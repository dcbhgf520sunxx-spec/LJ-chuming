import { ref as p } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as g } from "vue";
import { unref as s } from "vue";
import { createBlock as R } from "vue";
import { createCommentVNode as U } from "vue";
import { createVNode as n } from "vue";
import { withKeys as m } from "vue";
import { withCtx as v } from "vue";
import { createTextVNode as T } from "vue";
import { renderSlot as w } from "vue";
import { ElDatePicker as B } from "element-plus";
import { ElInput as S } from "element-plus";
import { lq as r, I as k } from "../../../../../shared/runtime.js";
const q = { class: "head-container" }, M = { __name: "header", props: { moduleType: { type: [Number, String] } }, emits: ["dateChange", "searchSuccess", "tenderChange", "reset"], setup(u, { emit: y }) {
  const V = u, l = y, h = p([r.BIDDING_METHOD.V, r.SETTLEMENT_METHOD.V]), e = p({ date: [], startDate: void 0, endDate: void 0, serialNumber: void 0, applyForBidReporterName: void 0, headUserName: void 0, crmTenderRequirementTypeEnum: V.moduleType });
  function D() {
    e.value.date && e.value.date.length > 1 ? (e.value.startDate = e.value.date[0], e.value.endDate = e.value.date[1]) : (e.value.startDate = void 0, e.value.endDate = void 0), l("dateChange", { startDate: e.value.startDate, endDate: e.value.endDate });
  }
  function N() {
    e.value = { date: [], startDate: void 0, endDate: void 0, serialNumber: void 0, applyForBidReporterName: void 0, headUserName: void 0, crmTenderRequirementTypeEnum: void 0 }, l("reset", e.value);
  }
  function o() {
    l("searchSuccess", e.value);
  }
  function E() {
    l("tenderChange", e.value.crmTenderRequirementTypeEnum);
  }
  return (C, a) => {
    const _ = c("common-radio-button"), b = B, d = S, i = c("common-button");
    return f(), g("div", q, [u.moduleType > s(r).SETTLEMENT_METHOD.V ? (f(), R(_, { key: 0, type: "enum", modelValue: e.value.crmTenderRequirementTypeEnum, "onUpdate:modelValue": a[0] || (a[0] = (t) => e.value.crmTenderRequirementTypeEnum = t), options: s(r).ENUM, "show-option-all": "", optionAllValue: u.moduleType, unshowVal: h.value, class: "filter-item", onChange: E }, null, 8, ["modelValue", "options", "optionAllValue", "unshowVal"])) : U("", true), n(b, { modelValue: e.value.date, "onUpdate:modelValue": a[1] || (a[1] = (t) => e.value.date = t), class: "filter-item", type: "daterange", shortcuts: s(k), "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", onChange: D }, null, 8, ["modelValue", "shortcuts"]), n(d, { class: "filter-item", style: { width: "210px" }, placeholder: "项目编号搜索", modelValue: e.value.serialNumber, "onUpdate:modelValue": a[2] || (a[2] = (t) => e.value.serialNumber = t), clearable: "", onKeyup: m(o, ["enter"]) }, null, 8, ["modelValue"]), n(d, { class: "filter-item", style: { width: "210px" }, placeholder: "投标人搜索", modelValue: e.value.applyForBidReporterName, "onUpdate:modelValue": a[3] || (a[3] = (t) => e.value.applyForBidReporterName = t), clearable: "", onKeyup: m(o, ["enter"]) }, null, 8, ["modelValue"]), n(d, { class: "filter-item", style: { width: "210px" }, placeholder: "负责人搜索", modelValue: e.value.headUserName, "onUpdate:modelValue": a[4] || (a[4] = (t) => e.value.headUserName = t), clearable: "", onKeyup: m(o, ["enter"]) }, null, 8, ["modelValue"]), n(i, { class: "filter-item", type: "success", onClick: o }, { default: v(() => a[5] || (a[5] = [T("搜索")])), _: 1, __: [5] }), n(i, { class: "filter-item", type: "warning", onClick: N }, { default: v(() => a[6] || (a[6] = [T("重置")])), _: 1, __: [6] }), w(C.$slots, "printBtn")]);
  };
} };
export {
  M as default
};
