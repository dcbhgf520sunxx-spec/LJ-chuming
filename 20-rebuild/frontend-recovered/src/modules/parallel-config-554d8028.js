import { l as t } from "../shared/runtime.js";
function r(e) {
  return t({ module: "mes", url: "spacer/parallel/page", method: "get", params: e });
}
function m(e) {
  return t({ module: "mes", url: "spacer/parallel", method: "get", params: e });
}
function a(e) {
  return t({ module: "mes", url: "spacer/parallel", method: "post", data: e.list });
}
function l(e) {
  return t({ module: "mes", url: "spacer/parallel", method: "put", data: e });
}
function o(e) {
  return t({ module: "mes", url: "spacer/parallel", method: "delete", data: e });
}
function s(e) {
  return t({ module: "mes", url: "spacer/parallel/struct/upload", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function d(e) {
  return t({ module: "mes", url: "spacer/parallel/upload/temporary/files", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function n() {
  return t({ module: "mes", url: "spacer/parallel/wait/condition", method: "get" });
}
const p = { get: r, add: a, edit: l, del: o };
export {
  m as a,
  p as c,
  n as g,
  d as s,
  s as u
};
