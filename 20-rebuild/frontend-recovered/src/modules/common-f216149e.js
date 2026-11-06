import { l as t } from "../shared/runtime.js";
function a() {
  return t({ url: "/api/branchCompany/all/simple", method: "get" });
}
function n(e) {
  return t({ url: "/api/expenseType/by-category", method: "get", params: e });
}
function o(e) {
  return t({ url: "/api/branchCompany/all/get-branch-project-list", method: "get", params: e });
}
export {
  a,
  o as b,
  n as g
};
