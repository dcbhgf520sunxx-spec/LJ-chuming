import hashlib
import importlib.util
import json
from pathlib import Path
import tempfile
import unittest
import zipfile


spec = importlib.util.spec_from_file_location("source_build", Path(__file__).parents[1] / "tools/build.py")
build = importlib.util.module_from_spec(spec)
spec.loader.exec_module(build)


class DependencyGuardTest(unittest.TestCase):
    def setUp(self):
        self.folder = tempfile.TemporaryDirectory()
        self.addCleanup(self.folder.cleanup)
        self.original_root = build.ROOT
        self.addCleanup(setattr, build, "ROOT", self.original_root)
        build.ROOT = Path(self.folder.name)
        (build.ROOT / ".deps").mkdir()

    def dependency(self, entry):
        path = build.ROOT / ".deps/library.jar"
        with zipfile.ZipFile(path, "w") as archive:
            archive.writestr(entry, b"fixture")
        lock = [{"file": path.name, "sha256": hashlib.sha256(path.read_bytes()).hexdigest()}]
        (build.ROOT / "thirdparty-lock.json").write_text(json.dumps(lock))
        return path

    def test_accepts_locked_thirdparty_bytecode(self):
        self.dependency("org/example/Library.class")
        self.assertEqual(len(build.validate_dependencies()), 1)

    def test_rejects_own_bytecode_inside_an_ordinary_jar_name(self):
        self.dependency("com/hzchum/pangu/common/Original.class")
        with self.assertRaisesRegex(RuntimeError, "Original business bytecode"):
            build.validate_dependencies()

    def test_rejects_tampered_locked_dependency(self):
        path = self.dependency("org/example/Library.class")
        with path.open("ab") as stream:
            stream.write(b"changed")
        with self.assertRaisesRegex(RuntimeError, "Unapproved dependency"):
            build.validate_dependencies()

    def test_rejects_unlisted_dependency(self):
        self.dependency("org/example/Library.class")
        (build.ROOT / ".deps/unlisted.jar").write_bytes(b"unknown")
        with self.assertRaisesRegex(RuntimeError, "differs from the lock"):
            build.validate_dependencies()

    def test_failed_dependency_validation_invalidates_previous_build_products(self):
        path = self.dependency("org/example/Library.class")
        path.write_bytes(b"changed")
        target = build.ROOT / "target"
        target.mkdir()
        (target / "build-report.json").write_text('{"parity_cases_passed": 9}')
        (target / "pangu-common.jar").write_bytes(b"previous product")
        with self.assertRaisesRegex(RuntimeError, "Unapproved dependency"):
            build.main()
        self.assertFalse((target / "build-report.json").exists())
        self.assertFalse((target / "pangu-common.jar").exists())

    def resource(self):
        path=build.ROOT / "modules" / build.MODULES[0] / "src/main/resources/mapper/TestMapper.xml"
        path.parent.mkdir(parents=True);path.write_bytes(b"<mapper/>")
        (build.ROOT / "resource-provenance.json").write_text(json.dumps([{"module":build.MODULES[0],"path":"mapper/TestMapper.xml","sha256":hashlib.sha256(path.read_bytes()).hexdigest()}]))
        return path

    def test_accepts_traced_runtime_resource(self):
        self.resource()
        self.assertEqual(build.validate_resources()["resources"],1)

    def test_rejects_changed_resource(self):
        self.resource().write_bytes(b"changed SQL")
        with self.assertRaisesRegex(RuntimeError,"differs from its source record"):
            build.validate_resources()

    def test_rejects_unlisted_runtime_resource(self):
        path=self.resource();(path.parent/"unlisted.xml").write_bytes(b"unknown")
        with self.assertRaisesRegex(RuntimeError,"inventory differs"):
            build.validate_resources()

    def packaged_resource(self, value):
        folder=build.ROOT/"products";folder.mkdir()
        with zipfile.ZipFile(folder/(build.MODULES[0]+".jar"),"w") as archive:
            archive.writestr("META-INF/MANIFEST.MF",b"Manifest-Version: 1.0\n")
            archive.writestr("mapper/TestMapper.xml",value)
        return folder

    def test_accepts_matching_packaged_resource(self):
        path=self.resource();folder=self.packaged_resource(path.read_bytes())
        self.assertEqual(build.validate_packaged_resources(folder,[build.MODULES[0]]),1)

    def test_rejects_registered_new_source_with_old_packaged_xml(self):
        self.resource();folder=self.packaged_resource(b"older SQL despite valid source registration")
        with self.assertRaisesRegex(RuntimeError,"recompile module"):
            build.validate_packaged_resources(folder,[build.MODULES[0]])

    def test_rejects_deleted_resource_still_present_in_jar(self):
        path=self.resource();folder=self.packaged_resource(path.read_bytes())
        records=json.loads((build.ROOT/"resource-provenance.json").read_text());records[0]["deleted"]=True
        (build.ROOT/"resource-provenance.json").write_text(json.dumps(records))
        with self.assertRaisesRegex(RuntimeError,"recompile module"):
            build.validate_packaged_resources(folder,[build.MODULES[0]])


if __name__ == "__main__":
    unittest.main()
