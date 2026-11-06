import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "project", url: "foreign/visa-settle", method: "get", params: e });
}
function u(e) {
  return t({ module: "project", url: "foreign/visa-settle/visa", method: "post", data: e });
}
function l(e) {
  return t({ module: "project", url: "foreign/visa-settle/visa", method: "put", data: e });
}
function i(e) {
  return t({ module: "project", url: "foreign/visa-settle/check", method: "put", data: e });
}
function d(e) {
  return t({ module: "project", url: "foreign/visa-settle/settle", method: "post", data: e });
}
function a(e) {
  return t({ module: "project", url: "foreign/visa-settle/settle", method: "put", data: e });
}
function r(e) {
  return t({ module: "contract", url: `visa/${e}`, method: "post" });
}
function n(e) {
  return t({ module: "contract", url: `visa/${e}/export`, method: "get", responseType: "blob" });
}
function c(e) {
  return t({ module: "project", url: `foreign/visa-settle/export-settle/${e}`, method: "get", responseType: "blob" });
}
const m = { get: o, download: n, detail: r };
export {
  u as a,
  d as b,
  m as c,
  a as d,
  l as e,
  i as f,
  c as g
};
