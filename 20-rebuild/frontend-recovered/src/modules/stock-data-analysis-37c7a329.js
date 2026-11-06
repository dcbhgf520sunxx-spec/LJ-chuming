import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ url: "/api/pc/operational/inventory/cost", method: "get", params: t });
}
function a(t) {
  return e({ url: "api/pc/operational/inventory/inventory/cost", method: "get", params: t, cancelKey: false });
}
function i(t) {
  return e({ url: "/api/pc/operational/inventory/month/cost", method: "get", params: t });
}
function r(t) {
  return e({ url: "/api/pc/operational/inventory/month/cost/detai", method: "get", params: t });
}
function l(t) {
  return e({ url: "/api/pc/operational/analysis/mainMaterialOutInMete", method: "get", params: t, cancelKey: false });
}
function s(t) {
  return e({ url: "/api/pc/operational/analysis/auxiliaryMaterialOutInMete", method: "get", params: t, cancelKey: false });
}
function u(t) {
  return e({ url: "/api/pc/operational/analysis/oneLevel", method: "get", params: t });
}
function c(t) {
  return e({ url: "/api/pc/operational/analysis/materialOutInCost", method: "get", params: t, cancelKey: false });
}
function p(t) {
  return e({ url: "/api/pc/operational/analysis/surplusMaterial", method: "get", params: t, cancelKey: false });
}
function d(t) {
  return e({ url: "/api/pc/operational/analysis/materialOutInCost", method: "get", params: t });
}
function m(t) {
  return e({ url: "/api/pc/operational/inventory/download/inventory/cost", method: "get", responseType: "blob", params: t });
}
function y(t) {
  return e({ url: "/api/pc/operational/inventory/download/monthCost/detail", method: "get", responseType: "blob", params: t });
}
function g(t) {
  return e({ url: "/api/pc/operational/inventory/download/outInCost", method: "get", responseType: "blob", params: t });
}
function f(t) {
  return e({ url: "/api/pc/operational/analysis/materialOutInCost/download", method: "get", responseType: "blob", timeout: 6e6, params: t });
}
function h(t) {
  return e({ url: "/api/pc/operational/analysis/surplusMaterial/download", method: "get", responseType: "blob", timeout: 6e6, params: t });
}
export {
  u as a,
  o as b,
  a as c,
  g as d,
  m as e,
  i as f,
  s as g,
  l as h,
  c as i,
  p as j,
  r as k,
  y as l,
  d as m,
  f as n,
  h as o
};
