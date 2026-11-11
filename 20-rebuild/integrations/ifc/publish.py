#!/usr/bin/env python3
"""Publish a verified GLB and IFC index as an immutable model version."""
import argparse
import hashlib
import json
import os
from pathlib import Path
import shutil
import struct
import tempfile

def publish(root, project, monomer, area, geometry, index):
    if min(project, monomer, area) <= 0:
        raise ValueError("项目、单体、区域 ID 必须为正整数")
    geometry = Path(geometry)
    with geometry.open("rb") as stream:
        header = stream.read(20)
        if len(header) != 20:
            raise ValueError("GLB 文件不完整")
        magic, version, size, length, kind = struct.unpack("<4sIII4s", header)
        if magic != b"glTF" or version != 2 or size != geometry.stat().st_size or kind != b"JSON":
            raise ValueError("GLB 文件格式或长度错误")
        gltf = json.loads(stream.read(length))
    if any(item.get("uri") for item in gltf.get("buffers", [])):
        raise ValueError("GLB 必须包含完整的模型数据")
    names = {node.get("name") for node in gltf["nodes"]}
    names.update(item["id"] for item in index.get("extraMeshes", []))
    if not isinstance(index.get("parts"), dict) or not isinstance(index.get("assemblies"), list):
        raise ValueError("缺少 IFC 构件索引")
    mapped = set(index["parts"])
    if not mapped <= names:
        raise ValueError("部分构件编号未对应到实际几何")
    if not index["assemblies"] or any(not item.get("id") for item in index["assemblies"]):
        raise ValueError("构件清单为空或缺少唯一标识")
    body = json.dumps(index, ensure_ascii=False, separators=(",", ":")).encode()
    digest = hashlib.sha256(body)
    with geometry.open("rb") as stream:
        for chunk in iter(lambda: stream.read(1024 * 1024), b""):
            digest.update(chunk)
    revision = digest.hexdigest()
    root = Path(root).resolve()
    root.mkdir(parents=True, exist_ok=True, mode=0o700)
    target = root / str(project) / str(monomer) / str(area)
    target.mkdir(parents=True, exist_ok=True)
    stage = Path(tempfile.mkdtemp(prefix=".import-", dir=target))
    try:
        shutil.copyfile(geometry, stage / "model.glb")
        (stage / "index.json").write_bytes(body)
        bundle = target / revision
        if bundle.exists():
            if (bundle / "index.json").read_bytes() != body or hashlib.sha256((bundle / "model.glb").read_bytes()).digest() != hashlib.sha256(geometry.read_bytes()).digest():
                raise ValueError("同版本目录内容不一致")
        else:
            stage.rename(bundle)
        descriptor, pointer = tempfile.mkstemp(prefix=".current-", dir=target)
        with os.fdopen(descriptor, "w") as stream:
            stream.write(revision + "\n")
        os.replace(pointer, target / "current")
    finally:
        if stage.exists():
            shutil.rmtree(stage)
    return revision

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    for name in ("project", "monomer", "area"):
        parser.add_argument("--" + name, type=int, required=True)
    parser.add_argument("--root", type=Path, required=True)
    parser.add_argument("--geometry", type=Path, required=True)
    parser.add_argument("--index", type=Path, required=True)
    args = parser.parse_args()
    print(publish(args.root, args.project, args.monomer, args.area,
                  args.geometry, json.loads(args.index.read_text())))
