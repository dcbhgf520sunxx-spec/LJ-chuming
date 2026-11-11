import { createRequire } from 'node:module';
import { readFile, writeFile } from 'node:fs/promises';

const require = createRequire(import.meta.url);
const { IfcAPI } = require('web-ifc');
const [source, missingFile, outputFile] = process.argv.slice(2);
const missing = JSON.parse(await readFile(missingFile, 'utf8'));
const api = new IfcAPI();
await api.Init();
const model = api.OpenModel(await readFile(source), { COORDINATE_TO_ORIGIN: false });
if (model < 0) throw new Error('补充解析器无法打开 IFC');
try {
  const result = [];
  for (const item of missing) {
    const flat = api.GetFlatMesh(model, item.step);
    const positions = [];
    const indices = [];
    for (let i = 0; i < flat.geometries.size(); i += 1) {
      const placed = flat.geometries.get(i);
      const geometry = api.GetGeometry(model, placed.geometryExpressID);
      try {
        const vertices = api.GetVertexArray(geometry.GetVertexData(), geometry.GetVertexDataSize());
        const triangles = api.GetIndexArray(geometry.GetIndexData(), geometry.GetIndexDataSize());
        const matrix = placed.flatTransformation;
        const offset = positions.length / 3;
        for (let j = 0; j < vertices.length; j += 6) {
          const [x, y, z] = vertices.subarray(j, j + 3);
          positions.push(
            matrix[0] * x + matrix[4] * y + matrix[8] * z + matrix[12],
            matrix[1] * x + matrix[5] * y + matrix[9] * z + matrix[13],
            matrix[2] * x + matrix[6] * y + matrix[10] * z + matrix[14],
          );
        }
        for (const vertex of triangles) indices.push(vertex + offset);
      } finally {
        geometry.delete();
      }
    }
    if (!positions.length || !indices.length) throw new Error('补充解析仍缺少几何 ' + item.id);
    const min = [Infinity, Infinity, Infinity];
    const max = [-Infinity, -Infinity, -Infinity];
    positions.forEach((value, i) => {
      const axis = i % 3;
      min[axis] = Math.min(min[axis], value);
      max[axis] = Math.max(max[axis], value);
    });
    if ([...min, ...max].some((value, i) => Math.abs(value - item.bounds.flat()[i]) > 0.00002)) {
      throw new Error('补充几何坐标或尺寸不一致 ' + item.id);
    }
    result.push({ id: item.id, positions, indices });
  }
  await writeFile(outputFile, JSON.stringify(result));
} finally {
  api.CloseModel(model);
}
