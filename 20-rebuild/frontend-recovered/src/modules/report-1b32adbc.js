import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "mes", url: "warehouse/report", method: "get", params: e });
}
function u(e) {
  return r({ module: "mes", url: "warehouse/report/summary", method: "get", params: e });
}
function m(e) {
  return r({ module: "mes", url: "warehouse/report/enclosure", method: "get", params: e });
}
function s(e) {
  return r({ module: "mes", url: "warehouse/report/artifact", method: "get", params: e });
}
const a = { get: t };
export {
  m as a,
  s as b,
  a as c,
  u as g
};
