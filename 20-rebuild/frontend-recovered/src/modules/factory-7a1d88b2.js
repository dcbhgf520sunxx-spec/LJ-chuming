import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ module: "mes", url: "factory/page", method: "get", params: t });
}
function u(t) {
  return e({ module: "mes", url: "factory", method: "post", data: t });
}
function a(t) {
  return e({ module: "mes", url: "factory", method: "put", data: t });
}
function m({ id: t, boolEnabledEnum: r }) {
  return e({ module: "mes", url: "factory/changeState", method: "put", data: { id: t, boolEnabledEnum: r } });
}
function c() {
  return e({ url: "/api/branchCompany/all/simple", method: "get" });
}
function n(t) {
  return e({ module: "mes", url: "factory", method: "delete", data: { ids: t } });
}
const l = { get: o, add: u, edit: a, del: n };
export {
  l as c,
  m as e,
  c as g
};
