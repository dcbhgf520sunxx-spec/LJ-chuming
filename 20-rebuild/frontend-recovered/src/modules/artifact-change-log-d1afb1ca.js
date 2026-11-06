import { l as t } from "../shared/runtime.js";
function n(e) {
  return t({ url: "/api/plan/tech-change", method: "get", params: e });
}
function o(e) {
  return t({ url: "/api/plan/tech-change/check", method: "post", data: e });
}
function c(e) {
  return t({ module: "plan", url: "tech-change/export/list", responseType: "blob", method: "get", params: e });
}
const r = { get: n };
export {
  o as a,
  r as c,
  c as d
};
