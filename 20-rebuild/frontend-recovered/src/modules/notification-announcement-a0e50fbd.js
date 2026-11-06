import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ url: "/api/notice/list", method: "get", params: e });
}
function i(e) {
  return t({ url: "/api/notice/list/download", method: "post", responseType: "blob", data: e });
}
function c(e) {
  return t({ url: "/api/notice/detail", method: "get", params: e });
}
function r(e) {
  return t({ url: "/api/notice/create", method: "post", data: e });
}
function u(e) {
  return t({ url: "/api/notice/delete", method: "delete", params: e });
}
export {
  c as a,
  i as b,
  r as c,
  u as d,
  o as g
};
