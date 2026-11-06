import { l as t } from "../shared/runtime.js";
function u(e) {
  return t({ module: "mes", url: "quality/config/page", method: "get", params: e, cancelKey: false });
}
function o(e) {
  return t({ module: "mes", url: "quality/config/save", method: "post", data: e });
}
function n(e) {
  return t({ module: "mes", url: "quality/config/update", method: "put", data: e });
}
function l(e) {
  return t({ module: "mes", url: `quality/config/delete/${e}`, method: "delete", data: e });
}
function r(e) {
  return t({ module: "mes", url: "quality/config/changeState", method: "put", data: e });
}
const c = { get: u, batchAdd: o, edit: n, del: l };
export {
  c,
  r as e
};
