import fs from 'node:fs';
import crypto from 'node:crypto';
import path from 'node:path';
import {createRequire} from 'node:module';
import {fileURLToPath} from 'node:url';
import {assemble} from './assemble.mjs';
const project=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..'),workspace=path.resolve(project,'../..');
const {parse}=createRequire(path.join(project,'package.json'))('@babel/parser');
const originalMain='index-50216080.js';
const graph=JSON.parse(fs.readFileSync(path.join(workspace,'20-rebuild/recovery-tools/generated/module-graph.json'))).modules;
const nodes=new Map(graph.map(x=>[x.file,x]));
const componentMap=JSON.parse(fs.readFileSync(path.join(workspace,'20-rebuild/docs/frontend-component-source-map.json'))).items;
const byComponent=new Map(componentMap.map(x=>[x.component,x]));
const menuBytes=fs.readFileSync(path.join(workspace,'10-reverse/private/local-menu.json'));
const response=JSON.parse(menuBytes);
const roots=Array.isArray(response.data)?response.data:[response.data];
const internal=roots.find(x=>x.boolMainSystem),menus=[];
function menuWalk(n,module){if(n.component&&n.component!=='Layout')menus.push({id:n.id,title:n.meta?.title,module,component:n.component.replace(/^\//,'')+'.vue',route_path:n.path});for(const c of n.children||[])menuWalk(c,module);}
for(const module of internal.children||[])menuWalk(module,module.meta?.title||module.name);
function walk(n,cb,parent=null,key=null){if(!n||typeof n!=='object')return;if(n.type)cb(n,parent,key);for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(Array.isArray(v))v.forEach(x=>walk(x,cb,n,k));else if(v?.type)walk(v,cb,n,k);}}
const code=assemble(),ast=parse(code,{sourceType:'module'}),declarations=new Map();
for(const n of ast.program.body){if(n.type==='FunctionDeclaration'&&n.id)declarations.set(n.id.name,n);if(n.type==='VariableDeclaration')for(const d of n.declarations)if(d.id.type==='Identifier')declarations.set(d.id.name,d);}
const exports=new Map(nodes.get(originalMain).exports.map(x=>[x.export,x.local]));
// Infrastructure objects lead to the complete route registry or every Vuex module. Do not
// treat their mere import as executing every business module in the distributed product.
const infrastructureStops=new Set(['_e','As','W','jN','L9','rc','k2','A9','QV']);
const chunks=new Set(),symbols=new Set(),chunkQueue=[],symbolQueue=[],missing=[],chunkOrigins=new Map(),symbolOrigins=new Map();
const nextWitness=(origin,step)=>origin?{...origin,chain:[...origin.chain,step]}:null;
const addChunk=(f,origin)=>{if(f&&f!==originalMain&&!f.includes('vendor-')&&nodes.has(f)&&!chunks.has(f)){chunks.add(f);chunkOrigins.set(f,nextWitness(origin,f));chunkQueue.push(f);}};
const addSymbol=(s,origin)=>{if(s&&declarations.has(s)&&!infrastructureStops.has(s)&&!symbols.has(s)){symbols.add(s);symbolOrigins.set(s,nextWitness(origin,'shared:'+s));symbolQueue.push(s);}};
for(const menu of menus){const mapping=byComponent.get(menu.component);if(!mapping){missing.push(menu);continue;}menu.shipped_chunk=mapping.shipped_chunk;menu.source=mapping.source;const origin={menu_id:menu.id,menu_title:menu.title,module:menu.module,component:menu.component,chain:[]};if(mapping.inline_namespace)addSymbol(mapping.inline_namespace,origin);else addChunk(mapping.shipped_chunk,origin);}
while(chunkQueue.length||symbolQueue.length){
 while(chunkQueue.length){const name=chunkQueue.pop(),module=nodes.get(name),origin=chunkOrigins.get(name);for(const dep of module.imports){const file=path.posix.basename(dep.source);if(file===originalMain)for(const symbol of dep.symbols)addSymbol(exports.get(symbol.import),origin);else addChunk(file,origin);}for(const dep of module.dynamic_imports)addChunk(path.posix.basename(dep.source||''),origin);}
 while(symbolQueue.length){const name=symbolQueue.pop(),node=declarations.get(name),origin=symbolOrigins.get(name);walk(node,(n,parent,key)=>{
   if(n.type==='Identifier'&&!(parent?.type==='MemberExpression'&&key==='property'&&!parent.computed)&&!((parent?.type==='ObjectProperty'||parent?.type==='ObjectMethod')&&key==='key'&&!parent.computed))addSymbol(n.name,origin);
   if(n.type==='CallExpression'&&n.callee.type==='Import'&&n.arguments[0]?.type==='StringLiteral')addChunk(path.posix.basename(n.arguments[0].value),origin);
 });}
}
const audit=JSON.parse(fs.readFileSync(path.join(project,'request-route-audit.json')));
function ownerAt(offset){return [...declarations].filter(([,n])=>n.start<=offset&&n.end>=offset).sort((a,b)=>(a[1].end-a[1].start)-(b[1].end-b[1].start))[0]?.[0]||null;}
const records=audit.records.map(r=>{const shared=r.original_chunk===originalMain,owner=shared?ownerAt(r.offset):null;return {...r,shared_top_level_owner:owner,menu_witness:shared?symbolOrigins.get(owner)||null:chunkOrigins.get(r.original_chunk)||null,menu_scope:shared?(owner&&symbols.has(owner)?'shared-symbol-reachable-conservative':'shared-not-attributed-to-current-menu'):chunks.has(r.original_chunk)?'current-menu-import-closure':'outside-current-menu-import-closure'};});
const unmatched=records.filter(x=>x.runtime_classification?x.runtime_classification==='no-registered-route-match':x.classification==='no-static-route-candidate');
const counts=Object.fromEntries([...new Set(records.map(x=>x.menu_scope))].map(scope=>[scope,{all_request_configs:records.filter(x=>x.menu_scope===scope).length,unmatched_request_configs:unmatched.filter(x=>x.menu_scope===scope).length}]));
const report={verified_at:new Date().toISOString(),menu_source:'10-reverse/private/local-menu.json',internal_root_id:internal.id,internal_modules:internal.children.map(x=>x.meta?.title||x.name),external_system_roots:roots.filter(x=>!x.boolMainSystem).map(x=>({id:x.id,name:x.name,redirect:x.redirect,component:x.component,source_present:false})),menu_components:menus.length,missing_menu_component_mappings:missing,nonshared_import_closure_modules:chunks.size,shared_dependency_symbols_conservative:symbols.size,infrastructure_stops:[...infrastructureStops],request_scope_counts:counts,unmatched_current_menu_unique_paths:[...new Set(unmatched.filter(x=>['current-menu-import-closure','shared-symbol-reachable-conservative'].includes(x.menu_scope)).map(x=>x.method+' '+x.path_pattern))].sort(),unmatched_shared_unattributed_unique_paths:[...new Set(unmatched.filter(x=>x.menu_scope==='shared-not-attributed-to-current-menu').map(x=>x.method+' '+x.path_pattern))].sort(),runtime_verified:false,limitations:['Module import reachability is potential exposure, not proof that a request is executed or a permission grants its action.','Shared-symbol traversal is conservative and not a full lexical call-graph analysis; infrastructure/store/router request objects are reported separately.','The global component registry is deliberately not traversed from the central router/store, as it contains all optional product modules.','Standalone external systems have menu links but no frontend/backend implementation in this platform backup.'],menus,reachable_modules:[...chunks].sort(),shared_symbols:[...symbols].sort(),records};
fs.writeFileSync(path.join(project,'menu-request-reachability.json'),JSON.stringify(report,null,2)+'\n');console.log({...report,menus:undefined,reachable_modules:undefined,shared_symbols:undefined,records:undefined});
const isBridge=x=>/\/bridge(?:\/|-)/.test(x.path_pattern);
const current=unmatched.filter(x=>['current-menu-import-closure','shared-symbol-reachable-conservative'].includes(x.menu_scope)&&!isBridge(x));
const focused={verified_at:report.verified_at,menu_source:report.menu_source,menu_source_sha256:crypto.createHash('sha256').update(menuBytes).digest('hex'),runtime_route_source:audit.runtime_route_source,runtime_route_source_sha256:audit.runtime_route_source_sha256,runtime_registered_mappings:audit.runtime_registered_mappings,runtime_route_started_epoch_millis:audit.runtime_route_started_epoch_millis,internal_menu_modules:internal.children.length,menu_components:menus.length,nonshared_import_closure:chunks.size,unmatched_total:unmatched.length,unmatched_bridge_requests:unmatched.filter(isBridge).length,current_menu_nonshared_unmatched_nonbridge:unmatched.filter(x=>x.menu_scope==='current-menu-import-closure'&&!isBridge(x)).length,current_menu_shared_conservative_unmatched_nonbridge:unmatched.filter(x=>x.menu_scope==='shared-symbol-reachable-conservative'&&!isBridge(x)).length,remaining_internal_review_unique_request_patterns:new Set(current.map(x=>x.method+' '+x.path_pattern)).size,external_systems:report.external_system_roots,requests:current.map(x=>({...x,path_status:'needs-bytecode-or-proxy-verification',menu_witness_strength:x.menu_scope==='current-menu-import-closure'?'module-import-closure':'conservative-shared-symbol-chain'})),boundary:'Potential current-menu dependency exposure only. Verify controller bytecode, method/parameter conditions, and original proxy routing before changing any URL or declaring API missing.'};
fs.writeFileSync(path.join(project,'current-menu-route-review.json'),JSON.stringify(focused,null,2)+'\n');
