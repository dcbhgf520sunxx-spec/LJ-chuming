import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ url: "/api/config/structureType/list/page", method: "get", params: t });
}
function u(t) {
  return e({ url: "/api/config/structureType/save", method: "post", data: t });
}
function c(t) {
  return e({ url: "/api/config/structureType/save/batch", method: "post", data: t.structureTypeConfig });
}
function i(t) {
  return e({ url: `/api/config/structureType/remove/${t}`, method: "delete" });
}
function p(t) {
  return e({ url: "/api/config/structureType/remove/batch", method: "delete", data: t });
}
function n(t) {
  return e({ url: "/api/config/structureType/update", method: "put", data: t });
}
function a() {
  return e({ url: "/api/config/structureType/list/public", method: "get" });
}
const s = { get: r, add: u, batchAdd: c, del: i, edit: n };
export {
  p as b,
  s as c,
  a as g
};
