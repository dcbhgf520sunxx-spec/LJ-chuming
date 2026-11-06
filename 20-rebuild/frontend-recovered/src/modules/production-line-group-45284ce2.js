import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "bridge", url: "groups/page", method: "get", params: e });
}
function u(e) {
  return t({ module: "bridge", url: "groups", method: "post", data: e });
}
function n(e) {
  return t({ module: "bridge", url: "groups", method: "put", data: e });
}
function i(e) {
  return t({ module: "bridge", url: "groups", method: "delete", data: { ids: e } });
}
function m({ productLineId: e, groupId: d, teamIds: r }) {
  return t({ module: "bridge", url: "groups/team", method: "post", data: { id: d, teamIds: r } });
}
function a({ productLineId: e, groupId: d, teamIds: r }) {
  return t({ module: "bridge", url: "groups/inspection_team", method: "post", data: { id: d, teamIds: r } });
}
const s = { get: o, add: u, edit: n, del: i };
export {
  a,
  s as c,
  m as p
};
