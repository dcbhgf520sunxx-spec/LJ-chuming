import { l as r } from "../shared/runtime.js";
function o(e) {
  return r({ module: "mes", url: "cargo/logistics", method: "get", params: e });
}
function u(e, t) {
  return r({ module: "mes", url: `cargo/${e}/change`, method: "put", data: t });
}
function m(e) {
  return r({ module: "mes", url: `cargo/${e}/change/log`, method: "get" });
}
const l = { get: o, edit: u };
function i(e) {
  return r({ module: "mes", url: "supper/price", method: "get", params: e });
}
function c(e) {
  return r({ module: "mes", url: "supper/price", method: "post", data: e });
}
function s(e) {
  return r({ module: "mes", url: "supper/price", method: "put", data: e });
}
function n(e) {
  return r({ module: "mes", url: `supper/price/${e}`, method: "delete" });
}
function g(e) {
  return r({ module: "mes", url: `supper/price/${e}/car`, method: "get" });
}
const p = { get: i, add: c, edit: s, del: n };
export {
  m as a,
  g as b,
  l as c,
  o as g,
  p as l
};
