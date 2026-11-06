import { l as i } from "../shared/runtime.js";
function o(t) {
  return i({ url: "/api/system/drill-hole-config/list", method: "get", params: t });
}
function s() {
  return i({ url: "/api/mes/building/process/machine-part-process-list", method: "get", params: { processType: 8 } });
}
function r(t) {
  return i({ url: "/api/config/structure-steel/classification", method: "get", params: t });
}
function l() {
  return i({ url: "/api/system/statistics-config/statistics-mode-config/detail", method: "get" });
}
function n(t) {
  return i({ url: `/api/system/drill-hole-config/detail/${t}`, method: "get" });
}
function a(t) {
  return i({ url: "/api/system/drill-hole-config/batch-save", method: "post", data: t });
}
function p(t) {
  return i({ url: "/api/system/drill-hole-config", method: "post", data: t });
}
function c(t) {
  return i({ url: "/api/system/drill-hole-config", method: "put", data: t });
}
function u(t) {
  return i({ url: "/api/system/drill-hole-config/batch-delete", method: "delete", data: t });
}
export {
  s as a,
  r as b,
  n as c,
  p as d,
  c as e,
  o as f,
  l as g,
  u as h,
  a as p
};
