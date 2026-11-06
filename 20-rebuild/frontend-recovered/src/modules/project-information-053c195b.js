import { l as r } from "../shared/runtime.js";
function n(o) {
  return r({ module: "crm", url: "project/information/warehousing/list", method: "get", params: o });
}
function i(o) {
  return r({ module: "crm", url: "project/information/warehousing/detail", method: "get", params: o });
}
function u(o, e) {
  return r({ module: "crm", url: "project/information/warehousing/save", method: "post", data: o, params: e });
}
function c(o) {
  return r({ module: "crm", url: "project/information/warehousing/update", method: "post", data: o });
}
function a(o) {
  return r({ module: "crm", url: "project/information/warehousing/filing/task/grant", method: "post", data: o });
}
function m(o) {
  return r({ module: "crm", url: "enterprise/warehousing/task/precheck", method: "get", params: o });
}
function d(o) {
  return r({ module: "crm", url: "project/follow/up/record", method: "get", params: o });
}
function l(o) {
  return r({ module: "crm", url: "project/follow/up/record/save", method: "post", data: o });
}
function s(o) {
  return r({ module: "crm", url: "prequalification/record/save", method: "post", data: o });
}
function p(o) {
  return r({ module: "crm", url: "apply/for/bid/record/save/custom", method: "post", data: o });
}
function f(o) {
  return r({ module: "crm", url: "project/abandon/record/save", method: "post", data: o });
}
function h(o) {
  return r({ module: "crm", url: "project/information/warehousing/can/be/released", method: "get", params: o });
}
function g(o) {
  return r({ module: "crm", url: "project/information/warehousing/project/can/carry/out/type/custom", method: "get", params: o });
}
function j(o) {
  return r({ module: "crm", url: "project/information/warehousing/this/project/bind/enter/record/info", method: "get", params: o });
}
function w(o) {
  return r({ module: "crm", url: "project/information/warehousing/detail/downLoad", method: "get", responseType: "blob", params: o });
}
function b(o) {
  return r({ module: "crm", url: "project/information/warehousing/can/bid/application/type", method: "get", params: o });
}
export {
  u as a,
  b,
  n as c,
  h as d,
  c as e,
  d as f,
  i as g,
  m as h,
  j as i,
  g as j,
  l as k,
  s as l,
  f as m,
  w as p,
  a as r,
  p as t
};
