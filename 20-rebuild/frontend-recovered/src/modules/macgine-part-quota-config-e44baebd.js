import { l as t } from "../shared/runtime.js";
function a(e) {
  return t({ module: "mes", url: "wage-quota-management/machine-part-quota-config/page", method: "get", params: e });
}
function n(e) {
  return t({ module: "mes", url: "wage-quota-management/machine-part-quota-config", method: "post", data: e });
}
function o(e) {
  return t({ module: "mes", url: "wage-quota-management/machine-part-quota-config", method: "put", data: e });
}
function u(e) {
  return t({ module: "mes", url: "wage-quota-management/machine-part-quota-config", method: "delete", params: e });
}
function r(e) {
  return t({ module: "mes", url: "wage-quota-management/machine-part-quota-config/status", method: "put", params: e });
}
function i(e) {
  return t({ url: "/api/config/structure-steel/classification", method: "get", params: e });
}
function c() {
  return t({ module: "mes", url: "wage-quota-management/machine-part-quota-config/machine-part-process-select", method: "get" });
}
const s = { get: a, add: n, edit: o, del: u };
export {
  i as a,
  s as c,
  u as d,
  r as e,
  c as g
};
