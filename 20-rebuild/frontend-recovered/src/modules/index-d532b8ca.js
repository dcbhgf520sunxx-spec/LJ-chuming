import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "mes", url: "qhse/qhse_stats/page", method: "get", params: e });
}
function r(e) {
  return t({ module: "mes", url: "qhse/report/summary", method: "get", params: e });
}
function n(e) {
  return t({ module: "mes", url: "quality/config/tree", method: "get", params: e });
}
function a(e) {
  return t({ module: "mes", url: "qhse/export/qhse_stats", responseType: "blob", method: "get", params: e });
}
function l(e) {
  return t({ module: "mes", url: `qhse/problem/Statistics/detail/${e}/download`, responseType: "blob", method: "get" });
}
function u(e) {
  return t({ module: "mes", url: `qhse/safety/environment/detail/${e}/download`, responseType: "blob", method: "get" });
}
const m = { get: o };
export {
  a,
  n as b,
  m as c,
  l as d,
  u as e,
  r as g
};
