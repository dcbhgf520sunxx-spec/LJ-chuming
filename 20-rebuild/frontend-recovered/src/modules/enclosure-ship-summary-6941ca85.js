import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ url: "/api/mes/building/cargo/project/enclosure/summary", method: "get", params: e });
}
function i(e) {
  return r({ url: "/api/mes/building/cargo/project/cargoList/enclosure/details/page", method: "get", params: e });
}
function a(e) {
  return r({ url: "/api/mes/building/cargo/year/enclosure/summary", method: "get", params: e });
}
function o(e) {
  return r({ url: "/api/mes/building/cargo/project/detail/enclosure/summary", method: "get", params: e });
}
function n(e) {
  return r({ url: "/api/mes/building/cargo/project/enclosure/detail/type", method: "get", params: e });
}
const s = { get: t };
export {
  n as a,
  s as c,
  i,
  o as p,
  a as s
};
