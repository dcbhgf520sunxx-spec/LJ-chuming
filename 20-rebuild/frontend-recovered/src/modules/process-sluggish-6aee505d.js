import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "bridge", url: "task/process/dull/process/detail/page", method: "get", params: e });
}
function s(e) {
  return r({ module: "bridge", url: "task/workShop/productionLine", method: "get", params: e });
}
function u(e) {
  return r({ module: "bridge", url: "task/process/dull/process", method: "get", params: e });
}
export {
  u as a,
  t as g,
  s as p
};
