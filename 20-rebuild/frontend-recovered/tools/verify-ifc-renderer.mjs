import assert from 'node:assert/strict';
import * as THREE from 'three';
import * as rendering from '../src/views/bim/ifc-model-show/render-data.js';
import { isSelectedPart, selectionColor, stages, statusAppearance } from '../src/views/bim/ifc-model-show/progress.js';
import { createIfcViewer } from '../src/views/bim/ifc-model-show/viewer.js';

assert.equal(typeof rendering.decodeIfcModel, 'function', 'Completed IFC buffers must reuse flattened decoded geometry');
const { decodeIfcModel, createIfcRenderData, createIfcRenderState, modelColor } = rendering;
const ids = ['0000000000000000000001', '0000000000000000000002',
  '0000000000000000000003', '0000000000000000000004'];
function sourceModel() {
  const scene = new THREE.Group();
  const geometry = new THREE.BoxGeometry(2, 2, 2);
  const material = new THREE.MeshBasicMaterial();
  for (const [i, id] of ids.entries()) {
    const element = new THREE.Group();
    element.name = id;
    element.position.x = [10, 14, 20, 30][i];
    element.add(new THREE.Mesh(i === 3 ? new THREE.BoxGeometry(4, 2, 2) : geometry, material));
    if (!i) {
      const second = new THREE.Mesh(geometry, material);
      second.position.y = 3;
      element.add(second);
    }
    scene.add(element);
  }
  return { scene };
}
const index = {
  parts: { [ids[0]]: ['a', 'GZ-1'], [ids[1]]: ['a', 'GZ-1'], [ids[2]]: ['b', 'GZ-1'] },
  assemblies: [{ id: 'a', mark: 'GZ-1', position: '1/A' }, { id: 'b', mark: 'GZ-1', position: '2/A' }],
};
const buffer = new ArrayBuffer(4);
let parses = 0;
const parse = async () => { parses++; return sourceModel(); };
const [decoded, shared] = await Promise.all([decodeIfcModel(buffer, parse), decodeIfcModel(buffer, parse)]);
assert.equal(decoded, shared);
assert.equal(await decodeIfcModel(buffer, parse), decoded);
assert.equal(parses, 1, 'Concurrent and repeated loads must decode once');
assert.equal(decoded.scene, undefined, 'The cache must retain flattened render data, not the full GLTF scene');
await decodeIfcModel(new ArrayBuffer(4), parse);
assert.equal(parses, 2, 'Different buffer identities must not reuse the wrong geometry');
const failedBuffer = new ArrayBuffer(4);
await assert.rejects(decodeIfcModel(failedBuffer, async () => { throw new Error('invalid model'); }), /invalid model/);
assert.ok(await decodeIfcModel(failedBuffer, parse), 'A failed decode must not poison the next load');

const data = createIfcRenderData(decoded, index);
const remapped = createIfcRenderData(decoded, { ...index, parts: { [ids[0]]: ['other', 'OTHER'] } });
assert.equal(data.byElement.get(ids[0]).length, 2);
assert.equal(data.byAssembly.get('a').length, 3);
assert.equal(data.byMark.get('GZ-1').length, 4);
assert.equal(remapped.byElement.get(ids[0])[0].mark, 'OTHER', 'The same buffer with a different index must use current metadata');
assert.equal(data.byElement.get(ids[0])[0].mark, 'GZ-1');
assert.deepEqual(data.elementIds, ids);
assert.equal(data.elementBounds.get(ids[0]).max.y - data.elementBounds.get(ids[0]).min.y, 5,
  'Element focus bounds must include every mesh of that element');
assert.equal(data.assemblyBounds.get('a').max.x - data.assemblyBounds.get('a').min.x, 6);
assert.equal(data.markBounds.get('GZ-1').max.x - data.markBounds.get('GZ-1').min.x, 12);
assert.deepEqual(data.box.getCenter(new THREE.Vector3()).toArray(), [0, 0, 0]);
assert.equal(data.groups[0].geometry.attributes.position.array, remapped.groups[0].geometry.attributes.position.array,
  'View geometry wrappers should reuse immutable decoded arrays');
