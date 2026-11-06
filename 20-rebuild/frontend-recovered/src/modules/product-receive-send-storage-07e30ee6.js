import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "bridge", url: "warehouse/finish-product/page", method: "get", params: e });
}
function o(e) {
  return r({ module: "bridge", url: "warehouse/finish-product/detail/page", method: "get", params: e });
}
function i(e) {
  return r({ module: "bridge", url: "warehouse/finish-product/summary", method: "get", params: e });
}
function a(e) {
  return r({ module: "bridge", url: "warehouse/report/finish-product/box", method: "get", params: e });
}
const d = { get: t };
export {
  a,
  d as c,
  o as d,
  i as s
};
