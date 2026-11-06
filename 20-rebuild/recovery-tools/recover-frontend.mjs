/** Offline source recovery, not original SFC/source-map restoration. */
import fs from 'node:fs';
import path from 'node:path';
import crypto from 'node:crypto';
import {createRequire} from 'node:module';
import {fileURLToPath} from 'node:url';
const workspace = path.resolve(path.dirname(fileURLToPath(import.meta.url)), '../..');
const root = path.join(workspace, '10-reverse/private/server/home/plm7/dist/static/js');
const out = path.join(workspace, '20-rebuild/recovery-tools/generated');
const docs = path.join(workspace, '20-rebuild/docs');
const require = createRequire(path.join(workspace, '20-rebuild/frontend-recovered/package.json'));
const {parse} = require('@babel/parser');
const esbuild = require('esbuild');
const hash = s => crypto.createHash('sha256').update(s).digest('hex');
const write = (name, value) => {const p=path.join(out,name);fs.mkdirSync(path.dirname(p),{recursive:true});fs.writeFileSync(p,value);};
const json = (name,value) => write(name,JSON.stringify(value,null,2)+'\n');
function walk(n,cb,parent=null,key=null) {if(!n||typeof n!=='object')return;if(n.type)cb(n,parent,key);for(const[k,v]of Object.entries(n)){if(k==='loc'||k==='comments'||k==='tokens')continue;if(Array.isArray(v))for(const q of v)walk(q,cb,n,k);else if(v&&typeof v==='object'&&v.type)walk(v,cb,n,k);}}
const ast = s => parse(s,{sourceType:'module',errorRecovery:false});
const vendorFile='vendor-7ae57976.js';
const entryFile='index-50216080.js';
const vendorSource=fs.readFileSync(path.join(root,vendorFile),'utf8');
const vendorAst=ast(vendorSource);
const vendorExports=vendorAst.program.body.filter(n=>n.type==='ExportNamedDeclaration').flatMap(n=>n.specifiers.map(s=>({alias:s.exported.name,symbol:s.local.name})));
const packages={};for(const name of ['vue','vue-router','vuex','element-plus','@element-plus/icons-vue','lodash','jsencrypt','vxe-pc-ui','vxe-table'])try{packages[name]=require(name)}catch{}
const installedNames = n => Object.keys(packages[n]||{});
const strip = s => s.replace(/\$\d+$/,'');
const pascal=s=>s.split('_').map(x=>x[0].toUpperCase()+x.slice(1)).join('');
const explicit={
 createStore:['vuex','createStore'],mapState:['vuex','mapState'],mapGetters:['vuex','mapGetters'],useStore:['vuex','useStore'],
 createBaseVNode:['vue','createElementVNode'],h:['vue','h'],
 zhCn:['element-plus/es/locale/lang/zh-cn','default'],
 QrcodeVue:['qrcode.vue','default'],convert:['convert-units','default'],hooks:['moment','default'],moment:['moment','default'],
 JSEncrypt:['jsencrypt','default'],axios:['axios','default'],Qs:['qs','default'],XLSX:['xlsx-legacy','default'],xlsxExports:['xlsx','*'],
 lodashExports:['lodash','*'],lodash:['lodash','default'],cloneDeep:['lodash','cloneDeep'],jrQrcode:['jr-qrcode','default'],
 PDFDocument:['pdf-lib','PDFDocument'],JSZip:['jszip','default'],NProgress:['nprogress','default'],Re:['vue3-tree-org','default'],
 commonjsRequire:['./build-helpers.mjs','commonjsRequire'],commonjsGlobal:['./build-helpers.mjs','commonjsGlobal'],
 getDefaultExportFromCjs:['./build-helpers.mjs','getDefaultExportFromCjs'],require$$4:['./build-helpers.mjs','browserExternal']
};
const maps=vendorExports.map(item=>{const symbol=explicit[item.symbol]?item.symbol:strip(item.symbol);let target;
 for(const name of ['vue','vue-router','element-plus'])if(installedNames(name).includes(symbol)){target=[name,symbol];break;}
 if(!target&&symbol.endsWith('_default')){let icon=pascal(symbol.slice(0,-8));if(installedNames('@element-plus/icons-vue').includes(icon))target=['@element-plus/icons-vue',icon];}
 if(!target)target=explicit[symbol];
 if(!target&&symbol.startsWith('Vxe'))target=[['VxeTable','VxeColumn','VxeColgroup','VxeGrid','VxeToolbar'].includes(symbol)?'vxe-table':'vxe-pc-ui',symbol];
 const packageName=target?.[0];const isHelper=packageName?.startsWith('./');let installed=false,exportPresent=false;
 if(packageName){try{const m=isHelper?null:require(packageName);installed=!!m;exportPresent=isHelper||target[1]==='default'||target[1]==='*'||target[1] in m;}catch{}}
 return{...item,package:packageName||null,export:target?.[1]||null,installed,export_present:exportPresent,
 status:!target?'unresolved':isHelper?'new_build_helper':installed&&exportPresent?'npm_export_verified':'package_inferred_not_installed',
 exact_original_version_verified:['vue','vue-router','@element-plus/icons-vue'].includes(packageName),runtime_equivalence_verified:false};
});
const mapByAlias=new Map(maps.map(x=>[x.alias,x]));
function npmImports(node) {
 return node.specifiers.map(spec => {
  if(spec.type!=='ImportSpecifier') throw Error('Unexpected vendor namespace/default import');
  const mapped=mapByAlias.get(namedKey(spec.imported));
  if(!mapped?.package) throw Error('Unresolved vendor export: '+namedKey(spec.imported));
  const pkg=mapped.package.startsWith('./')?'./runtime/'+mapped.package.slice(2):mapped.package;
  const binding=spec.local.name;
  if(mapped.export==='default')return 'import '+binding+' from '+JSON.stringify(pkg)+';';
  if(mapped.export==='*')return 'import * as '+binding+' from '+JSON.stringify(pkg)+';';
  return 'import { '+mapped.export+(mapped.export===binding?'':' as '+binding)+' } from '+JSON.stringify(pkg)+';';
 }).join('\n');
}
write('src/runtime/build-helpers.mjs',`// New helper implementation; never imports the shipped vendor bundle.\nexport const commonjsGlobal = globalThis;\nexport const browserExternal = {};\nexport function getDefaultExportFromCjs(value) { return value && value.__esModule && Object.hasOwn(value, 'default') ? value.default : value; }\nexport function commonjsRequire(name) { throw new Error('Unsupported dynamic dependency: ' + name); }\n`);
let bridge='// Third-party export bridge reconstructed from vendor symbol table.\n';
for(const m of maps){if(!m.package){bridge+=`// UNRESOLVED ${m.alias}: ${m.symbol}\n`;continue;}if(m.export==='*')bridge+=`import * as imported_${m.alias.replace(/\$/g,'Dollar')} from ${JSON.stringify(m.package)}; export { imported_${m.alias.replace(/\$/g,'Dollar')} as ${m.alias} };\n`;else bridge+=`export { ${m.export} as ${m.alias} } from ${JSON.stringify(m.package)};\n`;}
write('src/runtime/vendor-npm.mjs',bridge);
const ledger=JSON.parse(fs.readFileSync(path.join(docs,'frontend-component-ledger.json'),'utf8'));
const componentsByFile=new Map();for(const x of ledger.items){if(x.shipped_chunk){if(!componentsByFile.has(x.shipped_chunk))componentsByFile.set(x.shipped_chunk,[]);componentsByFile.get(x.shipped_chunk).push(x.component);}}
const records=[], failures=[];const moduleAsts=new Map();
const names = p => {const out=[];walk(p,n=>{if(n.type==='Identifier')out.push(n.name)});return out;};
function literal(n){if(!n)return null;if(['StringLiteral','NumericLiteral','BooleanLiteral'].includes(n.type))return n.value;if(n.type==='TemplateLiteral'&&n.expressions.length===0)return n.quasis[0].value.cooked;return null;}
const namedKey=n=>n?.name??n?.value;
for(const file of fs.readdirSync(root).filter(x=>x.endsWith('.js')&&x!==vendorFile).sort()){
 const source=fs.readFileSync(path.join(root,file),'utf8');let tree;try{tree=ast(source)}catch(e){failures.push({file,error:e.message});continue;}
 const imports=[],exports=[],dynamicImports=[],apiCalls=[],components=[],globalAccesses=new Set();
 for(const n of tree.program.body){if(n.type==='ImportDeclaration')imports.push({source:n.source.value,symbols:n.specifiers.map(s=>({import:s.type==='ImportDefaultSpecifier'?'default':s.type==='ImportNamespaceSpecifier'?'*':namedKey(s.imported),local:s.local.name}))});if(n.type==='ExportNamedDeclaration')for(const s of n.specifiers)exports.push({export:namedKey(s.exported),local:namedKey(s.local)});}
 walk(tree,n=>{
  if(n.type==='CallExpression'&&n.callee.type==='Import')dynamicImports.push({source:literal(n.arguments[0]),expression:source.slice(n.arguments[0].start,n.arguments[0].end)});
  if(n.type==='Identifier'&&['window','document','localStorage','sessionStorage','WebSocket','Worker','fetch','XMLHttpRequest'].includes(n.name))globalAccesses.add(n.name);
  if(n.type==='CallExpression'&&n.arguments[0]?.type==='ObjectExpression'){let props=Object.fromEntries(n.arguments[0].properties.filter(p=>p.type==='ObjectProperty').map(p=>[namedKey(p.key),p.value]));if(props.url&&props.method)apiCalls.push({callee:source.slice(n.callee.start,n.callee.end),module:literal(props.module),url:literal(props.url),url_expression:source.slice(props.url.start,props.url.end),method:literal(props.method),payload_keys:['params','data','body'].filter(k=>props[k]),source_offset:n.start});}
  if(n.type==='ObjectExpression'){const props=n.properties;const name=props.find(p=>p.type==='ObjectProperty'&&namedKey(p.key)==='__name');if(name){const prop=props.find(p=>p.type==='ObjectProperty'&&namedKey(p.key)==='props');const emits=props.find(p=>p.type==='ObjectProperty'&&namedKey(p.key)==='emits');components.push({name:literal(name.value),props:prop?.value.type==='ObjectExpression'?prop.value.properties.map(p=>namedKey(p.key)):[],emits:emits?.value.type==='ArrayExpression'?emits.value.elements.map(literal):[],source_offset:n.start});}}
 });
 const record={file,source_sha256:hash(source),source_bytes:Buffer.byteLength(source),components:componentsByFile.get(file)||[],imports,exports,dynamic_imports:dynamicImports,component_definitions:components,api_calls:apiCalls,browser_globals:[...globalAccesses],recovered_js_generated:true,original_sfc_restored:false,runtime_verified:false};records.push(record);
 // Rewrite only import source strings; preserve every application expression and binding.
 const patches=[];for(const n of tree.program.body)if(n.type==='ImportDeclaration'){
  if(n.source.value===`./${vendorFile}`){patches.push([n.start,n.end,npmImports(n)]);continue;}
  const old=n.source.value;let replacement=old===`./${vendorFile}`?'./runtime/vendor-npm.mjs':old===`./${entryFile}`?'./shared-runtime.mjs':old;
  if(replacement!==old)patches.push([n.source.start,n.source.end,JSON.stringify(replacement)]);
 }
 let rewritten=source;for(const[start,end,text]of patches.sort((a,b)=>b[0]-a[0]))rewritten=rewritten.slice(0,start)+text+rewritten.slice(end);
 if(file===entryFile){
  const bootIndex=tree.program.body.findIndex(n=>n.type==='VariableDeclaration'&&n.declarations.some(d=>d.id.type==='Identifier'&&d.id.name==='Co'&&d.init?.type==='CallExpression'));
  if(bootIndex<0)throw Error('Known application bootstrap boundary changed');
  const exportNode=tree.program.body.at(-1);if(exportNode.type!=='ExportNamedDeclaration')throw Error('Unexpected entry tail');
  // Do not auto-execute createApp/mount on import. Original pre-bootstrap browser side effects remain flagged.
  const importNode=tree.program.body[0];let initialImport=npmImports(importNode);
  write('src/shared/imports.fragment.js',initialImport+'\n');
  const statements=tree.program.body.slice(1,bootIndex);let segments=[];
  for(let i=0;i<statements.length;i+=50){const group=statements.slice(i,i+50);let code=group.map(n=>source.slice(n.start,n.end)).join('\n');const filename=`src/shared/segments/${String(i/50+1).padStart(3,'0')}.fragment.js`;write(filename,(await esbuild.transform(code,{loader:'js',format:'esm',legalComments:'inline',minify:false,charset:'utf8'})).code);segments.push({file:filename,statements:group.length,source_start:group[0].start,source_end:group.at(-1).end});}
  const bootNodes=tree.program.body.slice(bootIndex,-1);const boot=`export function startRecoveredApplication() {\n${bootNodes.map(n=>source.slice(n.start,n.end)).join('\n')}\n}\n`;
  write('src/shared/bootstrap.fragment.js',(await esbuild.transform(boot,{loader:'js',format:'esm'})).code);
  write('src/shared/exports.fragment.js',source.slice(exportNode.start,exportNode.end)+'\n');
  json('src/shared/assembly.json',{source_file:entryFile,source_sha256:hash(source),segments,order_preserved:true,bootstrap_extracted:true,pre_bootstrap_side_effects:statements.filter(n=>!['VariableDeclaration','FunctionDeclaration','ClassDeclaration'].includes(n.type)).map(n=>({type:n.type,start:n.start,preview:source.slice(n.start,Math.min(n.start+100,n.end))})),limitations:['Fragments intentionally share lexical scope and must be assembled in listed order. They are not independent ESM modules.','Top-level initializers and pre-bootstrap effects still require isolation review before a full application import.']});
  const full=initialImport+'\n'+segments.map(x=>fs.readFileSync(path.join(out,x.file),'utf8')).join('\n')+'\n'+fs.readFileSync(path.join(out,'src/shared/bootstrap.fragment.js'),'utf8')+'\n'+source.slice(exportNode.start,exportNode.end)+'\n';write('src/shared-runtime.mjs',full);
 }else write('src/'+file,(await esbuild.transform(rewritten,{loader:'js',format:'esm',legalComments:'inline',minify:false,charset:'utf8'})).code);
}
const declared=new Set(records.map(r=>r.file));declared.add(vendorFile);
const missingStatic=[];for(const rec of records)for(const imp of rec.imports)if(imp.source.startsWith('./')&&!declared.has(imp.source.slice(2)))missingStatic.push({file:rec.file,dependency:imp.source});
const componentItems=ledger.items.map(x=>({...x,source_recovery:x.shipped_chunk?{module:'recovery-tools/generated/src/'+x.shipped_chunk,generated:declared.has(x.shipped_chunk),form:'compiled setup/render JavaScript',sfc_template_restored:false,independent_build_status:'pending_shared_runtime_and_dependency_integration',runtime_equivalence_verified:false}:{module:'recovery-tools/generated/src/shared-runtime.mjs',generated:true,form:'inline component in recovered shared runtime',sfc_template_restored:false,independent_build_status:'pending_inline_symbol_mapping_and_integration',runtime_equivalence_verified:false}}));
const summary={generated_at:new Date().toISOString(),source_root:path.relative(workspace,root),vendor_source_sha256:hash(vendorSource),entry_source_sha256:hash(fs.readFileSync(path.join(root,entryFile))),application_js_modules:records.length,parse_failures:failures,missing_static_dependencies:missingStatic,vendor_exports:maps.length,vendor_npm_exports_installed_verified:maps.filter(m=>m.status==='npm_export_verified').length,vendor_packages_inferred_not_installed:maps.filter(m=>m.status==='package_inferred_not_installed').length,vendor_new_helpers:maps.filter(m=>m.status==='new_build_helper').length,vendor_unresolved:maps.filter(m=>m.status==='unresolved'),original_components:componentItems.length,separate_component_mappings:componentItems.filter(x=>x.shipped_chunk).length,inline_component_mappings:componentItems.filter(x=>!x.shipped_chunk).length,api_call_expressions:records.reduce((a,r)=>a+r.api_calls.length,0),fully_reconstructed_platform:false,original_vendor_copied_or_executed:false};
json('module-graph.json',{summary,modules:records});json('vendor-symbol-map.json',maps);json('component-coverage.json',{summary,items:componentItems});json('summary.json',summary);
fs.writeFileSync(path.join(docs,'frontend-full-recovery-summary.json'),JSON.stringify(summary,null,2)+'\n');
console.log(JSON.stringify(summary,null,2));
