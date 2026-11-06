import { l as t } from "../shared/runtime.js";
function n(e) {
  return t({ module: "mes", url: "nestingTeam/page", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: "nestingTeam/save", method: "post", data: e });
}
function u(e) {
  return t({ module: "mes", url: "nestingTeam/update", method: "put", data: e });
}
function m(e) {
  return t({ module: "mes", url: "nestingTeam/delete", method: "delete", data: { ids: e } });
}
function s(e) {
  return t({ module: "mes", url: "nestingTeam/all", method: "get", params: e });
}
function d(e) {
  return t({ module: "mes", url: "machine_part/nesting/nestConnectToServerOne", method: "post", params: e });
}
const l = { get: n, add: o, edit: u, del: m };
export {
  l as c,
  s as g,
  d as o
};
