import { inject as r } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as o } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as _ } from "vue";
import { unref as c } from "vue";
import { ElTableColumn as p } from "element-plus";
import { ElTable as m } from "element-plus";
import { _ as h, dp as u } from "../../../../../../shared/runtime.js";
import { u as b } from "../../../../../../modules/useTableTotal-3d22365a.js";
const f = { class: "second-container" }, y = { key: 0 }, w = { key: 1 }, k = { key: 0 }, g = { key: 1 }, x = { key: 0 }, T = { key: 1 }, v = { key: 0 }, C = { key: 1 }, E = { __name: "second-table", setup(S) {
  const { tableList: l } = r("invoice_data"), { getSummaries: i } = b(false, { defineData: ["paymentAmount", "invoiceAmount"] });
  return (A, B) => {
    const n = p, d = m;
    return t(), a("div", f, [o(u, { "header-title": "付款及发票记录" }), o(d, { data: c(l), "summary-method": c(i), border: "", fit: "", "max-height": "340", "show-summary": "" }, { default: s(() => [o(n, { align: "center", label: "序号", type: "index", width: "80" }), o(n, { align: "center", label: "付款", "min-width": "120", prop: "paymentAmount" }, { default: s(({ row: { paymentAmount: e } }) => [e ? (t(), a("span", y, _(e), 1)) : (t(), a("span", w, "-"))]), _: 1 }), o(n, { align: "center", label: "日期", "min-width": "120", prop: "paymentDate" }, { default: s(({ row: { paymentDate: e } }) => [e ? (t(), a("span", k, _(e), 1)) : (t(), a("span", g, "-"))]), _: 1 }), o(n, { align: "center", label: "发票", "min-width": "120", prop: "invoiceAmount" }, { default: s(({ row: { invoiceAmount: e } }) => [e ? (t(), a("span", x, _(e), 1)) : (t(), a("span", T, "-"))]), _: 1 }), o(n, { align: "center", label: "日期", "min-width": "120", prop: "invoiceDate" }, { default: s(({ row: { invoiceDate: e } }) => [e ? (t(), a("span", v, _(e), 1)) : (t(), a("span", C, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "summary-method"])]);
  };
} }, I = h(E, [["__scopeId", "data-v-bec4f837"]]);
export {
  I as default
};
