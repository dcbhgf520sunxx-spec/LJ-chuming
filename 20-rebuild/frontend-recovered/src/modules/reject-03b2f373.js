import { l as t } from "../shared/runtime.js";
function i(e) {
  return t({ module: "wms", url: "report/raw-materials/reject/receipt", method: "get", params: e });
}
function a(e) {
  return t({ module: "wms", url: `report/raw-materials/reject/receipt/${e}`, method: "get" });
}
function o(e) {
  return t({ module: "wms_v2", url: "report/raw-materials/reject/receiptDetailCount", method: "get", params: e });
}
function l(e) {
  return t({ module: "wms_v2", url: "report/raw-materials/reject/details/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
function c(e) {
  return t({ module: "wms", url: "report/raw-materials/reject/receiptDetail", method: "get", params: e });
}
function s(e) {
  return t({ url: `/api/wms/reject/receipt/${e}/printState`, method: "get" });
}
export {
  o as a,
  i as b,
  a as c,
  l as e,
  c as g,
  s as r
};
