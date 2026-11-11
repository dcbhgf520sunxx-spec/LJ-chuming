import assert from 'node:assert/strict';
import * as navigation from '../src/views/bim/ifc-model-show/navigation.js';
import { RoundedBoxGeometry } from 'three/addons/geometries/RoundedBoxGeometry.js';
import { componentTree, cubeDirection, cubeFaces, cubeFaceOrder, cubeHitDirection, viewDirections,
  zoomFromSlider, zoomLimits, zoomToSlider } from '../src/views/bim/ifc-model-show/navigation.js';
const index = {
  assemblies: [
    { id: 'a', mark: 'GZ-2', position: '2/B', members: ['one', 'two'] },
    { id: 'b', mark: 'GZ-2', position: '3/B', members: ['three'] },
    { id: 'c', mark: 'GZ-10', members: ['four'] },
  ],
  parts: { one: ['a', 'GZ-2'], two: ['a', 'GZ-2'], three: ['b', 'GZ-2'], four: ['c', 'GZ-10'] },
  looseElements: ['bolt'],
};
const roots = componentTree(index);
assert.deepEqual(roots.map(item => item.kind), ['mark', 'mark', 'loose']);
assert.equal(roots[0].label, 'GZ-2（2件）');
assert.deepEqual(roots[0].ids, ['one', 'two', 'three']);
assert.equal(roots[0].children[0].label, 'GZ-2 · 2/B');
assert.deepEqual(roots.at(-1).ids, ['bolt']);
assert.deepEqual(cubeDirection('front', 0.5, 0.5), [0, 0, 1]);
assert.deepEqual(cubeDirection('front', 0.05, 0.05), [-1, 1, 1]);
assert.deepEqual(cubeDirection('left', 0.5, 0.5), [-1, 0, 0]);
assert.deepEqual(cubeDirection('top', 0.95, 0.5), [1, 1, 0]);
assert.equal(Object.keys(viewDirections).length, 7);
console.log('IFC component hierarchy, loose elements and cube face/edge/corner directions passed');

const rounded = new RoundedBoxGeometry(1.25, 1.25, 1.25, 4, 0.065);
const normals = rounded.attributes.normal;
for (const [materialIndex, face] of cubeFaceOrder.entries()) {
  const group = rounded.groups.find(item => item.materialIndex === materialIndex);
  const average = [0, 0, 0];
  for (let i = group.start; i < group.start + group.count; i++) {
    average[0] += normals.getX(i); average[1] += normals.getY(i); average[2] += normals.getZ(i);
  }
  const direction = average.map(value => Math.abs(value) < 0.001 ? 0 : Math.sign(value));
  assert.deepEqual(direction, cubeFaces[face].direction, 'Rendered cube labels must match actual material normals');
  assert.deepEqual(cubeHitDirection(materialIndex, {x: 0.5, y: 0.5}), direction);
}
assert.deepEqual(cubeHitDirection(4, {x: 0.05, y: 0.95}), [-1, 1, 1]);
assert.deepEqual(cubeHitDirection(2, {x: 0.95, y: 0.5}), [1, 1, 0]);
rounded.dispose();
console.log('IFC rounded cube material/label normals and face/edge/corner picking passed');

const focusedDistance = navigation.focusDistance?.(20, 100);
assert.ok(focusedDistance > 20 && focusedDistance <= 100,
  'Component focus must leave surrounding room within the full-model zoom range');
const tinyPartDistance = navigation.focusDistance(0.01, 100);
assert.ok(100 / tinyPartDistance * 100 <= zoomLimits.max,
  'Focusing a tiny plate must not exceed the full-model maximum zoom');
assert.equal(navigation.focusDistance(200, 100), 100,
  'A large selection must fit within the overview instead of changing the zoom baseline');
assert.ok(zoomFromSlider(0) < 25, 'The viewer must allow zooming out below the old 25% limit');
assert.ok(zoomFromSlider(90) > 800, 'Individual components must support detail zoom beyond the old 800% cap');
console.log('IFC focus framing preserves full-model zoom limits for assemblies and tiny elements');

for (const percent of [10, 25, 50, 100, 200, 400, 800, 2500, 10000]) {
  assert.ok(Math.abs(zoomFromSlider(zoomToSlider(percent)) - percent) < 1e-9);
}
assert.equal(zoomFromSlider(-100), zoomLimits.min);
assert.equal(zoomFromSlider(200), zoomLimits.max);
assert.equal(zoomToSlider(1), 0);
assert.equal(zoomToSlider(50000), 100);
console.log('IFC zoom scale round trips and limits passed');
