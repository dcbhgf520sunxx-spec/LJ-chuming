import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import {fileURLToPath} from 'node:url';
import {parse} from '@babel/parser';
const root=path.resolve(path.dirname(fileURLToPath(import.meta.url)),'..');
function actualPrintParams(file){
 const source=fs.readFileSync(path.join(root,file),'utf8');let expression;
 function walk(node){
  if(!node||typeof node!=='object')return;
  if(node.type==='ObjectExpression' && node.properties.some(p=>p.key?.value==='api-key'&&p.value?.value==='myProject')){
   const params=node.properties.find(p=>p.key?.name==='params');assert(params,'Current print-table must carry params');expression=source.slice(params.value.start,params.value.end);
  }
  for(const value of Object.values(node)){if(Array.isArray(value))value.forEach(walk);else if(value?.type)walk(value);}
 }
 walk(parse(source,{sourceType:'module'}));assert(expression,'Current myProject print opener not found');return expression;
}
const plan=actualPrintParams('src/views/plan/project-list/module/header.vue.js');
const mes=actualPrintParams('src/views/mes/projects/module/header.vue.js');
const bridge=actualPrintParams('src/views/bridge/projects/module/header.vue.js');
let cases=0;
for(const query of [{year:2026,status:0,noOrName:'QA20261023PROJECTIMPORT'}, {year:2025,status:1,noOrName:'本地承包'}, {year:undefined,status:undefined,noOrName:undefined}]){
 const result=vm.runInNewContext(`(${plan})`,{e:value=>value,o:{query}});
 assert.equal(result.year,query.year);assert.equal(result.status,query.status);assert.equal(result.noName,query.noOrName);assert.equal(Object.keys(result).sort().join(','),'noName,status,year');cases++;
}
for(const mask of [25,8,16,undefined]){
 const query={year:2026,status:mask===8?1:0,noOrName:'QA20261023PROJECTIMPORT',lumpSumSystemType:mask};
 const result=vm.runInNewContext(`(${mes})`,{e:value=>value,l:{query},d:{STEEL:{V:1}}});
 assert.equal(result.year,query.year);assert.equal(result.status,query.status);assert.equal(result.noName,query.noOrName);assert.equal(result.projectType,1);assert.equal(result.lumpSumSystemType,mask);cases++;
}
for(const query of [{year:2026,status:0,noOrName:'QA桥梁'}, {year:2025,status:1,noOrName:'本地承包'}, {year:undefined,status:undefined,noOrName:undefined}]){
 const result=vm.runInNewContext(`(${bridge})`,{e:value=>value,l:{query},m:{BRIDGE:{V:2}}});
 assert.equal(result.year,query.year);assert.equal(result.status,query.status);assert.equal(result.noName,query.noOrName);assert.equal(result.projectType,2);cases++;
}
const result={cases,failed:0,actual_print_opener_params_executed:true,plan_parameter_alias:'noOrName -> noName',MES_project_type_preserved:true,current_lump_sum_mask_preserved:true,browser_verified:false,verified_at:new Date().toISOString()};
fs.writeFileSync(path.join(root,'project-print-filters-verification.json'),JSON.stringify(result,null,2)+'\n');console.log(result);
