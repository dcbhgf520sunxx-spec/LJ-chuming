import { ref as g } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as i } from "vue";
import { unref as e } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as E } from "vue";
import { createCommentVNode as P } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as j } from "vue";
import { Fragment as U } from "vue";
import { renderList as v } from "vue";
import { ElDatePicker as w } from "element-plus";
import { ElOption as I } from "element-plus";
import { ElSelect as N } from "element-plus";
import { B as k, zb as x, cV as m, vI as z, cm as D, I as L, E as W } from "../../../../../../../shared/runtime.js";
import { u as B } from "../../../../../../../modules/use-print-4d7e67fe.js";
import { _ as Q } from "../../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../../../modules/wms-material-label-cf4447ff.js";
const S = { class: "head-container" }, O = { key: 0 }, K = { __name: "header", emits: ["printed-success"], setup(M, { emit: R }) {
  const c = g([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), f = { boolPrinted: false, materialLabelPrintType: void 0, projectWarehouseType: void 0, projectId: void 0, basicClass: m, createDate: [], boolPartyA: true }, { print: y } = B(), { crud: a, query: l } = k(f);
  a.props.copies = 1;
  async function u(b) {
    a.data = [], a.setColumns(), a.toQuery();
  }
  async function _() {
    await y(a.selections, a.props.copies), a.refresh();
  }
  return (b, o) => {
    const s = d("common-radio-button"), C = w, V = d("common-button"), h = I, T = N;
    return r(), i("div", S, [e(a).searchToggle ? (r(), i("div", O, [n(s, { modelValue: e(l).materialLabelPrintType, "onUpdate:modelValue": o[0] || (o[0] = (t) => e(l).materialLabelPrintType = t), options: e(x).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: u }, null, 8, ["modelValue", "options"]), n(s, { modelValue: e(l).basicClass, "onUpdate:modelValue": o[1] || (o[1] = (t) => e(l).basicClass = t), "option-all-value": e(m), options: e(z).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: u }, null, 8, ["modelValue", "option-all-value", "options"]), n(s, { modelValue: e(l).boolPrinted, "onUpdate:modelValue": o[2] || (o[2] = (t) => e(l).boolPrinted = t), options: e(D).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(C, { modelValue: e(l).createDate, "onUpdate:modelValue": o[3] || (o[3] = (t) => e(l).createDate = t), "default-time": c.value, shortcuts: e(L), class: "filter-item", clearable: "", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "300px" }, type: "daterange", "value-format": "x", onChange: e(a).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), o[7] || (o[7] = E("br", null, null, -1)), n(e(Q), { projectId: e(l).projectId, "onUpdate:projectId": o[4] || (o[4] = (t) => e(l).projectId = t), projectWarehouseType: e(l).projectWarehouseType, "onUpdate:projectWarehouseType": o[5] || (o[5] = (t) => e(l).projectWarehouseType = t), showProjectWarehouseType: false, class: "filter-item", onChange: e(a).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"])])) : P("", true), n(e(W), null, { optLeft: p(() => [n(V, { class: "filter-item", icon: "el-icon-printer", size: "default", type: "success", onClick: _ }, { default: p(() => o[8] || (o[8] = [j(" 批量打印 ")])), _: 1, __: [8] }), n(T, { modelValue: e(a).props.copies, "onUpdate:modelValue": o[6] || (o[6] = (t) => e(a).props.copies = t), class: "select-mini", placeholder: "可选择打印份数", size: "default", style: { width: "100px" } }, { default: p(() => [(r(), i(U, null, v(3, (t) => n(h, { key: `copies_${t}`, label: `打印${t}份`, value: t }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]);
  };
} };
export {
  K as default
};
