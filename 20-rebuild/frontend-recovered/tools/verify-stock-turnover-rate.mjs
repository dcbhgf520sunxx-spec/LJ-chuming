import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import {fileURLToPath} from 'node:url';
import {parse} from '@babel/parser';

const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), '..');
function sourceFunction(file, name) {
  const source = fs.readFileSync(path.join(root, file), 'utf8');
  let result;
  function walk(node) {
    if (!node || typeof node !== 'object') return;
    if (node.type === 'FunctionDeclaration' && node.id.name === name) result = source.slice(node.start, node.end);
    for (const [key, value] of Object.entries(node)) {
      if (key === 'loc') continue;
      if (Array.isArray(value)) value.forEach(walk);
      else if (value?.type) walk(value);
    }
  }
  walk(parse(source, {sourceType: 'module'}));
  assert(result, `${file}: ${name}`);
  return result;
}
const show = sourceFunction('src/views/operation/stock-data-analysis/stock-turnover-detail.vue.js', 'F');
const isPresent = vm.runInNewContext(`(${sourceFunction('src/shared/segments/001.fragment.js', 'A')})`);
const tests = [];
const test = (name, run) => tests.push({name, run});
for (const [label, data, expectedRates, totalRate, totalIn, totalOut] of [
  ['actual October 14782 yuan in / 1995 yuan out', [{inCost:14782, outCost:1995}], ['13.50'], '13.50', '1', '0'],
  ['sub ten thousand amounts keep turnover', [{inCost:4000, outCost:1000}], ['25.00'], '25.00', '0', '0'],
  ['weighted raw totals are rounded only for display', [{inCost:14999, outCost:1995},{inCost:5001,outCost:1005}], ['13.30','20.10'], '15.00', '2', '0'],
  ['zero incoming', [{inCost:0,outCost:500}], [0], 0, '0', '0'],
  ['zero outgoing', [{inCost:500,outCost:0}], [0], 0, '0', '0'],
  ['numeric API strings', [{inCost:'14782',outCost:'1995'}], ['13.50'], '13.50', '1', '0'],
  ['null amounts', [{inCost:null,outCost:null}], [0], 0, '0', '0'],
  ['full amount range', [{inCost:1000000,outCost:1250000}], ['125.00'], '125.00', '100', '125'],
]) {
  test(label, async () => {
    const c={value:[]}, calls=[], errors=[];
    const refresh=vm.runInNewContext(`(${show})`, {
      c, m:{permission:{detail:true},query:{branchCompanyId:2,workshopId:1,yearDate:2026}},
      C:permission=>permission===true, k:isPresent,
      H:async params=>{calls.push(params);return JSON.parse(JSON.stringify(data));},
      console:{log:(...args)=>errors.push(args)},
    });
    await refresh();
    assert.equal(errors.length,0,'Actual show-hook must not hide a thrown calculation');
    assert.deepEqual(Array.from(c.value.slice(0,-1),row=>row.rate),expectedRates);
    const summary=c.value.at(-1);
    assert.equal(summary.rate,totalRate);
    assert.equal(summary.inCost,totalIn);assert.equal(summary.outCost,totalOut);
    assert.equal(summary.index,'合计');assert.equal(summary.type,2);
    assert.equal(calls.length,1);assert.equal(calls[0].branchCompanyId,2);assert.equal(calls[0].workshopId,1);
    for(let i=0;i<data.length;i++) {
      assert.equal(c.value[i].inCost,(data[i].inCost/1e4).toFixed(0));
      assert.equal(c.value[i].outCost,(data[i].outCost/1e4).toFixed(0));
    }
  });
}
for(const data of [[],null]) test(data===null?'null API response':'empty API response',async()=>{
  const c={value:['prior']};
  const refresh=vm.runInNewContext(`(${show})`,{c,m:{permission:{detail:true},query:{}},C:()=>true,H:async()=>data,console});
  await refresh();assert.equal(c.value.length,0);
});
test('no detail permission keeps the API uncalled',async()=>{
  const c={value:['prior']};
  const refresh=vm.runInNewContext(`(${show})`,{c,m:{permission:{detail:false}},C:()=>false,H:()=>{throw new Error('must not call');}});
  assert.equal(await refresh(),false);assert.equal(c.value[0],'prior');
});
let failed=0;
for(const {name,run} of tests) {
  try{await run();console.log(`PASS stock turnover: ${name}`);}
  catch(error){failed++;console.error(`FAIL stock turnover: ${name}: ${error.message}`);}
}
const result={cases:tests.length,failed,actual_show_hook_executed:true,actual_presence_helper_executed:true,rate_uses:'raw yuan',displayed_amount_unit:'ten thousand yuan',browser_verified:false};
console.log(JSON.stringify(result));
if(failed)process.exitCode=1;

fs.writeFileSync(path.join(root, 'stock-turnover-rate-verification.json'), JSON.stringify({...result, verified_at:new Date().toISOString()}, null, 2) + '\n');
