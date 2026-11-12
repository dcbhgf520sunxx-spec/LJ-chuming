#!/usr/bin/env python3
"""Publish a verified frontend without exposing Vite's disposable build directory."""
import hashlib
import json
import os
from pathlib import Path
import re
import shutil
import tempfile

ROOT = Path(__file__).resolve().parent


def digest(path):
    return hashlib.sha256(path.read_bytes()).hexdigest()


def preserve_bim_environment(html, previous):
    """Keep the deployed viewer environment separate from the generic verified build."""
    marker = 'ljaps-bim-viewer-config'
    if marker in html or marker not in previous:
        return html
    config = re.search(r'<script\b[^>]*\bid=[\"\']' + marker + r'[\"\'][^>]*>(.*?)</script>', previous, re.S)
    if not config or not {'sdk_version', 'sdk_loader_url', 'api_url', 'static_url', 'resource_url'} <= json.loads(config[1]).keys():
        raise ValueError('Existing BIM viewer environment is invalid')
    policy = r'<meta\b[^>]*http-equiv=[\"\']Content-Security-Policy[\"\'][^>]*>'
    previous_policy = re.search(policy, previous, re.I)
    if not previous_policy or not re.search(policy, html, re.I) or '</head>' not in html:
        raise ValueError('BIM viewer publication requires an explicit browser policy')
    html = re.sub(policy, lambda _: previous_policy[0], html, count=1, flags=re.I)
    return html.replace('</head>', config[0] + '</head>', 1)


def checked_path(root, relative):
    path = root / relative
    if Path(relative).is_absolute() or '..' in Path(relative).parts or path.is_symlink() or not path.is_file():
        raise ValueError('Invalid artifact path: ' + relative)
    if root.resolve() not in path.resolve().parents:
        raise ValueError('Artifact escaped its root')
    return path


def verify_files(root, entries):
    expected = {entry['path'] for entry in entries}
    actual = {str(path.relative_to(root)) for path in root.rglob('*') if path.is_file()}
    if expected != actual or len(expected) != len(entries):
        raise ValueError('Artifact file inventory changed after verification')
    for entry in entries:
        path = checked_path(root, entry['path'])
        if path.stat().st_size != entry['bytes'] or digest(path) != entry['sha256']:
            raise ValueError('Artifact changed after verification: ' + entry['path'])



def verify_source_inputs(frontend, report):
    verify_files(frontend / 'src', [{**entry, 'path': str(Path(entry['path']).relative_to('src'))} for entry in report['sources']])
    if digest(checked_path(frontend, 'package-lock.json')) != report['package_lock_sha256']:
        raise ValueError('Dependency lock changed after verification')
    required = {'vite.config.js', 'package.json', 'tools/assemble.mjs', 'tools/record-build.mjs',
                'tools/input-number-aria-compat.mjs', 'node_modules/element-plus/package.json',
                'node_modules/element-plus/es/components/input-number/src/input-number.vue_vue_type_script_setup_true_lang.mjs'}
    entries = report.get('build_inputs', [])
    if report.get('build_input_schema') != 1 or {entry['path'] for entry in entries} != required or len(entries) != len(required):
        raise ValueError('Complete frontend build input hashes are required')
    for entry in entries:
        source = checked_path(frontend, entry['path'])
        if source.stat().st_size != entry['bytes'] or digest(source) != entry['sha256']:
            raise ValueError('Frontend build input changed after verification: ' + entry['path'])


def publish(dist, destination, entries, expected_index):
    verify_files(dist, entries)
    if digest(dist / 'index.html') != expected_index:
        raise ValueError('Frontend entry differs from the verified build')
    destination.mkdir(parents=True, exist_ok=True)
    prior_index = destination / 'index.html'
    published_index = preserve_bim_environment((dist / 'index.html').read_text(),
                                              prior_index.read_text() if prior_index.exists() else '').encode()
    # Keep the directory inode stable for Docker's bind mount. Existing hashed assets
    # remain available to tabs opened before publication; switch index only at the end.
    with tempfile.TemporaryDirectory(prefix='.frontend-stage-', dir=destination.parent) as temporary:
        stage = Path(temporary)
        for entry in entries:
            relative = entry['path']
            staged = stage / relative
            staged.parent.mkdir(parents=True, exist_ok=True)
            shutil.copyfile(checked_path(dist, relative), staged)
        verify_files(stage, entries)
        (stage / 'index.html').write_bytes(published_index)
        for entry in entries:
            relative = entry['path']
            if relative == 'index.html':
                continue
            target = destination / relative
            target.parent.mkdir(parents=True, exist_ok=True)
            os.replace(stage / relative, target)
        os.replace(stage / 'index.html', destination / 'index.html')
    for entry in entries:
        expected = hashlib.sha256(published_index).hexdigest() if entry['path'] == 'index.html' else entry['sha256']
        if digest(checked_path(destination, entry['path'])) != expected:
            raise ValueError('Published frontend verification failed: ' + entry['path'])


def main():
    frontend = ROOT.parent / 'frontend-recovered'
    report = json.loads((frontend / 'source-build-verification.json').read_text())
    if report.get('original_vendor_used') is not False or not report.get('request_metadata_invariant'):
        raise ValueError('A verified recovered-source build is required')
    verify_source_inputs(frontend, report)
    entries = report.get('dist_files')
    if not entries:
        raise ValueError('Full build artifact hashes are required before publication')
    destination = ROOT / 'runtime/web'
    publish(frontend / 'dist', destination, entries, report['index_sha256'])
    record = {'index_sha256': report['index_sha256'], 'published_files': len(entries),
              'published_index_sha256': digest(destination / 'index.html'),
              'dist_files': entries, 'source_build_verified_at': report['verified_at'],
              'published_directory': '20-rebuild/local/runtime/web',
              'old_hashed_assets_retained_for_open_tabs': True}
    (ROOT / 'runtime/frontend-activation.json').write_text(json.dumps(record, indent=2) + '\n')
    print(json.dumps({key: value for key, value in record.items() if key != 'dist_files'}))


if __name__ == '__main__':
    main()
