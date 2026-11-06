import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import {fileURLToPath} from 'node:url';
import {parse} from '@babel/parser';
import {assemble} from './assemble.mjs';
const project=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..'),workspace=path.resolve(project,'../..');
const code=assemble(),ast=parse(code,{sourceType:'module'}),definitions=new Map();
for(const n of ast.program.body){if(n.type==='FunctionDeclaration')definitions.set(n.id.name,code.slice(n.start,n.end));if(n.type==='VariableDeclaration')for(const d of n.declarations)if(d.id.type==='Identifier'&&d.init)definitions.set(d.id.name,code.slice(d.init.start,d.init.end));}
const menu=JSON.parse(fs.readFileSync(path.join(workspace,'10-reverse/private/local-menu.json'))).data;
const root=(Array.isArray(menu)?menu:[menu]).find(x=>x.boolMainSystem);
const componentMap=new Map(JSON.parse(fs.readFileSync(path.join(workspace,'20-rebuild/docs/frontend-component-source-map.json'))).items.map(x=>[x.component,x]));
const context={ac:{layout:true},cw:{layout:true},rP:[],gP:[],EP:[],yP:[],uP:[],$e:{BRIDGE:{V:2}},Ni:{SELF:{V:1},PARTY_A:{V:2}},dP:(...parts)=>path.posix.resolve(...parts),Yw:component=>{const mapping=componentMap.get(component.replace(/^\//,'')+'.vue');if(!mapping)throw Error('Missing actual component '+component);return{component,source:mapping.source};}};
vm.createContext(context);vm.runInContext(['am','WN','im','ds'].map(n=>definitions.get(n)+';').join('\n')+'\nconst sc='+definitions.get('sc')+';this.recoverRoutes=sc;',context);
let tree;context.recoverRoutes((key,value)=>{if(key==='SET_TREE_ROUTES')tree=value},JSON.parse(JSON.stringify(root.children)));
const cases=[];function collect(nodes,module){for(const node of nodes||[]){if(node.component?.component)cases.push({title:node.meta.title,module,path:node.routePath,source:node.component.source});collect(node.children,module);}}
for(const module of root.children)collect(tree[module.id],module.meta?.title||module.name);
const target=path.join(workspace,'20-rebuild/docs/menu-page-smoke-cases.json');fs.writeFileSync(target,JSON.stringify(cases,null,2)+'\n');
const report={verified_at:new Date().toISOString(),cases:cases.length,unique_paths:new Set(cases.map(x=>x.path)).size,source:'actual recovered sc/ds/im/WN/am functions; terminal POSIX resolver uses node:path.posix.resolve on absolute route parents',scope:'363 concrete current-menu component entries; layout/group/external roots and old redirects excluded',redirect_used_for_page_path:false,duplicate_paths:cases.filter((x,i)=>cases.findIndex(y=>y.path===x.path)!==i),examples:cases.filter(x=>['CRM','配置管理'].includes(x.module)).slice(0,5)};
if(cases.length!==363||cases.some(x=>!x.path.startsWith('/')))throw Error('Unexpected current-menu page coverage');
fs.writeFileSync(path.join(workspace,'20-rebuild/docs/menu-page-smoke-provenance.json'),JSON.stringify(report,null,2)+'\n');console.log(report);
