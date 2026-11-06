import { l as a } from "../shared/runtime.js";
function u(e) {
  return a({ module: "mes", url: "package/artifact/use", method: "get", params: e });
}
function r(e) {
  return a({ url: "/api/mes/building/package/enclosure/use", method: "get", params: e });
}
function d(e) {
  return a({ module: "mes", url: "package/part/use", method: "get", params: e });
}
function o(e) {
  return a({ module: "mes", url: "package/auxiliary_material/use", method: "get", params: e });
}
function i(e) {
  return a({ module: "mes", url: "package", method: "post", data: e });
}
function n(e) {
  return a({ module: "mes", url: "package", method: "put", data: e });
}
function c(e) {
  return a({ module: "mes", url: "package/add", method: "put", data: e });
}
function l(e) {
  return a({ module: "bridge", url: "package", method: "post", data: e });
}
function m({ data: e }) {
  return a({ module: "bridge", url: "package", method: "put", data: e });
}
function s(e) {
  return a({ module: "bridge", url: "package/add", method: "put", data: e });
}
export {
  r as a,
  u as b,
  d as c,
  c as d,
  n as e,
  m as f,
  o as g,
  l as h,
  s as i,
  i as p
};
