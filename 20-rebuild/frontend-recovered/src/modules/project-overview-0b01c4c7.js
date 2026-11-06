import { l as r } from "../shared/runtime.js";
function u(e) {
  return r({ module: "enclosure", url: "overview/project", method: "get", params: e });
}
function c(e) {
  return r({ url: "/api/mes/enclosure/overview/v2/project/category", method: "get", params: e });
}
function n(e) {
  return r({ url: "/api/mes/enclosure/overview/v2/product/total", method: "get", params: e });
}
function t(e) {
  return r({ url: "/api/mes/enclosure/overview/v2/product/detail", method: "get", params: e });
}
const i = { get: t };
export {
  c as a,
  i as c,
  n as e,
  u as p
};
