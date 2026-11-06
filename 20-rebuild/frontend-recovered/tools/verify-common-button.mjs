import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import {fileURLToPath} from 'node:url';
import {parse} from '@babel/parser';
import * as Vue from 'vue';
const project=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..');
const read=p=>fs.readFileSync(path.join(project,p),'utf8');
const fragment=read('src/shared/segments/061.fragment.js');
function walk(n,cb){if(!n||typeof n!=='object')return;if(n.type)cb(n);for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(Array.isArray(v))v.forEach(x=>walk(x,cb));else if(v?.type)walk(v,cb);}}
function declaration(code,name){let found;walk(parse(code,{sourceType:'module'}),n=>{if(n.type==='VariableDeclarator'&&n.id.name===name)found=code.slice(n.init.start,n.init.end);if(n.type==='FunctionDeclaration'&&n.id.name===name)found=code.slice(n.start,n.end)});assert(found,name);return found;}
function vueImports(code){const context={};for(const n of parse(code,{sourceType:'module'}).program.body)if(n.type==='ImportDeclaration'&&n.source.value==='vue')for(const spec of n.specifiers)context[spec.local.name]=Vue[spec.imported.name];return context;}
const make=(type,text='')=>({type,text,props:{},style:{},children:[],parent:null});
const renderer=Vue.createRenderer({createElement:make,createText:t=>make('#text',t),createComment:t=>make('#comment',t),setText:(n,t)=>n.text=t,setElementText:(n,t)=>n.text=t,parentNode:n=>n.parent,nextSibling:n=>{if(!n.parent)return null;return n.parent.children[n.parent.children.indexOf(n)+1]||null;},patchProp:(n,k,old,v)=>n.props[k]=v,insert(n,p,anchor){if(n.parent){const index=n.parent.children.indexOf(n);if(index>=0)n.parent.children.splice(index,1);}const index=anchor?p.children.indexOf(anchor):-1;if(index<0)p.children.push(n);else p.children.splice(index,0,n);n.parent=p;},remove(n){if(n.parent)n.parent.children.splice(n.parent.children.indexOf(n),1);}});
const ButtonHost=Vue.defineComponent({emits:['click'],setup(_,ctx){return()=>Vue.h('button',{...ctx.attrs,onClick:event=>ctx.emit('click',event)},ctx.slots.default?.());}});
const focusWarnings=[];const sharedContext={...vueImports(read('src/shared/imports.fragment.js')),xo:ButtonHost,console:{warn:(...args)=>focusWarnings.push(args)}};
sharedContext.Ae=vm.runInNewContext('('+declaration(read('src/shared/segments/001.fragment.js'),'Ae')+')');
const CommonButton=vm.runInNewContext('('+declaration(fragment,'Pye')+')',sharedContext);
let cases=0;
function flatten(node){return[node,...node.children.flatMap(flatten)];}
function text(node){return node.text+node.children.map(text).join('');}
function mountButton(props={}){const root=make('root'),clicks=[];const app=renderer.createApp({render:()=>Vue.h(CommonButton,{...props,onClick:event=>clicks.push(event)},()=>Vue.h('span',null,'真实按钮'))});app.config.warnHandler=(message)=>{if(!message.startsWith('Slot'))throw Error(message)};app.mount(root);return{root,clicks,app,button:flatten(root).find(x=>x.type==='button')};}
// A mouse event can target a deeply nested icon. The actual button is currentTarget.
for(const target of [{nodeName:'SVG',parentNode:{}},{nodeName:'PATH',parentNode:{}},null]){
 const mounted=mountButton();let blurs=0;const button={nodeName:'BUTTON',closest:()=>button,blur:()=>blurs++};const event={target,currentTarget:button};mounted.button.props.onClick(event);assert.equal(mounted.clicks.length,1);assert.equal(mounted.clicks[0],event);assert.equal(blurs,1);mounted.app.unmount();cases++;
}
for(const event of [{target:null,currentTarget:null},{},undefined,{currentTarget:{closest(){throw Error('host currentTarget.closest failed')}}},{target:{closest(){throw Error('host target.closest failed')}}},{target:{closest:()=>({blur(){throw Error('host blur failed')}})}}]){
 const mounted=mountButton();mounted.button.props.onClick(event);assert.equal(mounted.clicks.length,1);mounted.app.unmount();cases++;
}
let mounted=mountButton();const keyboardButton={nodeName:'BUTTON',blur(){}};mounted.button.props.onClick({currentTarget:keyboardButton,target:keyboardButton,key:'Enter',detail:0});assert.equal(mounted.clicks.length,1);mounted.app.unmount();cases++;
mounted=mountButton({disabled:true});mounted.button.props.onClick({target:null});assert.equal(mounted.clicks.length,0);mounted.app.unmount();cases++;
mounted=mountButton({clickOutFocus:false});let inspected=0;mounted.button.props.onClick({currentTarget:{closest(){inspected++;}}});assert.equal(mounted.clicks.length,1);assert.equal(inspected,0);mounted.app.unmount();cases++;
// Actual header -> actual policy -> actual useDialog watch, with explicit service/UI host doubles.
const serviceCalls=[],notices=[];let rejectPolicy=false;
const Empty=Vue.defineComponent({setup:()=>()=>Vue.h('span')});
const Container=Vue.defineComponent({setup(_,ctx){return()=>Vue.h('div',null,[ctx.slots.viewLeft?.(),ctx.slots.default?.()]);}});
const Field=Vue.defineComponent({setup(_,ctx){return()=>Vue.h('div',null,ctx.slots.default?.());}});
const Input=Vue.defineComponent({props:['modelValue','placeholder','disabled'],setup:props=>()=>Vue.h('input',{value:props.modelValue,placeholder:props.placeholder,disabled:props.disabled})});
const Form=Vue.defineComponent({setup(_,ctx){ctx.expose({resetFields(){},clearValidate(){},validate:async()=>true});return()=>Vue.h('form',null,ctx.slots.default?.());}});
const Dialog=Vue.defineComponent({props:['modelValue','beforeClose'],setup(props,ctx){return()=>props.modelValue?Vue.h('section',{role:'dialog'},[ctx.slots.titleRight?.(),ctx.slots.default?.(),Vue.h('button',{onClick:()=>props.beforeClose()},'关闭策略')]):null;}});
const policySource=read('src/views/user-manage/user/module/password-strategy.vue.js');
const dialogHook=vm.runInNewContext('('+declaration(read('src/shared/segments/015.fragment.js'),'Ta')+')',sharedContext);
const policy=vm.runInNewContext('('+declaration(policySource,'de')+')',{...vueImports(policySource),te:dialogHook,n:{NUMBER:{V:1},SPECIAL_CHARACTERS:{V:2},LETTER:{V:4},ENUM:[]},policyRequest:async c=>{serviceCalls.push(c);if(rejectPolicy)throw Error('read unavailable');return{containNumbers:true,containLetter:true,minLength:8,loginVerification:true,defaultPasswordConfigured:true};},_:v=>v!=null,ne(){},le:()=>true,ue:{editPasswordPolicy:['edit']},re:async()=>{},ie:()=>null,$:n=>notices.push(n),Q:Field,X:Field,Y:Field,Z:Input,ee:Form,console});
const headerSource=read('src/views/user-manage/user/module/header.vue.js');
const header=vm.runInNewContext('('+declaration(headerSource,'j')+')',{...vueImports(headerSource),M:{class:'head-container'},D:()=>({crud:Vue.reactive({searchToggle:true,permission:{},toQuery(){},props:{}}),query:Vue.reactive({})}),H:policy,K:{ENUM:[]},V:{ORDINARY_PERSONNEL:1,LABOR_PERSONNEL:2},$:Empty,m:()=>true,v:Empty,q:Container,F:Empty,R:async()=>{},U:async()=>{},I:async()=>{},h:async()=>{},T(){},L:Input,Q:ButtonHost,console});
const root=make('root'),app=renderer.createApp(header);app.config.warnHandler=(message)=>{if(!message.startsWith('Slot'))throw Error(message)};app.component('common-button',CommonButton);app.component('common-dialog',Dialog);app.component('common-input-number',Input);app.component('common-radio-button',Empty);app.mount(root);
for(let i=0;i<2;i++){const trigger=flatten(root).find(n=>n.type==='button'&&text(n)==='密码策略');assert(trigger);const currentTarget={closest(){return this},blur(){}};trigger.props.onClick({currentTarget,target:{nodeName:'SVG',parentNode:{}}});await new Promise(setImmediate);await Vue.nextTick();assert(flatten(root).some(n=>n.props.role==='dialog'));assert.equal(serviceCalls.length,i+1);assert.equal(serviceCalls.at(-1).url,'/api/config/passwordPolicy/editable');assert(flatten(root).some(n=>n.props.placeholder==='已设置，留空保留'&&n.props.value===''));cases++;flatten(root).find(n=>n.type==='button'&&text(n)==='关闭策略').props.onClick();await Vue.nextTick();assert.equal(flatten(root).some(n=>n.props.role==='dialog'),false);cases++;}
rejectPolicy=true;flatten(root).find(n=>n.type==='button'&&text(n)==='密码策略').props.onClick({});await new Promise(setImmediate);await Vue.nextTick();assert(notices.some(x=>x.type==='error'));assert(flatten(root).find(n=>n.type==='button'&&text(n)==='确认').props.disabled);cases++;app.unmount();
assert.equal(focusWarnings.length,3);
const report={cases,known_original_slot_warning:'Original common-button invokes slot in setup; custom renderer filters this known warning only.',actual_vue_renderer:true,actual_recovered_button_header_policy_and_dialog_hook:true,element_plus_native_dom_and_browser_verified:false,explicit_doubles:['Element Plus UI host components','CRUD data provider','policy HTTP client'],deep_mouse_target_emits_once:true,blur_failure_does_not_block_action:true,policy_reopen_reads_each_time:true,policy_failure_blocks_submit:true,verified_at:new Date().toISOString()};fs.writeFileSync(path.join(project,'common-button-verification.json'),JSON.stringify(report,null,2)+'\n');console.log(report);
