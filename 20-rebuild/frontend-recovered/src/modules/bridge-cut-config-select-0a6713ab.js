import { useStore as z } from "vuex";
import { computed as r } from "vue";
import { watch as B } from "vue";
import { ref as O } from "vue";
import { openBlock as s } from "vue";
import { createBlock as g } from "vue";
import { withCtx as C } from "vue";
import { createElementBlock as y } from "vue";
import { Fragment as V } from "vue";
import { renderList as h } from "vue";
import { unref as m } from "vue";
import { ElOption as w } from "element-plus";
import { ElOptionGroup as T } from "element-plus";
import { ElSelect as x } from "element-plus";
import { az as N, b as p, ai as A } from "../shared/runtime.js";
const D = (e) => {
  const a = z(), t = r(() => a.state.config.loaded.bridgeCutConfigs);
  if (t.value || a.dispatch("config/fetchBridgeCutConfig"), e) {
    const o = B(t, (n) => {
      n && setTimeout(() => {
        e(), o();
      }, 0);
    }, { immediate: true });
  }
  return { bridgeCutConfigs: r(() => a.state.config.bridgeCutConfigs || []), bridgeCutConfigKV: r(() => a.state.config.bridgeCutConfigKV), loaded: t };
}, W = { __name: "bridge-cut-config-select", props: { modelValue: { type: [Number, String], default: void 0 }, layWayConfigId: { type: Number, default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, isDisabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择切割配置" }, disabledValue: { type: Array, default: () => [] } }, emits: ["change", "update:modelValue"], setup(e, { emit: a }) {
  const t = a, o = e, n = O(), { loaded: S, bridgeCutConfigs: k } = D();
  B(() => o.modelValue, (u) => {
    n.value = u;
  }, { immediate: true });
  function v(u) {
    console.log(u, "val");
    let l = u;
    p(l) && (l = void 0);
    const d = !A(l, o.modelValue), f = p(l) && p(o.modelValue);
    d && !f && (t("update:modelValue", l), t("change", l));
  }
  return (u, l) => {
    const d = w, f = T, E = x;
    return s(), g(E, { modelValue: n.value, "onUpdate:modelValue": l[0] || (l[0] = (c) => n.value = c), size: e.size, multiple: e.multiple, "collapse-tags": e.collapseTags, loading: !m(S), clearable: e.clearable, filterable: "", placeholder: e.placeholder, onChange: v }, { default: C(() => [(s(true), y(V, null, h(m(k), (c, b) => (s(), g(f, { key: b + 1, label: m(N).VL[b] }, { default: C(() => [(s(true), y(V, null, h(c, (i) => (s(), g(d, { key: i.id, label: i.name, value: i.id, disabled: e.isDisabled ? i.boolNestCutEnum : e.disabledValue ? e.disabledValue.indexOf(i.id) > -1 : false }, null, 8, ["label", "value", "disabled"]))), 128))]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["modelValue", "size", "multiple", "collapse-tags", "loading", "clearable", "placeholder"]);
  };
} };
export {
  W as _
};
