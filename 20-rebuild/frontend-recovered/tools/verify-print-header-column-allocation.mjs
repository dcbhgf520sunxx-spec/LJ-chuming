import assert from 'node:assert/strict';
import fs from 'node:fs';
import vm from 'node:vm';
import { createRequire } from 'node:module';
import { parse } from '@babel/parser';
const require=createRequire(import.meta.url), Yi=require('xlsx-legacy');
const file=n=>new URL('../src/shared/segments/'+n+'.fragment.js',import.meta.url);
function declaration(segment,name) {
  const source=fs.readFileSync(file(segment),'utf8');
  const node=parse(source,{sourceType:'module'}).program.body.find(node=>node.type==='FunctionDeclaration'&&node.id.name===name);
  assert.ok(node,name+' must be the actual shipped function');return source.slice(node.start,node.end);
}
const presence=declaration('001','A');
const source=fs.readFileSync(file('061'),'utf8');
const maxIndex=parse(source,{sourceType:'module'}).program.body.find(node=>node.type==='ExpressionStatement'&&node.expression.type==='AssignmentExpression'&&node.expression.left.property?.name==='maxIndex');
assert.ok(maxIndex);const prototype=source.slice(maxIndex.start,maxIndex.end);
let count=0;
for(const [segment,name] of [['051','eJ'],['073','pPe']]) {
  const implementation=declaration(segment,name);
  for(const footer of [false,true]) for(const widths of [[20,20,20],[40,40,40],[45,30,15]]) {
    const labels=['统计日期：2026-10','打印时间：16:50','打印人：管理员'];
    const args={ws:{'!ref':'A1:F8','!cols':Array.from({length:6},()=>({wpx:10})),'!rows':[]},
      headerCfg:{fields:widths.map(width=>({show:true,width})),size:10},
      footerCfg:{fields:widths.map(width=>({show:true,width})),size:10},tableCfg:{index:{show:false}},
      baseCfg:{unit:'px'},sr:{header:0,footerExtra:6},
      rn:{title:0,header:footer?0:1,tHeader:1,tBody:1,footerTip:0,footerExtra:footer?1:0},
      headerRows:footer?[]:[labels],footerRows:footer?[labels]:[]};
    const context=vm.createContext({Yi,seed:JSON.stringify(args),ta:value=>value,ul:value=>value,ym:value=>value,mr:value=>value,Dm:value=>value,pr:value=>value});
    vm.runInContext(prototype+'\n'+presence+'\n'+implementation+'\nvar actual=JSON.parse(seed);'+name+'(actual);',context);
    const ws=context.actual.ws,merges=ws['!merges'];assert.equal(merges.length,3);
    let previous=-1;
    for(const merge of merges) {
      assert.ok(merge.s.c>=0&&merge.s.c<=merge.e.c&&merge.e.c<6,'Every source header/footer merge stays ordered inside six table columns: '+JSON.stringify(merges));
      assert.equal(merge.s.c,previous+1,'Metadata fields must not overlap or leave the grid');previous=merge.e.c;
    }
    assert.equal(previous,5);
    assert.deepEqual(Array.from(merges,(merge)=>ws[Yi.utils.encode_cell(merge.s)].v),labels,'All metadata labels survive');
    count++;
  }
}
console.log('Actual two print exporters: '+count+' header/footer column-allocation checks passed');
