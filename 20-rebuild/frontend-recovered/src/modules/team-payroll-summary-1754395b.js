import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ module: "mes", url: "quota-config/team-salary/page", method: "get", params: t });
}
function r(t) {
  return e({ module: "mes", url: "quota-config/team-salary/summary", method: "get", params: t });
}
function m(t) {
  return e({ module: "mes", url: "quota-config/team-salary/team-production-list", method: "get", params: t });
}
const u = { get: o };
export {
  m as a,
  u as c,
  r as g
};
