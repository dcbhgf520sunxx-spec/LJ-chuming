import { l as e } from "../shared/runtime.js";
function u(t) {
  return e({ module: "contract", url: "contract/payment/list", method: "get", params: t, cancelKey: false });
}
function n(t) {
  return e({ module: "project", url: "sub-payment", method: "post", data: t });
}
function o(t) {
  return e({ module: "project", url: "sub-payment", method: "put", data: t });
}
function r(t) {
  return e({ module: "contract", url: "contract/payment/del-payment", method: "delete", data: t });
}
function a(t) {
  return e({ module: "project", url: "sub-payment/settle", method: "post", data: t });
}
function l(t) {
  return e({ module: "project", url: "sub-payment/settle", method: "put", data: t });
}
function m(t) {
  return e({ module: "project", url: "sub-payment/check-payment", method: "put", data: t });
}
function d(t) {
  return e({ module: "project", url: "sub-payment/check-settle", method: "put", params: t });
}
const p = { add: n, edit: o, get: u, del: r };
export {
  l as a,
  p as b,
  d as c,
  m as e,
  a as s
};
