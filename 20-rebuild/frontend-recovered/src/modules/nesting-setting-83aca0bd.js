import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "mes", url: "section_steel/nesting/wait/condition", method: "get", params: e });
}
function n(e) {
  return t({ module: "mes", url: "section_steel/nesting/wait/list", method: "get", params: e });
}
function i(e) {
  return t({ module: "mes", url: "section_steel/nesting/wait/no", method: "post", data: e });
}
function u(e) {
  return t({ module: "mes", url: "section_steel/nesting/wait/no", method: "get", params: e });
}
function r(e) {
  return t({ module: "mes", url: "section_steel/nesting/wait/no", method: "delete", data: e });
}
function l(e) {
  return t({ module: "mes", url: "section_steel/nesting/wait", method: "post", data: e });
}
function d(e) {
  return t({ module: "mes", url: "section_steel/nesting/wait/batch", method: "get", params: e });
}
function m(e) {
  return t({ module: "mes", url: "section_steel/nesting/wait/batch", method: "delete", data: e });
}
const c = { get: n };
export {
  u as a,
  m as b,
  c,
  r as d,
  l as e,
  o as g,
  d as n,
  i as s
};