assert.notEqual(data.groups[0].geometry, remapped.groups[0].geometry);

const withExtra = createIfcRenderData(decoded, { ...index, extraMeshes: [
  { id: '0000000000000000000005', positions: [40, 0, 0, 42, 0, 0, 40, 2, 0], indices: [0, 1, 2] },
] });
assert.equal(withExtra.box.max.x - withExtra.box.min.x, 33, 'Supplemental geometry participates in centering and overview fit');
assert.equal(withExtra.byElement.get('0000000000000000000005').length, 1);

const state = createIfcRenderState(data);
const isolated = createIfcRenderState(remapped);
const hidden = new Set();
state.update(undefined, undefined, undefined, undefined, null, hidden);
const matrices = state.batches.map(draw => draw.instanceMatrix.version);
const colors = state.batches.map(draw => draw.instanceColor.version);
const group = state.batches[0];
const loose = state.batches[1];
const looseCenter = new THREE.Vector3().setFromMatrixPosition(data.byElement.get(ids[3])[0].matrix);
const ray = new THREE.Raycaster(looseCenter.clone().add(new THREE.Vector3(0, 0, 100)), new THREE.Vector3(0, 0, -1));
assert.ok(ray.intersectObjects([loose], false).length, 'The original loose instance must remain pickable');
state.update(undefined, undefined, undefined, { id: ids[0], assemblyId: 'a' }, null, hidden);
assert.deepEqual(state.batches.map(draw => draw.instanceMatrix.version), matrices,
  'Selection-only changes must not rewrite instance matrices');
assert.equal(loose.instanceColor.version, colors[1], 'Unrelated batches must not upload colors for a selection');
assert.equal(group.instanceColor.updateRanges.reduce((sum, range) => sum + range.count, 0), 9,
  'Selection color uploads must cover only the changed three instances');
const colorAt = item => new THREE.Color().fromArray(item.group.draw.instanceColor.array, item.slot * 3).getHex();
assert.ok(data.byAssembly.get('a').every(item => colorAt(item) === selectionColor));
assert.equal(colorAt(data.byAssembly.get('b')[0]), modelColor);
state.update(undefined, undefined, undefined, { id: ids[0], assemblyId: 'a', elementOnly: true }, null, hidden);
assert.ok(data.byElement.get(ids[0]).every(item => colorAt(item) === selectionColor));
assert.equal(colorAt(data.byElement.get(ids[1])[0]), modelColor);

let progressReads = 0;
const match = { state: 2 };
const progress = { byMark: { get() { progressReads++; return match; } } };
state.update('production', progress, undefined, { assemblyId: 'a' }, null, hidden);
assert.equal(colorAt(data.byElement.get(ids[0])[0]), stages.production.colors[2]);
assert.equal(state.selectionLines.children.length, 3, 'Status mode must keep its fill and outline the whole selected assembly');
progressReads = 0;
const statusMatrixVersions = state.batches.map(draw => draw.instanceMatrix.version);
const statusColorVersions = state.batches.map(draw => draw.instanceColor.version);
state.update('production', progress, undefined, { id: ids[2], assemblyId: 'b', elementOnly: true }, null, hidden);
assert.equal(progressReads, 0, 'Selection-only changes must not rescan progress for every instance');
assert.deepEqual(state.batches.map(draw => draw.instanceMatrix.version), statusMatrixVersions);
assert.deepEqual(state.batches.map(draw => draw.instanceColor.version), statusColorVersions,
  'Status selection changes need only update the outline');
