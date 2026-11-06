import { ref as p } from "vue";
import { computed as f } from "vue";
import { watch as b } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as g } from "vue";
import { Fragment as x } from "vue";
import { renderList as N } from "vue";
import { createBlock as S } from "vue";
import { withCtx as k } from "vue";
import { createElementVNode as C } from "vue";
import { toDisplayString as B } from "vue";
import { renderSlot as V } from "vue";
import { normalizeStyle as w } from "vue";
import { ElTag as $ } from "element-plus";
import { _ as H } from "../shared/runtime.js";
const j = { __name: "one-code-number-list", props: { modelValue: { type: [Array, Number, String] }, list: { type: Array, default: () => [] }, tagWidth: { type: Number, default: 200 }, multiple: { type: Boolean, default: true }, maxHeight: { type: Number } }, emits: ["change", "update:modelValue"], setup(r, { emit: _ }) {
  const c = _, a = r, o = p(), l = p({}), i = f(() => a.multiple ? Object.keys(l.value) : o.value), v = f(() => ({ "grid-template-columns": `repeat(auto-fill, ${a.tagWidth}px)`, "max-height": a.maxHeight ? `${a.maxHeight}px` : "auto", overflow: "auto" }));
  b(() => a.modelValue, (e) => {
    a.multiple ? l.value = y(e) : o.value = e;
  }, { immediate: true });
  function d(e) {
    return a.multiple ? l.value[e.number] : Number(e.number) === o.value;
  }
  function y(e) {
    const n = {};
    for (let u = 0; u < e.length; u++) {
      const t = a.list.find((m) => Number(m.number) === Number(e[u]));
      n[t.number] = t;
    }
    return n;
  }
  function h(e, n) {
    a.multiple ? l.value[e] ? delete l.value[e] : l.value[e] = n : o.value = e, console.log(e, n), c("update:modelValue", i.value), c("change", i.value);
  }
  return (e, n) => {
    const u = $;
    return s(), g("div", { class: "tag-container", style: w(v.value) }, [(s(true), g(x, null, N(r.list, (t) => (s(), S(u, { key: t.number, type: d(t) ? "success" : "info", size: "large", effect: d(t) ? void 0 : "plain", onClick: (m) => h(t.number, t), class: "pointer" }, { default: k(() => [C("span", null, B(t.number), 1), V(e.$slots, "suffix", { data: t }, void 0, true)]), _: 2 }, 1032, ["type", "effect", "onClick"]))), 128))], 4);
  };
} }, E = H(j, [["__scopeId", "data-v-0fda5585"]]);
export {
  E as o
};
