import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ url: "/api/wms/inbound/manufactured/application/record", method: "get", params: e });
}
function n(e) {
  return t({ url: `/api/wms/inbound/manufactured/application/record/${e}`, method: "get" });
}
function i(e) {
  return t({ module: "wms", url: "inbound/manufactured/application/record/detail", method: "get", params: e });
}
function u(e) {
  return t({ url: "/api/v2/wms/report/raw-materials/inbound/details/manufactured/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
export {
  n as a,
  r as b,
  u as e,
  i as g
};
