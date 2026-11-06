import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ module: "mes", url: "scheduling/artifact/product/monitor/kanban", method: "get", params: t });
}
function u(t) {
  return e({ module: "mes", url: "scheduling/artifact/product/monitor/kanban/summary", method: "get", params: t });
}
function n(t) {
  return e({ module: "mes", url: "scheduling/artifact/product/monitor/kanban/detail", method: "get", params: t });
}
function a(t) {
  return e({ module: "mes", url: "scheduling/artifact/product/monitor/group", method: "get", params: t });
}
function i(t) {
  return e({ module: "mes", url: "scheduling/artifact/product/monitor/group/detail", method: "get", params: t });
}
const m = { get: r };
export {
  n as a,
  a as b,
  m as c,
  i as d,
  u as g
};
