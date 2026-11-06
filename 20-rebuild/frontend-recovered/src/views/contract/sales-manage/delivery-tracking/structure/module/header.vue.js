import { inject as f } from "vue";
import { ref as V } from "vue";
import { watch as h } from "vue";
import { nextTick as y } from "vue";
import u from "moment";
import { resolveComponent as v } from "vue";
import { openBlock as I } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as b } from "vue";
import { vShow as g } from "vue";
import { unref as e } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as o } from "vue";
import { withCtx as x } from "vue";
import { ElInput as C } from "element-plus";
import { B as D, q as _, C as Q, E as k } from "../../../../../../shared/runtime.js";
const U = { class: "head-container" }, N = { __name: "header", setup(q) {
  const r = f("searchQuery"), m = { startDate: void 0, endDate: void 0, projectContent: void 0, projectId: { value: void 0, resetAble: false } }, { crud: n, query: t } = D(m), i = V([]);
  h(r, (d) => {
    y(() => {
      n.query.projectId = d.projectId, r.date && r.date.length > 1 ? (t.startDate = u(r.date[0]).valueOf(), t.endDate = u(r.date[1]).valueOf()) : (t.startDate = void 0, t.endDate = void 0), n.toQuery();
    });
  }, { immediate: true });
  function c(d) {
    i.value = d || [];
  }
  return (d, a) => {
    const p = v("common-select"), s = C;
    return I(), w("div", U, [b(j("div", null, [o(e(_), { modelValue: e(t).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).monomerId = l), "project-id": e(r).projectId, class: "filter-item", onChange: e(n).toQuery, onGetAreaInfo: c }, null, 8, ["modelValue", "project-id", "onChange"]), o(p, { modelValue: e(t).areaId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).areaId = l), options: i.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(s, { modelValue: e(t).serialNumber, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).serialNumber = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(s, { modelValue: e(t).specification, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).specification = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入规格", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(s, { modelValue: e(t).material, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).material = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入材质", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(e(Q))], 512), [[g, e(n).searchToggle]]), o(e(k), null, { viewLeft: x(() => a[5] || (a[5] = [])), _: 1 })]);
  };
} };
export {
  N as default
};
