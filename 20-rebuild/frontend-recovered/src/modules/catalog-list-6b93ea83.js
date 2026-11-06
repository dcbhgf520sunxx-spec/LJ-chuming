import { l as a } from "../shared/runtime.js";
function e(t) {
  return a({ url: "/api/contract/catalogue/list", method: "get", params: t });
}
function o(t) {
  return a({ url: "/api/contract/catalogue/edit", method: "put", data: t });
}
function r(t) {
  return a({ url: `/api/contract/catalogue/${t}`, method: "get" });
}
function n(t) {
  return a({ url: "/api/contract/catalogue/editContractNumber", method: "put", data: t });
}
function u(t) {
  return a({ url: "/api/contract/catalogue/export", method: "get", responseType: "blob", params: t });
}
function i(t) {
  return a({ url: `/api/contract/catalogue/cancellation/${t.id}/${t.reviewStatus}`, method: "put" });
}
const l = { get: e, edit: o, detail: r };
export {
  u as a,
  i as b,
  l as c,
  n as d,
  o as e
};
