"""Offline preparation-tool checks, prepared for the consolidated local check phase."""
import importlib.util
import json
import os
from pathlib import Path
import tempfile
import unittest
from unittest.mock import patch

spec = importlib.util.spec_from_file_location('integration_prepare', Path(__file__).resolve().parents[1] / 'prepare.py')
p = importlib.util.module_from_spec(spec)
spec.loader.exec_module(p)


class PreparationTests(unittest.TestCase):
    def setUp(self):
        self.temp = tempfile.TemporaryDirectory()
        self.area = Path(self.temp.name)
        self.item = {'id': 'I01', 'name': 'fixture', 'material_file': 'I01/contract.json',
                     'environment': [{'name': 'LJAPS_TEST_SECRET', 'type': 'secret', 'spring_property': 'test.secret'}],
                     'required_materials': ['Exact test contract'], 'code_blockers': [],
                     'discovery_review_complete': True, 'local_preparation': 'prepared'}
        self.catalog = {'integrations': [self.item]}

    def tearDown(self): self.temp.cleanup()

    def material(self):
        (self.area / 'contract.md').write_text('Explicit synthetic local fixture, not a real provider.')
        file = self.area / 'I01/contract.json'
        file.parent.mkdir()
        file.write_text(json.dumps({'integration_id': 'I01', 'environment': 'test', 'reviewed': True,
            'requirements': [{'requirement': 'Exact test contract', 'confirmed': True, 'evidence': 'contract.md'}]}))

    def test_no_inputs_is_not_ready(self):
        report = p.inspect(self.catalog, {}, self.area, {'I01'})
        self.assertFalse(report['ready_for_real_test'])
        self.assertEqual(report['network_requests'], 0)

    def test_values_without_reviewed_contract_are_not_ready(self):
        self.assertFalse(p.inspect(self.catalog, {'LJAPS_TEST_SECRET': 'synthetic'}, self.area, {'I01'})['ready_for_real_test'])

    def test_reviewed_contract_and_values(self):
        self.material()
        self.assertTrue(p.inspect(self.catalog, {'LJAPS_TEST_SECRET': 'synthetic'}, self.area, {'I01'})['ready_for_real_test'])

    def test_code_blocker_cannot_be_bypassed_by_credentials(self):
        self.material();self.item['code_blockers'] = ['Needs source contract']
        self.assertFalse(p.inspect(self.catalog, {'LJAPS_TEST_SECRET': 'synthetic'}, self.area, {'I01'})['ready_for_real_test'])

    def test_disabled_flag_is_not_ready_for_remote_test(self):
        self.material();self.item['environment'][0].update(type='bool', expected='true')
        self.assertFalse(p.inspect(self.catalog, {'LJAPS_TEST_SECRET': 'false'}, self.area, {'I01'})['ready_for_real_test'])

    def test_unreviewed_source_is_not_ready(self):
        self.material();self.item['discovery_review_complete'] = False
        self.assertFalse(p.inspect(self.catalog, {'LJAPS_TEST_SECRET': 'synthetic'}, self.area, {'I01'})['ready_for_real_test'])

    def test_missing_evidence_is_not_a_review(self):
        self.material();(self.area / 'contract.md').unlink()
        self.assertFalse(p.material_state(self.item, self.area)['reviewed'])

    def test_invalid_urls_and_placeholder(self):
        for text in ['https://u:secret@example.test', 'ftp://example.test', 'https://example.invalid', 'https://example.test/?token=test', 'https://example.test/#x', 'https://example.test:99999', 'TODO']:
            self.assertFalse(p.valid_value(text, 'https-url'))
        self.assertTrue(p.valid_value('https://provider.example.test/api', 'https-url'))

    def test_optional_address_is_checked_when_provided(self):
        self.material()
        self.item['environment'].append({'name': 'LJAPS_TEST_ENDPOINT', 'type': 'https-url', 'required': False})
        values = {'LJAPS_TEST_SECRET': 'synthetic', 'LJAPS_TEST_ENDPOINT': 'https://provider.example.test:99999'}
        report = p.inspect(self.catalog, values, self.area, {'I01'})
        self.assertFalse(report['ready_for_real_test'])
        self.assertIn('LJAPS_TEST_ENDPOINT', report['integrations'][0]['missing_or_invalid_environment_names'])

    def test_blank_optional_values_keep_provider_defaults(self):
        self.material()
        self.item['environment'].append({'name': 'LJAPS_TEST_ENDPOINT', 'type': 'https-url',
                                        'spring_property': 'test.endpoint', 'required': False})
        values = {'LJAPS_TEST_SECRET': 'synthetic', 'LJAPS_TEST_ENDPOINT': ''}
        report = p.inspect(self.catalog, values, self.area, {'I01'})
        self.assertTrue(report['ready_for_real_test'])
        out = self.area / 'render'
        with patch.object(p, 'ROOT', self.area):
            p.render(self.catalog, values, report, out)
        self.assertNotIn('LJAPS_TEST_ENDPOINT', (out / 'connections.env').read_text())
        self.assertNotIn('test.endpoint', (out / 'connections.properties').read_text())

    def test_secret_raw_symbols_are_preserved_without_execution(self):
        file = self.area / 'config.env';file.write_text('LJAPS_TEST_SECRET=synthetic$neverExecute#literal=ok\n');file.chmod(0o600)
        self.assertEqual(p.environment(file, {'LJAPS_TEST_SECRET'})['LJAPS_TEST_SECRET'], 'synthetic$neverExecute#literal=ok')

    def test_duplicate_and_unknown_names_rejected_without_values(self):
        file = self.area / 'config.env'
        for text in ['LJAPS_TEST_SECRET=never-print-this\nLJAPS_TEST_SECRET=other\n', 'UNEXPECTED=never-print-this\n']:
            file.write_text(text);file.chmod(0o600)
            with self.assertRaises(ValueError) as caught: p.environment(file, {'LJAPS_TEST_SECRET'})
            self.assertNotIn('never-print-this', str(caught.exception))

    def test_loose_permissions_rejected(self):
        file = self.area / 'config.env';file.write_text('LJAPS_TEST_SECRET=test\n');file.chmod(0o644)
        with self.assertRaises(ValueError): p.environment(file, {'LJAPS_TEST_SECRET'})

    def test_renderer_refuses_incomplete(self):
        with self.assertRaises(ValueError): p.render(self.catalog, {}, {'ready_for_real_test': False}, self.area)
        self.assertEqual(list(self.area.iterdir()), [])

    def test_renderer_has_no_start_or_egress_and_uses_raw_env(self):
        values = {'LJAPS_TEST_SECRET': 'synthetic$raw#literal'}
        out = self.area / 'render';out.mkdir()
        with patch.object(p, 'ROOT', self.area):
            result = p.render(self.catalog, values, {'ready_for_real_test': True, 'selected': ['I01']}, out)
        self.assertFalse(result['started']);self.assertFalse(result['external_network_enabled'])
        compose = json.loads((out / 'compose.integrations.json').read_text())
        backend = compose['services']['backend']
        self.assertEqual(backend['env_file'][0]['format'], 'raw')
        self.assertNotIn('networks', backend)
        self.assertEqual((out / 'connections.env').read_text(), 'LJAPS_TEST_SECRET=synthetic$raw#literal\n')
        self.assertEqual((out / 'connections.properties').read_text(), 'test.secret=${LJAPS_TEST_SECRET}\n')
        self.assertEqual(os.stat(out / 'connections.env').st_mode & 0o777, 0o600)


if __name__ == '__main__': unittest.main()
