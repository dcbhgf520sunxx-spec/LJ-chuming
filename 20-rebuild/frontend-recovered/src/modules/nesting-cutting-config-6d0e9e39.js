import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "mes", url: "nestTeamConfig/page", method: "get", params: e });
}
function n(e) {
  return t({ module: "mes", url: "nestTeamConfig/add", method: "post", data: e });
}
function u(e) {
  return t({ module: "mes", url: "nestTeamConfig/update", method: "post", data: e });
}
function m(e) {
  return t({ module: "mes", url: "nestTeamConfig/delete", method: "post", data: { ids: e } });
}
function r(e) {
  return t({ module: "mes", url: "team/process", method: "get", params: e, cancelKey: false });
}
function s(e) {
  return t({ module: "mes", url: "nestTeamConfig/updateaAll", method: "post", params: e });
}
const a = { get: o, add: n, edit: u, del: m };
export {
  a as c,
  s as e,
  r as g
};
