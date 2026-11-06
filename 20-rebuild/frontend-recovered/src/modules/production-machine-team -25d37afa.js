import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "team/part_team", method: "get", params: e });
}
function m(e) {
  return t({ module: "mes", url: "team/part_team", method: "post", data: e });
}
function u(e) {
  return t({ module: "mes", url: "team/part_team", method: "put", data: e });
}
function a(e) {
  return t({ module: "mes", url: "team/part_team", method: "delete", data: { ids: e } });
}
function d(e) {
  return t({ module: "mes", url: "process/partCutWayList", method: "get", params: e });
}
function n(e) {
  return t({ module: "mes", url: "team/workshopProductionLineTeamLeader", method: "get", params: e });
}
const s = { get: r, add: m, edit: u, del: a };
export {
  n as a,
  s as c,
  d as g
};
