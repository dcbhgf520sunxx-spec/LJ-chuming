import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "user", url: "user", method: "get", params: e });
}
function u(e) {
  return r({ module: "user", url: "user", method: "post", data: e });
}
function o(e) {
  return r({ module: "user", url: "user", method: "put", data: e });
}
function s(e) {
  return r({ module: "user", url: "user", method: "delete", data: e });
}
function d(e) {
  return r({ module: "user", url: "user/enabled", method: "put", data: e });
}
function a() {
  return r({ url: "/api/shr/call/syncSHRUser", method: "get" });
}
function l(e) {
  return r({ module: "user", url: "user/resetToDefaultPassword", method: "put", data: { userId: e } });
}
function p(e) {
  return r({ url: "/api/shrUserChangeRecord/getChangeRecordAll", method: "get", params: e });
}
function i(e) {
  return r({ url: "/api/user/online/time/export", method: "get", responseType: "blob", params: e });
}
function m(e) {
  return r({ url: "/api/user/template/export", responseType: "blob", method: "get" });
}
function c(e) {
  return r({ url: "/api/user/import", responseType: "blob", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function f(e) {
  return r({ module: "user", url: "user/update/user/type", method: "post", params: e });
}
const h = { add: u, edit: o, del: s, get: t };
export {
  f as a,
  i as b,
  h as c,
  m as d,
  d as e,
  a as f,
  p as g,
  l as r,
  c as u
};
