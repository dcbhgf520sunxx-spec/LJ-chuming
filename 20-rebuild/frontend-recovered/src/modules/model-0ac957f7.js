import { l as a } from "../shared/runtime.js";
function i(t) {
  return a({ url: "api/model/3DModel/upload", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: t });
}
function n({ monomerId: t }) {
  return a({ url: "api/model/3DModel/monomer", method: "get", params: { monomerId: t } });
}
function u({ monomerId: t }) {
  return a({ url: "api/model/3DModel/area", method: "get", params: { monomerId: t } });
}
function m({ monomerId: t, areaId: e }) {
  return a({ url: "api/model/3DModel", method: "delete", params: { monomerId: t, areaId: e } });
}
function l({ monomerId: t, areaIds: e }) {
  return a({ url: "api/model/3DModel/model/integration", method: "post", params: { monomerId: t }, data: e });
}
function d({ monomerId: t }) {
  return a({ url: "api/model/3DModel/remove/integration", method: "delete", params: { monomerId: t } });
}
function s(t) {
  return a({ url: "api/model/configure", method: "put", data: t });
}
function g(t) {
  return a({ url: "api/model/3DModel/integrate", method: "get", params: { projectId: t } });
}
function p(t, e) {
  return a({ url: "api/model/3DModel/translate", method: "get", params: { monomerId: t, areaId: e } });
}
function c({ fileId: t, menuBar: e }) {
  return a({ url: "api/model/3DModel/artifact/status", method: "get", timeout: 6e5, params: { fileId: t, menuBar: e } });
}
function f({ projectId: t, menuBar: e }) {
  return a({ url: "/api/model/3DModel/artifact/integrate/status", method: "get", timeout: 6e5, params: { projectId: t, menuBar: e } });
}
function h(t) {
  return a({ url: "/api/model/3DModel/integrate/monomer", method: "get", timeout: 6e5, params: { projectId: t } });
}
function M(t) {
  return a({ url: "/api/model/3DModel/project/tree", method: "get", timeout: 6e5, params: { fileId: t } });
}
function D({ fileId: t, elementId: e, menuBar: o }) {
  return a({ url: "/api/model/3DModel/artifact", method: "get", timeout: 6e5, params: { fileId: t, elementId: e, menuBar: o } });
}
function I({ projectId: t, elementId: e, menuBar: o }) {
  return a({ url: "/api/model/3DModel/artifact/integrate", method: "get", timeout: 6e5, params: { projectId: t, elementId: e, menuBar: o } });
}
function A({ serialNumber: t, fileId: e }) {
  return a({ url: "/api/model/3DModel/artifact/element", method: "get", timeout: 6e5, params: { serialNumber: t, fileId: e } });
}
function S({ serialNumber: t, projectId: e }) {
  return a({ url: "/api/model/3DModel/artifact/element/integrate", method: "get", timeout: 6e5, params: { serialNumber: t, projectId: e } });
}
function T({ fileId: t, menuBar: e }) {
  return a({ url: "/api/model/3DModel/artifact/production", method: "get", timeout: 6e5, params: { fileId: t, menuBar: e } });
}
function j({ projectId: t, menuBar: e }) {
  return a({ url: "/api/model/3DModel/artifact/production/integrate", method: "get", timeout: 6e5, params: { projectId: t, menuBar: e } });
}
function v({ fileId: t, status: e, menuBar: o }) {
  return a({ url: "/api/model/3DModel/status/details", method: "get", timeout: 6e5, params: { fileId: t, status: e, menuBar: o } });
}
function w({ projectId: t, status: e, menuBar: o }) {
  return a({ url: "/api/model/3DModel/status/details/integrate", method: "get", timeout: 6e5, params: { projectId: t, status: e, menuBar: o } });
}
function P({ fileId: t }) {
  return a({ url: "/api/model/3DModel/logistics", method: "get", timeout: 6e5, params: { fileId: t } });
}
function b({ projectId: t }) {
  return a({ url: "/api/model/3DModel/logistics/integrate", method: "get", timeout: 6e5, params: { projectId: t } });
}
function x({ productId: t, productType: e }) {
  return a({ url: "/api/plan/drawing/product/bim", method: "get", timeout: 6e5, params: { productId: t, productType: e } });
}
export {
  v as a,
  w as b,
  h as c,
  M as d,
  c as e,
  f,
  x as g,
  A as h,
  S as i,
  D as j,
  I as k,
  T as l,
  j as m,
  P as n,
  b as o,
  p,
  g as q,
  s as r,
  n as s,
  m as t,
  i as u,
  u as v,
  l as w,
  d as x
};
