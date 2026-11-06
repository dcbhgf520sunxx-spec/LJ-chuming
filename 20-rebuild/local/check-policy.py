#!/usr/bin/env python3
"""Verify policy permissions and preserve-password editing; never return or print the stored plaintext."""
import base64
import importlib.util
import json
from pathlib import Path
import subprocess
from provision import mysql

ROOT=Path(__file__).resolve().parent
sp=importlib.util.spec_from_file_location("checks",ROOT/"check-runtime.py")
http=importlib.util.module_from_spec(sp);sp.loader.exec_module(http)


def main():
    fixture=dict(x.split("=",1) for x in (ROOT.parents[1]/"10-reverse/local/.env").read_text().splitlines() if "=" in x)
    pem=ROOT/"runtime/policy-check-public.pem";pem.write_text(http.call("/api/user/public-key")[1]["data"]["publicKey"])
    def encrypted(value):
        return base64.b64encode(subprocess.run(["openssl","pkeyutl","-encrypt","-pubin","-inkey",str(pem),"-pkeyopt","rsa_padding_mode:pkcs1"],input=value,stdout=subprocess.PIPE,stderr=subprocess.PIPE,check=True).stdout).decode()
    def login(username):
        value=http.call("/api/user/login","POST",{"username":username,"password":encrypted(fixture["LOCAL_WEB_PASSWORD"].encode())})[1]
        assert value["code"]==20000
        return value["data"]["token"]
    admin=login(fixture["LOCAL_WEB_USERNAME"]);owner=int(http.call("/api/user/info",token=admin)[1]["data"]["id"])
    row=mysql("SELECT id,HEX(value) FROM plm7_rebuild.sys_config WHERE code='PASSWORD_POLICY' AND bool_delete_enum=0;").split("\t")
    identity=int(row[0]);saved=row[1];policy=json.loads(bytes.fromhex(saved))
    database_metadata=mysql("SELECT COALESCE(HEX(CAST(update_time AS CHAR)),'NULL'),COALESCE(version,-1) FROM plm7_rebuild.sys_config WHERE id="+str(identity)+";").split("\t")
    checksum_sql="SELECT SHA2(CONCAT_WS('|',id,create_time,COALESCE(CAST(update_time AS CHAR),'NULL'),bool_delete_enum,COALESCE(version,-1),code,name,HEX(value)),256) FROM plm7_rebuild.sys_config WHERE id="+str(identity)+";"
    before_checksum=mysql(checksum_sql)
    private=ROOT/"runtime/rsa-private.pem"
    plain=subprocess.run(["openssl","pkeyutl","-decrypt","-inkey",str(private),"-pkeyopt","rsa_padding_mode:pkcs1","-pkeyopt","rsa_pkcs1_implicit_rejection:0"],input=base64.b64decode(policy["password"]),stdout=subprocess.PIPE,stderr=subprocess.PIPE,check=True).stdout
    backup=ROOT/"runtime/policy-check-before.json";backup.write_text(json.dumps({"id":identity,"value_hex":saved,"update_time_hex":database_metadata[0],"version":database_metadata[1],"row_checksum":before_checksum})+"\n");backup.chmod(0o600)
    for table in ("sys_user","sys_role","sys_user_role_link","sys_role_menu_link"):
        assert mysql("SELECT COUNT(*) FROM plm7_rebuild."+table+" WHERE id=8900000000003;")=="0"
    mysql("INSERT INTO plm7_rebuild.sys_user(id,name,username,password) SELECT 8900000000003,'策略权限验收','policycheck',password FROM plm7_rebuild.sys_user WHERE id="+str(owner)+";")
    result={"scope":"Temporary isolated user/role/link fixtures; original migrated policy restored exactly"}
    try:
        regular=login("policycheck")
        for path,method,data in [("/api/config/passwordPolicy/editable","GET",None),("/api/config/passwordPolicy/edit","POST",policy)]:
            value=http.call(path,method,data,regular)[1];assert value.get("code")!=20000 and value.get("message")=="无权限访问"
        result["no_role_read_and_edit_denied"]=True
        mysql("INSERT INTO plm7_rebuild.sys_role(id,name,permission) VALUES(8900000000003,'策略仅编辑验收','rebuild_policy_editor');INSERT INTO plm7_rebuild.sys_user_role_link(id,role_id,user_id) VALUES(8900000000003,8900000000003,8900000000003);INSERT INTO plm7_rebuild.sys_role_menu_link(id,role_id,menu_id) VALUES(8900000000003,8900000000003,8016173);")
        editor=login("policycheck")
        denied=http.call("/api/config/passwordPolicy/editable",token=editor)[1]
        assert denied.get("code")!=20000 and denied.get("message")=="无权限访问"
        result["edit_only_permission_cannot_read"]=True
        metadata=http.call("/api/config/passwordPolicy/editable",token=admin)[1]
        assert metadata["code"]==20000 and "password" not in metadata["data"]
        assert metadata["data"]["defaultPasswordConfigured"] is True and metadata["data"]["passwordEncoding"]=="preserved"
        for key,value in policy.items():
            if key!="password":assert metadata["data"].get(key)==value
        result["admin_reads_rules_without_password_or_private_key"]=True
        changed=dict(policy);changed["password"]=encrypted(plain)
        assert http.call("/api/config/passwordPolicy/edit","POST",changed,editor)[1]["code"]==20000
        value=http.call("/api/config/passwordPolicy/get",token=admin)[1]["data"]
        assert value==changed
        result["new_public_key_cipher_saved_with_original_rules"]=True
        retained=dict(changed);retained.pop("password")
        assert http.call("/api/config/passwordPolicy/edit","POST",retained,editor)[1]["code"]==20000
        assert http.call("/api/config/passwordPolicy/get",token=admin)[1]["data"]==changed
        retained["password"]=""
        assert http.call("/api/config/passwordPolicy/edit","POST",retained,editor)[1]["code"]==20000
        assert http.call("/api/config/passwordPolicy/get",token=admin)[1]["data"]==changed
        result["missing_and_empty_password_preserve_existing_cipher"]=True
        invalid=dict(retained);invalid["minLength"]=5
        assert http.call("/api/config/passwordPolicy/edit","POST",invalid,editor)[1].get("code")!=20000
        assert http.call("/api/config/passwordPolicy/get",token=admin)[1]["data"]==changed
        result["invalid_rules_rejected_without_mutation"]=True
    finally:
        stamp="NULL" if database_metadata[0]=="NULL" else "CONVERT(0x"+database_metadata[0]+" USING utf8mb4)"
        version="NULL" if int(database_metadata[1])==-1 else str(int(database_metadata[1]))
        mysql("UPDATE plm7_rebuild.sys_config SET value=CONVERT(0x"+saved+" USING utf8mb4),update_time="+stamp+",version="+version+" WHERE id="+str(identity)+";")
        mysql("DELETE FROM plm7_rebuild.sys_role_menu_link WHERE id=8900000000003 AND role_id=8900000000003;DELETE FROM plm7_rebuild.sys_user_role_link WHERE id=8900000000003 AND user_id=8900000000003;DELETE FROM plm7_rebuild.sys_role WHERE id=8900000000003 AND permission='rebuild_policy_editor';DELETE FROM plm7_rebuild.sys_user WHERE id=8900000000003 AND username='policycheck';")
        result["migrated_policy_restored_exactly"]=mysql(checksum_sql)==before_checksum
        result["fixture_cleanup"]=all(mysql("SELECT COUNT(*) FROM plm7_rebuild."+t+" WHERE id=8900000000003;")=="0" for t in ("sys_user","sys_role","sys_user_role_link","sys_role_menu_link"))
        http.call("/api/user/logout","POST",{},admin)
        (ROOT.parent/"docs/runtime-policy-verification.json").write_text(json.dumps(result,ensure_ascii=False,indent=2)+"\n")
    assert result["migrated_policy_restored_exactly"] and result["fixture_cleanup"]
    print(json.dumps(result,ensure_ascii=False,indent=2))


if __name__=="__main__":main()
