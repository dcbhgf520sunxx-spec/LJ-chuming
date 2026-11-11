#!/usr/bin/env python3
"""Convert a Tekla IFC into a locally viewable GLB and assembly index."""
import argparse
import json
from pathlib import Path
import shutil
import struct
import subprocess
import tempfile

import ifcopenshell
from ifcopenshell import geom
from ifcopenshell.util.element import get_psets
from ifcopenshell.util.shape import get_vertices

def convert(source, destination, gltfpack, supplement):
    model = ifcopenshell.open(str(source))
    products = [element for element in model.by_type("IfcElement")
                if not element.is_a("IfcFeatureElementSubtraction") and element.Representation]
    destination.mkdir(parents=True, exist_ok=True)
    with tempfile.TemporaryDirectory(prefix="ifc-convert-") as workspace:
        raw = Path(workspace) / "raw.glb"
        settings = geom.settings()
        settings.set("apply-default-materials", True)
        settings.set("use-element-guids", True)
        serializer = geom.serializers.gltf(str(raw), settings)
        serializer.setFile(model)
        serializer.setUnitNameAndMagnitude("METER", 1.0)
        serializer.writeHeader()
        iterator = geom.iterator(settings, model, 4, include=products)
        written = set()
        if not iterator.initialize():
            raise ValueError("IFC 没有可转换的三维几何")
        while True:
            shape = iterator.get()
            written.add(shape.guid)
            serializer.write(shape)
            if not iterator.next():
                break
        serializer.finalize()
        del serializer
        with raw.open("rb") as stream:
            length = struct.unpack("<4sIII4s", stream.read(20))[3]
            raw_gltf = json.loads(stream.read(length))
        written = {node["name"] for node in raw_gltf["nodes"] if "mesh" in node}
        extra = json.loads(supplement.read_text()) if supplement else []
        extra_ids = {item["id"] for item in extra}
        if written & extra_ids:
            raise ValueError("补充几何与已有元素重复")
        missing = [element for element in products if element.GlobalId not in written | extra_ids]
        if missing:
            bounds_settings = geom.settings()
            bounds_settings.set("use-world-coords", True)
            bounds_settings.set("disable-opening-subtractions", True)
            candidates = []
            for element in missing:
                shape = geom.create_shape(bounds_settings, element)
                vertices = get_vertices(shape.geometry)
                if not len(vertices):
                    raise ValueError("缺失几何无法取得尺寸 " + element.GlobalId)
                low, high = vertices.min(axis=0), vertices.max(axis=0)
                candidates.append({"step": element.id(), "id": element.GlobalId,
                                   "bounds": [[low[0], low[2], -high[1]], [high[0], high[2], -low[1]]]})
            request = Path(workspace) / "missing.json"
            request.write_text(json.dumps(candidates))
            recovered = Path(workspace) / "recovered.json"
            subprocess.run(["node", str(Path(__file__).with_name("repair.mjs")), str(source.resolve()),
                            str(request), str(recovered)], check=True)
            extra.extend(json.loads(recovered.read_text()))
            extra_ids = {item["id"] for item in extra}
        index = {"parts": {}, "assemblies": [], "extraMeshes": extra}
        geometry_ids = written | extra_ids
        for assembly in model.by_type("IfcElementAssembly"):
            properties = get_psets(assembly)
            fields = {key: value for values in properties.values() if isinstance(values, dict) for key, value in values.items()}
            mark = fields.get("Assembly/Cast unit Mark") or fields.get("Assembly mark") or fields.get("Assembly_mark")
            if not mark:
                raise ValueError("构件缺少编号 " + assembly.GlobalId)
            stack = [assembly]
            members = []
            while stack:
                element = stack.pop()
                if element.GlobalId in geometry_ids:
                    members.append(element.GlobalId)
                    index["parts"][element.GlobalId] = [assembly.GlobalId, mark]
                for relation in element.IsDecomposedBy:
                    stack.extend(relation.RelatedObjects)
            index["assemblies"].append({"id": assembly.GlobalId, "mark": mark,
                                        "position": fields.get("Assembly/Cast unit position code"), "members": members})
        if not index["assemblies"]:
            raise ValueError("IFC 缺少构件组合，需要配置构件编号映射")
        subprocess.run([str(gltfpack), "-kn", "-noq", "-c", "-i", str(raw),
                        "-o", str(destination / "model.glb")], check=True)
        with (destination / "model.glb").open("rb") as stream:
            length = struct.unpack("<4sIII4s", stream.read(20))[3]
            gltf = json.loads(stream.read(length))
        optimized = {node.get("name") for node in gltf["nodes"]}
        if not written <= optimized:
            raise ValueError("压缩后的模型丢失元素标识")
        (destination / "index.json").write_text(json.dumps(index, ensure_ascii=False, separators=(",", ":")))
        print(json.dumps({"geometryElements": len(geometry_ids), "assemblies": len(index["assemblies"]),
                          "supplementedElements": len(extra)}, ensure_ascii=False))

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("--ifc", type=Path, required=True)
    parser.add_argument("--output", type=Path, required=True)
    parser.add_argument("--gltfpack", type=Path, default=shutil.which("gltfpack"))
    parser.add_argument("--supplement", type=Path)
    args = parser.parse_args()
    if not args.gltfpack:
        parser.error("需要 --gltfpack 指定 gltfpack 可执行文件")
    convert(args.ifc, args.output, args.gltfpack, args.supplement)
