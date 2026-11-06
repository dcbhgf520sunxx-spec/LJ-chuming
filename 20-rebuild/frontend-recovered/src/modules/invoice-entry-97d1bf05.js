import { l as e } from "../shared/runtime.js";
function n(t) {
  return e({ url: "/api/contract/supplier-settlement/v2/get-inner", method: "get", params: t });
}
function o(t) {
  return e({ url: "/api/contract/receive-invoice/v2/addPurchase", method: "post", data: t });
}
export {
  n as g,
  o as p
};
