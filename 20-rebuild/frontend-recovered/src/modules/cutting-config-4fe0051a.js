import { l as e } from "../shared/runtime.js";
function u(t) {
  return e({ module: "bridge", url: "cut", method: "get", params: t });
}
function r(t) {
  return e({ module: "bridge", url: "cut", method: "post", data: t });
}
function d(t) {
  return e({ module: "bridge", url: "cut", method: "put", data: t });
}
function o(t) {
  return e({ module: "bridge", url: "cut/list", method: "delete", data: t });
}
const n = { get: u, add: r, edit: d, del: o };
export {
  n as c
};
