import { l as t } from "../shared/runtime.js";
function m(e) {
  return t({ module: "mes", url: "qhse/inspect/realtime/page", method: "get", params: e });
}
function s(e) {
  return t({ module: "mes", url: "qhse/inspect/realtime/summary", method: "get", params: e });
}
function u(e) {
  return t({ module: "mes", url: "qhse/simple/detail", method: "get", params: e });
}
const i = { get: m };
export {
  u as a,
  i as c,
  s as g
};
