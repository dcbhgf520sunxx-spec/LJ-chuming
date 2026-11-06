import { l as t } from "../shared/runtime.js";
function u(e) {
  return t({ module: "user", url: "dept/list", method: "get", params: e });
}
function d(e) {
  return t({ module: "user", url: "dept", method: "post", data: e });
}
function r(e) {
  return t({ module: "user", url: "dept", method: "put", data: e });
}
function n(e) {
  return t({ module: "user", url: "dept", method: "delete", data: e });
}
function o(e) {
  return t({ module: "user", url: "dept/all/simple", method: "get", params: e });
}
function p() {
  return t({ url: "/api/shr/call/syncSHRDept", method: "get" });
}
function i(e) {
  return t({ url: `/api/dept/enabled?id=${e.id}&enabled=${e.enabled}`, method: "put" });
}
const s = { add: d, edit: r, del: n, get: u };
export {
  i as a,
  p as b,
  s as c,
  o as d
};
