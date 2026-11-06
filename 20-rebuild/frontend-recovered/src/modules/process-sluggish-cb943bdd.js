import { l as o } from "../shared/runtime.js";
function r(e) {
  return o({ module: "mes", url: "task/process/dull/process/detail/page", method: "get", params: e });
}
function t(e) {
  return o({ module: "mes", url: "task/workShop/productionLine", method: "get", params: e });
}
function u(e) {
  return o({ module: "mes", url: "task/process/dull/process", method: "get", params: e });
}
export {
  u as a,
  r as g,
  t as p
};
