import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ module: "contract", url: "contract/invoice/project", method: "get", params: t });
}
function i(t) {
  return e({ module: "contract", url: "contract/invoice/listPage", method: "get", params: t });
}
function c(t) {
  return e({ module: "contract", url: "contract/invoice/project", method: "post", params: { projectId: t.projectId }, data: t.list });
}
function r(t) {
  return e({ module: "contract", url: "contract/invoice/project", method: "put", data: t });
}
function a(t) {
  return e({ module: "contract", url: "contract/invoice/audit/project", method: "put", data: t });
}
function n(t) {
  return e({ module: "contract", url: `contract/invoice/deleteById/${t}/project`, method: "delete" });
}
function d(t) {
  return e({ module: "contract", url: "contract/invoice/getInvoiceSum", method: "get", params: t });
}
const l = { get: o, add: c, edit: r, del: n };
export {
  d as a,
  l as c,
  a as e,
  i as g
};
