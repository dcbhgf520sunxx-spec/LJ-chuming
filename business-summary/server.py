#!/usr/bin/env python3
"""梳理页及其 SQLite 存储；只提供本机访问，不依赖重建系统。"""
import argparse
import hashlib
import json
import sqlite3
from contextlib import contextmanager
from html.parser import HTMLParser
from http.server import BaseHTTPRequestHandler, ThreadingHTTPServer
from pathlib import Path
from urllib.parse import unquote, urlsplit


ROOT = Path(__file__).resolve().parent
STATUSES = {'已确认', '待核实', '待补充', '暂不纳入', '暂缓'}


def encode(value):
    return json.dumps(value, ensure_ascii=False, sort_keys=True)


class SourceFields(HTMLParser):
    def __init__(self, text):
        super().__init__(convert_charrefs=True)
        self.fields = {}
        self.active = None
        self.feed(text)
        if not self.fields:
            raise ValueError('业务文档缺少可编辑字段')

    def handle_starttag(self, tag, attrs):
        key = dict(attrs).get('data-field')
        if key:
            if key in self.fields or self.active:
                raise ValueError('业务字段标识重复或嵌套')
            self.active = (tag, key, [])

    def handle_data(self, text):
        if self.active:
            self.active[2].append(text)

    def handle_endtag(self, tag):
        if self.active and tag == self.active[0]:
            _, key, parts = self.active
            self.fields[key] = ''.join(parts)
            self.active = None


class Store:
    def __init__(self, document, database):
        self.document = Path(document)
        self.database = Path(database)
        self.database.parent.mkdir(parents=True, exist_ok=True)
        with self.connect() as connection:
            connection.execute('PRAGMA journal_mode=WAL')
            connection.execute('''CREATE TABLE IF NOT EXISTS pms_business_summary (
                id INTEGER PRIMARY KEY CHECK (id=1),
                revision INTEGER NOT NULL,
                fields_json TEXT NOT NULL,
                source_json TEXT NOT NULL,
                updated_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP
            )''')
        self.load()

    @contextmanager
    def connect(self):
        connection = sqlite3.connect(self.database, timeout=5)
        connection.row_factory = sqlite3.Row
        try:
            with connection:
                yield connection
        finally:
            connection.close()

    def sync_source(self, connection):
        seed = SourceFields(self.document.read_text(encoding='utf-8')).fields
        row = connection.execute('SELECT * FROM pms_business_summary WHERE id=1').fetchone()
        if row is None:
            connection.execute('''INSERT INTO pms_business_summary
                (id, revision, fields_json, source_json) VALUES (1, 0, ?, ?)''',
                (encode(seed), encode(seed)))
        elif json.loads(row['source_json']) != seed:
            old_seed = json.loads(row['source_json'])
            fields = json.loads(row['fields_json'])
            # 源文档更新时，只刷新未手工改动的字段，避免覆盖已核实结果。
            for key, value in seed.items():
                if key not in fields or fields[key] == old_seed.get(key):
                    fields[key] = value
            connection.execute('''UPDATE pms_business_summary SET
                revision=revision+1, fields_json=?, source_json=?, updated_at=CURRENT_TIMESTAMP
                WHERE id=1''', (encode(fields), encode(seed)))
        row = connection.execute('SELECT * FROM pms_business_summary WHERE id=1').fetchone()
        fields = json.loads(row['fields_json'])
        return {
            'revision': row['revision'],
            'sourceHash': hashlib.sha256(encode(seed).encode()).hexdigest(),
            'fields': {key: fields[key] for key in seed}
        }

    def load(self):
        with self.connect() as connection:
            connection.execute('BEGIN IMMEDIATE')
            return self.sync_source(connection)

    def save(self, payload):
        with self.connect() as connection:
            connection.execute('BEGIN IMMEDIATE')
            current = self.sync_source(connection)
            if not isinstance(payload, dict) or type(payload.get('revision')) is not int:
                raise ValueError('保存数据格式不正确')
            fields = payload.get('fields')
            if not isinstance(fields, dict) or fields.keys() != current['fields'].keys():
                raise ValueError('节点字段不完整或与当前文档不一致')
            for key, value in fields.items():
                if not isinstance(value, str) or len(value) > 20000:
                    raise ValueError('单个字段须为文字且不超过 20000 字')
                if '.status.' in key and value not in STATUSES:
                    raise ValueError('核实状态不正确')
            if (payload['revision'] != current['revision'] or
                    payload.get('sourceHash') != current['sourceHash']):
                return None
            stored = json.loads(connection.execute(
                'SELECT fields_json FROM pms_business_summary WHERE id=1').fetchone()[0])
            stored.update(fields)
            connection.execute('''UPDATE pms_business_summary SET revision=revision+1,
                fields_json=?, updated_at=CURRENT_TIMESTAMP WHERE id=1''', (encode(stored),))
            return {**current, 'revision': current['revision'] + 1, 'fields': fields}


