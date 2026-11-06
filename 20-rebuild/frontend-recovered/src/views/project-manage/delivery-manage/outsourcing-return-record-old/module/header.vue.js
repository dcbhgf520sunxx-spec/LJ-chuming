import { ref as h } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as K } from "vue";
import { withDirectives as N } from "vue";
import { vShow as v } from "vue";
import { unref as e } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as n } from "vue";
import { withKeys as u } from "vue";
import { withCtx as g } from "vue";
import { createBlock as U } from "vue";
import { createCommentVNode as C } from "vue";
import { ElInput as x } from "element-plus";
import { ElDatePicker as Q } from "element-plus";
import { tS as i, B as T, I as z, C as A, G as I, E as S } from "../../../../../shared/runtime.js";
const j = { class: "head-container" }, k = { __name: "header", props: { permission: { type: Object, default: () => {
} } }, setup(m) {
  const c = h([i.MACHINE_PART.V, i.AUXILIARY_MATERIAL.V]), y = { projectId: { value: void 0, resetAble: false }, reviewTime: [], productType: void 0, rejectSn: void 0, purchaseSn: void 0, supplierName: void 0, name: void 0, monomerOrArea: void 0, applicantName: void 0, reviewerName: void 0, serialNumber: void 0 }, { crud: a, query: l } = T(y);
  return (E, o) => {
    const f = d("project-radio-button"), V = d("common-radio-button"), r = x, w = Q, b = d("print-table");
    return p(), K("div", j, [N(s("div", null, [n(f, { size: "default", type: "all", modelValue: e(l).projectId, "onUpdate:modelValue": o[0] || (o[0] = (t) => e(l).projectId = t), class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(V, { modelValue: e(l).productType, "onUpdate:modelValue": o[1] || (o[1] = (t) => e(l).productType = t), options: e(i).ENUM, type: "enum", unshowVal: c.value, showOptionAll: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), n(r, { modelValue: e(l).rejectSn, "onUpdate:modelValue": o[2] || (o[2] = (t) => e(l).rejectSn = t), size: "default", placeholder: "外购退货单号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(r, { modelValue: e(l).purchaseSn, "onUpdate:modelValue": o[3] || (o[3] = (t) => e(l).purchaseSn = t), size: "default", placeholder: "采购合同号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(r, { modelValue: e(l).supplierName, "onUpdate:modelValue": o[4] || (o[4] = (t) => e(l).supplierName = t), size: "default", placeholder: "供应商搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(r, { modelValue: e(l).name, "onUpdate:modelValue": o[5] || (o[5] = (t) => e(l).name = t), size: "default", placeholder: "名称搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s("div", null, [n(w, { modelValue: e(l).reviewTime, "onUpdate:modelValue": o[6] || (o[6] = (t) => e(l).reviewTime = t), type: "daterange", "range-separator": "-", size: "default", clearable: "", shortcuts: e(z), class: "filter-item", "value-format": "x", "start-placeholder": "退货日期", "end-placeholder": "退货日期", onChange: e(a).toQuery }, null, 8, ["modelValue", "shortcuts", "onChange"]), n(r, { modelValue: e(l).monomerOrArea, "onUpdate:modelValue": o[7] || (o[7] = (t) => e(l).monomerOrArea = t), size: "default", placeholder: "单体区域/批次搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(r, { modelValue: e(l).specification, "onUpdate:modelValue": o[8] || (o[8] = (t) => e(l).specification = t), size: "default", placeholder: "规格搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(r, { modelValue: e(l).serialNumber, "onUpdate:modelValue": o[9] || (o[9] = (t) => e(l).serialNumber = t), size: "default", placeholder: "编号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(r, { modelValue: e(l).applicantName, "onUpdate:modelValue": o[10] || (o[10] = (t) => e(l).applicantName = t), size: "default", placeholder: "退货人搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(r, { modelValue: e(l).reviewerName, "onUpdate:modelValue": o[11] || (o[11] = (t) => e(l).reviewerName = t), size: "default", placeholder: "审核人搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: u(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(A))])], 512), [[v, e(a).searchToggle]]), n(e(S), null, { optLeft: g(() => [s("div", null, [e(I)(m.permission.print) ? (p(), U(b, { key: 0, "api-key": "outsourcingReturnRecord", params: { ...e(a).query }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"])) : C("", true)])]), _: 1 })]);
  };
} };
export {
  k as default
};
