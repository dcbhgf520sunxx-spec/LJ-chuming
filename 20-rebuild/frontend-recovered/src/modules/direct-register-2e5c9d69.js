import { l as r } from "../shared/runtime.js";
function e(t) {
  return r({ url: "/api/contract/registration/listDirect", method: "get", params: t });
}
function o(t) {
  return r({ url: "/api/contract/registration/saveDirect", method: "post", data: t });
}
function a(t) {
  return r({ url: `/api/contract/registration/judge/${t}`, method: "get" });
}
function i(t) {
  return r({ url: "/api/contract/registration/exportDirect", method: "get", responseType: "blob", params: t });
}
function c(t) {
  return r({ url: "/api/contract/catalogue/getNoSupplementAndNumber", method: "get" });
}
const u = { add: o, detail: a, get: e };
export {
  i as a,
  u as c,
  c as g
};
