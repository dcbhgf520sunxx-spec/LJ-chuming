import { l as e } from "../shared/runtime.js";
function a(t) {
  return e({ module: "mes", url: "wage-quota-management/artifact-quota-config/page", method: "get", params: t });
}
function o(t) {
  return e({ module: "mes", url: "wage-quota-management/artifact-quota-config", method: "post", data: t });
}
function u(t) {
  return e({ module: "mes", url: "wage-quota-management/artifact-quota-config", method: "put", data: t });
}
function m(t) {
  return e({ module: "mes", url: "wage-quota-management/artifact-quota-config/status", method: "put", params: t });
}
function n(t) {
  return e({ module: "mes", url: "wage-quota-management/artifact-quota-config", method: "delete", params: t });
}
function c(t) {
  return e({ module: "mes", url: "productProcess/artifact-type-process-select", method: "get", params: t });
}
const s = { get: a, add: o, edit: u, del: n };
export {
  s as c,
  n as d,
  m as e,
  c as g
};
