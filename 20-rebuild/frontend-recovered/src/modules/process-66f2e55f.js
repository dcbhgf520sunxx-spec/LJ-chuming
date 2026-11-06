import { l as r } from "../shared/runtime.js";
function s(e) {
  return r({ url: "/api/mes/bridge/process/group", method: "get", params: e });
}
function d(e) {
  return r({ url: "/api/mes/bridge/process", method: "get", params: e });
}
function u(e) {
  return r({ url: "/api/mes/bridge/process", method: "put", data: e });
}
function t(e) {
  return r({ url: "/api/mes/bridge/process/save/list", method: "post", data: e });
}
function o(e) {
  return r({ url: "/api/mes/bridge/process", method: "delete", data: { ids: e } });
}
const n = { get: s, add: t, edit: t, del: o };
export {
  n as c,
  u as e,
  d as g
};
