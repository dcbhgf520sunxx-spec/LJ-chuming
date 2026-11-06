import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "wms", url: "report/raw-materials/outbound/details", method: "get", params: e });
}
function u(e) {
  return t({ module: "wms", url: "report/raw-materials/outbound/details/mete", method: "get", params: e });
}
function a(e) {
  return t({ module: "wms", url: "report/raw-materials/outbound/details/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
function s(e) {
  return t({ module: "wms", url: "report/raw-materials/outboundAndReturn/details/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
function l(e) {
  return t({ module: "wms", url: "report/raw-materials/outbound/detailsCount", method: "get", params: e });
}
function n(e) {
  return t({ url: "/api/v2/wms/report/raw-materials/outsourcingOutbound/details/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
export {
  l as a,
  u as b,
  s as c,
  n as d,
  a as e,
  o as g
};
