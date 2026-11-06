import { l as e } from "../shared/runtime.js";
function u(t) {
  return e({ module: "bridge", url: "cut/list/laying", method: "get", params: t });
}
function d(t) {
  return e({ module: "bridge", url: "cut/list/laying", method: "post", data: t });
}
function i(t) {
  return e({ module: "bridge", url: "cut/list/laying", method: "put", data: t });
}
function l(t) {
  return e({ module: "bridge", url: "cut/list/laying", method: "delete", data: t });
}
function o(t) {
  return e({ module: "bridge", url: "cut/detail", method: "post", data: t });
}
function n(t) {
  return e({ module: "bridge", url: "cut/detail", method: "put", data: t });
}
function a(t) {
  return e({ module: "bridge", url: "cut/detail", method: "delete", data: t });
}
const c = { get: u, add: d, edit: i, del: l };
export {
  o as a,
  c,
  a as d,
  n as e
};
