import { l as s } from "../shared/runtime.js";
function r(e) {
  return s({ module: "mes", url: "task/process/project/progressing/page", method: "get", params: e });
}
function o(e) {
  return s({ module: "mes", url: "task/process/project/progressing/outBound/page", method: "get", params: e });
}
function g(e) {
  return s({ module: "mes", url: "task/process/project/progressing/task/page", method: "get", params: e });
}
function u(e) {
  return s({ module: "mes", url: "task/process/project/progressing/process/page", method: "get", params: e });
}
const p = { get: r };
export {
  g as a,
  u as b,
  p as c,
  o as g
};
