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
const show = sourceFunction('src/views/operation/production-performance-dashboard/material-loss-analysis-detail.vue.js', 'F');
const isPresent = vm.runInNewContext(`(${sourceFunction('src/shared/segments/001.fragment.js', 'A')})`);
const tests = [];
const test = (name, run) => tests.push({name, run});
for (const [label, data, expected] of [
  ['scrap tonnes are converted before subtracting from kg', [{outMete:100000, mete:90000, sellMete:5}], '5.00%'],
  ['normal production and one tonne sale', [{outMete:10000, mete:8000, sellMete:1}], '10.00%'],
  ['no scrap sale', [{outMete:10000, mete:9000, sellMete:0}], '10.00%'],
  ['fully accounted steel', [{outMete:10000, mete:8000, sellMete:2}], '0.00%'],
  ['months use weighted totals', [{outMete:100000, mete:90000, sellMete:5}, {outMete:50000, mete:40000, sellMete:2}], '8.67%'],
  ['no issues', [{outMete:0, mete:50, sellMete:1}], '0%'],
  ['empty source', [], '0%'],
  ['null response', null, '0%'],
  ['negative native loss stays visible', [{outMete:10000, mete:9000, sellMete:2}], '-10.00%'],
]) {
  test(label, async () => {
    const I = {value:0}, w = {value:[]}, calls = [], errors = [];
    const before = JSON.stringify(data);
    const refresh = vm.runInNewContext(`(${show})`, {
      I, w, m:{permission:{detail:true}, query:{branchCompanyId:2}, workshopId:1, searchDate:2026},
      V:value=>value === true, N:isPresent,
      $:async params=>{ calls.push(params); return data; },
      console:{log:(...args)=>errors.push(args)},
    });
    await refresh();
    assert.equal(errors.length, 0, 'Actual show-hook must not hide a thrown calculation');
    assert.equal(I.value, expected);
    assert.equal(calls.length, 1);
    assert.equal(calls[0].branchCompanyId, 2);
    assert.equal(calls[0].workshopId, 1);
    assert.equal(calls[0].yearDate, 2026);
    assert.equal(JSON.stringify(data), before, 'Do not change native kg/tonne fields used by existing columns');
    assert.equal(JSON.stringify(w.value), JSON.stringify(data || []));
  });
}
test('no detail permission keeps the API uncalled', async () => {
  const I = {value:'existing'}, w = {value:[]};
  const refresh = vm.runInNewContext(`(${show})`, {
    I, w, m:{permission:{detail:false}}, V:()=>false,
    $:()=>{ throw new Error('Permission denied: API must not run'); },
  });
  assert.equal(await refresh(), false);
  assert.equal(I.value, 'existing');
});
let failed = 0;
for (const {name, run} of tests) {
  try { await run(); console.log(`PASS material loss: ${name}`); }
  catch (error) { failed++; console.error(`FAIL material loss: ${name}: ${error.message}`); }
}
const result={cases:tests.length, failed, actual_show_hook_executed:true, actual_presence_helper_executed:true, issued_and_finished_unit:'kg', scrap_sale_unit:'tonne', browser_verified:false};
console.log(JSON.stringify(result));
if (failed) process.exitCode = 1;

fs.writeFileSync(path.join(root, 'material-loss-rate-verification.json'), JSON.stringify({...result, verified_at:new Date().toISOString()}, null, 2) + '\n');
