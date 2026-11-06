import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "project", url: "reject/page", method: "get", params: e });
}
function c(e) {
  return t({ module: "project", url: "reject/detail", method: "get", params: e });
}
function n(e) {
  return t({ module: "project", url: "reject/check", method: "put", data: e });
}
function p(e) {
  return t({ module: "project", url: "reject/outCanReject/page", method: "get", params: e });
}
function a(e, r) {
  return t({ module: "project", url: "reject/save", method: "post", data: e, params: r });
}
const d = { get: o };
export {
  p as a,
  a as b,
  d as c,
  c as g,
  n as p
};
