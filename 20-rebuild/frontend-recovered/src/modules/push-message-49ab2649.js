import { l as i } from "../shared/runtime.js";
function n(t) {
  return i({ url: "/api/notification/config/getList", method: "post", params: t });
}
function a(t, o) {
  return i({ url: "/api/notification/config", method: "post", params: t, data: o });
}
function c(t) {
  return i({ url: "/api/notification/config", method: "delete", params: t });
}
function r(t) {
  return i({ url: "/api/notification/config/getSuitableObject", method: "get", cancelKey: false, params: t });
}
function u(t) {
  return i({ url: "/api/level/config", method: "post", data: t });
}
function f(t) {
  return i({ url: `/api/notification/config/edit/status/${t}`, method: "post" });
}
const s = { get: n };
export {
  a,
  u as b,
  s as c,
  c as d,
  f as e,
  r as g
};
