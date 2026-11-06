import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "cargo/ship", method: "get", params: e });
}
function u(e) {
  return t({ module: "mes", url: "cargo/ship/summary", method: "get", params: e });
}
function n(e) {
  return t({ module: "mes", url: "cargo/yearAndMonth/summary", method: "get", params: e });
}
function o({ id: e }) {
  return t({ url: `api/mes/ship/${e}/export`, method: "get", responseType: "blob" });
}
function s(e) {
  return t({ module: "mes", url: `cargo/ship/${e}`, method: "get" });
}
const a = { get: r, download: o };
export {
  n as a,
  r as b,
  a as c,
  s as d,
  u as g
};
