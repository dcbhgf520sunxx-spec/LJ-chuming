#!/usr/bin/env python3
"""Prepare explicit integration inputs. Never connects, starts services, or writes business data."""
import argparse
from datetime import datetime, timezone
import json
import os
from pathlib import Path
import re
import stat
from urllib.parse import urlsplit

HERE = Path(__file__).resolve().parent
ROOT = HERE.parent


def require(condition, message):
    if not condition:
        raise ValueError(message)


def read_json(path):
    return json.loads(path.read_text())


def save_new(path, text):
    require(not path.exists(), '保留已有文件，请另选输出目录')
    path.parent.mkdir(parents=True, exist_ok=True, mode=0o700)
    fd = os.open(path, os.O_WRONLY | os.O_CREAT | os.O_EXCL, 0o600)
    with os.fdopen(fd, 'w') as stream:
        stream.write(text)


def private_path(path):
    require(not path.is_symlink(), '私有输入和输出不能是符号链接')
    path = path.resolve()
    require(path.is_relative_to(HERE / 'private') or path.is_relative_to(HERE / 'runtime'), '输出和真实资料必须位于integrations私有目录')
    return path


def environment(path, permitted):
    if not path.exists():
        return {}
    require(not path.is_symlink(), '配置文件不能是符号链接')
    require(stat.S_IMODE(path.stat().st_mode) & 0o077 == 0, '真实配置文件需设置为0600')
    result = {}
    for number, line in enumerate(path.read_text().splitlines(), 1):
        if not line.strip() or line.lstrip().startswith('#'):
            continue
        match = re.fullmatch(r'([A-Z][A-Z0-9_]*)=(.*)', line)
        require(match is not None, '配置格式无效，第' + str(number) + '行；使用KEY=原始单行值')
        name, value = match.groups()
        require(name in permitted and name not in result, '未知或重复配置名，第' + str(number) + '行')
        require('\x00' not in value, '配置含非法字符，第' + str(number) + '行')
        result[name] = value
    return result


def configured(value):
    return bool(value and value.strip()) and not re.search(r'(?i)^(TODO|REPLACE_?ME|CHANGE_?ME|placeholder|<.*>)$', value.strip())


def valid_value(value, kind):
    if not configured(value): return False
    if kind == 'bool': return value in ['true', 'false']
    if kind == 'port': return value.isdigit() and 0 < int(value) < 65536
    if kind in ['url', 'https-url']:
        try:
            target = urlsplit(value)
            return (target.scheme in (['https'] if kind == 'https-url' else ['http', 'https'])
                    and bool(target.hostname) and not target.username and not target.password
                    and not target.query and not target.fragment and target.hostname not in ['example.com', 'example.invalid']
                    and not target.hostname.endswith('.invalid') and (target.port is None or 0 < target.port < 65536))
        except ValueError:
            return False
    return True


def material_state(item, area):
    file = area / item['material_file']
    if not file.is_file() or file.is_symlink():
        return {'present': False, 'reviewed': False, 'requirementsConfirmed': 0}
    value = read_json(file)
    if not isinstance(value, dict):
        return {'present': True, 'reviewed': False, 'requirementsConfirmed': 0}
    valid = value.get('integration_id') == item['id'] and value.get('environment') == 'test' and value.get('reviewed') is True
    confirmed = 0
    provided = value.get('requirements', [])
    if not isinstance(provided, list):
        return {'present': True, 'reviewed': False, 'requirementsConfirmed': 0}
    for text in item['required_materials']:
        matches = [row for row in provided if isinstance(row, dict) and row.get('requirement') == text]
        if len(matches) != 1 or matches[0].get('confirmed') is not True:
            valid = False
            continue
        evidence = matches[0].get('evidence', '')
        relative = Path(evidence)
        source = area / relative
        if not evidence or relative.is_absolute() or '..' in relative.parts or source.is_symlink() or not source.resolve().is_relative_to(area) or not source.is_file() or source.stat().st_size == 0:
            valid = False
        else:
            confirmed += 1
    return {'present': True, 'reviewed': valid, 'requirementsConfirmed': confirmed}


def inspect(catalog, values, area, selected):
    rows = []
    for item in catalog['integrations']:
        if item['id'] not in selected: continue
        missing = [field['name'] for field in item['environment']
                   if (field.get('required', True) or values.get(field['name']) not in (None, ''))
                   and (not valid_value(values.get(field['name']), field['type'])
                        or ('expected' in field and values.get(field['name']) != field['expected']))]
        materials = material_state(item, area)
        ready = not missing and materials['reviewed'] and not item['code_blockers'] and item['discovery_review_complete']
        rows.append({'id': item['id'], 'name': item['name'], 'ready_for_real_test': ready,
                     'local_preparation': item['local_preparation'], 'source_review_complete': item['discovery_review_complete'],
                     'missing_or_invalid_environment_names': missing, 'materials': materials,
                     'code_blockers': item['code_blockers'], 'real_test_status': 'not-started'})
    return {'schema': 1, 'generatedUTC': datetime.now(timezone.utc).isoformat(),
            'scope': '静态准备状态，未访问第三方/数据库/硬件；资料存在及人工审核不代表真实接口验收',
            'selected': sorted(selected), 'ready_for_real_test': bool(rows) and all(row['ready_for_real_test'] for row in rows),
            'ready_count': sum(row['ready_for_real_test'] for row in rows), 'integration_count': len(rows),
            'network_requests': 0, 'database_writes': 0, 'services_started': 0, 'integrations': rows}


