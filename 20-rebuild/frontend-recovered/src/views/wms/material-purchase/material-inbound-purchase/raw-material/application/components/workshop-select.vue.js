import { xW as f, hV as h } from "../../../../../../../shared/runtime.js";
import { ref as w } from "vue";
import { computed as y } from "vue";
import { watch as b } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as v } from "vue";
import { createBlock as B } from "vue";
import { withCtx as k } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as x } from "vue";
import { mergeProps as V } from "vue";
import { unref as S } from "vue";
const C = { class: "customize-option-item" }, N = { class: "label" }, A = { __name: "workshop-select", props: { modelValue: { type: [Number, String], default: void 0 }, dataStructure: { type: Object, default: () => ({ key: "id", label: "name", value: "name" }) }, size: { type: String, default: "small" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择仓库" }, type: { type: [Number, String], default: void 0 }, showExtra: { type: Boolean, default: false } }, emits: ["change", "update:modelValue"], setup(t, { emit: c }) {
  const d = c, s = t, n = w(), { loaded: m, workshopNameV2: p } = f(), u = y(() => {
    let e = p.value;
    return s.type && (e = s.type === h.NORMAL.V ? e.filter((a) => !a.workshopId) : e.filter((a) => a.workshopId)), e;
  });
  b([() => s.modelValue, () => u.value], ([e, a]) => {
    a != null && a.length && (n.value = e, r(e));
  }, { immediate: true });
  function r(e) {
    var o;
    const a = (o = u.value.find((l) => l.name === e)) == null ? void 0 : o.id;
    d("change", a), d("update:modelValue", e);
  }
  return (e, a) => {
    const o = g("common-select");
    return v(), B(o, V({ modelValue: n.value, "onUpdate:modelValue": a[0] || (a[0] = (l) => n.value = l), allLabelText: "全部", clearable: t.clearable, "data-structure": t.dataStructure, disabled: t.disabled, loading: !S(m), multiple: t.multiple, options: u.value, placeholder: t.placeholder, showExtra: t.showExtra, showOptionAll: t.showOptionAll, size: t.size, filterable: "" }, e.$attrs, { onChange: r }), { view: k(({ data: l }) => [i("span", C, [i("span", N, x(l.name), 1)])]), _: 1 }, 16, ["modelValue", "clearable", "data-structure", "disabled", "loading", "multiple", "options", "placeholder", "showExtra", "showOptionAll", "size"]);
  };
} };
export {
  A as default
};
