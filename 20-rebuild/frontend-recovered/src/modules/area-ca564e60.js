import { l as t } from "../shared/runtime.js";
function a(e) {
  return t({ url: "/api/plan/project-plan/enclosure/page", method: "get", params: e });
}
function i(e) {
  return t({ url: `/api/enclosurePlanDetail/${e}`, method: "get" });
}
function n(e) {
  return t({ url: "/api/enclosurePlanDetail/tech", method: "get", params: e });
}
function r(e) {
  return t({ url: "/api/enclosurePlanDetail", method: "post", data: e });
}
function l(e) {
  return t({ url: "/api/enclosurePlanDetail", method: "put", data: e });
}
function o(e) {
  return t({ url: `/api/enclosurePlanDetail/${e}`, method: "delete" });
}
function c(e) {
  return t({ url: `/api/enclosurePlanDetail/tech/${e}`, method: "get" });
}
const s = { add: r, edit: l, del: o, get: n };
export {
  c as a,
  s as c,
  i as e,
  a as g
};
