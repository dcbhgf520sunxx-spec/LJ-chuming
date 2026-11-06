import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "wms", url: "reject/inbound-rejectable", method: "get", params: e });
}
function n(e) {
  return t({ module: "wms", url: `reject/inbound-rejectable/${e}`, method: "get" });
}
function u(e) {
  return t({ module: "wms", url: `reject/inbound-rejectable/material-match/${e}`, method: "get" });
}
function c(e) {
  return t({ url: "/api/v2/wms/reject/inbound-rejectable", method: "post", data: e });
}
const a = { get: r, detail: n };
export {
  u as a,
  a as c,
  n as g,
  c as r
};
