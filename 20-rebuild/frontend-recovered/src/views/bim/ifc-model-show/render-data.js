import * as THREE from 'three';
import { stages, selectionColor, statusAppearance } from './progress.js';

export const modelColor = 0x9ba9b9;
const decodedModels = new WeakMap();

export function decodeIfcModel(buffer, parse) {
  if (decodedModels.has(buffer)) return decodedModels.get(buffer);
  const pending = Promise.resolve().then(() => parse(buffer)).then(({ scene: model }) => {
    const groups = new Map();
    const box = new THREE.Box3();
    const materials = new Set();
    model.updateMatrixWorld(true);
    model.traverse(mesh => {
      if (!mesh.isMesh) return;
      let node = mesh;
      while (node && !/^[0-9a-zA-Z_$]{22}$/.test(node.name)) node = node.parent;
      const key = mesh.geometry.uuid + ':' + mesh.material.uuid;
      if (!groups.has(key)) groups.set(key, { geometry: mesh.geometry, items: [] });
      groups.get(key).items.push({ id: node?.name, matrix: mesh.matrixWorld.clone() });
      if (!mesh.geometry.boundingBox) mesh.geometry.computeBoundingBox();
      box.union(mesh.geometry.boundingBox.clone().applyMatrix4(mesh.matrixWorld));
      for (const material of [mesh.material].flat()) {
        materials.add(material);
        for (const value of Object.values(material)) if (value?.isTexture) materials.add(value);
      }
    });
    for (const resource of materials) resource.dispose();
    return { groups: [...groups.values()], box };
  }).catch(error => {
    decodedModels.delete(buffer);
    throw error;
  });
  decodedModels.set(buffer, pending);
  return pending;
}

function geometryView(source) {
  // Geometry owns GPU lifetime; immutable decoded attributes can be shared across renderers.
  const geometry = new THREE.BufferGeometry();
  geometry.setIndex(source.index);
  for (const [name, attribute] of Object.entries(source.attributes)) geometry.setAttribute(name, attribute);
  for (const group of source.groups) geometry.addGroup(group.start, group.count, group.materialIndex);
  geometry.setDrawRange(source.drawRange.start, source.drawRange.count);
  geometry.boundingBox = source.boundingBox?.clone() || null;
  geometry.boundingSphere = source.boundingSphere?.clone() || null;
  return geometry;
}

export function createIfcRenderData(decoded, index) {
  const box = decoded.box.clone();
  const groups = decoded.groups.map(group => ({ geometry: geometryView(group.geometry), source: group.items }));
  for (const item of index.extraMeshes || []) {
    const geometry = new THREE.BufferGeometry();
    geometry.setAttribute('position', new THREE.Float32BufferAttribute(item.positions, 3));
    geometry.setIndex(item.indices);
    geometry.computeVertexNormals();
    geometry.computeBoundingBox();
    box.union(geometry.boundingBox);
    groups.push({ geometry, source: [{ id: item.id, matrix: new THREE.Matrix4() }] });
  }
  const offset = new THREE.Matrix4().makeTranslation(...box.getCenter(new THREE.Vector3()).negate().toArray());
  box.applyMatrix4(offset);
  const byElement = new Map(), byAssembly = new Map(), byMark = new Map();
  const elementBounds = new Map(), assemblyBounds = new Map(), markBounds = new Map();
  const bounds = new THREE.Box3();
  function add(items, boxes, key, item) {
    if (!items.has(key)) { items.set(key, []); boxes.set(key, new THREE.Box3()); }
    items.get(key).push(item);
    boxes.get(key).union(bounds);
  }
  for (const group of groups) {
    group.items = group.source.map((source, slot) => {
      const [assemblyId, mark] = index.parts[source.id] || [];
      const item = { id: source.id, assemblyId, mark, matrix: source.matrix.clone().premultiply(offset),
        visible: true, color: modelColor, slot, group };
      bounds.copy(group.geometry.boundingBox).applyMatrix4(item.matrix);
      add(byElement, elementBounds, item.id, item);
      add(byAssembly, assemblyBounds, assemblyId, item);
      add(byMark, markBounds, mark, item);
      return item;
    });
    delete group.source;
  }
  return { groups, box, byElement, byAssembly, byMark, elementBounds, assemblyBounds, markBounds,
    elementIds: [...byElement.keys()] };
}

function sameSet(first, second) {
  return first.size === second.size && [...first].every(item => second.has(item));
}

