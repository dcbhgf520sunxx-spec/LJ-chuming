import assert from 'node:assert/strict';
import fs from 'node:fs';
import vm from 'node:vm';
import { parse } from '@babel/parser';
const read=n=>fs.readFileSync(new URL('../src/shared/segments/'+n+'.fragment.js',import.meta.url),'utf8');
const body=source=>parse(source,{sourceType:'module'}).program.body;
const fn=(source,name)=>{const node=body(source).find(node=>node.type==='FunctionDeclaration'&&node.id.name===name);assert.ok(node,name);return source.slice(node.start,node.end);};
const common=read('001'),fields=read('050'),exporter=read('073');
const definitions=body(fields).flatMap(node=>node.type==='VariableDeclaration'?node.declarations:[]);
const a=definitions.find(node=>node.id.name==='a'), i=definitions.find(node=>node.id.name==='i');assert.ok(a&&i);
const context=vm.createContext({});
vm.runInContext('var a='+fields.slice(a.init.start,a.init.end)+';var i='+fields.slice(i.init.start,i.init.end)+';\n'+['A','Ae','Si'].map(name=>fn(common,name)).join('\n')+'\n'+['yc','wPe','APe'].map(name=>fn(exporter,name)).join('\n'),context);
const format=(val,type)=>context.yc({val,field:{key:'value',source:1,type,format:{precision:2}},emptyVal:'/',dataType:'tableData'});
for(const [val,type] of [['000000000000000012',undefined],['123456789012345678',undefined],['000123','GUID'],['13588089180','OTHER'],['+8613588089180','CONTRACT_NO'],['123','USER_NAME']]) {
 assert.equal(format(val,type),val,'Text field '+String(type)+' must retain exact identifier: '+val);
 assert.equal(typeof format(val,type),'string');
}
for(const [val,type,expected] of [['500.00','AMOUNT',500],['-123.45','AMOUNT',-123.45],['3.50','QUANTITY',3.5],['0','AMOUNT',0]]) {
 assert.equal(format(val,type),expected,'Numeric measure '+type);assert.equal(typeof format(val,type),'number');
}
assert.equal(format(15,undefined),15,'Previously numeric API values stay numeric without metadata');
let style;
function findStyle(node) {
 if(!node||typeof node!=='object')return;
 if(node.type==='ExpressionStatement'&&exporter.slice(node.start,node.end).includes('.includes(L.type)'))style=exporter.slice(node.start,node.end);
 for(const [key,value] of Object.entries(node))if(key!=='loc') {
  if(Array.isArray(value))value.forEach(findStyle);else if(value&&typeof value==='object')findStyle(value);
 }
}
findStyle(body(exporter).find(node=>node.type==='FunctionDeclaration'&&node.id.name==='EPe'));assert.ok(style);
for(const [value,type,formatted] of [['000012','OTHER',false],['123456789012345678',undefined,false],[500,'AMOUNT',true],[15,undefined,true]]) {
 context.c={A1:{v:value}};context.O='A1';context.L={type,format:{toThousand:true}};context.o={td:{size:9}};context.f6={};context.ul=x=>x;context.pr=()=> 'left';
 vm.runInContext('var y,b;'+style,context);assert.equal(context.c.A1.z,formatted?'#,##0.00':undefined,'Number format must follow numeric data/type');
}
console.log('Actual print-cell formatter: six text identifiers, five numeric measures and four styles passed');
