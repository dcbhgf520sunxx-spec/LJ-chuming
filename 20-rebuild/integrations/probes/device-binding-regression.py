#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Deferred offline probe; run only after root opens the testing phase.

Extracts the actual notificationsBindByUser method, compiles it with in-memory
boundary stubs, and checks first bind, replacement, invalid input, and user scope.
No Spring boot, network, DB, provider credentials, or message sending is involved.
This does not prove controller integration or provider/device delivery.
"""
from pathlib import Path
import argparse
import re
import subprocess
import tempfile


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--run", action="store_true", help="Explicitly run the deferred offline probe")
    args = parser.parse_args()
    if not args.run:
        parser.error("Prepared only. Run with --run after testing is authorized.")
    root = Path(__file__).resolve().parents[2]
    source = root / "backend/modules/scim-system-core/src/main/java/com/hzchum/scim/system/core/service/impl/UserServiceImpl.java"
    text = source.read_text(encoding="utf-8")
    start = text.index("public Boolean notificationsBindByUser(")
    opening = text.index("{", start)
    depth = 1
    ending = opening + 1
    while depth:
        depth += (text[ending] == "{") - (text[ending] == "}")
        ending += 1
    method = text[start:ending]
    if len(re.findall(r"public Boolean notificationsBindByUser\(", text)) != 1:
        raise RuntimeError("Expected exactly one product binding method")
    harness = r'''
public final class DeviceBindingActualMethodProbe {
    static final class StringUtils {
        static boolean isNotBlank(String value) { return value != null && !value.trim().isEmpty(); }
    }
    static final class Preconditions {
        static void checkArgument(boolean condition, String message) {
            if (!condition) throw new IllegalArgumentException(message);
        }
    }
    static final class UserUtil {
        static Long getCurrentUserId() { return 42L; }
    }
    static final class User {
        String platform, registrationId;
        User(String platform, String registrationId) { this.platform=platform; this.registrationId=registrationId; }
        String getPlatform() { return platform; }
        String getRegistrationId() { return registrationId; }
        void setPlatform(String value) { platform=value; }
        void setRegistrationId(String value) { registrationId=value; }
    }
    static final class SysNotificationsBindByUserParam {
        final String platform, registrationId;
        SysNotificationsBindByUserParam(String platform, String registrationId) { this.platform=platform; this.registrationId=registrationId; }
        String getPlatform() { return platform; }
        String getRegistrationId() { return registrationId; }
    }
    User stored;
    int reads, updates;
    DeviceBindingActualMethodProbe(User stored) { this.stored=stored; }
    User getById(Long id) {
        require(Long.valueOf(42).equals(id), "must read only current user");
        reads++;
        return stored;
    }
    boolean updateById(User user) {
        require(user==stored, "must update the same current user");
        updates++;
        return true;
    }
    /* PRODUCT_METHOD */
    static void require(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
    static void valid(String oldPlatform, String oldRegistration) {
        DeviceBindingActualMethodProbe probe = new DeviceBindingActualMethodProbe(new User(oldPlatform, oldRegistration));
        require(Boolean.TRUE.equals(probe.notificationsBindByUser(new SysNotificationsBindByUserParam("android", "controlled-test-registration"))), "successful result");
        require("android".equals(probe.stored.platform), "must save incoming platform for first bind and replacement");
        require("controlled-test-registration".equals(probe.stored.registrationId), "must save incoming registration for first bind and replacement");
        require(probe.reads==1 && probe.updates==1, "single read/update for current user");
    }
    static void invalid(String platform, String registration) {
        DeviceBindingActualMethodProbe probe = new DeviceBindingActualMethodProbe(new User("existing-platform", "existing-registration"));
        try {
            probe.notificationsBindByUser(new SysNotificationsBindByUserParam(platform, registration));
            throw new AssertionError("blank request must be rejected");
        } catch (IllegalArgumentException expected) {
            require(probe.reads==0 && probe.updates==0, "reject invalid input before touching user");
            require("existing-platform".equals(probe.stored.platform) && "existing-registration".equals(probe.stored.registrationId), "invalid input must not clear existing binding");
        }
    }
    public static void main(String[] args) {
        valid(null, null);
        valid("", "");
        valid("existing-platform", "existing-registration");
        valid("existing-platform", null);
        valid(null, "existing-registration");
        invalid(null, "incoming");
        invalid("", "incoming");
        invalid("  ", "incoming");
        invalid("android", null);
        invalid("android", "");
        invalid("android", "  ");
        DeviceBindingActualMethodProbe missing = new DeviceBindingActualMethodProbe(null);
        try {
            missing.notificationsBindByUser(new SysNotificationsBindByUserParam("android", "incoming"));
            throw new AssertionError("missing current user must be rejected");
        } catch (IllegalArgumentException expected) {
            require(missing.reads==1 && missing.updates==0, "missing user must not update");
        }
        System.out.println("PASS: actual source method; first bind, replace, partial old state, blank rejection, current user scope");
    }
}
'''.replace("/* PRODUCT_METHOD */", method)
    with tempfile.TemporaryDirectory(prefix="ljaps-device-binding-") as temporary:
        java = Path(temporary) / "DeviceBindingActualMethodProbe.java"
        java.write_text(harness, encoding="utf-8")
        subprocess.run(["javac", "-encoding", "UTF-8", str(java)], check=True)
        subprocess.run(["java", "-cp", temporary, "DeviceBindingActualMethodProbe"], check=True)


if __name__ == "__main__":
    main()
