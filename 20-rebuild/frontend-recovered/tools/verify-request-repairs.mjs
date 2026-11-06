import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import {fileURLToPath} from 'node:url';
import {parse} from '@babel/parser';
import * as Vue from 'vue';
import {localAttachmentUrl,normalizeAttachmentUrls} from '../src/runtime/attachments.js';
const project=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..'),read=p=>fs.readFileSync(path.join(project,p),'utf8');
function walk(n,cb){if(!n||typeof n!=='object')return;if(n.type)cb(n);for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(Array.isArray(v))v.forEach(x=>walk(x,cb));else if(v?.type)walk(v,cb);}}
function declaration(code,name){let found;walk(parse(code,{sourceType:'module'}),n=>{if(n.type==='FunctionDeclaration'&&n.id.name===name)found=code.slice(n.start,n.end);if(n.type==='VariableDeclarator'&&n.id.name===name)found=code.slice(n.init.start,n.init.end);});assert(found,name);return found;}
let cases=0;
for(const host of ['https://znzhlj.znjs.com:7077','http://znzhlj.znjs.com:7077','http://39.170.3.158:6006','http://172.16.0.176:6006','http://127.0.0.1:3119','http://127.0.0.1:3120']){assert.equal(localAttachmentUrl(host+'/files/config/missing.jpg?x=1#view'),'/files/config/missing.jpg?x=1#view');cases++;}
for(const value of ['https://unrelated.invalid/files/a.jpg','https://znzhlj.znjs.com:7077/api/config/company','https://user:pass@znzhlj.znjs.com:7077/files/a','data:image/png;base64,abc','/files/already-local.png',null,12]){assert.equal(localAttachmentUrl(value),value);cases++;}
const cyclic={path:'https://znzhlj.znjs.com:7077/files/config/missing.jpg',rows:[{image:'http://39.170.3.158:6006/files/a.png'}]};cyclic.self=cyclic;assert.equal(normalizeAttachmentUrls(cyclic),cyclic);assert.equal(cyclic.path,'/files/config/missing.jpg');assert.equal(cyclic.rows[0].image,'/files/a.png');assert.equal(cyclic.self,cyclic);cases++;
const calls=[],request=async config=>{calls.push(config);return config;};
const freezeSource=read('src/modules/freeze-handling-a93ff3c0.js');
for(const [name,endpoint] of [['i','gesManualFreeze'],['u','sectionSteelManualFreeze']]){
 const freeze=vm.runInNewContext('('+declaration(freezeSource,name)+')',{a:request});
 const payload={id:28,quantity:1};await freeze(payload);
 assert.equal(calls.at(-1).url,'freeze/raw-material/'+endpoint);
 assert.equal(calls.at(-1).method,'put');assert.equal(calls.at(-1).data,payload);cases++;
}
const processSource=read('src/modules/process-611d795f.js');const process=vm.runInNewContext('('+declaration(processSource,'f')+')',{e:request});
// Actual recovered function; the normal structural process page passes no arguments.
await process();assert.equal(calls.at(-1).params.mesProductEnum,1);cases++;
await process({mesProductEnum:2});assert.equal(calls.at(-1).params.mesProductEnum,2);cases++;
const configSource=read('src/modules/project-config-5f01cdbc.js');const configAst=parse(configSource,{sourceType:'module'});let deleteName;walk(configAst,n=>{if(n.type==='FunctionDeclaration'&&configSource.slice(n.start,n.end).includes('/delete/'))deleteName=n.id.name;});
const getDelete=vm.runInNewContext('('+declaration(configSource,deleteName)+')',{e:request,a:request,o:request});await getDelete(78);assert.equal(calls.at(-1).method,'delete');assert.equal(calls.at(-1).url,'/api/kit/wms/common/config/delete/78');cases++;
const injection=vm.runInNewContext('('+declaration(read('src/shared/segments/062.fragment.js'),'TTe')+')',{W:request});await injection({projectId:73,supplierId:92});assert.equal(calls.at(-1).url,'/api/contract/Injection/getInjectionDetailDownload/73/92');cases++;
// BG detail uses the same current PurchaseOrder identity and export as the modern detail.
const purchaseK5=vm.runInNewContext('('+declaration(read('src/shared/segments/017.fragment.js'),'K5')+')',{W:request});
const purchaseI5=vm.runInNewContext('('+declaration(read('src/shared/segments/016.fragment.js'),'I5')+')',{W:request,K5:purchaseK5,Ai:()=>true,DS:{download:['scm_purchaseOrder_v2:download']}});
for(const id of [2,'103']){await purchaseI5({id});assert.equal(calls.at(-1).url,`/api/v2/scm/purchase-order/PurchaseExcel/${id}`);assert.equal(calls.at(-1).method,'get');assert.equal(calls.at(-1).responseType,'blob');cases++;}
const deniedExport=vm.runInNewContext('('+declaration(read('src/shared/segments/016.fragment.js'),'I5')+')',{K5:()=>{throw Error('must not call')},Ai:()=>false,DS:{download:['scm_purchaseOrder_v2:download']}});assert.throws(()=>deniedExport({id:2}),/权限/);cases++;
// Exercise actual component setup + real Vue watch with explicit services/host doubles.
const source=read('src/views/mes/label-print/return-repair/module/print-header.vue.js'),vueContext={};
for(const node of parse(source,{sourceType:'module'}).program.body)if(node.type==='ImportDeclaration'&&node.source.value==='vue')for(const spec of node.specifiers)vueContext[spec.local.name]=Vue[spec.imported.name];
const projectId=Vue.ref(),printReads=[];const enums={COMMON:{V:1},V:{}};
const component=vm.runInNewContext('('+declaration(source,'oe')+')',{...vueContext,X:()=>({globalProjectId:Vue.ref(999),user:Vue.ref({companyName:'test'}),requestUrl:Vue.ref('')}),Y:{NET:{V:1}},v:enums,Z:{ONE:{V:1}},P:v=>JSON.parse(JSON.stringify(v)),G:async(...args)=>{printReads.push(args);return null;},ee:()=>({batchPrint(){},print(){}}),J(){},K:{},N:request,console});
const renderer=Vue.createRenderer({createElement:()=>({}),createText:()=>({}),createComment:()=>({}),setText(){},setElementText(){},parentNode(){},nextSibling(){},patchProp(){},insert(){},remove(){}});
let exposed;const Child=Vue.defineComponent({setup(){component.setup({}, {expose:v=>exposed=v,emit(){}});return()=>null;}});const root=Vue.defineComponent({setup(){Vue.provide('labelProjectId',projectId);Vue.provide('printType',1);Vue.provide('permission',{});Vue.provide('selections',Vue.ref([]));Vue.provide('productType',1);Vue.provide('headerObj',{getLabelInfo(){},printLabelFunc(){}});return()=>Vue.h(Child);}});
const app=renderer.createApp(root);app.mount({});await Vue.nextTick();assert.equal(printReads.length,0);cases++;
projectId.value=56;await Vue.nextTick();await new Promise(setImmediate);assert.equal(printReads.length,1);assert.deepEqual(printReads[0],[56,1]);assert(exposed.printConfig);cases++;
projectId.value=57;await Vue.nextTick();await new Promise(setImmediate);assert.equal(printReads.length,2);assert.deepEqual(printReads[1],[57,1]);cases++;
projectId.value=undefined;await Vue.nextTick();await new Promise(setImmediate);assert.equal(printReads.length,2);cases++;app.unmount();
const report={cases,verified_at:new Date().toISOString(),attachment_aliases_limited_to_known_deployment_files:true,no_remote_fetch_or_asset_substitution:true,actual_request_functions_executed:true,actual_print_header_setup_and_vue_watch:true,explicit_doubles:['HTTP client','printing hook','renderer host'],browser_verified:false};fs.writeFileSync(path.join(project,'request-repairs-verification.json'),JSON.stringify(report,null,2)+'\n');console.log(report);
