import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ url: "/api/v2/scm/subcontract-order/getPage", method: "get", params: t });
}
function n(t) {
  return e({ url: "/api/v2/scm/subcontract-order/saveSubcontractOrder", method: "post", data: t });
}
function o(t) {
  return e({ url: "/api/v2/scm/subcontract-order/updateSubcontractOrder", method: "put", data: t });
}
function c(t) {
  return e({ url: `/api/v2/scm/subcontract-order/subcontractOrder/${t}`, method: "get" });
}
function i(t) {
  return e({ url: "/api/v2/scm/subcontract-order/delSumSubcontractOrder", method: "delete", data: t });
}
function a(t) {
  return e({ url: "/api/v2/contract/payment/getSupplierList/sub", method: "get", params: t });
}
function s(t) {
  return e({ url: `/api/v2/contract/payment/selfOwned/getSupplier/${t.supplierId}`, method: "get", params: t });
}
function d(t) {
  return e({ url: "/api/v2/contract/payment/selfOwned/getPaymentDetail", method: "get", params: t });
}
function p(t) {
  return e({ url: "/api/v2/contract/payment/selfOwned/addSelfPayment", method: "post", data: t });
}
function l(t) {
  return e({ url: "/api/contract/supplier-settlement/v2/getSubcontractOrder", method: "get", params: t });
}
function m(t) {
  return e({ url: "/api/contract/supplier-settlement/v2/saveSubcontractOrder", method: "post", data: t });
}
function f(t) {
  return e({ url: `/api/contract/receive-invoice/v2/subcontrat/getPayment/SelfOwned/${t}`, method: "get" });
}
function g(t) {
  return e({ url: "/api/contract/receive-invoice/v2/subcontrat/audit/saveSelfOwned", method: "post", data: t });
}
function v() {
  return e({ url: "/api/v2/scm/subcontract-order/getProjectList", method: "get" });
}
function S(t) {
  return e({ url: `/api/v2/scm/subcontract-order/paymentList/${t.id}`, method: "get", params: t });
}
function b(t) {
  return e({ url: `/api/v2/scm/subcontract-order/invoiceList/${t.id}`, method: "get", params: t });
}
function h(t) {
  return e({ url: `/api/v2/scm/subcontract-order/settleList/${t.id}`, method: "get", params: t });
}
function A(t) {
  return e({ url: "/api/contract/supplier-settlement/v2/saveSubcontractOrder/pre", method: "post", data: t });
}
function O(t) {
  return e({ url: `/api/v2/scm/subcontract-order/preSettleList/${t.id}`, method: "get", params: t });
}
const P = { get: r, add: n, detail: c, del: i, edit: o };
export {
  g as P,
  v as a,
  a as b,
  P as c,
  s as d,
  f as e,
  m as f,
  d as g,
  A as h,
  l as i,
  b as j,
  S as k,
  O as l,
  h as m,
  p
};
