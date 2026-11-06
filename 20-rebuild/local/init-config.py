#!/usr/bin/env python3
"""Create local-only deployment secrets once; preserve existing credentials."""
from pathlib import Path
import os
import secrets
import subprocess

ROOT = Path(__file__).resolve().parent


def main():
    runtime = ROOT / "runtime"
    runtime.mkdir(parents=True, exist_ok=True)
    os.chmod(runtime, 0o700)
    env = ROOT / ".env"
    if not env.exists():
        env.write_text("LJAPS_DB_NAME=plm7_rebuild\nLJAPS_DB_USER=ljaps_rebuild\nLJAPS_DB_PASSWORD="
            + secrets.token_hex(24) + "\nLJAPS_JWT_SECRET=" + secrets.token_hex(32) + "\n")
    values = dict(line.split("=", 1) for line in env.read_text().splitlines() if "=" in line)
    if not values.get("LJAPS_INITIAL_USER_PASSWORD"):
        with env.open("a") as stream:
            stream.write("\nLJAPS_INITIAL_USER_PASSWORD=" + secrets.token_urlsafe(32) + "\n")
    os.chmod(env, 0o600)
    private = runtime / "rsa-private.pem"
    public = runtime / "rsa-public.pem"
    if not private.exists():
        subprocess.run(["openssl", "genpkey", "-algorithm", "RSA", "-pkeyopt", "rsa_keygen_bits:2048", "-out", str(private)],
            check=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    os.chmod(private, 0o600)
    if not public.exists():
        subprocess.run(["openssl", "pkey", "-in", str(private), "-pubout", "-out", str(public)],
            check=True, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    print("Private local configuration is ready; existing credentials were preserved.")


if __name__ == "__main__":
    main()
