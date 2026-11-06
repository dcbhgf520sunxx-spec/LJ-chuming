import { l as r } from "../shared/runtime.js";
function o(e) {
  return r({ module: "mes", url: "kanban/product/page", method: "get", params: e });
}
function u(e) {
  return r({ module: "mes", url: "kanban/product/steelSpec", method: "get", params: e });
}
export {
  u as a,
  o as p
};
