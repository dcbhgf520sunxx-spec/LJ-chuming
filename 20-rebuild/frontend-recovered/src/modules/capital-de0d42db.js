import { l as e } from "../shared/runtime.js";
function a() {
  return e({ url: "/api/dictDetail", method: "get", params: { name: "injection_type", pageSize: 100, pageNumber: 1 } });
}
function n(t) {
  return e({ url: `/api/contract/Injection/getAssetInjectionPersonnel/${t}`, method: "get" });
}
function r(t) {
  return e({ url: "/api/contract/Injection/page", method: "get", params: t });
}
function o(t) {
  return e({ url: `/api/contract/Injection/${t}`, method: "delete" });
}
export {
  n as a,
  a as b,
  o as d,
  r as g
};
