import { l as n } from "../shared/runtime.js";
function e(t) {
  return n({ url: "/api/inventory/configuration/list", method: "get", params: t });
}
function r(t) {
  return n({ url: "/api/inventory/configuration/add", method: "post", data: t });
}
function i(t) {
  return n({ url: "/api/inventory/configuration/update", method: "put", data: t });
}
function u(t) {
  return n({ url: "/api/inventory/configuration/remove", method: "delete", params: t });
}
const a = { get: e };
export {
  r as a,
  a as c,
  u as d,
  i as e,
  e as g
};
