import { l as t } from "../shared/runtime.js";
function n(e) {
  return t({ module: "wms_v2", url: "material-inventory/steel-plate", method: "get", params: e });
}
function o(e) {
  return t({ module: "wms_v2", url: "material-inventory/section-steel", method: "get", params: e });
}
function a(e) {
  return t({ module: "wms_v2", url: "material-inventory/steel-coil", method: "get", params: e });
}
function l(e) {
  return t({ module: "wms_v2", url: "material-inventory/other-steel", method: "get", params: e });
}
function m(e) {
  return t({ module: "wms_v2", url: "material-inventory/auxiliary-material", method: "get", params: e });
}
function u(e) {
  return t({ module: "wms_v2", url: "material-inventory/other-material", method: "get", params: e });
}
function i(e) {
  return t({ module: "wms_v2", url: "material-inventory/gas", method: "get", params: e });
}
function s(e) {
  return t({ module: "wms", url: "material-inventory/manufactured/list", method: "get", params: e });
}
function v(e) {
  return t({ module: "wms_v2", url: "material-inventory/realtimeInventory", method: "get", params: e });
}
function g(e) {
  return t({ module: "wms", url: "material-inventory/manufactured/getProject", method: "get", params: e });
}
export {
  i as a,
  u as b,
  n as c,
  l as d,
  a as e,
  o as f,
  m as g,
  v as h,
  s as i,
  g as j
};
