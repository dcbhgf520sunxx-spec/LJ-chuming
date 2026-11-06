import { l as t } from "../shared/runtime.js";
function s(e) {
  return t({ url: "/api/mes/building/productProcess/artifact-type-process-select", method: "get", params: e });
}
function n(e) {
  return t({ url: "/api/system/assembling-welding-config/page", method: "get", params: e });
}
function o() {
  return t({ url: "/api/system/statistics-config/statistics-mode-config/detail", method: "get" });
}
function l(e) {
  return t({ url: `/api/system/assembling-welding-config/detail/${e}`, method: "get" });
}
function r(e) {
  return t({ url: "/api/system/assembling-welding-config", method: "post", data: e });
}
function a(e) {
  return t({ url: "/api/system/assembling-welding-config/batch-save", method: "post", data: e });
}
function g(e) {
  return t({ url: "/api/system/assembling-welding-config", method: "post", data: e });
}
function d(e) {
  return t({ url: "/api/system/assembling-welding-config", method: "put", data: e });
}
function m(e) {
  return t({ url: `/api/system/assembling-welding-config/${e}`, method: "delete" });
}
function p(e) {
  return t({ url: "api/system/project-assembling-welding-config/page", method: "get", params: e });
}
function u(e) {
  return t({ url: `api/system/project-assembling-welding-config/${e}`, method: "delete" });
}
function c(e) {
  return t({ url: "api/system/project-assembling-welding-config", method: "put", data: e });
}
function f(e) {
  return t({ url: "api/system/project-assembling-welding-config/batch-save", method: "post", data: e });
}
function b(e) {
  return t({ url: `api/system/project-assembling-welding-config/detail/${e}`, method: "get" });
}
export {
  o as a,
  f as b,
  b as c,
  l as d,
  r as e,
  g as f,
  s as g,
  c as h,
  d as i,
  p as j,
  n as k,
  u as l,
  m,
  a as p
};
