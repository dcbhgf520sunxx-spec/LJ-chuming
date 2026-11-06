import { l as t } from "../shared/runtime.js";
function n(e) {
  return t({ module: "mes", url: "project/material/analysis/production_summary", method: "get", params: e });
}
function r(e) {
  return t({ module: "mes", url: "project/material/analysis/part/requisition", method: "get", params: e });
}
function i(e) {
  return t({ module: "wms", url: "nesting-docking/CumulativePickingMete", method: "get", params: e });
}
function u(e) {
  return t({ module: "wms", url: "nesting-docking/getProjectPicking", method: "get", params: e });
}
function m(e) {
  return t({ module: "wms", url: "nesting-docking/ProjectPickingDownload", method: "get", responseType: "blob", params: e });
}
export {
  n as a,
  i as b,
  u as c,
  m as d,
  r as g
};
