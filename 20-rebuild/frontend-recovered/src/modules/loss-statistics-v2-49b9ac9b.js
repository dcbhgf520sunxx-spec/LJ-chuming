import { l as t } from "../shared/runtime.js";
function s(e) {
  return t({ module: "mes", url: "task/loss_statistics", method: "get", params: e });
}
function r(e) {
  return t({ module: "mes", url: "task/loss_summary", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: "task/loss_statistics_detail", method: "get", params: e });
}
function i(e) {
  return t({ module: "mes", url: "task/steel_feeding_detail", method: "get", params: e });
}
function u(e) {
  return t({ module: "mes", url: "task/getReceiveDateDetail", method: "post", params: e });
}
function l(e) {
  return t({ module: "mes", url: "task/part_report_detail", method: "get", params: e });
}
const m = { get: s };
export {
  o as a,
  l as b,
  m as c,
  i as d,
  u as e,
  r as g
};
