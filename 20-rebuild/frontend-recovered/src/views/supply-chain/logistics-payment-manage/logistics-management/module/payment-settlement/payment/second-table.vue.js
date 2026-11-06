import { inject as A } from "vue";
import { watch as g } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as n } from "vue";
import { createVNode as a } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as m } from "vue";
import { unref as i } from "vue";
import { ElTableColumn as S } from "element-plus";
import { ElInput as k } from "element-plus";
import { ElTable as v } from "element-plus";
import { _ as w, ia as x, dp as T } from "../../../../../../../shared/runtime.js";
import { u as N } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const B = { class: "second-table-container" }, V = { key: 0 }, C = { key: 1 }, E = { key: 0 }, j = { key: 1 }, D = { key: 0 }, I = { key: 1 }, U = { key: 0 }, z = { key: 1 }, F = { key: 0 }, H = { key: 1 }, L = { __name: "second-table", setup(O, { expose: u }) {
  const d = A("payment_data"), { formData: _, projectInfo: p } = d, { getSummaries: r, applyAmount: y } = N(true, { defineData: ["contractAmount", "paymentAmountSum", "storageAmountSum", "invoiceAmountSum", "moneyAmount"] });
  return g(() => y.value, (l) => {
    const c = parseFloat(l) > 0 ? x(l) : "";
    Object.assign(p, { currentPaymentAmount: c });
  }), u({}), (l, c) => {
    const o = S, h = k, b = v;
    return t(), n("div", B, [a(T, { "header-title": "付款及开票记录" }), a(b, { data: i(_).tableList, "summary-method": i(r), border: "", fit: "", "show-summary": "" }, { default: s(() => [a(o, { align: "center", label: "序号", type: "index", width: "80" }), a(o, { align: "center", label: "合同编号", "min-width": "120", prop: "purchaseContractNumber", "show-overflow-tooltip": "" }), a(o, { align: "center", label: "签订主体", "min-width": "160", prop: "contractSignBodyName", "show-overflow-tooltip": "" }, { default: s(({ row: e }) => [e.contractSignBodyName ? (t(), n("span", V, m(e.contractSignBodyName), 1)) : (t(), n("span", C, "-"))]), _: 1 }), a(o, { align: "center", label: "合同额", "min-width": "120", prop: "contractAmount" }, { default: s(({ row: e }) => [e.contractAmount ? (t(), n("span", E, m(e.contractAmount), 1)) : (t(), n("span", j, "-"))]), _: 1 }), a(o, { align: "center", label: "入库额", "min-width": "120" }, { default: s(({ row: e }) => [e.storageAmountSum ? (t(), n("span", D, m(e.storageAmountSum), 1)) : (t(), n("span", I, "-"))]), _: 1 }), a(o, { align: "center", label: "累计付款", "min-width": "120", prop: "paymentAmountSum" }, { default: s(({ row: e }) => [e.paymentAmountSum ? (t(), n("span", U, m(e.paymentAmountSum), 1)) : (t(), n("span", z, "-"))]), _: 1 }), a(o, { align: "center", label: "累计开票", "min-width": "120", prop: "invoiceAmountSum" }, { default: s(({ row: e }) => [e.invoiceAmountSum ? (t(), n("span", F, m(e.invoiceAmountSum), 1)) : (t(), n("span", H, "-"))]), _: 1 }), a(o, { align: "center", label: "本次付款", "min-width": "120", prop: "moneyAmount" }, { default: s(({ row: e }) => [a(h, { modelValue: e.moneyAmount, "onUpdate:modelValue": (f) => e.moneyAmount = f, clearable: "", placeholder: "请输入金额", size: "default", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })]), _: 1 }, 8, ["data", "summary-method"])]);
  };
} }, J = w(L, [["__scopeId", "data-v-09bd4d8f"]]);
export {
  J as default
};
