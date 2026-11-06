import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import {createRequire} from 'node:module';
import {fileURLToPath} from 'node:url';
const root=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..');
const source='src/views/mes/work-order-manage/machine-part/module/cutting-detail.vue.js';
const code=fs.readFileSync(path.join(root,source),'utf8');
const {parse}=createRequire(path.join(root,'package.json'))('@babel/parser');
let callback,owner,content;
function walk(node){if(!node||typeof node!=='object')return;if(node.type==='FunctionDeclaration'){if(node.id?.name==='oe')callback=node;if(node.id?.name==='canRevokeOrder')owner=node;}if(node.type==='ObjectProperty'&&node.key?.name==='content')content=node.value.arguments[0].body.elements[0];for(const[k,v]of Object.entries(node)){if(['loc','start','end'].includes(k))continue;if(Array.isArray(v))v.forEach(walk);else if(v?.type)walk(v);}}
walk(parse(code,{sourceType:'module'}));assert(callback&&content);
const checks=[];function check(id,fn){try{fn();checks.push({id,status:'passed'});}catch(e){checks.push({id,status:'fail',error:e.message});}}
for(const[name,currentId,ownerId,admin,allowed]of [['owner',9,9,false,true],['owner_string_id','9',9,false,true],['foreign_same_get',8,9,false,false],['missing_owner',9,null,false,false],['anonymous',null,9,false,false],['admin_foreign',8,9,true,true]]){
 const requests=[],messages=[];let refreshed=0;
 const context={i:{cuttingDetailData:{taskOrderId:61,userId:ownerId}},currentUser:{value:{id:currentId}},canAdmin:keys=>admin&&keys.includes('admin'),be:async id=>requests.push(id),F:x=>messages.push(x),T:()=>refreshed++,console:{log(){}},v:(type,props,slots)=>({type,props,slots}),u:'confirm',s:'button',d:x=>x,se:()=>null};
 if(owner)context.canRevokeOrder=vm.runInNewContext('('+code.slice(owner.start,owner.end)+')',context);
 const invoke=vm.runInNewContext('('+code.slice(callback.start,callback.end)+')',context);context.oe=invoke;await invoke();
 check(name+'_actual_callback_only_owner_or_admin',()=>assert.deepEqual(requests,allowed?[61]:[]));
 check(name+'_denied_callback_has_no_success_or_refresh',()=>{assert.equal(messages.length,allowed?1:0);assert.equal(refreshed,0);});
 const rendered=vm.runInNewContext(code.slice(content.start,content.end),context);
 check(name+'_actual_content_slot_revoke_control_visibility',()=>assert.equal(rendered?.type==='confirm',allowed));
}
const result={verified_at:new Date().toISOString(),source,execution:'Actual parsed revoke callback and current content-slot revoke control expression; dependency doubles only; no HTTP',cases:checks.length,passed:checks.filter(x=>x.status==='passed').length,failed:checks.filter(x=>x.status==='fail').length,checks};fs.writeFileSync(path.join(root,'part-order-revoke-owner-verification.json'),JSON.stringify(result,null,2)+'\n');console.log(JSON.stringify(result));if(result.failed)process.exitCode=1;
