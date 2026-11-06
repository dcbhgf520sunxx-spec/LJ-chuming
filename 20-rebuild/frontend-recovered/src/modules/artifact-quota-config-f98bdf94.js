import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ module: "mes", url: "quota-config/artifact/page", method: "get", params: t });
}
function r(t) {
  return e({ module: "mes", url: "quota-config/artifact", method: "post", data: t });
}
function u(t) {
  return e({ module: "mes", url: "quota-config/artifact", method: "put", data: t });
}
function c(t) {
  return e({ module: "mes", url: "quota-config/artifact", method: "delete", params: t });
}
function n(t) {
  return e({ module: "mes", url: "productProcess/artifact-type-process-select", method: "get", params: t });
}
const i = { get: o, add: r, edit: u, del: c };
export {
  i as c,
  c as d,
  n as g
};
