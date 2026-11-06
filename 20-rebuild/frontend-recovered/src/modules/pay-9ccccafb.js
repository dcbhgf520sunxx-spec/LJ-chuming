import { l as e } from "../shared/runtime.js";
function c(t) {
  return e({ module: "contract", url: "contract/payment/list", method: "get", params: t });
}
function n(t) {
  return e({ module: "contract", url: "contract/payment/save", method: "post", data: t });
}
function r(t) {
  return e({ module: "contract", url: "contract/payment/audit", method: "put", data: t });
}
function a(t) {
  return e({ module: "contract", url: `contract/payment/${t}`, method: "get", cancelKey: false });
}
const u = { get: c, add: n };
export {
  u as c,
  r as e,
  a as p
};
