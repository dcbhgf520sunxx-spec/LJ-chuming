import json
from pathlib import Path
import struct
import tempfile
import unittest
from publish import publish

class PublishTests(unittest.TestCase):
    def test_atomic_publish_and_rejected_geometry_preserve_current(self):
        with tempfile.TemporaryDirectory() as workspace:
            root = Path(workspace)
            geometry = root / "input.glb"
            source = {"asset": {"version": "2.0"}, "nodes": [{"name": "part"}], "buffers": []}
            data = json.dumps(source).encode()
            data += b" " * (-len(data) % 4)
            geometry.write_bytes(struct.pack("<4sIII4s", b"glTF", 2, 20 + len(data), len(data), b"JSON") + data)
            index = {"parts": {"part": ["assembly", "GZ-1"]}, "assemblies": [{"id": "assembly", "mark": "GZ-1"}]}
            revision = publish(root / "models", 1, 2, 3, geometry, index)
            area = root / "models/1/2/3"
            self.assertEqual((area / "current").read_text().strip(), revision)
            self.assertEqual(publish(root / "models", 1, 2, 3, geometry, index), revision)
            index["parts"]["missing"] = ["assembly", "GZ-1"]
            with self.assertRaises(ValueError):
                publish(root / "models", 1, 2, 3, geometry, index)
            self.assertEqual((area / "current").read_text().strip(), revision)
            with self.assertRaises(ValueError):
                publish(root / "models", -1, 2, 3, geometry, index)

if __name__ == "__main__":
    unittest.main()
