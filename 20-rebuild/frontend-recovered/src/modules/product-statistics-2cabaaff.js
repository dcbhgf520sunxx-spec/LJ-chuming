import { l as s } from "../shared/runtime.js";
function e(t) {
  return s({ module: "mes", url: "task/process/produce/statistics", method: "get", params: t });
}
function r(t) {
  return s({ module: "mes", url: "task/process/produce/statistics/outBound/page", method: "get", params: t });
}
function u(t) {
  return s({ module: "mes", url: "task/process/produce/statistics/task/page", method: "get", params: t });
}
function c(t) {
  return s({ module: "mes", url: "task/process/produce/statistics/process/page", method: "get", params: t });
}
function a(t) {
  return s({ module: "mes", url: "task/process/produce/statistics/finish/page", method: "get", params: t });
}
const i = { get: e };
export {
  u as a,
  c as b,
  i as c,
  a as d,
  r as g
};
