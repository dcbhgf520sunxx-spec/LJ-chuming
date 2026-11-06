import { l as a } from "../shared/runtime.js";
function e(t) {
  return a({ module: "plan", url: "standardPart", method: "get", params: t });
}
function r(t) {
  return a({ module: "plan", url: "standardPart", method: "put", data: [t] });
}
function n(t) {
  return a({ module: "plan", url: "standardPart", method: "post", data: t });
}
function d(t) {
  return a({ module: "plan", url: "standardPart", method: "delete", data: t });
}
function l(t) {
  return a({ module: "plan", url: "standardPart/downloadlist", responseType: "blob", method: "get", params: t });
}
function u(t) {
  return a({ module: "plan", url: "standardPart/import", responseType: "blob", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: t });
}
function s(t) {
  return a({ module: "plan", url: "standardPart/download-template", responseType: "blob", method: "get", params: t });
}
function p(t) {
  return a({ url: "/api/plan/enclosureStandardPart/v2/import", responseType: "blob", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: t });
}
function m(t) {
  return a({ module: "plan", url: "enclosureStandardPart/download-template", responseType: "blob", method: "get", params: t });
}
function i(t) {
  return a({ module: "plan", url: "enclosureStandardPart/findWmsLink", method: "get", params: t });
}
const c = { get: e, edit: r, del: d, add: n };
export {
  m as a,
  s as b,
  c,
  l as d,
  p as e,
  i as g,
  u as s
};
