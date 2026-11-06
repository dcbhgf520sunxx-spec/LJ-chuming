import { ll as A, lm as x, ln as k, i as E, b as i, ai as z } from "../shared/runtime.js";
import { ref as H } from "vue";
import { computed as r } from "vue";
import { nextTick as M } from "vue";
import { watch as N } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as K } from "vue";
import { createBlock as T } from "vue";
import { withCtx as D } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as I } from "vue";
import { mergeProps as j } from "vue";
const F = { class: "customize-option-item" }, P = { class: "label" }, $ = { __name: "supplier-select", props: { modelValue: { type: [Number, String], default: void 0 }, size: { type: String, default: "small" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择供应商" }, mode: { type: String, default: "contained" }, typeMode: { type: String, default: "cross" }, showHide: { type: Boolean, default: false }, showExtra: { type: Boolean, default: false }, isAnnual: { type: Boolean, default: false }, default: { type: Boolean, default: false }, basicClass: { type: Number } }, emits: ["change", "update:modelValue"], setup(t, { emit: p }) {
  const u = p, l = t, o = H(), { loaded: y, suppliers: c, supplierKV: b } = A(V), { annualLoaded: h, annualSuppliers: g, annualSupplierKV: v } = x(), C = r(() => l.isAnnual ? h : y), d = r(() => {
    let e = [];
    if (l.isAnnual ? e = g.value : e = l.showHide ? c.value : c.value.filter((a) => a.boolHide === k.FALSE.V), l.basicClass) {
      if (l.mode === "contained") return e == null ? void 0 : e.filter((a) => (a.basicClass & l.basicClass) === a.basicClass);
      if (l.mode === "contain") return e == null ? void 0 : e.filter((a) => (a.basicClass & l.basicClass) === l.basicClass);
      if (l.mode === "cross") return e == null ? void 0 : e.filter((a) => a.basicClass & l.basicClass);
    }
    if (l.type) {
      if (l.typeMode === "contained") return e == null ? void 0 : e.filter((a) => (a.type & l.type) === a.type);
      if (l.typeMode === "contain") return e == null ? void 0 : e.filter((a) => (a.type & l.type) === l.type);
      if (l.typeMode === "cross") return e == null ? void 0 : e.filter((a) => a.type & l.type);
    }
    return e;
  });
  function B(e, a) {
    const s = l.isAnnual ? v.value : b.value, n = e ? s[e] : null, S = a ? s[a] : null;
    u("info-change", n, S);
  }
  function V() {
    E(o.value) ? B(o.value) : w();
  }
  function w() {
    M(() => {
      i(d.value) || o.value || l.default && (o.value = d.value[0].id, f(o.value));
    });
  }
  N(() => l.modelValue, (e) => {
    o.value = e;
  }, { immediate: true });
  function f(e) {
    let a = e;
    i(a) && (a = void 0);
    const s = !z(a, l.modelValue), n = i(a) && i(l.modelValue);
    s && !n && (u("update:modelValue", a), u("change", a));
  }
  return (e, a) => {
    const s = O("common-select-v2");
    return K(), T(s, j({ modelValue: o.value, "onUpdate:modelValue": a[0] || (a[0] = (n) => o.value = n), allLabelText: "全部", clearable: t.clearable, disabled: t.disabled, loading: !C.value, multiple: t.multiple, options: d.value, placeholder: t.placeholder, showExtra: t.showExtra, showOptionAll: t.showOptionAll, size: t.size, filterable: "" }, e.$attrs, { onChange: f }), { view: D(({ data: n }) => [m("span", F, [m("span", P, I(n.name), 1)])]), _: 1 }, 16, ["modelValue", "clearable", "disabled", "loading", "multiple", "options", "placeholder", "showExtra", "showOptionAll", "size"]);
  };
} };
export {
  $ as _
};
