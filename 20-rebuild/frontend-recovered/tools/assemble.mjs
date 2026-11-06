// Build-time composition reads editable source fragments and never overwrites them.
import fs from'node:fs';import path from'node:path';import{createRequire}from'node:module';import{fileURLToPath}from'node:url';
const project=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..');const r=createRequire(path.join(project,'package.json'));const{parse}=r('@babel/parser');
const map=JSON.parse(fs.readFileSync(path.join(project,'source-map.json'))).modules;const byOld=new Map(map.map(x=>[x.original_chunk,x.source]));
function walk(n,cb){if(!n||typeof n!=='object')return;if(n.type)cb(n);for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(Array.isArray(v))v.forEach(x=>walk(x,cb));else if(v?.type)walk(v,cb);}}
export function assemble(){
 const a=JSON.parse(fs.readFileSync(path.join(project,'src/shared/assembly.json')));
 const read=n=>fs.readFileSync(path.join(project,'src/shared',n),'utf8');
 const code=read('imports.fragment.js')+'\n'+a.segments.map(x=>fs.readFileSync(path.join(project,x.file),'utf8')).join('\n')+'\n'+read('bootstrap.fragment.js')+'\n'+read('exports.fragment.js')+'\n'+read('inline-exports.fragment.js');
 const patches=[];walk(parse(code,{sourceType:'module'}),n=>{let v;if(n.type==='ImportDeclaration')v=n.source;else if(n.type==='CallExpression'&&n.callee.type==='Import')v=n.arguments[0];if(v?.type!=='StringLiteral'||!v.value.startsWith('./'))return;
 let dest=v.value.startsWith('./runtime/')?'src/runtime/'+v.value.slice('./runtime/'.length):byOld.get(v.value.slice(2));if(dest){let rel=path.posix.relative('src/shared',dest);if(!rel.startsWith('.'))rel='./'+rel;patches.push([v.start,v.end,JSON.stringify(rel)]);}});
 let out=code;for(const[a,b,t]of patches.sort((a,b)=>b[0]-a[0]))out=out.slice(0,a)+t+out.slice(b);return out;
}
export function recoveredSharedRuntime(){return{name:'editable-recovered-shared-runtime',enforce:'pre',load(id){if(id.split('?')[0]===path.join(project,'src/shared/runtime.js'))return assemble();}};}
