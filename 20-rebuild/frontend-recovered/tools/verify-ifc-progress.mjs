import assert from 'node:assert/strict';
import { buildProgress, selectionColor, isSelectedPart, stages, statusAppearance } from '../src/views/bim/ifc-model-show/progress.js';

const assemblies = [
  { id: 'first', mark: 'GZ-1' },
  { id: 'second', mark: 'GZ-1' },
  { id: 'third', mark: 'GZ-2' },
  { id: 'unknown', mark: 'MS-1' },
];
const rows = [
  { mark: 'GZ-1', quantity: 2, complete: 1, inProduction: 2, inbound: 1, outbound: 0, received: 0, installed: 0 },
  { mark: 'GZ-2', quantity: 1, complete: 0, inProduction: 0, inbound: 0, outbound: 0, received: 0, installed: 0 },
  { mark: 'missing', quantity: 10, complete: 10, inProduction: 10 },
];
const production = buildProgress(assemblies, rows, 'production');
assert.deepEqual(production.totals, [1, 1, 1]);
assert.equal(production.byMark.get('GZ-1').state, 'mixed');
assert.equal(production.byMark.get('GZ-2').state, 0);
assert.equal(production.byMark.has('MS-1'), false);
assert.equal(production.unmatched, 1);
assert.deepEqual(buildProgress(assemblies, rows, 'shipment').totals, [2, 1, 0]);
assert.deepEqual(buildProgress(assemblies, rows, 'installation').totals, [3, 0, 0]);
const mismatch = buildProgress(assemblies.slice(1), rows, 'production');
assert.equal(mismatch.byMark.get('GZ-1').state, 'mixed');
assert.equal(mismatch.byMark.get('GZ-1').quantity, 2);
console.log('IFC progress counts and repeated-mark coloring passed');

const weighted = buildProgress(assemblies, [
  {...rows[0], totalGrossWeight: 20, completeWeight: 10, inProductionWeight: 20},
  {...rows[1], totalGrossWeight: 5},
], 'production');
assert.deepEqual(weighted.weightTotals, [5, 10, 10]);
assert.equal(production.weightTotals, null);
console.log('IFC status quantities and weights partition consistently');

assert.ok(Object.values(stages).every(stage => !stage.colors.includes(selectionColor)));
assert.notEqual(selectionColor, 0xa26de4, 'Selection must differ from mixed-progress color');
const member = {id: 'plate-a', assemblyId: 'column-a', mark: 'GZ-1'};
assert.equal(isSelectedPart(member, {id: 'plate-b', assemblyId: 'column-a'}), true);
assert.equal(isSelectedPart(member, {id: 'plate-b', assemblyId: 'column-a', elementOnly: true}), false);
assert.equal(isSelectedPart(member, {id: 'plate-a', elementOnly: true}), true);
assert.equal(isSelectedPart(member, {mark: 'GZ-1'}), true);
assert.equal(isSelectedPart(member, {id: 'plate-a', assemblyId: 'column-b'}), false);
assert.equal(isSelectedPart(member, undefined), false);
console.log('IFC assembly/element selection scope and independent highlight color passed');

for (const [stage, mode] of Object.entries(stages)) {
  for (let state = 0; state < mode.labels.length; state++) {
    assert.deepEqual(statusAppearance(stage, {state}), {label:mode.labels[state], color:mode.colors[state]});
  }
}
assert.deepEqual(statusAppearance('production', production.byMark.get('GZ-1')), {label:'部分完成', color:0xa26de4});
assert.equal(statusAppearance('production', mismatch.byMark.get('GZ-1')).label, '数量待核对');
assert.deepEqual(statusAppearance('production'), {label:'暂无进度', color:0x8796a9});
console.log('IFC detail status values share the model palette and preserve unknown/mixed states');
