#!/usr/bin/env python3
"""Prepare and prove a private self-contained deployment; verification publishes no ports."""
import argparse
import base64
from datetime import datetime, timezone
import gzip
import hashlib
import io
import importlib.util
import json
import os
from pathlib import Path
import re
import secrets
import shutil
import subprocess
import tempfile
import urllib.request
import urllib.parse
import zipfile
import xml.etree.ElementTree as ET

ROOT = Path(__file__).resolve().parent
REBUILD = ROOT.parent
IMAGES = ['mysql:8.2', 'redis:alpine', 'eclipse-temurin:8-jdk', 'nginx:alpine']
REPRESENTATIVE = ['/api/mes/building/factory/page?pageNumber=1&pageSize=10',
    '/api/mes/building/workshop/page?pageNumber=1&pageSize=10',
    '/api/mes/building/productionLine/page?pageNumber=1&pageSize=10',
    '/api/scm/supplier/all/brief', '/api/job/all', '/api/dictDetail/all?name=enclosure_type',
    '/api/user/all/simple', '/api/project/selectAllProjectInfo']
TEMPLATES = ['/api/scm/supplier/template/export', '/api/user/template/export',
    '/api/plan/standardPart/download-template', '/api/plan/enclosureStandardPart/download-template',
    '/api/mes/building/craft/paint-config/template-download']


def require(value, message):
    if not value:
        raise RuntimeError(message)


def digest(path):
    value = hashlib.sha256()
    with Path(path).open('rb') as source:
        for block in iter(lambda: source.read(1024 * 1024), b''):
            value.update(block)
    return value.hexdigest()


def run(args, data=None, timeout=180):
    value = subprocess.run(args, input=data, stdout=subprocess.PIPE, stderr=subprocess.PIPE, timeout=timeout)
    require(value.returncode == 0, 'Deployment command failed; private command output withheld')
    return value.stdout


def env_read(path):
    return dict(line.split('=', 1) for line in Path(path).read_text().splitlines() if '=' in line and not line.startswith('#'))


def private_json(path, value):
    path.write_text(json.dumps(value, ensure_ascii=False, indent=2) + '\n')
    path.chmod(0o600)


def fingerprint(directory):
    value = hashlib.sha256()
    for path in sorted(directory.rglob('*.java')):
        value.update(str(path.relative_to(directory)).encode()); value.update(b'\0'); value.update(path.read_bytes())
    return value.hexdigest()


def frontend_verifier():
    spec = importlib.util.spec_from_file_location('standalone_frontend_activation', REBUILD / 'local/activate-frontend.py')
    module = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(module)
    return module


def validate_frontend(front, stage=False):
    report = json.loads((front / 'source-build-verification.json').read_text())
    require(report.get('original_vendor_used') is False and report.get('request_metadata_invariant') is True,
        'A verified recovered-source frontend request contract is required')
    verifier = frontend_verifier()
    if not stage:
        verifier.verify_source_inputs(front, report)
    require(report.get('dist_files'), 'Full frontend artifact hashes are required')
    verifier.verify_files(front / 'dist', report['dist_files'])
    require(report['index_sha256'] == digest(verifier.checked_path(front / 'dist', 'index.html')), 'Frontend entry differs from the verified build')
    return report


