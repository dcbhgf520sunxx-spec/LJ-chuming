import { ref as T } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as a } from "vue";
import { unref as l } from "vue";
import { createElementVNode as B } from "vue";
import { withKeys as c } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as g } from "vue";
import { renderSlot as k } from "vue";
import { ElDatePicker as O } from "element-plus";
import { ElInput as A } from "element-plus";
import { ElCol as K } from "element-plus";
import { ElRow as L } from "element-plus";
import { I as P, dH as C } from "../../../../../shared/runtime.js";
import { _ as R } from "../../../../../modules/dept-cascader-6af417b9.js";
import { _ as W } from "../../../../../modules/region-cascader-39b54da2.js";
import { P as m } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/use-dept-b8e95315.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const $ = { class: "head-container" }, Q = { __name: "header", props: { summaryData: { type: Object, default: () => {
} }, structureList: { type: Array, default: () => [] } }, emits: ["structureChange", "departmentChange", "dateChange", "regionChange", "searchSuccess", "tenderChange", "reset", "reportType"], setup(f, { emit: h }) {
  const r = f, o = h, e = T({ date: [], startDate: void 0, endDate: void 0, regionIds: [], departmentId: void 0, structureTypeConfigurationId: void 0, projectName: void 0, crmEnterpriseWarehousingName: void 0, projectInformantUserName: void 0 });
  function y() {
    o("StructureChange", e.value.structureTypeConfigurationId);
  }
  function V() {
    o("reportType", e.value.crmSpecialBubmissionStatusEnum);
  }
  function _() {
    o("departmentChange", e.value.departmentId);
  }
  function I() {
    o("regionChange", e.value.regionIds);
  }
  function D() {
    e.value = { date: [], startDate: void 0, endDate: void 0, regionIds: [], departmentId: void 0, structureTypeConfigurationId: void 0, projectName: void 0, crmEnterpriseWarehousingName: void 0, projectInformantUserName: void 0 }, o("reset", e.value);
  }
  function N() {
    e.value.date && e.value.date.length > 1 ? (e.value.startDate = e.value.date[0], e.value.endDate = e.value.date[1]) : (e.value.startDate = void 0, e.value.endDate = void 0), console.log("dateChange"), o("dateChange", { startDate: e.value.startDate, endDate: e.value.endDate });
  }
  function d() {
    o("searchSuccess", e.value);
  }
  return (b, t) => {
    const S = O, E = p("common-radio-button"), w = p("common-select"), i = A, v = p("common-button"), s = K, U = L;
    return x(), j("div", $, [a(S, { modelValue: e.value.date, "onUpdate:modelValue": t[0] || (t[0] = (n) => e.value.date = n), "start-placeholder": "开始日期", "end-placeholder": "结束日期", class: "filter-item", type: "daterange", shortcuts: l(P), "value-format": "x", onChange: N }, null, 8, ["modelValue", "shortcuts"]), a(E, { modelValue: e.value.crmSpecialBubmissionStatusEnum, "onUpdate:modelValue": t[1] || (t[1] = (n) => e.value.crmSpecialBubmissionStatusEnum = n), options: l(C).ENUM, class: "filter-item", "show-option-all": false, default: "", unshowVal: [l(C).BID_ALLOCATION.V], type: "enum", onChange: V }, null, 8, ["modelValue", "options", "unshowVal"]), a(l(W), { modelValue: e.value.regionIds, "onUpdate:modelValue": t[2] || (t[2] = (n) => e.value.regionIds = n), class: "filter-item", onChange: I, clearable: "" }, null, 8, ["modelValue"]), a(w, { class: "filter-item", placeholder: "结构类型", options: f.structureList, modelValue: e.value.structureTypeConfigurationId, "onUpdate:modelValue": t[3] || (t[3] = (n) => e.value.structureTypeConfigurationId = n), onChange: y }, null, 8, ["options", "modelValue"]), a(l(R), { ref: "deptCascaderRef", style: { width: "240px" }, clearable: "", class: "filter-item", checkStrictly: true, showAllLevels: true, modelValue: e.value.departmentId, "onUpdate:modelValue": t[4] || (t[4] = (n) => e.value.departmentId = n), placeholder: "部门", onChange: _ }, null, 8, ["modelValue"]), B("div", null, [a(i, { class: "filter-item", style: { width: "210px" }, placeholder: "项目搜索", modelValue: e.value.projectName, "onUpdate:modelValue": t[5] || (t[5] = (n) => e.value.projectName = n), clearable: "", onKeyup: c(d, ["enter"]) }, null, 8, ["modelValue"]), a(i, { class: "filter-item", style: { width: "210px" }, placeholder: "企业名称搜索", modelValue: e.value.crmEnterpriseWarehousingName, "onUpdate:modelValue": t[6] || (t[6] = (n) => e.value.crmEnterpriseWarehousingName = n), clearable: "", onKeyup: c(d, ["enter"]) }, null, 8, ["modelValue"]), a(i, { class: "filter-item", style: { width: "210px" }, placeholder: "登记人搜索", modelValue: e.value.projectInformantUserName, "onUpdate:modelValue": t[7] || (t[7] = (n) => e.value.projectInformantUserName = n), clearable: "", onKeyup: c(d, ["enter"]) }, null, 8, ["modelValue"]), a(v, { class: "filter-item", type: "success", onClick: d }, { default: u(() => t[8] || (t[8] = [g("搜索")])), _: 1, __: [8] }), a(v, { class: "filter-item", type: "warning", onClick: D }, { default: u(() => t[9] || (t[9] = [g("重置")])), _: 1, __: [9] })]), a(U, { gutter: 20 }, { default: u(() => [a(s, { span: 6 }, { default: u(() => [a(l(m), { name: "进行中", "text-color": "#626262", "num-color": "#1890ff", "end-val": r.summaryData.ongoingCount || 0 }, null, 8, ["end-val"])]), _: 1 }), a(s, { span: 6 }, { default: u(() => [a(l(m), { name: "已完成", "text-color": "#626262", "num-color": "#1890ff", "end-val": r.summaryData.doneCount || 0 }, null, 8, ["end-val"])]), _: 1 }), a(s, { span: 6 }, { default: u(() => [a(l(m), { name: "未完成", "text-color": "#626262", "num-color": "#1890ff", "end-val": r.summaryData.notAppointedCount || 0 }, null, 8, ["end-val"])]), _: 1 }), a(s, { span: 6 }, { default: u(() => [a(l(m), { name: "已中标", "text-color": "#626262", "num-color": "#1890ff", "end-val": r.summaryData.winningBidCount || 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 }), k(b.$slots, "printBtn")]);
  };
} };
export {
  Q as default
};
