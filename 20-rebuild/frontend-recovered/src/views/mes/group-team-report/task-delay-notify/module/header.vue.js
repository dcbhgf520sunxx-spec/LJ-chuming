import { openBlock as s } from "vue";
import { createElementBlock as n } from "vue";
import { createVNode as t } from "vue";
import { withCtx as i } from "vue";
import { withDirectives as p } from "vue";
import { createElementVNode as u } from "vue";
import { unref as e } from "vue";
import { vShow as c } from "vue";
import { B as m, fv as f, aV as h, E as V } from "../../../../../shared/runtime.js";
import { _ } from "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const y = { class: "head-container" }, b = { __name: "header", setup(I) {
  const d = { workShopId: void 0, projectId: void 0, processId: void 0 }, { crud: r, query: o } = m(d);
  return (w, a) => (s(), n("div", y, [t(e(V), null, { optLeft: i(() => [p(u("div", null, [t(e(f), { modelValue: e(o).projectId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(o).projectId = l), class: "filter-item", style: { width: "300px" }, clearable: "", placeholder: "可选择项目搜索", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), t(h, { ref: "workshopInfRef", modelValue: e(o).workShopId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(o).workShopId = l), placeholder: "请选择车间", "factory-id": e(o).factoryId, style: { width: "200px" }, class: "filter-item", clearable: "", onChange: e(r).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"]), t(e(_), { modelValue: e(o).processId, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(o).processId = l), class: "filter-item", multiple: false, clearable: "", placeholder: "请选择工序", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"])], 512), [[c, e(r).searchToggle]])]), _: 1 })]));
} };
export {
  b as default
};
