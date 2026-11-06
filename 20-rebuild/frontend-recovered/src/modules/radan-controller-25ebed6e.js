import { l as t } from "../shared/runtime.js";
function a(r) {
  return t({ url: "/api/radan/getPartByProjectId", method: "get", params: r });
}
function n(r) {
  return t({ url: "/api/radan/getTaskByProjectId", method: "get", params: r });
}
function m() {
  return t({ url: "/api/radan/getProjectInfo", method: "get" });
}
function o(r, e) {
  return t({ url: "/api/radan/creatTaskPack", method: "post", data: r, params: e });
}
function u(r) {
  return t({ url: "/api/radan/getTaskPack", method: "get", params: r });
}
function d(r, e) {
  return t({ url: "/api/order/feedingOperation", method: "post", data: r, params: e });
}
function i({ cutTaskId: r }) {
  return t({ url: `/api/radan/uploadTask/${r}`, method: "get" });
}
function c(r) {
  return t({ url: "/api/radan/getPartByCutTaskId", method: "post", params: r });
}
function s(r) {
  return t({ url: `/api/order/getPartByAreaId/${r}`, method: "get" });
}
function f(r) {
  return t({ url: "/api/plan/monomer", method: "get", params: r });
}
function p(r) {
  return t({ url: "/api/plan/area", method: "get", params: r });
}
function l(r, e) {
  return t({ url: "/api/order/createOrder", method: "post", data: r, params: e });
}
const k = { get: a, area: p, ByAreaId: s, uploadTask: i, byCutTaskId: c, getTaskPack: u, creatTaskPack: o, feedingOperation: d, getTaskByProjectId: n };
export {
  s as B,
  u as a,
  c as b,
  k as c,
  n as d,
  l as e,
  d as f,
  m as g,
  p as h,
  f as m
};
