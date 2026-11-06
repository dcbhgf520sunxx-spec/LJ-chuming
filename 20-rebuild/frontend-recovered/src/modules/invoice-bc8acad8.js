import { l as e } from "../shared/runtime.js";
function c(t) {
  return e({ module: "contract", url: "contract/receive-invoice/list", method: "get", params: t });
}
function o(t) {
  return e({ module: "contract", url: "contract/receive-invoice", method: "post", data: t.list });
}
function r(t) {
  return e({ module: "contract", url: "contract/receive-invoice", method: "put", data: t });
}
function n(t) {
  return e({ module: "contract", url: `contract/receive-invoice/${t}`, method: "delete" });
}
function u(t) {
  return e({ module: "contract", url: "contract/receive-invoice/audit", method: "put", params: t });
}
const d = { get: c, add: o, edit: r, del: n };
export {
  d as c,
  u as e
};
