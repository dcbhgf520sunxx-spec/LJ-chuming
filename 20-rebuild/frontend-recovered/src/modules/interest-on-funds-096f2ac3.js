import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ url: "/api/project/v2/costReport/interest", method: "get", params: t });
}
function s(t) {
  return e({ url: "/api/project/v2/costReport/quarterInterest", method: "get", params: t });
}
export {
  s as a,
  o as g
};
