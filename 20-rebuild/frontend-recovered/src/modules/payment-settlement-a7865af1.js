import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ url: "/api/v2/contract/payment/addSelf-owned", method: "post", data: t });
}
function n(t) {
  return e({ url: "/api/v2/contract/payment/getSupplierList", method: "get" });
}
function o(t) {
  return e({ url: "/api/v2/contract/payment/lists", method: "get", params: t });
}
function a(t) {
  return e({ url: "/api/v2/contract/payment/listDetails", method: "get", params: t });
}
function i(t) {
  return e({ url: "/api/contract/supplier-settlement/v2/getSelfEmployed", method: "get", params: t });
}
function l(t) {
  return e({ url: "/api/contract/supplier-settlement/v2/selfEmployed", method: "post", data: t });
}
function s(t) {
  return e({ url: "/api/contract/supplier-settlement/v2/selfEmployed/preSettle", method: "post", data: t });
}
export {
  n as a,
  o as b,
  i as c,
  l as d,
  s as e,
  a as g,
  r as p
};
