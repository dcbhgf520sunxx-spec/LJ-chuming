import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "bridge", url: "productProcess/page", method: "get", params: e });
}
function n(e) {
  return r({ module: "bridge", url: "productProcess/box", method: "get", params: e });
}
function s(e) {
  return r({ module: "bridge", url: "productProcess/element", method: "get", params: e });
}
function i(e) {
  return r({ module: "bridge", url: "productProcess/machine_part", method: "get", params: e });
}
function o(e) {
  return r({ module: "bridge", url: "productProcess", method: "post", data: e });
}
function u(e) {
  return r({ module: "bridge", url: "productProcess", method: "put", data: e });
}
function d(e) {
  return r({ module: "bridge", url: "productProcess", method: "delete", data: { ids: e } });
}
const l = { get: t, add: o, edit: u, del: d };
export {
  s as a,
  i as b,
  l as c,
  n as g
};
