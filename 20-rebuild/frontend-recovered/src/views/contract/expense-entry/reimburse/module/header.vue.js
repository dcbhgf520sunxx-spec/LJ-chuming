import { ref as D } from "vue";
import { inject as i } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as I } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as j } from "vue";
import { withDirectives as c } from "vue";
import { vShow as T } from "vue";
import { unref as e } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as n } from "vue";
import { withKeys as y } from "vue";
import { withCtx as L } from "vue";
import { ElDatePicker as Q } from "element-plus";
import { ElInput as N } from "element-plus";
import { jg as U, p as B, B as E, C as z, E as K } from "../../../../../shared/runtime.js";
import { _ as A } from "../../../../../modules/dept-cascader-6af417b9.js";
import "../../../../../modules/use-dept-b8e95315.js";
const q = { class: "head-container" }, $ = { __name: "header", props: { branchList: { type: Array, default: () => [] } }, setup(h) {
  const b = D([]);
  i("summaryData");
  const u = i("expenseList"), V = i("projectTree"), g = { timeType: U.ALL_YEAR.V, expenseTypeId: void 0, expenseSubjectId: void 0, year: B(/* @__PURE__ */ new Date(), "{y}"), month: void 0, reimbursementPerson: void 0, projectId: void 0, date: [], startDate: void 0, endDate: void 0 }, { crud: o, query: t } = E(g);
  function v() {
    t.date && t.date.length > 1 ? (t.startDate = t.date[0], t.endDate = t.date[1]) : (t.startDate = void 0, t.endDate = void 0), o.toQuery();
  }
  function w(r) {
    var a;
    b.value = (a = u.find((d) => d.id === r)) == null ? void 0 : a.links, o.toQuery();
  }
  function x(r) {
    return r > /* @__PURE__ */ new Date();
  }
  return (r, a) => {
    const d = Q, s = m("common-select-v2"), p = N, C = m("print-table"), _ = I("permission");
    return k(), j("div", q, [c(f("div", null, [n(d, { modelValue: e(t).date, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).date = l), "disabled-date": x, class: "filter-item date-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: v }, null, 8, ["modelValue"]), n(s, { modelValue: e(t).branchCompanyId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).branchCompanyId = l), "data-structure": { key: "id", label: "name", value: "id" }, options: h.branchList, class: "filter-item", clearable: "", filterable: "", placeholder: "费用归属筛选", size: "default", style: { width: "270px" }, type: "other", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(s, { modelValue: e(t).expenseTypeId, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).expenseTypeId = l), "data-structure": { key: "id", label: "name", value: "id" }, options: e(u), class: "filter-item", clearable: "", placeholder: "费用类型筛选", style: { width: "200px" }, type: "other", onChange: w }, null, 8, ["modelValue", "options"]), n(e(A), { clearable: "", class: "filter-item", modelValue: e(t).deptId, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).deptId = l), placeholder: "选择部门", style: { width: "280px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), n(s, { modelValue: e(t).projectId, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).projectId = l), "data-structure": { key: "id", label: "fullName", value: "id" }, options: e(V), class: "filter-item", clearable: "", filterable: "", placeholder: "选择项目", style: { width: "300px" }, type: "other", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a[7] || (a[7] = f("br", null, null, -1)), n(p, { modelValue: e(t).reimburserName, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).reimburserName = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "报销人", size: "default", style: { width: "150px" }, onKeyup: y(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(p, { modelValue: e(t).writtenByName, "onUpdate:modelValue": a[6] || (a[6] = (l) => e(t).writtenByName = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "填报人", size: "default", style: { width: "150px" }, onKeyup: y(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(z))], 512), [[T, e(o).searchToggle]]), n(e(K), null, { viewLeft: L(() => [c(n(C, { params: e(t), "api-key": "reimbursementFee", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"]), [[_, e(o).permission.print]])]), _: 1 })]);
  };
} };
export {
  $ as default
};
