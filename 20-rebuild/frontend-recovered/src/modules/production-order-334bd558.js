import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "bridge", url: "scheduling/area/project/page", method: "get", params: e });
}
function a(e) {
  return r({ module: "bridge", url: "scheduling/area/list", method: "get", params: e });
}
function d(e) {
  return r({ module: "bridge", url: "scheduling/area", method: "put", data: e });
}
function n(e) {
  return r({ module: "bridge", url: "scheduling/area/project", method: "get", params: e });
}
function i(e) {
  return r({ module: "bridge", url: "scheduling/area/box/list", method: "get", params: e });
}
function l(e) {
  return r({ module: "bridge", url: "scheduling/area/element/list", method: "get", params: e });
}
function o(e) {
  return r({ module: "bridge", url: "scheduling/area/machinePart/list", method: "get", params: e });
}
function m(e) {
  return r({ module: "bridge", url: "scheduling/area/summary", method: "get", params: e });
}
function c(e) {
  return r({ module: "bridge", url: "scheduling/area/project/summay", method: "get", params: e });
}
const s = { get: t };
export {
  n as a,
  m as b,
  s as c,
  i as d,
  l as e,
  o as m,
  c as p,
  a as s,
  d as u
};
