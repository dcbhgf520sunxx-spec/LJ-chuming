#!/usr/bin/env python3
"""Disposable real password-change verification, only against the isolated reconstruction database."""
import base64
import importlib.util
import json
from pathlib import Path
import secrets
import subprocess
from provision import mysql

ROOT=Path(__file__).resolve().parent
spec=importlib.util.spec_from_file_location("http_checks",ROOT/"check-runtime.py")
http=importlib.util.module_from_spec(spec);spec.loader.exec_module(http)


def main():
    fixture=dict(line.split("=",1) for line in (ROOT.parents[1]/"10-reverse/local/.env").read_text().splitlines() if "=" in line)
    public=http.call("/api/user/public-key")[1]["data"]["publicKey"]
    pem=ROOT/"runtime/password-check-public.pem";pem.write_text(public)
    def encrypted(value):
        return base64.b64encode(subprocess.run(["openssl","pkeyutl","-encrypt","-pubin","-inkey",str(pem),"-pkeyopt","rsa_padding_mode:pkcs1"],input=value.encode(),stdout=subprocess.PIPE,stderr=subprocess.PIPE,check=True).stdout).decode()
    def login(username,password):
        return http.call("/api/user/login","POST",{"username":username,"password":encrypted(password)})[1]
    owner=login(fixture["LOCAL_WEB_USERNAME"],fixture["LOCAL_WEB_PASSWORD"])
    assert owner["code"]==20000
    owner_id=int(http.call("/api/user/info",token=owner["data"]["token"])[1]["data"]["id"])
    assert mysql("SELECT COUNT(*) FROM plm7_rebuild.sys_user WHERE id=8900000000002 OR username='rebuildpwdcheck';")=="0"
    mysql("INSERT INTO plm7_rebuild.sys_user(id,name,username,password) SELECT 8900000000002,'独立改密验收','rebuildpwdcheck',password FROM plm7_rebuild.sys_user WHERE id="+str(owner_id)+";")
    result={"scope":"Dedicated temporary user in plm7_rebuild; source and real local accounts unchanged"}
    try:
        old=fixture["LOCAL_WEB_PASSWORD"];new="Rebuild!91_"+secrets.token_hex(8)
        before=login("rebuildpwdcheck",old);assert before["code"]==20000;token=before["data"]["token"]
        wrong=http.call("/api/user/updatePwd","POST",{"oldPwd":encrypted("wrong synthetic current password"),"newPwd":encrypted(new)},token)[1]
        assert wrong.get("code")!=20000 and wrong.get("message")=="更新失败，密码错误"
        assert http.call("/api/user/info",token=token)[1]["code"]==20000
        result["wrong_old_password_rejected_without_session_change"]=True
        changed=http.call("/api/user/updatePwd","POST",{"oldPwd":encrypted(old),"newPwd":encrypted(new)},token)[1]
        assert changed.get("code")==20000 and changed.get("data") is True, "Legacy business RSA password-change path failed"
        result["new_mounted_rsa_key_password_change"]=True
        assert http.rejected(http.call("/api/user/info",token=token)[1])
        assert http.rejected(http.call("/api/user/menu",token=token)[1])
        result["old_token_immediately_invalidated"]=True
        assert http.rejected(login("rebuildpwdcheck",old));result["old_password_rejected"]=True
        after=login("rebuildpwdcheck",new);assert after["code"]==20000
        assert http.call("/api/user/info",token=after["data"]["token"])[1]["code"]==20000
        result["new_password_login_and_current_identity"]=True
        assert mysql("SELECT last_password_reset_date IS NOT NULL FROM plm7_rebuild.sys_user WHERE id=8900000000002;")=="1"
        result["password_reset_date_persisted"]=True
        http.call("/api/user/logout","POST",{},after["data"]["token"])
    finally:
        mysql("DELETE FROM plm7_rebuild.sys_user WHERE id=8900000000002 AND username='rebuildpwdcheck';")
        result["fixture_cleanup"]=mysql("SELECT COUNT(*) FROM plm7_rebuild.sys_user WHERE id=8900000000002;")=="0"
        http.call("/api/user/logout","POST",{},owner["data"]["token"])
        (ROOT.parent/"docs/runtime-password-verification.json").write_text(json.dumps(result,ensure_ascii=False,indent=2)+"\n")
    print(json.dumps(result,ensure_ascii=False,indent=2))


if __name__=="__main__":main()
