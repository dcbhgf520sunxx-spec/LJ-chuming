import { hW as w, hV as y, b as d, ai as g } from "../shared/runtime.js";
import { ref as b } from "vue";
import { computed as V } from "vue";
import { watch as v } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as k } from "vue";
import { createBlock as x } from "vue";
import { withCtx as C } from "vue";
import { createElementVNode as t } from "vue";
import { toDisplayString as r } from "vue";
import { mergeProps as A } from "vue";
import { unref as N } from "vue";
const S = { style: { "overflow-x": "auto", width: "100%" } }, z = { class: "customize-option-item" }, E = { class: "label" }, O = { class: "extra-label" }, L = { __name: "workshop-select", props: { modelValue: { type: [Array, Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择车间" }, type: { type: [Number, String], default: void 0 }, showExtra: { type: Boolean, default: false } }, emits: ["change", "update:modelValue"], setup(a, { emit: p }) {
  const u = p, s = a, n = b(), { loaded: m, workshopName: c } = w(), f = V(() => {
    let l = c.value;
    return s.type && (l = s.type === y.NORMAL.V ? l.filter((e) => !e.workshopId) : l.filter((e) => e.workshopId)), l;
  });
  v(() => s.modelValue, (l) => {
    n.value = l;
  }, { immediate: true });
  function h(l) {
    let e = l;
    d(e) && (e = void 0);
    const i = !g(e, s.modelValue), o = d(e) && d(s.modelValue);
    i && !o && (u("update:modelValue", e), u("change", e));
  }
  return (l, e) => {
    const i = B("common-select-v2");
    return k(), x(i, A(l.$attrs, { modelValue: n.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => n.value = o), size: a.size, disabled: a.disabled, multiple: a.multiple, loading: !N(m), clearable: a.clearable, showOptionAll: a.showOptionAll, allLabelText: "全部", showExtra: a.showExtra, filterable: "", placeholder: a.placeholder, options: f.value, onChange: h }), { view: C(({ data: o }) => [t("div", S, [t("span", z, [t("span", E, r(o.name), 1), t("span", null, [t("span", O, [e[1] || (e[1] = t("span", { class: "title" }, "车间类型：", -1)), t("span", null, r(o.workshopId ? "车间" : "普通"), 1)])])])])]), _: 1 }, 16, ["modelValue", "size", "disabled", "multiple", "loading", "clearable", "showOptionAll", "showExtra", "placeholder", "options"]);
  };
} };
export {
  L as _
};
