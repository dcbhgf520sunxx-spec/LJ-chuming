import { l as o } from "../shared/runtime.js";
function t(e) {
  return o({ module: "crm", url: "basics/config", method: "get", cancelKey: false, params: e });
}
function c(e, s) {
  return o({ module: "crm", url: "basics/config", method: "post", params: e, data: s });
}
export {
  t as g,
  c as s
};