assert.equal(state.selectionLines.children.length, 1);
state.update('production', progress, 'GZ-1', { assemblyId: 'a' }, null, hidden);
assert.equal(loose.visible, false, 'A fully hidden batch must not submit a draw');
assert.equal(loose.count, 0);
assert.equal(ray.intersectObjects([loose], false).length, 0, 'Hidden batches must also be excluded from real Three.js raycasts');
assert.equal(group.count, 4);
hidden.add(ids[0]);
state.update('production', progress, 'GZ-1', { assemblyId: 'a' }, null, hidden);
assert.equal(group.count, 2, 'Hidden instances must leave the draw prefix instead of submitting offscreen triangles');
assert.equal(state.selectionLines.children.length, 1);
assert.ok(group.userData.items.every(item => item.visible && item.id !== ids[0]), 'Raycast instance slots must follow the compacted draw order');
group.userData.items.forEach((item, slot) => assert.equal(item.slot, slot));
assert.equal(isolated.batches[0].count, 4, 'Viewer visibility must stay independent when buffers are shared');
hidden.clear();
state.update('production', progress, undefined, undefined, 0, hidden);
assert.ok(state.batches.every(draw => !draw.visible && draw.count === 0), 'Progress filters must suppress every nonmatching draw');
state.update(undefined, undefined, undefined, undefined, null, hidden);
assert.equal(group.count, 4);
assert.equal(loose.count, 1);
assert.ok(ray.intersectObjects([loose], false).length, 'Restored instances must remain pickable at their original location');
const restoredMatrices = state.batches.map(draw => draw.instanceMatrix.version);
const restoredColors = state.batches.map(draw => draw.instanceColor.version);
state.update(undefined, undefined, undefined, undefined, null, hidden);
assert.deepEqual(state.batches.map(draw => draw.instanceMatrix.version), restoredMatrices, 'A no-op update must not upload matrices');
assert.deepEqual(state.batches.map(draw => draw.instanceColor.version), restoredColors, 'A no-op update must not upload colors');

const realProgress = { byMark: new Map([['GZ-1', { state: 'mixed', count: 2, quantity: 3 }]]) };
for (const selected of [undefined, { id: ids[0] }, { assemblyId: 'a' }, { mark: 'GZ-1' },
  { id: ids[0], assemblyId: 'a', elementOnly: true }, { id: 'missing' }, {}]) {
  for (const stage of [undefined, 'production']) {
    for (const filter of [null, 'mixed', 'unknown', 0]) {
      const hiddenIds = new Set([ids[1]]);
      state.update(stage, realProgress, undefined, selected, filter, hiddenIds);
      for (const batch of state.batches) {
        assert.equal(batch.count, batch.userData.items.length);
        for (const item of batch.userData.items) {
          const expectedVisible = !hiddenIds.has(item.id)
            && (filter == null || (realProgress.byMark.get(item.mark)?.state ?? 'unknown') === filter);
          assert.equal(item.visible, expectedVisible);
          const expectedColor = stages[stage] ? statusAppearance(stage, realProgress.byMark.get(item.mark)).color
            : isSelectedPart(item, selected) ? selectionColor : modelColor;
          assert.equal(colorAt(item), expectedColor, 'Indexed selections must match the established assembly/element/mark rules');
          const matrix = new THREE.Matrix4();
          batch.getMatrixAt(item.slot, matrix);
          assert.deepEqual(matrix.elements, item.matrix.elements, 'Visible instance slots must keep their original transforms');
        }
      }
    }
  }
}

const cancelled = new AbortController();
cancelled.abort();
assert.equal(await createIfcViewer(null, new ArrayBuffer(0), index, cancelled.signal), undefined,
  'An already cancelled view must not parse or allocate rendering resources');

let disposed = 0;
let isolatedDisposals = 0;
data.groups[0].geometry.addEventListener('dispose', () => disposed++);
remapped.groups[0].geometry.addEventListener('dispose', () => isolatedDisposals++);
state.dispose();
state.dispose();
assert.equal(disposed, 1, 'View GPU resources must be released exactly once');
assert.equal(isolatedDisposals, 0, 'Disposing one view must not dispose another view geometry');
assert.equal(await decodeIfcModel(buffer, parse), decoded, 'GPU disposal must not invalidate reusable CPU geometry');
isolated.dispose();
for (const group of withExtra.groups) group.geometry.dispose();
console.log('IFC decoded-data reuse, indexed focus, selection-only uploads, compact visibility and independent disposal passed');
