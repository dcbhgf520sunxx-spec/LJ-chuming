import { l as t } from "../shared/runtime.js";
function i(e) {
  return t({ url: "/api/mes/inspection/getInspectionSummaryByProjectId", method: "get", params: e });
}
function s(e) {
  return t({ url: "/api/mes/inspection/getInspectionUserByProjectId", method: "get", params: e });
}
function o(e) {
  return t({ url: "/api/mes/inspection/getInspectionTaskInfo", method: "get", params: e });
}
function r(e) {
  return t({ url: "/api/mes/inspection/getInspectionTaskDetail", method: "get", params: e });
}
function a(e) {
  return t({ url: "/api/mes/map/key", method: "get", params: e });
}
export {
  s as a,
  o as b,
  r as c,
  a as d,
  i as g
};
