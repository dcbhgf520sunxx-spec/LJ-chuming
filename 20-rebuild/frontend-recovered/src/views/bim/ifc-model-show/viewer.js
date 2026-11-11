import * as THREE from 'three';
import { GLTFLoader } from 'three/addons/loaders/GLTFLoader.js';
import { OrbitControls } from 'three/addons/controls/OrbitControls.js';
import { MeshoptDecoder } from 'meshoptimizer/decoder';
import { stages, selectionColor, isSelectedPart, statusAppearance } from './progress.js';
import { focusDistance, zoomLimits } from './navigation.js';

const modelColor = 0x9ba9b9;

export async function createIfcViewer(container, buffer, index, signal, onSelect, onCameraChange) {
  const loader = new GLTFLoader().setMeshoptDecoder(MeshoptDecoder);
  const { scene: model } = await loader.parseAsync(buffer, '');
  const resources = new Set();
  function releaseModel() {
    for (const resource of resources) resource.dispose();
  }
  const fallbackMaterial = new THREE.MeshLambertMaterial({ color: modelColor, side: THREE.DoubleSide });
  resources.add(fallbackMaterial);
  for (const item of index.extraMeshes || []) {
    const geometry = new THREE.BufferGeometry();
    geometry.setAttribute('position', new THREE.Float32BufferAttribute(item.positions, 3));
    geometry.setIndex(item.indices);
    geometry.computeVertexNormals();
    const mesh = new THREE.Mesh(geometry, fallbackMaterial);
    mesh.name = item.id;
    model.add(mesh);
  }
  model.traverse(node => {
    if (!node.isMesh) return;
    resources.add(node.geometry);
    for (const material of [node.material].flat()) {
      resources.add(material);
      for (const value of Object.values(material)) if (value?.isTexture) resources.add(value);
    }
  });
  if (signal.aborted) {
    releaseModel();
    return;
  }
  let renderer;
  try {
    renderer = new THREE.WebGLRenderer({ antialias: true });
  } catch (error) {
    releaseModel();
    throw error;
  }
  renderer.setPixelRatio(Math.min(devicePixelRatio, 1.5));
  renderer.setClearColor(0xdce6f2);
  renderer.domElement.setAttribute('aria-label', 'IFC 三维模型');
  container.append(renderer.domElement);
  const scene = new THREE.Scene();
  const camera = new THREE.PerspectiveCamera(42, 1, 0.01, 10000);
  const orbit = new OrbitControls(camera, renderer.domElement);
  scene.add(new THREE.HemisphereLight(0xffffff, 0x8b9aae, 1.8));
  const sun = new THREE.DirectionalLight(0xffffff, 1.6);
  sun.position.set(20, 40, 30);
  scene.add(sun);

  const box = new THREE.Box3().setFromObject(model);
  model.position.sub(box.getCenter(new THREE.Vector3()));
  model.updateMatrixWorld(true);
  box.setFromObject(model);
  const groups = new Map();
  const assemblies = new Map(index.assemblies.map(item => [item.id, item]));
  model.traverse(mesh => {
    if (!mesh.isMesh) return;
    let node = mesh;
    while (node && !/^[0-9a-zA-Z_$]{22}$/.test(node.name)) node = node.parent;
    const id = node?.name;
    const [assemblyId, mark] = index.parts[id] || [];
    const key = mesh.geometry.uuid + ':' + mesh.material.uuid;
    if (!groups.has(key)) groups.set(key, { geometry: mesh.geometry, items: [] });
    groups.get(key).items.push({ id, assemblyId, mark, matrix: mesh.matrixWorld.clone(), visible: true });
  });

  const batches = [];
  const displayMaterial = new THREE.MeshLambertMaterial({ side: THREE.DoubleSide,
    polygonOffset: true, polygonOffsetFactor: 1, polygonOffsetUnits: 1 });
  resources.add(displayMaterial);
  const selectionEdges = new Map();
  const selectionLines = new THREE.Group();
  const lineMaterial = new THREE.LineBasicMaterial({color: selectionColor, depthWrite: false});
  resources.add(lineMaterial);
  scene.add(selectionLines);
  for (const group of groups.values()) {
    const draw = new THREE.InstancedMesh(group.geometry, displayMaterial, group.items.length);
    group.items.forEach((item, slot) => {
      draw.setMatrixAt(slot, item.matrix);
      draw.setColorAt(slot, new THREE.Color(modelColor));
    });
    draw.computeBoundingSphere();
    draw.userData.items = group.items;
    group.draw = draw;
    resources.add(draw);
    scene.add(draw);
    batches.push(draw);
  }

  let frame = 0;
  let fitDistance = 1;
  function paint() {
    if (frame) return;
    frame = requestAnimationFrame(() => {
      frame = 0;
      renderer.render(scene, camera);
      const direction = camera.position.clone().sub(orbit.target).normalize().toArray();
      const zoom = fitDistance / Math.max(camera.position.distanceTo(orbit.target), Number.EPSILON) * 100;
      onCameraChange?.(camera.quaternion.toArray(), direction, zoom);
    });
  }
  const size = new ResizeObserver(() => {
    const width = Math.max(1, container.clientWidth);
    const height = Math.max(1, container.clientHeight);
    renderer.setSize(width, height);
    camera.aspect = width / height;
    camera.updateProjectionMatrix();
    paint();
  });
  size.observe(container);
  orbit.addEventListener('change', paint);

  function fit(bounds = box) {
    const sphere = bounds.getBoundingSphere(new THREE.Sphere());
    // Compact workspaces need extra room for the two-row command bar and dock.
    const height = container.clientHeight;
    const frameScale = container.clientWidth <= 860
      ? Math.max(1.2, height / Math.max(height - 240, height * 0.45)) : 1.2;
    let distance = sphere.radius / Math.sin(THREE.MathUtils.degToRad(camera.fov / 2))
      / Math.min(1, camera.aspect) * frameScale || 1;
    // Focusing a part must not redefine 100% or trap navigation around a tiny plate.
    if (bounds === box) fitDistance = distance;
    else distance = focusDistance(distance, fitDistance);
    orbit.minDistance = fitDistance * 100 / zoomLimits.max;
    orbit.maxDistance = fitDistance * 100 / zoomLimits.min;
    orbit.target.copy(sphere.center);
    camera.position.copy(sphere.center).addScaledVector(new THREE.Vector3(-0.85, 0.68, 1).normalize(), distance);
    camera.near = Math.max(0.001, fitDistance / 2000);
    camera.far = Math.max(100, fitDistance * 20);
    camera.updateProjectionMatrix();
    orbit.update();
    paint();
  }
  function setZoom(percent) {
    if (!Number.isFinite(percent) || percent <= 0) return;
    const value = Math.max(zoomLimits.min, Math.min(zoomLimits.max, percent));
    const direction = camera.position.clone().sub(orbit.target).normalize();
    camera.position.copy(orbit.target).addScaledVector(direction, fitDistance * 100 / value);
    orbit.update();
    paint();
  }
  const offscreen = new THREE.Matrix4().makeTranslation(0, -1000000, 0);
  const color = new THREE.Color();
  function update(stage, progress, focused, selected, filter, hiddenIds = new Set()) {
    const palette = stages[stage]?.colors;
    selectionLines.clear();
    for (const group of groups.values()) {
      group.items.forEach((item, slot) => {
        const state = progress?.byMark.get(item.mark)?.state ?? 'unknown';
        item.visible = !hiddenIds.has(item.id) && (!focused || item.mark === focused) && (filter == null || state === filter);
        group.draw.setMatrixAt(slot, item.visible ? item.matrix : offscreen);
        const highlighted = isSelectedPart(item, selected);
        const shade = palette ? statusAppearance(stage, progress?.byMark.get(item.mark)).color
          : highlighted ? selectionColor : modelColor;
        group.draw.setColorAt(slot, color.setHex(shade));
        if (palette && highlighted && item.visible) {
          if (!selectionEdges.has(group.geometry)) {
            const edges = new THREE.EdgesGeometry(group.geometry, 30);
            selectionEdges.set(group.geometry, edges);
            resources.add(edges);
          }
          const lines = new THREE.LineSegments(selectionEdges.get(group.geometry), lineMaterial);
          lines.matrixAutoUpdate = false;
          lines.matrix.copy(item.matrix);
          lines.renderOrder = 1;
          selectionLines.add(lines);
        }
      });
      group.draw.instanceMatrix.needsUpdate = true;
      if (group.draw.instanceColor) group.draw.instanceColor.needsUpdate = true;
    }
    paint();
  }

  let start;
  renderer.domElement.addEventListener('pointerdown', event => { start = [event.clientX, event.clientY]; });
  renderer.domElement.addEventListener('pointerup', event => {
    if (!start || Math.hypot(event.clientX - start[0], event.clientY - start[1]) > 4) return;
    const rect = renderer.domElement.getBoundingClientRect();
    const point = new THREE.Vector2((event.clientX - rect.left) / rect.width * 2 - 1,
      1 - (event.clientY - rect.top) / rect.height * 2);
    const ray = new THREE.Raycaster();
    ray.setFromCamera(point, camera);
    const hit = ray.intersectObjects(batches, false).find(item => item.object.userData.items[item.instanceId].visible);
    const item = hit?.object.userData.items[hit.instanceId];
    onSelect(item ? { id: item.id, assemblyId: item.assemblyId, mark: item.mark,
      position: assemblies.get(item.assemblyId)?.position } : undefined);
  });

  function focus(mark) {
    const target = new THREE.Box3();
    for (const group of groups.values()) {
      group.geometry.computeBoundingBox();
      for (const item of group.items) {
        if (item.mark === mark) target.union(group.geometry.boundingBox.clone().applyMatrix4(item.matrix));
      }
    }
    if (!target.isEmpty()) fit(target);
    return !target.isEmpty();
  }
  function setView(direction) {
    const radius = camera.position.distanceTo(orbit.target);
    const vector = new THREE.Vector3(...direction).normalize();
    if (Math.abs(vector.y) > 0.999999) vector.z = 0.000001;
    camera.position.copy(orbit.target).addScaledVector(vector.normalize(), radius);
    camera.lookAt(orbit.target);
    orbit.update();
    paint();
  }
  function focusElement(id) {
    for (const group of groups.values()) {
      const item = group.items.find(value => value.id === id);
      if (!item) continue;
      group.geometry.computeBoundingBox();
      fit(group.geometry.boundingBox.clone().applyMatrix4(item.matrix));
      onSelect({ id, assemblyId: item.assemblyId, mark: item.mark,
        position: assemblies.get(item.assemblyId)?.position, elementOnly: true });
      return true;
    }
    return false;
  }
  function focusAssembly(assemblyId) {
    const bounds = new THREE.Box3();
    let first;
    for (const group of groups.values()) {
      group.geometry.computeBoundingBox();
      for (const item of group.items) {
        if (item.assemblyId !== assemblyId) continue;
        first ||= item;
        bounds.union(group.geometry.boundingBox.clone().applyMatrix4(item.matrix));
      }
    }
    if (!first) return false;
    fit(bounds);
    onSelect({ id: first.id, assemblyId, mark: first.mark, position: assemblies.get(assemblyId)?.position });
    return true;
  }
  const elementIds = [...new Set([...groups.values()].flatMap(group => group.items.map(item => item.id)))];
  renderer.setSize(container.clientWidth || 1, container.clientHeight || 1);
  camera.aspect = Math.max(1, container.clientWidth) / Math.max(1, container.clientHeight);
  fit();
  return {
    update, focus, focusElement, focusAssembly, setView, setZoom, elementIds, fit: () => fit(),
    dispose() {
      cancelAnimationFrame(frame);
      size.disconnect();
      orbit.dispose();
      releaseModel();
      renderer.dispose();
      renderer.forceContextLoss();
      renderer.domElement.remove();
    }
  };
}
