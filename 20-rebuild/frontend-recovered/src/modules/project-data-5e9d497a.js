import { l as u } from "../shared/runtime.js";
function e(t) {
  return u({ url: "/api/cut/getPlant", method: "get", params: t });
}
function n(t) {
  return u({ url: "/api/cut/getMachine", method: "get", params: t });
}
function r(t) {
  return u({ url: `/api/cut/getCutPart/${t}`, method: "get" });
}
function a(t) {
  return u({ url: `/api/cut/getCutSurplus/${t}`, method: "get" });
}
function s(t) {
  return u({ url: "/api/cut/suspendTask", method: "post", data: t });
}
function c(t) {
  return u({ url: "/api/cut/continueTask", method: "post", data: t });
}
const i = { get: e, getCutPart: r, continueTask: c, getCutSurplus: a, suspendTask: s, getMachine: n };
export {
  n as a,
  r as b,
  c,
  a as d,
  i as e,
  e as g
};
