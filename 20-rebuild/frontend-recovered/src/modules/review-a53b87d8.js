import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "wms", url: "outbound/application/review/raw-materials", method: "get", params: e });
}
function u(e) {
  return r({ module: "wms", url: `outbound/application/review/raw-materials/${e}`, method: "get" });
}
function i(e) {
  return r({ module: "wms", url: "outbound/application/review/raw-materials/pending/ids", method: "get", params: e });
}
function n(e) {
  return r({ module: "wms", url: `outbound/application/review/raw-materials/${e}/returned`, method: "put" });
}
function o(e) {
  return r({ module: "wms", url: `outbound/application/review/raw-materials/${e.id}/passed`, method: "put", data: e });
}
function l() {
  return r({ module: "wms", url: "outbound/application/review/raw-materials/current-user", method: "get" });
}
function d(e) {
  return r({ module: "wms", url: "outbound/application/review/raw-materials/current-user/detail-number", method: "get", params: e });
}
function m(e) {
  return r({ module: "wms", headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "outbound/application/review/raw-materials/material-del", method: "put", data: e });
}
const s = { get: t, detail: u };
export {
  l as a,
  n as b,
  s as c,
  m as d,
  i as e,
  u as f,
  d as g,
  o as r
};
