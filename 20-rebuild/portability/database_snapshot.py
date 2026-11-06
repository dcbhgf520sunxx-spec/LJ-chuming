#!/usr/bin/env python3
"""Export the rebuild database and verify it in an isolated, disposable MySQL.

No published ports, external network, source-server access, or imports into an
existing database. Sensitive SQL and Docker credentials stay in private runtime.
"""
from datetime import datetime, timezone
import gzip
import hashlib
import json
import os
from pathlib import Path
import re
import secrets
import subprocess
import time

ROOT = Path(__file__).resolve().parent
PROJECT = ROOT.parent.parent
SOURCE_CONTAINER = 'ljaps-local-mysql-1'
DATABASE = 'plm7_rebuild'
IMAGE = 'mysql:8.2'


def validate_database(value):
    if value != DATABASE:
        raise ValueError('Only the independent rebuild database can be exported')
    return value


def owned_name(value):
    return bool(re.fullmatch(r'ljaps-restore-check-[0-9a-f]{12}', value))


def digest(path):
    value = hashlib.sha256()
    with Path(path).open('rb') as handle:
        for block in iter(lambda: handle.read(1024 * 1024), b''):
            value.update(block)
    return value.hexdigest()


def verify_digest(path, expected):
    if digest(path) != expected:
        raise ValueError('Database snapshot digest mismatch; restore aborted')


def run(args, input_bytes=None, timeout=180):
    result = subprocess.run(args, input=input_bytes, stdout=subprocess.PIPE,
                            stderr=subprocess.PIPE, timeout=timeout)
    if result.returncode:
        # Docker and MySQL stderr can include configuration; do not echo it.
        raise RuntimeError('Local database verification command failed; raw details withheld')
    return result.stdout.decode()


def mysql(container, sql):
    return run(['docker', 'exec', '-i', container, 'sh', '-c',
                'MYSQL_PWD="$MYSQL_ROOT_PASSWORD" exec mysql --protocol=TCP -h127.0.0.1 -uroot -N -B'], sql.encode())


def parse_inventory(text):
    result = {}
    for line in text.splitlines():
        name, rows, checksum = line.split('\t')
        if checksum == 'NULL':
            raise ValueError('A table checksum was unavailable; coverage is not verified')
        if name in result or not re.fullmatch(r'[A-Za-z0-9_]+', name):
            raise ValueError('Unexpected table identity')
        result[name] = {'rows': int(rows), 'checksum': checksum}
    return result


def inventory(container):
    tables = mysql(container, "SELECT table_name FROM information_schema.tables WHERE table_schema='plm7_rebuild' AND table_type='BASE TABLE' ORDER BY table_name;").splitlines()
    if not tables or any(not re.fullmatch(r'[A-Za-z0-9_]+', table) for table in tables):
        raise RuntimeError('Expected rebuild tables were not found')
    queries = ''.join("SELECT '" + table + "',COUNT(*) FROM plm7_rebuild.`" + table + "`;" for table in tables)
    counts = dict(line.split('\t') for line in mysql(container, queries).splitlines())
    checks = mysql(container, 'CHECKSUM TABLE ' + ','.join('plm7_rebuild.`' + table + '`' for table in tables) + ' EXTENDED;')
    checksums = dict((line.split('\t')[0].split('.', 1)[1], line.split('\t')[1]) for line in checks.splitlines())
    return parse_inventory('\n'.join(table + '\t' + counts[table] + '\t' + checksums[table] for table in tables))


def schema_inventory(container):
    sql = "SELECT table_name,column_name,ordinal_position,column_type,is_nullable,IFNULL(column_default,'<NULL>'),extra,IFNULL(collation_name,'') FROM information_schema.columns WHERE table_schema='plm7_rebuild' ORDER BY table_name,ordinal_position;"
    return hashlib.sha256(mysql(container, sql).encode()).hexdigest()


