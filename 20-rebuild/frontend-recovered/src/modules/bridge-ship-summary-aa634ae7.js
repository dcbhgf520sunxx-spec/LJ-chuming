import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ url: "/api/mes/bridge/cargo/project/summary", method: "get", params: e });
}
function i(e) {
  return r({ url: "/api/mes/bridge/cargo/project/cargoList/details/page", method: "get", params: e });
}
function o(e) {
  return r({ url: "/api/mes/bridge/cargo/project/cargoList/directShipment/details/page", method: "get", params: e });
}
function m(e) {
  return r({ url: "/api/mes/bridge/cargo/project/cargoList/auxiliary/details/page", method: "get", params: e });
}
function u(e) {
  return r({ url: "/api/mes/bridge/cargo/year/summary", method: "get", params: e });
}
function c(e) {
  return r({ url: "/api/mes/bridge/cargo/project/detail/summary", method: "get", params: e });
}
function n(e) {
  return r({ url: "/api/mes/bridge/cargo/project/detail/directShipment/summary", method: "get", params: e });
}
function s(e) {
  return r({ url: "/api/mes/bridge/cargo/project/detail/type", method: "get", params: e });
}
function g(e) {
  return r({ url: "/api/mes/bridge/cargo/project/detail/directShipment/type", method: "get", params: e });
}
const d = { get: t };
export {
  n as a,
  m as b,
  d as c,
  s as d,
  g as e,
  o as f,
  i,
  c as p,
  u as s
};