export function createIfcRenderState(data) {
  const resources = new Set(data.groups.map(group => group.geometry));
  const material = new THREE.MeshLambertMaterial({ side: THREE.DoubleSide,
    polygonOffset: true, polygonOffsetFactor: 1, polygonOffsetUnits: 1 });
  const lineMaterial = new THREE.LineBasicMaterial({ color: selectionColor, depthWrite: false });
  resources.add(material);
  resources.add(lineMaterial);
  const selectionLines = new THREE.Group();
  const selectionEdges = new Map();
  const color = new THREE.Color();
  const batches = data.groups.map(group => {
    const draw = new THREE.InstancedMesh(group.geometry, material, group.items.length);
    draw.instanceMatrix.setUsage(THREE.DynamicDrawUsage);
    group.items.forEach((item, slot) => {
      draw.setMatrixAt(slot, item.matrix);
      draw.setColorAt(slot, color.setHex(modelColor));
    });
    draw.instanceColor.setUsage(THREE.DynamicDrawUsage);
    draw.computeBoundingSphere();
    draw.userData.items = group.items;
    group.draw = draw;
    resources.add(draw);
    return draw;
  });
  let previous;
  let selectedItems = new Set();
  let hiddenSnapshot = new Set();
  let disposed = false;
  function update(stage, progress, focused, selected, filter, hiddenIds = new Set()) {
    const palette = !!stages[stage];
    const selectedList = !selected ? []
      : selected.elementOnly || selected.id && !selected.assemblyId ? data.byElement.get(selected.id)
        : selected.assemblyId ? data.byAssembly.get(selected.assemblyId) : data.byMark.get(selected.mark);
    const nextSelected = new Set(selectedList || []);
    const selectionChanged = !sameSet(selectedItems, nextSelected);
    const hiddenChanged = !sameSet(hiddenSnapshot, hiddenIds);
    const focus = focused || null;
    const stateFilter = filter ?? null;
    const appearanceChanged = !previous || previous.stage !== stage || previous.progress !== progress;
    const visibilityChanged = !previous || previous.focus !== focus || previous.filter !== stateFilter
      || hiddenChanged || stateFilter != null && previous.progress !== progress;
    const dirtyColors = new Set();
    if (appearanceChanged) {
      for (const group of data.groups) for (const item of group.items) {
        const shade = palette ? statusAppearance(stage, progress?.byMark.get(item.mark)).color
          : nextSelected.has(item) ? selectionColor : modelColor;
        if (item.color !== shade) { item.color = shade; dirtyColors.add(item); }
      }
    } else if (selectionChanged && !palette) {
      for (const item of new Set([...selectedItems, ...nextSelected])) {
        const shade = nextSelected.has(item) ? selectionColor : modelColor;
        if (item.color !== shade) { item.color = shade; dirtyColors.add(item); }
      }
    }
    if (visibilityChanged) {
      for (const group of data.groups) {
        let changed = false;
        for (const item of group.items) {
          const visible = !hiddenIds.has(item.id) && (!focus || item.mark === focus)
            && (stateFilter == null || (progress?.byMark.get(item.mark)?.state ?? 'unknown') === stateFilter);
          if (item.visible !== visible) { item.visible = visible; changed = true; }
        }
        if (!changed) continue;
        const visibleItems = [];
        for (const item of group.items) {
          item.slot = item.visible ? visibleItems.length : -1;
          if (!item.visible) continue;
          visibleItems.push(item);
          group.draw.setMatrixAt(item.slot, item.matrix);
          dirtyColors.add(item);
        }
        group.draw.userData.items = visibleItems;
        group.draw.count = visibleItems.length;
        group.draw.visible = visibleItems.length > 0;
        if (visibleItems.length) {
          group.draw.instanceMatrix.addUpdateRange(0, visibleItems.length * 16);
          group.draw.instanceMatrix.needsUpdate = true;
        }
      }
    }
    const colorBatches = new Set();
    for (const item of dirtyColors) {
      if (!item.visible) continue;
      item.group.draw.setColorAt(item.slot, color.setHex(item.color));
      item.group.draw.instanceColor.addUpdateRange(item.slot * 3, 3);
      colorBatches.add(item.group.draw);
    }
    for (const draw of colorBatches) draw.instanceColor.needsUpdate = true;
    if (selectionChanged || visibilityChanged || !previous || previous.palette !== palette) {
      selectionLines.clear();
      if (palette) for (const item of nextSelected) {
        if (!item.visible) continue;
        const geometry = item.group.geometry;
        if (!selectionEdges.has(geometry)) {
          const edges = new THREE.EdgesGeometry(geometry, 30);
          selectionEdges.set(geometry, edges);
          resources.add(edges);
        }
        const lines = new THREE.LineSegments(selectionEdges.get(geometry), lineMaterial);
        lines.matrixAutoUpdate = false;
        lines.matrix.copy(item.matrix);
        lines.renderOrder = 1;
        selectionLines.add(lines);
      }
    }
    selectedItems = nextSelected;
    if (hiddenChanged) hiddenSnapshot = new Set(hiddenIds);
    previous = { stage, progress, focus, filter: stateFilter, palette };
  }
  return { batches, selectionLines, update, dispose() {
    if (disposed) return;
    disposed = true;
    selectionLines.clear();
    for (const resource of resources) resource.dispose();
  } };
}
