import { l as t } from "../shared/runtime.js";
function u(e) {
  return t({ module: "mes", url: "scheduling/artifact/artifact/scheduling/list", method: "get", params: e });
}
function r(e) {
  return t({ module: "mes", url: "scheduling/artifact/artifact/scheduling/summary", method: "get", params: e });
}
function c(e) {
  return t({ module: "mes", url: "scheduling/artifact/artifact/scheduling/detail/page", method: "get", params: e });
}
const i = { get: u };
export {
  c as a,
  i as c,
  r as g
};
