import { ref as m } from "vue";
import { watch as y } from "vue";
import { openBlock as s } from "vue";
import { createBlock as f } from "vue";
import { withCtx as x } from "vue";
import { createCommentVNode as w } from "vue";
import { createElementBlock as B } from "vue";
import { Fragment as S } from "vue";
import { renderList as E } from "vue";
import { unref as T } from "vue";
import { ElOption as O } from "element-plus";
import { ElSelect as N } from "element-plus";
import { dS as A, b as C, i as c, V as I } from "../shared/runtime.js";
const F = { __name: "index", props: { modelValue: { type: [Number, String], default: void 0 }, factoryId: { type: [Number, String], default: void 0 }, workshopType: { type: [Number, String, Array], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择车间" }, disabledVal: { type: Array, default: () => [] }, extraOptionLabel: { type: String, default: "同上" }, extraOptionValue: { type: [Number, String, Array, Boolean], default: -1 }, defaultValue: { type: Boolean, default: false }, showExtra: { type: Boolean, default: false } }, emits: ["change", "update:modelValue"], setup(a, { expose: b, emit: v }) {
  const p = v, e = a, o = m(), d = m([]), { loaded: h, workshops: i } = A();
  y(() => e.modelValue, (t) => {
    o.value = t, e.default && C(t) && c(d.value) && (o.value = d.value[0].value, r(o.value));
  }, { immediate: true }), y([i, () => e.factoryId, () => e.workshopType], () => {
    g();
  }, { immediate: true, deep: true });
  function r(t) {
    e.modelValue !== t && (p("update:modelValue", t), p("change", t));
  }
  function g() {
    d.value = [];
    let t = [];
    try {
      if (c(i.value)) {
        let l = I(i.value);
        e.factoryId && (l = l.filter((u) => e.factoryId === u.factoryId)), e.workshopType && (l = l.filter((u) => Array.isArray(e.workshopType) ? e.workshopType.includes(u.type) : e.workshopType === u.type)), t = l.map((u) => ({ value: u.id, label: u.name }));
      }
    } catch (l) {
      console.log("获取车间列表", l);
    } finally {
      d.value = t, c(d.value) && e.default && !o.value && (o.value = d.value[0].value), !d.value.some((u) => u.value === o.value) && !e.defaultValue && !e.showExtra && (o.value = void 0), r(o.value);
    }
  }
  function V(t) {
    return i.value.find((l) => l.id === t);
  }
  return b({ getOption: V }), (t, l) => {
    const u = O, k = N;
    return s(), f(k, { modelValue: o.value, "onUpdate:modelValue": l[0] || (l[0] = (n) => o.value = n), clearable: a.clearable, "collapse-tags": a.collapseTags, disabled: a.disabled, loading: !T(h), multiple: a.multiple, placeholder: a.placeholder, size: a.size, filterable: "", onChange: r }, { default: x(() => [a.showExtra ? (s(), f(u, { key: -2, label: a.extraOptionLabel, value: a.extraOptionValue, disabled: a.disabledVal.includes(a.extraOptionValue) }, null, 8, ["label", "value", "disabled"])) : w("", true), (s(true), B(S, null, E(d.value, (n) => (s(), f(u, { key: n.value, label: n.label, value: n.value, disabled: a.disabledVal.includes(n.value) }, null, 8, ["label", "value", "disabled"]))), 128))]), _: 1 }, 8, ["modelValue", "clearable", "collapse-tags", "disabled", "loading", "multiple", "placeholder", "size"]);
  };
} };
export {
  F as _
};
