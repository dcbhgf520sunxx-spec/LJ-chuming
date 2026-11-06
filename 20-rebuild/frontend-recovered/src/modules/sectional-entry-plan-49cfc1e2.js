import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "plan", url: "project-plan/page", method: "get", params: e });
}
function r(e) {
  return t({ module: "plan", url: "project-plan/count-info", method: "get", params: e });
}
function a(e) {
  return t({ module: "plan", url: "monomer/getMonomerAndAreaByProjectId", method: "get", params: { projectId: e } });
}
function l(e) {
  return t({ module: "plan", url: "project-plan/detail-batch-save", method: "post", data: e });
}
const u = { get: o };
export {
  r as a,
  u as c,
  l as d,
  a as g
};
