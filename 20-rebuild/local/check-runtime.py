#!/usr/bin/env python3
"""Real HTTP auth checks. Credentials/tokens are kept only in ignored runtime files."""
import base64
import hashlib
import hmac
import json
from pathlib import Path
import subprocess
import sys
import time
import urllib.error
import urllib.request
from provision import mysql

ROOT = Path(__file__).resolve().parent
PROJECT = ROOT.parents[1]
BASE = "http://127.0.0.1:3119"
HTTP = urllib.request.build_opener(urllib.request.ProxyHandler({}))


def call(path, method="GET", data=None, token=None):
    headers = {"Content-Type": "application/json"}
    if token:
        headers["Authorization"] = token
    request = urllib.request.Request(BASE + path, data=json.dumps(data).encode() if data is not None else None,
        headers=headers, method=method)
    try:
        response = HTTP.open(request, timeout=30)
    except urllib.error.HTTPError as error:
        response = error
    with response:
        return response.status, json.loads(response.read())


def rejected(value):
    return value.get("code") != 20000 and not (value.get("data") or {}).get("token")


def main():
    ROOT.joinpath("runtime").mkdir(exist_ok=True)
    if "--after-restart" in sys.argv:
        token = (ROOT / "runtime/revoked-token.txt").read_text()
        assert rejected(call("/api/user/info", token=token)[1]), "Exited session became valid after restart"
        print("Persistent logout verified after application restart.")
        return
    fixture = dict(line.split("=", 1) for line in (PROJECT / "10-reverse/local/.env").read_text().splitlines() if "=" in line)
    local = dict(line.split("=", 1) for line in (ROOT / ".env").read_text().splitlines() if "=" in line)
    results = {}
    assert call("/actuator/health")[1] == {"status": "UP"}
    results["database_health"] = True
    assert rejected(call("/api/user/info")[1])
    assert rejected(call("/api/user/menu")[1])
    results["anonymous_denied"] = True
    public = call("/api/user/public-key")[1]
    assert public["code"] == 20000 and "BEGIN PUBLIC KEY" in public["data"]["publicKey"]
    pubfile = ROOT / "runtime/http-public.pem"
    pubfile.write_text(public["data"]["publicKey"])

    def encrypted(password):
        return base64.b64encode(subprocess.run(["openssl", "pkeyutl", "-encrypt", "-pubin", "-inkey", str(pubfile),
            "-pkeyopt", "rsa_padding_mode:pkcs1"], input=password.encode(), stdout=subprocess.PIPE,
            stderr=subprocess.PIPE, check=True).stdout).decode()

    username = fixture["LOCAL_WEB_USERNAME"]
    assert rejected(call("/api/user/login", "POST", {"username": username, "password": encrypted("incorrect synthetic password")})[1])
    assert rejected(call("/api/user/login", "POST", {"username": username, "password": "not RSA ciphertext"})[1])
    results["wrong_password_and_malformed_rsa_denied"] = True
    login = call("/api/user/login", "POST", {"username": username, "password": encrypted(fixture["LOCAL_WEB_PASSWORD"])})[1]
    assert login["code"] == 20000 and login["data"].get("token")
    token = login["data"]["token"]
    results["rsa_login"] = True
    query_status, query_result=call("/api/mes/building/factory/page?probe[0]=1",token=token)
    assert query_status==200 and query_result.get("code")==20000, "Original bracket-style array query was rejected"
    results["real_bracket_array_query_accepted"]=True
    info, menu = call("/api/user/info", token=token)[1], call("/api/user/menu", token=token)[1]
    assert info["code"] == menu["code"] == 20000
    assert isinstance(info["data"], dict) and isinstance(menu["data"], list)
    assert "password" not in info["data"]
    results["user_info"] = {"fields": len(info["data"]), "password_excluded": True}
    results["menu"] = {"root_items": len(menu["data"])}
    original_menu = json.loads((PROJECT / "10-reverse/private/local-menu.json").read_text())["data"]
    assert menu["data"] == original_menu, "New menu tree differs from reference response"
    results["menu_equals_reference"] = True
    original_info = json.loads((PROJECT / "10-reverse/private/local-user_info.json").read_text())["data"]
    assert info["data"] == original_info, "New user information differs from reference response"
    results["user_info_equals_reference"] = True
    assert rejected(call("/api/user/info", token="Bearer " + token)[1])
    header, payload, signature = token.split(".")
    modified = ("A" if signature[0] != "A" else "B") + signature[1:]
    assert rejected(call("/api/user/info", token=header + "." + payload + "." + modified)[1])
    claims = json.loads(base64.urlsafe_b64decode(payload + "=" * (-len(payload) % 4)))
    claims["exp"] = int(time.time()) - 10
    encoded = base64.urlsafe_b64encode(json.dumps(claims, separators=(",", ":")).encode()).decode().rstrip("=")
    signed = header + "." + encoded
    digest = hmac.new(local["LJAPS_JWT_SECRET"].encode(), signed.encode(), hashlib.sha512).digest()
    expired = signed + "." + base64.urlsafe_b64encode(digest).decode().rstrip("=")
    assert rejected(call("/api/user/info", token=expired)[1])
    results["bearer_tampered_expired_tokens_denied"] = True
    # Dedicated synthetic row in the rebuild database; no roles or source records are changed.
    fixture_id = 8900000000000
    fixture_name = "rebuildcheck"
    existing = mysql("SELECT COUNT(*) FROM plm7_rebuild.sys_user WHERE id=8900000000000 OR username='rebuildcheck';")
    assert existing == "0", "Synthetic fixture identity already exists; inspect before changing it"
    source_user_id = int(info["data"]["id"])
    mysql("INSERT INTO plm7_rebuild.sys_user(id,name,username,password) SELECT 8900000000000,'重建验收用户','rebuildcheck',password FROM plm7_rebuild.sys_user WHERE id=" + str(source_user_id) + " LIMIT 1;")
    try:
        regular = call("/api/user/login", "POST", {"username": fixture_name, "password": encrypted(fixture["LOCAL_WEB_PASSWORD"])})[1]
        assert regular["code"] == 20000
        regular_token = regular["data"]["token"]
        assert call("/api/user/menu", token=regular_token)[1]["data"] == []
        regular_info = call("/api/user/info", token=regular_token)[1]["data"]
        assert regular_info["roles"] == [] and regular_info["permissions"] == []
        # These real controllers carry the original factory permission annotations.
        for method, path, body in [("GET", "/api/mes/building/factory/page", None),
                ("POST", "/api/mes/building/factory", {}),
                ("PUT", "/api/mes/building/factory", {}),
                ("DELETE", "/api/mes/building/factory", {"ids": []})]:
            denied=call(path,method,body,regular_token)[1]
            assert denied.get("code")!=20000 and denied.get("message")=="无权限访问", "No-role business request did not reach the permission guard"
        results["real_no_role_business_read_create_update_delete_denied"]=True
        mysql("UPDATE plm7_rebuild.sys_user SET is_enabled=0 WHERE id=8900000000000 AND username='rebuildcheck';")
        assert rejected(call("/api/user/info", token=regular_token)[1])
        mysql("UPDATE plm7_rebuild.sys_user SET is_enabled=1,last_password_reset_date=NOW(6) WHERE id=8900000000000 AND username='rebuildcheck';")
        assert rejected(call("/api/user/info", token=regular_token)[1])
        results["real_no_role_disabled_password_reset_checks"] = True
    finally:
        mysql("DELETE FROM plm7_rebuild.sys_user WHERE id=8900000000000 AND username='rebuildcheck';")
    assert call("/api/user/logout", "POST", {}, token)[1]["code"] == 20000
    assert rejected(call("/api/user/info", token=token)[1])
    assert rejected(call("/api/user/menu", token=token)[1])
    (ROOT / "runtime/revoked-token.txt").write_text(token)
    results["logout_revoked"] = True
    target = PROJECT / "20-rebuild/docs/runtime-auth-verification.json"
    target.write_text(json.dumps(results, ensure_ascii=False, indent=2) + "\n")
    print(json.dumps(results, ensure_ascii=False, indent=2))


if __name__ == "__main__":
    main()
