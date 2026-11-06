import { l as r } from "../shared/runtime.js";
function e(t) {
  return r({ module: "project", url: "install-report/install-statement", method: "get", params: t });
}
function l(t) {
  return r({ module: "project", url: "install-report/install-board", method: "get", params: t });
}
const a = { get: e };
export {
  a as c,
  l as i
};
