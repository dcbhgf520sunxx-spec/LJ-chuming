import { ref as Y } from "vue";
import { inject as _ } from "vue";
import { resolveComponent as d } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as j } from "vue";
import { withDirectives as b } from "vue";
import { vShow as A } from "vue";
import { unref as e } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as l } from "vue";
import { createBlock as g } from "vue";
import { createCommentVNode as x } from "vue";
import { withKeys as M } from "vue";
import { withCtx as v } from "vue";
import { toDisplayString as N } from "vue";
import { ElDatePicker as Q } from "element-plus";
import { ElInput as R } from "element-plus";
import { ElTag as S } from "element-plus";
import { jg as i, p as r, B as z, C as B, E as P } from "../../../../../shared/runtime.js";
const K = { class: "head-container" }, $ = { __name: "header", setup(O) {
  const p = Y([]), w = _("summaryData"), c = _("expenseList"), C = { timeType: i.ALL_YEAR.V, expenseTypeId: void 0, expenseSubjectId: void 0, year: r(/* @__PURE__ */ new Date(), "{y}"), month: void 0, reimbursementPerson: void 0 }, { crud: o, query: t } = z(C);
  function T(s) {
    s === i.ALL_YEAR.V ? (t.year = r(/* @__PURE__ */ new Date(), "{y}"), t.month = void 0) : (t.year = r(/* @__PURE__ */ new Date(), "{y}"), t.month = r(/* @__PURE__ */ new Date(), "{m}")), o.toQuery();
  }
  function D(s) {
    var a;
    p.value = (a = c.find((m) => m.id === s)) == null ? void 0 : a.links, o.toQuery();
  }
  function y(s) {
    return s > /* @__PURE__ */ new Date();
  }
  return (s, a) => {
    const m = d("common-radio-button"), f = Q, h = d("common-select-v2"), k = R, E = S, I = d("print-table"), L = U("permission");
    return u(), j("div", K, [b(V("div", null, [l(m, { modelValue: e(t).timeType, "onUpdate:modelValue": a[0] || (a[0] = (n) => e(t).timeType = n), options: e(i).ENUM, class: "filter-item", showOptionAll: false, type: "enum", onChange: T }, null, 8, ["modelValue", "options"]), e(t).timeType === e(i).ALL_YEAR.V ? (u(), g(f, { key: 0, modelValue: e(t).year, "onUpdate:modelValue": a[1] || (a[1] = (n) => e(t).year = n), type: "year", size: "default", class: "date-item filter-item", style: { width: "120px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", "disabled-date": y, onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"])) : x("", true), e(t).timeType === e(i).CURRENT_MONTH.V ? (u(), g(f, { key: 1, modelValue: e(t).month, "onUpdate:modelValue": a[2] || (a[2] = (n) => e(t).month = n), type: "month", size: "default", class: "date-item filter-item", style: { width: "120px !important" }, placeholder: "选择月", format: "MM", "value-format": "MM", "disabled-date": y, onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"])) : x("", true), l(h, { modelValue: e(t).expenseTypeId, "onUpdate:modelValue": a[3] || (a[3] = (n) => e(t).expenseTypeId = n), options: e(c), type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "200px" }, placeholder: "费用类别", onChange: D }, null, 8, ["modelValue", "options"]), l(h, { modelValue: e(t).expenseSubjectId, "onUpdate:modelValue": a[4] || (a[4] = (n) => e(t).expenseSubjectId = n), options: p.value, type: "other", "data-structure": { key: "id", label: "label", value: "id" }, size: "default", clearable: "", class: "filter-item", placeholder: "报销科目", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(k, { modelValue: e(t).reimbursementPerson, "onUpdate:modelValue": a[5] || (a[5] = (n) => e(t).reimbursementPerson = n), modelModifiers: { trim: true }, clearable: "", style: { width: "150px" }, size: "default", placeholder: "报销人", class: "filter-item", onKeyup: M(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(B))], 512), [[A, e(o).searchToggle]]), l(e(P), null, { viewLeft: v(() => [l(E, { effect: "plain", class: "filter-item", size: "large" }, { default: v(() => [V("span", null, " 报销总额（元）：" + N(e(w).info), 1)]), _: 1 }), b(l(I, { "api-key": "expenseReimburseList", params: { reimburseUserName: e(t).reimbursementPerson, expenseSubjectId: e(t).expenseSubjectId, month: e(t).month, year: e(t).year, expenseTypeId: e(t).expenseTypeId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[L, e(o).permission.print]])]), _: 1 })]);
  };
} };
export {
  $ as default
};
