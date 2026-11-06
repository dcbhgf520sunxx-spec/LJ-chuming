import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ module: "plan", url: "machinePart/list-summary", method: "get", params: t });
}
function n(t) {
  return e({ module: "plan", url: "machinePart/listByCondition", method: "get", params: t });
}
function a(t) {
  return e({ module: "plan", url: "machinePart/list-summary/export", responseType: "blob", method: "get", params: t });
}
function l(t) {
  return e({ module: "plan", url: "machinePart/listByCondition/export", responseType: "blob", method: "get", params: t });
}
const i = { get: r };
export {
  l as a,
  i as c,
  a as d,
  n as p
};
