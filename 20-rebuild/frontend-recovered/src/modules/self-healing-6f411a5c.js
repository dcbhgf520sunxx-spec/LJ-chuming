import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ url: "/api/project/v2/projectSelfEmployed", method: "get", params: { ...t, level: 1 } });
}
function i(t) {
  return e({ url: "/api/contract/collection/v2/listPage", method: "get", params: t });
}
function n(t) {
  return e({ url: "/api/project/v2/getProjectAttributeList", method: "get", params: { ...t, projectAttribute: "1", level: 1 } });
}
function c(t) {
  return e({ url: "/api/project/v2/projectSelfOwned", method: "get", params: { ...t, level: 1 } });
}
function a(t) {
  return e({ url: `/api/common/attachment/download/${t.id}`, method: "get", responseType: "blob", headers: { "Content-Type": "application/x-www-form-urlencoded" } });
}
function p(t) {
  return e({ url: "/api/contract/invoice/V2/listPage", method: "get", params: t });
}
function l(t) {
  return e({ url: "/api/project/v2/project/collectionAndInvoiceDetail", method: "get", params: t });
}
function u(t) {
  return e({ url: "/api/project/v2/detailList/", method: "get", params: t });
}
function s(t) {
  return e({ url: "/api/contract/audit/projectLedger/projectSettlementSave", method: "post", data: t });
}
function d(t) {
  return e({ url: "/api/contract/project/preSettlement/save", method: "post", data: t });
}
function m(t) {
  return e({ url: "/api/contract/project/preSettlement/list", method: "get", params: t });
}
function g(t) {
  return e({ url: "/api/contract/audit/project/settlement/check", method: "get", params: t });
}
export {
  s as a,
  p as b,
  m as c,
  u as d,
  l as e,
  r as f,
  i as g,
  n as h,
  c as i,
  a as j,
  d as p,
  g as s
};
