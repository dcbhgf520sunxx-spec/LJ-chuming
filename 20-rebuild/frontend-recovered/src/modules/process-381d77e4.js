import { l as o } from "../shared/runtime.js";
function r(e) {
  return o({ module: "mes", url: "process", method: "get", params: e });
}
function s(e) {
  return o({ module: "mes", url: "process", method: "put", data: e });
}
function u(e) {
  return o({ module: "mes", url: "process/wage", method: "post", data: e });
}
function n() {
  return o({ module: "mes", url: "process/group2", method: "get", cancelKey: false });
}
export {
  n as a,
  u as b,
  s as e,
  r as g
};
