import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ url: "/api/v2/scm/subcontract-order/getPage", method: "get", params: t });
}
function c(t) {
  return e({ url: "/api/v2/scm/subcontract-order/saveSubcontractOrder", method: "post", data: t });
}
function a(t) {
  return e({ url: `/api/v2/scm/subcontract-order/subcontractOrder/${t}`, method: "get" });
}
function u(t) {
  return e({ url: "/api/v2/scm/subcontract-order/delSumSubcontractOrder", method: "delete", data: t });
}
function s(t) {
  return e({ url: "/api/v2/contract/payment/getProject", method: "get", params: { projectManagerId: t } });
}
function p({ projectManagerId: t, projectId: r }) {
  return e({ url: `/api/v2/contract/payment/subcontract/getSupplier/${t}/${r}`, method: "get" });
}
function d({ projectManagerId: t, projectId: r, supplierId: n }) {
  return e({ url: `/api/v2/contract/payment/subcontract/getContractNumber/${t}/${r}/${n}`, method: "get" });
}
function m(t) {
  return e({ url: `/api/v2/contract/payment/subcontract/getPaymentDetail/${t}`, method: "get" });
}
function g(t) {
  return e({ url: "/api/v2/contract/payment/subcontract/addPayment", method: "post", data: t });
}
function l(t) {
  return e({ url: `/api/contract/receive-invoice/v2/subcontrat/getPayment/SelfOwned/${t}`, method: "get" });
}
function v(t) {
  return e({ url: "/api/contract/supplier-settlement/v2/saveSubcontractOrder", method: "post", data: t });
}
function f(t) {
  return e({ url: "/api/contract/receive-invoice/v2/subcontrat/audit", method: "post", data: t });
}
function b(t) {
  return e({ url: `/api/v2/scm/subcontract-order/paymentList/${t}`, method: "get" });
}
function h(t) {
  return e({ url: `/api/v2/scm/subcontract-order/invoiceList/${t}`, method: "get" });
}
function y() {
  return e({ url: "/api/v2/scm/subcontract-order", method: "get" });
}
const P = { get: o, add: c, detail: a, del: u };
export {
  f as P,
  l as a,
  s as b,
  P as c,
  p as d,
  d as e,
  v as f,
  y as g,
  m as h,
  h as i,
  b as j,
  g as p
};
