import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ url: "/api/plan/inventory/record/inventory/list", method: "get", params: e });
}
function o(e) {
  return r({ url: "/api/plan/inventory/record/inventory/check", method: "put", data: e });
}
function i(e) {
  return r({ url: "/api/plan/inventory/record/inventory/detail", method: "get", params: e });
}
function a(e) {
  return r({ module: "plan", url: "inventory/record/export", responseType: "blob", method: "get", params: e });
}
const d = { get: t };
export {
  a,
  o as b,
  d as c,
  i as d
};
