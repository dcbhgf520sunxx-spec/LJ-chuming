import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ module: "plan", url: "CappCraftCardStorehouse/list", method: "get", params: t });
}
function a(t) {
  return e({ module: "plan", url: "CappCraftCardStorehouse/add", method: "post", data: t });
}
function o(t) {
  return e({ module: "plan", url: "CappCraftCardStorehouse/update", method: "post", data: t });
}
function u(t) {
  return e({ module: "plan", url: "CappCraftCardStorehouse/delete", method: "delete", data: t });
}
function d(t) {
  return e({ module: "plan", url: `CappCraftCardStorehouse/detail?id=${t}`, method: "get" });
}
function n(t) {
  return e({ module: "plan", url: `CappCraftCardStorehouse/detail/list?ids=${t}`, method: "get" });
}
function p(t) {
  return e({ module: "plan", url: "CappCraftCardStorehouse/update/status", method: "post", data: t });
}
function s(t) {
  return e({ module: "plan", url: "CappCraftCardStorehouse/simple/list", method: "get", params: t });
}
const i = { get: r, add: a, edit: o, del: u, detail: d };
export {
  n as a,
  i as c,
  p as e,
  s as g
};
