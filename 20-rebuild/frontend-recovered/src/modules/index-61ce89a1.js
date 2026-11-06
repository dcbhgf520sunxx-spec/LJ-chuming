import { i as r } from "../shared/runtime.js";
import { computed as s } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as o } from "vue";
import { unref as l } from "vue";
import { toDisplayString as a } from "vue";
import { createTextVNode as m } from "vue";
import { Fragment as i } from "vue";
const _ = { key: 0, style: { color: "red" } }, y = { key: 1, style: { color: "red" } }, k = { key: 2, style: { color: "green" } }, w = { key: 3, style: { color: "green" } }, f = { key: 1 }, x = { __name: "index", props: { old: null, new: null, enum: Object }, setup(c) {
  const e = c, u = s(() => e.old !== e.new), p = s(() => e.enum ? e.enum.VL[e.old] : e.old), d = s(() => e.enum ? (console.log("props.enum.VL[props.new]", e.enum.VL[e.new]), e.enum.VL[e.new]) : e.new);
  return (V, t) => u.value ? (n(), o(i, { key: 0 }, [l(r)(e.old) ? (n(), o("span", _, a(p.value), 1)) : (n(), o("span", y, "未填写")), t[0] || (t[0] = m(" ▶ ")), l(r)(e.new) ? (n(), o("span", k, a(d.value), 1)) : (n(), o("span", w, "未填写"))], 64)) : (n(), o("span", f, "/"));
} };
export {
  x as _
};
