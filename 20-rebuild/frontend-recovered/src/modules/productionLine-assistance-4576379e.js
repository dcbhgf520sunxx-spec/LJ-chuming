import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "bridge", url: "task/change/task_order/page", method: "get", params: e });
}
function o(e) {
  return t({ module: "bridge", url: `task/change/task_order/${e.taskOrderId}/list`, method: "get", params: e });
}
function a(e) {
  return t({ module: "bridge", url: "task/change", method: "post", data: e });
}
function n(e) {
  return t({ module: "bridge", url: "task/change/nest", method: "post", data: e });
}
function s(e) {
  return t({ module: "bridge", url: "task/change/page", method: "get", params: e });
}
function u(e) {
  return t({ module: "bridge", url: `task/change/${e.changeId}/details/list`, method: "get", params: e });
}
const g = { get: r };
export {
  u as a,
  a as b,
  g as c,
  o as d,
  s as r,
  n as s
};
