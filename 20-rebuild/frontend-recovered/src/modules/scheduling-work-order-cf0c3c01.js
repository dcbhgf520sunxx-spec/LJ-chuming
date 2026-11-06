import { l as r } from "../shared/runtime.js";
function n(e) {
  return r({ module: "enclosure", url: "order/project/list", method: "get", params: e });
}
function o(e) {
  return r({ module: "enclosure", url: "order/order/list", method: "get", params: e });
}
function t(e) {
  return r({ module: "enclosure", url: "order/order/detail", method: "get", params: { id: e } });
}
function d(e) {
  return r({ module: "enclosure", url: "order/order", method: "delete", data: e });
}
function s(e) {
  return r({ module: "enclosure", url: "order/order/detail/save/print", method: "put", params: { id: e } });
}
function u({ id: e }) {
  return r({ module: "enclosure", url: "order/detail/download", method: "get", responseType: "blob", params: { id: e } });
}
function a(e) {
  return r({ url: "/api/enclosure/order/detail/delete", method: "post", data: e });
}
const c = { get: o, del: d, detail: t, download: u };
export {
  c,
  u as d,
  n as p,
  s as r,
  a as w
};
