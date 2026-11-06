import { l as r } from "../shared/runtime.js";
function e(t) {
  return r({ url: "/api/project/returnProductMain/page", method: "get", params: t });
}
function o(t) {
  return r({ url: "/api/project/returnProductMain/projectReturnChilds", method: "get", params: t });
}
function i(t) {
  return r({ url: "/api/project/returnProductMain/audit", method: "post", data: t });
}
const n = { get: e };
export {
  i as a,
  n as c,
  o as g
};
