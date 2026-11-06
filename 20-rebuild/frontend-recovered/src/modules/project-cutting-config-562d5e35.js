import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ url: "api/system/project-laying-off-config/page", method: "get", params: t });
}
function f(t) {
  return e({ url: "api/system/project-laying-off-config/batch-delete", method: "delete", data: t });
}
function n(t) {
  return e({ url: "api/system/project-laying-off-config", method: "post", data: t });
}
function r(t) {
  return e({ url: "api/system/project-laying-off-config", method: "put", data: t });
}
function a(t) {
  return e({ url: `/api/system/project-laying-off-config/detail/${t}`, method: "get" });
}
export {
  n as a,
  o as b,
  f as d,
  r as e,
  a as g
};
