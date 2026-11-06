import { ref as h } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as R } from "vue";
import { unref as l } from "vue";
import { createBlock as j } from "vue";
import { createCommentVNode as k } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as q } from "vue";
import { withKeys as g } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as C } from "vue";
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
} }, structureList: { type: Array, default: () => [] }, moduleType: { type: [Number, String] }, crmSpecialBubmissionStatusEnum: { type: [Number, String] } }, emits: ["structureChange", "departmentChange", "dateChange", "regionChange", "searchSuccess", "tenderChange", "reset"], setup(d, { emit: V }) {
  const o = d, u = V, T = h([i.BIDDING_METHOD.V, i.SETTLEMENT_METHOD.V]), e = h({ date: [], startDate: void 0, endDate: void 0, regionIds: [], departmentId: void 0, structureTypeConfigurationId: void 0, projectName: void 0, crmEnterpriseWarehousingName: void 0, projectInformantUserName: void 0, crmTenderRequirementTypeEnum: o.moduleType, crmSpecialBubmissionStatusEnum: o.crmSpecialBubmissionStatusEnum });
  function E() {
    u("StructureChange", e.value.structureTypeConfigurationId);
  }
  function D() {
    u("departmentChange", e.value.departmentId);
  }
  function _() {
    u("regionChange", e.value.regionIds);
  }
  function I() {
    e.value = { date: [], startDate: void 0, endDate: void 0, regionIds: [], departmentId: void 0, structureTypeConfigurationId: void 0, projectName: void 0, crmEnterpriseWarehousingName: void 0, projectInformantUserName: void 0, crmTenderRequirementTypeEnum: void 0, crmSpecialBubmissionStatusEnum: o.crmSpecialBubmissionStatusEnum }, u("reset", e.value);
  }
  function N() {
    e.value.date && e.value.date.length > 1 ? (e.value.startDate = e.value.date[0], e.value.endDate = e.value.date[1]) : (e.value.startDate = void 0, e.value.endDate = void 0), console.log("dateChange"), u("dateChange", { startDate: e.value.startDate, endDate: e.value.endDate });
  }
  function m() {
    u("searchSuccess", e.value);
  }
  function S() {
    u("tenderChange", e.value.crmTenderRequirementTypeEnum);
  }
  return (b, t) => {
    const w = f("common-radio-button"), U = A, x = f("common-select"), c = M, v = f("common-button"), s = K, B = L;
    return y(), R("div", $, [d.moduleType > l(i).SETTLEMENT_METHOD.V ? (y(), j(w, { key: 0, type: "enum", modelValue: e.value.crmTenderRequirementTypeEnum, "onUpdate:modelValue": t[0] || (t[0] = (a) => e.value.crmTenderRequirementTypeEnum = a), options: l(i).ENUM, "show-option-all": "", optionAllValue: d.moduleType, unshowVal: T.value, class: "filter-item", onChange: S }, null, 8, ["modelValue", "options", "optionAllValue", "unshowVal"])) : k("", true), n(U, { modelValue: e.value.date, "onUpdate:modelValue": t[1] || (t[1] = (a) => e.value.date = a), class: "filter-item", type: "daterange", shortcuts: l(P), "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", onChange: N }, null, 8, ["modelValue", "shortcuts"]), n(l(W), { modelValue: e.value.regionIds, "onUpdate:modelValue": t[2] || (t[2] = (a) => e.value.regionIds = a), class: "filter-item", onChange: _, clearable: "" }, null, 8, ["modelValue"]), n(x, { class: "filter-item", placeholder: "结构类型", options: d.structureList, modelValue: e.value.structureTypeConfigurationId, "onUpdate:modelValue": t[3] || (t[3] = (a) => e.value.structureTypeConfigurationId = a), onChange: E }, null, 8, ["options", "modelValue"]), n(l(H), { ref: "deptCascaderRef", style: { width: "240px" }, clearable: "", class: "filter-item", checkStrictly: true, showAllLevels: true, modelValue: e.value.departmentId, "onUpdate:modelValue": t[4] || (t[4] = (a) => e.value.departmentId = a), placeholder: "部门", onChange: D }, null, 8, ["modelValue"]), q("div", null, [n(c, { class: "filter-item", style: { width: "210px" }, placeholder: "项目搜索", modelValue: e.value.projectName, "onUpdate:modelValue": t[5] || (t[5] = (a) => e.value.projectName = a), clearable: "", onKeyup: g(m, ["enter"]) }, null, 8, ["modelValue"]), n(c, { class: "filter-item", style: { width: "210px" }, placeholder: "企业名称搜索", modelValue: e.value.crmEnterpriseWarehousingName, "onUpdate:modelValue": t[6] || (t[6] = (a) => e.value.crmEnterpriseWarehousingName = a), clearable: "", onKeyup: g(m, ["enter"]) }, null, 8, ["modelValue"]), n(c, { class: "filter-item", style: { width: "210px" }, placeholder: "登记人搜索", modelValue: e.value.projectInformantUserName, "onUpdate:modelValue": t[7] || (t[7] = (a) => e.value.projectInformantUserName = a), clearable: "", onKeyup: g(m, ["enter"]) }, null, 8, ["modelValue"]), n(v, { class: "filter-item", type: "success", onClick: m }, { default: r(() => t[8] || (t[8] = [C("搜索")])), _: 1, __: [8] }), n(v, { class: "filter-item", type: "warning", onClick: I }, { default: r(() => t[9] || (t[9] = [C("重置")])), _: 1, __: [9] })]), n(B, { gutter: 20 }, { default: r(() => [n(s, { span: 6 }, { default: r(() => [n(l(p), { name: "进行中", "text-color": "#626262", "num-color": "#1890ff", "end-val": o.summaryData.ongoingCount || 0 }, null, 8, ["end-val"])]), _: 1 }), n(s, { span: 6 }, { default: r(() => [n(l(p), { name: "已完成", "text-color": "#626262", "num-color": "#1890ff", "end-val": o.summaryData.doneCount || 0 }, null, 8, ["end-val"])]), _: 1 }), n(s, { span: 6 }, { default: r(() => [n(l(p), { name: "未完成", "text-color": "#626262", "num-color": "#1890ff", "end-val": o.summaryData.notAppointedCount || 0 }, null, 8, ["end-val"])]), _: 1 }), n(s, { span: 6 }, { default: r(() => [n(l(p), { name: "已中标", "text-color": "#626262", "num-color": "#1890ff", "end-val": o.summaryData.winningBidCount || 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 }), O(b.$slots, "printBtn")]);
  };
} };
export {
  Z as default
};
