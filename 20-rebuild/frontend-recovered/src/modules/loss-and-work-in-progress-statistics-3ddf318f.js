import { l as t } from "../shared/runtime.js";
function e(s) {
  return t({ url: "/api/mes/loss/progress/statistics/wastage/list", method: "get", params: s });
}
function a(s) {
  return t({ url: "/api/mes/loss/progress/statistics/process", method: "get", params: s });
}
function r(s) {
  return t({ url: "/api/mes/loss/progress/statistics/wastage/list/download", method: "get", responseType: "blob", params: s });
}
function i(s) {
  return t({ url: "/api/mes/loss/progress/statistics/wastage/list/download", method: "get", responseType: "blob", params: s });
}
function n(s) {
  return t({ url: "/api/mes/loss/progress/statistics/wastage/costSummary/download", method: "get", responseType: "blob", params: s });
}
function l(s) {
  return t({ url: "/api/mes/loss/progress/statistics/workshop/project/wastage/detail/download", method: "get", responseType: "blob", params: s });
}
function p(s) {
  return t({ url: "/api/mes/loss/progress/statistics/wastage/costSummary/mes/detail/download", method: "get", responseType: "blob", params: s });
}
function g(s) {
  return t({ url: "/api/mes/loss/progress/statistics/wastage/costSummary", method: "get", params: s });
}
const m = { get: e };
export {
  i as a,
  l as b,
  m as c,
  r as d,
  n as e,
  g as f,
  a as g,
  p as w
};
