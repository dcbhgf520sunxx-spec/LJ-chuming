import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ module: "mes", url: "production_statements/page", method: "get", params: t });
}
function o(t) {
  return e({ module: "mes", url: "production_statements/summary", method: "get", params: t });
}
const u = { get: r };
export {
  u as c,
  o as g
};
