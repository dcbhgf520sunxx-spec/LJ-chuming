import { openBlock as c } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as n } from "vue";
import { withCtx as d } from "vue";
import { unref as t } from "vue";
import { withKeys as f } from "vue";
import { renderSlot as _ } from "vue";
import { ElDatePicker as h } from "element-plus";
import { ElInput as y } from "element-plus";
import { B as D, I as V, C, E as U } from "../../../../../shared/runtime.js";
const g = { class: "head-container" }, w = { __name: "header", setup(E) {
  const l = { date: [], startDate: void 0, endDate: void 0, informantUserName: void 0 }, { crud: r, query: e } = D(l);
  function s() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), r.toQuery();
  }
  return (u, a) => {
    const i = h, m = y;
    return c(), p("div", g, [n(t(U), null, { optLeft: d(() => [n(i, { modelValue: t(e).date, "onUpdate:modelValue": a[0] || (a[0] = (o) => t(e).date = o), class: "filter-item", type: "daterange", shortcuts: t(V), "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", onChange: s }, null, 8, ["modelValue", "shortcuts"]), n(m, { class: "filter-item", style: { width: "200px" }, placeholder: "销售人员", modelValue: t(e).informantUserName, "onUpdate:modelValue": a[1] || (a[1] = (o) => t(e).informantUserName = o), clearable: "", onKeyup: f(t(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(t(C))]), viewLeft: d(() => [_(u.$slots, "printBtn")]), _: 3 })]);
  };
} };
export {
  w as default
};
