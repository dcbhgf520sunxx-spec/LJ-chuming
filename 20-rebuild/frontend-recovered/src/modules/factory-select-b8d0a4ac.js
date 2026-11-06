import { b as c, ai as V } from "../shared/runtime.js";
import { useStore as b } from "vuex";
import { computed as f } from "vue";
import { watch as p } from "vue";
import { ref as B } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as v } from "vue";
import { createBlock as w } from "vue";
import { mergeProps as S } from "vue";
import { unref as m } from "vue";
const z = (e) => {
  const t = b(), o = f(() => t.state.config.loaded.factories);
  if (o.value || t.dispatch("config/fetchFactories"), e) {
    const s = p(o, (n) => {
      n && setTimeout(() => {
        e(), s();
      }, 0);
    }, { immediate: true });
  }
  return { factoryKV: f(() => t.state.config.factoryKV), factories: f(() => t.state.config.factories), loaded: o };
}, T = { __name: "factory-select", props: { modelValue: { type: [Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择工厂" }, onlyOneDefault: { type: Boolean, default: true } }, emits: ["change", "update:modelValue"], setup(e, { expose: t, emit: o }) {
  const s = o, n = e, i = B(), { loaded: g, factories: r } = z();
  p(() => n.modelValue, (a) => {
    i.value = a;
  }, { immediate: true });
  function y(a) {
    let l = a;
    c(l) && (l = void 0);
    const u = !V(l, n.modelValue), d = c(l) && c(n.modelValue);
    u && !d && (s("update:modelValue", l), s("change", l));
  }
  function h(a) {
    return r.value.find((l) => l.id === a);
  }
  return t({ getOption: h }), (a, l) => {
    const u = O("common-select");
    return v(), w(u, S(a.$attrs, { modelValue: i.value, "onUpdate:modelValue": l[0] || (l[0] = (d) => i.value = d), size: e.size, disabled: e.disabled, multiple: e.multiple, "collapse-tags": e.collapseTags, loading: !m(g), clearable: e.clearable, showOptionAll: e.showOptionAll, allLabelText: "全部工厂", filterable: "", placeholder: e.placeholder, options: m(r), "only-one-default": e.onlyOneDefault, onChange: y }), null, 16, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "showOptionAll", "placeholder", "options", "only-one-default"]);
  };
} };
export {
  T as _,
  z as u
};
