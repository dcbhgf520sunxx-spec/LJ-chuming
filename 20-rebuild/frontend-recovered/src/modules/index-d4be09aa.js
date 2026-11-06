import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ url: "/api/project/v2/selfSupportCost/detail", method: "get", params: t });
}
function p(t) {
  return e({ url: "/api/project/v2/selfSupportCost/download", method: "get", responseType: "blob", params: t });
}
function s(t) {
  return e({ url: "/api/project/v2/selfSupportCost/detail/paymentList", method: "get", params: t });
}
export {
  s as a,
  p as c,
  r as g
};
