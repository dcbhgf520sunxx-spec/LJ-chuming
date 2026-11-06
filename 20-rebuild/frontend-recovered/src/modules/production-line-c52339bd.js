import { l as t } from "../shared/runtime.js";
function n(e) {
  return t({ module: "mes", url: "productionLine/page", method: "get", params: e });
}
function u(e) {
  return t({ module: "mes", url: "productionLine", method: "post", data: e });
}
function r(e) {
  return t({ module: "mes", url: "productionLine", method: "put", data: e });
}
function d(e) {
  return t({ module: "mes", url: "productionLine", method: "delete", data: { ids: e } });
}
function m({ id: e, boolEnabledEnum: o }) {
  return t({ module: "mes", url: "productionLine/changeState", method: "put", data: { id: e, boolEnabledEnum: o } });
}
function c({ productType: e, productionLineTypeEnum: o }) {
  return t({ module: "mes", url: "productionLine/type", method: "get", params: { productType: e, productionLineTypeEnum: o } });
}
function a(e) {
  return t({ module: "mes", url: "productionLine/name", method: "get", params: e });
}
const p = { get: n, add: u, edit: r, del: d };
export {
  p as c,
  m as e,
  a as g,
  c as p
};
