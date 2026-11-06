import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ module: "mes", url: "project/statistics/production/summary", method: "get", params: t });
}
function i(t) {
  return e({ module: "mes", url: "project/statistics/production/detail", method: "get", params: t });
}
function s(t) {
  return e({ module: "mes", url: "project/statistics/query/condition", method: "get", params: t });
}
function c(t) {
  return e({ module: "mes", url: "project/statistics/production/task/detail", method: "get", params: t });
}
function u(t) {
  return e({ module: "mes", url: "project/statistics/production/task/sum", method: "get", params: t });
}
function n(t) {
  return e({ module: "mes", url: "project/statistics/production/task/team/sum", method: "get", params: t });
}
function a(t) {
  return e({ module: "mes", url: "project/statistics/production/task/team/detail", method: "get", params: t });
}
function d(t) {
  return e({ module: "mes", url: "project/statistics/query/process", method: "get", params: t });
}
export {
  d as a,
  c as b,
  u as c,
  a as d,
  n as e,
  r as f,
  s as g,
  i as h
};
