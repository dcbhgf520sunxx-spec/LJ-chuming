import { _ as b, u as v, t as w, bV as p, a as h } from "../../../../../shared/runtime.js";
import { ref as k } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as i } from "vue";
import { createBlock as V } from "vue";
import { withCtx as c } from "vue";
import { createElementBlock as m } from "vue";
import { Fragment as B } from "vue";
import { renderList as I } from "vue";
import { createElementVNode as e } from "vue";
import { toDisplayString as o } from "vue";
import { createVNode as C } from "vue";
import { unref as n } from "vue";
import { isRef as L } from "vue";
const R = { style: { padding: "0 5px", flex: "1" } }, z = { style: { display: "flex", "justify-content": "space-between", "align-items": "center", "margin-bottom": "4px" } }, D = { style: { "font-size": "14px", "font-weight": "600", color: "#000", "margin-top": "2px", display: "inline-block" } }, P = { style: { display: "flex", "align-items": "end" } }, S = { style: { "margin-bottom": "1px", "margin-top": "0" } }, T = { style: { "margin-top": "1px", "margin-bottom": "2px" } }, W = { __name: "work-info", props: { visible: { type: Boolean, default: false }, lineNameList: { type: Array } }, emits: ["update:visible"], setup(l, { emit: _ }) {
  const f = k(), r = _, u = l, { visible: a } = v({ emit: r, props: u, field: "visible" }), { decimalPrecision: d } = w(), g = () => {
    r("update:modelValue", false);
  };
  return (j, s) => {
    const x = h, y = N("common-drawer");
    return i(), V(y, { ref_key: "drawerRef", ref: f, title: "车间实时信息", modelValue: n(a), "onUpdate:modelValue": s[0] || (s[0] = (t) => L(a) ? a.value = t : null), "before-close": g, size: "20%" }, { titleRight: c(() => s[1] || (s[1] = [])), content: c(() => [(i(true), m(B, null, I(l.lineNameList, (t) => (i(), m("div", { class: "wrap-work-item", key: t.teamId }, [s[2] || (s[2] = e("div", { style: { width: "10px", "background-color": "#00bcff", height: "81px", "border-radius": "8px 0 0 8px" } }, null, -1)), e("div", R, [e("div", z, [e("span", D, o(t.lineName), 1), e("div", P, [C(x, { "icon-class": "user", style: { color: "#666", "font-size": "15px" } }), e("span", null, o(t.teamLeaderName) + "班组", 1)])]), e("p", S, "生产车间：" + o(t.shopName), 1), e("a", null, "平均能力：" + o(n(p)(t.avgNetWeight, n(d).mes)) + "吨/月", 1), e("p", T, "在手任务：" + o(n(p)(t.unTotalNetWeight, n(d).mes)) + "吨", 1)])]))), 128))]), _: 1 }, 8, ["modelValue"]);
  };
} }, F = b(W, [["__scopeId", "data-v-a2cf946f"]]);
export {
  F as default
};
