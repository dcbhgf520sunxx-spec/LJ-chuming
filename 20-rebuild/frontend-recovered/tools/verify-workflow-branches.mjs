import fs from 'node:fs';import path from 'node:path';import vm from 'node:vm';import assert from 'node:assert/strict';import{fileURLToPath}from'node:url';import{parse}from'@babel/parser';
const project=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..'),read=p=>fs.readFileSync(path.join(project,p),'utf8');
function walk(n,cb){if(!n||typeof n!=='object')return;if(n.type)cb(n);for(const[k,v]of Object.entries(n)){if(k==='loc')continue;if(Array.isArray(v))v.forEach(x=>walk(x,cb));else if(v?.type)walk(v,cb);}}
function nested(code,owner,name){let scope,fn;walk(parse(code,{sourceType:'module'}),n=>{if(n.type==='VariableDeclarator'&&n.id.name===owner)scope=n.init;});assert(scope,owner);walk(scope,n=>{if(n.type==='FunctionDeclaration'&&n.id.name===name)fn=code.slice(n.start,n.end);});assert(fn,name);return fn;}
function fn(code,name){let found;walk(parse(code,{sourceType:'module'}),n=>{if(n.type==='FunctionDeclaration'&&n.id.name===name)found=code.slice(n.start,n.end)});assert(found,name);return found;}
let cases=0;
for(const def of [
 {component:'056',owner:'fde',handler:'v',apiFragment:'045',apiName:'qU',loading:'T',opinion:'_',expected:'/api/wms/move_material/review'},
 {component:'047',owner:'lF',handler:'N',apiFragment:'046',apiName:'JU',loading:'m',opinion:'R',expected:'/api/v2/wms/reject/review'}
]){
 const requests=[],notices=[],emits=[];let fail=false;
 const api=vm.runInNewContext('('+fn(read(`src/shared/segments/${def.apiFragment}.fragment.js`),def.apiName)+')',{W:async c=>{requests.push(c);if(fail)throw Error('service denied');return true;}});
 const ctx={g:{id:77,approveRecordId:901},Lt:{REFUSE:{V:2},PASS:{V:1}},A:v=>v!==null&&v!==undefined&&v!=='',ot:{error:m=>notices.push(['error',m]),success:m=>notices.push(['success',m])},n:(...a)=>emits.push(a),console:{log(){}},[def.loading]:{value:false},[def.opinion]:{value:undefined},[def.apiName]:api};
 const handler=vm.runInNewContext('('+nested(read(`src/shared/segments/${def.component}.fragment.js`),def.owner,def.handler)+')',ctx);
 await handler(2);assert.equal(requests.length,0);assert.equal(emits.length,0);assert.equal(notices.at(-1)[1],'请输入审批意见');cases++;
 await handler(1);assert.equal(requests.at(-1).url,def.expected);assert.equal(requests.at(-1).params.approveRecordId,901);assert.equal(requests.at(-1).params.decision,1);assert.equal(Object.hasOwn(requests.at(-1).params,'id'),false);assert.equal(emits.length,1);assert.equal(ctx[def.loading].value,false);cases++;
 ctx[def.opinion].value='拒绝原因';await handler(2);assert.equal(requests.at(-1).params.opinion,'拒绝原因');assert.equal(requests.at(-1).params.decision,2);assert.equal(emits.length,2);cases++;
 fail=true;notices.length=0;await handler(1);assert.equal(emits.length,2);assert.equal(notices.length,0);assert.equal(ctx[def.loading].value,false);cases++;
}
const autoSource=read('src/views/wms/mes-receipt-review/module/auto-detail.vue.js');let result=null;const arrays=[];const ctx={b:v=>v!==null&&v!==undefined,r:{value:{taskOrderId:78}},m:{value:false},y:{value:[]},G:async()=>result,A:async rows=>{assert(Array.isArray(rows));arrays.push(rows);return rows;},console};
const load=vm.runInNewContext('('+nested(autoSource,'se','T')+')',ctx);await load();assert.equal(ctx.y.value.length,0);assert.equal(arrays.length,1);cases++;
result={frozenQuantity:3,frozenMete:4};await load();assert.equal(ctx.y.value[0],result);assert.equal(ctx.m.value,false);cases++;
// Verify current-menu review pages keep the old local dialogs closed and use the new CRUD detail components.
for(const file of ['src/views/wms/material-moving-inventory/raw-material/review/index.vue.js','src/views/wms/material-reject/raw-material/review/index.vue.js']){
 const s=read(file);const ast=parse(s,{sourceType:'module'});const trueAssignments=[];walk(ast,n=>{if(n.type==='AssignmentExpression'&&n.right.type==='BooleanLiteral'&&n.right.value)trueAssignments.push(s.slice(n.start,n.end));});assert.equal(trueAssignments.length,0);cases++;
}
const report={cases,verified_at:new Date().toISOString(),actual_recovered_new_approval_handlers_and_http_functions:true,uses_approve_record_id_not_business_id:true,requires_refusal_opinion:true,failed_request_does_not_emit_success:true,missing_freeze_record_becomes_empty_rows:true,old_local_review_dialogs_have_no_opener_assignment:true,browser_verified:false};fs.writeFileSync(path.join(project,'workflow-branches-verification.json'),JSON.stringify(report,null,2)+'\n');console.log(report);
