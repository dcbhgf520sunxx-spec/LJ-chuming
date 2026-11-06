import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "scheduling/artifact/page", method: "get", params: e, cancelKey: false });
}
function n(e) {
  return t({ module: "mes", url: "scheduling/artifact/summary", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: "scheduling/artifact/new", method: "post", data: e });
}
function m(e) {
  return t({ module: "mes", url: "scheduling/artifact/v2/record", method: "get", params: e });
}
function a(e) {
  return t({ module: "mes", url: "scheduling/artifact/record", method: "get", params: e });
}
function d(e) {
  return t({ module: "mes", url: "scheduling/artifact/v2/record/summary", method: "get", params: e });
}
function s(e) {
  return t({ module: "mes", url: "productionLine/record/lines/summary", method: "get", params: e });
}
function c(e) {
  return t({ module: "mes", url: "scheduling/artifact/v2/assemble", method: "post", data: e });
}
function i(e) {
  return t({ module: "mes", url: "scheduling/artifact/v2/record", method: "put", data: e });
}
function l(e) {
  return t({ module: "mes", url: "scheduling/artifact/record", method: "delete", data: e });
}
function g(e) {
  return t({ module: "mes", url: "scheduling/area/tree/list", method: "get", params: e });
}
function h(e) {
  return t({ module: "mes", url: "scheduling/area/tree/time", method: "get", params: e });
}
function f(e) {
  return t({ module: "mes", url: "scheduling/artifact/record/type/list", method: "get", params: e });
}
function p(e) {
  return t({ module: "mes", url: "scheduling/artifact/record/name/list", method: "get", params: e });
}
function y(e) {
  return t({ module: "mes", url: "scheduling/artifact/record/line/type/list", method: "get", params: e });
}
function T(e) {
  return t({ module: "mes", url: "scheduling/artifact/type/list", method: "get", params: e });
}
function A(e) {
  return t({ module: "mes", url: "scheduling/artifact/name/list", method: "get", params: e });
}
function S(e) {
  return t({ module: "mes", url: "groups/scheduling/tree", method: "get", params: e });
}
function v(e) {
  return t({ module: "mes", url: "productionLine/scheduling/tree", method: "get", params: e, cancelKey: false });
}
function L(e) {
  return t({ module: "mes", url: "scheduling/artifact/v2/record/count", method: "get", params: e });
}
function R(e) {
  return t({ module: "mes", url: "scheduling/area/tree/workshop", method: "get", params: e });
}
function k(e) {
  return t({ module: "mes", url: "scheduling/area/tree/summary", method: "get", params: e });
}
function b(e) {
  return t({ module: "mes", url: "report/product/realtime/info", method: "get", params: e });
}
function N(e) {
  return t({ module: "mes", url: "task/assemble/ProdLineSummary", method: "get", params: e });
}
function w(e) {
  return t({ module: "mes", url: "scheduling/artifact/scheduling/quantity", method: "get", params: e });
}
const P = { get: r };
export {
  n as a,
  L as b,
  P as c,
  b as d,
  v as e,
  T as f,
  S as g,
  A as h,
  s as i,
  w as j,
  a as k,
  m as l,
  f as m,
  p as n,
  y as o,
  R as p,
  h as q,
  d as r,
  o as s,
  g as t,
  k as u,
  i as v,
  l as w,
  N as x,
  c as y
};
