import { l as e } from "../shared/runtime.js";
function a(t) {
  return e({ url: "/api/cut/getMachine", method: "get", params: t });
}
function u(t) {
  return e({ url: `/api/cut/getMachine/${t}`, method: "get", cancelKey: false });
}
function r(t) {
  return e({ url: "/api/cut/addMachine", method: "post", data: t });
}
function c(t) {
  return e({ url: `api/cut/deleteMachine/${t}`, method: "delete" });
}
function i(t) {
  return e({ url: "/api/cut/updateMachine", method: "post", data: t });
}
function l(t, n) {
  return e({ url: "/api/cut/assign/", method: "post", params: t, data: n });
}
function o(t) {
  return e({ url: "/api/cut/sentTask", method: "post", data: t });
}
function s(t) {
  return e({ url: "/api/cut/resetTask", method: "post", data: t });
}
function d(t, n) {
  return e({ url: "/api/cut/cleanTask", method: "post", params: t, data: n });
}
function f(t, n) {
  return e({ url: "/api/cut/changeTask", method: "post", params: t, data: n });
}
function p(t) {
  return e({ url: `/api/cut/getMachineInformation/${t}`, method: "get" });
}
const m = { get: a, add: r, del: c, edit: i, getMac: u, sentTask: o, cleanTask: d, resetTask: s, getMachineInformation: p };
export {
  d as a,
  l as b,
  f as c,
  p as d,
  m as e,
  u as g,
  s as r,
  o as s
};
