import { l as t } from "../shared/runtime.js";
function s(e) {
  return t({ module: "system", url: "system/bolt-sleeve/list", method: "get", params: e });
}
function o(e) {
  return t({ module: "system", url: "system/bolt-sleeve", method: "post", data: e });
}
function r(e) {
  return t({ module: "system", url: "system/bolt-sleeve", method: "put", data: e });
}
function l(e) {
  return t({ module: "system", url: `system/bolt-sleeve/${e}`, method: "delete" });
}
function i() {
  return t({ url: "/api/mes/building/process/artifact-process-list", method: "get" });
}
function n(e) {
  return t({ url: "/api/system/section/warehouse/config/simpleness/list", method: "get", params: e });
}
const m = { get: s, add: o, edit: r, del: l };
export {
  n as a,
  m as c,
  i as g
};
