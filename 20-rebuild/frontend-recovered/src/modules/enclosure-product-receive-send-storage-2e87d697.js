import { l as r } from "../shared/runtime.js";
function u(e) {
  return r({ url: "/api/mes/building/warehouse/v2/finish-product/enclosure/page", method: "get", params: e });
}
function t(e) {
  return r({ url: "/api/mes/building/warehouse/finish-product/detail/enclosure/page", method: "get", params: e });
}
function o(e) {
  return r({ url: "/api/mes/building/warehouse/v2/finish-product/enclosure/summary", method: "get", params: e });
}
function s(e) {
  return r({ url: "/api/mes/building/warehouse/v2/report/finish-product/enclosure", method: "get", params: e });
}
const n = { get: u };
export {
  n as c,
  t as d,
  s as e,
  o as s
};
