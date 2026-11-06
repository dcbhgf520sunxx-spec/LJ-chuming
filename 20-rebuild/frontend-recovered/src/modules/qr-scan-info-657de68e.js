import { s as e } from "./externalRequest-4308f5b0.js";
function n(t, { id: r, factoryId: a, taskId: i }) {
  return e({ url: `${t}/api/plan/qr/info/artifact/${r}`, method: "get", params: { id: r, factoryId: a, taskId: i } });
}
function o(t, { id: r, factoryId: a, taskId: i }) {
  return e({ url: `${t}/api/plan/qr/info/v2/enclosure/${r}`, method: "get", params: { id: r, factoryId: a, taskId: i } });
}
function u(t, { id: r, taskId: a }) {
  return e({ url: `${t}/api/qr/info/mes/auxiliaryMaterial`, method: "get", params: { id: r, taskId: a } });
}
function f(t, { taskId: r, number: a }) {
  return e({ url: `${t}/api/plan/qr/info/product/task/v2`, method: "get", params: { taskId: r, number: a } });
}
function l(t, r) {
  return e({ url: `${t}/api/system/product-traceability-config/getByProjectId/public`, method: "get", params: r });
}
function s(t) {
  return e({ url: `${t}/api/system/product-traceability-config/getDefault`, method: "get" });
}
export {
  f as a,
  l as b,
  s as c,
  o as d,
  u as e,
  n as f
};
