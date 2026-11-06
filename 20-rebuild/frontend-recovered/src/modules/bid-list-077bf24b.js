import { l as t } from "../shared/runtime.js";
function o(e) {
  return t({ module: "crm", url: "bidding/center/get/head/fill/out/detail", method: "get", params: e });
}
function n(e) {
  return t({ module: "crm", url: "winning/contract/warehousing/save/non/direct/special/programs", method: "post", data: e });
}
function i(e) {
  return t({ module: "crm", url: "business/center/project/terminated", method: "post", data: e });
}
export {
  n as a,
  o as g,
  i as p
};
