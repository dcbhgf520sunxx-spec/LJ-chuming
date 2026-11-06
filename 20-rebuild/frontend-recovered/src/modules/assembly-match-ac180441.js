import { l as t } from "../shared/runtime.js";
function n(e) {
  return t({ module: "bridge", url: "kanban/element_matching/page", cancelKey: false, method: "get", params: e });
}
function r(e) {
  return t({ module: "bridge", url: "kanban/element_matching/detail", method: "get", params: e });
}
function o(e) {
  return t({ module: "bridge", url: "kanban/element_matching/area/product", method: "get", params: e });
}
function i(e) {
  return t({ module: "bridge", url: "kanban/element_matching/area/box", method: "get", params: e });
}
const u = { get: n };
export {
  i as a,
  u as c,
  r as d,
  o as p
};
