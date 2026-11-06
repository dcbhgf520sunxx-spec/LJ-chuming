import { l as t } from "../shared/runtime.js";
function u(e) {
  return t({ module: "mes", url: "scheduling/cloudcut_result/page", method: "get", params: e });
}
function d(e) {
  return t({ module: "mes", url: "scheduling/cloudcut_job/page", method: "get", params: e });
}
function l(e) {
  return t({ module: "mes", url: "scheduling/cloudcut_job/add", method: "post", data: e });
}
function s(e) {
  return t({ module: "mes", url: "scheduling/cloudcut_job/teamList", method: "get", params: e });
}
function r(e) {
  return t({ module: "mes", url: "scheduling/cloudcut_job/delete", method: "delete", data: e });
}
function c(e) {
  return t({ module: "mes", url: "scheduling/cloudcut_result/add", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, responseType: "blob", data: e });
}
function n(e) {
  return t({ module: "mes", url: "scheduling/cloudcut_result/delete", method: "delete", data: e });
}
function m(e) {
  return t({ module: "mes", url: "team/partCutConfigTeamList/cutType", method: "get", params: e });
}
function i(e) {
  return t({ module: "mes", url: "scheduling/cloudcut_result/send", method: "post", data: e });
}
function a(e) {
  return t({ module: "mes", url: "scheduling/cloudcut_result/checkFile", method: "post", data: e });
}
const h = { get: u };
export {
  d as a,
  s as b,
  h as c,
  n as d,
  r as e,
  i as f,
  m as g,
  c as h,
  l as i,
  a as t
};
