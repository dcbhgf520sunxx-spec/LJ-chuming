import { l as n } from "../shared/runtime.js";
function a(t) {
  return n({ url: "/api/contractManagementCost/page", method: "get", params: t });
}
function o(t) {
  return n({ url: "/api/contractManagementCost", method: "put", data: t });
}
function r(t) {
  return n({ url: "/api/contractManagementCost", method: "post", data: t });
}
function u(t) {
  return n({ url: "/api/contractManagementCost", method: "delete", data: t });
}
function i(t) {
  return n({ url: "/api/contractManagementCost/updateStatus", method: "put", params: t });
}
function s(t) {
  return n({ url: "/api/contractEarnestMoney/page", method: "get", params: t });
}
function p(t) {
  return n({ url: "/api/contractEarnestMoney", method: "put", data: t });
}
function c(t) {
  return n({ url: "/api/contractEarnestMoney", method: "post", data: t });
}
function d(t) {
  return n({ url: "/api/contractEarnestMoney", method: "delete", data: t });
}
function m(t) {
  return n({ url: "/api/contractEarnestMoney/updateStatus", method: "put", params: t });
}
export {
  a,
  u as b,
  i as c,
  d,
  m as e,
  p as f,
  s as g,
  c as h,
  r as i,
  o as p
};
