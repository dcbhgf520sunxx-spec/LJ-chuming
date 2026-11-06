import { resolveDirective as V } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as b } from "vue";
import { withDirectives as o } from "vue";
import { vShow as _ } from "vue";
import { unref as a } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as r } from "vue";
import { withCtx as n } from "vue";
import { createBlock as v } from "vue";
import { createTextVNode as D } from "vue";
import u from "moment";
import { ElDatePicker as g } from "element-plus";
import { ElInput as x } from "element-plus";
import { h as S } from "../../../../../../../../modules/material-inventory-71cd4559.js";
import { kD as w, B as y, C as N, L as k, E as z } from "../../../../../../../../shared/runtime.js";
const A = { class: "head-container" }, O = { __name: "header", setup(B) {
  const m = { date: [], startDate: void 0, endDate: void 0, receiptSerialNumber: void 0, outSerialNumber: void 0, specification: void 0, brand: void 0, status: { value: w.PASS.V, resetAble: false }, boolAll: { value: 1, resetAble: false } }, { crud: i, query: e } = y(m);
  function p() {
    e.date && e.date.length > 1 ? (e.startDate = u(e.date[0]).valueOf(), e.endDate = u(e.date[1]).valueOf()) : (e.startDate = void 0, e.endDate = void 0), i.toQuery();
  }
  return (C, t) => {
    const f = g, d = x, c = V("permission");
    return s(), b("div", A, [o(h("div", null, [r(f, { modelValue: a(e).date, "onUpdate:modelValue": t[0] || (t[0] = (l) => a(e).date = l), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", style: { width: "240px" }, onChange: p }, null, 8, ["modelValue"]), r(d, { modelValue: a(e).receiptSerialNumber, "onUpdate:modelValue": t[1] || (t[1] = (l) => a(e).receiptSerialNumber = l), modelModifiers: { trim: true }, placeholder: "转换单号", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), r(d, { modelValue: a(e).outSerialNumber, "onUpdate:modelValue": t[2] || (t[2] = (l) => a(e).outSerialNumber = l), modelModifiers: { trim: true }, placeholder: "出库单号", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), r(d, { modelValue: a(e).specification, "onUpdate:modelValue": t[3] || (t[3] = (l) => a(e).specification = l), modelModifiers: { trim: true }, placeholder: "规格", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), r(d, { modelValue: a(e).brand, "onUpdate:modelValue": t[4] || (t[4] = (l) => a(e).brand = l), modelModifiers: { trim: true }, placeholder: "品牌", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), r(a(N))], 512), [[_, a(i).searchToggle]]), r(a(z), null, { optLeft: n(() => [o((s(), v(k, { params: a(e), fn: a(S), "response-header-result": "" }, { default: n(() => t[5] || (t[5] = [D(" 转换单汇总下载（根据查询条件） ")])), _: 1, __: [5] }, 8, ["params", "fn"])), [[c, a(i).permission.get]])]), _: 1 })]);
  };
} };
export {
  O as default
};
