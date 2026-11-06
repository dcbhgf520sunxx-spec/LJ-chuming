import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "project", url: "attendance/config/save", method: "post", data: e });
}
function a(e) {
  return t({ module: "project", url: "attendance/config/update", method: "put", data: e });
}
function d(e) {
  return t({ module: "project", url: "attendance/config/attendanceTime", method: "get", params: e });
}
function r(e) {
  return t({ url: "/api/mes/map/key", method: "get", params: e });
}
function u(e) {
  return t({ module: "project", url: "attendance/summary", method: "get", params: e });
}
function c(e) {
  return t({ module: "project", url: "attendance/dayDetails", method: "get", params: e });
}
function l(e) {
  return t({ module: "project", url: "attendance/dayDetails/download", method: "get", responseType: "blob", params: e });
}
function m(e) {
  return t({ module: "project", url: "attendance/monthDetails", method: "get", params: e });
}
function i(e) {
  return t({ module: "project", url: "attendance/monthDetails/download", method: "get", responseType: "blob", params: e });
}
export {
  c as a,
  m as b,
  i as c,
  l as d,
  r as e,
  d as f,
  u as g,
  o as h,
  a as s
};
