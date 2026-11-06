import { l as o } from "../shared/runtime.js";
function u(e) {
  return o({ module: "user", url: "job", method: "get", params: e });
}
function r(e) {
  return o({ module: "user", url: "job", method: "post", data: e });
}
function t(e) {
  return o({ module: "user", url: "job", method: "put", data: e });
}
function n(e) {
  return o({ module: "user", url: "job", method: "delete", data: e });
}
function d(e) {
  return o({ module: "user", url: "job/enabled", method: "put", params: e });
}
function l(e) {
  return o({ module: "user", url: "job/all", method: "get", params: e });
}
function m(e) {
  return o({ module: "user", url: "job/save/user", method: "post", data: e });
}
function a(e) {
  return o({ module: "user", url: "job/query/user", method: "get", params: e });
}
function b(e) {
  return o({ module: "user", url: "job/export", responseType: "blob", method: "get", params: e });
}
function c() {
  return o({ url: "/api/shr/call/syncSHRJob", method: "get" });
}
const i = { add: r, edit: t, del: n, get: u };
export {
  c as a,
  i as c,
  b as d,
  d as e,
  a as g,
  l as j,
  m as s
};
