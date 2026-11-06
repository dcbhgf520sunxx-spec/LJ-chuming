import { ref as i } from "vue";
import { computed as m } from "vue";
import { watch as f } from "vue";
import { openBlock as h } from "vue";
import { createBlock as y } from "vue";
import { unref as g } from "vue";
import { ElCascader as b } from "element-plus";
import { u as B } from "./use-dept-b8e95315.js";
const v = { __name: "dept-cascader", props: { modelValue: { type: [Array, Number] }, checkStrictly: { type: Boolean, default: false }, expandTrigger: { type: String, default: "hover" }, emitPath: { type: Boolean, default: false }, filterable: { type: Boolean, default: false }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, showAllLevels: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择部门" } }, emits: ["update:modelValue", "change"], setup(s, { emit: c }) {
  const t = c, e = s, a = i(), n = m(() => ({ value: "id", label: "name", children: "children", checkStrictly: e.checkStrictly, expandTrigger: e.expandTrigger, emitPath: e.emitPath, multiple: e.multiple }));
  f(() => e.modelValue, (l) => {
    l instanceof Array ? a.value = [...l] : a.value = l, o(l);
  }, { immediate: true });
  const { dept: p } = B();
  function o(l) {
    t("update:modelValue", l), t("change", l);
  }
  return (l, r) => {
    const d = b;
    return h(), y(d, { modelValue: a.value, "onUpdate:modelValue": r[0] || (r[0] = (u) => a.value = u), options: g(p), props: n.value, filterable: e.filterable, clearable: e.clearable, "show-all-levels": e.showAllLevels, placeholder: e.placeholder, onChange: o }, null, 8, ["modelValue", "options", "props", "filterable", "clearable", "show-all-levels", "placeholder"]);
  };
} };
export {
  v as _
};
