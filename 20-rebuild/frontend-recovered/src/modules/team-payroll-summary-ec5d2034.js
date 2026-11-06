import { l as e } from "../shared/runtime.js";
function t(r) {
  return e({ module: "mes", url: "report-work/report-work-approved/team-wage-summary", method: "get", params: r });
}
function m(r) {
  return e({ module: "mes", url: "report-work/report-work-approved/team-wage-summary/statistics", method: "get", params: r });
}
function a(r) {
  return e({ module: "mes", url: "report-work/report-work-approved/team-production", method: "get", params: r });
}
const u = { get: t };
export {
  a,
  u as c,
  m as g
};
