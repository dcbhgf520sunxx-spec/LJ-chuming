export const cubeFaces = {
  front: { label: '前', direction: [0, 0, 1], right: [1, 0, 0], up: [0, 1, 0] },
  back: { label: '后', direction: [0, 0, -1], right: [-1, 0, 0], up: [0, 1, 0] },
  left: { label: '左', direction: [-1, 0, 0], right: [0, 0, 1], up: [0, 1, 0] },
  right: { label: '右', direction: [1, 0, 0], right: [0, 0, -1], up: [0, 1, 0] },
  top: { label: '顶', direction: [0, 1, 0], right: [1, 0, 0], up: [0, 0, -1] },
  bottom: { label: '底', direction: [0, -1, 0], right: [1, 0, 0], up: [0, 0, 1] },
};

export const viewDirections = {
  front: { label: '前视图', direction: [0, 0, 1] },
  back: { label: '后视图', direction: [0, 0, -1] },
  left: { label: '左视图', direction: [-1, 0, 0] },
  right: { label: '右视图', direction: [1, 0, 0] },
  top: { label: '顶视图', direction: [0, 1, 0] },
  bottom: { label: '底视图', direction: [0, -1, 0] },
  isometric: { label: '等轴测', direction: [-1, 1, 1] },
};

// Three.js box material order: +X, -X, +Y, -Y, +Z, -Z.
export const cubeFaceOrder = ['right', 'left', 'top', 'bottom', 'front', 'back'];

export function cubeHitDirection(materialIndex, uv) {
  return cubeDirection(cubeFaceOrder[materialIndex], uv.x, 1 - uv.y);
}

export const zoomLimits = { min: 10, max: 10000 };

export function focusDistance(targetFitDistance, modelFitDistance) {
  return Math.max(modelFitDistance * 100 / zoomLimits.max,
    Math.min(modelFitDistance, targetFitDistance * 1.8));
}

export function zoomFromSlider(value) {
  return zoomLimits.min * (zoomLimits.max / zoomLimits.min) ** (Math.max(0, Math.min(100, value)) / 100);
}

export function zoomToSlider(value) {
  return Math.max(0, Math.min(100, 100 * Math.log(value / zoomLimits.min) / Math.log(zoomLimits.max / zoomLimits.min)));
}

export function cubeDirection(face, x, y) {
  const axes = cubeFaces[face];
  const horizontal = x < 0.23 ? -1 : x > 0.77 ? 1 : 0;
  const vertical = y < 0.23 ? 1 : y > 0.77 ? -1 : 0;
  return axes.direction.map((value, index) => value + axes.right[index] * horizontal + axes.up[index] * vertical);
}

export function componentTree(index) {
  const byMark = new Map();
  const members = new Map();
  for (const [id, [assemblyId]] of Object.entries(index.parts)) {
    if (!members.has(assemblyId)) members.set(assemblyId, []);
    members.get(assemblyId).push(id);
  }
  for (const assembly of index.assemblies) {
    if (!byMark.has(assembly.mark)) byMark.set(assembly.mark, []);
    const ids = members.get(assembly.id) || [];
    byMark.get(assembly.mark).push({
      key: 'assembly:' + assembly.id, assemblyId: assembly.id,
      kind: 'assembly',
      label: assembly.mark + ' · ' + (assembly.position || assembly.id),
      mark: assembly.mark,
      ids,
      children: ids.map(id => ({ key: 'part:' + id, kind: 'part', label: id, ids: [id], mark: assembly.mark, children: [] })),
    });
  }
  const roots = [...byMark].sort(([a], [b]) => a.localeCompare(b, 'zh-CN', { numeric: true })).map(([mark, children]) => ({
    key: 'mark:' + mark, kind: 'mark', label: mark + '（' + children.length + '件）', mark,
    ids: children.flatMap(item => item.ids), children,
  }));
  if (index.looseElements?.length) roots.push({
    key: 'loose', kind: 'loose', label: '独立元件（' + index.looseElements.length + '个）',
    ids: index.looseElements,
    children: index.looseElements.map(id => ({ key: 'part:' + id, kind: 'part', label: id, ids: [id], children: [] })),
  });
  return roots;
}
