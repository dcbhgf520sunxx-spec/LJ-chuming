import { l as r } from "../shared/runtime.js";
function e(t) {
  return r({ url: "/api/mes/building/warehouse/finish-product/page", method: "get", params: t });
}
function u(t) {
  return r({ url: "/api/mes/building/warehouse/finish-product/detail/page", method: "get", params: t });
}
function a(t) {
  return r({ url: "/api/mes/building/warehouse/finish-product/summary", method: "get", params: t });
}
function o(t) {
  return r({ url: "/api/mes/building/warehouse/report/finish-product/artifact", method: "get", params: t });
}
function s(t) {
  return r({ url: "/api/mes/building/warehouse/report/finish-product/artifact/sum", method: "get", params: t });
}
const n = { get: e };
export {
  o as a,
  s as b,
  n as c,
  u as d,
  a as s
};
