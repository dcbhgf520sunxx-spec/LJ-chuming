import { l as r } from "../shared/runtime.js";
function l(e) {
  return r({ url: "/api/contract/return/sale/ledger/list", method: "get", params: e });
}
function i(e) {
  return r({ url: "/api/contract/return/sale/ledger/saleTotalAmount", method: "get", params: e });
}
function o(e) {
  return r({ url: "/api/contract/return/sale/ledger/product/list", method: "get", params: e });
}
function c(e) {
  let t = "";
  return e.status === "collection" ? t = "/api/contract/return/sale/ledger/collection/list" : t = "/api/contract/return/sale/ledger/invoice/list", r({ url: t, method: "get", params: e });
}
function a(e) {
  let t = "";
  return e.status === "collection" ? t = "/api/contract/return/sale/ledger/collection/save" : t = "/api/contract/return/sale/ledger/invoice/save", r({ url: t, method: "post", data: e.list });
}
function u(e) {
  let t = "";
  return e.status === "collection" ? t = "/api/contract/return/sale/ledger/collection/update" : t = "/api/contract/return/sale/ledger/invoice/update", r({ url: t, method: "put", data: e.list[0] });
}
function s(e) {
  let t = "";
  return e.status === "collection" ? t = "/api/contract/return/sale/ledger/collection/audit" : t = "/api/contract/return/sale/ledger/invoice/audit", r({ url: t, method: "put", data: e });
}
function d(e) {
  return r({ url: `/api/contract/return/sale/ledger/collection/delete/${e}`, method: "delete" });
}
function p(e) {
  return r({ url: `/api/contract/return/sale/ledger/invoice/delete/${e}`, method: "delete" });
}
const g = { get: l };
export {
  o as a,
  c as b,
  g as c,
  u as d,
  s as e,
  d as f,
  i as g,
  p as h,
  a as p
};
