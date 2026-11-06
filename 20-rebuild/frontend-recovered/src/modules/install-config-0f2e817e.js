import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ module: "project", url: "install-report/updateReportMethod", method: "put", data: t });
}
function r(t) {
  return e({ module: "", url: "/api/plan/auxiliaryMaterial/class-list", method: "get", params: t });
}
function l(t) {
  return e({ module: "project", url: "install-report/auxiliaryMaterial-report", method: "put", data: t });
}
const i = { get: r };
export {
  o as a,
  i as c,
  l as e
};
