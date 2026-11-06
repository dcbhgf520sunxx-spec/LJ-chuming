import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "project", url: "manage/roster/page", method: "get", params: e });
}
function n(e) {
  return t({ module: "project", url: "manage/roster/updateStatus", method: "put", params: e });
}
function a(e) {
  return t({ module: "project", url: "manage/roster/getRosterInfo", method: "get", params: e });
}
function u(e) {
  return t({ module: "common", url: `attachment/${e}`, method: "get" });
}
function s(e) {
  return t({ url: "/api/user/get-user-by-phone", method: "get", params: e });
}
function m(e) {
  return t({ module: "project", url: "manage/roster", method: "post", data: e, cancelKey: false });
}
function c(e) {
  return t({ module: "project", url: "manage/roster", method: "put", data: e });
}
function d(e) {
  return t({ module: "project", url: "manage/roster", method: "delete", params: e });
}
function l(e) {
  return t({ module: "project", url: "manage/roster/age-statistics", method: "get", params: e });
}
function g(e) {
  return t({ module: "project", url: "manage/roster/nation-list", method: "get", params: e });
}
function i(e) {
  return t({ module: "project", url: "manage/roster/qr-code/print", method: "get", params: e });
}
function p(e) {
  return t({ url: "/api/project/manage/roster/download", method: "get", params: e, responseType: "blob" });
}
const f = { get: r };
export {
  p as a,
  l as b,
  f as c,
  d,
  c as e,
  s as f,
  g,
  u as h,
  a as i,
  i as j,
  m as l,
  n as u
};
