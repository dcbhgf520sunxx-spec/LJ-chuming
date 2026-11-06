import { l as e } from "../shared/runtime.js";
function o(t) {
  return e({ url: "/api/push/flow/config", method: "get", params: t });
}
function r(t) {
  return e({ url: "/api/push/flow/config/editStatus", method: "post", params: t });
}
function u(t) {
  return e({ url: "/api/push/flow/config/detail", method: "get", params: t });
}
function n(t) {
  return e({ url: "/api/push/flow/config", method: "delete", params: t });
}
function l(t) {
  return e({ url: "/api/push/flow/config/editFlow", method: "post", data: t });
}
const s = { get: o };
export {
  l as a,
  s as c,
  n as d,
  r as e,
  u as g
};
