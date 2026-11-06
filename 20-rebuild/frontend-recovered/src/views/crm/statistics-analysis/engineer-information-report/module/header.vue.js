import { openBlock as c } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { unref as t } from "vue";
import { withKeys as r } from "vue";
import { renderSlot as _ } from "vue";
import { ElDatePicker as y } from "element-plus";
import { ElInput as h } from "element-plus";
import { B as V, I as D, C as N, E as C } from "../../../../../shared/runtime.js";
const K = { class: "head-container" }, E = { __name: "header", setup(g) {
  const u = { date: [], startDate: void 0, endDate: void 0, projectName: void 0, salesName: void 0 }, { crud: o, query: e } = V(u);
  function p() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), o.toQuery();
  }
  return (i, a) => {
    const m = y, d = h;
    return c(), f("div", K, [n(t(C), null, { optLeft: s(() => [n(m, { modelValue: t(e).date, "onUpdate:modelValue": a[0] || (a[0] = (l) => t(e).date = l), class: "filter-item", type: "daterange", shortcuts: t(D), "start-placeholder": "开始日期", "end-placeholder": "结束日期", "value-format": "x", onChange: p }, null, 8, ["modelValue", "shortcuts"]), n(d, { class: "filter-item", style: { width: "200px" }, placeholder: "工程名称", modelValue: t(e).projectName, "onUpdate:modelValue": a[1] || (a[1] = (l) => t(e).projectName = l), clearable: "", onKeyup: r(t(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(d, { class: "filter-item", style: { width: "200px" }, placeholder: "销售人员", modelValue: t(e).salesName, "onUpdate:modelValue": a[2] || (a[2] = (l) => t(e).salesName = l), clearable: "", onKeyup: r(t(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(t(N))]), viewLeft: s(() => [_(i.$slots, "printBtn")]), _: 3 })]);
  };
} };
export {
  E as default
};
