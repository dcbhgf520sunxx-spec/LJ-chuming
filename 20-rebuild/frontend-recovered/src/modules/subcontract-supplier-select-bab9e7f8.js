import { b as s, t_ as B, i as k, ai as I } from "../shared/runtime.js";
import { ref as d } from "vue";
import { computed as S } from "vue";
import { watch as b } from "vue";
import { nextTick as j } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as C } from "vue";
import { createBlock as A } from "vue";
import { mergeProps as z } from "vue";
const x = { __name: "subcontract-supplier-select", props: { modelValue: { type: [Number, String], default: void 0 }, projectId: { type: [Number, String], default: void 0 }, size: { type: String, default: "small" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, disabledVal: { type: Array, default: () => [] }, default: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择分包单位" } }, emits: ["change", "update:modelValue"], setup(a, { emit: g }) {
  const r = g, t = a, c = d([]), i = d({}), p = d(false), o = d(), f = S(() => c.value);
  b(() => t.modelValue, (l) => {
    o.value = l;
  }, { immediate: true }), b(() => t.projectId, (l) => {
    h();
  }, { immediate: true });
  async function h() {
    if (c.value = [], i.value = {}, p.value = false, !s(t.projectId)) try {
      const l = await B({ projectId: t.projectId });
      c.value = l, i.value = l.reduce((e, u) => (e[u.id] = u, e), {}), y();
    } catch (l) {
      console.log(l);
    } finally {
      p.value = true;
    }
  }
  function m(l) {
    let e = l;
    s(e) && (e = void 0);
    const u = !I(e, t.modelValue), n = s(e) && s(t.modelValue);
    u && !n && (r("update:modelValue", e), r("change", e), v(e, t.modelValue));
  }
  function v(l, e) {
    const u = l ? i.value[l] : null, n = e ? i.value[e] : null;
    r("info-change", u, n);
  }
  function y() {
    k(o.value) ? v(o.value) : V();
  }
  function V() {
    j(() => {
      if (!(s(f.value) || o.value) && t.default) {
        o.value = f.value[0].id, m(o.value);
        return;
      }
    });
  }
  return (l, e) => {
    const u = w("common-select");
    return C(), A(u, z(l.$attrs, { modelValue: o.value, "onUpdate:modelValue": e[0] || (e[0] = (n) => o.value = n), size: a.size, disabled: a.disabled, multiple: a.multiple, loading: !p.value, clearable: a.clearable, disabledVal: a.disabledVal, showOptionAll: a.showOptionAll, filterable: "", placeholder: a.placeholder, dataStructure: { key: "supplierId", label: "supplierName", value: "supplierId" }, options: f.value, onChange: m }), null, 16, ["modelValue", "size", "disabled", "multiple", "loading", "clearable", "disabledVal", "showOptionAll", "placeholder", "options"]);
  };
} };
export {
  x as _
};
