import { l as c } from "../shared/runtime.js";
function a(t) {
  return c({ module: "wms", url: "config/wasteClassification/all", method: "get", params: t });
}
function r(t) {
  return c({ module: "contract", url: "contract/contractWaste", method: "get", params: t });
}
function e(t) {
  return c({ module: "contract", url: "contract/contractWaste", method: "post", data: t });
}
function n(t) {
  return c({ module: "contract", url: "contract/contractWaste", method: "put", data: t });
}
function u(t) {
  return c({ module: "contract", url: "contract/contractWaste", method: "delete", data: t });
}
function s(t) {
  return c({ module: "contract", url: "contract/contractWaste/summary/ledger", method: "get", params: t });
}
function l(t) {
  return c({ module: "contract", url: "contract/contractWaste/saleDetail", method: "get", params: t });
}
function m(t) {
  return c({ module: "contract", url: "contract/contractWaste/saleAmount", method: "get", params: t });
}
function i(t) {
  return c({ module: "contract", url: "contract/contractWaste/saleTotalAmount", method: "get", params: t });
}
function d(t) {
  return c({ module: "contract", url: "contract/contractWaste/collection_Invoice/amount", method: "get", params: t });
}
export {
  e as a,
  a as b,
  i as c,
  u as d,
  n as e,
  l as f,
  r as g,
  s as h,
  d as s,
  m as t
};
