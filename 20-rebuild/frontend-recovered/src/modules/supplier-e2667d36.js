import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ url: "/api/project/v2/projectLedger/supplierLedger", method: "get", params: { ...e, level: 1 } });
}
function a(e) {
  return r({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/paymentDetail/${e.orderId}`, method: "get", params: { pageNumber: e.pageNumber, pageSize: e.pageSize } });
}
function p(e) {
  return r({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/invoiceDetail/${e.orderId}`, method: "get", params: { pageNumber: e.pageNumber, pageSize: e.pageSize } });
}
function u(e) {
  return r({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/settleDetail/${e.orderId}`, method: "get", params: { pageNumber: e.pageNumber, pageSize: e.pageSize } });
}
function g(e) {
  return r({ url: "/api/project/v2/projectLedger/getOrderNumber/1", method: "get", params: e });
}
function o() {
  return r({ url: "/api/project/v2/projectLedger/projectFilter", method: "get", params: { projectAttribute: "1", level: "1" } });
}
const c = { get: t };
export {
  o as a,
  p as b,
  c,
  a as d,
  u as e,
  g
};
