import { l as o } from "../shared/runtime.js";
function t(e) {
  return o({ module: "mes", url: "outputReport/finishedProductWarehousingSummary", method: "get", params: e });
}
function r(e) {
  return o({ module: "mes", url: "outputReport/finishedProductWarehousingSummaryDownload", method: "get", responseType: "blob", params: e });
}
function n(e) {
  return o({ module: "mes", url: "outputReport/finishedProductWarehousingSummaryDetail", method: "get", params: e });
}
function a(e) {
  return o({ module: "mes", url: "outputReport/finishedProductWarehousingSummaryDetailDownload", method: "get", responseType: "blob", params: e });
}
const i = { get: t };
export {
  a,
  i as c,
  n as g,
  r as y
};
