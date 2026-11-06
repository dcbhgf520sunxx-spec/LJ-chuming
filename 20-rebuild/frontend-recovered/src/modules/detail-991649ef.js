import { l as t } from "../shared/runtime.js";
function i(e) {
  return t({ url: "/api/project/v2/projectLedger/supplierLedger/paymentList", method: "get", params: e });
}
function p(e) {
  return t({ url: "/api/project/v2/projectLedger/supplierLedger/invoiceList", method: "get", params: e });
}
function o(e) {
  return t({ url: "/api/project/v2/projectLedger/supplierLedger/settleList", method: "get", params: e });
}
export {
  p as a,
  o as b,
  i as g
};
