import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "scheduling/artifact/template/export", responseType: "blob", method: "get", params: e });
}
function a(e, s) {
  return t({ module: "mes", url: "scheduling/artifact/import", method: "post", headers: { "Content-Type": "multipart/form-data" }, params: s, data: e });
}
function n(e) {
  return t({ module: "mes", url: "task/order/new", method: "post", data: e });
}
function m(e) {
  return t({ module: "mes", url: "machine_part/scheduling/nest_cut/task", method: "post", data: e });
}
export {
  m as a,
  r as d,
  n as s,
  a as t
};
