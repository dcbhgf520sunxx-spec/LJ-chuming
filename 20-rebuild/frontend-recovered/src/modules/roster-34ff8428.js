import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "labor-management/roster/page", method: "get", params: e });
}
function n(e) {
  return t({ module: "mes", url: "labor-management/roster/updateStatus", method: "put", params: e });
}
function a(e) {
  return t({ module: "mes", url: "labor-management/roster/getRosterInfo", method: "get", params: e });
}
function m(e) {
  return t({ module: "common", url: `attachment/${e}`, method: "get" });
}
function u(e) {
  return t({ url: "/api/user/get-user-by-phone", method: "get", params: e });
}
function s(e) {
  return t({ module: "mes", url: "labor-management/roster", method: "post", data: e });
}
function l(e) {
  return t({ module: "mes", url: "labor-management/roster", method: "put", data: e });
}
function d(e) {
  return t({ module: "mes", url: "labor-management/roster", method: "delete", params: e });
}
function g(e) {
  return t({ module: "mes", url: "labor-management/roster/age-statistics", method: "get", params: e });
}
function i(e) {
  return t({ module: "mes", url: "labor-management/roster/nation-list", method: "get", params: e });
}
function c(e) {
  return t({ module: "mes", url: "labor-management/roster/qr-code/print", method: "get", params: e });
}
function h(e) {
  return t({ module: "mes", url: "labor-management/roster/download", method: "get", responseType: "blob", params: e });
}
const b = { get: r };
export {
  i as a,
  g as b,
  b as c,
  d,
  u as e,
  l as f,
  m as g,
  a as h,
  c as i,
  s as l,
  h as r,
  n as u
};
