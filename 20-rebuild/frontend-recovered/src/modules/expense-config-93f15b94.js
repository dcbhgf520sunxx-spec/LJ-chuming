import { l as t } from "../shared/runtime.js";
function n(e) {
  return t({ module: "contract", url: "expenseType", method: "get", params: e, cancelKey: false });
}
function o(e) {
  return t({ module: "contract", url: "expenseType", method: "post", data: e });
}
function r(e) {
  return t({ module: "contract", url: "expenseType", method: "put", data: e });
}
function c(e) {
  return t({ module: "contract", url: "expenseType", method: "delete", data: e });
}
const d = { get: n, add: o, edit: r, del: c };
export {
  d as c,
  n as g
};
