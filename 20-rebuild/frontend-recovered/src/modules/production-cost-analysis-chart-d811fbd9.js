import { l as t } from "../shared/runtime.js";
function r(a) {
  return t({ url: "/api/pc/operational/analysis/materialCost", method: "get", params: a });
}
function o(a) {
  return t({ url: "/api/pc/operational/analysis/threeYearsAvgInfo", method: "get", params: a });
}
function n(a) {
  return t({ url: "/api/pc/operational/analysis/yearsSummary", method: "get", params: a });
}
function i(a) {
  return t({ url: "/api/pc/operational/analysis/costList", method: "get", params: a });
}
function s(a) {
  return t({ url: "/api/pc/operational/analysis/downloadCost", method: "get", responseType: "blob", params: a });
}
export {
  r as a,
  o as b,
  i as c,
  s as d,
  n as g
};
