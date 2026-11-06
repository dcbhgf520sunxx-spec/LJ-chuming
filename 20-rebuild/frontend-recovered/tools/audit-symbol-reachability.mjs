import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import {fileURLToPath} from 'node:url';
import {parse,parseExpression} from '@babel/parser';
import {assemble} from './assemble.mjs';
const project=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..'),workspace=path.resolve(project,'../..');
const main='src/shared/runtime.js';
const sourceMap=JSON.parse(fs.readFileSync(path.join(project,'source-map.json'))).modules;
const sourceFiles=new Set(sourceMap.map(x=>x.source));
const components=JSON.parse(fs.readFileSync(path.join(workspace,'20-rebuild/docs/frontend-component-source-map.json'))).items;
const byComponent=new Map(components.map(x=>[x.component,x]));
const original=fs.readFileSync(path.join(workspace,'10-reverse/private/server/home/plm7/dist/static/js/index-50216080.js'),'utf8');
const menuAudit=JSON.parse(fs.readFileSync(path.join(project,'menu-request-reachability.json')));
const stop=new Set(['_e','As','W','jN','L9','rc','k2','A9','QV']);
function walk(n,cb,parent=null,key=null){if(!n||typeof n!=='object')return;if(n.type)cb(n,parent,key);for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(Array.isArray(v))v.forEach(x=>walk(x,cb,n,k));else if(v?.type)walk(v,cb,n,k);}}
function bindings(pattern,out=new Set()){if(!pattern)return out;if(pattern.type==='Identifier')out.add(pattern.name);else if(pattern.type==='RestElement')bindings(pattern.argument,out);else if(pattern.type==='AssignmentPattern')bindings(pattern.left,out);else if(pattern.type==='ObjectPattern')pattern.properties.forEach(p=>bindings(p.value||p.argument,out));else if(pattern.type==='ArrayPattern')pattern.elements.forEach(p=>bindings(p,out));return out;}
function blockBindings(body){const out=new Set();for(const n of body||[])if(n.type==='VariableDeclaration')for(const d of n.declarations)bindings(d.id,out);else if((n.type==='FunctionDeclaration'||n.type==='ClassDeclaration')&&n.id)out.add(n.id.name);return out;}
// Lexical scopes matter: render callbacks routinely reuse short names from module imports.
function freeRefs(root,known){const found=new Set(),dynamic=[];const isLocal=(s,name)=>s.some(x=>x.has(name));
 function visit(n,scopes=[],parent=null,key=null){if(!n?.type)return;
  if(['FunctionDeclaration','FunctionExpression','ArrowFunctionExpression','ObjectMethod','ClassMethod'].includes(n.type)){
   const own=new Set();if(n.id)own.add(n.id.name);for(const p of n.params)bindings(p,own);
   // var is function-scoped even when declared in a nested block.
   function collectVars(v){if(!v?.type)return;if(v!==n&&['FunctionDeclaration','FunctionExpression','ArrowFunctionExpression','ObjectMethod','ClassMethod'].includes(v.type))return;if(v.type==='VariableDeclaration'&&v.kind==='var')v.declarations.forEach(d=>bindings(d.id,own));for(const[k,x]of Object.entries(v)){if(k==='loc')continue;if(Array.isArray(x))x.forEach(collectVars);else if(x?.type)collectVars(x);}}
   collectVars(n.body);const nested=[...scopes,own];for(const p of n.params)if(p.type==='AssignmentPattern')visit(p.right,nested,p,'right');visit(n.body,nested,n,'body');return;
  }
  if(n.type==='BlockStatement'){const nested=[...scopes,blockBindings(n.body)];for(const x of n.body)visit(x,nested,n,'body');return;}
  if(n.type==='CatchClause'){const own=bindings(n.param);visit(n.body,[...scopes,own],n,'body');return;}
  if(['ForStatement','ForOfStatement','ForInStatement'].includes(n.type)){const decl=n.init||n.left,own=new Set();if(decl?.type==='VariableDeclaration')decl.declarations.forEach(d=>bindings(d.id,own));for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(v?.type)visit(v,[...scopes,own],n,k);}return;}
  if(n.type==='Identifier'){
   const skip=(parent?.type==='MemberExpression'&&key==='property'&&!parent.computed)||(['ObjectProperty','ObjectMethod','ClassMethod'].includes(parent?.type)&&key==='key'&&!parent.computed)||(parent?.type==='VariableDeclarator'&&key==='id')||(parent?.type==='ClassDeclaration'&&key==='id')||['LabeledStatement','BreakStatement','ContinueStatement'].includes(parent?.type);
   if(!skip&&!isLocal(scopes,n.name)&&known.has(n.name))found.add(n.name);
  }
  if(n.type==='CallExpression'&&n.callee.type==='Import'&&n.arguments[0]?.type==='StringLiteral')dynamic.push(n.arguments[0].value);
  for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(Array.isArray(v))v.forEach(x=>visit(x,scopes,n,k));else if(v?.type)visit(v,scopes,n,k);}
 }
 visit(root);return{names:[...found],dynamic};
}
// Self-check shadowing against real lexical examples before trusting business reachability.
const fixture=parse('const f=(x)=>{let y; return x+y+external};',{sourceType:'module'}).program.body[0].declarations[0].init;
if(JSON.stringify(freeRefs(fixture,new Set(['x','y','external'])).names)!=='["external"]')throw Error('Lexical reference self-check failed');
const cache=new Map();
function target(from,request){if(!request.startsWith('.'))return null;const normalized=path.posix.normalize(path.posix.join(path.posix.dirname(from),request));return sourceFiles.has(normalized)?normalized:null;}
function load(file){if(cache.has(file))return cache.get(file);const code=file===main?assemble():fs.readFileSync(path.join(project,file),'utf8'),ast=parse(code,{sourceType:'module'});const item={file,code,decls:new Map(),imports:new Map(),exports:new Map(),effects:[],sideImports:[],deps:new Map()};cache.set(file,item);
 const addDeclaration=n=>{if(n.type==='VariableDeclaration')for(const d of n.declarations){if(d.id.type==='Identifier')item.decls.set(d.id.name,d.init||d);}else if((n.type==='FunctionDeclaration'||n.type==='ClassDeclaration')&&n.id)item.decls.set(n.id.name,n);};
 for(const n of ast.program.body){
  if(n.type==='ImportDeclaration'){const dependency=target(file,n.source.value);if(dependency){item.sideImports.push(dependency);for(const s of n.specifiers)item.imports.set(s.local.name,{file:dependency,export:s.type==='ImportDefaultSpecifier'?'default':s.type==='ImportNamespaceSpecifier'?'*':s.imported.name||s.imported.value});}}
  else if(n.type==='ExportNamedDeclaration'){if(n.declaration){addDeclaration(n.declaration);for(const d of n.declaration.declarations||[])if(d.id.type==='Identifier')item.exports.set(d.id.name,d.id.name);if(n.declaration.id)item.exports.set(n.declaration.id.name,n.declaration.id.name);}for(const s of n.specifiers)item.exports.set(s.exported.name||s.exported.value,s.local.name||s.local.value);}
  else if(n.type==='ExportDefaultDeclaration'){if(n.declaration.type==='Identifier')item.exports.set('default',n.declaration.name);else{item.decls.set('__default__',n.declaration);item.exports.set('default','__default__');}}
  else if(['VariableDeclaration','FunctionDeclaration','ClassDeclaration'].includes(n.type))addDeclaration(n);
  else if(n.type!=='EmptyStatement'){const key='__effect_'+item.effects.length;item.decls.set(key,n);item.effects.push(key);}
 }
 item.known=new Set([...item.decls.keys(),...item.imports.keys()]);return item;
}
const queue=[],seen=new Set(),loadedModules=new Set(),unknownExports=[],origins=new Map();
function addDecl(file,name,origin){if(file===main&&stop.has(name))return;const key=file+'#'+name;if(!seen.has(key)){seen.add(key);origins.set(key,origin);queue.push({file,name});}}
function activateModule(file,origin){if(loadedModules.has(file))return;loadedModules.add(file);const m=load(file);if(file!==main){for(const name of m.effects)addDecl(file,name,origin);for(const dependency of m.sideImports)activateModule(dependency,origin);}}
function addExport(file,exportName,origin){activateModule(file,origin);const m=load(file);if(exportName==='*'){for(const local of m.exports.values())addDecl(file,local,origin);return;}const name=m.exports.get(exportName);if(!name){unknownExports.push({file,export:exportName,origin});return;}addDecl(file,name,origin);}
const rootSelectors=[];
for(const menu of menuAudit.menus){const component=byComponent.get(menu.component);if(!component)continue;const origin={menu_id:menu.id,module:menu.module,component:menu.component};if(component.inline_namespace){addDecl(main,component.inline_namespace,origin);continue;}let selector='default';const snippet=original.slice(component.original_mapping_start,component.original_mapping_end);walk(parseExpression('({'+snippet+'})'),n=>{if(n.type==='CallExpression'&&n.callee.type==='MemberExpression'&&n.callee.property.name==='then'){const body=n.arguments[0]?.body;if(body?.type==='MemberExpression'&&body.object.type==='Identifier')selector=body.property.name||body.property.value;}});rootSelectors.push({component:menu.component,source:component.source,export:selector});addExport(component.source,selector,origin);}
while(queue.length){const{file,name}=queue.pop(),m=load(file),origin=origins.get(file+'#'+name);if(m.imports.has(name)){const dependency=m.imports.get(name);addExport(dependency.file,dependency.export,origin);continue;}const node=m.decls.get(name);if(!node)continue;let refs=m.deps.get(name);if(!refs){refs=freeRefs(node,m.known);m.deps.set(name,refs);}for(const symbol of refs.names)addDecl(file,symbol,origin);for(const request of refs.dynamic){const dependency=target(file,request);if(dependency)addExport(dependency,'*',origin);}}
const review=JSON.parse(fs.readFileSync(path.join(project,'current-menu-route-review.json')));
const records=review.requests.map(request=>{const m=load(request.source),owners=[...m.decls].filter(([,n])=>n.start<=request.offset&&n.end>=request.offset).sort((a,b)=>(a[1].end-a[1].start)-(b[1].end-b[1].start)),owner=owners[0]?.[0]||null,key=request.source+'#'+owner;return{...request,lexical_owner:owner,selected_export_reachable:seen.has(key),selected_export_menu_witness:origins.get(key)||null};});
const report={verified_at:new Date().toISOString(),current_menu_components:rootSelectors.length,loaded_modules:loadedModules.size,reachable_bindings:seen.size,unknown_export_selections:unknownExports,scope:'Actual component callback export selectors; lexical top-level binding/import graph. CRUD object properties and runtime branch conditions remain conservative.',limitations:['Reachability is potential execution, not proof of action invocation or permission acceptance.','Object property reads conservatively include the referenced object; disabled CRUD operations and overwritten methods need per-view source checks.','Dynamic imports select all exported symbols conservatively unless they were menu component callbacks.','Central Vuex/router/HTTP infrastructure are terminal bindings to avoid incorrectly rooting every optional module.'],rootSelectors,records};
fs.writeFileSync(path.join(project,'selected-export-route-reachability.json'),JSON.stringify(report,null,2)+'\n');console.log({...report,rootSelectors:undefined,records:records.map(x=>({method:x.method,path:x.path_pattern,owner:x.lexical_owner,reachable:x.selected_export_reachable}))});
