import { inject as g } from "vue";
import { watch as S } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as n } from "vue";
import { createVNode as a } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as l } from "vue";
import { unref as i } from "vue";
import { ElTableColumn as k } from "element-plus";
import { ElInput as v } from "element-plus";
import { ElTable as w } from "element-plus";
import { _ as N, ia as x, dp as I, iK as T } from "../../../../../../shared/runtime.js";
import { u as B } from "../../../../../../modules/useTableTotal-3d22365a.js";
const V = { class: "second-table-container" }, C = { key: 0 }, E = { key: 1 }, j = { key: 0 }, D = { key: 1 }, U = { key: 0 }, P = { key: 1 }, z = { key: 0 }, F = { key: 1 }, H = { key: 0 }, K = { key: 1 }, L = { __name: "second-table", setup(O, { expose: d }) {
  const p = g("payment_data"), { formData: _, projectInfo: r } = p, { getSummaries: y, applyAmount: h } = B(true, { defineData: ["contractAmount", "paymentAmountSum", "storageAmountSum", "invoiceAmountSum", "moneyAmount"] });
  S(() => h.value, (m) => {
    const c = parseFloat(m) !== 0 ? x(m) : "";
    Object.assign(r, { currentPaymentAmount: c });
  });
  const b = (m, c, o) => {
    c[o] = T(m, { decimalPlaces: 2, allowNegative: true });
  };
  return d({}), (m, c) => {
    const o = k, f = v, A = w;
    return t(), n("div", V, [a(I, { "header-title": "付款及开票记录" }), a(A, { data: i(_).tableList, "summary-method": i(y), border: "", fit: "", "show-summary": "" }, { default: s(() => [a(o, { align: "center", label: "序号", type: "index", width: "80" }), a(o, { align: "center", label: "合同编号", "min-width": "120", prop: "purchaseContractNumber", "show-overflow-tooltip": "" }), a(o, { align: "center", label: "签订主体", "min-width": "160", prop: "contractSignBodyName", "show-overflow-tooltip": "" }, { default: s(({ row: e }) => [e.contractSignBodyName ? (t(), n("span", C, l(e.contractSignBodyName), 1)) : (t(), n("span", E, "-"))]), _: 1 }), a(o, { align: "center", label: "合同额", "min-width": "120", prop: "contractAmount" }, { default: s(({ row: e }) => [e.contractAmount ? (t(), n("span", j, l(e.contractAmount), 1)) : (t(), n("span", D, "-"))]), _: 1 }), a(o, { align: "center", label: "入库额", "min-width": "120" }, { default: s(({ row: e }) => [e.storageAmountSum ? (t(), n("span", U, l(e.storageAmountSum), 1)) : (t(), n("span", P, "-"))]), _: 1 }), a(o, { align: "center", label: "累计付款", "min-width": "120", prop: "paymentAmountSum" }, { default: s(({ row: e }) => [e.paymentAmountSum ? (t(), n("span", z, l(e.paymentAmountSum), 1)) : (t(), n("span", F, "-"))]), _: 1 }), a(o, { align: "center", label: "累计开票", "min-width": "120", prop: "invoiceAmountSum" }, { default: s(({ row: e }) => [e.invoiceAmountSum ? (t(), n("span", H, l(e.invoiceAmountSum), 1)) : (t(), n("span", K, "-"))]), _: 1 }), a(o, { align: "center", label: "本次付款", "min-width": "120", prop: "moneyAmount" }, { default: s(({ row: e }) => [a(f, { modelValue: e.moneyAmount, "onUpdate:modelValue": (u) => e.moneyAmount = u, clearable: "", placeholder: "请输入金额", size: "default", onInput: (u) => b(u, e, "moneyAmount") }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])]), _: 1 })]), _: 1 }, 8, ["data", "summary-method"])]);
  };
} }, M = N(L, [["__scopeId", "data-v-bc136ddb"]]);
export {
  M as default
};
