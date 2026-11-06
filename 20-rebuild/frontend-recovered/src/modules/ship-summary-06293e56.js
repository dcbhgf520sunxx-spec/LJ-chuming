import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "mes", url: "cargo/project/summary", method: "get", params: e });
}
function m(e) {
  return r({ url: "/api/mes/building/cargo/project/cargoList/details/page", method: "get", params: e });
}
function u(e) {
  return r({ module: "mes", url: "cargo/year/summary", method: "get", params: e });
}
function a(e) {
  return r({ module: "mes", url: "cargo/project/detail/summary", method: "get", params: e });
}
function s(e) {
  return r({ module: "mes", url: "cargo/project/detail/type", method: "get", params: e });
}
const c = { get: t };
export {
  s as a,
  c,
  m as i,
  a as p,
  u as s
};
