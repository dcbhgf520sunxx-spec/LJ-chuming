import { l as s } from "../shared/runtime.js";
function n(t) {
  return s({ module: "contract", url: "business/artifact", method: "get", params: t });
}
function o({ projectId: t, monomerId: e }) {
  return s({ module: "contract", url: "business/artifact/summary", method: "get", params: { projectId: t, monomerId: e } });
}
function r(t) {
  return s({ module: "contract", url: `business/artifact/${t}`, method: "get" });
}
function a(t) {
  return s({ module: "contract", url: "business/bind", method: "put", data: t });
}
function i(t) {
  return s({ module: "contract", url: "business/artifact/simple", method: "get", params: t });
}
function c(t) {
  return s({ url: `/api/business/artifact/download/${t.businessId}`, responseType: "blob", method: "get" });
}
const d = { get: n, detail: r };
export {
  o as a,
  i as b,
  d as c,
  a as d,
  c as s
};
