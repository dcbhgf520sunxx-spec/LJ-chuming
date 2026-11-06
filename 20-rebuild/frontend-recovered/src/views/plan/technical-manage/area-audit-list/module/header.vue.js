import { ref as m } from "vue";
import { watch as g } from "vue";
import { resolveComponent as s } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as C } from "vue";
import { vShow as E } from "vue";
import { unref as e } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as d } from "vue";
import { m9 as l, B as w, T, q as U, C as A, E as R } from "../../../../../shared/runtime.js";
const Q = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(p) {
  const c = { monomerId: void 0, areaId: void 0, projectId: { value: void 0, resetAble: false }, inventoryReviewedEnum: l.UNAUDITED.V }, { crud: n, query: o } = w(c), i = m([]), u = p, f = m([l.UNAUDITED, l.PASSED, l.FAIL]);
  g(() => u.projectId, (r) => {
    r && (n.query.projectId = u.projectId, n.toQuery());
  }, { immediate: true, deep: true });
  function I(r) {
    i.value = r || [];
  }
  function y() {
    o.monomerId = void 0, o.areaId = void 0, n.toQuery();
  }
  return (r, t) => {
    const v = s("project-radio-button"), V = s("common-select"), j = s("common-radio-button");
    return b(), h("div", null, [C(_("div", null, [d(v, { size: "default", modelValue: e(o).projectId, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).projectId = a), class: "filter-item", onChange: y }, null, 8, ["modelValue"]), d(e(U), { ref: "monomerSelectRef", modelValue: e(o).monomerId, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).monomerId = a), "project-id": u.projectId, class: "filter-item", productType: e(T).STRUCTURE.V, default: false, disabled: !e(o).projectId, onGetAreaInfo: I, onChange: e(n).toQuery }, null, 8, ["modelValue", "project-id", "productType", "disabled", "onChange"]), d(V, { modelValue: e(o).areaId, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).areaId = a), options: i.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, disabled: !e(o).projectId, onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "disabled", "onChange"]), d(j, { modelValue: e(o).inventoryReviewedEnum, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(o).inventoryReviewedEnum = a), options: f.value, type: "enum", showOptionAll: "", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), d(e(A))], 512), [[E, e(n).searchToggle]]), d(e(R))]);
  };
} };
export {
  Q as default
};
