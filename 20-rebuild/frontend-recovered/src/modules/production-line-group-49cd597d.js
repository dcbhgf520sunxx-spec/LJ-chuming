import { l as t } from "../shared/runtime.js";
function d(e) {
  return t({ module: "mes", url: "groups/page", method: "get", params: e });
}
function r(e) {
  return t({ module: "mes", url: "groups", method: "post", data: e });
}
function n(e) {
  return t({ module: "mes", url: "groups", method: "put", data: e });
}
function m(e) {
  return t({ module: "mes", url: "groups", method: "delete", data: { ids: e } });
}
function p({ productLineId: e, groupId: o, teamIds: u }) {
  return t({ module: "mes", url: "groups/team", method: "post", data: { id: o, teamIds: u } });
}
function a({ productLineId: e, groupId: o, teamIds: u }) {
  return t({ module: "mes", url: "groups/inspection_team", method: "post", data: { id: o, teamIds: u } });
}
const i = { get: d, add: r, edit: n, del: m };
export {
  p as a,
  i as c,
  a as p
};