def export_snapshot(folder):
    path = folder / 'plm7-rebuild.sql.gz'
    with path.open('xb') as output:
        os.chmod(path, 0o600)
        with gzip.GzipFile(fileobj=output, mode='wb', mtime=0) as compressed:
            process = subprocess.Popen(['docker', 'exec', SOURCE_CONTAINER, 'sh', '-c',
                'MYSQL_PWD="$MYSQL_ROOT_PASSWORD" exec mysqldump -uroot --single-transaction --quick '
                '--routines --triggers --events --set-gtid-purged=OFF --column-statistics=0 --no-tablespaces plm7_rebuild'],
                stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            try:
                for block in iter(lambda: process.stdout.read(1024 * 1024), b''):
                    compressed.write(block)
                process.stdout.close()
                process.wait(timeout=180)
                if process.returncode:
                    raise RuntimeError('Snapshot export failed; no restore was attempted')
            finally:
                if process.poll() is None:
                    process.kill()
                    process.wait()
    return path


def restore(container, snapshot, expected):
    verify_digest(snapshot, expected)
    mysql(container, 'CREATE DATABASE plm7_rebuild CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;')
    process = subprocess.Popen(['docker', 'exec', '-i', container, 'sh', '-c',
        'MYSQL_PWD="$MYSQL_ROOT_PASSWORD" exec mysql -uroot plm7_rebuild'],
        stdin=subprocess.PIPE, stdout=subprocess.DEVNULL, stderr=subprocess.PIPE)
    try:
        with gzip.open(snapshot, 'rb') as source:
            for block in iter(lambda: source.read(1024 * 1024), b''):
                process.stdin.write(block)
        process.stdin.close()
        process.wait(timeout=180)
        if process.returncode:
            raise RuntimeError('Snapshot restore failed in disposable container')
    finally:
        if process.poll() is None:
            process.kill()
            process.wait()


def main():
    validate_database(DATABASE)
    tag = secrets.token_hex(6)
    container = 'ljaps-restore-check-' + tag
    volume = container
    if not owned_name(container):
        raise RuntimeError('Unexpected disposable container name')
    runtime = ROOT / 'runtime'
    runtime.mkdir(exist_ok=True, mode=0o700)
    os.chmod(runtime, 0o700)
    folder = runtime / (datetime.now().strftime('%Y%m%d-%H%M%S-') + tag)
    folder.mkdir(mode=0o700)
    credential = folder / 'mysql.env'
    credential.write_text('MYSQL_ROOT_PASSWORD=' + secrets.token_hex(32) + '\n')
    os.chmod(credential, 0o600)
    report = {'verified_at_utc': datetime.now(timezone.utc).isoformat(),
              'source_database': DATABASE, 'image': IMAGE,
              'source_server_accessed': False, 'reference_database_modified': False,
              'published_ports': [], 'network': 'none', 'verified': False}
    try:
        before = inventory(SOURCE_CONTAINER)
        schema = schema_inventory(SOURCE_CONTAINER)
        snapshot = export_snapshot(folder)
        after = inventory(SOURCE_CONTAINER)
        if before != after or schema != schema_inventory(SOURCE_CONTAINER):
            raise RuntimeError('Rebuild database changed during export; rerun for a stable verification snapshot')
        expected = digest(snapshot)
        run(['docker', 'run', '--detach', '--name', container, '--network', 'none',
             '--memory', '768m', '--env-file', str(credential),
             '--mount', 'type=volume,src=' + volume + ',dst=/var/lib/mysql', IMAGE])
        for attempt in range(60):
            try:
                if mysql(container, 'SELECT 1;').strip() == '1':
                    break
            except RuntimeError:
                pass
            time.sleep(1)
        else:
            raise RuntimeError('Disposable MySQL did not become ready')
        restore(container, snapshot, expected)
        restored = inventory(container)
        if before != restored or schema != schema_inventory(container):
            raise RuntimeError('Restored tables, row counts, checksums, or column definitions differ')
        report.update({'verified': True, 'snapshot_relative_path': str(snapshot.relative_to(PROJECT)),
                       'snapshot_sha256': expected, 'compressed_bytes': snapshot.stat().st_size,
                       'tables': len(restored), 'total_rows': sum(table['rows'] for table in restored.values()),
                       'column_definition_sha256': schema, 'all_row_counts_and_mysql_checksums_match': True,
                       'limits': ['MySQL CHECKSUM TABLE is a restoration check, not a cryptographic hash of every row',
                                  'Application startup in an independent deployment is a separate acceptance item']})
        (folder / 'table-inventory.json').write_text(json.dumps(restored, ensure_ascii=False, indent=2) + '\n')
        os.chmod(folder / 'table-inventory.json', 0o600)
    finally:
        # Only UUID-scoped resources created by this invocation are removable.
        if owned_name(container):
            subprocess.run(['docker', 'rm', '--force', container], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
            subprocess.run(['docker', 'volume', 'rm', volume], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
        credential.unlink(missing_ok=True)
        report_path = folder / 'verification.json'
        report_path.write_text(json.dumps(report, ensure_ascii=False, indent=2) + '\n')
        os.chmod(report_path, 0o600)
    if report['verified']:
        (PROJECT / '20-rebuild/docs/database-portability-verification.json').write_text(json.dumps(report, ensure_ascii=False, indent=2) + '\n')
        print(json.dumps({key: report[key] for key in ('verified', 'tables', 'total_rows', 'compressed_bytes', 'network')}, ensure_ascii=False))


if __name__ == '__main__':
    main()
