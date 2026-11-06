/** Materialize editable modules in original view directories; never copy vendor/business dist JS. */
import fs from 'node:fs';import path from 'node:path';import{createRequire}from'node:module';import{fileURLToPath}from'node:url';
const workspace=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'../..');
const base=path.join(workspace,'20-rebuild/recovery-tools/generated');const project=path.join(workspace,'20-rebuild/frontend-recovered');
const require=createRequire(path.join(workspace,'20-rebuild/frontend/package.json'));const{parse}=require('@babel/parser');
const ledger=JSON.parse(fs.readFileSync(path.join(workspace,'20-rebuild/docs/frontend-component-source-map.json')));
const graph=JSON.parse(fs.readFileSync(path.join(base,'module-graph.json')));
const target=new Map(graph.modules.map(m=>[m.file,m.file==='index-50216080.js'?'src/shared/runtime.js':'src/modules/'+m.file]));
for(const x of ledger.items)if(x.shipped_chunk)target.set(x.shipped_chunk,'src/views/'+x.component+'.js');
const write=(p,v)=>{let f=path.join(project,p);fs.mkdirSync(path.dirname(f),{recursive:true});fs.writeFileSync(f,v)};
const rel=(from,to)=>{const v=path.posix.relative(path.posix.dirname(from),to);return v.startsWith('.')?v:'./'+v;};
function visit(n,cb){if(!n||typeof n!=='object')return;if(n.type)cb(n);for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(Array.isArray(v))v.forEach(q=>visit(q,cb));else if(v?.type)visit(v,cb);}}
function rewrite(source,to){const a=parse(source,{sourceType:'module'}),patches=[];visit(a,n=>{let key;if(n.type==='ImportDeclaration'||n.type==='ExportNamedDeclaration'&&n.source||n.type==='ExportAllDeclaration')key=n.source;else if(n.type==='CallExpression'&&n.callee.type==='Import')key=n.arguments[0];if(!key||key.type!=='StringLiteral'||!key.value.startsWith('./'))return;
 let map;if(key.value==='./shared-runtime.mjs')map='src/shared/runtime.js';else if(key.value.startsWith('./runtime/'))map='src/runtime/'+key.value.slice('./runtime/'.length);else map=target.get(key.value.slice(2));if(map)patches.push([key.start,key.end,JSON.stringify(rel(to,map))]);});let s=source;for(const[a,b,v]of patches.sort((a,b)=>b[0]-a[0]))s=s.slice(0,a)+v+s.slice(b);return s;}
const mapping=[];
for(const mod of graph.modules){const dest=target.get(mod.file);const src=mod.file==='index-50216080.js'?'shared-runtime.mjs':mod.file;const source=fs.readFileSync(path.join(base,'src',src),'utf8');write(dest,rewrite(source,dest));mapping.push({original_chunk:mod.file,source:dest,original_sha256:mod.source_sha256,view_components:ledger.items.filter(x=>x.shipped_chunk===mod.file).map(x=>x.component)});}
for(const n of ['build-helpers.mjs'])write('src/runtime/'+n,fs.readFileSync(path.join(workspace,'20-rebuild/recovery-tools/build-helpers.template.mjs')));
const assembly=JSON.parse(fs.readFileSync(path.join(base,'src/shared/assembly.json')));
for(const n of ['imports.fragment.js','bootstrap.fragment.js','exports.fragment.js',...assembly.segments.map(s=>s.file.replace('src/shared/',''))])write('src/shared/'+n,fs.readFileSync(path.join(base,'src/shared',n)));
write('src/shared/assembly.json',JSON.stringify(assembly,null,2)+'\n');
write('source-map.json',JSON.stringify({original_vendor_used:false,original_sfc_templates_restored:false,modules:mapping,component_ledger:'../docs/frontend-component-ledger.json'},null,2)+'\n');
const dist=path.join(workspace,'10-reverse/private/server/home/plm7/dist');
for(const n of ['static/css','static/png','static/jpg','static/svg','static/woff','static/ttf','assets']){if(fs.existsSync(path.join(dist,n)))fs.cpSync(path.join(dist,n),path.join(project,'public',n),{recursive:true});}
const top=fs.readdirSync(path.join(dist,'static'));for(const n of top)if(n!=='js'&&!fs.existsSync(path.join(project,'public/static',n)))fs.cpSync(path.join(dist,'static',n),path.join(project,'public/static',n),{recursive:true});
console.log(JSON.stringify({modules:mapping.length,view_source_modules:mapping.filter(x=>x.view_components.length).length,shared_segments:assembly.segments.length,original_vendor_used:false}));
