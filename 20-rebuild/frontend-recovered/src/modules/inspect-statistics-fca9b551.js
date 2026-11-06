import { l as t } from "../shared/runtime.js";
function s(e) {
  return t({ module: "mes", url: "qhse/inspect/statistics", method: "get", params: e });
}
function n(e) {
  return t({ module: "mes", url: "qhse/source/report/list", method: "get", params: e });
}
function r(e) {
  return t({ module: "mes", url: "inspect/config/find/all/inspect_user", method: "get", params: e });
}
function u(e) {
  return t({ module: "mes", url: "qhse/inspect/total_count", method: "get", params: e });
}
function c(e) {
  return t({ module: "mes", url: "qhse/inspect/statistics/download", method: "get", responseType: "blob", params: e });
}
const i = { get: s };
export {
  u as a,
  n as b,
  i as c,
  c as d,
  r as g
};
