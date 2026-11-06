import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "bridge", url: "scheduling/box/page", method: "get", params: e });
}
function o(e) {
  return r({ module: "bridge", url: "scheduling/box/summary", method: "get", params: e });
}
function d(e) {
  return r({ module: "bridge", url: "scheduling/box/record/count", method: "get", params: e });
}
function n(e) {
  return r({ module: "bridge", url: "scheduling/box", method: "post", data: e });
}
function i(e) {
  return r({ module: "bridge", url: "scheduling/box/record/page", method: "get", params: e });
}
function g(e) {
  return r({ module: "bridge", url: "scheduling/box/record/summary", method: "get", params: e });
}
function l(e) {
  return r({ module: "bridge", url: "scheduling/box/element", method: "post", data: e });
}
function c(e) {
  return r({ module: "bridge", url: "scheduling/box/record", method: "put", data: e });
}
function m(e) {
  return r({ module: "bridge", url: "scheduling/box/record", method: "delete", data: e });
}
function s(e) {
  return r({ module: "bridge", url: "scheduling/area/tree/list", method: "get", params: e });
}
function a(e) {
  return r({ module: "bridge", url: "scheduling/area/tree/time", method: "get", params: e });
}
function h(e) {
  return r({ module: "bridge", url: "scheduling/box/record/type/list", method: "get", params: e });
}
function b(e) {
  return r({ module: "bridge", url: "scheduling/box/type/list", method: "get", params: e });
}
function f(e) {
  return r({ module: "bridge", url: "groups/scheduling/tree", method: "get", params: e });
}
const x = { get: t };
export {
  d as a,
  f as b,
  x as c,
  b as d,
  h as e,
  i as f,
  o as g,
  a as h,
  s as i,
  c as j,
  m as k,
  l,
  g as r,
  n as s
};
