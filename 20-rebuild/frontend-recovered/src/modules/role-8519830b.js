import { l as r } from "../shared/runtime.js";
function o(e) {
  return r({ module: "user", url: "role", method: "get", params: e });
}
function u(e) {
  return r({ module: "user", url: "role", method: "post", data: e });
}
function t(e) {
  return r({ module: "user", url: "role", method: "put", data: e });
}
function l(e) {
  return r({ module: "user", url: "role", method: "delete", data: e });
}
function s(e) {
  return r({ module: "user", url: "role/menu", method: "put", data: e });
}
function d() {
  return r({ module: "user", url: "role/all", method: "get" });
}
function i(e) {
  return r({ module: "user", url: "role/user", method: "get", params: e });
}
function m(e) {
  return r({ module: "user", url: "role/update/user", method: "put", data: e });
}
function a(e) {
  return r({ module: "user", url: "role/export", responseType: "blob", method: "get" });
}
function p(e) {
  return r({ url: "/api/role/look/permission/config/get/detail", method: "get", params: e });
}
function c(e) {
  return r({ url: "/api/role/look/permission/config/update", method: "post", data: e });
}
const f = { add: u, edit: t, del: l, get: o };
export {
  i as a,
  s as b,
  f as c,
  a as d,
  p as g,
  d as r,
  m as s,
  c as u
};
