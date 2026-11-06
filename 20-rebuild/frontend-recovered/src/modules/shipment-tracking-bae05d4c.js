import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ module: "contract", url: "business/ship/bridge/detail", method: "get", params: t });
}
function i(t) {
  return e({ module: "contract", url: "business/ship/detail", method: "get", params: t });
}
function u(t) {
  return e({ module: "contract", url: "business/ship/direct/detail", method: "get", params: t });
}
function n(t) {
  return e({ module: "contract", url: "business/ship/enclosure/detail", method: "get", params: t });
}
function o(t) {
  return e({ module: "contract", url: "business/ship/detail/standard", method: "get", params: t });
}
function a(t) {
  return e({ module: "contract", url: "business/ship/summary", method: "get", params: t });
}
function c(t) {
  return e({ module: "contract", url: "business/ship/bridge/summary", method: "get", params: t });
}
function d(t) {
  return e({ url: "/api/business/ship/return/list", method: "get", params: t });
}
export {
  o as a,
  r as b,
  c,
  i as d,
  n as e,
  u as f,
  d as g,
  a as s
};
