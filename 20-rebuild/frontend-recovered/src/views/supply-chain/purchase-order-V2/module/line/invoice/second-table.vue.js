import { inject as f } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as o } from "vue";
import { createVNode as a } from "vue";
import { withCtx as c } from "vue";
import { toDisplayString as s } from "vue";
import { unref as u } from "vue";
import { ElTableColumn as y } from "element-plus";
import { ElInput as b } from "element-plus";
import { ElTable as A } from "element-plus";
import { _ as v, dp as g } from "../../../../../../shared/runtime.js";
import { u as S } from "../../../../../../modules/useTableTotal-3d22365a.js";
const k = { class: "second-container" }, w = { key: 0 }, x = { key: 1 }, I = { key: 0 }, T = { key: 1 }, B = { key: 0 }, E = { key: 1 }, N = { key: 0 }, V = { key: 1 }, C = { key: 0 }, D = { key: 1 }, L = { __name: "second-table", setup(U) {
  const { formData: d } = f("invoice_data");
  d.orderInvoiceList.forEach((i) => {
    i.checked = false;
  });
  const { getSummaries: _ } = S(false, { defineData: ["contractAmount", "paymentAmountSum", "storageAmountSum", "invoiceAmountSum", "invoiceAmount"] }), r = (i, l) => {
    const t = i.match(/^-?\d*\.?\d{0,5}/);
    t ? l.invoiceAmount = t[0] : l.invoiceAmount = "";
  };
  return (i, l) => {
    const t = y, p = b, h = A;
    return n(), o("div", k, [a(g, { "header-title": "付款及发票记录" }), a(h, { data: u(d).orderInvoiceList, "summary-method": u(_), border: "", fit: "", "show-summary": "", "max-height": "240" }, { default: c(() => [a(t, { align: "center", label: "序号", type: "index", width: "80" }), a(t, { align: "center", label: "合同编号", "min-width": "120", prop: "purchaseContractNumber", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "签订主体", "min-width": "160", prop: "contractSignBodyName", "show-overflow-tooltip": "" }, { default: c(({ row: e }) => [e.contractSignBodyName ? (n(), o("span", w, s(e.contractSignBodyName), 1)) : (n(), o("span", x, "-"))]), _: 1 }), a(t, { align: "center", label: "合同额", "min-width": "120", prop: "contractAmount" }, { default: c(({ row: e }) => [e.contractAmount ? (n(), o("span", I, s(e.contractAmount), 1)) : (n(), o("span", T, "-"))]), _: 1 }), a(t, { align: "center", label: "入库额", "min-width": "120" }, { default: c(({ row: e }) => [e.storageAmountSum ? (n(), o("span", B, s(e.storageAmountSum), 1)) : (n(), o("span", E, "-"))]), _: 1 }), a(t, { align: "center", label: "累计付款", "min-width": "120", prop: "paymentAmountSum" }, { default: c(({ row: e }) => [e.paymentAmountSum ? (n(), o("span", N, s(e.paymentAmountSum), 1)) : (n(), o("span", V, "-"))]), _: 1 }), a(t, { align: "center", label: "累计开票", "min-width": "120", prop: "invoiceAmountSum" }, { default: c(({ row: e }) => [e.invoiceAmountSum ? (n(), o("span", C, s(e.invoiceAmountSum), 1)) : (n(), o("span", D, "-"))]), _: 1 }), a(t, { align: "center", label: "本次发票额", "min-width": "120", prop: "invoiceAmount" }, { default: c(({ row: e }) => [a(p, { modelValue: e.invoiceAmount, "onUpdate:modelValue": (m) => e.invoiceAmount = m, clearable: "", placeholder: "请输入金额", size: "default", onInput: (m) => r(m, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])]), _: 1 })]), _: 1 }, 8, ["data", "summary-method"])]);
  };
} }, q = v(L, [["__scopeId", "data-v-402ec7d3"]]);
export {
  q as default
};
