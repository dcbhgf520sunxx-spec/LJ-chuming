import { l as r } from "../shared/runtime.js";
function s(e) {
  return r({ module: "mes", url: "wages/reckon/page", method: "get", params: e });
}
function n({ endDate: e, startDate: t, factoryId: m, productType: o, projectId: a }) {
  return r({ module: "mes", url: "wages/reckon/summary", method: "get", params: { endDate: e, startDate: t, factoryId: m, productType: o, projectId: a } });
}
function g(e) {
  return r({ module: "mes", url: "wages/reckon/details/page", method: "get", params: e });
}
const c = { get: s };
export {
  c,
  g as d,
  n as g
};
