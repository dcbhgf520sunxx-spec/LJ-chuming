import { _ as w, ke as B, bD as i, b as y, iV as N } from "../../../../../shared/runtime.js";
import { ref as c } from "vue";
import { onMounted as C } from "vue";
import { watchEffect as f } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as T } from "vue";
import { unref as p } from "vue";
import { Fragment as k } from "vue";
import { createElementVNode as I } from "vue";
import { createCommentVNode as S } from "vue";
const L = { class: "invoice-type-select flex-rsc child-mr-10" }, O = { __name: "invoice-type-select-private", props: { invoiceType: { type: Number }, taxRateTypeValue: { type: [Number, String] }, classification: { type: Number }, unshowOptions: { type: Array, default: () => [] }, default: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, clearable: { type: Boolean, default: false } }, emits: ["update:invoiceType", "update:taxRateTypeValue", "change"], setup(_, { emit: x }) {
  const o = x, a = _, l = c(), n = c(), { loaded: g } = B(), s = c([]), h = async () => {
    try {
      let { content: e } = await N();
      e = e.map((t) => ({ ...t, value: Number(t.value) })), s.value = e || [];
    } catch (e) {
      console.log(e);
    }
  };
  C(async () => {
    await h();
  }), f(() => {
    l.value = a.invoiceType, V();
  }), f(() => {
    var e;
    (e = s.value) != null && e.length && a.taxRateTypeValue && (n.value = Number(a.taxRateTypeValue));
  });
  function V() {
    if (!l.value && a.default) {
      l.value = i.SPECIAL.V, r(l.value);
      return;
    }
  }
  function r(e) {
    y(e) && (e = void 0), o("update:invoiceType", e), o("change", {});
  }
  function d(e) {
    y(e) && (e = void 0), o("update:taxRateTypeValue", e), o("change", {});
  }
  function R(e) {
    n.value = e.target.value || n.value, d(n.value);
  }
  return (e, t) => {
    const v = E("common-select-v2");
    return m(), b("span", L, [T(v, { modelValue: l.value, "onUpdate:modelValue": t[0] || (t[0] = (u) => l.value = u), clearable: a.clearable, disabled: a.disabled, options: p(i).ENUM, unshowOptions: a.unshowOptions, placeholder: "选择票据类型", style: { width: "150px" }, type: "enum", onChange: r }, null, 8, ["modelValue", "clearable", "disabled", "options", "unshowOptions"]), l.value !== p(i).RECEIPT.V ? (m(), b(k, { key: 0 }, [T(v, { modelValue: n.value, "onUpdate:modelValue": t[1] || (t[1] = (u) => n.value = u), clearable: a.clearable, "data-structure": { key: "id", label: "label", value: "value" }, disabled: a.disabled, loading: !p(g), options: s.value, "allow-create": "", filterable: "", placeholder: "税率", style: { width: "80px" }, onBlur: R, onChange: d }, null, 8, ["modelValue", "clearable", "disabled", "loading", "options"]), t[2] || (t[2] = I("span", null, "%", -1))], 64)) : S("", true)]);
  };
} }, D = w(O, [["__scopeId", "data-v-91227695"]]);
export {
  D as default
};
