import { l as t } from "../shared/runtime.js";
function i(e) {
  return t({ url: "/api/enterprisenetdisk/list", method: "get", params: e });
}
function s(e) {
  return t({ url: "/api/enterprisenetdisk/list/download", method: "post", responseType: "blob", data: e });
}
function n(e) {
  return t({ url: "/api/enterprisenetdisk/create", method: "post", data: e });
}
function o(e) {
  return t({ url: "/api/enterprisenetdisk/delete", method: "delete", params: e });
}
export {
  o as a,
  n as c,
  s as d,
  i as g
};
