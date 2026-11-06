import { l as t } from "../shared/runtime.js";
function a(e) {
  return t({ module: "mes", url: "kanban/tracking/summary", method: "get", params: e });
}
function r(e) {
  return t({ module: "mes", url: "kanban/tracking", method: "get", params: e });
}
function u(e) {
  return t({ module: "mes", url: "kanban/tracking/artifact/record/detail", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: "kanban/tracking/plate/record/detail", method: "get", params: e });
}
function m(e) {
  return t({ module: "mes", url: "kanban/tracking/use", method: "get", params: e });
}
function i(e) {
  return t({ module: "mes", url: "kanban/tracking/inventory", method: "get", params: e });
}
export {
  a,
  r as g,
  o,
  u as p,
  i as s,
  m as u
};
