import importlib.util
from pathlib import Path
import tempfile
import unittest

MODULE = Path(__file__).with_name('database_snapshot.py')


class SnapshotSafetyTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        spec = importlib.util.spec_from_file_location('database_snapshot', MODULE)
        cls.module = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(cls.module)

    def test_refuses_reference_database(self):
        for value in ('plm7', 'mysql', 'plm7_rebuild; DROP DATABASE plm7', ''):
            with self.assertRaises(ValueError):
                self.module.validate_database(value)
        self.assertEqual(self.module.validate_database('plm7_rebuild'), 'plm7_rebuild')

    def test_cleanup_only_accepts_this_tools_random_names(self):
        self.assertTrue(self.module.owned_name('ljaps-restore-check-0123456789ab'))
        for value in ('ljaps-local-mysql-1', 'ljaps-rebuild-backend-1', 'ljaps-restore-check-', 'ljaps-restore-check-0123456789ab-extra'):
            self.assertFalse(self.module.owned_name(value))

    def test_table_inventory_keeps_empty_and_big_tables(self):
        result = self.module.parse_inventory('empty_table\t0\t0\nbusiness_table\t9999999\t12345\n')
        self.assertEqual(result['empty_table'], {'rows': 0, 'checksum': '0'})
        self.assertEqual(result['business_table'], {'rows': 9999999, 'checksum': '12345'})

    def test_null_checksum_cannot_be_reported_as_verified(self):
        with self.assertRaises(ValueError):
            self.module.parse_inventory('business_table\t4\tNULL\n')

    def test_tampered_snapshot_is_rejected_before_restore(self):
        with tempfile.TemporaryDirectory() as folder:
            path = Path(folder) / 'snapshot.sql.gz'
            path.write_bytes(b'changed')
            with self.assertRaises(ValueError):
                self.module.verify_digest(path, '0' * 64)


if __name__ == '__main__':
    unittest.main()
