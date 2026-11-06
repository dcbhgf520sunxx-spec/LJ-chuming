import { l as o } from "../shared/runtime.js";
function e(t) {
  return o({ url: "/api/kit/wms/common/config/list", method: "get", params: t });
}
function i(t) {
  return o({ url: "/api/kit/wms/common/config/save", method: "post", data: t });
}
function n(t) {
  return o({ url: "/api/kit/wms/common/config/update", method: "put", data: t });
}
function m(t) {
  return o({ url: `/api/kit/wms/common/config/delete/${t}`, method: "delete" });
}
const c = { get: e, edit: n, add: i, del: m };
export {
  i as a,
  c,
  e as g
};
