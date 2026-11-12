import hashlib
import importlib.util
import json
from pathlib import Path
import tempfile
import unittest

spec = importlib.util.spec_from_file_location('frontend_activation', Path(__file__).with_name('activate-frontend.py'))
activation = importlib.util.module_from_spec(spec)
spec.loader.exec_module(activation)


class FrontendPublicationTests(unittest.TestCase):
    def test_preserves_existing_bim_environment_and_policy_when_publishing(self):
        config = {'sdk_version': '3.6.350', 'sdk_loader_url': 'https://static.bimface.com/loader.js',
                  'api_url': 'https://api.bimface.com/', 'static_url': 'https://static.bimface.com/api',
                  'resource_url': 'https://m.bimface.com/'}
        old = '<head><meta http-equiv="Content-Security-Policy" content="existing-policy">' \
              '<script type="application/json" id="ljaps-bim-viewer-config">' + json.dumps(config) + '</script></head>'
        new = '<head><meta http-equiv="Content-Security-Policy" content="build-policy"></head><script src="new.js"></script>'
        result = activation.preserve_bim_environment(new, old)
        self.assertIn('existing-policy', result)
        self.assertIn('ljaps-bim-viewer-config', result)
        self.assertIn('new.js', result)
        self.assertEqual(activation.preserve_bim_environment(new, ''), new)
        self.assertEqual(activation.preserve_bim_environment(result, old), result)
        with tempfile.TemporaryDirectory() as temporary:
            dist, web = Path(temporary) / 'dist', Path(temporary) / 'web'
            dist.mkdir(); web.mkdir()
            (dist / 'index.html').write_text(new)
            (web / 'index.html').write_text(old)
            entry = {'path': 'index.html', 'bytes': (dist / 'index.html').stat().st_size,
                     'sha256': activation.digest(dist / 'index.html')}
            activation.publish(dist, web, [entry], entry['sha256'])
            self.assertEqual((web / 'index.html').read_text(), result)
            self.assertEqual((dist / 'index.html').read_text(), new)

    def artifacts(self, root):
        (root / 'assets').mkdir()
        (root / 'index.html').write_text('<script src="/assets/new.js"></script>')
        (root / 'assets/new.js').write_text('export const version = 2;')
        return [{'path': str(p.relative_to(root)), 'bytes': p.stat().st_size,
                 'sha256': hashlib.sha256(p.read_bytes()).hexdigest()} for p in root.rglob('*') if p.is_file()]

    def test_publishes_verified_entry_and_keeps_open_tab_chunks(self):
        with tempfile.TemporaryDirectory() as temporary:
            dist, web = Path(temporary) / 'dist', Path(temporary) / 'web'
            dist.mkdir(); web.mkdir(); (web / 'assets').mkdir()
            (web / 'assets/old.js').write_text('export const version = 1;')
            entries = self.artifacts(dist)
            activation.publish(dist, web, entries, activation.digest(dist / 'index.html'))
            self.assertEqual((web / 'index.html').read_bytes(), (dist / 'index.html').read_bytes())
            self.assertTrue((web / 'assets/old.js').is_file())
            self.assertEqual(activation.digest(web / 'assets/new.js'), activation.digest(dist / 'assets/new.js'))

    def test_tampered_chunk_does_not_replace_entry(self):
        with tempfile.TemporaryDirectory() as temporary:
            dist, web = Path(temporary) / 'dist', Path(temporary) / 'web'
            dist.mkdir(); web.mkdir(); (web / 'index.html').write_text('previous entry')
            entries = self.artifacts(dist)
            (dist / 'assets/new.js').write_text('changed')
            with self.assertRaises(ValueError):
                activation.publish(dist, web, entries, activation.digest(dist / 'index.html'))
            self.assertEqual((web / 'index.html').read_text(), 'previous entry')

    def test_unlisted_files_and_escaping_paths_are_rejected(self):
        with tempfile.TemporaryDirectory() as temporary:
            root = Path(temporary)
            entries = self.artifacts(root)
            (root / 'unverified.js').write_text('changed')
            with self.assertRaises(ValueError):
                activation.verify_files(root, entries)
            with self.assertRaises(ValueError):
                activation.checked_path(root, '../index.html')


if __name__ == '__main__':
    unittest.main()