def create_server(document, database, port=3121):
    store = Store(document, database)

    class Handler(BaseHTTPRequestHandler):
        def reply(self, status, payload, content_type='application/json; charset=utf-8'):
            body = payload if isinstance(payload, bytes) else encode(payload).encode()
            self.send_response(status)
            self.send_header('Content-Type', content_type)
            self.send_header('Content-Length', str(len(body)))
            self.send_header('Cache-Control', 'no-store')
            self.send_header('X-Content-Type-Options', 'nosniff')
            self.end_headers()
            self.wfile.write(body)

        def local_request(self):
            expected = '127.0.0.1:' + str(self.server.server_address[1])
            if self.headers.get('Host') != expected:
                self.reply(403, {'message': '仅允许本机页面访问'})
                return False
            origin = self.headers.get('Origin')
            if origin and origin != 'http://' + expected:
                self.reply(403, {'message': '不允许来自其他页面的请求'})
                return False
            return True

        def do_GET(self):
            if not self.local_request():
                return
            path = unquote(urlsplit(self.path).path)
            try:
                if path in ('/', '/' + store.document.name):
                    self.reply(200, store.document.read_bytes(), 'text/html; charset=utf-8')
                elif path == '/api/nodes':
                    self.reply(200, store.load())
                elif path == '/health':
                    store.load()
                    self.reply(200, {'status': 'ok', 'storage': 'sqlite'})
                else:
                    self.reply(404, {'message': '页面不存在'})
            except (OSError, sqlite3.Error, ValueError):
                self.reply(503, {'message': '业务数据暂时无法读取，请稍后重试'})

        def do_PUT(self):
            if not self.local_request():
                return
            if urlsplit(self.path).path != '/api/nodes':
                self.reply(404, {'message': '接口不存在'})
                return
            if (self.headers.get('X-LJ-APS-Editor') != '1' or
                    self.headers.get('Content-Type', '').split(';')[0] != 'application/json'):
                self.reply(403, {'message': '请通过业务页面保存'})
                return
            try:
                length = int(self.headers.get('Content-Length', '0'))
                if not 0 < length <= 2 * 1024 * 1024:
                    self.reply(413, {'message': '保存内容超出允许大小'})
                    return
                self.connection.settimeout(15)
                result = store.save(json.loads(self.rfile.read(length)))
                if result is None:
                    self.reply(409, {'message': '内容已被其他页面或资料更新。修改仍保留，请复制当前修改后刷新核对。'})
                else:
                    self.reply(200, result)
            except (ValueError, UnicodeError) as error:
                self.reply(400, {'message': str(error)})
            except (OSError, sqlite3.Error):
                self.reply(503, {'message': '数据库暂时无法保存，当前修改仍保留，请重试'})

    return ThreadingHTTPServer(('127.0.0.1', port), Handler)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--port', type=int, default=3121)
    parser.add_argument('--document', type=Path, default=ROOT.parent / '绿建智能生产业务梳理.html')
    parser.add_argument('--database', type=Path, default=ROOT / 'data' / 'summary.sqlite3')
    args = parser.parse_args()
    server = create_server(args.document, args.database, args.port)
    print('业务梳理：http://127.0.0.1:' + str(server.server_address[1]), flush=True)
    try:
        server.serve_forever()
    except KeyboardInterrupt:
        pass
    finally:
        server.server_close()
