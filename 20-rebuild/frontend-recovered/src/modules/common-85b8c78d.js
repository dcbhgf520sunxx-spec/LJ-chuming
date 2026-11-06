import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "mes", url: "warehouse/artifact/page", method: "get", params: e });
}
function u(e) {
  return r({ module: "mes", url: "warehouse/enclosure/page", method: "get", params: e });
}
function a(e) {
  return r({ module: "mes", url: "warehouse/artifact/summary", method: "get", params: e });
}
function m(e) {
  return r({ module: "mes", url: "warehouse/enclosure/summary", method: "get", params: e });
}
export {
  a,
  u as b,
  m as c,
  t as g
};
