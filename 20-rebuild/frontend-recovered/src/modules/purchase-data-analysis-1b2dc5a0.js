import { l as a } from "../shared/runtime.js";
function t(e) {
  return a({ url: "/api/pc/operational/purchase/purchaseSummary", method: "get", params: e });
}
function o(e) {
  return a({ url: "/api/pc/operational/purchase/getGroupDetail/year", method: "get", params: e });
}
function u(e) {
  return a({ url: "/api/pc/operational/purchase/getGroupMonth", method: "get", params: e });
}
function n(e) {
  return a({ url: "/api/pc/operational/purchase/getGroupDetail/month", method: "get", params: e });
}
function p(e) {
  return a({ url: "/api/pc/operational/purchase/getInboundMaterial", method: "get", params: e, cancelKey: false });
}
function i(e) {
  return a({ url: "/api/config/classification/getPurchaseClassification", method: "get", params: e });
}
function l(e) {
  return a({ url: "/api/pc/operational/purchase/getInboundPriceSummary", method: "get", params: e });
}
function c(e) {
  return a({ url: "/api/pc/operational/purchase/supplierSummary", method: "get", params: e });
}
function s(e) {
  return a({ url: "/api/pc/operational/purchase/supplierGroupDetail", method: "get", params: e });
}
function h(e) {
  return a({ url: "/api/pc/operational/purchase/groupSupplierMonth", method: "get", params: e });
}
function g(e) {
  return a({ url: "/api/pc/operational/purchase/groupMonthDetail", method: "get", params: e });
}
function d(e) {
  return a({ url: "/api/v2/scm/purchase-order", method: "get", params: e });
}
function m({ id: e }) {
  return a({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/inboundDetail/${e}`, method: "get" });
}
function f(e) {
  return a({ url: "/api/pc/operational/purchase/download/supplierGroupDetail", method: "get", responseType: "blob", params: e });
}
function D(e) {
  return a({ url: "/api/pc/operational/purchase/download/groupMonthDetail", method: "get", responseType: "blob", params: e });
}
function S(e) {
  return a({ url: "/api/pc/operational/purchase/download/getGroupDetail/year", method: "get", responseType: "blob", params: e });
}
function y(e) {
  return a({ url: "/api/pc/operational/purchase/download/inboundDetail", method: "get", responseType: "blob", params: e });
}
export {
  u as a,
  o as b,
  n as c,
  S as d,
  c as e,
  h as f,
  t as g,
  d as h,
  p as i,
  i as j,
  l as k,
  s as l,
  f as m,
  g as n,
  D as o,
  m as p,
  y as q
};
