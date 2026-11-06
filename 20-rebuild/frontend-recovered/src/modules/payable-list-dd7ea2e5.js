import { l as r } from "../shared/runtime.js";
function e(t) {
  return r({ url: "/api/contract/supplier/summary/list", method: "get", params: t });
}
function u(t) {
  return r({ url: "/api/contract/supplier/summary/purchaseOrder/list", method: "get", params: t });
}
function s(t) {
  return r({ url: `/api/contract/supplier/summary/purchaseOrder/${t}`, method: "get" });
}
function i(t) {
  return r({ url: `/api/contract/supplier/summary/purchaseOrder/${t.id}/download`, responseType: "blob", method: "get" });
}
function n(t) {
  return r({ url: "/api/contract/supplier/summary/subcontractOrder/list", method: "get", params: t });
}
function c(t) {
  return r({ url: `/api/contract/supplier/summary/subcontractOrder/${t}`, method: "get" });
}
function o(t) {
  return r({ url: "/api/contract/supplier/summary/cargoList/list", method: "get", params: t });
}
function p(t) {
  return r({ url: "/api/contract/supplier/summary/logistics/list", method: "get", params: t });
}
function l(t) {
  return r({ url: `/api/contract/supplier/summary/logistics/inboundOrder/${t}`, method: "get" });
}
const m = { get: e };
export {
  n as a,
  p as b,
  m as c,
  o as d,
  s as e,
  i as f,
  u as g,
  c as h,
  l as i
};
