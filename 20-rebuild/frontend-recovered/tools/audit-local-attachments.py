from pathlib import Path
import json,hashlib,datetime
p=Path(__file__).resolve().parent.parent;r=p.parent.parent
manifest=r/'20-rebuild/local/runtime/attachment-provenance.json';rows=json.loads(manifest.read_text());files=r/'20-rebuild/local/runtime/files'
verified=0
for row in rows:
 target=files/row['path']
 if target.is_file() and hashlib.sha256(target.read_bytes()).hexdigest()==row['sha256']==row['copied_sha256']:verified+=1
missing=['/files/config/1749624658783_logo-zhongnan-title-preview.jpg']+['/files/MemberSectionImg/'+n+'.jpg' for n in ['round-tubes','H-beam','square-tube','unequal-angles','rectangular-tubes','T-beam','round','channel','I-beams','steel-plate']]
assert all(not(files/rel.removeprefix('/files/')).exists() for rel in missing)
report={'verified_at':datetime.datetime.now(datetime.timezone.utc).isoformat(),'backed_up_attachments':len(rows),'original_sha256_matches_local_files':verified,'source_manifest_sha256':hashlib.sha256(manifest.read_bytes()).hexdigest(),'observed_missing_attachments':missing,'alias_scope':'Only known historical deployment origins and pathname /files/; all JSON-success response fields recursively normalized, without DB mutation.','remote_downloads':False,'substitute_assets':False,'csp_relaxed':False,'actual_missing_file_http_status_expected':404,'browser_verified':False,'limitations':['28 copied filenames are retained in the private provenance manifest, not this public summary.','Missing attachments must be supplied as the actual original files or explicitly reuploaded by the user.','Other external systems/BIM endpoints remain distinct and are not redirected.']}
assert verified==len(rows)
(r/'20-rebuild/docs/frontend-local-attachment-audit.json').write_text(json.dumps(report,ensure_ascii=False,indent=2)+'\n');print({'backed_up':len(rows),'sha256_verified':verified,'observed_missing':len(missing)})
