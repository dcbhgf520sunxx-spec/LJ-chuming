import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ url: "/api/mes/bridge/warehouse/finish-product/page", method: "get", params: e });
}
function a(e) {
  return r({ url: "/api/mes/bridge/warehouse/finish-product/detail/page", method: "get", params: e });
}
function u(e) {
  return r({ url: "/api/mes/bridge/warehouse/finish-product/summary", method: "get", params: e });
}
function o(e) {
  return r({ url: "/api/mes/bridge/warehouse/report/finish-product/box", method: "get", params: e });
}
const s = { get: t };
export {
  o as a,
  s as c,
  a as d,
  u as s
};
