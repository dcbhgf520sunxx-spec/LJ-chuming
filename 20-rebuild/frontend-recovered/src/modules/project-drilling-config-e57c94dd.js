import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ url: "api/system/project-drill-hole-config/page", method: "get", params: e });
}
function i(e) {
  return t({ url: "api/system/project-drill-hole-config/batch-delete", method: "delete", data: e });
}
function o(e) {
  return t({ url: "api/system/project-drill-hole-config", method: "post", data: e });
}
function s(e) {
  return t({ url: "api/system/project-drill-hole-config", method: "put", data: e });
}
export {
  o as a,
  i as d,
  s as e,
  r as g
};
