import { ref as N } from "vue";
import { resolveComponent as r } from "vue";
import { resolveDirective as v } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as T } from "vue";
import { withDirectives as m } from "vue";
import { vShow as U } from "vue";
import { unref as e } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as n } from "vue";
import { withKeys as d } from "vue";
import { withCtx as p } from "vue";
import { createBlock as E } from "vue";
import { createTextVNode as S } from "vue";
import { ElDatePicker as I } from "element-plus";
import { ElInput as D } from "element-plus";
import { B as Q, jP as k, vd as K, I as z, fv as A, iH as P, C as j, b as B, E as O, gD as R } from "../../../../shared/runtime.js";
const $ = { class: "head-container" }, M = { __name: "header", props: { selections: { type: Array, default: () => [] } }, emits: ["handleAdd"], setup(c, { emit: f }) {
  const y = f, V = c, h = N([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), b = { times: [], serialNumber: void 0, status: 2, departmentName: void 0, applicantName: void 0, projectId: void 0, purchaseCreationState: void 0, branchCompanyId: void 0 }, { crud: o, query: l } = Q(b);
  function C() {
    y("handleAdd", R.SELF_SUPPORT.V);
  }
  return (q, t) => {
    const i = r("common-radio-button"), g = I, s = D, _ = r("common-button"), w = v("permission");
    return u(), T("div", $, [m(x("div", null, [n(i, { modelValue: e(l).materialType, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(l).materialType = a), options: e(k).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(i, { modelValue: e(l).purchaseCreationState, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(l).purchaseCreationState = a), options: e(K).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(g, { modelValue: e(l).times, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(l).times = a), "default-time": h.value, disabledDate: (a) => a.getTime() > (/* @__PURE__ */ new Date()).getTime(), shortcuts: e(z), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(o).toQuery }, null, 8, ["modelValue", "default-time", "disabledDate", "shortcuts", "onChange"]), n(A, { modelValue: e(l).projectId, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(l).projectId = a), isLumpSum: false, class: "filter-item", clearable: "", isAll: "", style: { width: "280px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), n(P, { modelValue: e(l).branchCompanyId, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(l).branchCompanyId = a), class: "filter-item", placeholder: "申购单位", clearable: "", style: { width: "250px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), n(s, { modelValue: e(l).serialNumber, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(l).serialNumber = a), class: "filter-item", clearable: "", placeholder: "可输入申购编号搜索", size: "default", style: { width: "200px" }, onKeyup: d(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(s, { modelValue: e(l).departmentName, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(l).departmentName = a), class: "filter-item", clearable: "", placeholder: "可输入申购部门搜索", size: "default", style: { width: "200px" }, onKeyup: d(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(s, { modelValue: e(l).applicantName, "onUpdate:modelValue": t[7] || (t[7] = (a) => e(l).applicantName = a), class: "filter-item", clearable: "", placeholder: "可输入申购人搜索", size: "default", style: { width: "200px" }, onKeyup: d(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(j))], 512), [[U, e(o).searchToggle]]), n(e(O), null, { optLeft: p(() => [m((u(), E(_, { disabled: e(B)(V.selections), class: "filter-item", size: "default", type: "primary", onClick: t[8] || (t[8] = (a) => C()) }, { default: p(() => t[9] || (t[9] = [S(" 新建采购 ")])), _: 1, __: [9] }, 8, ["disabled"])), [[w, e(o).permission.add]])]), _: 1 })]);
  };
} };
export {
  M as default
};
