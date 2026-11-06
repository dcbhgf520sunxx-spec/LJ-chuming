import { l as t } from "../shared/runtime.js";
function e(s) {
  return t({ module: "mes", url: "assist/top_task_order/page", method: "get", params: s });
}
function o({ topTaskOrderId: s }) {
  return t({ module: "mes", url: `assist/${s}/task_order/list`, method: "get" });
}
function a(s) {
  return t({ module: "mes", url: "assist/task_order/product/list", method: "get", params: s });
}
function u(s) {
  return t({ module: "mes", url: "assist/task_order/assemble/list", method: "get", params: s });
}
function m(s) {
  return t({ module: "mes", url: "assist", method: "post", data: s });
}
function i(s) {
  return t({ module: "mes", url: "assist/list", method: "post", data: s });
}
const l = { get: e };
export {
  u as a,
  i as b,
  l as c,
  a as d,
  o as g,
  m as s
};
