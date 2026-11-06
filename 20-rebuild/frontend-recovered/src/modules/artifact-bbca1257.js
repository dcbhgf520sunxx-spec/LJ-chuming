import { l as o } from "../shared/runtime.js";
function n(t) {
  return o({ module: "plan", url: "artifact/listByCondition", method: "get", params: t });
}
function i(t) {
  return o({ module: "plan", url: "artifact/listByCondition/summary", method: "get", params: t });
}
function e(t) {
  return o({ module: "plan", url: "artifact/listByCondition/downLoad", method: "get", responseType: "blob", timeout: 6e7, params: t });
}
const a = { get: n, downLoad: e };
export {
  a as c,
  e as d,
  i as s
};
