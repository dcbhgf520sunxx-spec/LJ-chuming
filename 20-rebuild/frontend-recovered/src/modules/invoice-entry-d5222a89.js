import { l as t } from "../shared/runtime.js";
function c(e) {
  return t({ url: "/api/contract/receive-invoice/v2/getPurchase/SelfOwned/getPage", method: "get", params: e });
}
function o(e) {
  return t({ url: "/api/contract/receive-invoice/v2/addPurchase/SelfOwned", method: "post", data: e });
}
export {
  c as g,
  o as p
};
