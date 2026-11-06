import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "cargo/project/summary", method: "get", params: e });
}
function i(e) {
  return t({ url: "/api/mes/building/cargo/project/cargoList/details/page", method: "get", params: e });
}
function u(e) {
  return t({ url: "/api/mes/building/cargo/project/cargoList/auxiliary/details/page", method: "get", params: e });
}
function o(e) {
  return t({ url: "/api/mes/building/cargo/project/cargoList/auxiliary/package/details", method: "get", params: e });
}
function c(e) {
  return t({ module: "mes", url: "cargo/year/summary", method: "get", params: e });
}
function n(e) {
  return t({ module: "mes", url: "cargo/project/detail/summary", method: "get", params: e });
}
function l(e) {
  return t({ module: "mes", url: "cargo/project/detail/directShipment/summary", method: "get", params: e });
}
function m(e) {
  return t({ module: "mes", url: "cargo/project/detail/type", method: "get", params: e });
}
function s(e) {
  return t({ module: "mes", url: "cargo/project/detail/directShipment/type", method: "get", params: e });
}
function g(e) {
  return t({ url: "/api/mes/building/cargo/project/cargoList/directShipment/details/page", method: "get", params: e });
}
function d(e) {
  return t({ url: "/api/mes/building/cargo/project/detail/artifact/package", method: "get", params: e });
}
function p(e) {
  return t({ url: "/api/mes/building/cargo/project/detail/directShipment/package", method: "get", params: e });
}
function h(e) {
  return t({ url: "/api/mes/building/cargo/project/detail/enclosure/package", method: "get", params: e });
}
function f(e) {
  return t({ url: "/api/mes/building/cargo/project/detail/artifact/package/details", method: "get", params: e });
}
function b(e) {
  return t({ url: "/api/mes/building/cargo/project/detail/directShipment/package/details", method: "get", params: e });
}
function D(e) {
  return t({ url: "/api/mes/building/cargo/project/detail/enclosure/package/details", method: "get", params: e });
}
function j(e) {
  return t({ url: "/api/mes/building/cargo/project/detail/artifact/trainNumber", method: "get", params: e });
}
function y(e) {
  return t({ url: "/api/mes/building/cargo/project/detail/directShipment/trainNumber", method: "get", params: e });
}
function k(e) {
  return t({ url: "/api/mes/building/cargo/project/detail/enclosure/trainNumber", method: "get", params: e });
}
const S = { get: r };
export {
  u as a,
  o as b,
  S as c,
  c as d,
  n as e,
  l as f,
  m as g,
  s as h,
  d as i,
  p as j,
  j as k,
  y as l,
  i as m,
  g as n,
  f as o,
  D as p,
  b as q,
  h as s,
  k as t
};
