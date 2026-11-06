import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "process/list", method: "get", params: e, cancelKey: false });
}
function o(e) {
  return t({ module: "mes", url: "process/createOrUpdate", method: "post", data: e });
}
function s(e) {
  return t({ module: "mes", url: "process/createOrUpdate", method: "post", data: e });
}
function u(e) {
  return t({ module: "mes", url: "process", method: "delete", data: e });
}
const d = { get: r, add: o, edit: s, del: u };
export {
  d as c,
  r as g
};
