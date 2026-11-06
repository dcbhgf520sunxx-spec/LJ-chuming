import { l as r } from "../shared/runtime.js";
function u(e) {
  return r({ module: "mes", url: "cargo/receipt", method: "get", params: e });
}
function n(e) {
  return r({ module: "mes", url: `cargo/receipt/${e}`, method: "get" });
}
function c(e) {
  return r({ module: "mes", url: "cargo/cancel", method: "put", data: e });
}
function l(e) {
  return r({ module: "bridge", url: "cargo/cancel", method: "put", data: e });
}
function a(e, t) {
  return r({ module: "mes", url: `cargo/sign/${e}`, method: "put", params: t });
}
export {
  a,
  l as b,
  c,
  n as d,
  u as g
};
