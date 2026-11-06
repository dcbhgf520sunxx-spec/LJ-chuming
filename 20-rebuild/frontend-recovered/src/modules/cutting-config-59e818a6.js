import { l as e } from "../shared/runtime.js";
function s(t) {
  return e({ url: "/api/system/laying-off-config/page", method: "get", params: t });
}
function o() {
  return e({ url: "/api/mes/building/process/machine-part-process-list", method: "get", params: { processType: 4 } });
}
function n(t) {
  return e({ url: "/api/mes/building/productProcess/machine-part-type-process-select", method: "get", params: t });
}
function r(t) {
  return e({ url: `/api/system/laying-off-config/detail/${t}`, method: "get" });
}
function a(t) {
  return e({ url: "/api/config/structure-steel/classification", method: "get", params: t });
}
function f() {
  return e({ url: "/api/system/statistics-config/statistics-mode-config/detail", method: "get" });
}
function p(t) {
  return e({ url: `/api/system/laying-off-config/detail/${t}`, method: "get" });
}
function c(t) {
  return e({ url: "/api/system/laying-off-config/batch-save", method: "post", data: t });
}
function g(t) {
  return e({ url: "/api/system/laying-off-config", method: "post", data: t });
}
function u(t) {
  return e({ url: "/api/system/laying-off-config", method: "put", data: t });
}
function l(t) {
  return e({ url: "/api/system/laying-off-config/batch-delete", method: "delete", data: t });
}
export {
  f as a,
  o as b,
  p as c,
  g as d,
  u as e,
  r as f,
  a as g,
  n as h,
  s as i,
  l as j,
  c as p
};
