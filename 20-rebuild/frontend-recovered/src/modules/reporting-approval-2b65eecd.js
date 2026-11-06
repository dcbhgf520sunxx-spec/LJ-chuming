import { l as t } from "../shared/runtime.js";
function e(o) {
  return t({ module: "mes", url: "quota-config/production-reporting-approval/unapproved-page", method: "get", params: o });
}
function a(o) {
  return t({ module: "mes", url: "quota-config/production-reporting-approval/approval-passed", method: "post", data: o });
}
function n(o) {
  return t({ module: "mes", url: "quota-config/production-reporting-approval/batch-approval-passed", method: "post", data: o });
}
function u(o) {
  return t({ module: "mes", url: "quota-config/artifact/list", method: "get", params: o });
}
function p(o) {
  return t({ module: "mes", url: "quota-config/assemble/list", method: "get", params: o });
}
function i(o) {
  return t({ module: "mes", url: "quota-config/machine-part/list", method: "get", params: o });
}
function s(o) {
  return t({ module: "mes", url: "quota-config/coating/list", method: "get", params: o });
}
function d(o) {
  return t({ module: "mes", url: "quota-config/production-reporting-approval/approved-page", method: "get", params: o });
}
function c(o) {
  return t({ module: "mes", url: "quota-config/production-reporting-approval/approved-edit", method: "put", data: o });
}
function l(o) {
  return t({ module: "mes", url: "quota-config/production-reporting-approval/approved-record-export", method: "get", timeout: 6e6, responseType: "blob", params: o });
}
const m = { get: e };
export {
  i as a,
  n as b,
  m as c,
  p as d,
  u as e,
  a as f,
  d as g,
  c as h,
  l as i,
  s as q
};
