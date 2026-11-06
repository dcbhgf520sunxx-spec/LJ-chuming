import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import { fileURLToPath } from 'node:url';
import { parse } from '@babel/parser';
const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), '..');
const dir = 'src/views/mes/production-manage/dashboard/project-material/';
const read = p => fs.readFileSync(path.join(root, p), 'utf8');
function nodes(n) { return n && typeof n === 'object' ? [n, ...Object.values(n).flatMap(v => Array.isArray(v) ? v.flatMap(nodes) : nodes(v))] : []; }
const page = parse(read(dir + 'index.vue.js'), { sourceType: 'module' });
const column = nodes(page).find(n => n.type === 'ObjectExpression' && n.properties.some(p => p.key?.name === 'label' && p.value?.value === '领料量(kg)'));
const prop = column.properties.find(p => p.key?.name === 'prop').value.value;
// Matches the actual populated API shape: actual receipt is known, theory is unknown.
const row = { receiveWeight: 1130, actualTheoryWeight: null };
assert.equal(row[prop], 1130, 'The receipt column must bind actual receipt, preserving missing theory');
const detail = read(dir + 'module/detail.vue.js');
const ast = parse(detail, { sourceType: 'module' });
const transform = nodes(ast).find(n => n.type === 'VariableDeclarator' && n.id.name === 'c' && n.init?.type === 'ArrowFunctionExpression' && n.init.params.length === 4).init;
const format = vm.runInNewContext('(' + detail.slice(transform.start, transform.end) + ')');
let cases = 1;
for (const [unit, theory, returned, expectedTheory] of [['吨', null, false, null], ['kg', 900000, false, 900], ['吨', 0, false, 0], ['吨', 180000, true, 180]]) {
  const input = { mete: 1000000, actualTheoryWeight: theory, accountingUnit: unit, quantity: 2 };
  const result = format([input], '小计', returned);
  assert.equal(result[0].mete, returned ? -1000 : 1000);
  assert.equal(result[0].accountingUnit, 'kg', 'Displayed unit must match the converted numeric value');
  assert.equal(result[0].actualTheoryWeight, expectedTheory);
  assert.equal(result[1].mete, result[0].mete);
  assert.equal(input.mete, 1000000, 'Read-only raw API fact must not be mutated');
  cases++;
}
assert.match(detail, /理论重量\(kg\)/);
assert.match(detail, /actualTheoryWeight\s*==\s*null\s*\?\s*["']-["']/);
cases++;
const result = { cases, failed: 0, source_functions_executed: true, raw_units: 'grams', displayed_units: 'kg', optional_theory_preserved: true, browser_verified: false };
fs.writeFileSync(path.join(root, 'project-material-weights-verification.json'), JSON.stringify(result, null, 2) + '\n');
console.log(JSON.stringify(result));
