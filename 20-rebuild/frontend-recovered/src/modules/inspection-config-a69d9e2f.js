import { l as t } from "../shared/runtime.js";
function i(e) {
  return t({ url: "/api/mes/inspection/list", method: "get", params: e });
}
function o(e) {
  return t({ url: "/api/mes/inspection/config/printQrCode", method: "get", params: e });
}
function u(e) {
  return t({ url: "/api/mes/inspection/config", method: "post", data: e });
}
function s(e) {
  return t({ url: "/api/mes/inspection/config", method: "put", data: e });
}
function r(e) {
  return t({ url: "/api/mes/inspection/config/updateStatus", method: "put", params: e });
}
function p(e) {
  return t({ url: "/api/mes/inspection/updateLineStatus", method: "put", params: e });
}
function a(e) {
  return t({ url: "/api/mes/inspection/config", method: "delete", params: e });
}
function c(e) {
  return t({ url: "/api/mes/inspection/getLine", method: "get", params: e });
}
function m(e) {
  return t({ url: "/api/mes/inspection/config/saveLine", method: "post", data: e });
}
function d(e) {
  return t({ url: "/api/mes/inspection/config/updateLine", method: "put", data: e });
}
function f(e) {
  return t({ url: "/api/mes/inspection/config/deleteLine", method: "delete", params: e });
}
function l(e) {
  return t({ url: "/api/mes/inspection/config/applyRemoveLine/page", method: "get", params: e });
}
function g(e) {
  return t({ url: "/api/mes/inspection/config/applyRemoveLine/examine", method: "post", params: e });
}
function h(e) {
  return t({ url: "/api/mes/inspection/config/applyNum", method: "get", params: e });
}
export {
  c as a,
  h as b,
  f as c,
  a as d,
  r as e,
  p as f,
  i as g,
  s as h,
  u as i,
  d as j,
  m as k,
  o as l,
  l as m,
  g as n
};
