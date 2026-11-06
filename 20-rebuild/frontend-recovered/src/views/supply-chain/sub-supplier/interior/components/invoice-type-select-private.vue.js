import { _ as w, ke as R, bD as u, b as y, iV as B } from "../../../../../shared/runtime.js";
import { ref as i } from "vue";
import { onMounted as C } from "vue";
import { watchEffect as E } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as b } from "vue";
import { unref as c } from "vue";
import { Fragment as k } from "vue";
import { createElementVNode as I } from "vue";
import { createCommentVNode as L } from "vue";
const O = { class: "invoice-type-select flex-rsc child-mr-10" }, P = { __name: "invoice-type-select-private", props: { invoiceType: { type: Number }, taxRateTypeValue: { type: Number, default: void 0 }, classification: { type: Number }, unshowOptions: { type: Array, default: () => [] }, default: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, clearable: { type: Boolean, default: false } }, emits: ["update:invoiceType", "update:taxRateTypeValue", "change"], setup(_, { emit: T }) {
  const o = T, t = _, l = i(), n = i(), { loaded: h } = R(), d = i([]), x = async () => {
    try {
      const { content: e } = await B();
      d.value = e.map((a) => ({ ...a, label: a.label + "%" }));
    } catch (e) {
      console.log(e);
    }
  };
  C(async () => {
    await x();
  }), E(() => {
    l.value = t.invoiceType, g();
  });
  function g() {
    if (!l.value && t.default) {
      l.value = u.SPECIAL.V, p(l.value);
      return;
    }
  }
  function p(e) {
    y(e) && (e = void 0), o("update:invoiceType", e), o("change", {});
  }
  function r(e) {
    y(e) && (e = void 0), o("update:taxRateTypeValue", e), o("change", {});
  }
  function V(e) {
    n.value = e.target.value || n.value, r(n.value);
  }
  return (e, a) => {
    const f = N("common-select");
    return m(), v("span", O, [b(f, { modelValue: l.value, "onUpdate:modelValue": a[0] || (a[0] = (s) => l.value = s), clearable: t.clearable, disabled: t.disabled, options: c(u).ENUM, unshowOptions: t.unshowOptions, placeholder: "选择票据类型", style: { width: "150px" }, type: "enum", onChange: p }, null, 8, ["modelValue", "clearable", "disabled", "options", "unshowOptions"]), l.value !== c(u).RECEIPT.V ? (m(), v(k, { key: 0 }, [b(f, { modelValue: n.value, "onUpdate:modelValue": a[1] || (a[1] = (s) => n.value = s), clearable: t.clearable, "data-structure": { key: "id", label: "label", value: "value" }, disabled: t.disabled, loading: !c(h), options: d.value, "allow-create": "", default: "", filterable: "", placeholder: "税率", style: { width: "80px" }, onBlur: V, onChange: r }, null, 8, ["modelValue", "clearable", "disabled", "loading", "options"]), a[2] || (a[2] = I("span", null, "%", -1))], 64)) : L("", true)]);
  };
} }, D = w(P, [["__scopeId", "data-v-6650391a"]]);
export {
  D as default
};
