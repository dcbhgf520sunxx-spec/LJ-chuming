import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "wms_v2", url: "material/label-print/receipt-mode", method: "get", params: e });
}
function i(e) {
  return t({ module: "wms", url: `material/label-print/receipt-mode/${e}`, method: "get" });
}
const m = { get: r, detail: i };
export {
  m as c
};
