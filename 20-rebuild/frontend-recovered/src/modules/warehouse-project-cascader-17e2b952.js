import { pB as s, fv as g } from "../shared/runtime.js";
import { ref as d } from "vue";
import { watch as m } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as V } from "vue";
import { createBlock as C } from "vue";
import { mergeProps as h } from "vue";
import { unref as u } from "vue";
import { createCommentVNode as T } from "vue";
import { createVNode as b } from "vue";
import { Fragment as v } from "vue";
const W = { __name: "warehouse-project-cascader", props: { projectWarehouseType: { type: Number }, projectId: { type: [Number, String] }, showOptionAll: { type: Boolean, default: true }, showProjectWarehouseType: { type: Boolean, default: true } }, emits: ["change", "update:projectWarehouseType", "update:projectId"], setup(r, { emit: y }) {
  const o = y, t = d(), n = d(), p = r;
  m(() => p.projectWarehouseType, (e) => {
    t.value = e;
  }, { immediate: true }), m(() => p.projectId, (e) => {
    n.value = e;
  }, { immediate: true });
  function j(e) {
    e === s.PUBLIC.V && c(void 0), o("update:projectWarehouseType", e), o("change");
  }
  function c(e) {
    o("update:projectId", e), o("change");
  }
  return (e, a) => {
    const f = w("common-radio-button");
    return i(), V(v, null, [r.showProjectWarehouseType ? (i(), C(f, h({ key: 0, modelValue: t.value, "onUpdate:modelValue": a[0] || (a[0] = (l) => t.value = l), options: u(s).ENUM, "show-option-all": r.showOptionAll, size: "default", type: "enum" }, e.$attrs, { onChange: j }), null, 16, ["modelValue", "options", "show-option-all"])) : T("", true), b(u(g), h({ modelValue: n.value, "onUpdate:modelValue": a[1] || (a[1] = (l) => n.value = l), disabled: t.value === u(s).PUBLIC.V, clearable: "", isAll: "", placeholder: "所属项目", style: { width: "250px" } }, e.$attrs, { onChange: c }), null, 16, ["modelValue", "disabled"])], 64);
  };
} };
export {
  W as _
};
