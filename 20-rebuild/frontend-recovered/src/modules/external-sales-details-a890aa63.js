import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "wms_v2", url: "report/raw-materials/outbound/forSale/details", method: "get", params: e });
}
function a(e) {
  return t({ module: "wms_v2", url: "report/raw-materials/outbound/forSale/detailsCount", method: "get", params: e });
}
function l(e) {
  return t({ module: "wms_v2", url: "report/raw-materials/forSale/outbound/details/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
export {
  a,
  l as e,
  r as g
};
