import { l as t } from "../shared/runtime.js";
function o(i) {
  return t({ module: "config", url: `classification/specification/${i.id}`, method: "get" });
}
function c(i) {
  return t({ module: "config", url: "classification/specification", method: "post", data: i });
}
function n(i) {
  return t({ module: "config", url: "classification/specification", method: "put", data: i });
}
function u(i) {
  return t({ module: "config", url: "classification/specification", method: "delete", data: i });
}
function s(i, e) {
  return t({ module: "config", url: "classification/material/section-steel/updateStatus", method: "put", data: i, params: e });
}
const r = { get: o, del: u, edit: n, add: c };
export {
  r as c,
  s as e
};
