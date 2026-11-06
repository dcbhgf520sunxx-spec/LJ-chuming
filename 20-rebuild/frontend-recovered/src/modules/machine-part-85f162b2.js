import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "task/order/machinePart/page", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: "task/order/nesting", method: "get", responseType: "blob", params: e });
}
function s(e) {
  return t({ module: "mes", url: "task/order/drilling", method: "get", params: e });
}
function u(e) {
  return t({ module: "mes", url: "machine_part/separate", method: "get", params: e });
}
function a(e) {
  return t({ module: "mes", url: "machine_part/separate/print/sign", method: "get", params: e });
}
function i(e) {
  return t({ module: "mes", url: "task/order/machinePart/project/list", method: "get", params: e });
}
function d(e) {
  return t({ module: "mes", url: "process/partCutWayList", method: "get", params: e });
}
function m(e) {
  return t({ url: `/api/mes/building/machine_part/scheduling/task_order/revoke/${e}`, method: "delete" });
}
const l = { get: r };
export {
  a,
  u as b,
  l as c,
  m as d,
  i as e,
  d as g,
  s as p,
  o as s
};
