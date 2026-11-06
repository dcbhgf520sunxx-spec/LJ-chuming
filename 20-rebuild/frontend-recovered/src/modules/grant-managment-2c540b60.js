import { l as r } from "../shared/runtime.js";
function n(t) {
  return r({ url: "/api/contract/givingCredit/page", method: "get", params: t });
}
function e(t) {
  return r({ url: "/api/contract/givingCredit", method: "post", data: t });
}
function a(t) {
  return r({ url: "/api/contract/givingCredit", method: "put", data: t });
}
function o(t) {
  return r({ url: "/api/contract/givingCredit", method: "delete", data: t });
}
function u(t) {
  return r({ url: `/api/contract/givingCredit/${t}`, method: "get" });
}
function p(t) {
  return r({ url: "/api/contract/givingCredit/status", method: "put", params: t });
}
function c(t) {
  return r({ url: "/api/creditDetail/pageSize", method: "get", params: t });
}
function d(t) {
  return r({ url: "/api/common/attachment", method: "post", data: t, headers: { "Content-Type": "multipart/form-data" } });
}
export {
  u as a,
  a as b,
  e as c,
  o as d,
  c as e,
  n as g,
  d as i,
  p
};
