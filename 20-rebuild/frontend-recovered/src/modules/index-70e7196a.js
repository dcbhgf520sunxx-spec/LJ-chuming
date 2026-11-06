import { l as a } from "../shared/runtime.js";
function o(t) {
  return a({ url: "/api/oa/flow/getFixedData", method: "get", params: t });
}
function r(t) {
  return a({ url: "/api/oa/flow/doCreatePurchasePayment", method: "post", data: t });
}
function u(t) {
  return a({ url: "/api/oa/flow/doCreatePurchaseSettleAccounts/manufacturedGoods", method: "post", data: t });
}
function p(t) {
  return a({ url: "/api/oa/flow/doCreatePurchaseSettleAccounts/rawMaterial", method: "post", data: t });
}
function n(t) {
  return a({ url: "/api/oa/flow/updateRequestId", method: "put", data: t });
}
export {
  u as a,
  p as b,
  n as c,
  o as g,
  r as p
};
