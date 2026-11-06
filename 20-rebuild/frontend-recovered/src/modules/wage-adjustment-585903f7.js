import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "report-work/wage-adjust/page", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: `report-work/wage-adjust/detail/${e}`, method: "get" });
}
const a = { get: r, detail: o };
export {
  a as c
};
