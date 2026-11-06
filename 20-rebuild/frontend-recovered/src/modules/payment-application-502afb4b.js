import { l as e } from "../shared/runtime.js";
function n(t) {
  return e({ module: "contract", url: "contract/payment/list", method: "get", params: t, cancelKey: false });
}
function c(t) {
  return e({ module: "contract", url: "contract/payment/save", method: "post", data: t });
}
function r(t) {
  return e({ module: "contract", url: "contract/payment/update", method: "put", data: t });
}
function o(t) {
  return e({ module: "contract", url: "contract/payment/del-payment", method: "delete", data: t });
}
function u(t) {
  return e({ module: "contract", url: "contract/supplier-settlement/save", method: "post", data: t });
}
function l(t) {
  return e({ module: "contract", url: "contract/supplier-settlement/check", method: "put", params: t });
}
const m = { add: c, edit: r, del: o, get: n };
export {
  l as a,
  m as c,
  u as s
};
