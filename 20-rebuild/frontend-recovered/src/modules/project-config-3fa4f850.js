import { l as e } from "../shared/runtime.js";
function n(o) {
  return e({ module: "crm", url: "project/information/config", method: "get", cancelKey: false, params: o });
}
function c(o, r) {
  return e({ module: "crm", url: "project/information/config", method: "post", params: o, data: r });
}
export {
  n as g,
  c as s
};
