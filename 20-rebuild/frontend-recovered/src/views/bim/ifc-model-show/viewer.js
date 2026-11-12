import * as THREE from 'three';
import { GLTFLoader } from 'three/addons/loaders/GLTFLoader.js';
import { OrbitControls } from 'three/addons/controls/OrbitControls.js';
import { MeshoptDecoder } from 'meshoptimizer/decoder';
import { focusDistance, zoomLimits } from './navigation.js';
import { decodeIfcModel, createIfcRenderData, createIfcRenderState } from './render-data.js';

export async function createIfcViewer(container, buffer, index, signal, onSelect, onCameraChange) {
  if (signal.aborted) return;
  const decoded = await decodeIfcModel(buffer, data =>
    new GLTFLoader().setMeshoptDecoder(MeshoptDecoder).parseAsync(data, ''));
  if (signal.aborted) return;
  const data = createIfcRenderData(decoded, index);
  const renderState = createIfcRenderState(data);
  const releaseModel = () => renderState.dispose();
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

  const box = data.box;
  const assemblies = new Map(index.assemblies.map(item => [item.id, item]));
  const { batches, selectionLines } = renderState;
  scene.add(selectionLines);
  for (const draw of batches) scene.add(draw);

  let frame = 0;
  let fitDistance = 1;
  let disposed = false;
  function paint() {
    if (frame || disposed) return;
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
  function update(stage, progress, focused, selected, filter, hiddenIds = new Set()) {
    renderState.update(stage, progress, focused, selected, filter, hiddenIds);
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
    const bounds = data.markBounds.get(mark);
    if (bounds && !bounds.isEmpty()) fit(bounds);
    return !!bounds && !bounds.isEmpty();
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
    const item = data.byElement.get(id)?.[0];
    if (!item) return false;
    fit(data.elementBounds.get(id));
    onSelect({ id, assemblyId: item.assemblyId, mark: item.mark,
      position: assemblies.get(item.assemblyId)?.position, elementOnly: true });
    return true;
  }
  function focusAssembly(assemblyId) {
    const first = data.byAssembly.get(assemblyId)?.[0];
    if (!first) return false;
    fit(data.assemblyBounds.get(assemblyId));
    onSelect({ id: first.id, assemblyId, mark: first.mark, position: assemblies.get(assemblyId)?.position });
    return true;
  }
  const elementIds = data.elementIds;
  renderer.setSize(container.clientWidth || 1, container.clientHeight || 1);
  camera.aspect = Math.max(1, container.clientWidth) / Math.max(1, container.clientHeight);
  fit();
  return {
    update, focus, focusElement, focusAssembly, setView, setZoom, elementIds, fit: () => fit(),
    dispose() {
      if (disposed) return;
      disposed = true;
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
