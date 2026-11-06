import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "kanban/project/year/page", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: "kanban/project/process/summary", method: "get", params: e });
}
function s(e) {
  return t({ module: "mes", url: "kanban/project/process/summary/detail/page", method: "get", params: e });
}
function n(e) {
  return t({ module: "mes", url: "kanban/project/group/task/detail/page", method: "get", params: e });
}
const u = { get: r };
export {
  s as a,
  n as b,
  u as c,
  o as g
};
