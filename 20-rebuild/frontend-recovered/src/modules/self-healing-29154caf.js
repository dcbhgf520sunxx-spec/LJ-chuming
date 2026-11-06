import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ url: "/api/project/v2/projectSelfEmployed", method: "get", params: { ...e, level: 2 } });
}
function p(e) {
  return t({ url: "/api/project/v2/getProjectAttributeList", method: "get", params: { ...e, projectAttribute: "1", level: 2 } });
}
function i(e) {
  return t({ url: "/api/project/v2/projectSelfOwned", method: "get", params: { ...e, level: 2 } });
}
export {
  p as a,
  i as b,
  o as g
};
