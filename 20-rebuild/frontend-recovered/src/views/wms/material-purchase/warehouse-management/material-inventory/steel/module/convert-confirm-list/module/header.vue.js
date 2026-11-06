import { inject as E } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as T } from "vue";
import { withDirectives as f } from "vue";
import { vShow as x } from "vue";
import { unref as e } from "vue";
import { createElementVNode as U } from "vue";
import { createVNode as o } from "vue";
import { createBlock as d } from "vue";
import { createCommentVNode as u } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as k } from "vue";
import y from "moment";
import { ElDatePicker as j } from "element-plus";
import { ElInput as S } from "element-plus";
import { h as A } from "../../../../../../../../../modules/material-inventory-71cd4559.js";
import { kD as p, B, pB as h, fv as Q, z7 as I, C as P, L as z, E as W } from "../../../../../../../../../shared/runtime.js";
const q = { class: "head-container" }, H = { __name: "header", props: { showType: { type: String, default: void 0 } }, emits: ["to-query"], setup(V, { emit: M }) {
  const n = V, b = { date: [], status: n.showType === "coilPlate" ? { value: p.UNREVIEWED.V, resetAble: false } : p.UNREVIEWED.V, startDate: void 0, endDate: void 0, projectId: void 0, receiptSerialNumber: void 0, outSerialNumber: void 0, specification: void 0, brand: void 0, boolAll: n.showType === "coilPlate" ? { value: 0, resetAble: false } : { value: 1, resetAble: false }, heatNoAndBatchNo: void 0, boolPartyA: false }, g = E("permission"), { crud: r, query: t } = B(b);
  function v() {
    t.date && t.date.length > 1 ? (t.startDate = y(t.date[0]).valueOf(), t.endDate = y(t.date[1]).valueOf()) : (t.startDate = void 0, t.endDate = void 0), r.toQuery();
  }
  function w() {
    r.toQuery();
  }
  return (O, a) => {
    const m = C("common-radio-button"), _ = j, i = S, N = D("permission");
    return s(), T("div", q, [f(U("div", null, [o(m, { modelValue: e(t).projectWarehouseType, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).projectWarehouseType = l), options: e(h).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), e(t).projectWarehouseType === e(h).PROJECT.V ? (s(), d(e(Q), { key: 0, modelValue: e(t).projectId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).projectId = l), class: "filter-item", clearable: "", isAll: "", filterable: "", placeholder: "所属项目", style: { width: "260px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"])) : u("", true), n.showType !== "coilPlate" ? (s(), d(m, { key: 1, modelValue: e(t).status, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).status = l), options: e(p).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : u("", true), o(_, { modelValue: e(t).date, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).date = l), class: "filter-item date-item", "end-placeholder": "结束时间", "range-separator": ":", size: "default", "start-placeholder": "开始时间", style: { width: "240px" }, type: "daterange", onChange: v }, null, 8, ["modelValue"]), o(i, { modelValue: e(t).receiptSerialNumber, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).receiptSerialNumber = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "转换单号", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), n.showType !== "coilPlate" ? (s(), d(i, { key: 2, modelValue: e(t).outSerialNumber, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).outSerialNumber = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "出库单号", size: "default", style: { width: "190px" } }, null, 8, ["modelValue"])) : u("", true), o(i, { modelValue: e(t).brand, "onUpdate:modelValue": a[6] || (a[6] = (l) => e(t).brand = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "品牌", size: "default", style: { width: "190px" } }, null, 8, ["modelValue"]), o(I, { query: e(t), class: "filter-item", placeholder: "卷号", style: { width: "190px" }, onToQuery: w }, null, 8, ["query"]), o(e(P))], 512), [[x, e(r).searchToggle]]), o(e(W), null, { optLeft: c(() => [f((s(), d(z, { fn: e(A), params: e(t), "response-header-result": "" }, { default: c(() => a[7] || (a[7] = [k(" 转换单汇总下载（根据查询条件） ")])), _: 1, __: [7] }, 8, ["fn", "params"])), [[N, e(g).get]])]), _: 1 })]);
  };
} };
export {
  H as default
};
