import { l as t } from "../shared/runtime.js";
function e(n) {
  return t({ url: "/api/config/financeAmountLimit", method: "get", params: n });
}
function i(n) {
  return t({ url: "/api/config/financeAmountLimit", method: "post", data: n });
}
function u(n) {
  return t({ url: "/api/config/finance/unsettled-order/uncollected-unpaid/amount/show", method: "get", params: n });
}
function c(n) {
  return t({ url: "/api/config/finance/unsettled-order/uncollected-unpaid/amount/show", method: "post", data: n });
}
export {
  u as a,
  c as b,
  i as e,
  e as g
};
