import hashlib
import importlib.util
import json
from pathlib import Path
import tempfile
import unittest

sp=importlib.util.spec_from_file_location("registration",Path(__file__).parents[1]/"tools/record-source-change.py")
registration=importlib.util.module_from_spec(sp);sp.loader.exec_module(registration)


class SourceRegistrationTest(unittest.TestCase):
    def setUp(self):
        temp=tempfile.TemporaryDirectory();self.addCleanup(temp.cleanup);self.root=Path(temp.name)
        (self.root/"source-modules.json").write_text('["example"]')
        for name in ("source-provenance.json","resource-provenance.json"):(self.root/name).write_text('[]')
    def test_source_add_modify_delete_retains_origin_and_history(self):
        path=self.root/"modules/example/src/main/java/Test.java";path.parent.mkdir(parents=True);path.write_text("class Test {}")
        registration.register(self.root,"example","Add owned implementation")
        file=self.root/"source-provenance.json";first=json.loads(file.read_text())[0];self.assertIsNone(first["original_source_sha256"])
        path.write_text("class Test { int version; }");registration.register(self.root,"example","Change implementation")
        path.unlink();registration.register(self.root,"example","Remove superseded implementation")
        value=json.loads(file.read_text())[0];self.assertTrue(value["deleted"]);self.assertIsNone(value["original_source_sha256"]);self.assertEqual(len(value["adjustments"]),3)
    def test_resource_change_preserves_original_digest(self):
        path=self.root/"modules/example/src/main/resources/mapper/Test.xml";path.parent.mkdir(parents=True);path.write_bytes(b"old SQL")
        original=hashlib.sha256(path.read_bytes()).hexdigest();file=self.root/"resource-provenance.json"
        file.write_text(json.dumps([{"module":"example","path":"mapper/Test.xml","sha256":original,"source":"original artifact"}]))
        path.write_bytes(b"new SQL");registration.register(self.root,"example","Fix mapper condition")
        value=json.loads(file.read_text())[0];self.assertEqual(value["original_sha256"],original);self.assertNotEqual(value["sha256"],original)
    def test_dry_run_does_not_register_and_bytecode_is_refused(self):
        path=self.root/"modules/example/src/main/resources/unlisted.txt";path.parent.mkdir(parents=True);path.write_text("new")
        self.assertTrue(registration.register(self.root,"example","Add resource",True));self.assertEqual(json.loads((self.root/"resource-provenance.json").read_text()),[])
        path.with_suffix(".class").write_bytes(b"original bytecode")
        with self.assertRaisesRegex(ValueError,"cannot contain"):registration.register(self.root,"example","Disallowed bytecode")
