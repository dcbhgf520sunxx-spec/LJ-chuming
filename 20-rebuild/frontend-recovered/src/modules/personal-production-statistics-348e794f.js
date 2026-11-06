import { l as o } from "../shared/runtime.js";
function r(e) {
  return o({ module: "mes", url: "report/user/production/summary", method: "get", params: e });
}
function u(e) {
  return o({ module: "mes", url: "report/user/production/summary/download", method: "get", params: e, responseType: "blob" });
}
function d(e) {
  return o({ module: "mes", url: "report/user/production/detail", method: "get", params: e });
}
function n(e) {
  return o({ module: "mes", url: "report/user/production/detail/download", method: "get", params: e, responseType: "blob" });
}
const s = { get: r };
export {
  s as c,
  n as d,
  d as g,
  u as s
};
