import { l as t } from "../shared/runtime.js";
function l(e) {
  return t({ module: "wms", url: "move_material/application/steel-plate", method: "put", data: e });
}
function o(e) {
  return t({ module: "wms", url: "move_material/application/section-steel", method: "put", data: e });
}
function i(e) {
  return t({ module: "wms", url: "move_material/application/steel-coil", method: "put", data: e });
}
function n(e) {
  return t({ module: "wms", url: "move_material/application/auxiliary-material", method: "put", data: e });
}
function r(e) {
  return t({ module: "wms", url: "move_material/application/other-material", method: "put", data: e });
}
function m(e) {
  return t({ module: "wms", url: "move_material/application/gas", method: "put", data: e });
}
export {
  n as a,
  o as b,
  l as c,
  m as g,
  r as o,
  i as s
};
