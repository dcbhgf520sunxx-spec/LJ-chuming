import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "project", url: "install-plan/listV2", method: "get", params: e });
}
function o(e) {
  return t({ module: "project", url: "install-plan/updateDivideMethod", method: "put", data: e });
}
function l(e) {
  return t({ module: "project", url: "install-plan/setSupplierV2", method: "post", data: e });
}
function u(e) {
  return t({ module: "project", url: "install-plan/getLaborOrderDetailsPage", method: "get", params: e });
}
function a(e) {
  return t({ module: "project", url: "install-plan/getCanSubSupplierProductPage", method: "get", params: e });
}
function i(e) {
  return t({ module: "project", url: "install-plan/subSupplierOrder/save", method: "post", data: e });
}
function s(e) {
  return t({ module: "project", url: "install-plan/orderDetailsDelete", method: "delete", data: e });
}
function d(e) {
  return t({ module: "project", url: "install-plan/getLaborOrderList", method: "get", params: e });
}
const p = { get: r, edit: l };
export {
  d as a,
  a as b,
  p as c,
  s as d,
  o as e,
  u as g,
  i as s
};
