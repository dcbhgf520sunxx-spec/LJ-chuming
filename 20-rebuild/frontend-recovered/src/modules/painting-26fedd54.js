import { l as e } from "../shared/runtime.js";
function t(n) {
  return e({ module: "bridge", url: "kanban/painting/setting/list", method: "get", params: n });
}
function r(n) {
  return e({ module: "bridge", url: "kanban/painting/type", method: "get", params: n });
}
function i(n) {
  return e({ module: "bridge", url: "kanban/painting/box/page", method: "get", params: n });
}
function o(n) {
  return e({ module: "bridge", url: "kanban/painting/box/page/summary", method: "get", params: n });
}
function u(n) {
  return e({ module: "bridge", url: "kanban/painting", method: "post", data: n });
}
function g(n) {
  return e({ module: "bridge", url: "kanban/painting/box", method: "post", data: n });
}
const d = { get: t };
export {
  i as a,
  o as b,
  d as c,
  u as d,
  g as e,
  r as g
};
