import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import {createRequire} from 'node:module';
import {fileURLToPath} from 'node:url';
const root=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..');
const {parse}=createRequire(path.join(root,'package.json'))('@babel/parser');
function walk(node,fn){if(!node||typeof node!=='object')return;if(node.type)fn(node);for(const[k,v]of Object.entries(node)){if(['loc','start','end'].includes(k))continue;if(Array.isArray(v))v.forEach(n=>walk(n,fn));else if(v?.type)walk(v,fn);}}
const defs=new Map();
for(const name of fs.readdirSync(path.join(root,'src/shared/segments')).filter(n=>n.endsWith('.js'))){
 const source=fs.readFileSync(path.join(root,'src/shared/segments',name),'utf8');
 for(const statement of parse(source,{sourceType:'module'}).program.body){
  if(statement.type==='FunctionDeclaration')defs.set(statement.id.name,{node:statement,source});
  if(statement.type==='VariableDeclaration')for(const d of statement.declarations)if(d.id.type==='Identifier')defs.set(d.id.name,{node:d.init,source});
 }
}
function property(record,key){assert(record.node.type==='ObjectExpression',key+' expected actual object definition');return {node:record.node.properties.find(p=>(p.key.name??p.key.value)===key)?.value,source:record.source};}
function resolve(record){
 assert(record?.node,'Actual dispatcher registry entry absent');const n=record.node;
 if(n.type==='Identifier')return resolve(defs.get(n.name));
 if(n.type==='MemberExpression')return resolve(property(resolve({node:n.object,source:record.source}),n.property.name??n.property.value));
 return record;
}
function registryFunction(key){return resolve(property(defs.get('WNe'),key));}
function componentPrint(kind,tab,id){
 const file=kind==='sub'?'src/views/supply-chain/sub-supplier/self/module/record/index.vue.js':`src/views/supply-chain/${kind==='bg'?'purchase-order-bg':'purchase-order-V2'}/module/record/index.vue.js`;
 const source=fs.readFileSync(path.join(root,file),'utf8'),ast=parse(source,{sourceType:'module'});let component;
 walk(ast,n=>{if(n.type==='ObjectExpression'&&n.properties.some(p=>p.key?.name==='setup')&&n.properties.some(p=>p.key?.name==='__name'))component=n;});assert(component);
 const printNodes=[],refs=[],common={table_item_data:{value:{id,project:{serialNumber:'QA-SUB'}}},current_key:{value:tab}};
 const ref=v=>{const r={value:v};refs.push(r);return r;},computed=fn=>({get value(){return fn();}}),unref=x=>x&&typeof x==='object'&&'value'in x?x.value:x;
 const crud={props:{recordType:tab,rowDetail:{id},recordVisible:true}};
 function vnode(type,props,slots){
  if(type==='common-drawer')props?.onOpen?.();
  if(type==='print-table')printNodes.push(props);
  if(slots&&!Array.isArray(slots)&&typeof slots==='object')for(const slot of Object.values(slots))if(typeof slot==='function')slot();
  return {type,props};
 }
 const context={console,Array,Number,String,Boolean};
 for(const statement of ast.program.body)if(statement.type==='ImportDeclaration')for(const spec of statement.specifiers){
  const imported=spec.imported?.name,alias=spec.local.name;
  const vue={ref,computed,unref,inject:()=>common,watch:(getter,fn,options)=>{if(options?.immediate)fn(getter());},resolveComponent:x=>x,resolveDynamicComponent:x=>x,defineAsyncComponent:()=>({}),openBlock:()=>{},createBlock:vnode,createVNode:vnode,createElementVNode:vnode,createElementBlock:vnode,withCtx:fn=>fn,createTextVNode:x=>x,toDisplayString:String};
  context[alias]=statement.source.value==='vue'?(vue[imported]??(()=>{})):statement.source.value==='element-plus'?alias:imported==='u'?()=>({visible:{value:true},handleClose(){}}):imported==='kc'?()=>({crud}):imported==='z'?()=> 'QA-SUB':()=>{};
 }
 for(const statement of ast.program.body)if(statement.type==='VariableDeclaration')for(const d of statement.declarations)if(d.id.type==='Identifier'&&d.init?.type==='ObjectExpression'&&d!==component)context[d.id.name]={};
 const actual=vm.runInNewContext('('+source.slice(component.start,component.end)+')',context);
 const render=actual.setup({modelValue:true},{emit(){}});render({},[]);assert.equal(printNodes.length,1);
 return {file,key:printNodes[0]['api-key'],params:JSON.parse(JSON.stringify(printNodes[0].params))};
}
const checks=[];
async function check(id,fn){try{const details=await fn();checks.push({id,status:'passed',details});}catch(e){checks.push({id,status:'fail',error:e.message});}}
for(const kind of ['po','bg','sub'])for(const tab of kind==='sub'?['payment','invoice','settle','preSettle']:['payment','invoice','settle']){
 await check(kind+'_'+tab+'_actual_component_to_registry_and_native_provider_preserves_business_object',async()=>{
  const id=913,props=componentPrint(kind,tab,id),provider=registryFunction(props.key),requests=[];
  assert.equal(provider.node.type,'FunctionDeclaration');
  const actual=vm.runInNewContext('('+provider.source.slice(provider.node.start,provider.node.end)+')',{W:request=>{requests.push(request);return {table:[{marker:'source-object'}]};}});
  const result=await actual(props.params);assert.equal(result.table[0].marker,'source-object');assert.equal(requests.length,1);
  const branch=tab==='preSettle'?'preSettle':tab;
  const expected=kind==='sub'?`/api/v2/scm/subcontract-order/${branch}List/${id}/print`:`/api/v2/scm/purchase-order/getPurchaseOrder/${branch}Detail/${id}/download`;
  assert.equal(requests[0].url,expected);assert.equal(requests[0].method,'get');assert.equal(requests[0].params.id,id);
  return {...props,actual_native_path:requests[0].url};
 });
}
const report={verified_at:new Date().toISOString(),execution:'Actual parsed current Vue component setup/render, real WNe registry aliases, actual native provider functions; Vue UI dependencies and network W only are doubled. No HTTP or browser claims.',cases:checks.length,passed:checks.filter(c=>c.status==='passed').length,failed:checks.filter(c=>c.status==='fail').length,checks};
fs.writeFileSync(path.join(root,'scm-record-print-dispatch-verification.json'),JSON.stringify(report,null,2)+'\n');console.log(JSON.stringify(report));if(report.failed)process.exitCode=1;
