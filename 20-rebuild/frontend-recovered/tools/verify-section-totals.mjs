import fs from 'node:fs';
import path from 'node:path';
import vm from 'node:vm';
import assert from 'node:assert/strict';
import { fileURLToPath } from 'node:url';
import { parse } from '@babel/parser';

const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), '..');
const dir = 'src/views/mes/scheduling-manage/section-machine-part/';
const read = file => fs.readFileSync(path.join(root, file), 'utf8');
function walk(node, visit) {
  if (!node || typeof node !== 'object') return;
  if (node.type) visit(node);
  for (const [key, value] of Object.entries(node)) {
    if (key === 'loc') continue;
    if (Array.isArray(value)) value.forEach(child => walk(child, visit));
    else if (value?.type) walk(value, visit);
  }
}
function sourceFunction(file, name) {
  const source = read(file);
  let result;
  walk(parse(source, { sourceType: 'module' }), node => {
    if (node.type === 'FunctionDeclaration' && node.id.name === name) result = source.slice(node.start, node.end);
  });
  assert(result, `${file}: ${name}`);
  return result;
}
// Execute the shared summary and its actual numeric helpers, including its decimal precision extension.
const shared = vm.createContext({});
for (const [fragment, names] of [['001', ['Ae', 'ji']], ['002', ['Ho']], ['043', ['mn', 'Hi']]]) {
  for (const name of names) vm.runInContext(sourceFunction(`src/shared/segments/${fragment}.fragment.js`, name), shared);
}
const extensions = parse(read('src/shared/segments/061.fragment.js'), { sourceType: 'module' }).program.body;
for (const node of extensions) {
  if (node.type === 'ExpressionStatement' && node.expression.type === 'AssignmentExpression' && node.expression.left.property?.name === 'getMax') {
    const source = read('src/shared/segments/061.fragment.js');
    vm.runInContext(source.slice(node.start, node.end), shared);
  }
}
const summary = vm.runInNewContext(`(${sourceFunction(dir + 'index.vue.js', 'ge')})`, { Ve: shared.Hi });
const preview = vm.runInNewContext(`(${sourceFunction(dir + 'module/preview.vue.js', 'oe')})`);
const materials = vm.runInNewContext(`(${sourceFunction(dir + 'module/materials-drawer.vue.js', 'Ie')})`);
const row = { id: 23, partType: '型材', specification: 'H200', material: 'Q355', specificationAndMaterial: 'H200-Q355', quantity: 2, weight: 16.9, length: 1000, LENGTH: 0, totalWeight: 33.8, totalLength: 2000 };
const columns = [{ property: 'index' }, { property: 'weight' }, { property: 'quantity' }];
const tests = [];
const test = (name, run) => tests.push({ name, run });
for (const [label, data, quantity, weight, length] of [
  ['quantity two', [row], 2, 33.8, 2000],
  ['quantity three decimal weight', [{ ...row, quantity: 3 }], 3, 50.7, 3000],
  ['mixed quantities and lengths', [row, { ...row, id: 24, quantity: 3, weight: 10, length: 750 }], 5, 63.8, 4250],
  ['numeric JSON strings', [{ ...row, quantity: '2', weight: '16.9', length: '1000' }, { ...row, quantity: '3', weight: '10', length: '750' }], 5, 63.8, 4250],
  ['zero quantity', [{ ...row, quantity: 0 }], 0, 0, 0]
]) {
  test(`current list summary: ${label}`, () => {
    for (const rows of [data, data.map(sourceRow => ({ ...sourceRow, weight: -1, sourceRow }))]) {
      const before = JSON.stringify(rows);
      const totals = summary({ columns, data: rows });
      assert.equal(Number(totals[1]), weight, 'summary must sum unit weight times effective quantity');
      assert.equal(Number(totals[2]), quantity);
      assert.equal(JSON.stringify(rows), before, 'summary must retain original rows and sourceRow');
    }
  });
  for (const [name, aggregate] of [['production preview', preview], ['material binding', materials]]) {
    test(`${name}: ${label}`, () => {
      const before = JSON.stringify(data), result = aggregate(data);
      assert.equal(result.length, 1);
      assert.equal(result[0].quantity, quantity);
      assert.equal(result[0].weight, weight, 'group weight must account for every piece');
      assert.equal(result[0].length, length, 'group length must account for every piece in mm');
      assert.equal(JSON.stringify(data), before, 'aggregate must not change unit fields or submitted quantities');
    });
  }
}
test('empty summaries', () => {
  assert.equal(summary({ columns, data: [] })[1], undefined);
  assert.equal(preview([]).length, 0);
  assert.equal(materials([]).length, 0);
});
test('different specifications retain distinct totals', () => {
  const data = [row, { ...row, specification: 'H300', specificationAndMaterial: 'H300-Q355', quantity: 3, weight: 10, length: 750 }];
  for (const aggregate of [preview, materials]) {
    const result = aggregate(data);
    assert.equal(result.length, 2);
    assert.equal(result[0].weight, 33.8);
    assert.equal(result[1].weight, 30);
    assert.equal(result[0].length, 2000);
    assert.equal(result[1].length, 2250);
  }
});
let failed = 0;
for (const { name, run } of tests) {
  try { run(); console.log(`PASS ${name}`); }
  catch (error) { failed++; console.error(`FAIL ${name}: ${error.message}`); }
}
const result = { cases: tests.length, failed, source_functions_executed: true, shared_summary_executed: true, raw_length_unit: 'mm', browser_verified: false };
console.log(JSON.stringify(result));
if (failed) process.exitCode = 1;

fs.writeFileSync(path.join(root, 'section-totals-verification.json'), JSON.stringify({...result, verified_at:new Date().toISOString()}, null, 2) + '\n');
