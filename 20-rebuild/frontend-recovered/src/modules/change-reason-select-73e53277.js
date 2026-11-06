import { b as u, ai as h } from "../shared/runtime.js";
import { useStore as b } from "vuex";
import { computed as c } from "vue";
import { watch as f } from "vue";
import { ref as C } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as y } from "vue";
import { createBlock as B } from "vue";
import { mergeProps as w } from "vue";
import { unref as m } from "vue";
const R = (e) => {
  const o = b(), l = c(() => o.state.config.loaded.changeReasonConfig);
  if (console.log(l), l.value || o.dispatch("config/fetchChangeReasonConfig"), e) {
    const t = f(l, (n) => {
      n && setTimeout(() => {
        e(), t();
      }, 0);
    }, { immediate: true });
  }
  return { changeReasonConfig: c(() => o.state.config.changeReasonConfig), loaded: l };
}, z = { __name: "change-reason-select", props: { modelValue: { type: [Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择变更原因" } }, emits: ["change", "update:modelValue"], setup(e, { emit: o }) {
  const l = o, t = e, n = C(), { loaded: r, changeReasonConfig: g } = R();
  f(() => t.modelValue, (s) => {
    n.value = s;
  }, { immediate: true });
  function p(s) {
    let a = s;
    u(a) && (a = void 0);
    const i = !h(a, t.modelValue), d = u(a) && u(t.modelValue);
    i && !d && (l("update:modelValue", a), l("change", a));
  }
  return (s, a) => {
    const i = V("common-select");
    return y(), B(i, w(s.$attrs, { modelValue: n.value, "onUpdate:modelValue": a[0] || (a[0] = (d) => n.value = d), size: e.size, disabled: e.disabled, multiple: e.multiple, loading: !m(r), clearable: e.clearable, showOptionAll: e.showOptionAll, allLabelText: "全部", filterable: "", placeholder: e.placeholder, options: m(g), onChange: p }), null, 16, ["modelValue", "size", "disabled", "multiple", "loading", "clearable", "showOptionAll", "placeholder", "options"]);
  };
} };
export {
  z as _
};
