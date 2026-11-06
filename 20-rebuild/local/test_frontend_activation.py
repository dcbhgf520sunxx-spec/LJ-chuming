import hashlib
import importlib.util
from pathlib import Path
import tempfile
import unittest

spec = importlib.util.spec_from_file_location('frontend_activation', Path(__file__).with_name('activate-frontend.py'))
activation = importlib.util.module_from_spec(spec)
spec.loader.exec_module(activation)


class FrontendPublicationTests(unittest.TestCase):
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
