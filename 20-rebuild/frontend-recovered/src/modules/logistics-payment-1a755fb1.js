import { l as e } from "../shared/runtime.js";
function n(t) {
  return e({ module: "contract", url: "contract/payment/list", method: "get", params: t, cancelKey: false });
}
function o(t) {
  return e({ module: "contract", url: "supply-chain/logistics-payment/save", method: "post", data: t });
}
function a(t) {
  return e({ module: "contract", url: "supply-chain/logistics-payment/update", method: "post", data: t });
}
function c(t) {
  return e({ module: "contract", url: "contract/payment/del-payment", method: "delete", data: t });
}
function l(t) {
  return e({ module: "contract", url: "supply-chain/logistics-payment/list-info", method: "get", params: t });
}
const u = { add: o, edit: a, del: c, get: n };
export {
  o as a,
  u as c,
  n as g,
  l as p
};
