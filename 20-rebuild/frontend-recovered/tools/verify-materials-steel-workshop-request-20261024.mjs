import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import crypto from 'node:crypto';
import {createRequire} from 'node:module';
import {fileURLToPath} from 'node:url';
const root=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..');
const {parse}=createRequire(path.join(root,'package.json'))('@babel/parser');
const file='src/views/mes/scheduling-manage/machine-part/module/materials-drawer.vue.js';
const providerFile='src/shared/segments/058.fragment.js';
const before=fs.readFileSync(path.join(root,file),'utf8');
const old='workshopId: R.value, thickness: i.value';
const replacement='workshopIds: R.value == null ? void 0 : [R.value], thickness: i.value';
const currentOnly=process.argv.includes('--verify-current') || path.resolve(process.argv[1]??'')===path.join(root,'tools/test.mjs');
assert.equal(before.split(currentOnly?replacement:old).length,2,'Only the exact current steel picker request may change');
const patched=currentOnly?before:before.replace(old,replacement);
const sha=s=>crypto.createHash('sha256').update(s).digest('hex');
function walk(n,fn){if(!n||typeof n!=='object')return;if(n.type)fn(n);for(const[k,v]of Object.entries(n)){if(['start','end','loc'].includes(k))continue;if(Array.isArray(v))v.forEach(x=>walk(x,fn));else if(v?.type)walk(v,fn);}}
const providerSource=fs.readFileSync(path.join(root,providerFile),'utf8');
const providerNode=parse(providerSource,{sourceType:'module'}).program.body.find(n=>n.type==='FunctionDeclaration'&&n.id.name==='Lyt');
assert(providerNode);
assert.match(fs.readFileSync(path.join(root,'src/shared/exports.fragment.js'),'utf8'),/\bLyt as r6\b/);
async function requestFromActualComponent(source,selected){
 const ast=parse(source,{sourceType:'module'});let component;
 walk(ast,n=>{if(n.type==='ObjectExpression'&&n.properties.some(p=>p.key?.name==='setup')&&n.properties.some(p=>p.key?.name==='__name'))component=n;});assert(component);
 const setup=component.properties.find(p=>p.key?.name==='setup');
 const renderReturn=setup.body.body.find(n=>n.type==='ReturnStatement');assert(renderReturn);
 // Test-only closure exposure. All production setup, render, model setter and fetch code execute unchanged.
 const componentCode=source.slice(component.start,renderReturn.start)+'globalThis.__ports={fetch:E,show:Ne};'+source.slice(renderReturn.start,component.end);
 const requests=[],selectors=[];
 const ref=value=>({value}),computed=fn=>({get value(){return fn();}}),unref=x=>x&&typeof x==='object'&&'value'in x?x.value:x;
 const actualProvider=vm.runInNewContext('('+providerSource.slice(providerNode.start,providerNode.end)+')',{W:req=>{requests.push(req);return Promise.resolve({totalElements:0,content:[]});}});
 function vnode(type,props,slots){if(type==='warehouse-selector')selectors.push(props);if(slots&&!Array.isArray(slots)&&typeof slots==='object')for(const f of Object.values(slots))if(typeof f==='function'&&f.length===0)f();return {type,props};}
 const vue={ref,computed,unref,watch(){},resolveComponent:x=>x,openBlock(){},createBlock:vnode,createVNode:vnode,createElementVNode:vnode,createElementBlock:vnode,withCtx:f=>f,createTextVNode:x=>x,toDisplayString:String,createCommentVNode:()=>null,withDirectives:x=>x,withModifiers:f=>f,renderSlot:()=>null,isRef:x=>!!x&&'value'in x};
 const context={console,Array,Set,Number,String,Boolean,Math,parseFloat};
 for(const n of ast.program.body)if(n.type==='ImportDeclaration')for(const spec of n.specifiers){const imported=spec.imported?.name,alias=spec.local.name;
 context[alias]=n.source.value==='vue'?(vue[imported]??(()=>{})):n.source.value==='lodash'?{clone:x=>structuredClone(x)}:n.source.value==='element-plus'?(imported==='ElMessage'?{error:m=>{throw Error(m);}}:alias):alias==='ua'?()=>({columns:ref({visible:()=>true})}):alias==='ia'?()=>({queryPage:{pageNumber:2,pageSize:50},setTotalPage(){},total:ref(0)}):alias==='sa'?()=>({visible:ref(true),handleClose(){}}):alias==='ra'?()=>({maxHeight:ref(900)}):alias==='q'?{AREA:{V:1},ENUM:{}}:alias==='b'?{PUBLIC:{V:1},PROJECT:{V:2},REMAIN:{V:3}}:alias==='da'?actualProvider:alias==='pa'?'warehouse-selector':()=>{};
 }
 for(const n of ast.program.body)if(n.type==='VariableDeclaration')for(const d of n.declarations)if(d.id.type==='Identifier')context[d.id.name]={};
 vm.createContext(context);
 const actual=vm.runInContext('('+componentCode+')',context);
 const render=actual.setup({list:[{project:{id:1,serialNumber:'QA',shortName:'OWN'},thick:8,material:'Q235B',quantity:2,weight:6.28,area:1}],sureBinding:[],bindingWorkshopId:1,schedulingGroups:[]},{emit(){}});
 await context.__ports.show();render({list:[{project:{serialNumber:'QA',shortName:'OWN'}}],$slots:{}},[]);
 assert.equal(selectors.length,1,'Actual render must expose one scalar warehouse selector');
 selectors[0]['onUpdate:modelValue'](selected);
 await selectors[0].onChange();
 assert.equal(requests.length,1);return JSON.parse(JSON.stringify(requests[0]));
}
const scenarios=[['selected_workshop_1',1],['selected_workshop_7',7],['cleared_workshop_undefined',undefined],['cleared_workshop_null',null]];
const reports=[];
for(const [stage,source]of (currentOnly?[['current-after',before]]:[['before',before],['patched-unapplied',patched]])){
 const checks=[];
 for(const[id,value]of scenarios){let request;try{request=await requestFromActualComponent(source,value);assert.equal(request.url,'api/wms/nesting-docking/steel-plate');assert.equal(request.method,'get');assert(!('workshopId'in request.params));assert.deepEqual(request.params.workshopIds,value==null?undefined:[value]);assert.equal(request.params.projectId,1);assert.equal(request.params.pageNumber,2);assert.equal(request.params.pageSize,50);checks.push({id,status:'passed',request});}catch(e){checks.push({id,status:'fail',error:e.message,request});}}
 const report={verified_at:new Date().toISOString(),stage,execution:'Actual parsed recovered component setup/render/model event/fetch, actual r6=Lyt provider; Vue/helper ports and W transport doubled. Test-only closure exposes show/fetch without changing their bodies. No HTTP/CUA/native claim.',source:{path:file,sha256:sha(source)},provider:{path:providerFile,sha256:sha(providerSource)},checks,summary:{passed:checks.filter(x=>x.status==='passed').length,fail:checks.filter(x=>x.status==='fail').length}};
 report.cases=checks.length;report.passed=report.summary.passed;report.failed=report.summary.fail;
 const out=currentOnly?path.join(root,'materials-steel-workshop-request-verification.json'):path.join(root,'../docs/2026-10-24-steel-picker-actual-component-'+stage+'.json');fs.writeFileSync(out,JSON.stringify(report,null,2)+'\n');reports.push(report);console.log(JSON.stringify({stage,cases:report.cases,failed:report.failed,summary:report.summary,report:out}));
}
if(currentOnly)assert.equal(reports[0].summary.fail,0);else {assert.equal(reports[0].summary.fail,3,'Preserve exact current scalar source RED');assert.equal(reports[1].summary.fail,0,'Proposed source must fix actual request object');}
