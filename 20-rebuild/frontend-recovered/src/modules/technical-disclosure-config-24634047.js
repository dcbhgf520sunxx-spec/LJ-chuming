import { l as e } from "../shared/runtime.js";
function c(t) {
  return e({ url: "/api/config/contractTechConfig/get", method: "get", params: t });
}
function n(t) {
  return e({ url: "/api/config/contractTechConfig/edit", method: "post", data: t });
}
function i() {
  return e({ url: "/api/config/contractTechConfig/get/public", method: "get" });
}
export {
  i as a,
  n as e,
  c as g
};
