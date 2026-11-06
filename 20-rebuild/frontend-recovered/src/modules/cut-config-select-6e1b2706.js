import { useStore as z } from "vuex";
import { computed as p } from "vue";
import { watch as O } from "vue";
import { ref as E } from "vue";
import { openBlock as o } from "vue";
import { createBlock as y } from "vue";
import { withCtx as C } from "vue";
import { createElementBlock as V } from "vue";
import { Fragment as b } from "vue";
import { renderList as h } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as W } from "vue";
import { ElOption as w } from "element-plus";
import { ElOptionGroup as x } from "element-plus";
import { ElSelect as N } from "element-plus";
import { b as f, az as B, ai as A } from "../shared/runtime.js";
const K = (e) => {
  const l = z(), t = p(() => l.state.config.loaded.cutConfigs);
  if (t.value || l.dispatch("config/fetchCutConfig"), e) {
    const n = O(t, (u) => {
      u && setTimeout(() => {
        e(), n();
      }, 0);
    }, { immediate: true });
  }
  return { cutConfigs: p(() => l.state.config.cutConfigs || []), cutConfigKV: p(() => l.state.config.cutConfigKV), loaded: t };
}, D = { __name: "cut-config-select", props: { modelValue: { type: [Number, String], default: void 0 }, layOffWayType: { type: [Boolean, void 0], default: void 0 }, layWayConfigId: { type: Number, default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择切割配置" }, disabledValue: { type: Array, default: () => [] } }, emits: ["change", "update:modelValue"], setup(e, { emit: l }) {
  const t = l, n = e, u = E(), { loaded: k, cutConfigs: S } = K();
  O(() => n.modelValue, (d) => {
    u.value = d;
  }, { immediate: true });
  function T(d) {
    console.log(d, "val");
    let a = d;
    f(a) && (a = void 0);
    const c = !A(a, n.modelValue), r = f(a) && f(n.modelValue);
    c && !r && (t("update:modelValue", a), t("change", a));
  }
  return (d, a) => {
    const c = w, r = x, v = N;
    return o(), y(v, { modelValue: u.value, "onUpdate:modelValue": a[0] || (a[0] = (m) => u.value = m), size: e.size, multiple: e.multiple, "collapse-tags": e.collapseTags, loading: !s(k), clearable: e.clearable, filterable: "", placeholder: e.placeholder, onChange: T }, { default: C(() => [(o(true), V(b, null, h(s(S), (m, g) => (o(), V(b, { key: g }, [s(f)(e.layOffWayType) || !!s(B).V[g].V == !!e.layOffWayType ? (o(), y(r, { key: 0, label: s(B).VL[g] }, { default: C(() => [(o(true), V(b, null, h(m, (i) => (o(), y(c, { key: i.id, label: i.name, value: i.id, disabled: e.disabledValue ? e.disabledValue.indexOf(i.id) > -1 : false }, null, 8, ["label", "value", "disabled"]))), 128))]), _: 2 }, 1032, ["label"])) : W("", true)], 64))), 128))]), _: 1 }, 8, ["modelValue", "size", "multiple", "collapse-tags", "loading", "clearable", "placeholder"]);
  };
} };
export {
  D as _
};
