import { inject as S } from "vue";
import { watch as v } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as o } from "vue";
import { createVNode as t } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as u } from "vue";
import { unref as i } from "vue";
import { ElTableColumn as k } from "element-plus";
import { ElInput as w } from "element-plus";
import { ElTable as B } from "element-plus";
import { _ as N, ia as x, dp as I, iK as T, e2 as E } from "../../../../../../../shared/runtime.js";
import { u as V } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const C = { class: "second-table-container" }, j = { key: 0 }, D = { key: 1 }, U = { key: 0 }, F = { key: 1 }, P = { key: 0 }, z = { key: 1 }, H = { key: 0 }, K = { key: 1 }, L = { __name: "second-table", setup(O, { expose: d }) {
  const p = S("payment_data"), { formData: r, projectInfo: _ } = p, { getSummaries: y, applyAmount: h } = V(true, { defineData: ["contractAmount", "paymentAmountSum", "storageAmountSum", "invoiceAmountSum", "moneyAmount"] });
  v(() => h.value, (m) => {
    const l = parseFloat(m) !== 0 ? x(m) : "";
    Object.assign(_, { currentPaymentAmount: l });
  });
  const b = (m, l, n) => {
    l[n] = T(m, { decimalPlaces: 2, allowNegative: true });
  }, f = (m) => {
    parseFloat(m.moneyAmount) === 0 && (m.moneyAmount = void 0, E("warning", "本次付款不得小于0,请重新输入!"));
  };
  return d({}), (m, l) => {
    const n = k, A = w, g = B;
    return a(), o("div", C, [t(I, { "header-title": "付款及开票记录" }), t(g, { data: i(r).tableList, "summary-method": i(y), border: "", fit: "", "show-summary": "" }, { default: s(() => [t(n, { align: "center", label: "序号", type: "index", width: "80" }), t(n, { align: "center", label: "合同编号", "min-width": "120", prop: "purchaseContractNumber", "show-overflow-tooltip": "" }), t(n, { align: "center", label: "签订主体", "min-width": "160", prop: "contractSignBodyName", "show-overflow-tooltip": "" }, { default: s(({ row: e }) => [e.contractSignBodyName ? (a(), o("span", j, u(e.contractSignBodyName), 1)) : (a(), o("span", D, "-"))]), _: 1 }), t(n, { align: "center", label: "合同额", "min-width": "120", prop: "contractAmount" }, { default: s(({ row: e }) => [e.contractAmount ? (a(), o("span", U, u(e.contractAmount), 1)) : (a(), o("span", F, "-"))]), _: 1 }), t(n, { align: "center", label: "累计付款", "min-width": "120", prop: "paymentAmountSum" }, { default: s(({ row: e }) => [e.paymentAmountSum ? (a(), o("span", P, u(e.paymentAmountSum), 1)) : (a(), o("span", z, "-"))]), _: 1 }), t(n, { align: "center", label: "累计开票", "min-width": "120", prop: "invoiceAmountSum" }, { default: s(({ row: e }) => [e.invoiceAmountSum ? (a(), o("span", H, u(e.invoiceAmountSum), 1)) : (a(), o("span", K, "-"))]), _: 1 }), t(n, { align: "center", label: "本次付款", "min-width": "120", prop: "moneyAmount" }, { default: s(({ row: e }) => [t(A, { modelValue: e.moneyAmount, "onUpdate:modelValue": (c) => e.moneyAmount = c, clearable: "", placeholder: "请输入金额", size: "default", onBlur: (c) => f(e), onInput: (c) => b(c, e, "moneyAmount") }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur", "onInput"])]), _: 1 })]), _: 1 }, 8, ["data", "summary-method"])]);
  };
} }, J = N(L, [["__scopeId", "data-v-64ad88ba"]]);
export {
  J as default
};
