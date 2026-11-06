import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "contract", url: "project/pageProjectLedger", method: "get", params: e });
}
function c(e) {
  return t({ module: "contract", url: "project/listContractAmountRecord", method: "get", params: e });
}
function n(e) {
  return t({ module: "contract", url: "project/getLedgerSum", method: "get", params: e });
}
function u(e) {
  return t({ module: "contract", url: "project/happened/record", method: "get", params: e });
}
function m(e) {
  return t({ module: "contract", url: "project/collection_invoice/amount", method: "get", params: e });
}
const d = { get: o };
export {
  d as c,
  n as l,
  c as m,
  u as o,
  m as p
};
