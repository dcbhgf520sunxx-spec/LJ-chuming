import { l as t } from "../shared/runtime.js";
function c(e) {
  return t({ module: "mes", url: "price/change/product/type", method: "get", params: e });
}
function p(e) {
  return t({ module: "mes", url: "price/change/product/page", method: "get", params: e });
}
function n({ id: e, configId: r, taskTypeEnum: o }) {
  return t({ module: "mes", url: `price/change/product/type/${e}/process`, method: "get", params: { configId: r, taskTypeEnum: o } });
}
function d(e) {
  return t({ module: "mes", url: "price/change/product", method: "put", data: e });
}
export {
  p as d,
  d as e,
  n as p,
  c as t
};
