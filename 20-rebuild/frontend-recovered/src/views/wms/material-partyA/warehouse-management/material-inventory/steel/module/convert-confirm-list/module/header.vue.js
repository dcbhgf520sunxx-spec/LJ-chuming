import { inject as N } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as C } from "vue";
import { withDirectives as p } from "vue";
import { vShow as x } from "vue";
import { unref as e } from "vue";
import { createElementVNode as T } from "vue";
import { createBlock as d } from "vue";
import { createCommentVNode as u } from "vue";
import { createVNode as o } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as k } from "vue";
import f from "moment";
import { ElDatePicker as S } from "element-plus";
import { ElInput as U } from "element-plus";
import { h as A } from "../../../../../../../../../modules/material-inventory-71cd4559.js";
import { kD as m, B, pB as j, fv as I, z7 as P, C as Q, L as q, E as z } from "../../../../../../../../../shared/runtime.js";
const O = { class: "head-container" }, H = { __name: "header", props: { showType: { type: String, default: void 0 } }, emits: ["to-query"], setup(y, { emit: M }) {
  const n = y, h = { date: [], status: n.showType === "coilPlate" ? { value: m.UNREVIEWED.V, resetAble: false } : m.UNREVIEWED.V, startDate: void 0, endDate: void 0, projectId: void 0, receiptSerialNumber: void 0, outSerialNumber: void 0, specification: void 0, brand: void 0, boolAll: n.showType === "coilPlate" ? { value: 0, resetAble: false } : { value: 1, resetAble: false }, heatNoAndBatchNo: void 0, boolPartyA: true }, V = N("permission"), { crud: r, query: t } = B(h);
  function b() {
    t.date && t.date.length > 1 ? (t.startDate = f(t.date[0]).valueOf(), t.endDate = f(t.date[1]).valueOf()) : (t.startDate = void 0, t.endDate = void 0), r.toQuery();
  }
  function _() {
    r.toQuery();
  }
  return (R, a) => {
    const v = D("common-radio-button"), w = S, i = U, g = E("permission");
    return s(), C("div", O, [p(T("div", null, [e(t).projectWarehouseType === e(j).PROJECT.V ? (s(), d(e(I), { key: 0, modelValue: e(t).projectId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).projectId = l), class: "filter-item", clearable: "", isAll: "", filterable: "", placeholder: "所属项目", style: { width: "260px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"])) : u("", true), n.showType !== "coilPlate" ? (s(), d(v, { key: 1, modelValue: e(t).status, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).status = l), options: e(m).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : u("", true), o(w, { modelValue: e(t).date, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).date = l), class: "filter-item date-item", "end-placeholder": "结束时间", "range-separator": ":", size: "default", "start-placeholder": "开始时间", style: { width: "240px" }, type: "daterange", onChange: b }, null, 8, ["modelValue"]), o(i, { modelValue: e(t).receiptSerialNumber, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).receiptSerialNumber = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "转换单号", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), n.showType !== "coilPlate" ? (s(), d(i, { key: 2, modelValue: e(t).outSerialNumber, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).outSerialNumber = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "出库单号", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"])) : u("", true), o(i, { modelValue: e(t).brand, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).brand = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "品牌", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), o(P, { query: e(t), class: "filter-item", placeholder: "卷号", style: { width: "200px" }, onToQuery: _ }, null, 8, ["query"]), o(e(Q))], 512), [[x, e(r).searchToggle]]), o(e(z), null, { optLeft: c(() => [p((s(), d(q, { fn: e(A), params: e(t), "response-header-result": "" }, { default: c(() => a[6] || (a[6] = [k(" 转换单汇总下载（根据查询条件） ")])), _: 1, __: [6] }, 8, ["fn", "params"])), [[g, e(V).get]])]), _: 1 })]);
  };
} };
export {
  H as default
};
