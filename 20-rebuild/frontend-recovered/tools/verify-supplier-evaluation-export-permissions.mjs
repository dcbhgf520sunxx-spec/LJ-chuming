import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import {createRequire} from 'node:module';
import {fileURLToPath} from 'node:url';

const root=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..');
const source='src/views/supply-chain/supplier/evaluation-manage/evaluation-operate/module/detail-drawer.vue.js';
const code=fs.readFileSync(path.join(root,source),'utf8');
const {parse}=createRequire(path.join(root,'package.json'))('@babel/parser');
let component;
function walk(node){if(!node||typeof node!=='object')return;if(node.type==='ObjectExpression'&&node.properties.some(p=>p.key?.name==='__name'&&p.value?.value==='detail-drawer'))component=node;for(const[k,v]of Object.entries(node)){if(['loc','start','end'].includes(k))continue;if(Array.isArray(v))v.forEach(walk);else if(v?.type)walk(v);}}
walk(parse(code,{sourceType:'module'}));assert(component);
const checks=[];
function check(id,fn){try{fn();checks.push({id,status:'passed'});}catch(e){checks.push({id,status:'fail',error:e.message});}}
function scenario(permissions){
 const created=[],requests=[];
 const hasPermission=keys=>keys.some(key=>permissions.includes(key));
 const vnode=(tag,props,slots)=>{const node={tag,props:props||{},slots:slots||{}};created.push(node);return node;};
 const permissionMap={get:['scm_supplier_evaluate:get'],detail:['scm_supplier_evaluate:detail'],download:['scm_supplier_evaluate:download'],exportDetail:['scm_supplier_evaluate:detailDownload']};
 const context={Math,Number,String,JSON,console,g:fn=>({get value(){return fn();}}),d:value=>({value}),q:name=>name,m:()=>{},h:vnode,v:vnode,l:fn=>fn,w:x=>x,n:String,s:vnode,S:x=>x,W:(node,directives)=>directives.every(([directive,keys])=>directive!=='permission'||hasPermission(keys))?node:null,X:vnode,G:'Fragment',Q:(rows,fn)=>rows.map(fn),k:x=>x,Y:'Tag',Z:'Column',ee:'Table',te:'Card',ae:'loading',re:()=>({visible:{value:true},handleClose(){}}),le:()=>({maxHeight:{value:800}}),ie:'Download',ne:id=>{requests.push(id);return Promise.resolve('native-download');},supplierPermission:permissionMap,hasPermission,exportPermissionDirective:name=>name};
 const render=vm.runInNewContext('('+code.slice(component.start,component.end)+').setup({visible:true,detailRow:{id:123}},{emit(){}})',context);
 const drawer=render({},[]);const title=drawer.slots.titleRight();
 return{requests,visible:title.some(node=>node?.tag==='Download'),callback:created.find(node=>node.tag==='Download').props.fn};
}
for(const[name,permissions,allowed]of[
 ['roleless',[],false],
 ['get_only',['scm_supplier_evaluate:get'],false],
 ['detail_only',['scm_supplier_evaluate:detail'],false],
 ['summary_download_only',['scm_supplier_evaluate:download'],false],
 ['detail_download_only',['scm_supplier_evaluate:detailDownload'],true],
 ['detail_and_detail_download',['scm_supplier_evaluate:detail','scm_supplier_evaluate:detailDownload'],true],
 ['all',['scm_supplier_evaluate:get','scm_supplier_evaluate:detail','scm_supplier_evaluate:download','scm_supplier_evaluate:detailDownload'],true],
]){
 const s=scenario(permissions);
 check(name+'_drawer_download_visibility_requires_existing_detailDownload_leaf',()=>assert.equal(s.visible,allowed));
 await s.callback({evaluateId:123});
 check(name+'_direct_download_callback_requires_existing_detailDownload_leaf',()=>assert.deepEqual(s.requests,allowed?[123]:[]));
}
const result={verified_at:new Date().toISOString(),source,cases:checks.length,passed:checks.filter(x=>x.status==='passed').length,failed:checks.filter(x=>x.status==='fail').length,checks};
fs.writeFileSync(path.join(root,'supplier-evaluation-export-permissions-verification.json'),JSON.stringify(result,null,2)+'\n');
console.log(JSON.stringify(result));if(result.failed)process.exitCode=1;
