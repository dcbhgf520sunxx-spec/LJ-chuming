import { ref as b } from "vue";
import { computed as O } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as S } from "vue";
import { withDirectives as f } from "vue";
import { vShow as k } from "vue";
import { unref as t } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as o } from "vue";
import { createBlock as U } from "vue";
import { createCommentVNode as L } from "vue";
import { withKeys as y } from "vue";
import { withCtx as T } from "vue";
import V from "moment";
import { ElDatePicker as x } from "element-plus";
import { ElInput as K } from "element-plus";
import { g as P, b as B } from "../../../../../modules/payment-ledger-cb1d373c.js";
import { iF as g, B as Q, C as z, E as A } from "../../../../../shared/runtime.js";
const I = { class: "head-container" }, Y = { __name: "header", setup(q, { expose: _ }) {
  const h = { date: void 0, startDate: void 0, endDate: void 0, serialNumber: void 0, supplierName: void 0, settlementStatus: g.UNSETTLEMENT.V }, { crud: a, query: e } = Q(h), s = { ORDER: { L: "采购合同", K: "ORDER", V: 1 }, SUPPLIER: { L: "供应商", K: "SUPPLIER", V: 2 } }, r = b(s.ORDER.V), i = O(() => r.value === s.ORDER.V);
  function E(u) {
    a.data = [], a.loading = true, a.crudApi.get = u === s.ORDER.V ? P : B, a.toQuery();
  }
  function D() {
    e.date && e.date.length > 1 ? (e.startDate = V(e.date[0]).valueOf(), e.endDate = V(e.date[1]).valueOf()) : (e.startDate = void 0, e.endDate = void 0), a.toQuery();
  }
  return _({ isOrderType: i }), (u, l) => {
    const d = m("common-radio-button"), v = x, p = K, R = m("print-table"), N = C("permission");
    return c(), S("div", I, [f(w("div", null, [o(d, { modelValue: r.value, "onUpdate:modelValue": l[0] || (l[0] = (n) => r.value = n), options: s, type: "enum", size: "default", class: "filter-item", onChange: E }, null, 8, ["modelValue"]), r.value === s.ORDER.V ? (c(), U(d, { key: 0, modelValue: t(e).settlementStatus, "onUpdate:modelValue": l[1] || (l[1] = (n) => t(e).settlementStatus = n), options: t(g).ENUM, showOptionAll: "", optionAllValue: void 0, type: "enum", class: "filter-item", onChange: t(a).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : L("", true), o(v, { modelValue: t(e).date, "onUpdate:modelValue": l[2] || (l[2] = (n) => t(e).date = n), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", style: { width: "240px" }, onChange: D }, null, 8, ["modelValue"]), o(p, { modelValue: t(e).serialNumber, "onUpdate:modelValue": l[3] || (l[3] = (n) => t(e).serialNumber = n), placeholder: "采购合同编号", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: y(t(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(p, { modelValue: t(e).supplierName, "onUpdate:modelValue": l[4] || (l[4] = (n) => t(e).supplierName = n), placeholder: "供应商", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: y(t(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(t(z))], 512), [[k, t(a).searchToggle]]), o(t(A), null, { optRight: T(() => [f(o(R, { "api-key": i.value ? "orderPaymentLedger" : "scmSupplierPaymentLedger", params: { ...t(e) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[N, t(a).permission.print]])]), _: 1 })]);
  };
} };
export {
  Y as default
};
