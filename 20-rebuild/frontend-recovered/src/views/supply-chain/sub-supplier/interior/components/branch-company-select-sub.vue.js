import { wD as h, b as d, ai as b } from "../../../../../shared/runtime.js";
import { ref as g } from "vue";
import { computed as y } from "vue";
import { watch as w } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as V } from "vue";
import { createBlock as v } from "vue";
import { withCtx as C } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as x } from "vue";
import { mergeProps as E } from "vue";
import { unref as S } from "vue";
const z = { class: "customize-option-item" }, A = { class: "label" }, O = { __name: "branch-company-select-sub", props: { modelValue: { type: [Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showAll: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择公司主体" }, defaultLevel: { type: [Number, String], default: void 0 }, showExtra: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false } }, emits: ["change", "update:modelValue"], setup(a, { emit: m }) {
  const u = m, t = a, n = g(), { loaded: c, branchCompanyEnum: r } = h(), f = y(() => {
    let l = r.value || [];
    return t.defaultLevel && (l = l.filter((e) => e.level === t.defaultLevel)), l;
  });
  w(() => t.modelValue, (l) => {
    n.value = l;
  }, { immediate: true });
  function p(l) {
    let e = l;
    d(e) && (e = void 0);
    const s = !b(e, t.modelValue), o = d(e) && d(t.modelValue);
    s && !o && (u("update:modelValue", e), u("change", e));
  }
  return (l, e) => {
    const s = B("common-select");
    return V(), v(s, E({ modelValue: n.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => n.value = o), allLabelText: "全部", clearable: a.clearable, disabled: a.disabled, loading: !S(c), multiple: a.multiple, options: f.value, placeholder: a.placeholder, showExtra: a.showExtra, showOptionAll: a.showOptionAll, size: a.size, filterable: "" }, l.$attrs, { onChange: p }), { view: C(({ data: o }) => [i("span", z, [i("span", A, x(o.name), 1)])]), _: 1 }, 16, ["modelValue", "clearable", "disabled", "loading", "multiple", "options", "placeholder", "showExtra", "showOptionAll", "size"]);
  };
} };
export {
  O as default
};
