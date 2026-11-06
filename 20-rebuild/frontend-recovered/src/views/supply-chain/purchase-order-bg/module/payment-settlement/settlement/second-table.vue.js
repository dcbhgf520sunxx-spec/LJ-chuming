import { inject as d } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as i } from "vue";
import { unref as l } from "vue";
import { ElTableColumn as p } from "element-plus";
import { ElTable as r } from "element-plus";
import { dp as u } from "../../../../../../shared/runtime.js";
import { u as h } from "../../../../../../modules/useTableTotal-3d22365a.js";
const y = { class: "second-container" }, b = { key: 0 }, f = { key: 1 }, k = { key: 0 }, g = { key: 1 }, v = { key: 0 }, A = { key: 1 }, D = { key: 0 }, x = { key: 1 }, j = { __name: "second-table", setup(T) {
  const { tableList: m } = d("settlement_data"), { getSummaries: c } = h(false, { defineData: ["paymentAmount", "invoiceAmount"] });
  return (w, C) => {
    const o = p, _ = r;
    return t(), a("div", y, [n(u, { "header-title": "付款信息" }), n(_, { data: l(m), "summary-method": l(c), border: "", fit: "", "max-height": "340", "show-summary": "" }, { default: s(() => [n(o, { align: "center", label: "序号", type: "index", width: "80" }), n(o, { align: "center", label: "付款", "min-width": "120", prop: "paymentAmount" }, { default: s(({ row: e }) => [e.paymentAmount ? (t(), a("span", b, i(e.paymentAmount), 1)) : (t(), a("span", f, "-"))]), _: 1 }), n(o, { align: "center", label: "日期", "min-width": "120", prop: "paymentDate" }, { default: s(({ row: e }) => [e.paymentDate ? (t(), a("span", k, i(e.paymentDate), 1)) : (t(), a("span", g, "-"))]), _: 1 }), n(o, { align: "center", label: "发票", "min-width": "120", prop: "invoiceAmount" }, { default: s(({ row: e }) => [e.invoiceAmount ? (t(), a("span", v, i(e.invoiceAmount), 1)) : (t(), a("span", A, "-"))]), _: 1 }), n(o, { align: "center", label: "日期", "min-width": "120", prop: "invoiceDate" }, { default: s(({ row: e }) => [e.invoiceDate ? (t(), a("span", D, i(e.invoiceDate), 1)) : (t(), a("span", x, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "summary-method"])]);
  };
} };
export {
  j as default
};
