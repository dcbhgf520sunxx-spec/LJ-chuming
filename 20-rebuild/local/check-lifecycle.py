#!/usr/bin/env python3
"""Run business lifecycle exclusively in a fresh, limited-account QA clone; no host ports."""
from pathlib import Path
import json,secrets,subprocess,shutil,re
from provision import mysql,ROOT,CONTAINER
QA=ROOT/'runtime/lifecycle-qa';DB='plm7_rebuild_qa_lifecycle';USER='rebuild_qa_lifecycle'
def command(*args,**kwargs):return subprocess.run(args,check=True,stdout=subprocess.PIPE,stderr=subprocess.PIPE,**kwargs)
def main():
 QA.mkdir(parents=True,exist_ok=True)
 if mysql("SELECT COUNT(*) FROM information_schema.schemata WHERE schema_name='"+DB+"';")!='0':raise RuntimeError('QA database already exists; inspect prior run instead of overwriting')
 password=secrets.token_hex(24)
 mysql("CREATE DATABASE "+DB+" CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;CREATE USER IF NOT EXISTS '"+USER+"'@'%' IDENTIFIED BY '"+password+"';ALTER USER '"+USER+"'@'%' IDENTIFIED BY '"+password+"';GRANT ALL ON "+DB+".* TO '"+USER+"'@'%';")
 dump=subprocess.Popen(['docker','exec',CONTAINER,'sh','-c','MYSQL_PWD="$MYSQL_ROOT_PASSWORD" exec mysqldump -uroot --single-transaction --quick --set-gtid-purged=OFF --column-statistics=0 --no-tablespaces plm7_rebuild'],stdout=subprocess.PIPE,stderr=subprocess.PIPE)
 restore=subprocess.run(['docker','exec','-i',CONTAINER,'sh','-c','MYSQL_PWD="$MYSQL_ROOT_PASSWORD" exec mysql -uroot '+DB],stdin=dump.stdout,stdout=subprocess.PIPE,stderr=subprocess.PIPE);dump.stdout.close();dump.wait()
 if dump.returncode or restore.returncode:raise RuntimeError('QA clone failed; source and main rebuilt database untouched')
 config=(ROOT/'business.properties').read_text()+'\nspring.redis.host=lifecycle-qa-redis\nljaps.lifecycle.enabled=true\nljaps.lifecycle.qa-run-all=true\n'
 (QA/'business.properties').write_text(config)
 env=dict(l.split('=',1) for l in (ROOT/'.env').read_text().splitlines() if '=' in l)
 source=json.loads((ROOT/'compose.json').read_text())['services']['backend']
 source['volumes']=[str(ROOT.parent/'backend/target/runtime')+':/app:ro',str(ROOT/'runtime/rsa-private.pem')+':/run/secrets/rsa-private.pem:ro',str(ROOT/'runtime/rsa-public.pem')+':/run/secrets/rsa-public.pem:ro',str(QA/'business.properties')+':/run/config/business.properties:ro',str(QA/'files')+':/data/files',str(QA/'evidence')+':/evidence']
 source['environment'].update(SPRING_DATASOURCE_URL='jdbc:mysql://mysql:3306/'+DB+'?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai',SPRING_DATASOURCE_USERNAME=USER,SPRING_DATASOURCE_PASSWORD=password,LJAPS_JWT_SECRET=env['LJAPS_JWT_SECRET'])
 source['networks']={'database':{'aliases':['lifecycle-qa-backend']},'isolated':{}}
 source['container_name']='ljaps-lifecycle-qa-backend';source['depends_on']=['redis'];source['mem_limit']='2g'
 config={'name':'ljaps-lifecycle-qa','services':{'backend':source,'redis':{'image':'redis:alpine','command':['redis-server','--appendonly','no'],'networks':{'isolated':{'aliases':['lifecycle-qa-redis']}},'mem_limit':'128m'}},'networks':{'database':{'external':True,'name':'ljaps-local_isolated'},'isolated':{'internal':True}}}
 f=QA/'compose.json';f.write_text(json.dumps(config,indent=2));f.chmod(0o600)
 subprocess.run(['docker','compose','-f',str(f),'up','-d'],check=True)
 print('Independent QA clone launched with limited account, internal networks and no host ports. Database: '+DB)
if __name__=='__main__':main()
