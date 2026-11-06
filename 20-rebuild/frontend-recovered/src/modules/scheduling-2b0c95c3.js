import { l as e } from "../shared/runtime.js";
function s(t) {
  return e({ url: "/api/cut/getMachinePlateList", method: "get", params: t });
}
function r(t) {
  return e({ url: "/api/cut/suspendTask", method: "post", data: t });
}
const n = { get: s, suspendTask: r };
export {
  n as c,
  r as s
};
