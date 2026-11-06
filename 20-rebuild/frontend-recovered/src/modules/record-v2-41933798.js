import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ url: "/api/v2/wms/outbound/application/record/raw-materials", method: "get", params: t });
}
function r(t) {
  return e({ module: "wms_v2", url: `outbound/application/record/raw-materials/${t}`, method: "get" });
}
function i(t) {
  return e({ module: "wms", url: `outbound/receipt/${t}/printState`, method: "get" });
}
const n = { get: o, detail: r };
export {
  n as c,
  i as o
};
