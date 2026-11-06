import { l as t } from "../shared/runtime.js";
function e(r) {
  return t({ url: "/api/v2/contract/payment/order", method: "get", params: r });
}
const c = { get: e };
export {
  c
};
