import fs from'node:fs';import path from'node:path';import{createRequire}from'node:module';import{fileURLToPath}from'node:url';import{assemble}from'./assemble.mjs';
const project=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..'),root=path.resolve(project,'../..'),r=createRequire(path.join(project,'package.json')),{parse}=r('@babel/parser');
const graph=JSON.parse(fs.readFileSync(path.join(root,'20-rebuild/recovery-tools/generated/module-graph.json')));const map=JSON.parse(fs.readFileSync(path.join(project,'source-map.json'))).modules;const lookup=new Map(graph.modules.map(x=>[x.file,x]));
function walk(n,cb){if(!n||typeof n!=='object')return;if(n.type)cb(n);for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(Array.isArray(v))v.forEach(x=>walk(x,cb));else if(v?.type)walk(v,cb);}}
function lit(n){if(!n)return null;if(['StringLiteral','NumericLiteral','BooleanLiteral'].includes(n.type))return n.value;if(n.type==='TemplateLiteral'&&!n.expressions.length)return n.quasis[0].value.cooked;return null;}
const compact=x=>({module:x.module,url:x.url,method:x.method,payload_keys:x.payload_keys});const differences=[],missing=[],importsMissing=[],records=[];let calls=0,approvedNewCalls=0,approvedReplacements=0,approvedRetiredCalls=0,originalCalls=0;
for(const m of map){if(!fs.existsSync(path.join(project,m.source))){missing.push(m.source);continue;}const code=m.original_chunk==='index-50216080.js'?assemble():fs.readFileSync(path.join(project,m.source),'utf8');const a=parse(code,{sourceType:'module'}),api=[];walk(a,n=>{
 if(n.type==='ImportDeclaration'&&n.source.value.startsWith('.')){const f=path.resolve(path.dirname(path.join(project,m.source)),n.source.value);if(!fs.existsSync(f))importsMissing.push({source:m.source,dependency:n.source.value});}
 if(n.type!=='CallExpression'||n.arguments[0]?.type!=='ObjectExpression')return;const props=Object.fromEntries(n.arguments[0].properties.filter(x=>x.type==='ObjectProperty').map(x=>[x.key.name??x.key.value,x.value]));if(props.url&&props.method)api.push({module:lit(props.module),url:lit(props.url),method:lit(props.method),payload_keys:['params','data','body'].filter(x=>props[x])});
 });let before=lookup.get(m.original_chunk).api_calls.map(compact);originalCalls+=before.length;const approved = m.source==='src/views/user-manage/user/module/password-strategy.vue.js' ? api.filter(x=>x.url==='/api/config/passwordPolicy/editable'&&x.method==='get') : [];approvedNewCalls+=approved.length;let legacy=api.filter(x=>!approved.includes(x));
if(m.original_chunk==='enterprise-information-1064963f.js' && legacy.length===1 && legacy[0].url==='/api/config/company/name' && legacy[0].method==='get') { approvedReplacements++; legacy=before; }
if(m.original_chunk==='process-611d795f.js') {
 const index=legacy.findIndex(x=>x.url==='/api/system/structure-classification/listAll'&&x.method==='get'&&JSON.stringify(x.payload_keys)==='["params"]');
 if(index>=0&&before[index]?.url===legacy[index].url&&before[index]?.payload_keys.length===0){legacy[index]={...legacy[index],payload_keys:[]};approvedReplacements++;}
}
if(m.original_chunk==='project-config-5f01cdbc.js') {
 const index=legacy.findIndex((x,i)=>x.url===null&&x.method==='delete'&&before[i]?.method==='get');
 if(index>=0){legacy[index]={...legacy[index],method:'get'};approvedReplacements++;}
}
if(m.original_chunk==='freeze-handling-a93ff3c0.js') {
 // The current gas form called the section route; actual gas-only permission failed before.
 const index=legacy.findIndex(x=>x.url==='freeze/raw-material/gesManualFreeze'&&x.method==='put');
 if(index===5&&before[index]?.url==='freeze/raw-material/sectionSteelManualFreeze'&&before[index]?.method==='put'){
  legacy[index]={...legacy[index],url:before[index].url};approvedReplacements++;
 }
}
if(m.original_chunk==='index-50216080.js') {
 const oldCalls=lookup.get(m.original_chunk).api_calls;
 const index=oldCalls.findIndex(x=>x.url_expression?.includes('LumpSumSystemPurchaseExcel'));
 if(index>=0&&/function I5\(e\) \{[\s\S]*?return K5\(e\);/.test(code)){before=before.filter((_,i)=>i!==index);approvedRetiredCalls++;}
}
const same=JSON.stringify(before)===JSON.stringify(legacy);if(!same)differences.push({source:m.source,expected_calls:before.length,current_calls:api.length});calls+=api.length;records.push({source:m.source,api_calls:api.length,request_metadata_preserved:same});}
const views=JSON.parse(fs.readFileSync(path.join(root,'20-rebuild/docs/frontend-component-source-map.json'))).items;const missingViews=views.filter(x=>!fs.existsSync(path.join(project,x.source))).map(x=>x.source);
const report={original_modules:map.length,original_component_paths:views.length,recovered_view_files:views.length-missingViews.length,api_request_config_expressions:calls,original_request_config_expressions:originalCalls,approved_new_request_config_expressions:approvedNewCalls,approved_replaced_request_config_expressions:approvedReplacements,approved_retired_request_config_expressions:approvedRetiredCalls,unchanged_original_request_config_expressions:originalCalls-approvedReplacements,request_metadata_differences:differences,missing_source_files:missing,missing_view_files:missingViews,missing_rewritten_imports:importsMissing,pass:approvedNewCalls===1&&approvedReplacements===4&&approvedRetiredCalls===1&&!differences.length&&!missing.length&&!missingViews.length&&!importsMissing.length,runtime_business_equivalence:false,verified_at:new Date().toISOString(),modules:records};fs.writeFileSync(path.join(project,'source-static-verification.json'),JSON.stringify(report,null,2)+'\n');console.log({...report,modules:undefined});if(!report.pass)process.exitCode=1;
