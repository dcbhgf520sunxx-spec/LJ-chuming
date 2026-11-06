import { l as i } from "../shared/runtime.js";
function e(t) {
  return i({ module: "mes", url: "daily/statistics/production/task/sum", method: "get", params: t });
}
function o(t) {
  return i({ module: "mes", url: "daily/statistics/production/task/sum/print", method: "get", responseType: "blob", params: t });
}
function u(t) {
  return i({ module: "mes", url: "daily/statistics/query/condition", method: "get", params: t });
}
function r(t) {
  return i({ module: "mes", url: "daily/statistics/production/pack/detail", method: "get", params: t });
}
function n(t) {
  return i({ module: "mes", url: "daily/statistics/production/detail", method: "get", params: t });
}
const a = { get: e };
export {
  r as a,
  n as b,
  a as c,
  o as d,
  u as g
};
