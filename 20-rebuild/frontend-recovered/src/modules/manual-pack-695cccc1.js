import { l as a } from "../shared/runtime.js";
function o(e) {
  return a({ module: "mes", url: "package/artifact/use", method: "get", params: e });
}
function n(e) {
  return a({ url: "/api/mes/building/package/enclosure/use", method: "get", params: e });
}
function c(e) {
  return a({ module: "mes", url: "package/part/use", method: "get", params: e });
}
function i(e) {
  return a({ module: "mes", url: "package/auxiliary_material/use", method: "get", params: e });
}
function m(e) {
  return a({ module: "mes", url: "package", method: "post", data: e });
}
function s({ id: e, remark: t, packageLinks: u }) {
  return a({ module: "mes", url: "package", method: "put", data: { id: e, remark: t, packageLinks: u } });
}
function d({ id: e, remark: t, packageLinks: u }) {
  return a({ module: "mes", url: "package/add", method: "put", data: { id: e, remark: t, packageLinks: u } });
}
export {
  n as a,
  o as b,
  c,
  d,
  s as e,
  i as g,
  m as p
};
