import { _ as V, b as i, ai as k } from "../shared/runtime.js";
import { useStore as w } from "vuex";
import { computed as c } from "vue";
import { watch as m } from "vue";
import { ref as B } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as W } from "vue";
import { createBlock as S } from "vue";
import { unref as _ } from "vue";
const C = (a) => {
  const n = w(), s = c(() => n.state.config.loaded.manufWarehouse);
  if (s.value || n.dispatch("config/fetchManufWarehouse"), a) {
    const l = m(s, (o) => {
      o && setTimeout(() => {
        a(), l();
      }, 0);
    }, { immediate: true });
  }
  return { manufWarehouse: c(() => n.state.config.manufWarehouse), loaded: s };
};
const A = { __name: "manuf-warehouse-select", props: { modelValue: { type: [Array, Number, String] }, workshopId: { type: [Array, Number] }, size: { type: String, default: "small" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, disabledVal: { type: Array, default: () => [] }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, onlyOneDefault: { type: Boolean, default: false }, placeholder: { type: String, default: "选择库位" } }, emits: ["change", "update:modelValue", "infoChange"], setup(a, { emit: n }) {
  const s = n, l = a, o = B(), { loaded: h, manufWarehouse: g } = C(), u = c(() => {
    let t = g.value || [];
    return l.workshopId && (Array.isArray(l.workshopId) ? t = t.filter((e) => l.workshopId.includes(e.workshopId)) : t = t.filter((e) => l.workshopId === e.workshopId)), t || [];
  });
  m(u, (t) => {
    v();
  }), m(() => l.modelValue, (t) => {
    o.value = t, p();
  }, { immediate: true });
  function d(t) {
    let e = t;
    i(e) && (e = void 0);
    const r = !k(e, l.modelValue), f = i(e) && i(l.modelValue);
    if (r && !f) {
      const y = u.value.find((b) => b.id === e) || {};
      s("update:modelValue", e), s("infoChange", y), s("change", e);
    }
  }
  function v() {
    p();
  }
  function p() {
    if (!(i(u.value) || o.value)) {
      if (l.onlyOneDefault && u.value.length === 1) {
        o.value = u.value[0].value, d(o.value);
        return;
      }
      if (l.default) {
        o.value = u.value[0].value, d(o.value);
        return;
      }
      d(o.value);
    }
  }
  return (t, e) => {
    const r = I("common-select");
    return W(), S(r, { modelValue: o.value, "onUpdate:modelValue": e[0] || (e[0] = (f) => o.value = f), clearable: a.clearable, "collapse-tags": a.collapseTags, disabled: a.disabled, loading: !_(h), multiple: a.multiple, options: u.value, disabledVal: a.disabledVal, placeholder: a.placeholder, size: a.size, filterable: "", onChange: d }, null, 8, ["modelValue", "clearable", "collapse-tags", "disabled", "loading", "multiple", "options", "disabledVal", "placeholder", "size"]);
  };
} }, D = V(A, [["__scopeId", "data-v-41545bee"]]);
export {
  D as m
};
