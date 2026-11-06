import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "crm", url: "person/template/config/template/list", method: "get", params: e });
}
function l(e) {
  return t({ module: "crm", url: "person/template/config/update/template", method: "post", data: e });
}
function m(e) {
  return t({ module: "crm", url: "person/template/config/detail", method: "get", params: e });
}
function a(e) {
  return t({ module: "crm", url: "person/template/config/delete", method: "post", params: e });
}
export {
  l as a,
  a as d,
  o as g,
  m as u
};
