import { l as t } from "../shared/runtime.js";
function n(e) {
  return t({ module: "wms", url: "material-inventory/steel-plate", method: "get", params: e });
}
function o(e) {
  return t({ module: "wms", url: "material-inventory/section-steel", method: "get", params: e });
}
function i(e) {
  return t({ module: "wms", url: "material-inventory/steel-coil", method: "get", params: e });
}
function l(e) {
  return t({ module: "wms", url: "material-inventory/auxiliary-material", method: "get", params: e });
}
function a(e) {
  return t({ module: "wms", url: "material-inventory/other-material", method: "get", params: e });
}
function u(e) {
  return t({ module: "wms", url: "material-inventory/gas", method: "get", params: e });
}
function m(e) {
  return t({ module: "wms", url: "material-inventory/ids", method: "get", params: e });
}
function s(e) {
  return t({ url: "/api/wms/convert/exportConversionOrderAuditList", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
export {
  l as a,
  u as b,
  a as c,
  n as d,
  i as e,
  o as f,
  m as g,
  s as h
};
