import fs from 'node:fs';
import crypto from 'node:crypto';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import {createRequire} from 'node:module';
import {fileURLToPath} from 'node:url';
const here=path.dirname(fileURLToPath(import.meta.url));
const frontend=path.resolve(here,'..');
if(process.argv[1]&&path.resolve(process.argv[1])===fileURLToPath(import.meta.url)&&process.argv.slice(2).some(a=>a!=='--verify-current'))throw new Error('Only --verify-current is supported; candidate/staged source substitution is forbidden');
const require=createRequire(path.join(frontend,'package.json'));
const {parse}=require('@babel/parser'),Vue=require('vue');
const target=frontend,checks=[];
const sourcePaths=['src/views/crm/business-center/bidding-platform/module/header.vue.js','src/views/crm/business-center/bidding-platform/index.vue.js','src/shared/segments/037.fragment.js','src/modules/use-form-config-data-098a0552.js','src/shared/segments/015.fragment.js'];
const source_identity=sourcePaths.map(relative=>({path:relative,sha256:crypto.createHash('sha256').update(fs.readFileSync(path.join(frontend,relative))).digest('hex')}));
function read(rel){return fs.readFileSync(path.join(target,rel),'utf8')}
function walk(n,visit){if(!n||typeof n!=='object')return;if(n.type)visit(n);for(const[k,v]of Object.entries(n)){if(['loc','start','end'].includes(k))continue;if(Array.isArray(v))v.forEach(x=>walk(x,visit));else if(v?.type)walk(v,visit)}}
function extract(code,name){let found;walk(parse(code,{sourceType:'module'}),n=>{if(n.type==='VariableDeclarator'&&n.id.name===name)found=code.slice(n.init.start,n.init.end);if(n.type==='FunctionDeclaration'&&n.id.name===name)found=code.slice(n.start,n.end)});assert(found,name);return found}
function contextFor(code,other){const c={console,...other};for(const n of parse(code,{sourceType:'module'}).program.body)if(n.type==='ImportDeclaration'&&n.source.value==='vue')for(const s of n.specifiers)c[s.local.name]=Vue[s.imported.name];return c}
function value(code,name,context){return vm.runInNewContext('('+extract(code,name)+')',context)}
function check(id,fn){try{fn();checks.push({id,status:'passed'})}catch(e){checks.push({id,status:'failed',error:e.message})}}
const Empty={render:()=>null};
function render(component,components={},props={}){const node=type=>({type,props:{},children:[],parent:null});const renderer=Vue.createRenderer({createElement:node,createText:text=>({...node('#text'),text}),createComment:()=>node('#comment'),setText(n,text){n.text=text},setElementText(n,text){n.text=text},parentNode:n=>n.parent,nextSibling:()=>null,patchProp:(n,k,o,v)=>n.props[k]=v,insert(n,p){p.children.push(n);n.parent=p},remove(){}});const root=node('root'),app=renderer.createApp(component,props);for(const[k,v]of Object.entries(components))app.component(k,v);app.mount(root);return{root,app}}
function nodes(n,p){return[n,...n.children.flatMap(c=>nodes(c,p))].filter(p)}
const headerCode=read('src/views/crm/business-center/bidding-platform/module/header.vue.js');
let query,called=0;
const headerContext=contextFor(headerCode,{x:'input',N:'section',V:{setup:(_,c)=>()=>Vue.h('div',null,c.slots.default?.())},h:defaults=>{query=Vue.reactive({...defaults});return{query,crud:{toQuery(){called++}}}},w:Empty,u:Empty});
headerContext.C=value(headerCode,'C',headerContext);
const header=render(value(headerCode,'g',headerContext),{},{summary:{}});
const input=nodes(header.root,n=>n.type==='input')[0];
check('platform_header_names_the_search_target',()=>assert.equal(input.props.placeholder,'招标平台名称搜索'));
input.props['onUpdate:modelValue']('QA20261023EXPORT_FULL');
input.props.onKeyup({key:'Enter'});
const providerCode=fs.readFileSync(path.join(frontend,'src/modules/use-form-config-data-098a0552.js'),'utf8');
let request;const provider=value(providerCode,'_',{t:config=>{request=config;return config}});provider(query);
check('actual_header_input_reaches_actual_provider_biddingPlatformName',()=>{assert.equal(called,1);assert.equal(request.url,'business/center/platform/list');assert.equal(request.params.biddingPlatformName,'QA20261023EXPORT_FULL');assert(!('businessName'in request.params));});
header.app.unmount();
const indexCode=read('src/views/crm/business-center/bidding-platform/index.vue.js');
const crud={query:{},data:[{id:11,biddingPlatformName:'QA20261023EXPORT_FULL_平台',crmEnterpriseWarehousingName:null}],toQuery(){}};
const indexContext=contextFor(indexCode,{R:{props:['prop','label'],setup:props=>()=>Vue.h('column',{...props})},B:{},P:async()=>({}),E:()=>({crud,CRUD:{HOOK:{}}}),O:()=>({maxHeight:800}),S:{RECORD:{V:1}},y:()=>false,m:{},T:Empty,U:Empty,L:Empty});
indexContext.A=value(indexCode,'A',indexContext);indexContext.M=value(indexCode,'M',indexContext);indexContext.D=()=>{};
const table={setup:(_,c)=>()=>Vue.h('table',null,c.slots.default?.())};
const list=render(value(indexCode,'Y',indexContext),{'common-table':table,'print-table':Empty,'common-button':Empty});
const cols=nodes(list.root,n=>n.type==='column');
check('actual_list_renders_platform_name_column_for_standalone_record',()=>{const col=cols.find(n=>n.props.prop==='biddingPlatformName');assert(col,'missing biddingPlatformName column');assert.equal(col.props.label,'招标平台名称');assert.equal(crud.data[0][col.props.prop],'QA20261023EXPORT_FULL_平台')});
check('actual_list_preserves_independent_enterprise_column',()=>assert(cols.some(n=>n.props.prop==='crmEnterpriseWarehousingName'&&n.props.label==='企业名称')));
list.app.unmount();
const projectCode=read('src/shared/segments/037.fragment.js');
const types={MES:{V:1},BRIDGE:{V:2},PARKING_LOT:{V:4},ENCLOSURE:{V:8}},business={MACHINING:{V:1},INSTALLATION:{V:2}},status={PROCESS:{V:1,L:'进行中'},PAUSE:{V:2,L:'暂停'},FINISH:{V:4,L:'完工'}};
// This input is already permission-filtered by the server. No test may add an absent project.
const allowed=[{id:1,projectType:1,businessType:1,status:1},{id:3,projectType:9,businessType:2,status:1},{id:40,projectType:1,businessType:2,status:1},{id:41,projectType:1,businessType:2,status:1},{id:44,projectType:3,businessType:2,status:1},{id:42,projectType:3,businessType:1,status:1},{id:43,projectType:3,businessType:2,status:2},{id:8,projectType:8,businessType:2,status:1},{id:9,projectType:9,businessType:2,status:1},{id:10,projectType:1,businessType:2,status:1,hasEnclosure:true},{id:11,projectType:4,businessType:2,status:1},{id:12,projectType:0,businessType:2,status:1},{id:13,projectType:null,businessType:2,status:1}].map(p=>({...p,createTime:1792857600000,shortName:'project-'+p.id}));
const pc={P2:Object.values(types),$e:types,xi:business,gn:status,Ot:0,Ra:{toArr:Object.values},Qi:v=>String(new Date(v).getUTCFullYear()),di:p=>p.shortName,oC:async()=>({content:structuredClone(allowed)})};
pc.Hs=value(projectCode,'Hs',pc);const actions=value(projectCode,'qP',pc),maps={};
await actions.fetchUserProjects({state:{projectType:1},commit:(k,v)=>maps[k]=v,dispatch(){}});
const ids=a=>Array.from(a||[],p=>p.id),cascadeIds=a=>Array.from(a||[]).flatMap(y=>Array.from(y.children).flatMap(s=>ids(s.children)));
check('actual_project_action_keeps_combined_type_in_mes_map',()=>assert(ids(maps.SET_USER_PROJECTS_MAP[1]).includes(3)));
check('actual_project_action_keeps_combined_type_in_bridge_map',()=>{assert(ids(maps.SET_USER_PROJECTS_MAP[2]).includes(44));assert(!ids(maps.SET_USER_PROJECTS_MAP[2]).includes(3));});
check('actual_project_action_installation_consumer_keeps_active_combined_type',()=>assert(ids(maps.SET_USER_BUSINESS_PROJECTS_MAP['2_1']).includes(3)));
check('actual_project_action_machining_consumer_keeps_active_combined_type',()=>assert(ids(maps.SET_USER_BUSINESS_PROJECTS_MAP['1_1']).includes(42)));
check('actual_project_cascade_all_consumer_keeps_combined_type',()=>assert(cascadeIds(maps.SET_USER_PROJECTS_CASCADE_MAP[1]).includes(3)));
check('actual_project_business_cascade_consumer_keeps_combined_type',()=>assert(cascadeIds(maps.SET_USER_BUSINESS_PROJECTS_CASCADE_MAP['2_1']).includes(3)));
check('actual_project_mask_excludes_unrelated_null_zero_types',()=>{for(const id of[8,11,12,13])assert(!ids(maps.SET_USER_PROJECTS_MAP[1]).includes(id));});
check('actual_project_active_business_scope_preserved',()=>{assert(!ids(maps.SET_USER_BUSINESS_PROJECTS_MAP['2_1']).includes(43));assert(!ids(maps.SET_USER_BUSINESS_PROJECTS_MAP['2_1']).includes(42));});
check('actual_project_enclosure_hasEnclosure_compatibility_preserved',()=>{assert(ids(maps.SET_USER_PROJECTS_MAP[8]).includes(10));assert(ids(maps.SET_USER_PROJECTS_MAP[8]).includes(8));});
check('actual_project_enclosure_combined_mask_supported',()=>{assert(ids(maps.SET_USER_PROJECTS_MAP[8]).includes(9));assert(ids(maps.SET_USER_PROJECTS_MAP[8]).includes(3));assert(!ids(maps.SET_USER_PROJECTS_MAP[8]).includes(44));});
check('actual_project_action_never_synthesizes_unauthorized_project',()=>{for(const map of[maps.SET_USER_PROJECTS_MAP,maps.SET_USER_BUSINESS_PROJECTS_MAP])for(const list of Object.values(map))for(const p of list)assert(allowed.some(a=>a.id===p.id));assert.equal(ids(maps.SET_USER_PROJECTS_MAP[0]).length,allowed.length);});
const globalHeaderCode=fs.readFileSync(path.join(frontend,'src/shared/segments/015.fragment.js'),'utf8');
const globalHeader=extract(globalHeaderCode,'ON');
const optionExpr=extract('const component='+globalHeader,'P');
for(const all of[false,true])for(const businessScope of[undefined,2])check('actual_global_header_options_combined_project_all_'+all+'_business_'+businessScope,()=>{
  const ctx={Ee:Vue.computed,Ot:0,S:Vue.ref(1),b:Vue.ref(all),V:Vue.ref(businessScope),u:Vue.ref(false),f:Vue.ref(maps.SET_USER_PROJECTS_CASCADE_MAP[1]),m:Vue.ref(maps.SET_USER_PROJECTS_MAP[1].filter(p=>p.status===1)),v:Vue.ref(maps.SET_USER_BUSINESS_PROJECTS_MAP),N:Vue.ref(maps.SET_USER_BUSINESS_PROJECTS_CASCADE_MAP)};
  const options=vm.runInNewContext('('+optionExpr+')',ctx).value;
  assert((all?cascadeIds(options):ids(options)).includes(3),'actual global header P computed discarded combined project');
});
const result={target,verify_current:true,source_identity,fixture_basis:'Root current57 native read corrected project3 to projectType9 (MES1|ENCLOSURE8), status1/businessType2. Test list is a synthetic permission-filtered fixture; project44/type3 independently covers MES1|BRIDGE2.',verified_at:new Date().toISOString(),scope:'Offline actual Vue header/list setup-render and actual provider function; actual qP.fetchUserProjects, Hs cascade and global header ON.P options execute. CRUD/transport/enum helpers are dependency doubles. Synthetic authorized-list fixtures, not server observations. No HTTP/SQL/CUA/services; no product source mutation.',cases:checks.length,passed:checks.filter(c=>c.status==='passed').length,failed:checks.filter(c=>c.status==='failed').length,checks};
fs.writeFileSync(path.join(frontend,'platform-and-project-mask-verification.json'),JSON.stringify(result,null,2)+'\n');console.log({test:'platform-and-project-mask-current',cases:result.cases,passed:result.passed,failed:result.failed,verify_current:true});if(result.failed){console.error(JSON.stringify(result.checks.filter(c=>c.status==='failed'),null,2));process.exitCode=1;}
