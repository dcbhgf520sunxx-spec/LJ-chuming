import { l as e } from "../shared/runtime.js";
function u(t) {
  return e({ module: "mes", url: "cut", method: "get", params: t });
}
function o(t) {
  return e({ module: "mes", url: "cut", method: "post", data: t });
}
function r(t) {
  return e({ module: "mes", url: "cut", method: "put", data: t });
}
function d(t) {
  return e({ module: "mes", url: "cut/list", method: "delete", data: t });
}
const n = { get: u, add: o, edit: r, del: d };
export {
  n as c
};
