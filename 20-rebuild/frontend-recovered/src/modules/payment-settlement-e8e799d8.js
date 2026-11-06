import { l as e } from "../shared/runtime.js";
function p(t) {
  return e({ url: "/api/v2/contract/payment/addSupplierPayment", method: "post", data: t });
}
function n(t) {
  return e({ url: `/api/v2/contract/payment/getProject?projectManagerId=${t}`, method: "get" });
}
function o(t) {
  return e({ url: `/api/v2/contract/payment/getSupplier?projectId=${t.projectId}&projectManagerId=${t.projectManagerId}`, method: "get" });
}
function c(t) {
  return e({ url: `/api/v2/contract/payment/getSupplierNumber?projectId=${t.projectId}&projectManagerId=${t.projectManagerId}&supplierId=${t.supplierId}`, method: "get" });
}
function a(t) {
  return e({ url: "/api/project/v2/getContractBaseByProjectId", method: "get", params: t });
}
function i(t) {
  return e({ url: "/api/contract/supplier-settlement/v2/get-inner", method: "get", params: t });
}
function u(t) {
  return e({ url: "/api/contract/supplier-settlement/v2/save-inner", method: "post", data: t });
}
export {
  o as a,
  c as b,
  i as c,
  a as d,
  u as e,
  n as g,
  p
};
