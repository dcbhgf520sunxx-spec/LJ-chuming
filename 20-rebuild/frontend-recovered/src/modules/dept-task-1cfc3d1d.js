import { l as e } from "../shared/runtime.js";
function n(t) {
  return e({ url: "/api/plan/technology/getProjectInfo", method: "get", params: t });
}
function o(t) {
  return e({ url: "/api/plan/technology", method: "get", params: t });
}
function a(t) {
  return e({ url: "/api/plan/technology", method: "post", data: t });
}
const c = { get: o };
export {
  a,
  c,
  n as g
};
