import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ url: "/api/plan/project/getProjectList", method: "get", params: e });
}
function n(e) {
  return t({ url: "/api/plan/project/getProjectSummaryInfo", method: "get", params: e });
}
function m(e) {
  return t({ module: "plan", url: "monomer/getMonomerAndAreaByProjectId", method: "get", params: e });
}
function a(e) {
  return t({ module: "plan", url: "monomer", method: "post", data: e });
}
const u = { get: r };
export {
  m as a,
  u as c,
  n as g,
  a as s
};
