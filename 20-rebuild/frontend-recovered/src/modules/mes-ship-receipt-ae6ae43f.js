import { l as e } from "../shared/runtime.js";
function n(t) {
  return e({ url: "/api/wms/shipment/getWmsShipment", method: "get", params: t });
}
function r(t) {
  return e({ url: "/api/wms/shipment/getRelationType", method: "get", params: t });
}
function i(t) {
  return e({ url: "/api/wms/shipment/getWmsShipmentByIds", method: "get", params: t });
}
function a(t) {
  return e({ url: `/api/wms/shipment/getOutboundDetails/${t}`, method: "get" });
}
function m(t) {
  return e({ url: "/api/wms/shipment/getInventory", method: "get", params: t, cancelKey: false });
}
function u(t) {
  return e({ url: "/api/wms/shipment/save", method: "post", data: t });
}
const o = { get: n, detail: i };
export {
  o as c,
  i as d,
  m as g,
  r as j,
  u as o,
  a as r
};
