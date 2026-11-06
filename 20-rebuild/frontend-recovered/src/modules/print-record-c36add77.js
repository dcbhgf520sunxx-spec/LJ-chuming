import { l as e } from "../shared/runtime.js";
function n(r) {
  return e({ module: "bridge", url: `print/record/task/${r}`, method: "get" });
}
function u(r) {
  return e({ module: "bridge", url: `print/record/material/${r}`, method: "get" });
}
function c(r) {
  return e({ module: "bridge", url: `print/record/package/${r}`, method: "get" });
}
function m({ id: r, quantity: t, startTime: a, endTime: d, numberList: o }) {
  return e({ module: "bridge", url: "print/record/task", method: "post", data: { taskId: r, quantity: t, startTime: a, endTime: d, numberList: o } });
}
function l({ id: r, quantity: t, startTime: a, endTime: d }) {
  return e({ module: "bridge", url: "print/record/material", method: "post", data: { materialId: r, quantity: t, startTime: a, endTime: d } });
}
function g({ id: r, quantity: t, startTime: a, endTime: d }) {
  return e({ module: "bridge", url: "print/record/package", method: "post", data: { packId: r, quantity: t, startTime: a, endTime: d } });
}
export {
  n as a,
  c as b,
  u as g,
  l as m,
  g as p,
  m as t
};
