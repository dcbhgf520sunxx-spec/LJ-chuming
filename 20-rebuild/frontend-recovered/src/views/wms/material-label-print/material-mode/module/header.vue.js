import { ref as g } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as i } from "vue";
import { unref as e } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as E } from "vue";
import { createCommentVNode as j } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as P } from "vue";
import { Fragment as U } from "vue";
import { renderList as v } from "vue";
import { ElDatePicker as I } from "element-plus";
import { ElOption as w } from "element-plus";
import { ElSelect as N } from "element-plus";
import { B as k, zb as x, vI as z, cV as m, cm as D, I as L, E as B } from "../../../../../shared/runtime.js";
import { u as Q } from "../../../../../modules/use-print-d47bc68b.js";
import { _ as S } from "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/wms-material-label-cf4447ff.js";
const W = { class: "head-container" }, O = { key: 0 }, A = { __name: "header", emits: ["printed-success"], setup(M, { emit: R }) {
  const c = g([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), f = { boolPrinted: false, materialLabelPrintType: void 0, projectWarehouseType: void 0, projectId: void 0, basicClass: m, createDate: [] }, { print: y } = Q(), { crud: a, query: l } = k(f);
  a.props.copies = 1;
  async function u(b) {
    a.data = [], a.setColumns(), a.toQuery();
  }
  async function _() {
    await y(a.selections, a.props.copies), a.refresh();
  }
  return (b, t) => {
    const s = d("common-radio-button"), C = I, V = d("common-button"), h = w, T = N;
    return r(), i("div", W, [e(a).searchToggle ? (r(), i("div", O, [n(s, { modelValue: e(l).materialLabelPrintType, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(l).materialLabelPrintType = o), options: e(x).ENUM, "show-option-all": "", type: "enum", size: "default", class: "filter-item", onChange: u }, null, 8, ["modelValue", "options"]), n(s, { modelValue: e(l).basicClass, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(l).basicClass = o), options: e(z).ENUM, "show-option-all": "", "option-all-value": e(m), type: "enum", size: "default", class: "filter-item", onChange: u }, null, 8, ["modelValue", "options", "option-all-value"]), n(s, { modelValue: e(l).boolPrinted, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(l).boolPrinted = o), options: e(D).ENUM, "show-option-all": "", type: "enum", size: "default", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(C, { modelValue: e(l).createDate, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(l).createDate = o), type: "daterange", "range-separator": ":", size: "default", class: "filter-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "300px" }, clearable: "", shortcuts: e(L), "default-time": c.value, "value-format": "x", onChange: e(a).toQuery }, null, 8, ["modelValue", "shortcuts", "default-time", "onChange"]), t[7] || (t[7] = E("br", null, null, -1)), n(e(S), { projectId: e(l).projectId, "onUpdate:projectId": t[4] || (t[4] = (o) => e(l).projectId = o), projectWarehouseType: e(l).projectWarehouseType, "onUpdate:projectWarehouseType": t[5] || (t[5] = (o) => e(l).projectWarehouseType = o), class: "filter-item", onChange: e(a).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"])])) : j("", true), n(e(B), null, { optLeft: p(() => [n(V, { class: "filter-item", type: "success", size: "default", icon: "el-icon-printer", onClick: _ }, { default: p(() => t[8] || (t[8] = [P("批量打印")])), _: 1, __: [8] }), n(T, { class: "select-mini", modelValue: e(a).props.copies, "onUpdate:modelValue": t[6] || (t[6] = (o) => e(a).props.copies = o), placeholder: "可选择打印份数", size: "default", style: { width: "100px" } }, { default: p(() => [(r(), i(U, null, v(3, (o) => n(h, { key: `copies_${o}`, label: `打印${o}份`, value: o }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]);
  };
} };
export {
  A as default
};
