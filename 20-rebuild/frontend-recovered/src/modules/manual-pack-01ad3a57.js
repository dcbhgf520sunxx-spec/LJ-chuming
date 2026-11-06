import { l as t } from "../shared/runtime.js";
function d(e) {
  return t({ module: "bridge", url: "package/box/use", method: "get", params: e });
}
function o(e) {
  return t({ module: "bridge", url: "package/part/use", method: "get", params: e });
}
function i(e) {
  return t({ module: "bridge", url: "package", method: "post", data: e });
}
function n({ id: e, remark: a, packageLinks: r }) {
  return t({ module: "bridge", url: "package", method: "put", data: { id: e, remark: a, packageLinks: r } });
}
function c({ id: e, remark: a, packageLinks: r }) {
  return t({ module: "bridge", url: "package/add", method: "put", data: { id: e, remark: a, packageLinks: r } });
}
export {
  o as a,
  c as b,
  n as e,
  d as g,
  i as p
};
