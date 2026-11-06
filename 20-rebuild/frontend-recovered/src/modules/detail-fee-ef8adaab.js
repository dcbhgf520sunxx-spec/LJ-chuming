import { l as e } from "../shared/runtime.js";
function n(t) {
  return e({ url: "/api/mes/building/cargo/shipment/list/page", method: "get", params: t });
}
function r(t) {
  return e({ url: `/api/mes/building/cargo/shipment/summary/${t}`, method: "get" });
}
function a(t) {
  return e({ url: "/api/contract/project-finance/list-depreciation", method: "get", params: t });
}
function c(t) {
  return e({ url: "/api/contract/project-finance/list-outbound", method: "get", params: t });
}
function o(t) {
  return e({ url: "/api/contract/project-finance/list-wage", method: "get", params: t });
}
function u(t) {
  return e({ url: "/api/contract/project-finance/list-sub", method: "get", params: t });
}
function s(t) {
  return e({ url: "/api/contract/project-finance/list-testing", method: "get", params: t });
}
function g(t) {
  return e({ url: "/api/contract/project-finance/list-water", method: "get", params: t });
}
function p(t) {
  return e({ url: "/api/contract/project-finance/list-manage", method: "get", params: t });
}
export {
  o as a,
  g as b,
  a as c,
  p as d,
  r as e,
  n as f,
  c as g,
  s as h,
  u as i
};
