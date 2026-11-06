import { l as o } from "../shared/runtime.js";
function e(t) {
  return o({ module: "contract", url: "contract/manufacturecost/manufactureCost/page", method: "get", params: t });
}
function r(t) {
  return o({ module: "contract", url: "contract/fixed-assets-depreciation/factory-building-depreciation", method: "post", data: t });
}
function c(t) {
  return o({ module: "contract", url: "contract/fixed-assets-depreciation/factory-building-depreciation", method: "put", data: t });
}
function a(t) {
  return o({ module: "contract", url: `contract/fixed-assets-depreciation/factory-building-depreciation/${t}`, method: "delete" });
}
function u(t) {
  return o({ module: "contract", url: "contract/manufacturecost/costSummary", method: "get", params: t });
}
function i(t) {
  return o({ module: "contract", url: "contract/manufacturecost/costSummaryExport", method: "get", params: t, responseType: "blob" });
}
function s(t) {
  return o({ module: "contract", url: "contract/manufacturecost/main-materials-statistics", method: "get", params: t });
}
function m(t) {
  return o({ module: "contract", url: "contract/manufacturecost/other-steel-materials-amortization", method: "get", params: t });
}
function l(t) {
  return o({ module: "contract", url: "contract/manufacturecost/auxiliary-materials-direct-cost", method: "get", params: t });
}
function d(t) {
  return o({ module: "contract", url: "contract/manufacturecost/auxiliary-materials-amortization-cost", method: "get", params: t });
}
function f(t) {
  return o({ module: "contract", url: "contract/manufacturecost/paint-cost", method: "get", params: t });
}
function g(t) {
  return o({ module: "contract", url: "contract/manufacturecost/welding-consumable-cost", method: "get", params: t });
}
function h(t) {
  return o({ module: "contract", url: "contract/manufacturecost/production-labor-cost", method: "get", params: t });
}
function p(t) {
  return o({ module: "contract", url: "contract/manufacturecost/temp-work-amortization-cost", method: "get", params: t });
}
function y(t) {
  return o({ module: "contract", url: "contract/manufacturecost/manager-amortization-cost", method: "get", params: t });
}
function C(t) {
  return o({ module: "contract", url: "contract/manufacturecost/transportationCost", method: "get", params: t });
}
function z(t) {
  return o({ module: "contract", url: "contract/manufacturecost/water-electricity-amortization", method: "get", params: t });
}
function x(t) {
  return o({ module: "contract", url: "contract/manufacturecost/gas-fee", method: "get", params: t });
}
function M(t) {
  return o({ module: "contract", url: "contract/manufacturecost/gas-direct-cost", method: "get", params: t });
}
function b(t) {
  return o({ module: "contract", url: "contract/manufacturecost/property-amortization", method: "get", params: t });
}
function A(t) {
  return o({ module: "contract", url: "contract/manufacturecost/direct-cost", method: "get", params: t });
}
function S(t) {
  return o({ module: "contract", url: "contract/manufacturecost/amortization-cost", method: "get", params: t });
}
function P(t) {
  return o({ module: "contract", url: "contract/manufacturecost/factory-depreciation", method: "get", params: t });
}
function D(t) {
  return o({ module: "contract", url: "contract/manufacturecost/equipment-depreciation", method: "get", params: t });
}
function L(t) {
  return o({ module: "contract", url: "contract/manufacturecost/testing-fee", method: "get", params: t });
}
function w(t) {
  return o({ module: "contract", url: "contract/manufacturecost/finishedProductScrapLoss", method: "get", params: t });
}
function B(t) {
  return o({ module: "contract", url: "contract/manufacturecost/repair/list", method: "get", params: t });
}
function E(t) {
  return o({ module: "contract", url: "contract/manufacturecost/reuse/list", method: "get", params: t });
}
function T(t) {
  return o({ module: "contract", url: "contract/manufacturecost/mainBusinessIncome", method: "get", params: t });
}
function F(t) {
  return o({ module: "contract", url: "contract/manufacturecost/nonMainBusinessIncome", method: "get", params: t });
}
function I(t) {
  return o({ module: "contract", url: "contract/manufacturecost/manufactureCost/total", method: "get", params: t });
}
function j(t) {
  return o({ url: "/api/contract/manufacturecost/project-list", method: "get", params: t });
}
function k(t) {
  return o({ module: "contract", url: "contract/manufacturecost/send-directly-site-material-cost", method: "get", params: t });
}
function q(t) {
  return o({ module: "contract", url: "contract/manufacturecost/send-directly-site-material-order-payment", method: "get", params: t });
}
const W = { get: e, add: r, edit: c, del: a };
export {
  i as A,
  u as B,
  W as C,
  j as D,
  I as E,
  A as a,
  D as b,
  P as c,
  w as d,
  M as e,
  x as f,
  S as g,
  T as h,
  y as i,
  B as j,
  E as k,
  d as l,
  q as m,
  k as n,
  l as o,
  f as p,
  F as q,
  p as r,
  m as s,
  s as t,
  h as u,
  b as v,
  L as w,
  C as x,
  z as y,
  g as z
};
