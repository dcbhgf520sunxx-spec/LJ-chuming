#!/usr/bin/env python3
"""Exercise the repaired legacy task-order list only on the disposable lifecycle QA database."""
from pathlib import Path
import json,subprocess,base64,sys
from provision import mysql,ROOT
CONTAINER='ljaps-lifecycle-qa-backend';DATABASE='plm7_rebuild_qa_lifecycle';QA=ROOT/'runtime/lifecycle-qa'
def command(*args,**kw):return subprocess.run(args,check=True,stdout=subprocess.PIPE,stderr=subprocess.PIPE,**kw)
def call(path,token=None,method='GET',data=None):
 request=dict(path=path,method=method)
 if token:request['token']=token
 if data is not None:request['data']=data
 raw=command('docker','exec','-i',CONTAINER,'java','-cp','/evidence:/app/lib/*','ContainerHttp',input=json.dumps(request).encode()).stdout
 value=json.loads(raw);value['body']=json.loads(base64.b64decode(value['bodyBase64']));return value
def main():
 source=ROOT.parent/'standalone/ContainerHttp.java'
 (QA/'evidence/ContainerHttp.java').write_text(source.read_text().replace('http://web','http://127.0.0.1:8080'))
 command('docker','exec',CONTAINER,'javac','-cp','/app/lib/*','/evidence/ContainerHttp.java')
 # The helper's Accept must match the original Axios JSON client, not the JVM's text/html default.
 assert '"Accept", "application/json"' in source.read_text() or '"Accept","application/json"' in source.read_text()
 value=call('/api/user/public-key')
 if 'body' in value and isinstance(value['body'],dict):body=value['body']
 else:body=json.loads(value['body'])
 public=QA/'public.pem';public.write_text(body['data']['publicKey'])
 fixture=dict(x.split('=',1) for x in (ROOT.parents[1]/'10-reverse/local/.env').read_text().splitlines() if '=' in x)
 cipher=command('openssl','pkeyutl','-encrypt','-pubin','-inkey',str(public),'-pkeyopt','rsa_padding_mode:pkcs1',input=fixture['LOCAL_WEB_PASSWORD'].encode()).stdout
 response=call('/api/user/login',method='POST',data=dict(username=fixture['LOCAL_WEB_USERNAME'],password=base64.b64encode(cipher).decode()))
 value=response['body'];value=json.loads(value) if isinstance(value,str) else value
 assert value['code']==20000;token=value['data']['token'];report=[]
 prefix='rebuild_order_qa_'
 assert mysql("SELECT COUNT(*) FROM "+DATABASE+".mes_building_task_order WHERE id BETWEEN 8900001000000 AND 8900001000099;")=='0'
 rows=[]
 for index,kind in enumerate((1,2,4,8,16,32,64)):
  for offset in range(4):
   identity=8900001000000+index*10+offset
   rows.append("("+str(identity)+","+str(kind)+",1,'"+prefix+str(identity)+"')")
 mysql("INSERT INTO "+DATABASE+".mes_building_task_order(id,task_type_enum,user_id,order_number) VALUES"+','.join(rows)+";")
 try:
  for kind in (1,2,4,8,16,64):
   previous=None
   for page in (1,2):
    response=call('/api/mes/building/task/order/page?taskTypeEnum='+str(kind)+'&pageNumber='+str(page)+'&pageSize=3',token)
    body=response['body'];body=json.loads(body) if isinstance(body,str) else body
    assert response['status']==200 and body['code']==20000, (kind,page,body.get('code'))
    data=body['data'];mask=48 if kind==16 else kind
    total=int(mysql('SELECT COUNT(*) FROM '+DATABASE+'.mes_building_task_order WHERE task_type_enum & '+str(mask)+';'))
    assert data['totalElements']==total,(kind,total,data.get('totalElements'))
    ids=[int(x['id']) for x in data.get('content',[])]
    if ids:
     assert int(mysql('SELECT COUNT(*) FROM '+DATABASE+'.mes_building_task_order WHERE id IN ('+','.join(map(str,ids))+') AND task_type_enum & '+str(mask)+';'))==len(ids)
    assert len(ids)==min(3,max(0,total-(page-1)*3))
    if previous:assert set(previous).isdisjoint(ids)
    previous=ids
    report.append(dict(taskTypeEnum=kind,page=page,matching_database_total=total,returned=len(ids)))
  for suffix in ('','?taskTypeEnum=0','?taskTypeEnum=3','?taskTypeEnum=32','?taskTypeEnum=999'):
   response=call('/api/mes/building/task/order/page'+suffix,token);body=response['body'];body=json.loads(body) if isinstance(body,str) else body
   assert body['code']!=20000 and body['message']=='任务类型不正确'
  result=dict(scope='Independent lifecycle QA database; read-only task-order queries, no source or main rebuilt database writes',cases=report,invalid_types_rejected=5,passed=True)
  (ROOT.parent/'docs/task-order-query-verification.json').write_text(json.dumps(result,ensure_ascii=False,indent=2)+'\n');print(json.dumps(result,ensure_ascii=False,indent=2))
 finally:
  call('/api/user/logout',token,'POST',{})
  mysql("DELETE FROM "+DATABASE+".mes_building_task_order WHERE id BETWEEN 8900001000000 AND 8900001000099 AND order_number LIKE 'rebuild_order_qa_%';")
  assert mysql("SELECT COUNT(*) FROM "+DATABASE+".mes_building_task_order WHERE id BETWEEN 8900001000000 AND 8900001000099;")=='0'
  if 'result' in locals():
   result['qa_fixture_rows']=28;result['fixture_cleanup']=True
   (ROOT.parent/'docs/task-order-query-verification.json').write_text(json.dumps(result,ensure_ascii=False,indent=2)+'\n')
if __name__=='__main__':main()
