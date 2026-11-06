import { l as e } from "../shared/runtime.js";
function o() {
  return e({ url: "/api/mes/building/productProcess/assemble-type-process-select", method: "get" });
}
function n(t) {
  return e({ url: "/api/system/group-welding-config/page", method: "get", params: t });
}
function r() {
  return e({ url: "/api/system/statistics-config/statistics-mode-config/detail", method: "get" });
}
function s(t) {
  return e({ url: `/api/system/group-welding-config/detail/${t}`, method: "get" });
}
function g(t) {
  return e({ url: "/api/system/group-welding-config/batch-save", method: "post", data: t });
}
function u(t) {
  return e({ url: "/api/system/group-welding-config", method: "post", data: t });
}
function p(t) {
  return e({ url: "/api/system/group-welding-config", method: "put", data: t });
}
function l(t) {
  return e({ url: "/api/system/group-welding-config/batch-delete", method: "delete", data: t });
}
function d(t) {
  return e({ url: "api/system/project-group-welding-config/page", method: "get", params: t });
}
function a(t) {
  return e({ url: "api/system/project-group-welding-config/batch-delete", method: "delete", data: t });
}
function c(t) {
  return e({ url: "api/system/project-group-welding-config", method: "post", data: t });
}
function f(t) {
  return e({ url: "api/system/project-group-welding-config", method: "put", data: t });
}
function m(t) {
  return e({ url: "/api/system/project-group-welding-config/batch-save", method: "post", data: t });
}
function h(t) {
  return e({ url: `api/system/project-group-welding-config/detail/${t}`, method: "get" });
}
export {
  r as a,
  m as b,
  h as c,
  s as d,
  c as e,
  u as f,
  o as g,
  f as h,
  p as i,
  d as j,
  n as k,
  a as l,
  l as m,
  g as p
};
