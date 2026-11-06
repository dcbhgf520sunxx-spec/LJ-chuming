import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import {createRequire} from 'node:module';
import {fileURLToPath} from 'node:url';
const root=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..');
const {parse}=createRequire(path.join(root,'package.json'))('@babel/parser');
const files={map:'src/shared/segments/056.fragment.js',page:'src/views/mes/scheduling-manage/section-machine-part/index.vue.js',dialog:'src/views/mes/scheduling-manage/section-machine-part/module/eliminate-dialog.vue.js'};
const source=Object.fromEntries(Object.entries(files).map(([k,f])=>[k,fs.readFileSync(path.join(root,f),'utf8')]));
function find(code,predicate){let found;function walk(n){if(!n||typeof n!=='object')return;if(predicate(n))found=n;for(const[k,v]of Object.entries(n)){if(['loc','start','end'].includes(k))continue;if(Array.isArray(v))v.forEach(walk);else if(v?.type)walk(v);}}walk(parse(code,{sourceType:'module'}));assert(found);return found;}
const mapNode=find(source.map,n=>n.type==='VariableDeclarator'&&n.id?.name==='Egt').init;
const permissionMap=vm.runInNewContext('('+source.map.slice(mapNode.start,mapNode.end)+')');
const opener=find(source.page,n=>n.type==='FunctionDeclaration'&&n.id?.name==='me');
const save=find(source.dialog,n=>n.type==='FunctionDeclaration'&&n.id?.name==='B');
const checks=[];function check(id,fn){try{fn();checks.push({id,status:'passed'});}catch(e){checks.push({id,status:'fail',error:e.message});}}
for(const key of ['unProductDel','unProductDelRecord'])check('section_map_reuses_exact_existing_'+key,()=>assert.deepEqual(JSON.parse(JSON.stringify(permissionMap[key]??null)),['mes_scheduling_machine_part:'+key]));
for(const[name,roles,allowed]of [['roleless',[],false],['section_get_only',['mes_scheduling_section_machine_part:get'],false],['record_only',['mes_scheduling_machine_part:unProductDelRecord'],false],['remove_leaf',['mes_scheduling_machine_part:unProductDel'],true],['admin',['admin'],true]]){
 // Mirrors the existing role helper's empty-argument behavior, which exposed the missing map entry.
 const can=keys=>!keys||keys.length===0||roles.includes('admin')||keys.some(key=>roles.includes(key));
 const N={value:false};vm.runInNewContext('('+source.page.slice(opener.start,opener.end)+')',{N,k:permissionMap,canEliminate:can})();
 check(name+'_actual_summary_opener_requires_remove_leaf',()=>assert.equal(N.value,allowed));
 const requests=[],events=[],s={value:false};let closed=0;
 const invoke=vm.runInNewContext('('+source.dialog.slice(save.start,save.end)+')',{sectionPermissions:permissionMap,canEliminate:can,u:{eliminateList:[{id:12,quantity:2,serialNumber:'QA24SECTION'}]},s,$:async data=>requests.push(JSON.parse(JSON.stringify(data))),I:()=>{},o:(...x)=>events.push(x),m:()=>closed++,console:{error(){}}});await invoke();
 check(name+'_actual_confirm_callback_request_scope',()=>assert.deepEqual(requests,allowed?[[{needId:12,quantity:2,serialNumber:'QA24SECTION'}]]:[]));
 check(name+'_denied_confirm_has_no_close_or_success',()=>{assert.equal(closed,allowed?1:0);assert.equal(events.length,allowed?2:0);assert.equal(s.value,false);});
}
check('actual_summary_control_retains_existing_map_directive',()=>assert.match(source.page,/\[\[L, n\(k\)\.unProductDel\]\]/));
check('actual_confirm_control_uses_same_permission_directive',()=>assert.match(source.dialog,/\[\[permissionDirective\("permission"\), sectionPermissions\.unProductDel\]\]/));
const result={verified_at:new Date().toISOString(),sources:files,execution:'Actual parsed current Egt permission map, summary opener and confirm callback; no HTTP',cases:checks.length,passed:checks.filter(x=>x.status==='passed').length,failed:checks.filter(x=>x.status==='fail').length,checks};fs.writeFileSync(path.join(root,'section-unproduction-permissions-verification.json'),JSON.stringify(result,null,2)+'\n');console.log(JSON.stringify(result));if(result.failed)process.exitCode=1;
