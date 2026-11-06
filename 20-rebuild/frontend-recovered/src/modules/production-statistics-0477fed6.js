import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ module: "mes", url: "analysis/production_summary", method: "get", params: t });
}
function r(t) {
  return e({ module: "mes", url: "analysis/production_summary/group", method: "get", params: t });
}
function n(t) {
  return e({ module: "mes", url: "analysis/production_summary/complete/details", method: "get", params: t });
}
function s(t) {
  return e({ module: "mes", url: "analysis/production_summary/in_production/details", method: "get", params: t });
}
function i(t) {
  return e({ module: "mes", url: "analysis/production_summary/un_production/details", method: "get", params: t });
}
const m = { get: o };
export {
  i as a,
  s as b,
  m as c,
  n as d,
  r as g
};
