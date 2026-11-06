import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "wms", url: "report/raw-materials/inbound/receipt", method: "get", params: e });
}
function n(e) {
  return t({ module: "wms", url: `inbound/receipt/${e}/printState`, method: "get" });
}
function i(e) {
  return t({ module: "wms", url: `report/raw-materials/inbound/receipt/${e}`, method: "get" });
}
function u(e) {
  return t({ module: "wms", url: "report/raw-materials/inbound/details", method: "get", params: e });
}
function a(e) {
  return t({ module: "wms", url: "report/raw-materials/inbound/details/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
function l(e) {
  return t({ module: "wms", url: "report/raw-materials/inboundAndReject/details/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
function s(e) {
  return t({ module: "wms", url: "report/raw-materials/inbound/detailsCount", method: "get", params: e });
}
export {
  s as a,
  l as b,
  o as c,
  i as d,
  a as e,
  u as g,
  n as r
};
