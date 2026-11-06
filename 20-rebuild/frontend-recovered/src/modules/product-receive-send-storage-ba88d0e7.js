import { l as t } from "../shared/runtime.js";
function i(e) {
  return t({ url: "/api/mes/building/warehouse/finish-product/page", method: "get", params: e });
}
function u(e) {
  return t({ url: "/api/mes/building/warehouse/finish-product/detail/page", method: "get", params: e });
}
function a(e) {
  return t({ url: "/api/mes/building/warehouse/finish-product/summary", method: "get", params: e });
}
function o(e) {
  return t({ url: "/api/mes/building/warehouse/report/finish-product/artifact", method: "get", params: e });
}
const s = { get: i };
export {
  o as a,
  s as c,
  u as d,
  a as s
};
