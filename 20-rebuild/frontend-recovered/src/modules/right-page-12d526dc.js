import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ url: `/api/v2/supply-chain/order-payment/orderDetail/${e.id}`, method: "get" });
}
function a(e) {
  return r({ url: "/api/v2/supply-chain/order-payment/orderReconciliationDetailAll", method: "get", params: e });
}
const o = { get: t };
export {
  o as c,
  a as g
};
