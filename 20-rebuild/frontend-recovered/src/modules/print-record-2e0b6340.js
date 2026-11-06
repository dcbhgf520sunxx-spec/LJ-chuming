import { l as d } from "../shared/runtime.js";
function s(r) {
  return d({ module: "mes", url: `print/record/task/${r}`, method: "get" });
}
function n(r) {
  return d({ url: `/api/mes/building/subscribe/print/record/artifact/${r}`, method: "get" });
}
function c(r) {
  return d({ module: "mes", url: `print/record/package/${r}`, method: "get" });
}
function i({ id: r, quantity: e, startTime: t, endTime: a, numberList: o }) {
  return d({ module: "mes", url: "print/record/task", method: "post", data: { taskId: r, quantity: e, startTime: t, endTime: a, numberList: o } });
}
function p({ id: r, quantity: e, startTime: t, endTime: a, numberList: o }) {
  return d({ url: "/api/mes/building/subscribe/print/artifact/print", method: "post", data: { warehouseId: r, quantity: e, startTime: t, endTime: a, numberList: o } });
}
function m({ id: r, quantity: e, startTime: t, endTime: a }) {
  return d({ module: "mes", url: "print/record/package", method: "post", data: { packId: r, quantity: e, startTime: t, endTime: a } });
}
function g({ id: r, quantity: e, startTime: t, endTime: a }) {
  return d({ module: "bridge", url: "print/record/package", method: "post", data: { packId: r, quantity: e, startTime: t, endTime: a } });
}
export {
  p as a,
  s as b,
  c,
  g as d,
  n as g,
  m as p,
  i as t
};
