import { l as t } from "../shared/runtime.js";
function d({ id: e, productType: u }) {
  return t({ module: "mes", url: "wages/product/process", method: "get", params: { id: e, productType: u } });
}
function n({ processId: e, productId: u, productType: r, factoryId: s, productionLineId: a, workshopId: o, organizationType: m }) {
  return t({ module: "mes", url: "wages/product/process/team", method: "get", params: { processId: e, productId: u, productType: r, factoryId: s, productionLineId: a, workshopId: o, organizationType: m } });
}
function i(e) {
  return t({ module: "mes", url: "wages/product/process/wage", method: "put", data: e });
}
function l(e) {
  return t({ module: "mes", url: "wages/audit/page", method: "get", params: e });
}
function p(e) {
  return t({ module: "mes", url: `wages/audit/${e}/list`, method: "get" });
}
function g({ projectId: e, organizationType: u }) {
  return t({ module: "mes", url: "wages/audit/number", method: "get", params: { projectId: e, organizationType: u } });
}
function h(e) {
  return t({ module: "mes", url: "wages/status", method: "put", data: e });
}
export {
  l as a,
  p as b,
  g as c,
  h as d,
  i as e,
  d as p,
  n as t
};
