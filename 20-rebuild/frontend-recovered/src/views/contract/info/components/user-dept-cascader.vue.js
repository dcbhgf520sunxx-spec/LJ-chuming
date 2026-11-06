import { ref as o } from "vue";
import { computed as S } from "vue";
import { watch as i } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as w } from "vue";
import { ElCascader as C } from "element-plus";
import { _ as N, ds as v, ai as A, b as y, V as E, i as d } from "../../../../shared/runtime.js";
const I = { __name: "user-dept-cascader", props: { modelValue: { type: [Array, Number, String], default: "" }, noDisabledVal: { type: Array, default: () => [] }, deptIds: { type: Array, default: () => [] }, size: { type: String, default: "default" }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, showAllLevels: { type: Boolean, default: false }, separator: { type: String, default: "/" }, placeholder: { type: String, default: "请选择用户" }, multiple: { type: Boolean, default: false }, checkStrictly: { type: Boolean, default: false }, emitPath: { type: Boolean, default: false }, showExtra: { type: Boolean, default: false }, extraOptionLabel: { type: String, default: "同上" }, extraOptionValue: { type: [Number, String, Array, Boolean], default: -1 } }, emits: ["change", "update:modelValue"], setup(l, { expose: b, emit: g }) {
  const u = g, t = l, c = o(), n = o(), s = o([]), { userDeptTree: V } = v(), B = S(() => ({ value: "id", label: "label", children: "children", expandTrigger: "hover", emitPath: t.emitPath, multiple: t.multiple, checkStrictly: t.checkStrictly }));
  i([V, () => t.deptIds], ([e]) => {
    D(e);
  }, { deep: true, immediate: true }), i(() => t.modelValue, (e) => {
    e instanceof Array ? n.value = [...e] : n.value = e, p(e);
  }, { immediate: true }), i(() => t.noDisabledVal, () => {
    h(s.value);
  }, { immediate: true, deep: true });
  function p(e) {
    const a = !A(e, t.modelValue), r = y(e) && y(t.modelValue);
    return a && !r ? (u("update:modelValue", e), u("change", e), true) : false;
  }
  function D(e) {
    s.value = [];
    try {
      e && (s.value = f(E(e)), t.showExtra && s.value.unshift({ id: t.extraOptionValue, label: t.extraOptionLabel }));
    } catch (a) {
      console.log("获取人员部门树失败", a);
    }
  }
  function f(e) {
    return e.filter((a) => (a.isUser && (a.disabled = true), d(a.children) ? (a.children.forEach((r) => {
      r.parentDeptId = a.id, r.parentDeptName = a.label;
    }), a.children = f(a.children), d(a.children)) : a.isUser));
  }
  function h(e) {
    e.forEach((a) => (a.disabled = a.isUser ? !t.noDisabledVal.includes(a.id) : a.disabled, d(a.children) && h(a.children), a));
  }
  function x() {
    const e = c.value.getCheckedNodes(true);
    return e.length ? e[0].data : {};
  }
  function m(e) {
    return e.parent ? m(e.parent) : e;
  }
  return b({ getNodeInfo: x, getParentNode: m }), (e, a) => {
    const r = C;
    return _(), w(r, { ref_key: "userDeptRef", ref: c, class: "user-dept-cascader", modelValue: n.value, "onUpdate:modelValue": a[0] || (a[0] = (k) => n.value = k), placeholder: l.placeholder, options: s.value, props: B.value, "show-all-levels": l.showAllLevels, separator: l.separator, clearable: l.clearable, disabled: l.disabled, filterable: "", size: l.size, onChange: p }, null, 8, ["modelValue", "placeholder", "options", "props", "show-all-levels", "separator", "clearable", "disabled", "size"]);
  };
} }, U = N(I, [["__scopeId", "data-v-f63bef2f"]]);
export {
  U as default
};