def validate_build(stage=False, config=None):
    backend = REBUILD / 'backend'
    report = json.loads(((ROOT / 'runtime/stage-build-report.json') if stage else (backend / 'target/build-report.json')).read_text())
    artifacts = (config / 'runtime/app') if stage else (backend / 'target/runtime')
    auth_verified = (report.get('auth_synthetic_checks') in (18, 21) if stage else
        report.get('auth_synthetic_checks') == 21 and report.get('health_readiness_checks') == 3)
    require(report.get('original_business_jars_on_classpath') == 0 and report.get('parity_cases_passed') == 9
        and auth_verified and report.get('business_permission_checks') == 7
        and report.get('numeric_menu_permission_checks') == 8, 'A verified complete source build is required')
    require(stage or (report.get('outsourcing_submission_checks') == 4
        and report.get('outsourcing_batch_submission_checks') == 4
        and report.get('outbound_revocation_checks') == 10), 'Current outbound submission and revocation build gates are required')
    require([item['module'] for item in report['modules']] == json.loads((backend / 'source-modules.json').read_text()), 'Source module coverage mismatch')
    build_spec = importlib.util.spec_from_file_location('standalone_source_build', backend / 'tools/build.py')
    source_build = importlib.util.module_from_spec(build_spec); build_spec.loader.exec_module(source_build)
    require(stage or report.get('resource_coverage') == source_build.validate_resources(), 'Packaged resource source differs from the verified build')
    for item in report['modules']:
        require(stage or item['source_tree_sha256'] == fingerprint(backend / 'modules' / item['module'] / 'src/main/java'), 'Business source changed after build')
        require(digest(artifacts / 'modules' / (item['module'] + '.jar')) == item['jar_sha256'], 'New module artifact hash mismatch')
    require(stage or fingerprint(backend / 'app/src/main/java') == report['application']['source_tree_sha256'], 'Application source changed after build')
    require(digest(artifacts / 'app.jar') == report['application']['jar_sha256'], 'New application artifact hash mismatch')
    lock = {item['file']: item['sha256'] for item in json.loads((backend / 'thirdparty-lock.json').read_text())}
    selected = json.loads((backend / 'runtime-artifacts.json').read_text())['files']
    require(set(path.name for path in (artifacts / 'lib').iterdir()) == set(selected), 'Unexpected runtime dependency')
    for name in selected:
        path = artifacts / 'lib' / name
        require(name in lock and digest(path) == lock[name] and not name.startswith(('scim-', 'pangu-')), 'Unapproved dependency binary')
        with zipfile.ZipFile(path) as archive:
            require(not any(name.startswith('com/hzchum/') and name.endswith('.class') for name in archive.namelist()), 'Original business bytecode is forbidden in dependencies')
    front = REBUILD / 'frontend-recovered'
    front_report = validate_frontend(front, stage)
    return report, front_report


def auth_baseline(bundle, fixture):
    http = urllib.request.build_opener(urllib.request.ProxyHandler({}))
    def call(path, data=None, token=None):
        headers = {'Content-Type': 'application/json'}
        if token: headers['Authorization'] = token
        req = urllib.request.Request('http://127.0.0.1:3119' + path, data=json.dumps(data).encode() if data is not None else None, headers=headers)
        with http.open(req, timeout=30) as result:
            value = json.loads(result.read())
            require(value.get('code') == 20000, 'Current new application baseline capture failed')
            return value['data']
    encrypted = run(['openssl', 'pkeyutl', '-encrypt', '-pubin', '-inkey', str(bundle / 'rsa-public.pem'), '-pkeyopt', 'rsa_padding_mode:pkcs1'], fixture['LOCAL_WEB_PASSWORD'].encode())
    token = call('/api/user/login', {'username': fixture['LOCAL_WEB_USERNAME'], 'password': base64.b64encode(encrypted).decode()})['token']
    try:
        return {path: call(path, token=token) for path in ['/api/user/info', '/api/user/menu']}
    finally:
        call('/api/user/logout', {}, token)


