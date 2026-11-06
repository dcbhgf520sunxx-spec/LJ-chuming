import { l as e } from "../shared/runtime.js";
function t(a) {
  return e({ url: "/api/dynamics/list", method: "get", params: a });
}
function i(a) {
  return e({ url: "/api/dynamics/list/download", method: "post", responseType: "blob", data: a });
}
function o(a) {
  return e({ url: "/api/dynamics/detail", method: "get", params: a });
}
function s(a) {
  return e({ url: "/api/dynamics/create", method: "post", data: a });
}
function m(a) {
  return e({ url: "/api/dynamics/delete", method: "delete", params: a });
}
export {
  o as a,
  i as b,
  s as c,
  m as d,
  t as g
};
