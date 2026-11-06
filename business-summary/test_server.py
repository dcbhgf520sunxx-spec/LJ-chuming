import copy
import importlib.util
import json
import re
import sqlite3
import tempfile
import threading
import unittest
from pathlib import Path
from urllib.error import HTTPError
from urllib.request import Request, urlopen


ROOT = Path(__file__).resolve().parent
DOCUMENT = ROOT.parent / '绿建智能生产业务梳理.html'


class SummaryServerTests(unittest.TestCase):
    def setUp(self):
        self.assertTrue((ROOT / 'server.py').exists(), '需要实现数据库保存服务')
        spec = importlib.util.spec_from_file_location('summary_server', ROOT / 'server.py')
        self.module = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(self.module)
        self.temp = tempfile.TemporaryDirectory()
        self.addCleanup(self.temp.cleanup)
        self.document = Path(self.temp.name) / 'summary.html'
        self.document.write_bytes(DOCUMENT.read_bytes())
        self.database = Path(self.temp.name) / 'summary.sqlite3'
        self.server = None
        self.start_server()
        self.addCleanup(self.stop_server)

    def start_server(self):
        self.server = self.module.create_server(self.document, self.database, port=0)
        self.origin = 'http://127.0.0.1:' + str(self.server.server_address[1])
        self.thread = threading.Thread(target=self.server.serve_forever, daemon=True)
        self.thread.start()

    def stop_server(self):
        if self.server:
            self.server.shutdown()
            self.server.server_close()
            self.thread.join()
            self.server = None

    def request(self, path='/api/nodes', data=None, origin=None, host=None):
        headers = {'Content-Type': 'application/json', 'X-LJ-APS-Editor': '1'}
        if origin:
            headers['Origin'] = origin
        if host:
            headers['Host'] = host
        payload = None if data is None else json.dumps(data).encode()
        request = Request(self.origin + path, data=payload, headers=headers,
                          method='GET' if data is None else 'PUT')
        try:
            with urlopen(request, timeout=5) as response:
                return response.status, response.read()
        except HTTPError as error:
            return error.code, error.read()

    def snapshot(self):
        status, body = self.request()
        self.assertEqual(status, 200, body)
        return json.loads(body)

    def test_save_survives_restart_and_is_really_in_sqlite(self):
        state = self.snapshot()
        field_ids = re.findall(r'data-field="([^"]+)"', self.document.read_text())
        self.assertEqual(set(state['fields']), set(field_ids))
        self.assertEqual(len(state['fields']), len(field_ids))
        state['fields']['node-01.c0.text.1'] = '测试采购计划到位时间\n第二行'
        state['fields']['node-01.c0.status.0'] = '已确认'
        state['fields']['department-01.duties'] = '核实后的部门主要职责'
        state['fields']['department-01.status.0'] = '已确认'
        self.assertEqual(self.request(data=state)[0], 200)
        self.stop_server()
        self.start_server()
        loaded = self.snapshot()
        self.assertEqual(loaded['fields'], state['fields'])
        with sqlite3.connect(self.database) as connection:
            fields = json.loads(connection.execute(
                'SELECT fields_json FROM pms_business_summary WHERE id=1').fetchone()[0])
        self.assertEqual(fields['node-01.c0.text.1'], state['fields']['node-01.c0.text.1'])

    def test_stale_save_cannot_overwrite_another_save(self):
        state = self.snapshot()
        other = copy.deepcopy(state)
        state['fields']['node-01.c0.text.1'] = '先保存的内容'
        self.assertEqual(self.request(data=state)[0], 200)
        other['fields']['node-01.c0.text.1'] = '过期页面内容'
        self.assertEqual(self.request(data=other)[0], 409)
        self.assertEqual(self.snapshot()['fields']['node-01.c0.text.1'], '先保存的内容')

    def test_invalid_payload_does_not_change_database(self):
        original = self.snapshot()
        for change in ('status', 'missing', 'unknown', 'oversize', 'revision'):
            state = copy.deepcopy(original)
            if change == 'status':
                state['fields']['node-01.c0.status.0'] = '随便写的状态'
            elif change == 'missing':
                state['fields'].pop('node-01.c0.text.1')
            elif change == 'unknown':
                state['fields']['unknown'] = '额外字段'
            elif change == 'oversize':
                state['fields']['node-01.c0.text.1'] = '字' * 20001
            else:
                state['revision'] = True
            self.assertEqual(self.request(data=state)[0], 400, change)
        self.assertEqual(self.snapshot(), original)

    def test_source_updates_preserve_manual_edits_and_refresh_untouched_fields(self):
        state = self.snapshot()
        state['fields']['node-01.c0.text.1'] = '手工确认的内容'
        self.assertEqual(self.request(data=state)[0], 200)
        text = self.document.read_text()
        for field, value in [('node-01.c0.text.1', '新的资料说明'),
                             ('node-01.c4.text.0', '更新后的需求计划准确性')]:
            text, count = re.subn(
                r'(<[^>]+data-field="' + re.escape(field) + r'"[^>]*>)[^<]*(</[^>]+>)',
                lambda match: match[1] + value + match[2], text)
            self.assertEqual(count, 1)
        self.document.write_text(text)
        current = self.snapshot()
        self.assertEqual(current['fields']['node-01.c0.text.1'], '手工确认的内容')
        self.assertIn('更新后的需求计划准确性', current['fields']['node-01.c4.text.0'])
        self.assertEqual(self.request(data=state)[0], 409)

    def test_external_origin_or_host_cannot_write_or_read(self):
        state = self.snapshot()
        self.assertEqual(self.request(data=state, origin='https://example.com')[0], 403)
        self.assertEqual(self.request(host='example.com')[0], 403)
        self.assertEqual(self.snapshot(), state)

    def test_serves_only_the_summary_page_and_health(self):
        status, body = self.request('/')
        self.assertEqual(status, 200)
        self.assertIn('绿建智能生产'.encode(), body)
        self.assertEqual(self.request('/health')[0], 200)
        for path in ('/server.py', '/data/summary.sqlite3', '/../09-%E8%B5%84%E6%96%99/', '/api/unknown'):
            self.assertEqual(self.request(path)[0], 404, path)


if __name__ == '__main__':
    unittest.main()
