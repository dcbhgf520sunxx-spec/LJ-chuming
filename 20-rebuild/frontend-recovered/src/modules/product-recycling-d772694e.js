import { l as r } from "../shared/runtime.js";
function c(e) {
  return r({ url: "/api/contract/return/recycle/ledger/list", method: "get", params: e });
}
function i(e) {
  return r({ url: "/api/contract/return/recycle/ledger/totalAmount", method: "get", params: e });
}
function l(e) {
  return r({ url: "/api/contract/return/recycle/ledger/product/list", method: "get", params: e });
}
function u(e) {
  let t = "";
  return e.status === "payment" ? t = "/api/contract/return/recycle/ledger/payment/list" : t = "/api/contract/return/recycle/ledger/invoice/list", r({ url: t, method: "get", params: e });
}
function a(e) {
  let t = "";
  return e.status === "payment" ? t = "/api/contract/return/recycle/ledger/payment/save" : t = "/api/contract/return/recycle/ledger/invoice/save", r({ url: t, method: "post", data: e });
}
function o(e) {
  let t = "";
  return e.status === "payment" ? t = "/api/contract/return/recycle/ledger/payment/update" : t = "/api/contract/return/recycle/ledger/invoice/update", r({ url: t, method: "put", data: e });
}
function p(e) {
  let t = "";
  return e.status === "payment" ? t = "/api/contract/return/recycle/ledger/payment/audit" : t = "/api/contract/return/recycle/ledger/invoice/audit", r({ url: t, method: "put", data: e });
}
function d(e) {
  return r({ url: `/api/contract/return/recycle/ledger/payment/delete/${e}`, method: "delete" });
}
function s(e) {
  return r({ url: `/api/contract/return/recycle/ledger/invoice/delete/${e}`, method: "delete" });
}
const y = { get: c };
export {
  l as a,
  u as b,
  y as c,
  o as d,
  p as e,
  d as f,
  i as g,
  s as h,
  a as p
};
