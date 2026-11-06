import { l as r } from "../shared/runtime.js";
function o(e) {
  return r({ module: "crm", url: "tender/request/config", method: "get", cancelKey: false, params: e });
}
function s(e, t) {
  return r({ module: "crm", url: "tender/request/config", method: "post", params: e, data: t });
}
export {
  o as g,
  s
};
