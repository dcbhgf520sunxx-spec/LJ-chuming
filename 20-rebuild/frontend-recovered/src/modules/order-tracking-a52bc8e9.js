import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ url: "/api/project/tracking/v2", method: "get", params: t });
}
function i(t) {
  return e({ url: "/api/project/tracking/v2/collection", method: "get", params: t });
}
function c(t) {
  return e({ url: "/api/project/tracking/v2/invoice", method: "get", params: t });
}
function n(t) {
  return e({ url: "/api/project/tracking/v2/ship", method: "get", params: t });
}
export {
  o as a,
  i as b,
  c,
  n as g
};
