import { l as t } from "../shared/runtime.js";
function i(e) {
  return t({ url: "/api/wms/picking-information/getWmsPicking", method: "get", params: e });
}
function n(e) {
  return t({ url: "/api/wms/picking-information/getWmsPickingDetail", method: "get", params: e });
}
function o(e) {
  return t({ url: `/api/wms/picking-information/selectById/${e}`, method: "get" });
}
function s(e) {
  return t({ url: "/api/wms/nesting-docking/section-steel", method: "get", params: e, cancelKey: false });
}
function r(e) {
  return t({ url: "/api/wms/nesting-docking/steel-plate", method: "get", params: e, cancelKey: false });
}
function c(e) {
  return t({ url: "/api/wms/picking/approve/save", method: "post", data: e });
}
function l(e) {
  return t({ url: "/api/wms/picking/approve/getPassDetail", method: "get", params: e });
}
function u(e) {
  return t({ url: "/api/wms/nesting-docking/getNestingFreezeDetail", method: "get", params: e });
}
function g(e) {
  return t({ url: "/api/wms/picking/approve/allocation", method: "post", data: e });
}
const p = { get: i, detail: n };
export {
  u as a,
  r as b,
  p as c,
  n as d,
  s as e,
  l as f,
  g,
  o as r,
  c as s
};
