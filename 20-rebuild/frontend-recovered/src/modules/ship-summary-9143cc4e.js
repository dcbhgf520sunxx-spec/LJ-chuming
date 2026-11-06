import { l as e } from "../shared/runtime.js";
function t(r) {
  return e({ module: "bridge", url: "cargo/project/summary", method: "get", params: r });
}
function u(r) {
  return e({ module: "bridge", url: "cargo/project/cargoList/details/page", method: "get", params: r });
}
function a(r) {
  return e({ module: "bridge", url: "cargo/year/summary", method: "get", params: r });
}
const i = { get: t };
export {
  i as c,
  u as i,
  a as s
};
