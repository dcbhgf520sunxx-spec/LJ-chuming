import { l as t } from "../shared/runtime.js";
function l(e) {
  return t({ url: "/api/config/getWastePriceEntryType/public", method: "get", params: e });
}
function r(e) {
  return t({ module: "wms", url: "report/wasteSale", method: "get", params: e });
}
function a(e) {
  return t({ url: "/api/branchCompany/all/simple", method: "get", params: e });
}
function n(e) {
  return t({ url: "/api/contract/contractWaste/listAll", method: "get", params: e });
}
function u(e) {
  return t({ module: "wms", url: "report/wasteSale", method: "post", data: e });
}
function c(e) {
  return t({ module: "wms", url: "report/wasteSale", method: "put", data: e });
}
function s(e) {
  return t({ module: "wms", url: "report/wasteSale", method: "delete", data: e });
}
function p(e) {
  return t({ module: "wms", url: "report/wasteSale/check", method: "put", data: e });
}
function d(e) {
  return t({ module: "wms", url: `report/wasteSale/downLoad/${e}`, method: "get", responseType: "blob" });
}
const i = { get: r };
export {
  l as a,
  p as b,
  i as c,
  s as d,
  d as e,
  a as f,
  n as g,
  u as h,
  c as i
};
