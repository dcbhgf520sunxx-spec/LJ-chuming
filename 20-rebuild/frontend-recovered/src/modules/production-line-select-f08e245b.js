import { useStore as I } from "vuex";
import { computed as y } from "vue";
import { ref as v } from "vue";
import { watch as s } from "vue";
import { openBlock as f } from "vue";
import { createBlock as g } from "vue";
import { withCtx as S } from "vue";
import { createElementBlock as w } from "vue";
import { Fragment as L } from "vue";
import { renderList as P } from "vue";
import { unref as x } from "vue";
import { ElOption as T } from "element-plus";
import { ElSelect as E } from "element-plus";
import { b as N, i as p, V as z } from "../shared/runtime.js";
const C = () => {
  const t = I();
  return t.state.config.loaded.onlyProductLines || t.dispatch("config/fetchOnlyProductLines"), { onlyProductLines: y(() => t.state.config.onlyProductLines), loaded: y(() => t.state.config.loaded.onlyProductLines) };
}, Q = { __name: "production-line-select", props: { modelValue: { type: [Number, String], default: void 0 }, factoryId: { type: [Number, String], default: void 0 }, workshopId: { type: [Number, String], default: void 0 }, productType: { type: [Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择生产线" }, defaultValue: { type: Boolean, default: false } }, emits: ["change", "update:modelValue"], setup(t, { expose: b, emit: h }) {
  const m = h, a = t, u = v(), d = v([]), { loaded: V, onlyProductLines: i } = C();
  s(() => a.modelValue, (e) => {
    u.value = e, a.default && N(e) && p(d) && (u.value = d.value[0].value, r(u.value));
  }, { immediate: true }), s(i, (e) => {
    c();
  }, { immediate: true, deep: true }), s(() => a.factoryId, (e) => {
    c();
  }, { immediate: true }), s(() => a.workshopId, (e) => {
    c();
  }, { immediate: true });
  function r(e) {
    a.modelValue !== e && (m("update:modelValue", e), m("change", e));
  }
  function c() {
    d.value = [];
    let e = [];
    try {
      if (p(i.value)) {
        let l = z(i.value);
        a.factoryId && (l = l.filter((o) => a.factoryId === o.factoryId)), a.workshopId && (l = l.filter((o) => a.workshopId === o.workshopId)), a.productType && (l = l.filter((o) => a.productType & o.productType)), e = l.map((o) => ({ value: o.id, label: o.name }));
      }
    } catch (l) {
      console.log("获取生产线列表", l);
    } finally {
      d.value = e, p(d.value) && a.default && !u.value && (u.value = d.value[0].value), !d.value.some((o) => o.value === u.value) && !a.defaultValue && (u.value = void 0), r(u.value);
    }
  }
  function k(e) {
    return i.value.find((l) => l.id === e);
  }
  return b({ getOption: k }), (e, l) => {
    const o = T, B = E;
    return f(), g(B, { modelValue: u.value, "onUpdate:modelValue": l[0] || (l[0] = (n) => u.value = n), size: t.size, disabled: t.disabled, multiple: t.multiple, "collapse-tags": t.collapseTags, loading: !x(V), clearable: t.clearable, filterable: "", placeholder: t.placeholder, onChange: r }, { default: S(() => [(f(true), w(L, null, P(d.value, (n) => (f(), g(o, { key: n.value, label: n.label, value: n.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "placeholder"]);
  };
} };
export {
  Q as _
};
