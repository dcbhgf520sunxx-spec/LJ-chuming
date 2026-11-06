import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "package/page", method: "get", params: e });
}
function d(e) {
  return t({ module: "mes", url: `package/${e}`, method: "get" });
}
function o(e) {
  return t({ module: "mes", url: "package", method: "delete", data: { ids: [e] } });
}
export {
  o as a,
  d,
  r as g
};
