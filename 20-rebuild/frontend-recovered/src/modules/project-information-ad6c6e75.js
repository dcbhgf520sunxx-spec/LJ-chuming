import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "crm", url: "business/center/project/list", method: "get", cancelKey: false, params: e });
}
function u(e) {
  return r({ module: "crm", url: "business/center/summary", method: "get", params: e });
}
function c(e) {
  return r({ module: "crm", url: "project/information/warehousing/check/project/have/recording/custom", method: "get", params: e });
}
function n(e) {
  return r({ module: "crm", url: "project/follow/up/record/get/follow/up/simple/list", method: "get", params: e });
}
function i(e) {
  return r({ url: "/api/v2/wms/config/record/getSerialNumberById", method: "get", params: e });
}
function m(e) {
  return r({ url: "/api/crm/apply/for/bid/record/get/approval/already/enum", method: "get", params: e });
}
const s = { get: t };
export {
  n as a,
  i as b,
  s as c,
  m as d,
  u as g,
  c as i
};
