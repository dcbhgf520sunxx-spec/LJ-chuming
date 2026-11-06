#!/usr/bin/env python3
"""Read-only main rebuilt database baseline around the explicitly authorized lifecycle activation."""
import sys,json,hashlib
from provision import mysql,ROOT
DB='plm7_rebuild';WHERE="table_schema='"+DB+"' AND LEFT(table_name,8)<>'rebuild_'"
def state():
 names=mysql('SELECT table_name FROM information_schema.tables WHERE '+WHERE+' ORDER BY table_name;').splitlines();out={}
 for i in range(0,len(names),60):
  group=names[i:i+60];values={row.split('\t')[0].split('.',1)[1]:row.split('\t')[1] for row in mysql('CHECKSUM TABLE '+','.join(DB+'.'+table for table in group)+';').splitlines()}
  for table in group:out[table]={'checksum':values[table]}
 schema=mysql("SELECT table_name,ordinal_position,column_name,column_type,is_nullable,COALESCE(column_default,'<NULL>'),extra FROM information_schema.columns WHERE "+WHERE+" ORDER BY table_name,ordinal_position;")
 return dict(database=DB,business_tables=len(names),tables=out,column_schema_sha256=hashlib.sha256(schema.encode()).hexdigest())
def main():
 mode=sys.argv[1];before=ROOT/'runtime/verification/lifecycle-before-state.json';current=state()
 if mode=='before':
  if before.exists():raise RuntimeError('Preserve existing preactivation state; do not overwrite it')
  before.write_text(json.dumps(current,ensure_ascii=False,indent=2)+'\n');print('Read-only lifecycle baseline saved for '+str(current['business_tables'])+' original business tables.')
 elif mode=='after':
  previous=json.loads(before.read_text());diff=[t for t in sorted(set(previous['tables'])|set(current['tables'])) if previous['tables'].get(t)!=current['tables'].get(t)]
  result=dict(scope='Main rebuilt database before/after normal local initializer activation; excludes new rebuild_* runtime tables',business_tables_before=previous['business_tables'],business_tables_after=current['business_tables'],changed_business_tables=diff,column_definitions_identical=previous['column_schema_sha256']==current['column_schema_sha256'],all_business_checksums_identical=not diff)
  result['total_tables_after']=int(mysql("SELECT COUNT(*) FROM information_schema.tables WHERE table_schema='"+DB+"';"))
  report=ROOT.parent/'docs/lifecycle-main-activation-verification.json'
  result['raw_all_checksums_match']=not diff
  if report.exists():
   confirmed=json.loads(report.read_text());expected=confirmed.get('workshop_non_fixture_row_digest')
   if expected and diff==['mes_building_workshop']:
    columns=mysql("SELECT column_name FROM information_schema.columns WHERE table_schema='"+DB+"' AND table_name='mes_building_workshop' ORDER BY ordinal_position;").splitlines()
    expression="SHA2(GROUP_CONCAT(SHA2(JSON_ARRAY("+','.join('`'+c+'`' for c in columns)+"),256) ORDER BY id SEPARATOR ''),256)"
    actual=mysql('SELECT '+expression+' FROM '+DB+'.mes_building_workshop WHERE id<>13;')
    fixture=mysql("SELECT id,name,bool_delete_enum FROM "+DB+".mes_building_workshop WHERE id=13;")
    if actual==expected and fixture=='13\trebuild_ui_w_1792060132825\t1':
     for key in ['confirmed_expected_changes','workshop_non_fixture_row_digest','workshop_excluding_confirmed_fixture_matches_qa_original_rows']:result[key]=confirmed[key]
     result['unchanged_business_table_count']=len(previous['tables'])-1;result['verify_expected_changes']=True
  report.write_text(json.dumps(result,ensure_ascii=False,indent=2)+'\n');print(json.dumps(result,ensure_ascii=False,indent=2))
 else:raise ValueError('before / after')
if __name__=='__main__':main()
