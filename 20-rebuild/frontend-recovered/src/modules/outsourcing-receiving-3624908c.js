import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "project", url: "receiving/operateRecordPage", method: "get", params: e });
}
function i(e) {
  return r({ module: "project", url: "receiving/orderSimpleInfo", method: "get", params: e });
}
function c(e) {
  return r({ module: "project", url: "receiving/purchaseProductDetails", method: "get", params: e });
}
function n(e) {
  return r({ module: "project", url: "receiving/purchaseReceiving", method: "post", data: e });
}
function u(e) {
  return r({ module: "project", url: "receiving/operateDetails", method: "get", params: e });
}
const a = { get: t };
export {
  i as a,
  c as b,
  a as c,
  n as d,
  u as g
};
