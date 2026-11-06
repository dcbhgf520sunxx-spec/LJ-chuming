import { l as e } from "../shared/runtime.js";
function r(t) {
  return e({ module: "mes", url: `abnormal/${t}`, method: "put" });
}
function n(t) {
  return e({ module: "mes", url: "abnormal/handle/part", method: "put", data: { id: t } });
}
function o(t) {
  return e({ module: "mes", url: "abnormal/artifact", method: "put", data: t });
}
function u(t) {
  return e({ module: "mes", url: "abnormal/artifact/task", method: "put", data: t });
}
function m(t) {
  return e({ module: "mes", url: "abnormal/report", method: "get", params: t });
}
export {
  o as a,
  r as c,
  m as e,
  n as p,
  u as t
};
