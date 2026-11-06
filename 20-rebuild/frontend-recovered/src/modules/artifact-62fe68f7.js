import { m4 as u, l as t } from "../shared/runtime.js";
function n(e) {
  return (e == null ? void 0 : e.manufactureType) === u.OUTSOURCE.V ? t({ url: "/api/mes/building/subscribe/print/artifact", method: "get", params: { ...e, productionLineId: void 0, manufactureType: void 0 } }) : (e == null ? void 0 : e.manufactureType) === u.HOMEMADE.V ? t({ module: "mes", url: "print/artifact", method: "get", params: { ...e, manufactureType: void 0 } }) : t({ module: "mes", url: "print/part", method: "get", params: { ...e, manufactureType: void 0 } });
}
function r(e) {
  return t({ url: "/api/mes/building/task/productionLine/hasTask", method: "get", params: e });
}
const d = { get: n };
export {
  d as c,
  r as g
};
