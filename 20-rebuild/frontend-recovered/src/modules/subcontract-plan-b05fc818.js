import { l as e } from "../shared/runtime.js";
function l(t) {
  return e({ module: "project", url: "install-plan/listV2", method: "get", params: t });
}
function r(t) {
  return e({ module: "project", url: "install-plan/setSupplier", method: "post", data: t });
}
function n(t) {
  return e({ module: "project", url: "install-plan/listSupplier", method: "get", params: t });
}
const u = { edit: r, get: l };
export {
  u as c,
  n as s
};
