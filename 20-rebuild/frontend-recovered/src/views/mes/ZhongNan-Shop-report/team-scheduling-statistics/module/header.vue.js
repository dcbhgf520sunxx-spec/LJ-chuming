import { ref as w } from "vue";
import d from "moment";
import { resolveComponent as V } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as I } from "vue";
import { unref as e } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as l } from "vue";
import { withKeys as m } from "vue";
import { ElDatePicker as v } from "element-plus";
import { ElInput as C } from "element-plus";
import { B as O, aV as x, a3 as r, C as D, E } from "../../../../../shared/runtime.js";
import { _ as U } from "../../../../../modules/production-line-select-f08e245b.js";
const R = { __name: "header", setup(b) {
  const u = w(), f = { date: [d().startOf("month").valueOf(), d().valueOf()], startDate: d().startOf("month").valueOf(), endDate: d().valueOf(), workshopId: void 0, workshopName: void 0, teamName: void 0, productionLineId: void 0, processType: void 0, processName: void 0 };
  function c(p) {
    var s;
    const a = (s = u.value) == null ? void 0 : s.getOption(p);
    o.workshopName = a == null ? void 0 : a.shortName, n.toQuery();
  }
  function h() {
    o.date && o.date.length > 1 ? (o.startDate = o.date[0], o.endDate = o.date[1]) : (o.startDate = void 0, o.endDate = void 0), n.toQuery();
  }
  const { crud: n, query: o } = O(f);
  return (p, a) => {
    const s = v, i = C, y = V("common-select");
    return k(), g("div", null, [_(N("div", null, [l(s, { modelValue: e(o).date, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(o).date = t), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", style: { width: "240px" }, clearable: false, onChange: h }, null, 8, ["modelValue"]), l(e(x), { ref_key: "workshopSelectRef", ref: u, modelValue: e(o).workshopId, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(o).workshopId = t), placeholder: "选择车间搜索", "factory-id": e(o).factoryId, style: { width: "200px" }, class: "filter-item", clearable: "", onChange: c }, null, 8, ["modelValue", "factory-id"]), l(e(U), { ref: "productionLineRef", class: "filter-item", modelValue: e(o).productionLineId, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(o).productionLineId = t), "factory-id": e(o).factoryId, "workshop-id": e(o).workshopId, placeholder: "请选择生产线", style: { width: "200px" }, clearable: "", onChange: e(n).toQuery }, null, 8, ["modelValue", "factory-id", "workshop-id", "onChange"]), l(i, { modelValue: e(o).teamName, "onUpdate:modelValue": a[3] || (a[3] = (t) => e(o).teamName = t), placeholder: "输入班组名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: m(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(y, { modelValue: e(o).processType, "onUpdate:modelValue": a[4] || (a[4] = (t) => e(o).processType = t), options: e(r).ENUM, unshowOptions: [e(r).ENCLOSURE.K, e(r).AUXILIARY_MATERIAL.K], class: "filter-item", clearable: "", placeholder: "请选择工序类型", style: { width: "180px" }, type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshowOptions", "onChange"]), l(i, { modelValue: e(o).processName, "onUpdate:modelValue": a[5] || (a[5] = (t) => e(o).processName = t), placeholder: "输入工序名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: m(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(D))], 512), [[I, e(n).searchToggle]]), l(e(E))]);
  };
} };
export {
  R as default
};
