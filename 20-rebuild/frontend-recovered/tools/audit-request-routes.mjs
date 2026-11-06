import fs from 'node:fs';
import crypto from 'node:crypto';
import path from 'node:path';
import {createRequire} from 'node:module';
import {fileURLToPath} from 'node:url';
import {assemble} from './assemble.mjs';
const project=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..');
const workspace=path.resolve(project,'../..');
const originalMain='index-50216080.js';
const {parse}=createRequire(path.join(project,'package.json'))('@babel/parser');
const modules=JSON.parse(fs.readFileSync(path.join(project,'source-map.json'))).modules;
const candidates=JSON.parse(fs.readFileSync(path.join(workspace,'20-rebuild/docs/backend-static-api-candidates.json'))).routes;
const runtimeFile=path.join(workspace,'20-rebuild/local/runtime/verification/runtime-registration.json');
const runtimeBytes=fs.readFileSync(runtimeFile),runtimeRegistration=JSON.parse(runtimeBytes);
function walk(n,cb){if(!n||typeof n!=='object')return;if(n.type)cb(n);for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(Array.isArray(v))v.forEach(x=>walk(x,cb));else if(v?.type)walk(v,cb);}}
const props=n=>Object.fromEntries((n?.properties||[]).filter(x=>x.type==='ObjectProperty').map(x=>[x.key.name??x.key.value,x.value]));
const literal=n=>n?.type==='StringLiteral'?n.value:null;
const shared=assemble(),sharedAst=parse(shared,{sourceType:'module'});let prefixes;
const assembly=JSON.parse(fs.readFileSync(path.join(project,'src/shared/assembly.json')));
const editableFragments=['src/shared/imports.fragment.js',...assembly.segments.map(x=>x.file),'src/shared/bootstrap.fragment.js','src/shared/exports.fragment.js','src/shared/inline-exports.fragment.js'].map(file=>({file,code:fs.readFileSync(path.join(project,file),'utf8')}));
const locationCache=new Map();
function editableLocations(needle){if(locationCache.has(needle))return locationCache.get(needle);const locations=[];for(const fragment of editableFragments){let index=fragment.code.indexOf(needle);while(index>=0){locations.push({source:fragment.file,line:fragment.code.slice(0,index).split('\n').length,offset:index});index=fragment.code.indexOf(needle,index+1);}}locationCache.set(needle,locations);return locations;}
walk(sharedAst,n=>{if(n.type==='VariableDeclarator'&&n.id.name==='jN')prefixes=Object.fromEntries(Object.entries(props(props(n.init).baseApi)).map(([k,v])=>[k,literal(v)]));});
if(!prefixes?.mes)throw Error('Cannot extract actual API module prefix table');
function expression(n){if(!n)return{value:'<dynamic>',dynamic:true};if(n.type==='StringLiteral')return{value:n.value,dynamic:false};if(n.type==='NumericLiteral')return{value:String(n.value),dynamic:false};if(n.type==='TemplateLiteral'){let value='';for(let i=0;i<n.quasis.length;i++)value+=n.quasis[i].value.cooked+(i<n.expressions.length?expression(n.expressions[i]).value:'');return{value,dynamic:!!n.expressions.length};}if(n.type==='BinaryExpression'&&n.operator==='+'){const a=expression(n.left),b=expression(n.right);return{value:a.value+b.value,dynamic:a.dynamic||b.dynamic};}return{value:'<dynamic>',dynamic:true};}
const escape=s=>s.replace(/[.*+?^${}()|[\]\\]/g,'\\$&');
function routeRegex(p){return new RegExp('^'+p.split(/(\{[^}]+\}|\*\*|\*)/).map(x=>x.startsWith('{')?'[^/]+':x==='**'?'.*':x==='*'?'[^/]*':escape(x)).join('')+'/?$');}
const extras=[['GET','/api/user/public-key'],['GET','/api/config/passwordPolicy/editable']].map(([method,p])=>({path:p,http_methods:[method],controller:'new-local-auth-or-policy-controller'}));
const allCandidates=[...candidates,...extras].map(x=>({...x,regex:routeRegex(x.path)}));
const runtimeCandidates=runtimeRegistration.routes.flatMap(x=>x.paths.map(p=>({...x,path:p,regex:routeRegex(p)})));
const records=[];
for(const module of modules){const code=module.original_chunk==='index-50216080.js'?shared:fs.readFileSync(path.join(project,module.source),'utf8');const ast=module.original_chunk==='index-50216080.js'?sharedAst:parse(code,{sourceType:'module'});walk(ast,n=>{
 if(n.type!=='CallExpression'||n.arguments[0]?.type!=='ObjectExpression')return;const p=props(n.arguments[0]);if(!p.url||!p.method)return;
 const url=expression(p.url),mod=literal(p.module),method=literal(p.method)?.toUpperCase();let full=url.value,classification='unresolved',matches=[];
 if(mod&&prefixes[mod])full=prefixes[mod]+full;
 if(/^https?:\/\//.test(full))classification='explicit-external-url';
 else if((p.module&&!mod)||(mod&&!prefixes[mod]))classification='dynamic-or-unknown-api-module';
 else if(full.startsWith('<dynamic>'))classification='fully-dynamic-url';
 else if(!method)classification='dynamic-http-method';
 else {full='/'+full.replace(/[\t\r\n]/g,'').trim().replace(/^\/+/, '').split('?')[0];const example=full.replaceAll('<dynamic>','1');matches=allCandidates.filter(x=>(!x.http_methods.length||x.http_methods.includes(method))&&x.regex.test(example));classification=matches.length?(url.dynamic?'parameterized-route-candidate-match':'literal-route-candidate-match'):'no-static-route-candidate';}
 const comparable=['literal-route-candidate-match','parameterized-route-candidate-match','no-static-route-candidate'].includes(classification);
 const runtimeMatches=comparable?runtimeCandidates.filter(x=>(!x.methods.length||x.methods.includes(method))&&x.regex.test(full.replaceAll('<dynamic>','1'))):[];
 const runtimeClassification=comparable?(runtimeMatches.length?(url.dynamic?'parameterized-registered-route-match':'literal-registered-route-match'):'no-registered-route-match'):classification;
 const locations=module.original_chunk===originalMain?editableLocations(code.slice(n.start,n.end)):[{source:module.source,line:n.loc.start.line,offset:n.start}];
 records.push({source:module.source,original_chunk:module.original_chunk,line:n.loc.start.line,offset:n.start,editable_source_locations:locations,module:mod,method,url_expression:code.slice(p.url.start,p.url.end).slice(0,220),path_pattern:full,classification,matches:matches.map(x=>({path:x.path,methods:x.http_methods,controller:x.controller})),runtime_classification:runtimeClassification,runtime_matches:runtimeMatches.map(x=>({path:x.path,methods:x.methods,controller:x.controller,java_method:x.java_method,pre_authorize:x.pre_authorize,params:x.params,headers:x.headers,consumes:x.consumes,produces:x.produces}))});
 });}
const metadata=JSON.parse(fs.readFileSync(path.join(project,'source-static-verification.json')));
if(records.length!==metadata.api_request_config_expressions)throw Error('Request-path audit did not cover the full verified request-expression count');
if(records.some(x=>!x.editable_source_locations.length))throw Error('Request expression has no editable source-fragment location');
const counts=Object.fromEntries([...new Set(records.map(x=>x.classification))].map(c=>[c,records.filter(x=>x.classification===c).length]));
const runtimeCounts=Object.fromEntries([...new Set(records.map(x=>x.runtime_classification))].map(c=>[c,records.filter(x=>x.runtime_classification===c).length]));
const report={verified_at:new Date().toISOString(),scope:'4088 recovered original modules plus two known new backend endpoints; source AST request objects with url/method keys.',prefixes,request_config_expressions:records.length,classification_counts:counts,static_backend_candidates:candidates.length,local_new_endpoints:extras.map(({path,http_methods})=>({path,methods:http_methods})),unmatched_unique_paths:[...new Set(records.filter(x=>x.classification==='no-static-route-candidate').map(x=>x.method+' '+x.path_pattern))].sort(),runtime_route_source:'20-rebuild/local/runtime/verification/runtime-registration.json',runtime_route_source_sha256:crypto.createHash('sha256').update(runtimeBytes).digest('hex'),runtime_route_started_epoch_millis:runtimeRegistration.started_epoch_millis,runtime_registered_mappings:runtimeRegistration.registered_mappings,runtime_classification_counts:runtimeCounts,runtime_unmatched_unique_paths:[...new Set(records.filter(x=>x.runtime_classification==='no-registered-route-match').map(x=>x.method+' '+x.path_pattern))].sort(),runtime_request_results_verified:false,limitations:['AST path comparison is not an API call or workflow acceptance.','Parameterized URLs use one path segment per dynamic expression; expressions that contain slash-separated subpaths remain unresolved candidates.','Runtime registration includes method/path/controller/pre_authorize and params/headers/consumes/produces conditions; URL matching alone still does not verify concrete parameters.','Static backend candidates may be overridden by the new auth controllers; see backend-runtime-route-coverage.json.','Other network forms, runtime-generated CRUD requests, direct fetch/XHR, and third-party worker behavior require runtime evidence.','src/main.js separately fetches GET /api/user/public-key before application import.'],records};
fs.writeFileSync(path.join(project,'request-route-audit.json'),JSON.stringify(report,null,2)+'\n');
console.log({...report,records:undefined});
