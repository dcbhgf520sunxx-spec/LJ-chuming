import { l as t } from "../shared/runtime.js";
function e(i) {
  return t({ url: "/api/business/pricing/list", method: "get", params: i });
}
function n(i) {
  return t({ url: "/api/business/pricing/add", method: "post", data: i });
}
function s(i) {
  return t({ url: "/api/business/pricing/update", method: "put", data: i });
}
function r(i) {
  return t({ url: "/api/business/pricing/detail", method: "get", params: i });
}
function c(i) {
  return t({ url: "/api/business/pricing/check", method: "put", data: i });
}
function o(i) {
  return t({ url: "/api/business/pricing/project/info", method: "get", params: i });
}
function p(i) {
  return t({ url: "/api/business/pricing/project/list", method: "get", params: i });
}
function a(i) {
  return t({ url: "/api/business/pricing/unPricing/product", method: "get", params: i });
}
function g(i) {
  return t({ url: "/api/business/pricing/list/public", method: "get", params: i });
}
function d(i) {
  return t({ url: "/api/project/tracking/v2/return/list", method: "get", params: i });
}
const l = { get: e, add: n, detail: r };
export {
  c as a,
  o as b,
  l as c,
  r as d,
  s as e,
  a as f,
  p as g,
  g as h,
  n as i,
  d as j
};
