import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "workshop/page", method: "get", params: e });
}
function u(e) {
  return t({ module: "mes", url: "workshop", method: "post", data: e });
}
function d(e) {
  return t({ module: "mes", url: "workshop", method: "put", data: e });
}
function n({ id: e, boolEnabledEnum: o }) {
  return t({ module: "mes", url: "workshop/changeState", method: "put", data: { id: e, boolEnabledEnum: o } });
}
function s(e) {
  return t({ module: "mes", url: "workshop", method: "delete", data: { ids: e } });
}
const l = { get: r, add: u, edit: d, del: s };
export {
  l as c,
  n as e
};
