import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ url: "/api/pc/operational/analysis/production", method: "get", params: e, cancelKey: false });
}
function n(e) {
  return t({ url: "/api/pc/operational/analysis/targetRatio", method: "get", params: e, cancelKey: false });
}
function l(e) {
  return t({ url: "/api/pc/operational/analysis/productionMonthly", method: "get", params: e, cancelKey: false });
}
function i(e) {
  return t({ url: "/api/pc/operational/analysis/productionDay", method: "get", params: e, cancelKey: false });
}
function r(e) {
  return t({ url: "/api/pc/operational/analysis/taskAccomplished", method: "get", params: e, cancelKey: false });
}
function s(e) {
  return t({ url: "/api/pc/operational/analysis/mainOutMete", method: "get", params: e, cancelKey: false });
}
function c(e) {
  return t({ url: "/api/pc/operational/analysis/avgProduction", method: "get", params: e, cancelKey: false });
}
function p(e) {
  return t({ url: "/api/pc/operational/analysis/avgYearProduction", method: "get", params: e, cancelKey: false });
}
function u(e) {
  return t({ url: "/api/pc/operational/analysis/targetProductionAnalysis", method: "get", params: e });
}
function d(e) {
  return t({ url: "/api/pc/operational/analysis/projectMete", method: "get", params: e, cancelKey: false });
}
function g(e) {
  return t({ url: "/api/pc/operational/analysis/taskAccomplishedList", method: "get", params: e });
}
function y(e) {
  return t({ url: "/api/pc/operational/analysis/mainOutMeteDetailsV2", method: "get", params: e, cancelKey: false });
}
function m(e) {
  return t({ url: "/api/pc/operational/analysis/targetProductionAnalysis/download", method: "get", responseType: "blob", timeout: 6e6, params: e });
}
function h(e) {
  return t({ url: "/api/pc/operational/analysis/projectMete/download", method: "get", responseType: "blob", timeout: 6e6, params: e });
}
function f(e) {
  return t({ url: "/api/pc/operational/analysis/taskAccomplished/download", method: "get", responseType: "blob", timeout: 6e6, params: e });
}
function M(e) {
  return t({ url: "/api/pc/operational/analysis/taskAccomplishedList/download", method: "get", responseType: "blob", timeout: 6e6, params: e });
}
function A(e) {
  return t({ url: "/api/pc/operational/produce/download/mainOutMeteDetails/download", method: "get", responseType: "blob", timeout: 6e6, params: e });
}
export {
  A as a,
  r as b,
  f as c,
  o as d,
  n as e,
  l as f,
  y as g,
  i as h,
  s as i,
  c as j,
  p as k,
  u as l,
  m,
  d as n,
  h as o,
  g as p,
  M as q
};
