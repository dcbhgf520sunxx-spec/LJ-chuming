import { l as e } from "../shared/runtime.js";
function a(t) {
  return e({ module: "mes", url: "craft/paint-config/painting-craft-select-list", method: "get", params: t });
}
function n(t) {
  return e({ module: "mes", url: "craft/painting-craft", method: "post", data: t });
}
function r(t) {
  return e({ module: "mes", url: "craft/painting-craft", method: "put", data: t });
}
function i(t) {
  return e({ module: "mes", url: "craft/painting-craft/painting-calculation-download", method: "post", responseType: "blob", data: t });
}
function u(t) {
  return e({ module: "mes", url: "craft/painting-craft/get-surface-area", method: "get", params: t });
}
function c(t) {
  return e({ module: "mes", url: "craft/painting-craft/get-approved-list", method: "get", params: t });
}
const s = { get: a, add: n, edit: r };
export {
  a,
  c as b,
  n as c,
  s as d,
  r as e,
  u as g,
  i as p
};