def templates(catalog, area):
    lines = ['# 第三方测试配置；原始单行KEY=值，不使用引号、不source执行。', '# 本文件不含真实凭据。复制到private/connections.env后chmod 600。']
    seen = set()
    for item in catalog['integrations']:
        lines.append('\n# ' + item['id'] + ' ' + item['name'])
        for field in item['environment']:
            if field['name'] not in seen:
                lines.append(field['name'] + '=')
                seen.add(field['name'])
        contract = {'integration_id': item['id'], 'environment': 'test', 'reviewed': False,
                    'requirements': [{'requirement': text, 'confirmed': False, 'evidence': ''} for text in item['required_materials']],
                    'notes': 'evidence填相对于本private目录的实际文档/样例文件；不得放生产账号作为测试默认值。'}
        save_new(area / item['material_file'], json.dumps(contract, ensure_ascii=False, indent=2) + '\n')
    save_new(area / 'connections.env.example', '\n'.join(lines) + '\n')


def render(catalog, values, report, area):
    require(report['ready_for_real_test'], '资料或代码尚未齐全，停止生成可执行对接配置；先查看status')
    names = {field['name'] for item in catalog['integrations'] if item['id'] in report['selected'] for field in item['environment']}
    env = {name: values[name] for name in names if name in values and values[name] != ''}
    properties = {}
    for item in catalog['integrations']:
        if item['id'] not in report['selected']: continue
        for field in item['environment']:
            if field.get('spring_property') and field['name'] in env:
                properties[field['spring_property']] = '${' + field['name'] + '}'
    env_path = area / 'connections.env'
    properties_path = area / 'connections.properties'
    compose_path = area / 'compose.integrations.json'
    require(not any(p.exists() for p in [env_path, properties_path, compose_path]), '请使用新的私有输出目录以保留既有配置')
    save_new(env_path, '\n'.join(name + '=' + env[name] for name in sorted(env)) + '\n')
    save_new(properties_path, '\n'.join(name + '=' + properties[name] for name in sorted(properties)) + '\n')
    compose = {'services': {'backend': {
        'env_file': [{'path': str(env_path), 'format': 'raw'}],
        'environment': {'SPRING_CONFIG_ADDITIONAL_LOCATION': 'file:/run/config/business.properties,file:/run/config/integrations.properties'},
        'volumes': [{'type': 'bind', 'source': str(properties_path), 'target': '/run/config/integrations.properties', 'read_only': True}]}}}
    save_new(compose_path, json.dumps(compose, ensure_ascii=False, indent=2) + '\n')
    # Networking stays unchanged; an operator must separately prepare approved egress and inbound callbacks.
    return {'generated': True, 'directory': str(area.relative_to(ROOT)), 'started': False, 'external_network_enabled': False}


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('command', choices=['templates', 'status', 'render'])
    parser.add_argument('--env', type=Path, default=HERE / 'private/connections.env')
    parser.add_argument('--materials', type=Path, default=HERE / 'private')
    parser.add_argument('--output', type=Path)
    parser.add_argument('--integrations', default='all')
    args = parser.parse_args()
    catalog = read_json(HERE / 'catalog.json')
    ids = {item['id'] for item in catalog['integrations']}
    require(len(ids) == catalog['integration_count'] == 17, '对接目录必须保留全部17项')
    selected = ids if args.integrations == 'all' else set(args.integrations.split(','))
    require(bool(selected) and selected <= ids, '请选择目录内的对接ID')
    area = private_path(args.materials)
    if args.command == 'templates':
        templates(catalog, private_path(args.output or area))
        print(json.dumps({'templates': 17, 'secretsWritten': 0, 'testsRun': 0}))
        return
    permitted = {field['name'] for item in catalog['integrations'] for field in item['environment']}
    values = environment(private_path(args.env), permitted)
    report = inspect(catalog, values, area, selected)
    if args.command == 'render':
        print(json.dumps(render(catalog, values, report, private_path(args.output or HERE / 'runtime/prepared')), ensure_ascii=False))
        return
    if args.output:
        save_new(private_path(args.output), json.dumps(report, ensure_ascii=False, indent=2) + '\n')
    print(json.dumps(report, ensure_ascii=False, indent=2))


if __name__ == '__main__':
    try:
        main()
    except (ValueError, OSError, json.JSONDecodeError):
        # Do not include parser/file exception strings that could contain secret input values.
        raise SystemExit('准备检查未通过：请核对私有文件格式、权限、缺项或使用新的输出目录；未执行外部请求。')
