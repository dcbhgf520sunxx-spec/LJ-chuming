import { l as n } from "../shared/runtime.js";
function e(t) {
  return n({ module: "crm", url: "winning/contract/warehousing/contract/list", method: "get", params: t });
}
function o(t) {
  return n({ module: "crm", url: "winning/contract/warehousing", method: "get", params: t });
}
function c(t) {
  return n({ module: "crm", url: "winning/contract/warehousing/project/detail", method: "get", params: t });
}
function i(t) {
  return n({ module: "crm", url: "winning/contract/warehousing/save/contract/custom", method: "post", data: t });
}
function a(t) {
  return n({ module: "crm", url: "winning/contract/warehousing/detail", method: "get", params: t });
}
function u(t) {
  return n({ module: "crm", url: "winning/contract/warehousing/up/load/stamp/contract", responseType: "blob", method: "post", data: t });
}
function g(t) {
  return n({ module: "crm", url: "winning/contract/warehousing/detail/down/load", responseType: "blob", method: "get", params: t });
}
function l(t) {
  return n({ module: "crm", url: "winning/contract/warehousing/get/simple/list ", method: "get", params: t });
}
function m(t) {
  return n({ module: "crm", url: "winning/contract/warehousing/get/backfill/details", method: "get", params: t });
}
function s(t) {
  return n({ module: "crm", url: "winning/contract/warehousing/contract/summary", method: "get", params: t });
}
const d = { get: e };
export {
  m as a,
  s as b,
  d as c,
  a as d,
  o as e,
  c as f,
  l as g,
  g as h,
  i,
  u as j
};
