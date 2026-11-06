import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import {createRequire} from 'node:module';
import {fileURLToPath} from 'node:url';
const root=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..');
const source='src/views/mes/label-print/components/label-print-header.vue.js';
const code=fs.readFileSync(path.join(root,source),'utf8');
const {parse}=createRequire(path.join(root,'package.json'))('@babel/parser');
let callback;
function walk(node){if(!node||typeof node!=='object')return;if(node.type==='FunctionDeclaration'&&node.id?.name==='Ue')callback=node;for(const[k,v]of Object.entries(node)){if(['loc','start','end'].includes(k))continue;if(Array.isArray(v))v.forEach(walk);else if(v?.type)walk(v);}}
walk(parse(code,{sourceType:'module'}));assert(callback);
const checks=[];
function check(id,fn){try{fn();checks.push({id,status:'passed'});}catch(e){checks.push({id,status:'fail',error:e.message});}}
for(const[page,printType,leaf,legacy]of [['artifact',1,'mes_label_artifact:printSetting',false],['enclosure',2,'enclosure_label:printSetting',false],['enclosure_independent',2,'enclosure_label:printSetting',true]]){
 const actualSource=legacy?'src/views/enclosure/label-print/components/label-print-header.vue.js':source;
 const actualCode=fs.readFileSync(path.join(root,actualSource),'utf8');
 let actualCallback=callback;if(legacy){const ast=parse(actualCode,{sourceType:'module'});function find(n){if(!n||typeof n!=='object')return;if(n.type==='FunctionDeclaration'&&n.id?.name==='ve')actualCallback=n;for(const[k,v]of Object.entries(n)){if(['loc','start','end'].includes(k))continue;if(Array.isArray(v))v.forEach(find);else if(v?.type)find(v);}}find(ast);}

 for(const[name,permissions]of [['roleless',[]],['get_only',[page==='artifact'?'mes_label_artifact:get':'enclosure_label:get']],['global_layout_edit_only',['label_print_config:edit']],['other_type_setting_only',[page==='artifact'?'enclosure_label:printSetting':'mes_label_artifact:printSetting']],['own_setting_only',[leaf]],['all',[leaf,'label_print_config:edit']]]){
  const allowed=permissions.includes(leaf),requests=[],messages=[];
  const a={manufacturerName:'QA24SETTING',copiesQuantity:2,showArea:true,showMonomer:false,showBatch:true,dateInProduced:false,showProductName:true,showLength:false};
  const context={console,Q:{printSetting:[leaf]},printSettingAllowed:keys=>keys.some(key=>permissions.includes(key)),a,R:{value:28},G:printType,Z:{value:false},z:{value:true},f:{value:{manufacturerName:'original'}},O:x=>structuredClone(x),rt:async payload=>{requests.push(payload);},M:message=>messages.push(message)};
  if(legacy)Object.assign(context,{p:context.Q,v:context.R,S:context.G,M:context.Z,y:context.z,L:context.f,X:context.O,nt:context.rt,je:context.M});
  const invoke=vm.runInNewContext('('+actualCode.slice(actualCallback.start,actualCallback.end)+')',context);await invoke();
  check(page+'_'+name+'_actual_save_callback_exact_leaf',()=>assert.deepEqual(JSON.parse(JSON.stringify(requests)),allowed?[{...a,projectId:28,printType}]:[]));
  check(page+'_'+name+'_denied_preserves_form_and_success_state',()=>{assert.equal(context.Z.value,false);assert.equal(context.z.value,!allowed);assert.equal(messages.length,allowed?1:0);assert.equal(context.f.value.manufacturerName,allowed?'QA24SETTING':'original');});
 }
}
check('current_save_button_retains_actual_Ue_handler',()=>assert.match(code,/onClick: Ue/));
check('current_setting_trigger_retains_injected_permission_directive',()=>assert.match(code,/\[\[ne, e\(Q\)\.printSetting\]\]/));
const result={verified_at:new Date().toISOString(),source,execution:'Actual parsed Ue and ve functions; request and permission dependency doubles only; no HTTP',cases:checks.length,passed:checks.filter(x=>x.status==='passed').length,failed:checks.filter(x=>x.status==='fail').length,checks};
fs.writeFileSync(path.join(root,'label-project-setting-permissions-verification.json'),JSON.stringify(result,null,2)+'\n');console.log(JSON.stringify(result));if(result.failed)process.exitCode=1;
