import { l as e } from "../shared/runtime.js";
function n(t) {
  return e({ url: "/api/mes/building/kanban/tracking/wastage", method: "get", params: t });
}
function i(t) {
  return e({ url: "/api/mes/building/kanban/tracking/wastageCollect", method: "get", params: t });
}
function a(t) {
  return e({ url: "/api/mes/building/kanban/tracking/steelProduction/record", method: "get", params: t });
}
function o(t) {
  return e({ url: "/api/wms/receiveDate/getReceiveDateDetail", method: "post", data: t });
}
function u(t) {
  return e({ url: "/api/mes/building/kanban/tracking/steelProduction/recordTotalWeight", method: "get", params: t });
}
function s(t) {
  return e({ url: "/api/mes/building/kanban/tracking/wastage/export", method: "get", responseType: "blob", params: t });
}
function c(t) {
  return e({ url: "/api/mes/building/kanban/tracking/steelProduction/export", method: "get", responseType: "blob", params: t });
}
const l = { get: n };
export {
  c as a,
  i as b,
  l as c,
  u as g,
  s as l,
  a as p,
  o as r
};
