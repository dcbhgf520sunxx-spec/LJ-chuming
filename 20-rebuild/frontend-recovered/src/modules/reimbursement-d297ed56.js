import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ module: "contract", url: "contract/reimbursement/listPage", method: "get", params: t });
}
function n(t) {
  return e({ module: "contract", url: "contract/reimbursement/save", method: "post", data: t });
}
function u(t) {
  return e({ module: "contract", url: "contract/reimbursement/update", method: "put", data: t });
}
function c(t) {
  return e({ module: "contract", url: "contract/reimbursement/confirm", method: "put", data: t });
}
function m() {
  return e({ module: "contract", url: "contract/reimbursement/getSumPayAmount", method: "get" });
}
const a = { get: r, add: n, edit: u };
export {
  u as a,
  a as c,
  c as e,
  m as r
};
