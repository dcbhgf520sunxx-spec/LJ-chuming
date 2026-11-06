import { l as t } from "../shared/runtime.js";
function s(e) {
  return t({ module: "mes", url: "task/order/listNumberOrder", method: "get", params: e });
}
function o(e) {
  return t({ module: "mes", url: "task/order/listProductNumbers", method: "get", params: e });
}
function u(e) {
  return t({ module: "mes", url: "task/order/list/linknumbers", method: "post", data: e });
}
export {
  s as a,
  u as b,
  o as g
};
