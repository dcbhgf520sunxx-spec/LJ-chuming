import { l as t } from "../shared/runtime.js";
function i(o) {
  return t({ module: "crm", url: "information/validity/period/config", method: "get", cancelKey: false, params: o });
}
function r(o, e) {
  return t({ module: "crm", url: "information/validity/period/config", method: "post", params: o, data: e });
}
function u(o) {
  return t({ module: "crm", url: "business/license/query/config", method: "get", cancelKey: false, params: o });
}
function m(o) {
  return t({ module: "crm", url: "business/license/query/config", method: "post", params: o });
}
function c(o) {
  return t({ module: "crm", url: "project/information/config/custom/quantity/list", method: "get", params: o });
}
function s(o) {
  return t({ module: "crm", url: "project/information/config/custom/quantity/update", method: "post", data: o });
}
function a(o) {
  return t({ module: "crm", url: "project/information/config/custom/quantity/clean", method: "delete", data: o });
}
export {
  r as a,
  c as b,
  u as c,
  a as d,
  m as e,
  i as g,
  s
};
