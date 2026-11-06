import { l as e } from "../shared/runtime.js";
function u(t) {
  return e({ module: "mes", url: "cut/list/laying", method: "get", params: t });
}
function l(t) {
  return e({ module: "mes", url: "cut/list/laying", method: "post", data: t });
}
function d(t) {
  return e({ module: "mes", url: "cut/list/laying", method: "put", data: t });
}
function o(t) {
  return e({ module: "mes", url: "cut/list/laying", method: "delete", data: t });
}
function n(t) {
  return e({ module: "mes", url: "cut/detail", method: "post", data: t });
}
function r(t) {
  return e({ module: "mes", url: "cut/detail", method: "put", data: t });
}
function m(t) {
  return e({ module: "mes", url: "cut/detail", method: "delete", data: t });
}
const a = { get: u, add: l, edit: d, del: o };
export {
  n as a,
  a as c,
  m as d,
  r as e
};
