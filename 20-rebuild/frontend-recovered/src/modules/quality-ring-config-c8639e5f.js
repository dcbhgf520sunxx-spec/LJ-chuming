import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "mes", url: "safety/config/page", method: "get", params: e, cancelKey: false });
}
function u(e) {
  return t({ module: "mes", url: "safety/config/save", method: "post", data: e });
}
function n(e) {
  return t({ module: "mes", url: "safety/config/update", method: "put", data: e });
}
function r(e) {
  return t({ module: "mes", url: `safety/config/delete/${e}`, method: "delete", data: e });
}
function d(e) {
  return t({ module: "mes", url: "safety/config/changeState", method: "put", data: e });
}
const s = { get: o, batchAdd: u, edit: n, del: r };
export {
  s as c,
  d as e
};
