import { _ as k, u as h } from "../../../../../shared/runtime.js";
import { ref as V } from "vue";
import { computed as g } from "vue";
import { resolveComponent as n } from "vue";
import { openBlock as C } from "vue";
import { createBlock as B } from "vue";
import { withCtx as s } from "vue";
import { renderSlot as r } from "vue";
import { createVNode as w } from "vue";
import { createElementVNode as x } from "vue";
import { unref as i } from "vue";
const A = { class: "container" }, I = { __name: "deatil-record", props: { modelValue: { type: Boolean, required: true }, title: { type: String, default: "付款与开票记录" }, hiddenItem: { type: Array, default: () => [] } }, emits: ["update:modelValue", "change"], setup(d, { emit: c }) {
  const t = d, o = V(1), a = c, { visible: u, handleClose: m } = h({ emit: a, props: t }), p = [{ label: "付款记录", key: 1 }, { label: "收款记录", key: 2 }, { label: "开票记录", key: 3 }, { label: "收票记录", key: 4 }], _ = g(() => p.filter((e) => !t.hiddenItem.includes(e.key))), f = (e) => {
    a("change", e);
  };
  return (e, l) => {
    const b = n("common-radio-button"), y = n("common-drawer");
    return C(), B(y, { "append-to-body": true, "before-close": i(m), title: t.title, visible: i(u), size: "100%" }, { titleAfter: s(() => [r(e.$slots, "titleAfter", {}, void 0, true)]), content: s(() => [w(b, { modelValue: o.value, "onUpdate:modelValue": l[0] || (l[0] = (v) => o.value = v), dataStructure: { key: "key", label: "label", value: "key" }, options: _.value, class: "filter-item", onChange: f }, null, 8, ["modelValue", "options"]), x("div", A, [r(e.$slots, "table", {}, void 0, true)])]), _: 3 }, 8, ["before-close", "title", "visible"]);
  };
} }, R = k(I, [["__scopeId", "data-v-15610813"]]);
export {
  R as default
};
