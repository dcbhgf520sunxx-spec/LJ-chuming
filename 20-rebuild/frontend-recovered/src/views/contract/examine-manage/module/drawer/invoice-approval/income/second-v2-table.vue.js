import { inject as r } from "vue";
import { ref as b } from "vue";
import { watchEffect as g } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as u } from "vue";
import { createElementVNode as k } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as i } from "vue";
import { unref as h } from "vue";
import { createBlock as S } from "vue";
import { ElTableColumn as E } from "element-plus";
import { ElInput as w } from "element-plus";
import { ElTable as B } from "element-plus";
import { ec as C, dp as N } from "../../../../../../../shared/runtime.js";
import { u as V } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const x = { class: "second-tabel-container" }, T = { class: "table" }, D = { key: 0 }, L = { key: 1 }, j = { key: 0 }, F = { key: 1 }, U = { key: 0 }, z = { key: 1 }, H = { key: 0 }, O = { key: 1 }, q = { key: 0 }, G = { key: 1 }, J = { key: 0 }, K = { key: 1 }, M = { key: 1 }, X = { __name: "second-v2-table", setup(P) {
  const p = r("approveInfo"), _ = r("purchaseForm"), s = b([]), A = r("isCanEdit");
  g(() => {
    p.value && !s.value.length && (s.value = C(p.value.orderInvoiceList, ["actualInvoiceAmount", "invoiceAmount"]), _.orderInvoiceList = s.value.map((t) => ({ actualInvoiceAmount: t.actualInvoiceAmount || t.invoiceAmount, orderId: t.orderId })), s.value.forEach((t) => {
      t.actualInvoiceAmount = t.actualInvoiceAmount || t.invoiceAmount, Object.keys(t).forEach((n) => {
        t[n] || (t[n] = "-");
      });
    }));
  });
  const { getSummaries: f } = V(true, { defineData: ["contractAmount", "paymentAmountSum", "storageAmountSum", "invoiceAmountSum", "invoiceAmount", "actualInvoiceAmount"] }), v = (t, n) => {
    const o = _.orderInvoiceList.find((m) => m.orderId === t);
    o.actualInvoiceAmount = n;
  }, I = (t, n) => {
    const o = t.match(/^-?\d*\.?\d{0,5}/);
    if (o) {
      if (+o[0] > +n.invoiceAmount) {
        n.actualInvoiceAmount = n.invoiceAmount, v(n.orderId, n.actualInvoiceAmount);
        return;
      }
      n.actualInvoiceAmount = o[0];
    } else n.actualInvoiceAmount = "";
    v(n.orderId, n.actualInvoiceAmount);
  };
  return (t, n) => {
    const o = E, m = w, y = B;
    return a(), c("div", x, [u(N, { "header-title": "付款及发票记录" }), k("div", T, [u(y, { data: s.value, "summary-method": h(f), border: "", fit: "", "show-summary": "", "max-height": "240" }, { default: l(() => [u(o, { align: "center", label: "序号", type: "index", width: "80" }), u(o, { align: "center", label: "合同编号", "min-width": "120", prop: "purchaseContractNumber", "show-overflow-tooltip": "" }), u(o, { align: "center", label: "签订主体", "min-width": "160", prop: "contractSignBodyName", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [e.contractSignBodyName ? (a(), c("span", D, i(e.contractSignBodyName), 1)) : (a(), c("span", L, "-"))]), _: 1 }), u(o, { align: "center", label: "合同额", "min-width": "120", prop: "contractAmount" }, { default: l(({ row: e }) => [e.contractAmount ? (a(), c("span", j, i(e.contractAmount), 1)) : (a(), c("span", F, "-"))]), _: 1 }), u(o, { align: "center", label: "入库额", "min-width": "120" }, { default: l(({ row: e }) => [e.storageAmountSum ? (a(), c("span", U, i(e.storageAmountSum), 1)) : (a(), c("span", z, "-"))]), _: 1 }), u(o, { align: "center", label: "累计付款", "min-width": "120", prop: "paymentAmountSum" }, { default: l(({ row: e }) => [e.paymentAmountSum ? (a(), c("span", H, i(e.paymentAmountSum), 1)) : (a(), c("span", O, "-"))]), _: 1 }), u(o, { align: "center", label: "累计开票", "min-width": "120", prop: "invoiceAmountSum" }, { default: l(({ row: e }) => [e.invoiceAmountSum ? (a(), c("span", q, i(e.invoiceAmountSum), 1)) : (a(), c("span", G, "-"))]), _: 1 }), u(o, { align: "center", label: "申请金额", "min-width": "120", prop: "invoiceAmount" }, { default: l(({ row: e }) => [e.invoiceAmount ? (a(), c("span", J, i(e.invoiceAmount), 1)) : (a(), c("span", K, "-"))]), _: 1 }), u(o, { align: "center", label: "实际金额", "min-width": "120", prop: "actualInvoiceAmount" }, { default: l(({ row: e }) => [h(A) ? (a(), S(m, { key: 0, modelValue: e.actualInvoiceAmount, "onUpdate:modelValue": (d) => e.actualInvoiceAmount = d, clearable: false, placeholder: "请输入金额", size: "default", onInput: (d) => I(d, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])) : (a(), c("span", M, i(e.actualInvoiceAmount), 1))]), _: 1 })]), _: 1 }, 8, ["data", "summary-method"])])]);
  };
} };
export {
  X as default
};
