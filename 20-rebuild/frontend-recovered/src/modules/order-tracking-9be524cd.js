import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "contract", url: "project/tracking", method: "get", params: e });
}
function c(e) {
  return r({ module: "contract", url: "project/tracking/record", method: "get", params: e });
}
function n(e) {
  return r({ url: "/api/project/tracking/invoice", method: "get", params: e });
}
function i(e) {
  return r({ url: "/api/project/tracking/collection", method: "get", params: e });
}
function u(e) {
  return r({ url: "/api/mes/building/warehouse/list-record", method: "get", params: e });
}
const a = { get: t };
export {
  i as a,
  a as c,
  n as i,
  c as s,
  u as w
};
