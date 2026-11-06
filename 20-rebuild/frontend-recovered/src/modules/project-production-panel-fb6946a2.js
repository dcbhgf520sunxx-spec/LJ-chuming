import { l as o } from "../shared/runtime.js";
function c(e) {
  return o({ module: "mes", url: "production/signage/project/production/sum", method: "get", params: e });
}
function n(e) {
  return o({ module: "mes", url: "production/signage/project/page/process/product", method: "get", params: e });
}
function u(e) {
  return o({ module: "mes", url: "production/signage/project/artifact/class", method: "get", params: e });
}
function i(e) {
  return o({ module: "mes", url: "production/signage/project/part/process", method: "get", params: e });
}
function s(e) {
  return o({ module: "mes", url: "production/signage/project/process", method: "get", params: e });
}
function d(e) {
  return o({ module: "mes", url: "production/signage/project/process/product/detail", method: "get", params: e });
}
function p(e) {
  return o({ module: "mes", url: "production/signage/project/page/product/production/state", method: "get", params: e });
}
function t(e) {
  return o({ module: "mes", url: "production/signage/project/page/production/cardDisplay", method: "get", params: e });
}
function a(e) {
  return o({ module: "mes", url: "production/signage/project/page/production/cardDisplay/detail", method: "get", params: e });
}
function g(e) {
  return o({ module: "mes", url: "production/signage/project/page/production/cardDisplay/process/detail", method: "get", params: e });
}
function l(e) {
  return o({ module: "mes", url: "production/signage/project/page/process/product/download", method: "get", params: e, responseType: "blob" });
}
const m = { get: t };
export {
  g as a,
  n as b,
  m as c,
  s as d,
  l as e,
  c as f,
  a as g,
  u as h,
  d as i,
  i as j,
  p as k
};
