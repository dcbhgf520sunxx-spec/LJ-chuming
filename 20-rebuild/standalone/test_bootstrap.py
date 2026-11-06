"""Small corruption regressions for the standalone frontend packaging boundary."""
import importlib.util
import copy
import json
from pathlib import Path
import tempfile
import unittest
from unittest.mock import patch

spec = importlib.util.spec_from_file_location('standalone_bootstrap', Path(__file__).with_name('bootstrap.py'))
bootstrap = importlib.util.module_from_spec(spec)
spec.loader.exec_module(bootstrap)


class DeploymentNetworkVerification(unittest.TestCase):
    def setUp(self):
        self.compose = json.loads(Path(__file__).with_name('compose.json').read_text())

    def test_only_gateway_has_local_entry_bridge(self):
        bootstrap.validate_network_boundary(self.compose)

    def test_business_service_cannot_join_entry_bridge(self):
        for name in ('backend', 'mysql', 'redis', 'web'):
            with self.subTest(service=name):
                data = copy.deepcopy(self.compose)
                data['services'][name]['networks'] = ['isolated', 'local_entry']
                with self.assertRaisesRegex(RuntimeError, 'internal network'):
                    bootstrap.validate_network_boundary(data)

    def test_gateway_cannot_publish_beyond_loopback(self):
        data = copy.deepcopy(self.compose)
        data['services']['gateway']['ports'] = ['0.0.0.0:3120:80', '127.0.0.1:3119:81']
        with self.assertRaisesRegex(RuntimeError, 'loopback'):
            bootstrap.validate_network_boundary(data)


class FrontendPackageVerification(unittest.TestCase):
    def setUp(self):
        self.temporary = tempfile.TemporaryDirectory(prefix='standalone-front-')
        self.addCleanup(self.temporary.cleanup)
        self.front = Path(self.temporary.name)
        for name, body in [('src/main.js', 'export const value = 1;'), ('dist/index.html', '<script src="assets/app.js"></script>'), ('dist/assets/app.js', 'console.log(1);'), ('package-lock.json', '{}')]:
            path = self.front / name
            path.parent.mkdir(parents=True, exist_ok=True)
            path.write_text(body)
        def entry(path, relative):
            return {'path': relative, 'bytes': path.stat().st_size, 'sha256': bootstrap.digest(path)}
        report = {'original_vendor_used': False, 'request_metadata_invariant': True,
                  'sources': [entry(self.front / 'src/main.js', 'src/main.js')],
                  'dist_files': [entry(path, str(path.relative_to(self.front / 'dist'))) for path in sorted((self.front / 'dist').rglob('*')) if path.is_file()],
                  'package_lock_sha256': bootstrap.digest(self.front / 'package-lock.json'),
                  'index_sha256': bootstrap.digest(self.front / 'dist/index.html')}
        (self.front / 'source-build-verification.json').write_text(json.dumps(report))

    def test_matching_complete_inventory_is_accepted(self):
        bootstrap.validate_frontend(self.front)

    def test_new_unverified_source_file_is_rejected(self):
        (self.front / 'src/unverified.js').write_text('export const injected = true;')
        with self.assertRaisesRegex(ValueError, 'inventory'):
            bootstrap.validate_frontend(self.front)

    def test_changed_chunk_is_rejected_even_for_stage_package(self):
        (self.front / 'dist/assets/app.js').write_text('console.log(2);')
        with self.assertRaisesRegex(ValueError, 'changed after verification'):
            bootstrap.validate_frontend(self.front, stage=True)

    def test_prepared_bundle_validation_needs_no_local_or_source_tree(self):
        standalone = self.front / 'standalone'
        bundle = standalone / 'runtime/bundle-20261015-000000-abcdef'
        (bundle / 'web').mkdir(parents=True)
        (bundle / 'web/index.html').write_text('self-contained')
        (bundle / 'manifest.json').write_text(json.dumps({'files': {'web/index.html': bootstrap.digest(bundle / 'web/index.html')}}))
        with patch.object(bootstrap, 'ROOT', standalone), patch.object(bootstrap, 'frontend_verifier', side_effect=AssertionError('Source helper used at startup')):
            accepted, _ = bootstrap.packaged_bundle(bundle)
        self.assertEqual(accepted, bundle.resolve())


if __name__ == '__main__':
    unittest.main()
