import { l as t } from "../shared/runtime.js";
function d(e) {
  return t({ module: "plan", url: "project-execution-dynamics/page", method: "get", params: e });
}
function n(e) {
  return t({ module: "plan", url: `project-execution-dynamics/deepen-detail/${e}`, method: "get" });
}
function r(e, o) {
  return t({ module: "plan", url: `project-execution-dynamics/deepen-detail/product/${e}`, method: "get", params: o });
}
function c(e) {
  return t({ module: "plan", url: `project-execution-dynamics/scheduling-detail/${e}`, method: "get" });
}
function i(e, o) {
  return t({ module: "plan", url: `project-execution-dynamics/scheduling-detail/product/${e}`, method: "get", params: o });
}
function l(e) {
  return t({ module: "plan", url: `project-execution-dynamics/produced-detail/${e}`, method: "get" });
}
function a(e, o) {
  return t({ module: "plan", url: `project-execution-dynamics/produced-detail/product/${e}`, method: "get", params: o });
}
function p(e) {
  return t({ module: "plan", url: `project-execution-dynamics/not-produced-detail/${e}`, method: "get" });
}
function m(e, o) {
  return t({ module: "plan", url: `project-execution-dynamics/not-produced-detail/product/${e}`, method: "get", params: o });
}
function g(e) {
  return t({ module: "plan", url: `project-execution-dynamics/delivery-detail/${e}`, method: "get" });
}
function s(e, o) {
  return t({ module: "plan", url: `project-execution-dynamics/delivery-detail/product/${e}`, method: "get", params: o });
}
const h = { get: d };
export {
  n as a,
  s as b,
  g as c,
  m as d,
  p as e,
  a as f,
  r as g,
  l as h,
  i,
  c as j,
  h as k
};