def prepare(args):
    config = args.config_dir.resolve()
    backend, frontend = validate_build(args.stage, config)
    snapshot = args.snapshot.resolve()
    verification = json.loads(snapshot.with_name('verification.json').read_text())
    require(verification.get('verified') is True and verification.get('source_database') == 'plm7_rebuild'
        and digest(snapshot) == verification['snapshot_sha256'], 'Snapshot must have a matching successful isolated restore verification')
    with gzip.open(snapshot, 'rt', errors='strict') as source:
        for line in source:
            require(not re.match(r'^\s*(?:CREATE\s+DATABASE|USE\s+|GRANT\s+|CREATE\s+USER)', line, re.I), 'Snapshot contains a database/account switching directive')
    runtime = ROOT / 'runtime'; runtime.mkdir(exist_ok=True, mode=0o700); runtime.chmod(0o700)
    bundle = runtime / ('bundle-' + datetime.now().strftime('%Y%m%d-%H%M%S-') + secrets.token_hex(3))
    bundle.mkdir(mode=0o700)
    config = args.config_dir.resolve()
    values = env_read(config / '.env')
    require(values.get('LJAPS_DB_NAME') == 'plm7_rebuild', 'Only new application configuration can be packaged')
    manifest = {'prepared_at': datetime.now(timezone.utc).isoformat(), 'original_business_jars': 0,
        'backend_modules': len(backend['modules']), 'frontend_source_modules': frontend['source_modules'],
        'snapshot_tables': verification['tables'], 'source_snapshot_sha256': verification['snapshot_sha256'],
        'stage_runtime_only': args.stage, 'current_source_fingerprints_verified': not args.stage,
        'runtime_reads_original_or_reference_paths': False, 'image_archives_included': True}
    shutil.copytree((config / 'runtime/app') if args.stage else (REBUILD / 'backend/target/runtime'), bundle / 'app')
    require(digest(bundle / 'app/app.jar') == backend['application']['jar_sha256'], 'Application artifact changed during packaging')
    for item in backend['modules']:
        require(digest(bundle / 'app/modules' / (item['module'] + '.jar')) == item['jar_sha256'], 'Business module changed during packaging')
    shutil.copytree(REBUILD / 'frontend-recovered/dist', bundle / 'web')
    frontend_verifier().verify_files(bundle / 'web', frontend['dist_files'])
    require(digest(bundle / 'web/index.html') == frontend['index_sha256'], 'Frontend artifact changed during packaging')
    for name in ['rsa-private.pem', 'rsa-public.pem']:
        shutil.copy2(config / 'runtime' / name, bundle / name); (bundle / name).chmod(0o600)
    shutil.copy2(config / 'business.properties', bundle / 'business.properties'); (bundle / 'business.properties').chmod(0o600)
    copied_files = 0
    files = bundle / 'files'; files.mkdir(mode=0o700)
    for path in sorted((config / 'runtime/files').rglob('*')):
        require(not path.is_symlink(), 'Attachment symlinks require inspection before packaging')
        relative = path.relative_to(config / 'runtime/files')
        if path.is_dir(): (files / relative).mkdir(exist_ok=True)
        elif path.is_file():
            require(path.suffix.lower() not in ('.key', '.pfx', '.p12') and path.name != 'privkey.pem', 'TLS/private-key attachment is excluded from the migration package')
            shutil.copy2(path, files / relative); copied_files += 1
    require(copied_files > 0, 'Expected local attachments were not found')
    manifest['attachment_files'] = copied_files
    section_images = files / 'MemberSectionImg'
    section_images.mkdir(exist_ok=True)
    for image in (ROOT / 'assets/MemberSectionImg').glob('*.jpg'):
        destination = section_images / image.name
        if not destination.exists():
            shutil.copy2(image, destination)
    shutil.copy2(snapshot, bundle / 'database.sql.gz')
    shutil.copy2(snapshot.with_name('table-inventory.json'), bundle / 'database-inventory.json')
    shutil.copy2(snapshot.with_name('verification.json'), bundle / 'database-verification.json')
    credential = {'LJAPS_DB_NAME': 'plm7_rebuild', 'LJAPS_DB_USER': 'ljaps_standalone',
        'LJAPS_DB_PASSWORD': secrets.token_hex(24), 'LJAPS_MYSQL_ROOT_PASSWORD': secrets.token_hex(32),
        'LJAPS_JWT_SECRET': values['LJAPS_JWT_SECRET'],
        'LJAPS_INITIAL_USER_PASSWORD': values.get('LJAPS_INITIAL_USER_PASSWORD') or secrets.token_urlsafe(32),
        'LJAPS_BUNDLE': './' + str(bundle.relative_to(ROOT)),
        'LJAPS_EVIDENCE': './' + str(bundle.relative_to(ROOT)) + '/evidence',
        'LJAPS_STANDALONE_PROJECT': 'ljaps-standalone-' + secrets.token_hex(6)}
    (bundle / '.env').write_text(''.join(key + '=' + value + '\n' for key, value in credential.items())); (bundle / '.env').chmod(0o600)
    (bundle / 'evidence').mkdir(mode=0o700)
    fixture = env_read(args.fixture_env.resolve())
    expected = json.loads((REBUILD / 'acceptance/runtime/rebuilt-responses.json').read_text())
    attachment = next(path for path in sorted(files.rglob('*')) if path.is_file() and path.stat().st_size > 0)
    der = run(['openssl', 'pkey', '-pubin', '-in', str(bundle / 'rsa-public.pem'), '-outform', 'DER'])
    comparison = {case['path']: case['comparison'] for case in json.loads((REBUILD / 'acceptance/read-contract-cases.json').read_text())['cases'] if case.get('comparison')}
    probe = {'comparison': comparison, 'username': fixture['LOCAL_WEB_USERNAME'], 'password': fixture['LOCAL_WEB_PASSWORD'],
        'frontend_index_sha256': digest(bundle / 'web/index.html'), 'rsa_public_der_sha256': hashlib.sha256(der).hexdigest(),
        'auth_expected': auth_baseline(bundle, fixture), 'business_expected': {path: result for path, result in expected.items() if result[0] == 200 and isinstance(result[1], dict) and result[1].get('code') == 20000},
        'attachment_path': '/files/' + urllib.parse.quote(str(attachment.relative_to(files)), safe='/'),
        'attachment_sha256': digest(attachment), 'templates': TEMPLATES}
    private_json(bundle / 'verification-input.json', probe)
    (bundle / 'template-baselines').mkdir(mode=0o700)
    for index in range(len(TEMPLATES)):
        shutil.copy2(REBUILD / 'acceptance/runtime' / ('template-' + str(index) + '-rebuilt.xlsx'), bundle / 'template-baselines' / (str(index) + '.xlsx'))
    manifest['images'] = {}
    for image in IMAGES:
        details = json.loads(run(['docker', 'image', 'inspect', image]))[0]
        manifest['images'][image] = {key: details[key] for key in ['Id', 'Os', 'Architecture']}
    run(['docker', 'image', 'save', '-o', str(bundle / 'images.tar'), *IMAGES], timeout=600)
    manifest['files'] = {str(path.relative_to(bundle)): digest(path) for path in sorted(bundle.rglob('*')) if path.is_file()}
    private_json(bundle / 'manifest.json', manifest)
    for path in bundle.rglob('*'):
        if path.is_file(): path.chmod(0o644 if (bundle / 'web') in path.parents else 0o600)
        elif path.is_dir() and (path == bundle / 'web' or (bundle / 'web') in path.parents): path.chmod(0o755)
    private_json(runtime / 'latest-bundle.json', {'bundle': str(bundle.relative_to(ROOT))})
    print(json.dumps({'prepared': True, 'bundle': str(bundle), 'backend_modules': manifest['backend_modules'], 'attachment_files': copied_files, 'snapshot_tables': manifest['snapshot_tables'], 'stage_runtime_only': args.stage}))


