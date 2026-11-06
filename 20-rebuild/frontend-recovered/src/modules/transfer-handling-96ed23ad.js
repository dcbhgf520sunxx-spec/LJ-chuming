import { l as a } from "../shared/runtime.js";
function n(t) {
  return a({ module: "wms", url: "transfer/application/steel-plate", method: "put", data: t });
}
function r(t) {
  return a({ module: "wms", url: "transfer/application/section-steel", method: "put", data: t });
}
function l(t) {
  return a({ module: "wms", url: "transfer/application/steel-coil", method: "put", data: t });
}
function s(t) {
  return a({ module: "wms", url: "transfer/application/auxiliary-material", method: "put", data: t });
}
function i(t) {
  return a({ module: "wms", url: "transfer/application/other-material", method: "put", data: t });
}
function o(t) {
  return a({ module: "wms", url: "transfer/application/gas", method: "put", data: t });
}
function u(t) {
  return a({ module: "wms", url: "transfer/application/steel-plate/batch", method: "put", data: t });
}
function c(t) {
  return a({ module: "wms", url: "transfer/application/section-steel/batch", method: "put", data: t });
}
function m(t) {
  return a({ module: "wms", url: "transfer/application/steel-coil/batch", method: "put", data: t });
}
function p(t) {
  return a({ module: "wms", url: "transfer/application/auxiliary-material/batch", method: "put", data: t });
}
function f(t) {
  return a({ module: "wms", url: "transfer/application/other-material/batch", method: "put", data: t });
}
function d(t) {
  return a({ module: "wms", url: "transfer/application/gas/batch", method: "put", data: t });
}
export {
  s as a,
  r as b,
  n as c,
  p as d,
  d as e,
  f,
  o as g,
  m as h,
  c as i,
  u as j,
  i as o,
  l as s
};
