#!/usr/bin/env python3
"""Explicitly record source/resource edits while retaining original evidence hashes."""
import argparse
import hashlib
import json
from pathlib import Path

ROOT=Path(__file__).resolve().parents[1]


def register(root,module,note,dry_run=False):
    if module not in json.loads((root/"source-modules.json").read_text()):raise ValueError("Unknown source module")
    if not note.strip():raise ValueError("A concrete change note is required")
    changes=[];updates=[]
    for kind,filename,folder in [("source","source-provenance.json","src/main/java"),("resource","resource-provenance.json","src/main/resources")]:
        file=root/filename;records=json.loads(file.read_text());base=root/"modules"/module/folder
        actual={str(p.relative_to(base)):p for p in base.rglob("*") if p.is_file() and (kind!="source" or p.suffix==".java")}
        if kind=="resource" and any(p.suffix.lower() in (".class",".jar") for p in actual.values()):
            raise ValueError("Runtime resources cannot contain class or JAR bytecode")
        selected={item["path"]:item for item in records if item["module"]==module}
        for path in sorted(set(selected)|set(actual)):
            item=selected.get(path);exists=path in actual
            current=hashlib.sha256(actual[path].read_bytes()).hexdigest() if exists else None
            field="rebuilt_source_sha256" if kind=="source" else "sha256"
            if item and current==item.get(field) and item.get("deleted",False)==(not exists):continue
            if item is None:
                item={"module":module,"path":path,"origin":"new-development","adjustments":[]}
                if kind=="source":item["original_source_sha256"]=None
                else:item.update(original_sha256=None,source="new-development")
                records.append(item)
            if kind=="resource" and "original_sha256" not in item:item["original_sha256"]=item.get("sha256")
            item[field]=current;item["deleted"]=not exists;item.setdefault("adjustments",[]).append(note.strip())
            changes.append({"kind":kind,"module":module,"path":path,"status":"deleted" if not exists else "updated"})
        updates.append((file,records))
    if not dry_run:
        for file,records in updates:file.write_text(json.dumps(records,ensure_ascii=False,indent=2)+"\n")
    return changes


def main():
    parser=argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--module",required=True);parser.add_argument("--note",required=True)
    parser.add_argument("--dry-run",action="store_true");args=parser.parse_args()
    changes=register(ROOT,args.module,args.note,args.dry_run)
    print(json.dumps({"dry_run":args.dry_run,"changes":changes},ensure_ascii=False,indent=2))


if __name__=="__main__":main()
