import { l as o } from "../shared/runtime.js";
function r(e) {
  return o({ module: "mes", url: "labor-management/behavior-score/page", method: "get", params: e });
}
function t(e) {
  return o({ module: "mes", url: "labor-management/behavior-score/save-behavior-total-score", method: "post", data: e });
}
function n(e) {
  return o({ module: "mes", url: "labor-management/behavior-score/behavior-total-score-info", method: "get", params: e });
}
function m(e) {
  return o({ module: "mes", url: "labor-management/behavior-score/violation-record", method: "get", params: e });
}
function s(e) {
  return o({ module: "mes", url: "labor-management/behavior-score/set-employee-behavior-total-score", method: "put", params: e });
}
const l = { get: r };
export {
  s as a,
  n as b,
  l as c,
  m as g,
  t as s
};
