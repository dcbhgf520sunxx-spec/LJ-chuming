import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "productProcess/page", method: "get", params: e });
}
function d(e) {
  return t({ module: "mes", url: "productProcess/v2/artifact", method: "get", params: e });
}
function l(e) {
  return t({ module: "mes", url: "productProcess/v2/assemble", method: "get", params: e });
}
function m(e) {
  return t({ module: "mes", url: "productProcess/v2/machine_part", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: "productProcess", method: "post", data: e });
}
function s(e) {
  return t({ module: "mes", url: "productProcess/update2", method: "put", data: e });
}
function u(e) {
  return t({ module: "mes", url: "productProcess", method: "delete", data: { ids: e } });
}
function n(e) {
  return t({ module: "mes", url: "productProcess/classPorcessLink", method: "get", params: e });
}
function a(e) {
  return t({ module: "mes", url: "team/workshop/process/leader", method: "get", params: e });
}
function p(e) {
  return t({ module: "mes", url: "productProcess/applyAllList", method: "get", params: e });
}
function i(e) {
  return t({ module: "mes", url: "productProcess/applyAll ", method: "post", data: e });
}
const g = { get: r, add: o, edit: s, del: u };
export {
  l as a,
  m as b,
  g as c,
  n as d,
  i as e,
  a as f,
  d as g,
  p as h
};
