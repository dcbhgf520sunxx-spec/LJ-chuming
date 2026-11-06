import { inject as r } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as i } from "vue";
import { unref as l } from "vue";
import { ElTableColumn as u } from "element-plus";
import { ElTable as h } from "element-plus";
import { dp as y } from "../../../../../../shared/runtime.js";
import { u as b } from "../../../../../../modules/useTableTotal-3d22365a.js";
const f = { class: "second-container" }, k = { key: 0 }, D = { key: 1 }, g = { key: 0 }, v = { key: 1 }, A = { key: 0 }, x = { key: 1 }, T = { key: 0 }, w = { key: 1 }, H = { __name: "second-table", setup(C, { expose: m }) {
  const { tableList: c } = r("settlement_data"), { getSummaries: _, requestData: d } = b(false, { defineData: ["paymentAmount", "invoiceAmount"] });
  return m({ requestData: d }), (E, B) => {
    const o = u, p = h;
    return t(), a("div", f, [n(y, { "header-title": "付款及开票记录" }), n(p, { data: l(c), "summary-method": l(_), border: "", fit: "", "max-height": "340", "show-summary": "" }, { default: s(() => [n(o, { align: "center", label: "序号", type: "index", width: "80" }), n(o, { align: "center", label: "付款", "min-width": "120", prop: "paymentAmount" }, { default: s(({ row: e }) => [e.paymentAmount ? (t(), a("span", k, i(e.paymentAmount), 1)) : (t(), a("span", D, "-"))]), _: 1 }), n(o, { align: "center", label: "日期", "min-width": "120", prop: "paymentDate" }, { default: s(({ row: e }) => [e.paymentDate ? (t(), a("span", g, i(e.paymentDate), 1)) : (t(), a("span", v, "-"))]), _: 1 }), n(o, { align: "center", label: "发票", "min-width": "120", prop: "invoiceAmount" }, { default: s(({ row: e }) => [e.invoiceAmount ? (t(), a("span", A, i(e.invoiceAmount), 1)) : (t(), a("span", x, "-"))]), _: 1 }), n(o, { align: "center", label: "日期", "min-width": "120", prop: "invoiceDate" }, { default: s(({ row: e }) => [e.invoiceDate ? (t(), a("span", T, i(e.invoiceDate), 1)) : (t(), a("span", w, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "summary-method"])]);
  };
} };
export {
  H as default
};
