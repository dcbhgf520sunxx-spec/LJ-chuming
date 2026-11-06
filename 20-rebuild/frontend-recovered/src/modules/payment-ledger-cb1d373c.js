import { l as t } from "../shared/runtime.js";
function n(e) {
  return t({ url: "/api/v2/supply-chain/order-payment", method: "get", params: e });
}
function c(e) {
  return t({ module: "contract", url: "supply-chain/order-payment/sumBySupplier", method: "get", params: e });
}
function o(e) {
  return t({ module: "contract", url: "contract/payment/list", method: "get", params: e, cancelKey: false });
}
function a(e) {
  return t({ module: "contract", url: "contract/receive-invoice/list", method: "get", params: e, cancelKey: false });
}
function u(e) {
  return t({ url: "/api/v2/supply-chain/order-payment/listInbound", method: "get", params: e, cancelKey: false });
}
const i = { get: n };
export {
  a,
  c as b,
  i as c,
  n as g,
  u as i,
  o as p
};
