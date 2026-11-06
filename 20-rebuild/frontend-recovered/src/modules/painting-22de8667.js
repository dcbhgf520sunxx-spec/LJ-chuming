import { l as n } from "../shared/runtime.js";
function a(t) {
  return n({ module: "mes", url: "kanban/painting/setting/list", method: "get", params: t });
}
function r(t) {
  return n({ module: "mes", url: "kanban/painting/type", method: "get", params: t });
}
function i(t) {
  return n({ module: "mes", url: "kanban/painting/artifact/page", method: "get", params: t });
}
function u(t) {
  return n({ module: "mes", url: "kanban/painting/artifact/page/summary", method: "get", params: t });
}
function m(t) {
  return n({ module: "mes", url: "kanban/painting", method: "post", data: t });
}
function o(t) {
  return n({ module: "mes", url: "kanban/painting/artifact", method: "post", data: t });
}
const s = { get: a };
export {
  u as a,
  i as b,
  s as c,
  m as d,
  o as e,
  r as g
};
