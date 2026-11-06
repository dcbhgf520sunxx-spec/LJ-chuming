import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "project", url: "receiving/receiving-statementV2", method: "get", params: e });
}
function n(e) {
  return t({ module: "project", url: "receiving/receiving-board", method: "get", params: e });
}
function a(e) {
  return t({ module: "project", url: "receiving/receiving-install-statement", method: "get", params: e });
}
function c(e) {
  return t({ module: "project", url: "receiving/receiving-install-sum", method: "get", params: e, cancelKey: false });
}
const l = { get: r };
export {
  c as a,
  n as b,
  l as c,
  a as d
};
