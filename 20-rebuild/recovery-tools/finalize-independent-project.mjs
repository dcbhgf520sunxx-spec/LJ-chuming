/** One-time explicit materialization adaptation. Never run automatically by npm build. */
import fs from'node:fs';import path from'node:path';import{createRequire}from'node:module';import{fileURLToPath}from'node:url';
const root=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'../..');const project=path.join(root,'20-rebuild/frontend-recovered');const r=createRequire(path.join(project,'package.json'));const{parse}=r('@babel/parser');
const write=(n,s)=>{const f=path.join(project,n);fs.mkdirSync(path.dirname(f),{recursive:true});fs.writeFileSync(f,s)};
function walk(n,cb){if(!n||typeof n!=='object')return;if(n.type)cb(n);for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(Array.isArray(v))v.forEach(x=>walk(x,cb));else if(v?.type)walk(v,cb);}}
const functions={
 or:'function or() { return JSON.parse(sessionStorage.getItem("ljaps-recovered-token") || "null"); }',
 JV:'function JV(token) { sessionStorage.setItem("ljaps-recovered-token", JSON.stringify(token)); return token; }',
 bA:'function bA() { sessionStorage.removeItem("ljaps-recovered-token"); }',
 yn:'function yn() { return location.origin; }',
 XV:'function XV() { return location.origin; }',
 VA:'function VA() { return undefined; }',
 grt:'function grt() { return ""; }'
};
const adaptations=[];
const importsPath=path.join(project,'src/shared/imports.fragment.js');fs.writeFileSync(importsPath,fs.readFileSync(importsPath,'utf8').replaceAll('element-plus/es/locale/lang/zh-cn.mjs','element-plus/es/locale/lang/zh-cn'));

const assembly=JSON.parse(fs.readFileSync(path.join(project,'src/shared/assembly.json')));
for(const entry of assembly.segments){const relative=entry.file.replace('src/shared/','src/shared/');const filename=path.join(project,relative);let s=fs.readFileSync(filename,'utf8');const a=parse(s,{sourceType:'module'}),patches=[];walk(a,n=>{
 if(n.type==='FunctionDeclaration'&&functions[n.id?.name]){patches.push([n.start,n.end,functions[n.id.name]]);adaptations.push({symbol:n.id.name,file:relative,reason:n.id.name==='grt'?'disable original embedded-private-key password recovery':'isolate local request origin and session-only token'});}
 if(n.type==='VariableDeclarator'&&['o9','n9'].includes(n.id?.name)){patches.push([n.init.start,n.init.end,n.id.name==='o9'?'window.__REBUILD_PUBLIC_KEY__':'null']);adaptations.push({symbol:n.id.name,file:relative,reason:n.id.name==='o9'?'new backend public key loaded before module import':'remove original embedded private key'});}
 if(n.type==='VariableDeclarator'&&n.id?.name==='d'&&n.init?.type==='FunctionExpression'&&!s.slice(n.start,n.end).includes('.filter(asset')){patches.push([n.init.body.start+1,n.init.body.start+1,'\n n = (n || []).filter(asset => asset.endsWith(".css"));\n']);adaptations.push({symbol:'d',file:relative,reason:'preload recovered CSS only; never request original JS/vendor'});}
 });for(const[a,b,v]of patches.sort((a,b)=>b[0]-a[0]))s=s.slice(0,a)+v+s.slice(b);fs.writeFileSync(filename,s);}
const original=fs.readFileSync(path.join(root,'10-reverse/private/server/home/plm7/dist/static/js/index-50216080.js'),'utf8');const oa=parse(original,{sourceType:'module'}),inline=[];
walk(oa,n=>{if(n.type!=='ObjectProperty'||n.key.type!=='StringLiteral'||!n.key.value.startsWith('../../views/')||n.value.type!=='ArrowFunctionExpression')return;let ns;walk(n.value,call=>{if(call.type==='CallExpression'&&call.callee?.type==='MemberExpression'&&call.callee.property?.name==='then'&&call.arguments[0]?.body?.type==='Identifier')ns=call.arguments[0].body;});if(ns?.type==='Identifier')inline.push({component:n.key.value.slice('../../views/'.length),namespace:ns.name,map_source_offset:n.start});});
const declarations=new Map();walk(oa,n=>{if(n.type==='VariableDeclarator'&&n.id.type==='Identifier')declarations.set(n.id.name,n);});
const extra=[];for(let i=0;i<inline.length;i++){const it=inline[i],alias='recoveredInline_'+i;extra.push(`export { ${it.namespace} as ${alias} };`);const dest='src/views/'+it.component+'.js';let rel=path.posix.relative(path.posix.dirname(dest),'src/shared/runtime.js');if(!rel.startsWith('.'))rel='./'+rel;write(dest,`// Recovered inline component. See inline-components.json for owning statement/source fragment.\nimport { ${alias} } from ${JSON.stringify(rel)};\nexport default ${alias}.default;\n`);const declaration=declarations.get(it.namespace);const seg=assembly.segments.find(s=>declaration&&s.source_start<=declaration.start&&s.source_end>=declaration.end);Object.assign(it,{adapter:dest,definition_fragment:seg?.file||null,definition_source_start:declaration?.start||null,definition_source_end:declaration?.end||null,alias});}
write('src/shared/inline-exports.fragment.js',extra.join('\n')+'\n');write('inline-components.json',JSON.stringify(inline,null,2)+'\n');write('runtime-adaptations.json',JSON.stringify({adaptations,original_private_key_present_in_active_source:false,original_password_decryption_disabled:true,raw_jwt:true},null,2)+'\n');
// Placeholder marks ownership clearly; Vite plugin reads the editable fragments in memory.
write('src/shared/runtime.js','// Generated in memory by tools/assemble.mjs. Edit the source fragments under this directory.\n');
console.log(JSON.stringify({adaptations:adaptations.length,inline_components:inline.length,private_key_removed:true}));
