import { l as i } from "../shared/runtime.js";
function o() {
  return i({ module: "", url: "/api/scm/supplierConfig/evaluation-category", method: "get", cancelKey: false });
}
function a(e) {
  return i({ module: "", url: "/api/scm/supplierConfig/evaluation-category", method: "put", data: e });
}
function n() {
  return i({ module: "", url: "/api/scm/supplierConfig/score-rating", method: "get", cancelKey: false });
}
function u(e) {
  return i({ module: "", url: "/api/scm/supplierConfig/score-rating", method: "post", data: e });
}
function r() {
  return i({ module: "", url: "/api/scm/supplierConfig/qualification", method: "get", cancelKey: false });
}
function l(e) {
  return i({ module: "", url: "/api/scm/supplierConfig/qualification", method: "post", data: e });
}
function c(e) {
  return i({ module: "", url: "/api/scm/supplierConfig/review-template", method: "get", params: { classifyId: e }, cancelKey: false });
}
function p(e) {
  return i({ module: "", url: "/api/scm/supplierConfig/review-template", method: "put", data: e });
}
export {
  n as a,
  u as b,
  r as c,
  l as d,
  a as e,
  c as f,
  o as g,
  p as h
};
