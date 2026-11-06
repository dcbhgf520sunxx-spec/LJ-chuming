import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import {createRequire} from 'node:module';
import {fileURLToPath} from 'node:url';
const root=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..');
const source='src/views/plan/technical-manage/artifact-tree/index.vue.js';
const code=fs.readFileSync(path.join(root,source),'utf8');
const {parse}=createRequire(path.join(root,'package.json'))('@babel/parser');
const functions={};
function walk(node){if(!node||typeof node!=='object')return;if(node.type==='FunctionDeclaration'&&['_e','ke'].includes(node.id?.name))functions[node.id.name]=code.slice(node.start,node.end);for(const[k,v]of Object.entries(node)){if(['loc','start','end'].includes(k))continue;if(Array.isArray(v))v.forEach(walk);else if(v?.type)walk(v);}}
walk(parse(code,{sourceType:'module'}));assert.equal(Object.keys(functions).length,2);
const checks=[];
function check(id,fn){try{fn();checks.push({id,status:'passed'});}catch(e){checks.push({id,status:'fail',error:e.message});}}
const leaf='plan_artifact_tree_list:edit';
for(const[name,permissions,admin]of [['roleless',[],false],['read_only',['plan_artifact_tree_list:get'],false],['other_edit',['plan_artifact_tree_list:editNum'],false],['exact_edit',[leaf],false],['admin',[],true]]){
 const allowed=admin||permissions.includes(leaf),requests=[],messages=[];let refreshes=0;
 const context={T:{edit:[leaf]},he:keys=>admin||keys.some(key=>permissions.includes(key)),He:async data=>requests.push(JSON.parse(JSON.stringify(data))),Fe:{success:message=>messages.push(message)},c:{toQuery:()=>refreshes++},console:{log(){}}};
 const open=vm.runInNewContext('('+functions._e+')',context),save=vm.runInNewContext('('+functions.ke+')',context);
 const row={id:77,remark:'new remark',originalRemark:'original',dataType:2,edit:false,editLoading:false};
 open(row,{property:'remark'});
 check(name+'_actual_double_click_respects_edit_leaf',()=>assert.equal(row.edit,allowed));
 row.edit=true;const before=structuredClone(row);await save(row);
 check(name+'_actual_save_callback_request_scope',()=>assert.deepEqual(requests,allowed?[[{id:77,remark:'new remark'}]]:[]));
 check(name+'_actual_save_state_and_feedback',()=>{assert.equal(refreshes,allowed?1:0);assert.equal(messages.length,allowed?1:0);if(allowed){assert.equal(row.edit,false);assert.equal(row.editLoading,false);}else assert.deepEqual(row,before);});
 if(allowed){
  for(const[reason,patch,column]of [['non_artifact',{dataType:1},{property:'remark'}],['other_column',{}, {property:'serialNumber'}]]){
   const other={...row,edit:false,...patch};open(other,column);check(name+'_'+reason+'_does_not_open_editor',()=>assert.equal(other.edit,false));
  }
 }
}
{
 const row={id:77,remark:'changed',originalRemark:'original',dataType:2,edit:true,editLoading:false};
 const save=vm.runInNewContext('('+functions.ke+')',{T:{edit:[leaf]},he:()=>true,He:async()=>{throw new Error('retained failure path');},Fe:{success(){throw new Error('unexpected success');}},c:{toQuery(){throw new Error('unexpected refresh');}},console:{log(){}}});await save(row);
 check('authorized_native_error_restores_original_and_clears_edit_state',()=>{assert.equal(row.remark,'original');assert.equal(row.edit,false);assert.equal(row.editLoading,false);});
}
check('current_render_retains_actual_double_click_and_save_callbacks',()=>{assert.match(code,/onRowDblclick: _e/);assert.match(code,/onClick:[^\n]*ke\(/);});
const result={verified_at:new Date().toISOString(),source,execution:'Actual parsed _e and ke functions; permission and HTTP dependency doubles; no business HTTP',cases:checks.length,passed:checks.filter(x=>x.status==='passed').length,failed:checks.filter(x=>x.status==='fail').length,checks};
fs.writeFileSync(path.join(root,'artifact-remark-permissions-verification.json'),JSON.stringify(result,null,2)+'\n');console.log(JSON.stringify(result));if(result.failed)process.exitCode=1;
