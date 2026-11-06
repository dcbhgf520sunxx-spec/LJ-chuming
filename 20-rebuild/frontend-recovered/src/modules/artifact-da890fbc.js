import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "task/order/artifact/page", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: "task/process/list", method: "get", params: e });
}
function a(e) {
  return t({ module: "mes", url: "task/process/product/task/list/page", method: "get", params: e });
}
function n(e) {
  return t({ module: "mes", url: "task/process/nesting/task/list/page", method: "get", params: e });
}
function u(e) {
  return t({ module: "mes", url: "task/process/task/list/sign", method: "get", params: e });
}
function i(e) {
  return t({ module: "mes", url: "task/order/artifact/project/listV2", method: "get", params: e });
}
function d(e) {
  return t({ url: "api/mes/building/task/task/revoke", method: "delete", data: e });
}
function l(e) {
  return t({ url: "api/mes/building/task/process/task_order/revoke", method: "get", params: e });
}
function c(e) {
  return t({ url: `api/mes/building/task/task_order/revoke/${e}`, method: "delete", data: e });
}
const m = { get: r };
export {
  l as a,
  d as b,
  m as c,
  c as d,
  n as e,
  u as f,
  a as g,
  i as h,
  o as p
};
