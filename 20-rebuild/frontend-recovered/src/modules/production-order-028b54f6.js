import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "scheduling/area/project/page", method: "get", params: e });
}
function a(e) {
  return t({ module: "mes", url: "scheduling/area/list", method: "get", params: e });
}
function m(e) {
  return t({ module: "mes", url: "scheduling/area", method: "put", data: e });
}
function s(e) {
  return t({ module: "mes", url: "scheduling/area/project", method: "get", params: e });
}
function l(e) {
  return t({ module: "mes", url: "scheduling/area/artifact/list", method: "get", params: e });
}
function n(e) {
  return t({ module: "mes", url: "scheduling/area/assemble/list", method: "get", params: e });
}
function i(e) {
  return t({ module: "mes", url: "scheduling/area/machinePart/list", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: "scheduling/area/summary", method: "get", params: e });
}
function c(e) {
  return t({ module: "mes", url: "scheduling/area/project/summay", method: "get", params: e });
}
const d = { get: r };
export {
  o as a,
  s as b,
  d as c,
  l as d,
  n as e,
  i as m,
  c as p,
  a as s,
  m as u
};
