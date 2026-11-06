import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "bridge", url: "machine_part/scheduling/list", method: "get", params: e });
}
function n(e) {
  return t({ module: "bridge", url: "machine_part/scheduling/month/list", method: "get", params: e });
}
function u(e) {
  return t({ module: "bridge", url: "machine_part/scheduling/project/list", method: "get", params: e });
}
function d(e) {
  return t({ module: "bridge", url: "machine_part/scheduling/type/list", method: "get", params: e });
}
function a(e) {
  return t({ module: "bridge", url: "machine_part/scheduling/material/list", method: "get", params: e });
}
function o(e) {
  return t({ module: "bridge", url: "machine_part/scheduling/thick/list", method: "get", params: e });
}
function l(e) {
  return t({ module: "bridge", url: "machine_part/scheduling", method: "post", data: e });
}
function c(e) {
  return t({ module: "bridge", url: "machine_part/scheduling", method: "delete", data: e });
}
function g(e) {
  return t({ module: "bridge", url: "machine_part/scheduling/record/page", method: "get", params: e });
}
function s(e) {
  return t({ module: "bridge", url: `machine_part/scheduling/record/${e}`, method: "get" });
}
function h(e) {
  return t({ module: "bridge", url: "machine_part/scheduling/nesting", method: "post", data: e });
}
function m(e) {
  return t({ module: "bridge", url: "machine_part/scheduling/task/page", method: "get", params: e });
}
function p({ id: e }) {
  return t({ module: "bridge", url: `machine_part/scheduling/task/${e}`, method: "get" });
}
const f = { get: r };
export {
  a,
  o as b,
  f as c,
  n as d,
  u as e,
  p as f,
  d as g,
  m as h,
  c as i,
  h as j,
  s as k,
  g as r,
  l as s
};
