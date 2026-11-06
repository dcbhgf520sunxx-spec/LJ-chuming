import fs from'node:fs';import path from'node:path';import vm from'node:vm';import assert from'node:assert/strict';import{createRequire}from'node:module';import{fileURLToPath}from'node:url';
import{createSessionBootstrap}from'../src/runtime/session-bootstrap.js';import{getConfiguredPrinter,requirePrintResult}from'../src/runtime/printing.js';
const project=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..'),r=createRequire(path.join(project,'package.json')),{parse}=r('@babel/parser');
function walk(n,cb){if(!n||typeof n!=='object')return;if(n.type)cb(n);for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(Array.isArray(v))v.forEach(x=>walk(x,cb));else if(v?.type)walk(v,cb);}}
let cases=0;
function setup({optionalFailure=false,infoFailure=null,menuFailure=false}={}){const events=[],getters={roles:[],loadedMenus:false};let token='existing-session-token';const store={getters,async dispatch(action,value){events.push(action);if(action==='user/getInfo'){if(infoFailure)throw infoFailure;getters.roles=['admin'];}if(action.startsWith('config/')&&optionalFailure)throw Error('local configuration unavailable');if(action==='permission/setRoutes')return['real-local-routes'];if(action==='user/updateLoadedMenus')getters.loadedMenus=true;}};const ensure=createSessionBootstrap({store,token:()=>token,loadMenu:async()=>{events.push('menu');if(menuFailure)throw Error('network');return['real-menu']},installRoutes:()=>events.push('install'),onOptionalFailure:()=>events.push('optional-error')});return{events,store,ensure,token:()=>token};}
let env=setup();let result=await env.ensure({path:'/home-page'});assert.equal(result.authenticated,true);assert.equal(env.token(),'existing-session-token');assert.equal(env.events.includes('user/logout'),false);assert.equal(env.events.filter(x=>x==='menu').length,1);await env.ensure({path:'/home-page'});assert.equal(env.events.filter(x=>x==='menu').length,1);cases++;
// Refresh creates a new Vuex store and bootstrap closure while retaining sessionStorage-backed token.
let memory=new Map();const sessionStorage={getItem:k=>memory.get(k)??null,setItem:(k,v)=>memory.set(k,v),removeItem:k=>memory.delete(k)};const helperSource=fs.readFileSync(path.join(project,'src/shared/segments/001.fragment.js'),'utf8');let functions={};walk(parse(helperSource,{sourceType:'module'}),n=>{if(n.type==='FunctionDeclaration'&&['or','JV','bA'].includes(n.id.name))functions[n.id.name]=helperSource.slice(n.start,n.end)});const helper=vm.runInNewContext(functions.or+';'+functions.JV+';'+functions.bA+';({read:or,write:JV,clear:bA})',{sessionStorage,JSON});helper.write('existing-session-token');assert.equal(helper.read(),'existing-session-token');env=setup();await env.ensure({path:'/home-page'});const refreshed=setup();await refreshed.ensure({path:'/home-page'});assert.equal(helper.read(),'existing-session-token');assert.equal(refreshed.events.includes('user/logout'),false);cases++;
env=setup({optionalFailure:true});result=await env.ensure({path:'/home-page'});assert.equal(result.authenticated,true);assert.equal(env.token(),'existing-session-token');assert.equal(env.events.filter(x=>x==='optional-error').length,2);assert.equal(env.events.includes('user/logout'),false);cases++;
env=setup({infoFailure:Error('network unavailable')});await assert.rejects(env.ensure({path:'/home-page'}));assert.equal(env.token(),'existing-session-token');assert.equal(env.events.includes('user/logout'),false);assert.equal(env.events.includes('menu'),false);cases++;
env=setup({menuFailure:true});await assert.rejects(env.ensure({path:'/home-page'}));assert.equal(env.token(),'existing-session-token');assert.equal(env.events.includes('user/logout'),false);cases++;
let release;const events=[],getters={roles:[],loadedMenus:false};const store={getters,async dispatch(action){events.push(action);if(action==='user/getInfo')await new Promise(r=>release=r);if(action==='permission/setRoutes')return[];if(action==='user/updateLoadedMenus')getters.loadedMenus=true;}};const ensure=createSessionBootstrap({store,token:()=> 'session',loadMenu:async()=>{events.push('menu');return[]},installRoutes:()=>events.push('install')});const first=ensure({path:'/home-page'}),second=ensure({path:'/home-page'});assert.equal(events.filter(x=>x==='user/getInfo').length,1);release();await Promise.all([first,second]);assert.equal(events.filter(x=>x==='menu').length,1);assert.equal(events.filter(x=>x==='install').length,1);cases++;
// Execute the actual recovered router callback with injected runtime dependencies.
const guardSource=fs.readFileSync(path.join(project,'src/shared/segments/061.fragment.js'),'utf8');let guardNode;walk(parse(guardSource,{sourceType:'module'}),n=>{if(n.type==='CallExpression'&&n.callee.type==='MemberExpression'&&n.callee.object.name==='As'&&n.callee.property.name==='beforeEach')guardNode=n.arguments[0]});assert(guardNode);let ensureCalls=0,nextCalls=[],notices=[];let token='session';const guardContext={zm:{start(){}},document:{},wye:()=> 'local',ew(){},$V(){},bye:['/login'],or:()=>token,rebuildEnsureSession:async()=>{ensureCalls++;return{authenticated:true,installed:false}},_e:{getters:{},dispatch:async()=>{}},rebuildIsAuthenticationFailure:e=>[40001,40002,40003,40004,40005,40103].includes(e?.code),ot:n=>notices.push(n)};const guard=vm.runInNewContext('('+guardSource.slice(guardNode.start,guardNode.end)+')',guardContext);const next=v=>nextCalls.push(v);await guard({path:'/login',meta:{}},{fullPath:'/home-page'},next);assert.equal(nextCalls.length,1);assert.equal(ensureCalls,0);cases++;
nextCalls=[];await guard({path:'/home-page',meta:{}},{fullPath:'/home-page'},next);assert.equal(nextCalls.length,1);assert.equal(ensureCalls,1);assert.equal(token,'session');cases++;
guardContext.rebuildEnsureSession=async()=>{throw Error('network')};nextCalls=[];await guard({path:'/home-page',meta:{}},{fullPath:'/home-page'},next);assert.deepEqual(nextCalls,[false]);assert.equal(token,'session');cases++;
guardContext.rebuildEnsureSession=async()=>{const error=Error('expired');error.code=40003;throw error};nextCalls=[];await guard({path:'/home-page',meta:{}},{fullPath:'/home-page'},next);assert.deepEqual(nextCalls,['/login']);cases++;
const earlyGuardSource=fs.readFileSync(path.join(project,'src/shared/segments/060.fragment.js'),'utf8');assert.equal(earlyGuardSource.includes('As.beforeEach('),false);cases++;
guardContext._e.getters.homePageShowConfig=undefined;guardContext.rebuildEnsureSession=async()=>{guardContext._e.getters.homePageShowConfig=true;return{authenticated:true,installed:true}};nextCalls=[];await guard({path:'/home-page',fullPath:'/home-page',meta:{}},{fullPath:'/home-page'},next);assert.equal(nextCalls.length,1);assert.equal(nextCalls[0].path,'/home-page');assert.equal(nextCalls[0].replace,true);cases++;
nextCalls=[];await guard({path:'/iframe',meta:{}},{fullPath:'/login'},next);assert.deepEqual(nextCalls,['/home-page']);cases++;
guardContext.rebuildEnsureSession=async()=>({authenticated:true,installed:false});nextCalls=[];await guard({path:'/iframe',meta:{}},{fullPath:'/crm-office'},next);assert.equal(nextCalls.length,1);assert.equal(nextCalls[0],undefined);cases++;
await assert.rejects(getConfiguredPrinter({}),/打印未配置/);cases++;
await assert.rejects(getConfiguredPrinter({LJAPS_PRINT_ADAPTER:{getPrinter:async()=>({})}}),/适配器不可用/);cases++;
let deviceCalls=[];const printer={PRINT_INIT:()=>deviceCalls.push('init'),SET_PRINT_MODE:()=>deviceCalls.push('mode')};assert.equal(await getConfiguredPrinter({LJAPS_PRINT_ADAPTER:{getPrinter:async()=>printer}}),printer);assert.deepEqual(deviceCalls,[]);cases++;
await assert.rejects(getConfiguredPrinter({LJAPS_PRINT_ADAPTER:{getPrinter:async()=>{throw Error('device offline')}}}),/device offline/);cases++;
const printSource=fs.readFileSync(path.join(project,'src/shared/segments/070.fragment.js'),'utf8');assert.equal(printSource.includes('CLodopfuncs.js'),false);let entry;walk(parse(printSource,{sourceType:'module'}),n=>{if(n.type==='FunctionDeclaration'&&n.id.name==='qNe')entry=n});let warnings=[];const q=vm.runInNewContext('('+printSource.slice(entry.start,entry.end)+')',{FNe:async()=>printer,GNe:()=>deviceCalls.push('reset'),ot:v=>warnings.push(v)});assert.equal(await q(),printer);assert.deepEqual(deviceCalls,['init','mode','reset']);cases++;
const failure=vm.runInNewContext('('+printSource.slice(entry.start,entry.end)+')',{FNe:async()=>getConfiguredPrinter({}),GNe(){throw Error('must not initialize')},ot:v=>warnings.push(v)});await assert.rejects(failure(),/打印未配置/);assert(warnings.at(-1).message.includes('打印未配置'));cases++;
const printFunctions={};walk(parse(printSource,{sourceType:'module'}),n=>{if(n.type==='FunctionDeclaration')printFunctions[n.id.name]=printSource.slice(n.start,n.end)});
// The actual recovered NORMAL / DESIGN / QUEUE functions must preserve a failed driver result.
const checkPrintResult=requirePrintResult;
for(const name of ['Gd','XNe'])for(const outcome of [false,'real-driver-task',Error('device write failed')]){
 const method=name==='Gd'?'PRINT':'PRINT_DESIGN';const instance={ [method](){if(outcome instanceof Error)throw outcome;return outcome;} };
 const invoke=vm.runInNewContext('('+printFunctions[name]+')',{Oi:instance,rebuildRequirePrintResult:checkPrintResult});
 if(outcome===false||outcome instanceof Error)await assert.rejects(Promise.resolve().then(invoke),outcome===false?/打印操作失败/:/device write failed/);else assert.equal(await invoke(),outcome);cases++;
}
for(const cloud of [false,true])for(const outcome of [false,'real-driver-task',Error('queue device failed')]){
 const instance={CVERSION:cloud,PRINT(){if(outcome instanceof Error)throw outcome;if(cloud)queueMicrotask(()=>this.On_Return('task',outcome));return outcome;}};
 const invoke=vm.runInNewContext('('+printFunctions.Jb+')',{Oi:instance,rebuildRequirePrintResult:checkPrintResult,console:{log(){}}});
 if(outcome===false||outcome instanceof Error)await assert.rejects(invoke(),outcome===false?/打印操作失败/:/queue device failed/);else assert.equal(await invoke(),outcome);cases++;
}
for(const outcome of [false,'printed']){
 const instance={SET_PRINT_MODE(){},PREVIEW(){queueMicrotask(()=>this.On_Return('task',outcome==='printed'?1:0));return true;}};
 const invoke=vm.runInNewContext('('+printFunctions.JNe+')',{Oi:instance,rebuildRequirePrintResult:checkPrintResult});assert.equal(await invoke(),outcome);cases++;
}
// Execute the real outer print wrapper: nested async print failures must reject, not hang or resolve success.
for(const outcome of ['driver-task',Error('actual print failure')]){
 const config={title:{show:false},header:{show:false},footer:{show:false},logo:{show:false},qrCode:{show:false},page:{show:false},unit:'mm',paddingTB:0};
 const device={SET_PRINT_PAGESIZE(){},ADD_PRINT_HTM(){},SET_PRINT_STYLEA(){},ADD_PRINT_TABLE(){},SET_PRINT_COPIES(){}};const messages=[];
 const context={Kl:{QUEUE:{V:1}},$n:{LONGITUDINAL:{V:1}},Ua:null,Ae:v=>!v,A:v=>!!v,a5e(){},m5e(){},l5e:()=>'',u5e:()=>'',r6:()=>'',n5e:()=>'',s5e:()=>'',St:()=>0,t5e:()=>true,qNe:async()=>device,QNe:async()=>{if(outcome instanceof Error)throw outcome;return outcome},ot:m=>messages.push(m)};
 const invoke=vm.runInNewContext('('+printFunctions.i5e+')',context);if(outcome instanceof Error){await assert.rejects(invoke({config}),/actual print failure/);assert.equal(messages.at(-1).type,'error');}else assert.equal(await invoke({config}),outcome);cases++;
}
// Preview without a physical printer reuses the actual report markup.
{
 const config={title:{show:true,title:'费用报表'},header:{show:false},footer:{show:false},logo:{show:false},qrCode:{show:false},page:{show:false},unit:'mm',paddingTB:0};
 const previewMode=Symbol('preview');let preview;
 const context={Kl:{PREVIEW:{V:previewMode}},Ae:v=>!v,A:v=>!!v,a5e(){},m5e(){},l5e:()=>'<h1>费用报表</h1>',u5e:()=>'<table><tr><td>11400</td></tr></table>',r6:()=>'',n5e:()=>'',s5e:()=>'',rebuildHasConfiguredPrinter:()=>false,rebuildShowReportPreview:report=>{preview=report;return 'previewed'},qNe(){throw Error('must not initialize a physical printer')},ot(){}};
 const invoke=vm.runInNewContext('('+printFunctions.i5e+')',context);
 assert.equal(await invoke({config,printMode:previewMode}),'previewed');
 assert.match(preview.html,/<td>11400<\/td>/);
 assert.equal(preview.title,'费用报表');
 cases++;
}
// The approval report's actual-payment column uses the same native field as the list.
{
 const source=fs.readFileSync(path.join(project,'src/shared/segments/073.fragment.js'),'utf8');
 const columns=[];
 walk(parse(source,{sourceType:'module'}),node=>{
   if(node.type!=='ObjectExpression')return;
   const property=name=>node.properties.find(p=>p.type==='ObjectProperty'&&p.key.name===name)?.value.value;
   if(property('title')==='实付（开）金额')columns.push(property('key'));
 });
 assert.deepEqual(columns,['actuallyPayAmount']);
 cases++;
}
// Shipment report buttons must forward the same active query as their list.
for(const kind of ['structure','box','enclosure','auxiliary-material','straightener']){
 const source=fs.readFileSync(path.join(project,'src/views/contract/sales-manage/shipment-tracking',kind,'module/header.vue.js'),'utf8');
 assert.match(source,/"api-key": "[^"]+", params: e\([as]\)/,kind);
 cases++;
}
// Order tracking totals and invoice detail both use the actual approved invoice amount.
{
 const printSource=fs.readFileSync(path.join(project,'src/shared/segments/073.fragment.js'),'utf8');
 const template=printSource.split('dWe = {')[1].split('}, mWe =')[0];
 const drawer=fs.readFileSync(path.join(project,'src/views/contract/sales-manage/unit/order-tracking/module/invoice-detail-drawer.vue.js'),'utf8');
 assert.match(template,/key: "actualInvoiceAmount", title: "实际开票金额"/);
 assert.match(drawer,/props: \["actualInvoiceAmount"\]/);
 assert.match(drawer,/prop: "actualInvoiceAmount"/);
 cases++;
}
// Shipment return DTO already carries tonnes and uses the new pricing enum.
{
 const source=fs.readFileSync(path.join(project,'src/shared/segments/073.fragment.js'),'utf8');
 const structure=source.split('jKe = {')[1].split('}, FKe =')[0];
 assert.match(structure,/key: "pricingManner"[^}]+enum: "newPricingMannerEnum"/);
 for(const field of ['netWeight','totalNetWeight']){
   const format=structure.split('key: "'+field+'"')[1].split('}')[0];
   assert.match(format,/precision: 6/);
   assert.doesNotMatch(format,/unit:/);
 }
 cases++;
}
// Company metadata never manufactures a central customer code, version, or expiry.
const company=fs.readFileSync(path.join(project,'src/modules/enterprise-information-1064963f.js'),'utf8');let companyFunction;walk(parse(company,{sourceType:'module'}),n=>{if(n.type==='FunctionDeclaration'&&n.id.name==='getCustomer')companyFunction=n});const localRead=vm.runInNewContext('('+company.slice(companyFunction.start,companyFunction.end)+')',{store:{getters:{user:{companyName:'数据库公司',companyLogo:'/files/actual-logo'}}},request(){throw Error('No central or extra request needed')}});const facts=await localRead();assert.equal(facts.name,'数据库公司');assert.equal(facts.code,null);assert.equal(facts.version,null);assert.equal(facts.licenseExpiresAt,null);cases++;
let requested;const fallbackRead=vm.runInNewContext('('+company.slice(companyFunction.start,companyFunction.end)+')',{store:{getters:{user:{}}},request:async config=>{requested=config;return{companyName:'本地配置公司'}}});assert.equal((await fallbackRead()).name,'本地配置公司');assert.equal(requested.url,'/api/config/company/name');assert.equal(company.includes('https://'),false);cases++;
const userSource=fs.readFileSync(path.join(project,'src/shared/segments/037.fragment.js'),'utf8');let userSetter;walk(parse(userSource,{sourceType:'module'}),n=>{if(n.type==='ObjectProperty'&&n.key.name==='SET_USER')userSetter=n.value});assert(userSetter);const mutation=vm.runInNewContext('('+userSource.slice(userSetter.start,userSetter.end)+')');const userState={};mutation(userState,{companyName:'本地公司',companyLogo:'/files/actual-logo'});assert.equal(userState.user.companyLogo,'/files/actual-logo');cases++;
const fonts=JSON.parse(fs.readFileSync(path.join(project,'local-font-verification.json')));assert.equal(fonts.sprite_remaining_external_font_references,0);assert(fonts.public_svg_files.every(x=>x.paths_preserved>0));assert.equal(guardSource.includes('font_1031158_u69w8yhxdu'),false);cases++;
const report={cases,refresh_keeps_session:true,single_flight_menu_initialization:true,optional_configuration_failure_is_not_logout:true,central_company_lookup:false,unknown_license_fields_not_fabricated:true,automatic_print_probe:false,explicit_unconfigured_print_rejects:true,svg_paths_preserved:true,verified_at:new Date().toISOString()};fs.writeFileSync(path.join(project,'local-runtime-verification.json'),JSON.stringify(report,null,2)+'\n');console.log(report);
