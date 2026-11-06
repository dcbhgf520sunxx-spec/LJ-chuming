import { useStore as m } from "vuex";
import { computed as r } from "vue";
import { watch as i } from "vue";
import { ref as g } from "vue";
import { openBlock as h } from "vue";
import { createBlock as b } from "vue";
import { unref as V } from "vue";
import { ElCascader as _ } from "element-plus";
const y = (n) => {
  const t = m(), l = r(() => t.state.config.loaded.regional);
  if (l.value || t.dispatch("config/fetchRegional"), n) {
    const a = i(l, (o) => {
      o && setTimeout(() => {
        n(), a();
      }, 0);
    }, { immediate: true });
  }
  return { regional: r(() => t.state.config.regional), loaded: l };
}, w = { __name: "region-cascader", props: { modelValue: { type: [Array, Number], default: void 0 }, filterable: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择地区" } }, emits: ["update:modelValue", "change"], setup(n, { emit: t }) {
  const l = t, a = n, o = g(), u = r(() => ({ label: "name", value: "id", children: "children" }));
  i(() => a.modelValue, (e) => {
    e instanceof Array ? o.value = [...e] : o.value = e, s(e);
  }, { immediate: true });
  const { regional: d } = y();
  function s(e) {
    l("update:modelValue", e), l("change", e);
  }
  return (e, c) => {
    const p = _;
    return h(), b(p, { modelValue: o.value, "onUpdate:modelValue": c[0] || (c[0] = (f) => o.value = f), options: V(d), props: u.value, filterable: a.filterable, clearable: a.clearable, "show-all-levels": a.showAllLevels, placeholder: a.placeholder, onChange: s }, null, 8, ["modelValue", "options", "props", "filterable", "clearable", "show-all-levels", "placeholder"]);
  };
} };
export {
  w as _
};
