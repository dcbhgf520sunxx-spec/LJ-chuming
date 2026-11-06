import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ module: "plan", url: "artifact-processFile", method: "get", params: t });
}
function u(t) {
  return e({ module: "plan", url: "artifact-processFile", method: "post", data: t });
}
function n(t) {
  return e({ module: "plan", url: "artifact-processFile", method: "put", data: t });
}
function l(t) {
  return e({ module: "plan", url: "artifact-processFile/artifactClass-snQuantity", method: "get", params: t });
}
function s(t) {
  return e({ module: "plan", url: "artifact-processFile/artifactSnList", method: "get", params: t });
}
function o(t) {
  return e({ module: "plan", url: "artifact-processFile/bind", method: "post", data: t });
}
function c(t) {
  return e({ module: "plan", url: "artifact-processFile/listBind", method: "get", params: t });
}
function d(t) {
  return e({ module: "plan", url: "artifact-processFile/unbind", method: "put", data: t });
}
function p(t) {
  return e({ module: "plan", url: "artifact-processFile/unbindAll/" + t, method: "put" });
}
function f(t = { mesProductEnum: 1 }) {
  return e({ url: "/api/system/structure-classification/listAll", method: "get", params: t });
}
function i(t) {
  return e({ url: "/api/plan/artifact-processFile", method: "delete", data: [t] });
}
const m = { get: r, del: i, add: u, edit: n };
export {
  d as a,
  c as b,
  m as c,
  l as d,
  o as e,
  s as g,
  f as s,
  p as u
};
