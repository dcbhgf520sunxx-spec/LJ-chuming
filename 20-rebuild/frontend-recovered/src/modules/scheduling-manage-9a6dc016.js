import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ url: "/api/mes/enclosure/scheduling/project_tree", method: "get", params: e });
}
function s(e) {
  return t({ module: "enclosure", url: "scheduling/category", method: "get", params: e });
}
function c(e) {
  return t({ module: "enclosure", url: "scheduling/plans", method: "get", params: e });
}
function l(e) {
  return t({ module: "enclosure", url: "scheduling/totalLength", method: "get", params: e });
}
function u(e) {
  return t({ url: "/api/mes/enclosure/scheduling/v2/list", method: "get", params: e });
}
function r(e) {
  return t({ module: "enclosure", url: "scheduling", method: "post", data: e });
}
function i(e) {
  return t({ url: "/api/mes/enclosure/scheduling/dictionary", method: "get", params: e });
}
function a(e) {
  return t({ url: "/api/mes/enclosure/scheduling/allots", method: "post", data: e });
}
const d = { get: u, add: r };
export {
  a,
  s as b,
  d as c,
  c as d,
  l as e,
  r as f,
  i as g,
  o as p
};
