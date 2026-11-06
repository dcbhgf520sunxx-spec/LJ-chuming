import { l as r } from "../shared/runtime.js";
function t(e) {
  return r({ module: "project", url: "sub-payment/list-subOrder", method: "get", params: e, cancelKey: false });
}
const o = { get: t };
export {
  o as c
};
