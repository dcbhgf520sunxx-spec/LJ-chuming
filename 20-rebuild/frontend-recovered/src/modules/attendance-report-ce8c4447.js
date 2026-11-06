import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ url: "/api/attend/config/dayDetails", method: "get", params: t });
}
function a(t) {
  return e({ url: "/api/attend/config/standConfig/edit", method: "post", data: t });
}
function i(t) {
  return e({ url: "/api/attend/config/standConfig", method: "get", params: t });
}
function r(t) {
  return e({ url: "/api/mes/map/key", method: "get", params: t });
}
function d(t) {
  return e({ url: "/api/attend/config/summary", method: "get", params: t });
}
function g(t) {
  return e({ url: "/api/attend/config/cardDetails", method: "get", params: t });
}
function u(t) {
  return e({ url: "/api/attend/config/dayDetails/download", method: "get", responseType: "blob", params: t });
}
function s(t) {
  return e({ url: "/api/attend/config/cardDetails/download", method: "get", responseType: "blob", params: t });
}
function f(t) {
  return e({ url: "/api/attend/config/OverConfig/page", method: "get", params: t });
}
function l(t) {
  return e({ url: "/api/attend/config/OverConfig/details", method: "get", params: t });
}
function c(t) {
  return e({ url: "/api/attend/config/overConfig/edit", method: "post", data: t });
}
function p(t) {
  return e({ url: "/api/attend/config/overConfig/delete", method: "delete", params: t });
}
function m(t) {
  return e({ url: "/api/attend/config/dept/list", method: "get", params: t });
}
function h(t) {
  return e({ url: "/api/attend/config/rosterByDept/list", method: "get", params: t });
}
function C(t) {
  return e({ url: "/api/attend/config/monthDetails", method: "get", params: t });
}
function D(t) {
  return e({ url: "/api/attend/config/monthDetails/download", method: "get", responseType: "blob", params: t });
}
export {
  g as a,
  o as b,
  C as c,
  s as d,
  u as e,
  D as f,
  d as g,
  r as h,
  i,
  f as j,
  p as k,
  l,
  h as m,
  c as n,
  m as o,
  a as s
};
