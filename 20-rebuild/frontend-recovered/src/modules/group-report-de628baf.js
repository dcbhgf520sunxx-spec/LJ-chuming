import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "mes", url: "report/product/team/summary/review", method: "get", params: e });
}
function s(e) {
  return r({ module: "mes", url: "report/product/team/summary/list", method: "get", params: e });
}
function m(e) {
  return r({ module: "mes", url: "report/workshop/process/list", method: "get", params: e });
}
const u = { get: t };
export {
  s as a,
  u as c,
  m as g
};