def packaged_bundle(value):
    bundle = value.resolve()
    require(bundle.parent == (ROOT / 'runtime').resolve() and re.fullmatch(r'bundle-[0-9]{8}-[0-9]{6}-[a-f0-9]{6}', bundle.name), 'Use a prepared bundle under standalone/runtime')
    manifest = json.loads((bundle / 'manifest.json').read_text())
    for name, expected in manifest['files'].items():
        path = bundle / name
        require(not Path(name).is_absolute() and '..' not in Path(name).parts and not path.is_symlink()
            and path.is_file() and bundle in path.resolve().parents and digest(path) == expected, 'Prepared package hash mismatch')
    expected_web = {name[len('web/'):] for name in manifest['files'] if name.startswith('web/')}
    actual_web = {str(path.relative_to(bundle / 'web')) for path in (bundle / 'web').rglob('*') if path.is_file()}
    require(expected_web == actual_web, 'Prepared frontend artifact inventory changed')
    return bundle, manifest


def ensure_images(bundle, manifest):
    expected = manifest.get('images')
    require(isinstance(expected, dict) and set(expected) == set(IMAGES), 'Image identities are missing from package')
    needs_load = False
    for image in IMAGES:
        checked = subprocess.run(['docker', 'image', 'inspect', image], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        if checked.returncode or json.loads(checked.stdout)[0]['Id'] != expected[image]['Id']:
            needs_load = True
    if needs_load:
        run(['docker', 'image', 'load', '-i', str(bundle / 'images.tar')], timeout=600)
    for image in IMAGES:
        actual = json.loads(run(['docker', 'image', 'inspect', image]))[0]
        require(all(actual[key] == expected[image][key] for key in ['Id', 'Os', 'Architecture']), 'Offline runtime image differs from prepared identity')


def compose_env(bundle, project, evidence):
    result = os.environ.copy(); result.update(env_read(bundle / '.env'))
    result.update(LJAPS_BUNDLE=str(bundle), LJAPS_EVIDENCE=str(evidence), LJAPS_STANDALONE_PROJECT=project, COMPOSE_PROJECT_NAME=project, COMPOSE_PROFILES='')
    return result


def compose(bundle, project, evidence, *args, timeout=180, profile='verification'):
    value = subprocess.run(['docker', 'compose', '--env-file', str(bundle / '.env'), '-f', str(ROOT / 'compose.json'), '-p', project, '--profile', profile, *args],
        env=compose_env(bundle, project, evidence), cwd=ROOT, stdout=subprocess.PIPE, stderr=subprocess.PIPE, timeout=timeout)
    require(value.returncode == 0, 'Independent compose operation failed; see private evidence logs')
    return value.stdout


def mysql(container, sql, raw=False):
    value = run(['docker', 'exec', '-i', container, 'sh', '-c', 'MYSQL_PWD="$MYSQL_ROOT_PASSWORD" exec mysql --protocol=TCP -h127.0.0.1 -uroot -N -B'], sql.encode()).decode()
    return value if raw else value.strip()


def inventory(container):
    tables = mysql(container, "SELECT table_name FROM information_schema.tables WHERE table_schema='plm7_rebuild' AND table_type='BASE TABLE' ORDER BY table_name;").splitlines()
    require(tables and all(re.fullmatch(r'[A-Za-z0-9_]+', name) for name in tables), 'Unexpected standalone table inventory')
    counts = dict(line.split('\t') for line in mysql(container, ''.join("SELECT '" + name + "',COUNT(*) FROM plm7_rebuild.`" + name + "`;" for name in tables)).splitlines())
    checks = dict((line.split('\t')[0].split('.', 1)[1], line.split('\t')[1]) for line in mysql(container, 'CHECKSUM TABLE ' + ','.join('plm7_rebuild.`' + name + '`' for name in tables) + ' EXTENDED;').splitlines())
    return {name: {'rows': int(counts[name]), 'checksum': checks[name]} for name in tables}


def xlsx_equal(left, right, generated=False):
    with zipfile.ZipFile(left) as a, zipfile.ZipFile(right) as b:
        require(a.testzip() is None and b.testzip() is None, 'Workbook CRC failed')
        require('[Content_Types].xml' in a.namelist() and 'xl/workbook.xml' in a.namelist(), 'Expected XLSX workbook')
        if sorted(a.namelist()) != sorted(b.namelist()): return False
        for name in a.namelist():
            first, second = a.read(name), b.read(name)
            if generated and name == 'docProps/core.xml':
                nodes = [ET.fromstring(value) for value in (first, second)]
                for node in nodes:
                    created = node.find('{http://purl.org/dc/terms/}created')
                    require(created is not None, 'Generated workbook timestamp missing'); created.text = '<request time>'
                first, second = (ET.tostring(node) for node in nodes)
            if first != second: return False
    return True


def bind_inside_standalone(source):
    # Docker Desktop exposes amd64-emulated bind sources through this exact host alias.
    candidate = str(source)
    if candidate.startswith('/host_mnt/'):
        candidate = candidate[len('/host_mnt'):]
    try:
        Path(candidate).resolve().relative_to(ROOT.resolve())
        return True
    except ValueError:
        return False


def isolated_services(bundle, project, evidence, expected):
    ids = compose(bundle, project, evidence, 'ps', '-q').decode().splitlines()
    details = json.loads(run(['docker', 'inspect', *ids]))
    require({item['Config']['Labels'].get('com.docker.compose.service') for item in details} == set(expected), 'Independent service inventory mismatch')
    network_name = project + '_isolated'
    for item in details:
        require(item['Config']['Labels'].get('com.docker.compose.project') == project, 'Independent project ownership mismatch')
        require(set(item['NetworkSettings']['Networks']) == {network_name}, 'Independent container connected to an unexpected network')
        require(not item['HostConfig'].get('PortBindings'), 'Verification must publish no host ports')
        require(all(bind_inside_standalone(mount['Source']) for mount in item.get('Mounts', []) if mount.get('Type') == 'bind'), 'Container bind mount escapes the standalone package')
    network = json.loads(run(['docker', 'network', 'inspect', network_name]))[0]
    require(network['Internal'] is True and set(network['Containers']) == set(ids), 'Network must be internal and exclusively owned')
    return details


def verify(args):
    bundle, manifest = packaged_bundle(args.bundle)
    project = 'ljaps-standalone-check-' + secrets.token_hex(6)
    require(re.fullmatch(r'ljaps-standalone-check-[a-f0-9]{12}', project) is not None, 'Only fresh owned verification project names are allowed')
    evidence = ROOT / 'runtime' / ('check-' + project.rsplit('-', 1)[1]); evidence.mkdir(mode=0o700)
    report = {'verified_at': datetime.now(timezone.utc).isoformat(), 'project': project, 'published_ports': [], 'external_network': False, 'reference_containers_connected': False, 'passed': False, 'bundle': str(bundle.relative_to(ROOT)),
        'app_sha256': manifest['files']['app/app.jar'], 'business_properties_sha256': manifest['files']['business.properties'], 'frontend_index_sha256': manifest['files']['web/index.html'], 'stage_runtime_only': manifest.get('stage_runtime_only', False)}
    try:
        require(not run(['docker', 'ps', '-aq', '--filter', 'label=com.docker.compose.project=' + project]).strip(), 'Refusing to reuse an existing container project')
        require(not run(['docker', 'volume', 'ls', '-q', '--filter', 'label=com.docker.compose.project=' + project]).strip(), 'Refusing to reuse an existing database volume')
        ensure_images(bundle, manifest)
        shutil.copy2(ROOT / 'StandaloneProbe.java', evidence / 'StandaloneProbe.java')
        shutil.copy2(ROOT / 'ContainerHttp.java', evidence / 'ContainerHttp.java')
        deployment = env_read(bundle / '.env'); deployment.update(LJAPS_BUNDLE=str(bundle), LJAPS_EVIDENCE=str(evidence), LJAPS_STANDALONE_PROJECT=project)
        if not deployment.get('LJAPS_INITIAL_USER_PASSWORD'):
            deployment['LJAPS_INITIAL_USER_PASSWORD'] = secrets.token_urlsafe(32)
        (evidence / 'deployment.env').write_text(''.join(key + '=' + value + '\n' for key, value in deployment.items())); (evidence / 'deployment.env').chmod(0o600)
        # Prove byte-level data recovery before application initializers legitimately update data.
        compose(bundle, project, evidence, 'up', '-d', '--pull', 'never', '--wait', '--wait-timeout', '240', 'mysql', 'redis', timeout=300)
        details = isolated_services(bundle, project, evidence, {'mysql', 'redis'})
        report['mount_paths_within_standalone'] = True
        report['isolated_container_count'] = len(details)
        report['image_platforms'] = sorted(set(image['Os'] + '/' + image['Architecture'] for image in manifest['images'].values()))
        report['offline_image_identities_exact'] = True
        database = next(item['Id'] for item in details if item['Config']['Labels']['com.docker.compose.service'] == 'mysql')
        restored = inventory(database)
        require(restored == json.loads((bundle / 'database-inventory.json').read_text()), 'Standalone restored table rows/checksums differ from verified snapshot')
        report['database_tables_exact'] = len(restored)
        columns = mysql(database, "SELECT table_name,column_name,ordinal_position,column_type,is_nullable,IFNULL(column_default,'<NULL>'),extra,IFNULL(collation_name,'') FROM information_schema.columns WHERE table_schema='plm7_rebuild' ORDER BY table_name,ordinal_position;", raw=True)
        schema = hashlib.sha256(columns.encode()).hexdigest()
        require(schema == json.loads((bundle / 'database-verification.json').read_text())['column_definition_sha256'], 'Standalone restored column definitions differ')
        report['column_definitions_exact'] = True
        report['database_inventory_verified_before_application_start'] = True
        compose(bundle, project, evidence, 'up', '-d', '--pull', 'never', timeout=360)
        details = isolated_services(bundle, project, evidence, {'mysql', 'redis', 'backend', 'web'})
        report['isolated_container_count'] = len(details)
        compose(bundle, project, evidence, 'exec', '-T', 'backend', 'javac', '-J-Xmx256m', '-cp', '/app/lib/*', '/evidence/StandaloneProbe.java', '/evidence/ContainerHttp.java', timeout=120)
        command = ['docker', 'compose', '--env-file', str(bundle / '.env'), '-f', str(ROOT / 'compose.json'), '-p', project, '--profile', 'verification', 'exec', '-T', 'backend', 'java', '-Xmx128m', '-cp', '/evidence:/app/lib/*', 'StandaloneProbe']
        value = subprocess.run(command, env=compose_env(bundle, project, evidence), cwd=ROOT, input=(bundle / 'verification-input.json').read_bytes(), stdout=subprocess.PIPE, stderr=subprocess.PIPE, timeout=420)
        (evidence / 'probe-output.log').write_bytes(value.stdout + value.stderr)
        http = json.loads((evidence / 'http-verification.json').read_text())
        report['http'] = http
        after_application = inventory(database)
        report['post_application_table_changes'] = [
            {'table': name, 'restored': restored.get(name), 'after_application': after_application.get(name)}
            for name in sorted(set(restored) | set(after_application)) if restored.get(name) != after_application.get(name)]
        report['post_application_boundary'] = 'After initialization and authenticated HTTP verification; includes legitimate session/config changes, not a second snapshot-equality claim'
        require(value.returncode == 0 and http.get('passed') is True, 'Independent HTTP probe failed')
        report['templates'] = []
        for index, path in enumerate(TEMPLATES):
            matched = xlsx_equal(bundle / 'template-baselines' / (str(index) + '.xlsx'), evidence / ('template-' + str(index) + '.xlsx'), index == 4)
            require(matched, 'Independent template workbook differs from packed baseline')
            report['templates'].append({'path': path, 'workbook_parts_match': matched})
        report['backend_modules'] = manifest['backend_modules']; report['frontend_source_modules'] = manifest['frontend_source_modules']
        report['passed'] = True
    except Exception as error:
        report['error'] = str(error) if isinstance(error, RuntimeError) else type(error).__name__
    finally:
        logs = subprocess.run(['docker', 'compose', '--env-file', str(bundle / '.env'), '-f', str(ROOT / 'compose.json'), '-p', project, '--profile', 'verification', 'logs', '--tail', '100'], env=compose_env(bundle, project, evidence), cwd=ROOT, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        (evidence / 'private-service.log').write_bytes(logs.stdout + logs.stderr)
        try:
            if args.keep and report.get('database_tables_exact') == manifest['snapshot_tables'] and report.get('column_definitions_exact'):
                report['retained_for_additional_acceptance'] = True
                report['private_deployment_env'] = str((evidence / 'deployment.env').relative_to(ROOT))
                report['temporary_containers_and_volumes_removed'] = False
            else:
                compose(bundle, project, evidence, 'down', '--volumes', '--remove-orphans', timeout=120)
                report['temporary_containers_and_volumes_removed'] = not run(['docker', 'ps', '-aq', '--filter', 'label=com.docker.compose.project=' + project]).strip() and not run(['docker', 'volume', 'ls', '-q', '--filter', 'label=com.docker.compose.project=' + project]).strip()
        except Exception:
            report['temporary_containers_and_volumes_removed'] = False
        report['limits'] = ['Representative query/template/attachment migration acceptance, not full business equivalence', 'No outside integrations or cross-machine UI/browser acceptance', 'Delivery port profile was not started during this no-port verification']
        report['compose_sha256'] = digest(ROOT / 'compose.json')
        report['nginx_sha256'] = digest(ROOT / 'nginx.conf')
        report['http_probe_source_sha256'] = digest(evidence / 'StandaloneProbe.java')
        private_json(evidence / 'verification.json', report)
        for path in evidence.rglob('*'):
            if path.is_file(): path.chmod(0o600)
        (ROOT / 'verification.json').write_text(json.dumps(report, ensure_ascii=False, indent=2) + '\n')
    print(json.dumps({'passed': report['passed'], 'database_tables_exact': report.get('database_tables_exact'), 'published_ports': [], 'cleanup': report['temporary_containers_and_volumes_removed']}))
    require(report['passed'] and (report['temporary_containers_and_volumes_removed'] or report.get('retained_for_additional_acceptance')), 'Independent deployment acceptance did not pass')


def up(args):
    bundle, manifest = packaged_bundle(args.bundle)
    require(not manifest.get('stage_runtime_only'), 'Interim QA bundles cannot be published through the delivery profile')
    project = 'ljaps-standalone-' + secrets.token_hex(6)
    require(not run(['docker', 'ps', '-aq', '--filter', 'label=com.docker.compose.project=' + project]).strip(), 'Refusing an existing deployment project')
    require(not run(['docker', 'volume', 'ls', '-q', '--filter', 'label=com.docker.compose.project=' + project]).strip(), 'Refusing an existing database volume')
    evidence = ROOT / 'runtime' / ('deployment-' + project.rsplit('-', 1)[1]); evidence.mkdir(mode=0o700)
    ensure_images(bundle, manifest)
    deployment = env_read(bundle / '.env')
    if not deployment.get('LJAPS_INITIAL_USER_PASSWORD'):
        deployment['LJAPS_INITIAL_USER_PASSWORD'] = secrets.token_urlsafe(32)
    deployment.update(LJAPS_BUNDLE=str(bundle), LJAPS_EVIDENCE=str(evidence), LJAPS_STANDALONE_PROJECT=project)
    (evidence / 'deployment.env').write_text(''.join(key + '=' + value + '\n' for key, value in deployment.items())); (evidence / 'deployment.env').chmod(0o600)
    compose(bundle, project, evidence, 'up', '-d', '--pull', 'never', timeout=360, profile='delivery')
    private_json(evidence / 'deployment.json', {'project': project, 'bundle': str(bundle.relative_to(ROOT)), 'published_local_ports': [3119, 3120]})
    print(json.dumps({'started': True, 'project': project, 'deployment_env': str(evidence / 'deployment.env'), 'frontend': 'http://127.0.0.1:3120', 'api': 'http://127.0.0.1:3119'}))


def cleanup(args):
    require(re.fullmatch(r'ljaps-standalone-check-[a-f0-9]{12}', args.project) is not None, 'Only this tool owned QA projects may be removed')
    bundle = args.bundle.resolve()
    require(bundle.parent == (ROOT / 'runtime').resolve() and re.fullmatch(r'bundle-[0-9]{8}-[0-9]{6}-[a-f0-9]{6}', bundle.name), 'Cleanup requires an owned prepared bundle path')
    evidence = ROOT / 'runtime' / ('check-' + args.project.rsplit('-', 1)[1])
    report = json.loads((evidence / 'verification.json').read_text())
    require(report.get('project') == args.project and report.get('bundle') == str(bundle.relative_to(ROOT)), 'Owned QA evidence does not match project/bundle')
    compose(bundle, args.project, evidence, 'down', '--volumes', '--remove-orphans', timeout=120)
    removed = not run(['docker', 'ps', '-aq', '--filter', 'label=com.docker.compose.project=' + args.project]).strip() and not run(['docker', 'volume', 'ls', '-q', '--filter', 'label=com.docker.compose.project=' + args.project]).strip()
    require(removed, 'Some owned QA resources remain')
    report['temporary_containers_and_volumes_removed'] = True
    report['retained_for_additional_acceptance'] = False
    report['cleaned_at'] = datetime.now(timezone.utc).isoformat()
    private_json(evidence / 'verification.json', report)
    public = ROOT / 'verification.json'
    if public.exists() and json.loads(public.read_text()).get('project') == args.project:
        public.write_text(json.dumps(report, ensure_ascii=False, indent=2) + '\n')
    print(json.dumps({'project': args.project, 'removed': True}))


def validate_network_boundary(compose_data):
    require(compose_data['networks'] == {'isolated': {'internal': True}, 'local_entry': {}}, 'Network invariant')
    for name in ('backend', 'mysql', 'redis', 'web'):
        networks = compose_data['services'][name]['networks']
        require(set(networks) == {'isolated'}, name + ' must use only the internal network')
        require(not compose_data['services'][name].get('ports'), name + ' must remain unpublished')
    gateway = compose_data['services']['gateway']
    require(set(gateway['networks']) == {'isolated', 'local_entry'}, 'Gateway entry network invariant')
    require(gateway['ports'] == ['127.0.0.1:3120:80', '127.0.0.1:3119:81'], 'Gateway must retain the registered loopback listeners')


def main():
    parser = argparse.ArgumentParser(description=__doc__); commands = parser.add_subparsers(dest='command', required=True)
    prep = commands.add_parser('prepare'); prep.add_argument('--snapshot', type=Path, required=True); prep.add_argument('--fixture-env', type=Path, required=True); prep.add_argument('--config-dir', type=Path, default=REBUILD / 'local'); prep.add_argument('--stage', action='store_true', help='Package the activated interim artifact against its preserved build report; never claim current source acceptance')
    check = commands.add_parser('verify'); check.add_argument('--bundle', type=Path, required=True); check.add_argument('--keep', action='store_true', help='Keep an isolated group after exact database recovery, including business failures for diagnosis')
    delivery = commands.add_parser('up'); delivery.add_argument('--bundle', type=Path, required=True)
    remove = commands.add_parser('cleanup'); remove.add_argument('--bundle', type=Path, required=True); remove.add_argument('--project', required=True)
    commands.add_parser('self-check')
    args = parser.parse_args()
    if args.command == 'prepare': prepare(args)
    elif args.command == 'verify': verify(args)
    elif args.command == 'up': up(args)
    elif args.command == 'cleanup': cleanup(args)
    else:
        compose_data = json.loads((ROOT / 'compose.json').read_text())
        require(bind_inside_standalone(str(ROOT / 'runtime')) and bind_inside_standalone('/host_mnt' + str(ROOT / 'runtime')) and not bind_inside_standalone('/host_mnt/Users/outside'), 'Host bind alias boundary invariant')
        validate_network_boundary(compose_data)
        require('$$MYSQL_ROOT_PASSWORD' in compose_data['services']['mysql']['healthcheck']['test'][1], 'Container health password must not be interpolated by Compose')
        require('ports' not in compose_data['services']['web'] and compose_data['services']['gateway']['profiles'] == ['delivery'], 'No-port verification profile invariant')
        require(all(not value.get('external') for value in compose_data['volumes'].values()), 'Only new owned data volumes are allowed')
        print('Standalone offline configuration invariants passed; no containers were started.')


if __name__ == '__main__':
    main()
