import { l as r } from "../shared/runtime.js";
function i(e) {
  return r({ module: "bridge", url: "cargo/logistics", method: "get", params: e });
}
function o(e, t) {
  return r({ module: "bridge", url: `cargo/${e}/change`, method: "put", data: t });
}
function s(e) {
  return r({ module: "bridge", url: `cargo/${e}/change/log`, method: "get" });
}
const l = { get: i, edit: o };
function u(e) {
  return r({ module: "bridge", url: "supper/price", method: "get", params: e });
}
function c(e) {
  return r({ module: "bridge", url: "supper/price", method: "post", data: e });
}
function d(e) {
  return r({ module: "bridge", url: "supper/price", method: "put", data: e });
}
function g(e) {
  return r({ module: "bridge", url: `supper/price/${e}`, method: "delete" });
}
function p(e) {
  return r({ module: "bridge", url: `supper/price/${e}/car`, method: "get" });
}
const m = { get: u, add: c, edit: d, del: g };
export {
  p as a,
  l as c,
  s as g,
  m as l
};
