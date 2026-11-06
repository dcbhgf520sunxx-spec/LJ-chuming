import { l as r } from "../shared/runtime.js";
function o(e) {
  return r({ module: "wms", url: "report/raw-materials/psi", method: "get", params: e });
}
function a(e) {
  return r({ module: "wms", url: "report/raw-materials/psi/detail", method: "get", params: e });
}
function s(e) {
  return r({ module: "wms", url: "report/raw-materials/psi/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
export {
  a,
  s as d,
  o as g
};
