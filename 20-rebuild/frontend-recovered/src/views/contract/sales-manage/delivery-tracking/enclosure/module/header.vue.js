import { inject as f } from "vue";
import { ref as V } from "vue";
import { watch as y } from "vue";
import { nextTick as v } from "vue";
import i from "moment";
import { resolveComponent as h } from "vue";
import { openBlock as I } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as b } from "vue";
import { vShow as j } from "vue";
import { unref as e } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as o } from "vue";
import { withCtx as g } from "vue";
import { ElInput as D } from "element-plus";
import { B as _, q as C, C as k, E as Q } from "../../../../../../shared/runtime.js";
const U = { class: "head-container" }, N = { __name: "header", setup(q) {
  const d = f("searchQuery"), m = { startDate: void 0, endDate: void 0, projectContent: void 0, projectId: { value: void 0, resetAble: false } }, { crud: r, query: t } = _(m), u = V([]);
  y(d, (n) => {
    v(() => {
      r.query.projectId = n.projectId, d.date && d.date.length > 1 ? (t.startDate = i(d.date[0]).valueOf(), t.endDate = i(d.date[1]).valueOf()) : (t.startDate = void 0, t.endDate = void 0), r.toQuery();
    });
  }, { immediate: true });
  function p(n) {
    u.value = n || [];
  }
  return (n, a) => {
    const c = h("common-select"), s = D;
    return I(), w("div", U, [b(x("div", null, [o(e(C), { modelValue: e(t).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).monomerId = l), "project-id": e(d).projectId, class: "filter-item", onGetAreaInfo: p }, null, 8, ["modelValue", "project-id"]), o(c, { modelValue: e(t).areaId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).areaId = l), options: u.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(s, { modelValue: e(t).name, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).name = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入名称", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(s, { modelValue: e(t).serialNumber, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).serialNumber = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(s, { modelValue: e(t).plateType, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).plateType = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入板型", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(e(k))], 512), [[j, e(r).searchToggle]]), o(e(Q), null, { viewLeft: g(() => a[5] || (a[5] = [])), _: 1 })]);
  };
} };
export {
  N as default
};
