import { l as t } from "../shared/runtime.js";
function s(e) {
  return t({ module: "system", url: "permission/type", method: "get", params: e });
}
function o(e) {
  return t({ module: "system", url: "permission/type", method: "post", data: e });
}
function r(e) {
  return t({ module: "system", url: "permission/type", method: "put", data: e });
}
function m(e) {
  return t({ module: "system", url: "permission/type", method: "delete", data: e });
}
function u(e) {
  return t({ module: "system", url: "permission/type", method: "get", params: e });
}
const i = { add: o, edit: r, del: m, get: s };
export {
  i as c,
  u as p
};
