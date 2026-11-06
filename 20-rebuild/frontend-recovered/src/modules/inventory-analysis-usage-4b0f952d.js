import { l as t } from "../shared/runtime.js";
function n(e) {
  return t({ module: "wms", url: "report/raw-materials/inventory-use/new", method: "get", params: e });
}
function o() {
  return t({ module: "wms", url: "report/raw-materials/inventory-use/getTimeList", method: "get" });
}
function s() {
  return t({ module: "wms_v2", url: "config/inventory/base", method: "get" });
}
function u(e) {
  return t({ module: "wms_v2", url: "config/inventory/base", method: "put", data: e });
}
function i(e) {
  return t({ module: "wms", url: "report/raw-materials/inventory-use/weighting", method: "post", params: e });
}
function a(e) {
  return t({ module: "wms", url: "report/raw-materials/inventory-use/getUseRecord-new", method: "get", params: e });
}
function m(e) {
  return t({ module: "wms", url: "report/raw-materials/inventory-use/getSteelCount", method: "get", params: e });
}
function l(e) {
  return t({ module: "wms_v2", url: "report/raw-materials/inventory/statistics/excel-new", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
function d(e) {
  return t({ module: "wms_v2", url: "report/raw-materials/inventory/use/excel-new", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
export {
  a,
  o as b,
  s as c,
  m as d,
  l as e,
  d as f,
  n as g,
  i as h,
  u as p
};
