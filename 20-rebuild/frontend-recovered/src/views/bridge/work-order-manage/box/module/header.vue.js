import h from "moment";
import { resolveComponent as u } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as _ } from "vue";
import { withDirectives as d } from "vue";
import { vShow as m } from "vue";
import { unref as e } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as n } from "vue";
import { withCtx as T } from "vue";
import { withKeys as b } from "vue";
import { Fragment as w } from "vue";
import { ElDatePicker as E } from "element-plus";
import { ElInput as k } from "element-plus";
import { F as r, B as v, cm as x, aV as B, C as Q, E as U } from "../../../../../shared/runtime.js";
const N = { __name: "header", setup(O) {
  const i = h().startOf("month").valueOf(), c = { BOX: r.BOX, CELL: r.CELL }, y = { productType: r.BOX.V, localDateTime: i }, { crud: a, query: o } = v(y);
  return (D, l) => {
    const f = u("project-radio-button"), s = u("common-radio-button"), V = E, g = k;
    return C(), _(w, null, [d(p("div", null, [n(f, { size: "default", modelValue: e(o).projectId, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(o).projectId = t), class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(s, { modelValue: e(o).printType, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(o).printType = t), options: e(x).ENUM, type: "enum", "show-option-all": "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(s, { modelValue: e(o).productType, "onUpdate:modelValue": l[2] || (l[2] = (t) => e(o).productType = t), options: c, type: "enum", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"])], 512), [[m, e(a).searchToggle]]), n(e(U), null, { optLeft: T(() => [d(p("div", null, [n(V, { modelValue: e(o).localDateTime, "onUpdate:modelValue": l[3] || (l[3] = (t) => e(o).localDateTime = t), type: "month", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", clearable: "", placeholder: "查询月份", style: { width: "160px" }, class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(e(B), { modelValue: e(o).workshopId, "onUpdate:modelValue": l[4] || (l[4] = (t) => e(o).workshopId = t), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(g, { modelValue: e(o).orderNumber, "onUpdate:modelValue": l[5] || (l[5] = (t) => e(o).orderNumber = t), placeholder: "输入任务单号搜索搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: b(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(Q))], 512), [[m, e(a).searchToggle]])]), _: 1 })], 64);
  };
} };
export {
  N as default
};
