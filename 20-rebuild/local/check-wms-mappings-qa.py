#!/usr/bin/env python3
"""Real HTTP checks of new source-backed WMS mappings; exact original menu permissions on QA fixtures."""
import importlib.util,json,base64
from pathlib import Path
from provision import mysql,ROOT
sp=importlib.util.spec_from_file_location('qa_http',ROOT/'check-task-orders-qa.py');h=importlib.util.module_from_spec(sp);sp.loader.exec_module(h)
DB=h.DATABASE;ID=8900005000001

def sql(s):return mysql(s.replace('{db}',DB).replace('{id}',str(ID)))
def main():
 source=ROOT.parent/'standalone/ContainerHttp.java';(h.QA/'evidence/ContainerHttp.java').write_text(source.read_text().replace('http://web','http://127.0.0.1:8080'));h.command('docker','exec',h.CONTAINER,'javac','-cp','/app/lib/*','/evidence/ContainerHttp.java')
 public=h.QA/'wms-mapping-public.pem';public.write_text(h.call('/api/user/public-key')['body']['data']['publicKey'])
 fixture=dict(x.split('=',1) for x in (ROOT.parents[1]/'10-reverse/local/.env').read_text().splitlines() if '=' in x)
 cipher=base64.b64encode(h.command('openssl','pkeyutl','-encrypt','-pubin','-inkey',str(public),'-pkeyopt','rsa_padding_mode:pkcs1',input=fixture['LOCAL_WEB_PASSWORD'].encode()).stdout).decode()
 def login(username):
  body=h.call('/api/user/login',method='POST',data=dict(username=username,password=cipher))['body'];assert body['code']==20000;return body['data']['token']
 def call(path,token=None,method='GET',data=None):return h.call(path,token,method,data)['body']
 def denied(body):assert body['code']!=20000 and body['message']=='无权限访问'
 admin=login(fixture['LOCAL_WEB_USERNAME']);owner=int(call('/api/user/info',admin)['data']['id']);tables=['sys_user','sys_role','sys_role_menu_link','sys_user_role_link','mes_building_task_order']
 for table in tables:assert sql('SELECT COUNT(*) FROM {db}.'+table+' WHERE id={id};')=='0'
 sql("INSERT INTO {db}.sys_user(id,name,username,password) SELECT {id},'WMS映射验收','wmsmappingcheck',password FROM {db}.sys_user WHERE id="+str(owner)+";INSERT INTO {db}.mes_building_task_order(id,task_type_enum,user_id,order_number) VALUES({id},2,1,'rebuild_wms_mapping_qa_only');")
 result={'scope':'Independent QA user/role/order fixtures, actual HTTP and original permission keys'}
 try:
  ordinary=login('wmsmappingcheck');path='/api/wms/nesting-docking/getNestingFreezeDetail?id='+str(ID);transfer='/api/wms/transfer/application/other-material/batch'
  denied(call(path,ordinary));denied(call(transfer,ordinary,'PUT',{}));result['no_role_denied_both_routes']=True
  sql("INSERT INTO {db}.sys_role(id,name,permission) VALUES({id},'WMS明细专用','rebuild_wms_mapping_fixture');INSERT INTO {db}.sys_user_role_link(id,user_id,role_id) VALUES({id},{id},{id});INSERT INTO {db}.sys_role_menu_link(id,role_id,menu_id) SELECT {id},{id},id FROM {db}.sys_menu WHERE permission='wms_mes_receipt_review:detail' LIMIT 1;")
  reader=login('wmsmappingcheck');body=call(path,reader);assert body['code']==20000 and body.get('data') is None;denied(call(transfer,reader,'PUT',{}));result['detail_permission_allows_real_unfrozen_task_only']=True
  assert call('/api/wms/nesting-docking/getNestingFreezeDetail',reader)['code']==40205
  missing=call('/api/wms/nesting-docking/getNestingFreezeDetail?id=8900005000099',reader);assert missing['code']!=20000 and missing['message']=='工单不存在';result['missing_id_and_missing_task_explicitly_rejected']=True
  sql("UPDATE {db}.sys_role_menu_link SET menu_id=(SELECT id FROM {db}.sys_menu WHERE permission='wms_matWarehouse_other:transfer' LIMIT 1) WHERE id={id};")
  writer=login('wmsmappingcheck');denied(call(path,writer));body=call(transfer,writer,'PUT',{});assert body['code']==40205 and body['message']=='调拨类型和明细不能为空';result['transfer_permission_cannot_read_frozen_details']=True;result['empty_batch_rejected_before_mutation']=True
  assert call(path,admin)['code']==20000;result['original_admin_allowed']=True
 finally:
  sql("DELETE FROM {db}.sys_role_menu_link WHERE id={id} AND role_id={id};DELETE FROM {db}.sys_user_role_link WHERE id={id} AND user_id={id};DELETE FROM {db}.sys_role WHERE id={id} AND permission='rebuild_wms_mapping_fixture';DELETE FROM {db}.sys_user WHERE id={id} AND username='wmsmappingcheck';DELETE FROM {db}.mes_building_task_order WHERE id={id} AND order_number='rebuild_wms_mapping_qa_only';")
  result['fixture_cleanup']=all(sql('SELECT COUNT(*) FROM {db}.'+t+' WHERE id={id};')=='0' for t in tables)
  call('/api/user/logout',admin,'POST',{})
  (ROOT.parent/'docs/wms-source-mapping-verification.json').write_text(json.dumps(result,ensure_ascii=False,indent=2)+'\n')
 assert result['fixture_cleanup'];print(json.dumps(result,ensure_ascii=False,indent=2))
if __name__=='__main__':main()
