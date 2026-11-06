import { l as e } from "../shared/runtime.js";
function s() {
  return e({ module: "system", url: "system/artifact-classification/list", method: "get" });
}
function i(t) {
  return e({ module: "system", url: "system/artifact-classification", method: "post", data: t });
}
function a(t) {
  return e({ module: "system", url: "system/artifact-classification", method: "put", data: t });
}
function o(t) {
  return e({ module: "system", url: `system/artifact-classification/${t}`, method: "delete", data: t });
}
const c = { get: s, add: i, edit: a, del: o };
export {
  c
};
