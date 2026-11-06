import { l as a } from "../shared/runtime.js";
function t(e) {
  return a({ module: "wms", url: "freeze/raw-material/steelPlateManualFreeze", method: "put", data: e });
}
function l(e) {
  return a({ module: "wms", url: "freeze/raw-material/steelCoilManualFreeze", method: "put", data: e });
}
function u(e) {
  return a({ module: "wms", url: "freeze/raw-material/sectionSteelManualFreeze", method: "put", data: e });
}
function n(e) {
  return a({ module: "wms", url: "freeze/raw-material/auxiliaryMaterialManualFreeze", method: "put", data: e });
}
function o(e) {
  return a({ module: "wms", url: "freeze/raw-material/otherMaterialManualFreeze", method: "put", data: e });
}
function i(e) {
  return a({ module: "wms", url: "freeze/raw-material/gesManualFreeze", method: "put", data: e });
}
function m(e) {
  return a({ module: "wms", url: "freeze/raw-material/steelPlateBatchManualFreeze", method: "put", data: e });
}
function s(e) {
  return a({ module: "wms", url: "freeze/raw-material/sectionSteelBatchManualFreeze", method: "put", data: e });
}
function z(e) {
  return a({ module: "wms", url: "freeze/raw-material/steelCoilBatchManualFreeze", method: "put", data: e });
}
function M(e) {
  return a({ module: "wms", url: "freeze/raw-material/auxiliaryMaterialBatchManualFreeze", method: "put", data: e });
}
function c(e) {
  return a({ module: "wms", url: "freeze/raw-material/otherMaterialBatchManualFreeze", method: "put", data: e });
}
function h(e) {
  return a({ module: "wms", url: "freeze/raw-material/gesBatchManualFreeze", method: "put", data: e });
}
export {
  M as a,
  s as b,
  m as c,
  t as d,
  u as e,
  l as f,
  h as g,
  n as h,
  i,
  o as j,
  c as o,
  z as s
};
