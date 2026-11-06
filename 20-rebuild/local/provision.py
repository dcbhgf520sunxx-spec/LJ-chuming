#!/usr/bin/env python3
"""Clone the local reference database once; never import over the reference."""
from pathlib import Path
import re
import subprocess

ROOT = Path(__file__).resolve().parent
CONTAINER = "ljaps-local-mysql-1"


def mysql(sql):
    result = subprocess.run(["docker", "exec", "-i", CONTAINER, "sh", "-c",
        'MYSQL_PWD="$MYSQL_ROOT_PASSWORD" exec mysql -uroot -N -B'],
        input=sql.encode(), stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    if result.returncode:
        raise RuntimeError("Local database provisioning failed; credentials are withheld")
    return result.stdout.decode().strip()


def main():
    env = dict(line.split("=", 1) for line in (ROOT / ".env").read_text().splitlines() if "=" in line)
    database, user, password = (env[key] for key in ("LJAPS_DB_NAME", "LJAPS_DB_USER", "LJAPS_DB_PASSWORD"))
    if database != "plm7_rebuild" or not re.fullmatch(r"[a-z0-9_]+", user) or not re.fullmatch(r"[a-f0-9]{48}", password):
        raise ValueError("Unexpected local database configuration")
    count = int(mysql("SELECT COUNT(*) FROM information_schema.tables WHERE table_schema='plm7_rebuild' AND LEFT(table_name,8)<>'rebuild_';"))
    reference = int(mysql("SELECT COUNT(*) FROM information_schema.tables WHERE table_schema='plm7';"))
    if count not in (0, reference):
        raise RuntimeError("Rebuild database is partial; inspect it before any further import")
    mysql("CREATE DATABASE IF NOT EXISTS plm7_rebuild CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;"
        + "CREATE USER IF NOT EXISTS '" + user + "'@'%' IDENTIFIED BY '" + password + "';"
        + "GRANT ALL PRIVILEGES ON plm7_rebuild.* TO '" + user + "'@'%';")
    if count == 0:
        # No --databases flag: the dump contains no USE/CREATE DATABASE targeting plm7.
        dump = subprocess.Popen(["docker", "exec", CONTAINER, "sh", "-c",
            'MYSQL_PWD="$MYSQL_ROOT_PASSWORD" exec mysqldump -uroot --single-transaction --quick '
            '--routines --triggers --events --set-gtid-purged=OFF --column-statistics=0 --no-tablespaces plm7'],
            stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        restore = subprocess.run(["docker", "exec", "-i", CONTAINER, "sh", "-c",
            'MYSQL_PWD="$MYSQL_ROOT_PASSWORD" exec mysql -uroot plm7_rebuild'],
            stdin=dump.stdout, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        dump.stdout.close()
        dump.wait()
        if dump.returncode or restore.returncode:
            raise RuntimeError("Database copy failed; original database was not the import target")
    copied = int(mysql("SELECT COUNT(*) FROM information_schema.tables WHERE table_schema='plm7_rebuild' AND LEFT(table_name,8)<>'rebuild_';"))
    if copied != reference or copied == 0:
        raise RuntimeError("Database table coverage mismatch")
    mysql("USE plm7_rebuild;" + (ROOT / "schema.sql").read_text())
    print("Independent local database ready: " + str(copied) + " reference tables plus new session table; reference database preserved.")


if __name__ == "__main__":
    main()
