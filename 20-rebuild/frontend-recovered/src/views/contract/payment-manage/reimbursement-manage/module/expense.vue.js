import { ref as r } from "vue";
import { computed as k } from "vue";
import { watch as m } from "vue";
import { openBlock as B } from "vue";
import { createBlock as S } from "vue";
import { ElCascader as _ } from "element-plus";
import { _ as w, ai as E, b as h, i as y } from "../../../../../shared/runtime.js";
import { g as N } from "../../../../../modules/expense-config-93f15b94.js";
const A = { __name: "expense", props: { modelValue: { type: [Array, Number, String], default: "" }, disabledVal: { type: Array, default: () => [] }, size: { type: String, default: "default" }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, showAllLevels: { type: Boolean, default: true }, separator: { type: String, default: "/" }, placeholder: { type: String, default: "请选择" }, multiple: { type: Boolean, default: false }, checkStrictly: { type: Boolean, default: true }, emitPath: { type: Boolean, default: false }, showExtra: { type: Boolean, default: false }, extraOptionLabel: { type: String, default: "同上" }, extraOptionValue: { type: [Number, String, Array, Boolean], default: -1 }, dataIndex: { type: Number } }, emits: ["change", "update:modelValue"], setup(o, { expose: g, emit: b }) {
  const i = b, t = o, c = r(), s = r(), d = r([]), x = k(() => ({ value: "id", label: "label", children: "links", expandTrigger: "hover", emitPath: t.emitPath, multiple: t.multiple, checkStrictly: t.checkStrictly }));
  V();
  async function V() {
    let e = [];
    try {
      const { content: a = [] } = await N();
      a && a.length > 0 && a.forEach((l) => {
        l.label = l.name, l.type = 1, l.links.length > 0 && l.links.forEach((n) => {
          n.parentId = l.id, n.type = 2;
        });
      }), e = a;
    } catch (a) {
      console.log("获取报销类别", a);
    } finally {
      d.value = e.length > 0 ? e : [];
    }
  }
  m(() => t.modelValue, (e) => {
    e instanceof Array ? s.value = [...e] : s.value = e, u(e);
  }, { immediate: true }), m(() => t.disabledVal, () => {
    p(d.value);
  }, { immediate: true, deep: true });
  function u(e) {
    const a = !E(e, t.modelValue), l = h(e) && h(t.modelValue);
    if (a && !l) {
      i("update:modelValue", e);
      const n = f();
      return y(n) && (n.dataIndex = t.dataIndex), i("change", n), true;
    }
    return false;
  }
  function p(e) {
    e.forEach((a) => (a.disabled = t.disabledVal.includes(a.id), y(a.links) && p(a.links), a));
  }
  function f() {
    const e = c.value.getCheckedNodes();
    return e.length ? e[0].data : {};
  }
  return g({ getNodeInfo: f }), (e, a) => {
    const l = _;
    return B(), S(l, { ref_key: "expenseRef", ref: c, class: "expense-cascader", modelValue: s.value, "onUpdate:modelValue": a[0] || (a[0] = (n) => s.value = n), placeholder: o.placeholder, options: d.value, props: x.value, "show-all-levels": o.showAllLevels, separator: o.separator, clearable: o.clearable, disabled: o.disabled, filterable: "", size: o.size, onChange: u }, null, 8, ["modelValue", "placeholder", "options", "props", "show-all-levels", "separator", "clearable", "disabled", "size"]);
  };
} }, P = w(A, [["__scopeId", "data-v-91d0c73c"]]);
export {
  P as default
};
