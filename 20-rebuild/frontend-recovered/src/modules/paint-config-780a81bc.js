import { l as e } from "../shared/runtime.js";
function n(t) {
  return e({ module: "mes", url: "craft/paint-config/page", method: "get", params: t });
}
function o(t) {
  return e({ module: "mes", url: "craft/paint-config", method: "post", data: t });
}
function r(t) {
  return e({ module: "mes", url: "craft/paint-config", method: "put", data: t });
}
function a(t) {
  return e({ module: "mes", url: "craft/paint-config", method: "delete", params: t });
}
function u(t) {
  return e({ module: "config", url: "base-config/unit/all", method: "get", params: t });
}
function l(t) {
  return e({ module: "mes", url: "craft/paint-config/template-download", responseType: "blob", method: "get", params: t });
}
function m(t) {
  return e({ module: "mes", url: "craft/paint-config/import", responseType: "blob", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: t });
}
function c(t) {
  return e({ module: "mes", url: "craft/paint-config/clear", method: "delete", params: t });
}
const d = { get: n, add: o, del: a, edit: r };
export {
  l as a,
  c as b,
  d as c,
  a as d,
  u as g,
  m as p
};
