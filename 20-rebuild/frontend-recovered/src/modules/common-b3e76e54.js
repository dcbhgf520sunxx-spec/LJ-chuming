import { l as t } from "../shared/runtime.js";
function n(e) {
  return t({ module: "mes", url: "abnormal/page", method: "get", params: e });
}
function a(e) {
  return t({ module: "mes", url: "abnormal/report", method: "get", params: e });
}
function u({ productId: e, productType: r }) {
  return t({ module: "mes", url: "abnormal/task", method: "get", params: { productId: e, productType: r } });
}
function m(e) {
  return t({ module: "mes", url: "abnormal/handle/abnormal", method: "put", data: e });
}
function l(e) {
  return t({ module: "mes", url: "abnormal/handle/task", method: "put", data: e });
}
function s(e) {
  return t({ module: "mes", url: "abnormal/handle/preview", method: "put", data: e });
}
function d(e) {
  return t({ module: "mes", url: "abnormal/preview", method: "get", params: e });
}
function i(e) {
  return t({ module: "mes", url: "abnormal/change/report", method: "get", params: e });
}
function c(e) {
  return t({ module: "mes", url: "abnormal/product/info", method: "get", params: e });
}
const p = { get: n };
export {
  i as a,
  s as b,
  p as c,
  d,
  a as e,
  m as f,
  l as g,
  c as p,
  u as t
};
