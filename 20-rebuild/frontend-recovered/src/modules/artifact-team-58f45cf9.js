import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "team_form/artifact_assemble", method: "get", params: e });
}
function m(e) {
  return t({ module: "mes", url: "team_form/artifact_assemble/details/page", method: "get", params: e });
}
function s(e) {
  return t({ module: "mes", url: "team_form/artifact_assemble/process/page", method: "get", params: e });
}
const o = { get: r };
export {
  o as c,
  s as d,
  m as p
};
