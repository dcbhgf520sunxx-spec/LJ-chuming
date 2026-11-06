import { l as t } from "../shared/runtime.js";
function u(e) {
  return t({ module: "system", url: "menu", method: "get", params: e });
}
function m(e) {
  return t({ module: "system", url: "menu", method: "post", data: e });
}
function n(e) {
  return t({ module: "system", url: "menu", method: "put", data: e });
}
function r(e) {
  return t({ module: "system", url: "menu", method: "delete", data: e });
}
function d(e) {
  return t({ module: "system", url: "menu/tree", method: "get", params: e });
}
const s = { add: m, edit: n, del: r, get: u };
export {
  s as c,
  d as m
};
