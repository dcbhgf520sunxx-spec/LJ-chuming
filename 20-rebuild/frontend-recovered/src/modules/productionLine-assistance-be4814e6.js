import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "task/change/task_order/page", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: `task/change/task_order/${e.taskOrderId}/list`, method: "get", params: e });
}
function a(e) {
  return t({ module: "mes", url: "task/change", method: "post", data: e });
}
function n(e) {
  return t({ module: "mes", url: "task/change/nest", method: "post", data: e });
}
function u(e) {
  return t({ module: "mes", url: "task/change/page", method: "get", params: e });
}
function d(e) {
  return t({ module: "mes", url: `task/change/${e.changeId}/details/list`, method: "get", params: e });
}
const c = { get: r };
export {
  d as a,
  a as b,
  c,
  o as d,
  u as r,
  n as s
};
