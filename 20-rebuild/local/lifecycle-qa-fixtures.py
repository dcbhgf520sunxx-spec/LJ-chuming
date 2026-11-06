#!/usr/bin/env python3
"""Prepare/assert/clean dedicated annual rollover fixtures only in the disposable lifecycle QA database."""
import json,sys
from pathlib import Path
from provision import mysql,ROOT
DATABASE='plm7_rebuild_qa_lifecycle';ID=8900002000001
assert DATABASE.startswith('plm7_rebuild_qa_')
MODE=sys.argv[1]
if MODE=='prepare':
 for table in ('contract_project','project_manage_behavior_total_score','mes_behavior_total_score'):
  assert mysql('SELECT COUNT(*) FROM '+DATABASE+'.'+table+' WHERE id='+str(ID)+';')=='0'
 assert mysql('SELECT COUNT(*) FROM '+DATABASE+'.mes_roster;')=='0'
 checksum=mysql('CHECKSUM TABLE '+DATABASE+'.sys_user;').split('\t')[-1]
 mysql("INSERT INTO "+DATABASE+".contract_project(id,name,serial_number,status,settlement_status,start_date,contract_sign_body_id,user_id) VALUES("+str(ID)+",'rebuild_lifecycle_qa_only','rebuild_lifecycle_qa_only',1,0,CURRENT_DATE(),2,1);")
 for table,columns,values in [('mes_behavior_total_score','', ''),('project_manage_behavior_total_score',',project_id',','+str(ID))]:
  mysql('INSERT INTO '+DATABASE+'.'+table+'(id,year,total_score,bool_deduction'+columns+') VALUES('+str(ID)+',YEAR(CURRENT_DATE())-1,73,0'+values+');')
 evidence={'scope':'Dedicated annual rollover fixtures; total_score=73 is arbitrary test data, not a default business rule','fixture_id':ID,'sys_user_checksum_before':checksum,'prepared':True}
 (ROOT/'runtime/lifecycle-qa/annual-fixtures.json').write_text(json.dumps(evidence,indent=2)+'\n');print('Independent annual rollover fixtures prepared; no existing account changed.')
elif MODE=='verify':
 evidence=json.loads((ROOT/'runtime/lifecycle-qa/annual-fixtures.json').read_text())
 for table in ('project_manage_behavior_total_score','mes_behavior_total_score'):
  where=' AND project_id='+str(ID) if table.startswith('project_') else ''
  old=mysql('SELECT id,total_score FROM '+DATABASE+'.'+table+' WHERE year=YEAR(CURRENT_DATE())-1'+where+';').split('\t')
  current=mysql('SELECT id,total_score FROM '+DATABASE+'.'+table+' WHERE year=YEAR(CURRENT_DATE())'+where+';').split('\t')
  assert old==[str(ID),'73'] and len(current)==2 and current[0]!=str(ID) and current[1]=='73'
  evidence[table]={'previous_year_preserved':True,'new_primary_key':True,'same_configured_score':True}
 evidence['empty_roster_did_not_enable_all_users']=evidence['sys_user_checksum_before']==mysql('CHECKSUM TABLE '+DATABASE+'.sys_user;').split('\t')[-1]
 assert evidence['empty_roster_did_not_enable_all_users']
 (ROOT.parent/'docs/annual-rollover-verification.json').write_text(json.dumps(evidence,ensure_ascii=False,indent=2)+'\n');print(json.dumps(evidence,ensure_ascii=False,indent=2))
elif MODE=='cleanup':
 mysql('DELETE FROM '+DATABASE+'.project_manage_behavior_total_score WHERE project_id='+str(ID)+';DELETE FROM '+DATABASE+'.mes_behavior_total_score WHERE total_score=73 AND id>='+str(ID)+';DELETE FROM '+DATABASE+".contract_project WHERE id="+str(ID)+" AND name='rebuild_lifecycle_qa_only';")
 print('Dedicated QA annual fixtures removed.')
else:raise ValueError('prepare / verify / cleanup')
