import { inject as p } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as i } from "vue";
import { unref as l } from "vue";
import { ElTableColumn as r } from "element-plus";
import { ElTable as u } from "element-plus";
import { _ as h, dp as y } from "../../../../../../shared/runtime.js";
import { u as b } from "../../../../../../modules/useTableTotal-3d22365a.js";
const f = { class: "second-container" }, v = { key: 0 }, k = { key: 1 }, g = { key: 0 }, A = { key: 1 }, D = { key: 0 }, x = { key: 1 }, T = { key: 0 }, E = { key: 1 }, w = { __name: "second-table", setup(C) {
  const { tableList: c } = p("invoice_data");
  c.forEach((_) => {
    _.checked = false;
  });
  const { getSummaries: d } = b(false, { defineData: ["paymentAmount", "invoiceAmount"] });
  return (_, S) => {
    const o = r, m = u;
    return t(), a("div", f, [n(y, { "header-title": "付款及发票记录" }), n(m, { data: l(c), "summary-method": l(d), border: "", fit: "", "max-height": "340", "show-summary": "" }, { default: s(() => [n(o, { align: "center", label: "序号", type: "index", width: "80" }), n(o, { align: "center", label: "付款", "min-width": "120", prop: "paymentAmount" }, { default: s(({ row: e }) => [e.paymentAmount ? (t(), a("span", v, i(e.paymentAmount), 1)) : (t(), a("span", k, "-"))]), _: 1 }), n(o, { align: "center", label: "日期", "min-width": "120", prop: "paymentDate" }, { default: s(({ row: e }) => [e.paymentDate ? (t(), a("span", g, i(e.paymentDate), 1)) : (t(), a("span", A, "-"))]), _: 1 }), n(o, { align: "center", label: "发票", "min-width": "120", prop: "invoiceAmount" }, { default: s(({ row: e }) => [e.invoiceAmount ? (t(), a("span", D, i(e.invoiceAmount), 1)) : (t(), a("span", x, "-"))]), _: 1 }), n(o, { align: "center", label: "日期", "min-width": "120", prop: "invoiceDate" }, { default: s(({ row: e }) => [e.invoiceDate ? (t(), a("span", T, i(e.invoiceDate), 1)) : (t(), a("span", E, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "summary-method"])]);
  };
} }, I = h(w, [["__scopeId", "data-v-5875bd60"]]);
export {
  I as default
};
