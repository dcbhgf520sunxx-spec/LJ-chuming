import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ url: "/api/pc/operational/project/listAllProject", method: "get", params: t });
}
function a(t) {
  return e({ url: "/api/pc/operational/project/projectSelfOwned", method: "get", params: t });
}
function n(t) {
  return e({ url: "/api/pc/operational/project/openUp", method: "get", params: t });
}
function p(t) {
  return e({ url: "/api/pc/operational/project/getProjectProductionMete", method: "get", params: t });
}
function c(t) {
  return e({ url: "/api/pc/operational/project/productionState", method: "get", params: t });
}
function i(t) {
  return e({ url: "/api/pc/operational/project/status", method: "get", params: t });
}
function u(t) {
  return e({ url: "/api/pc/operational/project/projectExecuteState", method: "get", params: t });
}
function l(t) {
  return e({ url: "/api/pc/operational/project/projectFeedingState", method: "get", params: t });
}
function d(t) {
  return e({ url: "/api/pc/operational/project/cost/summary", method: "get", params: t });
}
function s(t) {
  return e({ url: "/api/pc/operational/project/projectCost", method: "get", params: t });
}
function g(t) {
  return e({ url: "/api/pc/operational/project/download/openUp", method: "get", responseType: "blob", params: t });
}
function j(t) {
  return e({ url: "/api/pc/operational/project/download/productionState", method: "get", responseType: "blob", params: t });
}
function m(t) {
  return e({ url: "/api/pc/operational/project/download/projectCost", method: "get", responseType: "blob", params: t });
}
function f(t) {
  return e({ url: "/api/pc/operational/project/download/projectExecuteState", method: "get", responseType: "blob", params: t });
}
function h(t) {
  return e({ url: "/api/pc/operational/project/download/projectFeedingState", method: "get", responseType: "blob", params: t });
}
const S = { get: o };
export {
  p as a,
  i as b,
  S as c,
  l as d,
  d as e,
  s as f,
  a as g,
  n as h,
  g as i,
  c as j,
  j as k,
  u as l,
  f as m,
  h as n,
  m as o
};
