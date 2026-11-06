import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ url: "/api/project/v2/projectManagerLedger", method: "get", params: t });
}
function n(t) {
  return e({ url: `/api/project/v2/projectManagerLedger/${t.id}/amount`, method: "get" });
}
function o(t) {
  return e({ url: "/api/project/v2/projectManagerLedger/disburseDetail", method: "get", params: t });
}
function i(t) {
  return e({ url: `/api/contract/Injection/getProjectDetail/${t.projectId}`, method: "get" });
}
function c(t) {
  return e({ url: "/api/securityAndManagementCost/getProjectInterest", method: "get", params: t });
}
function u(t) {
  return e({ url: "/api/securityAndManagementCost/getProjectInterest", method: "get", params: t });
}
function p(t) {
  return e({ url: "/api/project/v2/order/projectPaymentAll", method: "get", params: t });
}
function g(t) {
  return e({ url: "/api/contract/Injection/getUseDetail", method: "get", params: t });
}
const s = { get: r };
export {
  i as a,
  g as b,
  s as c,
  o as d,
  u as e,
  c as f,
  p as g,
  n as i
};
