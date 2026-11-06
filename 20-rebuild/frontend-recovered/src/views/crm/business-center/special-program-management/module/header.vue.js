import { resolveComponent as p } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withKeys as s } from "vue";
import { ElDatePicker as y } from "element-plus";
import { ElInput as _ } from "element-plus";
import { B as V, lQ as b, I as h, C as E } from "../../../../../shared/runtime.js";
const N = { class: "head-container" }, j = { __name: "header", props: { permission: { type: Object, default: () => {
} } }, setup(S) {
  const u = { crmSubmissionStatusEnum: void 0, projectName: void 0, projectNumber: void 0, date: [], startDate: void 0, endDate: void 0 }, { query: e, crud: l } = V(u);
  function d() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), l.toQuery();
  }
  return (C, o) => {
    const m = p("common-radio-button"), i = y, r = _;
    return c(), f("div", N, [n(m, { modelValue: t(e).crmSubmissionStatusEnum, "onUpdate:modelValue": o[0] || (o[0] = (a) => t(e).crmSubmissionStatusEnum = a), options: t(b).ENUM, showOptionAll: "", type: "enum", class: "filter-item", onChange: t(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(i, { class: "filter-item", "value-format": "x", type: "daterange", shortcuts: t(h), "start-placeholder": "开始日期", "end-placeholder": "结束日期", modelValue: t(e).date, "onUpdate:modelValue": o[1] || (o[1] = (a) => t(e).date = a), onChange: d }, null, 8, ["shortcuts", "modelValue"]), n(r, { modelValue: t(e).projectName, "onUpdate:modelValue": o[2] || (o[2] = (a) => t(e).projectName = a), class: "filter-item", style: { width: "220px" }, clearable: "", placeholder: "项目名称搜索", onKeyup: s(t(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(r, { modelValue: t(e).projectNumber, "onUpdate:modelValue": o[3] || (o[3] = (a) => t(e).projectNumber = a), class: "filter-item", clearable: "", style: { width: "220px" }, placeholder: "项目编号搜索", onKeyup: s(t(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(t(E))]);
  };
} };
export {
  j as default
};
