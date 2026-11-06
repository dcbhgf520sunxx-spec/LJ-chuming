import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "report-work/material-feeding-report/page", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: "report-work/material-feeding-report", method: "post", data: e });
}
function i(e) {
  return t({ module: "mes", url: "report-work/material-feeding-report/detail", method: "get", params: e });
}
function l(e) {
  return t({ module: "mes", url: "report-work/material-feeding-report/artifact-class_list", method: "get", params: e });
}
function s(e) {
  return t({ module: "mes", url: "report-work/material-feeding-report/have-list-data-project-list", method: "get", params: e });
}
const m = { get: r, add: o };
export {
  s as a,
  l as b,
  m as c,
  o as d,
  i as g
};
