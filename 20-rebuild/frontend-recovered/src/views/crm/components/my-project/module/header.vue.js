import { ref as h } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as j } from "vue";
import { unref as l } from "vue";
import { createBlock as k } from "vue";
import { createCommentVNode as q } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as B } from "vue";
import { withKeys as g } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as y } from "vue";
import { renderSlot as O } from "vue";
import { ElDatePicker as A } from "element-plus";
import { ElInput as M } from "element-plus";
import { ElCol as K } from "element-plus";
import { ElRow as L } from "element-plus";
import { lq as i, I as P } from "../../../../../shared/runtime.js";
import { _ as H } from "../../../../../modules/dept-cascader-6af417b9.js";
import { _ as W } from "../../../../../modules/region-cascader-39b54da2.js";
import { P as p } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/use-dept-b8e95315.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const $ = { class: "head-container" }, Z = { __name: "header", props: { summaryData: { type: Object, default: () => {
} }, structureList: { type: Array, default: () => [] }, moduleType: { type: [Number, String] } }, emits: ["structureChange", "departmentChange", "dateChange", "regionChange", "searchSuccess", "tenderChange", "reset"], setup(d, { emit: V }) {
  const u = d, o = V, T = h([i.BIDDING_METHOD.V, i.SETTLEMENT_METHOD.V]), e = h({ date: [], startDate: void 0, endDate: void 0, regionIds: [], departmentId: void 0, structureTypeConfigurationId: void 0, projectName: void 0, crmEnterpriseWarehousingName: void 0, projectInformantUserName: void 0, crmTenderRequirementTypeEnum: u.moduleType });
  function D() {
    o("StructureChange", e.value.structureTypeConfigurationId);
  }
  function E() {
    o("departmentChange", e.value.departmentId);
  }
  function _() {
    o("regionChange", e.value.regionIds);
  }
  function I() {
    e.value = { date: [], startDate: void 0, endDate: void 0, regionIds: [], departmentId: void 0, structureTypeConfigurationId: void 0, projectName: void 0, crmEnterpriseWarehousingName: void 0, projectInformantUserName: void 0, crmTenderRequirementTypeEnum: void 0 }, o("reset", e.value);
  }
  function N() {
    e.value.date && e.value.date.length > 1 ? (e.value.startDate = e.value.date[0], e.value.endDate = e.value.date[1]) : (e.value.startDate = void 0, e.value.endDate = void 0), console.log("dateChange"), o("dateChange", { startDate: e.value.startDate, endDate: e.value.endDate });
  }
  function m() {
    o("searchSuccess", e.value);
  }
  function b() {
    o("tenderChange", e.value.crmTenderRequirementTypeEnum);
  }
  return (w, n) => {
    const U = f("common-radio-button"), x = A, S = f("common-select"), c = M, v = f("common-button"), s = K, R = L;
    return C(), j("div", $, [d.moduleType > l(i).SETTLEMENT_METHOD.V ? (C(), k(U, { key: 0, type: "enum", modelValue: e.value.crmTenderRequirementTypeEnum, "onUpdate:modelValue": n[0] || (n[0] = (a) => e.value.crmTenderRequirementTypeEnum = a), options: l(i).ENUM, "show-option-all": "", optionAllValue: d.moduleType, unshowVal: T.value, class: "filter-item", onChange: b }, null, 8, ["modelValue", "options", "optionAllValue", "unshowVal"])) : q("", true), t(x, { modelValue: e.value.date, "onUpdate:modelValue": n[1] || (n[1] = (a) => e.value.date = a), class: "filter-item", type: "daterange", shortcuts: l(P), "start-placeholder": "开始日期", "end-placeholder": "结束日期", clearable: "", "value-format": "x", onChange: N }, null, 8, ["modelValue", "shortcuts"]), t(l(W), { modelValue: e.value.regionIds, "onUpdate:modelValue": n[2] || (n[2] = (a) => e.value.regionIds = a), class: "filter-item", onChange: _, clearable: "" }, null, 8, ["modelValue"]), t(S, { class: "filter-item", placeholder: "结构类型", options: d.structureList, clearable: "", modelValue: e.value.structureTypeConfigurationId, "onUpdate:modelValue": n[3] || (n[3] = (a) => e.value.structureTypeConfigurationId = a), onChange: D }, null, 8, ["options", "modelValue"]), t(l(H), { ref: "deptCascaderRef", style: { width: "240px" }, clearable: "", class: "filter-item", checkStrictly: true, showAllLevels: true, modelValue: e.value.departmentId, "onUpdate:modelValue": n[4] || (n[4] = (a) => e.value.departmentId = a), placeholder: "部门", onChange: E }, null, 8, ["modelValue"]), B("div", null, [t(c, { class: "filter-item", style: { width: "210px" }, placeholder: "项目搜索", modelValue: e.value.projectName, "onUpdate:modelValue": n[5] || (n[5] = (a) => e.value.projectName = a), clearable: "", onKeyup: g(m, ["enter"]) }, null, 8, ["modelValue"]), t(c, { class: "filter-item", style: { width: "210px" }, placeholder: "企业名称搜索", modelValue: e.value.crmEnterpriseWarehousingName, "onUpdate:modelValue": n[6] || (n[6] = (a) => e.value.crmEnterpriseWarehousingName = a), clearable: "", onKeyup: g(m, ["enter"]) }, null, 8, ["modelValue"]), t(c, { class: "filter-item", style: { width: "210px" }, placeholder: "登记人搜索", modelValue: e.value.projectInformantUserName, "onUpdate:modelValue": n[7] || (n[7] = (a) => e.value.projectInformantUserName = a), clearable: "", onKeyup: g(m, ["enter"]) }, null, 8, ["modelValue"]), t(v, { class: "filter-item", type: "success", onClick: m }, { default: r(() => n[8] || (n[8] = [y("搜索")])), _: 1, __: [8] }), t(v, { class: "filter-item", type: "warning", onClick: I }, { default: r(() => n[9] || (n[9] = [y("重置")])), _: 1, __: [9] })]), t(R, { gutter: 20 }, { default: r(() => [t(s, { span: 6 }, { default: r(() => [t(l(p), { name: "进行中", "text-color": "#626262", "num-color": "#1890ff", "end-val": u.summaryData.ongoingCount || 0 }, null, 8, ["end-val"])]), _: 1 }), t(s, { span: 6 }, { default: r(() => [t(l(p), { name: "已完成", "text-color": "#626262", "num-color": "#1890ff", "end-val": u.summaryData.doneCount || 0 }, null, 8, ["end-val"])]), _: 1 }), t(s, { span: 6 }, { default: r(() => [t(l(p), { name: "未完成", "text-color": "#626262", "num-color": "#1890ff", "end-val": u.summaryData.notAppointedCount || 0 }, null, 8, ["end-val"])]), _: 1 }), t(s, { span: 6 }, { default: r(() => [t(l(p), { name: "已中标", "text-color": "#626262", "num-color": "#1890ff", "end-val": u.summaryData.winningBidCount || 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 }), O(w.$slots, "printBtn")]);
  };
} };
export {
  Z as default
};
