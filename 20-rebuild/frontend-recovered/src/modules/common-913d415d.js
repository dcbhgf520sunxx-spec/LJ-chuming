import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "contract", url: "business", method: "put", data: e });
}
function s({ projectId: e, monomerId: c, areaId: u, type: r }) {
  return t({ module: "contract", url: "business/summary", method: "get", params: { projectId: e, monomerId: c, areaId: u, type: r } });
}
function i(e) {
  return t({ module: "contract", url: "business/check", method: "get", params: e });
}
function a({ id: e, status: c }) {
  return t({ module: "contract", url: "business/check", method: "put", data: { id: e, status: c } });
}
function m() {
  return t({ module: "contract", url: "business/check/count", method: "get" });
}
function d(e) {
  return t({ module: "contract", url: `business/check/${e}`, method: "get" });
}
function l(e) {
  return t({ module: "contract", url: "business/tempPrice", method: "get", params: e });
}
function p(e) {
  return t({ module: "contract", url: "business/tempPrice", method: "delete", data: e });
}
function h(e) {
  return t({ module: "contract", url: "business/tempPrice/commitCheck", method: "post", data: e });
}
function f(e) {
  return t({ module: "contract", url: "business/tempPrice/count", method: "get", params: e });
}
function b(e) {
  return t({ url: "/api/business/check/excel", method: "get", responseType: "blob", params: e });
}
export {
  o as a,
  f as b,
  s as c,
  i as d,
  d as e,
  p as f,
  l as g,
  b as h,
  a as i,
  m as p,
  h as s
};
