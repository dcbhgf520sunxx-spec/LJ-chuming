import { l as a } from "../shared/runtime.js";
function t(e) {
  return a({ module: "mes", url: "kanban/assemble_matching/page", cancelKey: false, method: "get", params: e });
}
function m(e) {
  return a({ module: "mes", url: "kanban/assemble_matching/detail", method: "get", params: e });
}
function r(e) {
  return a({ module: "mes", url: "kanban/assemble_matching/area/product", method: "get", params: e });
}
const o = { get: t };
export {
  o as c,
  m as d,
  r as p
};
