import { l as s } from "../shared/runtime.js";
function e(t) {
  return s({ module: "mes", url: "task/process/produce/statistics/list", method: "get", params: t });
}
function r(t) {
  return s({ module: "mes", url: "task/process/produce/statistics/process_list", method: "get", params: t });
}
function i(t) {
  return s({ module: "mes", url: "task/process/produce/statistics/detail", method: "get", params: t });
}
function c(t) {
  return s({ module: "mes", url: "task/process/produce/statistics/list/download", method: "get", responseType: "blob", params: t });
}
const u = { get: e };
export {
  i as a,
  u as c,
  c as d,
  r as g
};
