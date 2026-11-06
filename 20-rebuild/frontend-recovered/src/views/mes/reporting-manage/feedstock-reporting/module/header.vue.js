import r from "moment";
import { ref as d } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withKeys as _ } from "vue";
import { createElementVNode as k } from "vue";
import { createBlock as g } from "vue";
import { withCtx as w } from "vue";
import { createTextVNode as C } from "vue";
import { createCommentVNode as D } from "vue";
import { ElDatePicker as b } from "element-plus";
import { ElInput as x } from "element-plus";
import { B as I, aV as N, C as O, G as B } from "../../../../../shared/runtime.js";
import { _ as Q } from "../../../../../modules/project-select-94bb5bbd.js";
import U from "./form.vue.js";
import "../../../../../modules/feedstock-reporting-f416c9a5.js";
import "./preview.vue.js";
const A = { __name: "header", setup(j) {
  const i = { date: [r().startOf("month").valueOf(), r().valueOf()], startDate: r().startOf("month").valueOf(), endDate: r().valueOf(), workshopId: void 0, projectId: void 0, userName: void 0 }, s = d(false), { crud: o, query: t } = I(i), m = d([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]);
  function p() {
    t.date && t.date.length > 1 ? (t.startDate = t.date[0], t.endDate = t.date[1]) : (t.startDate = void 0, t.endDate = void 0), o.toQuery();
  }
  function f() {
    s.value = true;
  }
  return ($, a) => {
    const c = b, V = x, y = v("common-button");
    return u(), h("div", null, [n(c, { modelValue: e(t).date, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).date = l), "default-time": m.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: p }, null, 8, ["modelValue", "default-time"]), n(e(N), { modelValue: e(t).workshopId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).workshopId = l), placeholder: "车间筛选", class: "filter-item", style: { width: "200px" }, clearable: "", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), n(e(Q), { modelValue: e(t).projectId, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).projectId = l), class: "filter-item", style: { width: "200px" }, clearable: "", placeholder: "项目筛选", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), n(V, { modelValue: e(t).userName, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).userName = l), placeholder: "输入办理人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: _(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(O)), k("div", null, [e(B)(e(o).permission.add) ? (u(), g(y, { key: 0, type: "primary", size: "default", onClick: f }, { default: w(() => a[6] || (a[6] = [C(" 投料填报 ")])), _: 1, __: [6] })) : D("", true)]), n(e(U), { visible: s.value, "onUpdate:visible": a[4] || (a[4] = (l) => s.value = l), onSuccess: a[5] || (a[5] = (l) => e(o).refresh()) }, null, 8, ["visible"])]);
  };
} };
export {
  A as default
};
