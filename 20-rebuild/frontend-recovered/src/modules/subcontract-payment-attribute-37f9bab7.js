import { l as e } from "../shared/runtime.js";
function a() {
  return e({ module: "", url: "/api/system/payment/attribute/pageList", method: "get", cancelKey: false });
}
function i() {
  return e({ module: "", url: "/api/system/payment/attribute/listAll", method: "get", cancelKey: false });
}
function u(t) {
  return e({ module: "", url: "/api/system/payment/attribute/save/batch", method: "post", data: t.list });
}
function r(t) {
  return e({ module: "", url: "/api/system/payment/attribute/update", method: "put", data: t });
}
function m(t) {
  return e({ module: "", url: "/api/system/payment/attribute/remove", method: "delete", data: t });
}
const s = { get: a, add: u, edit: r, del: m };
export {
  s as c,
  i as g
};
