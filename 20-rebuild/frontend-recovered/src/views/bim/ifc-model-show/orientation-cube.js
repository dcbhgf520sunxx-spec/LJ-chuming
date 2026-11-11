import * as THREE from 'three';
import { RoundedBoxGeometry } from 'three/addons/geometries/RoundedBoxGeometry.js';
import { cubeFaces, cubeFaceOrder, cubeHitDirection } from './navigation.js';

export function createOrientationCube(host, onView) {
  const renderer = new THREE.WebGLRenderer({ alpha: true, antialias: true });
  renderer.setPixelRatio(Math.min(devicePixelRatio * 2, 3));
  renderer.setClearColor(0x000000, 0);
  renderer.toneMapping = THREE.ACESFilmicToneMapping;
  renderer.toneMappingExposure = 1;
  const canvas = renderer.domElement;
  canvas.setAttribute('role', 'img');
  canvas.setAttribute('aria-label', '模型方向立方体');
  canvas.title = '点击面、边或角切换方向，也可使用下方视角菜单';
  host.append(canvas);

  const scene = new THREE.Scene();
  const camera = new THREE.PerspectiveCamera(38, 1, 0.1, 20);
  scene.add(new THREE.AmbientLight(0xffffff, 1.2));
  scene.add(new THREE.HemisphereLight(0xffffff, 0x8b9fb7, 1.4));
  const keyLight = new THREE.DirectionalLight(0xffffff, 3.6);
  keyLight.position.set(-3, 5, 4);
  scene.add(keyLight);
  const fillLight = new THREE.DirectionalLight(0xb9d8ff, 0.45);
  fillLight.position.set(4, 1, -3);
  scene.add(fillLight);

  const materials = cubeFaceOrder.map(face => {
    const label = document.createElement('canvas');
    label.width = label.height = 256;
    const context = label.getContext('2d');
    context.fillStyle = '#b6cce3';
    context.fillRect(0, 0, 256, 256);
    context.fillStyle = '#233b58';
    context.font = '500 82px "PingFang SC", "Microsoft YaHei", sans-serif';
    context.textAlign = 'center';
    context.textBaseline = 'middle';
    context.fillText(cubeFaces[face].label, 128, 132);
    const texture = new THREE.CanvasTexture(label);
    texture.colorSpace = THREE.SRGBColorSpace;
    texture.anisotropy = Math.min(4, renderer.capabilities.getMaxAnisotropy());
    return new THREE.MeshPhysicalMaterial({ map: texture, roughness: 0.4, metalness: 0.08,
      clearcoat: 0.35, clearcoatRoughness: 0.25 });
  });
  const geometry = new RoundedBoxGeometry(1.25, 1.25, 1.25, 4, 0.065);
  const cube = new THREE.Mesh(geometry, materials);
  scene.add(cube);

  const quaternion = new THREE.Quaternion();
  const ray = new THREE.Raycaster();
  const pointer = new THREE.Vector2();
  let hovered = -1;
  let start;
  const render = () => renderer.render(scene, camera);
  function highlight(index) {
    if (hovered === index) return;
    hovered = index;
    materials.forEach((material, i) => material.emissive.setHex(i === index ? 0x102b49 : 0));
    canvas.style.cursor = index < 0 ? 'default' : 'pointer';
    render();
  }
  function hit(event) {
    const rect = canvas.getBoundingClientRect();
    pointer.set((event.clientX - rect.left) / rect.width * 2 - 1,
      1 - (event.clientY - rect.top) / rect.height * 2);
    ray.setFromCamera(pointer, camera);
    return ray.intersectObject(cube, false)[0];
  }
  canvas.addEventListener('pointermove', event => highlight(hit(event)?.face.materialIndex ?? -1));
  canvas.addEventListener('pointerleave', () => { start = undefined; highlight(-1); });
  canvas.addEventListener('pointerdown', event => { start = [event.clientX, event.clientY]; });
  canvas.addEventListener('pointerup', event => {
    if (!start || Math.hypot(event.clientX - start[0], event.clientY - start[1]) > 4) return;
    start = undefined;
    const picked = hit(event);
    if (picked) onView(cubeHitDirection(picked.face.materialIndex, picked.uv));
  });

  const size = new ResizeObserver(() => {
    const width = Math.max(1, host.clientWidth);
    const height = Math.max(1, host.clientHeight);
    renderer.setSize(width, height);
    camera.aspect = width / height;
    camera.updateProjectionMatrix();
    render();
  });
  size.observe(host);
  return {
    update(value) {
      quaternion.fromArray(value);
      camera.quaternion.copy(quaternion);
      camera.position.set(0, 0, 3.5).applyQuaternion(quaternion);
      camera.updateMatrixWorld();
      highlight(-1);
      render();
    },
    dispose() {
      size.disconnect();
      geometry.dispose();
      for (const material of materials) { material.map.dispose(); material.dispose(); }
      renderer.dispose();
      renderer.forceContextLoss();
      canvas.remove();
    },
  };
}
