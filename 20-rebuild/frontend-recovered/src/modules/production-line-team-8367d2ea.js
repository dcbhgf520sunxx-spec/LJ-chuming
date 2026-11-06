import { l as n } from "../shared/runtime.js";
function o(e) {
  return n({ url: "/api/mes/enclosure/productionLine/teams", method: "get", params: e });
}
function r(e) {
  return n({ url: "/api/mes/enclosure/team", method: "get", params: e });
}
function i(e) {
  return n({ url: "/api/mes/enclosure/inspectionTeam", method: "get", params: e });
}
function s(e) {
  return n({ url: "/api/mes/enclosure/productionLine/team", method: "post", data: e });
}
function u(e) {
  return n({ url: "/api/mes/enclosure/productionLine/inspection_team", method: "post", data: e });
}
export {
  u as a,
  o as g,
  i,
  r as p,
  s
};
