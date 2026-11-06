import { wD as b, b as d, ai as g } from "../../../../../shared/runtime.js";
import { ref as y } from "vue";
import { computed as w } from "vue";
import { watch as B } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as v } from "vue";
import { createBlock as C } from "vue";
import { withCtx as x } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as E } from "vue";
import { mergeProps as S } from "vue";
import { unref as z } from "vue";
const A = { class: "customize-option-item" }, k = { class: "label" }, N = { __name: "branch-company-select-sub", props: { modelValue: { type: [Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showAll: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择公司主体" }, defaultLevel: { type: [Number, String], default: void 0 }, showExtra: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false } }, emits: ["change", "update:modelValue"], setup(a, { expose: c, emit: r }) {
  const u = r, t = a, s = y(), { loaded: f, branchCompanyEnum: p } = b(), i = w(() => {
    let l = p.value || [];
    return t.defaultLevel && (l = l.filter((e) => e.level === t.defaultLevel)), l;
  });
  B(() => t.modelValue, (l) => {
    s.value = l;
  }, { immediate: true });
  function h(l) {
    let e = l;
    d(e) && (e = void 0);
    const n = !g(e, t.modelValue), o = d(e) && d(t.modelValue);
    n && !o && (u("update:modelValue", e), u("change", e));
  }
  return c({ options: i }), (l, e) => {
    const n = V("common-select");
    return v(), C(n, S({ modelValue: s.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => s.value = o), allLabelText: "全部", clearable: a.clearable, disabled: a.disabled, loading: !z(f), multiple: a.multiple, options: i.value, placeholder: a.placeholder, showExtra: a.showExtra, showOptionAll: a.showOptionAll, size: a.size, filterable: "" }, l.$attrs, { onChange: h }), { view: x(({ data: o }) => [m("span", A, [m("span", k, E(o.name), 1)])]), _: 1 }, 16, ["modelValue", "clearable", "disabled", "loading", "multiple", "options", "placeholder", "showExtra", "showOptionAll", "size"]);
  };
} };
export {
  N as default
};
