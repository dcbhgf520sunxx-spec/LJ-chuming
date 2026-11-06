import { l as e } from "../shared/runtime.js";
function n(t) {
  return e({ module: "plan", url: "artifactMachinePart/listByCondition", method: "get", params: t });
}
function o(t) {
  return e({ module: "plan", url: "artifact/update", method: "put", data: t });
}
function l(t, a, r) {
  return e({ module: "plan", url: `artifactMachinePart/updateStatus/${t}/${a}`, method: "put", params: r });
}
function c(t) {
  return e({ module: "plan", url: "artifact/updateRemark", method: "put", data: t });
}
function i(t) {
  return e({ module: "plan", url: "artifactMachinePart/deleteArtifact", method: "delete", data: t });
}
function p(t) {
  return e({ module: "plan", url: "inventory/record/import", responseType: "blob", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: t });
}
function s(t) {
  return e({ module: "plan", url: "tech-change/import/direct", responseType: "blob", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: t });
}
function d(t) {
  return e({ module: "mes", url: "tech/change/temporary", method: "post", data: t });
}
function m(t) {
  return e({ module: "plan", url: "artifactMachinePart/export", responseType: "blob", method: "get", params: t });
}
function h(t) {
  return e({ module: "plan", url: "artifactMachinePart/template/export", responseType: "blob", method: "get", params: t });
}
function f(t) {
  return e({ module: "plan", url: "artifactMachinePart/listMachinePart", method: "get", params: t });
}
function g(t) {
  return e({ module: "plan", url: "artifactMachinePart/clear", method: "delete", params: t });
}
function y(t) {
  return e({ module: "plan", url: "tech-change", method: "post", data: t });
}
function b(t) {
  return e({ url: "/api/plan/tech-change/import", responseType: "blob", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: t });
}
function v(t) {
  return e({ url: "/api/plan/tech-change/list-artifact", method: "get", params: t });
}
function A(t) {
  return e({ url: "/api/plan/tech-change/list-artifact-detail", method: "get", params: t });
}
function T(t) {
  return e({ url: "/api/plan/tech-change", method: "post", data: t });
}
function P(t) {
  return e({ url: "/api/plan/tech-change/list-old-part", method: "get", params: t });
}
function C(t) {
  return e({ url: "/api/plan/inventory/record/status", method: "get", params: t });
}
function M(t) {
  return e({ url: "/api/plan/inventory/record/repetition", method: "get", params: t });
}
function S(t) {
  return e({ url: "/api/plan/inventory/record/repetition/check", method: "put", data: t });
}
function k(t) {
  return e({ url: "/api/system/structure-classification/welding/all", method: "get", params: t });
}
function w(t) {
  return e({ url: "/api/plan/inventory/record/repetition/machineTwo", method: "get", params: t });
}
function R(t) {
  return e({ url: "/api/system/assemble-config/welding/list-info", method: "get", params: t });
}
function x(t) {
  return e({ url: "/api/plan/inventory/record/repetition/assembleSave", method: "post", data: t });
}
function D(t) {
  return e({ url: "/api/plan/inventory/record/repetition/assembleDelete", method: "post", data: t });
}
function B(t) {
  return e({ module: "plan", url: "inventory/record/inventory/check", method: "put", data: t });
}
function L(t) {
  return e({ module: "plan", url: "inventory/record/automatic/assembleSave", method: "post", data: t });
}
function U(t) {
  return e({ url: "/api/plan/area/batch", method: "put", data: t });
}
const W = { edit: o, del: i, get: n };
export {
  x as A,
  W as a,
  l as b,
  d as c,
  f as d,
  c as e,
  m as f,
  C as g,
  s as h,
  h as i,
  g as j,
  B as k,
  p as l,
  A as m,
  y as n,
  U as o,
  v as p,
  M as q,
  k as r,
  S as s,
  b as t,
  P as u,
  T as v,
  L as w,
  w as x,
  R as y,
  D as z
};
