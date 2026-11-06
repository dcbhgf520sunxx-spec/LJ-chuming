import { l as r } from "../shared/runtime.js";
function i(e) {
  return e != null && e.manufactureType ? r({ url: "/api/mes/building/subscribe/print/enclosure", method: "get", params: { ...e, productionLineId: void 0, manufactureType: void 0 } }) : r({ url: "/api/mes/enclosure", method: "get", params: { ...e, manufactureType: void 0 } });
}
function c(e) {
  return r({ url: "/api/mes/enclosure/listByProjectId", method: "get", params: e });
}
function d(e) {
  return r({ url: "/api/mes/enclosure/productionLine/hasTask", method: "get", params: e });
}
function a(e) {
  return r({ url: "/api/mes/enclosure/print", method: "get", params: { taskId: e } });
}
function l(e) {
  return r({ url: `/api/mes/building/subscribe/print/record/enclosure/${e}`, method: "get" });
}
function p({ id: e, quantity: n, startTime: t, endTime: u, numberList: s }) {
  return r({ url: "/api/mes/enclosure/print", method: "post", data: { taskId: e, quantity: n, startTime: t, endTime: u, numberList: s } });
}
function m({ id: e, quantity: n, startTime: t, endTime: u, numberList: s }) {
  return r({ url: "/api/mes/building/subscribe/print/enclosure/print ", method: "post", data: { warehouseId: e, quantity: n, startTime: t, endTime: u, numberList: s } });
}
const f = { get: i };
export {
  c as a,
  p as b,
  f as c,
  a as d,
  m as e,
  l as f,
  d as g
};
