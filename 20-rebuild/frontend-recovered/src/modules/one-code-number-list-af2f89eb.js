import { ref as g } from "vue";
import { computed as m } from "vue";
import { watch as k } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as f } from "vue";
import { Fragment as x } from "vue";
import { renderList as C } from "vue";
import { createBlock as P } from "vue";
import { withCtx as b } from "vue";
import { createVNode as B } from "vue";
import { normalizeClass as V } from "vue";
import { createElementVNode as w } from "vue";
import { toDisplayString as y } from "vue";
import { renderSlot as W } from "vue";
import { normalizeStyle as h } from "vue";
import { createCommentVNode as I } from "vue";
import { ElTag as $ } from "element-plus";
import { ElTooltip as z } from "element-plus";
import { _ as E } from "../shared/runtime.js";
const H = { __name: "one-code-number-list", props: { modelValue: { type: [Array, Number, String] }, list: { type: Array, default: () => [] }, tagWidth: { type: Number, default: 200 }, multiple: { type: Boolean, default: true }, minSelectNum: { type: Number, default: 1 }, maxHeight: { type: Number }, color: { type: String, default: "" }, showPrintstatus: { type: Boolean, default: false }, boolPrintWarehousing: { type: Boolean, default: false } }, emits: ["change", "update:modelValue"], setup(o, { emit: N }) {
  const p = N, l = o, u = g(), n = g({}), i = m(() => l.multiple ? Object.keys(n.value) : u.value), v = m(() => ({ "grid-template-columns": `repeat(auto-fill, ${l.tagWidth}px)`, "max-height": l.maxHeight ? `${l.maxHeight}px` : "auto", overflow: "auto" }));
  k(() => l.modelValue, (t) => {
    l.multiple ? n.value = S(t) : u.value = t;
  }, { immediate: true });
  function d(t) {
    return l.multiple ? n.value[t.number] : Number(t.number) === u.value;
  }
  function S(t) {
    const a = {};
    for (let s = 0; s < t.length; s++) {
      const r = l.list.find((e) => Number(e.number) === Number(t[s]));
      a[r.number] = r;
    }
    return a;
  }
  function _(t, a) {
    if (!(a.isNotInStock && l.boolPrintWarehousing)) {
      if (l.multiple) if (n.value[t]) {
        if (l.minSelectNum && i.value.length === l.minSelectNum) return;
        delete n.value[t];
      } else n.value[t] = a;
      else u.value = t;
      console.log(t, a), p("update:modelValue", i.value), p("change", i.value);
    }
  }
  return (t, a) => {
    const s = $, r = z;
    return c(), f("div", { class: "tag-container", style: h(v.value) }, [(c(true), f(x, null, C(o.list, (e) => (c(), P(r, { key: e.number, content: e.isNotInStock ? "未入库" : "", disabled: !e.isNotInStock || !o.boolPrintWarehousing, placement: "top" }, { default: b(() => [B(s, { type: d(e) ? "success" : "info", size: "large", effect: d(e) ? void 0 : "plain", color: d(e) ? o.color : "", class: V([{ "disabled-tag": e.isNotInStock && o.boolPrintWarehousing }, "pointer"]), onClick: (j) => _(e.number, e) }, { default: b(() => [w("span", null, y(e.number), 1), W(t.$slots, "suffix", { data: e }, void 0, true), o.showPrintstatus && (e != null && e.boolPrint) ? (c(), f("span", { key: 0, class: "print-states", style: h({ color: e != null && e.boolPrint ? "#16c14e" : "#f00a0a" }) }, y(e != null && e.boolPrint ? "已打印" : "未打印"), 5)) : I("", true)]), _: 2 }, 1032, ["type", "effect", "color", "class", "onClick"])]), _: 2 }, 1032, ["content", "disabled"]))), 128))], 4);
  };
} }, L = E(H, [["__scopeId", "data-v-6c671e67"]]);
export {
  L as o
};
