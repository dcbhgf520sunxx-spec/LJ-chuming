import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import {createRequire} from 'node:module';
import {fileURLToPath} from 'node:url';
import {s as permissionMap} from '../src/modules/project-19a12d6b.js';
const root=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..');
const source='src/views/project-manage/installation-manage/install-review/index.vue.js';
const code=fs.readFileSync(path.join(root,source),'utf8');
const {parse}=createRequire(path.join(root,'package.json'))('@babel/parser');
const ast=parse(code,{sourceType:'module'});
const statements=ast.program.body.filter(n=>n.type!=='ImportDeclaration'&&n.type!=='ExportNamedDeclaration');
const executable=statements.map(n=>code.slice(n.start,n.end)).join('\n');
// Use the current exported enum object instead of copying audit values into the component.
const exports=fs.readFileSync(path.join(root,'src/shared/exports.fragment.js'),'utf8');
const enumName=exports.match(/\b(\w+) as c3\b/)[1];
const enumFile='src/shared/segments/002.fragment.js';
const enumCode=fs.readFileSync(path.join(root,enumFile),'utf8');
let enumNode;
for(const st of parse(enumCode,{sourceType:'module'}).program.body)if(st.type==='VariableDeclaration')for(const item of st.declarations)if(item.id.name===enumName)enumNode=item.init;
assert(enumNode,'Actual installation audit enum missing');
const auditStatus=vm.runInNewContext('('+enumCode.slice(enumNode.start,enumNode.end)+')');
assert.equal(auditStatus.PASS.V,2);assert.equal(auditStatus.REJECT.V,4);
function scenario(leaves,{selections=[{id:91},{id:92}],app=true,cancel=false}={}){
 const created=[],requests=[],confirmations=[];
 const crud={query:{projectId:3,productType:2},selections,data:[],toQuery(){},selectionChangeHandler(){}};
 const vnode=(tag,props,slots)=>{const node={tag,props:props??{},slots:slots??{}};created.push(node);return node;};
 const context={console,Array,Number,String,Boolean,
  x:value=>({value}),j:name=>name,n(){},d:vnode,e:value=>value&&typeof value==='object'&&'value'in value?value.value:value,
  t:vnode,s:fn=>fn,y:vnode,_:text=>text,f:()=>null,O:node=>node,P:'Fragment',U:vnode,L:String,
  C:{confirm:async(...args)=>{confirmations.push(args);if(cancel)throw new Error('User cancelled');}},T(){},z:'TableColumn',F:'Tag',G:'loading',
  R:request=>{requests.push(JSON.parse(JSON.stringify(request)));return Promise.resolve({});},
  K:component=>component,W:()=>({globalProjectId:{value:3},globalProject:{value:{installReportMethod:app?2:1}}}),
  J:()=>({crud,CRUD:{HOOK:{}}}),Y:()=>({maxHeight:{value:800}}),E:{APP:{V:2}},
  I:keys=>keys.some(key=>leaves.includes(key)),$: {ENCLOSURE:{V:4}},X:{COM_L__M:2},Z:'Pagination',M:auditStatus,h:permissionMap,ee:'Header'};
 const component=vm.runInNewContext(executable+'\nue',context);
 const render=component.setup({});render({},[]);
 const header=created.find(v=>v.tag==='Header');const buttons=header?header.slots.opeBtn().filter(Boolean):[];
 return{buttons,requests,confirmations};
}
const checks=[];
async function check(id,fn){try{const detail=await fn();checks.push({id,status:'passed',detail});}catch(e){checks.push({id,status:'fail',error:e.message});}}
function text(button){return button.slots.default().join('').trim();}
for(const[name,leaves,expected]of[
 ['none',[],[]],
 ['pass_only',['installation_audit:batchPass'],['批量通过']],
 ['reject_only',['installation_audit:batchReject'],['批量驳回']],
 ['both',['installation_audit:batchPass','installation_audit:batchReject'],['批量驳回','批量通过']],
]){
 await check(name+'_actual_render_exposes_only_correct_action_labels',()=>{const s=scenario(leaves);assert.deepEqual(Array.from(s.buttons,text),expected);return{leaves,labels:s.buttons.map(text)};});
 for(const label of expected)await check(name+'_'+(label==='批量通过'?'pass':'reject')+'_actual_visible_callback_posts_matching_current_status',async()=>{
  const s=scenario(leaves);const button=s.buttons.find(b=>text(b)===label);assert(button,'Expected button absent');assert.equal(button.props.disabled,false);await button.props.onClick();
  assert.equal(s.requests.length,1);const request=s.requests[0];assert.equal(request.method,'post');assert.equal(request.module,'project');assert.equal(request.url,'install-report/check/appV2');assert.deepEqual(request.params,{projectId:3});
  assert.deepEqual(request.data,[{id:91,auditStatus:label==='批量通过'?2:4},{id:92,auditStatus:label==='批量通过'?2:4}]);
  assert(s.confirmations[0][0].includes(label));return{label,method:'POST',path:'/api/project/install-report/check/appV2',request};
 });
}
for(const[label,leaf]of[['批量通过','installation_audit:batchPass'],['批量驳回','installation_audit:batchReject']]){
 await check((label==='批量通过'?'pass':'reject')+'_empty_selection_keeps_button_disabled',()=>{const s=scenario([leaf],{selections:[]});assert.equal(s.buttons.length,1);assert.equal(text(s.buttons[0]),label);assert.equal(s.buttons[0].props.disabled,true);});
 await check((label==='批量通过'?'pass':'reject')+'_cancelled_confirmation_does_not_post',async()=>{const s=scenario([leaf],{cancel:true});assert.equal(s.buttons.length,1);await s.buttons[0].props.onClick();assert.equal(s.requests.length,0);});
}
await check('non_APP_project_existing_gate_renders_neither_batch_action',()=>assert.equal(scenario(['installation_audit:batchPass','installation_audit:batchReject'],{app:false}).buttons.length,0));
const result={verified_at:new Date().toISOString(),source,permission_source:'src/modules/project-19a12d6b.js export s',enum_source:enumFile+' actual c3 export '+enumName,execution:'Actual current component setup/render and visible onClick callbacks; current permission module and audit enum; Vue renderer and HTTP R are doubles. No browser/HTTP claim.',cases:checks.length,passed:checks.filter(x=>x.status==='passed').length,failed:checks.filter(x=>x.status==='fail').length,checks};
fs.writeFileSync(path.join(root,'install-review-permissions-verification.json'),JSON.stringify(result,null,2)+'\n');console.log(JSON.stringify(result));if(result.failed)process.exitCode=1;
