import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ url: "/api/project/v2/costReport", method: "get", params: t });
}
function a(t) {
  return e({ url: "/api/project/v2/costReport/management", method: "get", params: t });
}
function i(t) {
  return e({ url: "/api/project/v2/costReport/material", method: "get", params: t });
}
function p(t) {
  return e({ url: "/api/project/v2/costReport/other", method: "get", params: t });
}
export {
  i as a,
  p as b,
  o as c,
  a as g
};
