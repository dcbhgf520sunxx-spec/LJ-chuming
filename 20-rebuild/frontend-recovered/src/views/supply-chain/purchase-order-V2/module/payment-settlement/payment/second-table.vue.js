import { inject as w } from "vue";
import { ref as p } from "vue";
import { watch as _ } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as n } from "vue";
import { createVNode as t } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as u } from "vue";
import { unref as y } from "vue";
import { ElTableColumn as N } from "element-plus";
import { ElInput as x } from "element-plus";
import { ElTable as I } from "element-plus";
import { _ as V, ia as C, dp as T, iK as B } from "../../../../../../shared/runtime.js";
import { u as P } from "../../../../../../modules/useTableTotal-3d22365a.js";
import D from "../../storage-detail.vue.js";
const E = { class: "second-table-container" }, U = { key: 0 }, j = { key: 1 }, F = { key: 0 }, R = { key: 1 }, z = ["onClick"], H = { key: 1 }, K = { key: 0 }, L = { key: 1 }, O = { key: 0 }, q = { key: 1 }, G = { __name: "second-table", setup(J, { expose: b }) {
  const h = w("payment_data"), { formData: f, projectInfo: c } = h, d = p({}), i = p(false), { getSummaries: A, applyAmount: g } = P(true, { defineData: ["contractAmount", "paymentAmountSum", "storageAmountSum", "invoiceAmountSum", "moneyAmount"] });
  _(() => g.value, (m) => {
    const l = parseFloat(m) !== 0 ? C(m) : "";
    Object.assign(c, { currentPaymentAmount: l });
  }), _(() => c.currentPaymentAmount, (m, l) => {
    !m && l && (c.currentPaymentAmount = l);
  }, { deep: true });
  const S = (m, l, o) => {
    l[o] = B(m, { decimalPlaces: 2, allowNegative: true });
  };
  return b({}), (m, l) => {
    const o = N, k = x, v = I;
    return a(), n("div", E, [t(T, { "header-title": "付款及开票记录" }), t(v, { data: y(f).tableList, "summary-method": y(A), border: "", fit: "", "show-summary": "" }, { default: s(() => [t(o, { align: "center", label: "序号", type: "index", width: "80" }), t(o, { align: "center", label: "合同编号", "min-width": "120", prop: "purchaseContractNumber", "show-overflow-tooltip": "" }), t(o, { align: "center", label: "签订主体", "min-width": "160", prop: "contractSignBodyName", "show-overflow-tooltip": "" }, { default: s(({ row: e }) => [e.contractSignBodyName ? (a(), n("span", U, u(e.contractSignBodyName), 1)) : (a(), n("span", j, "-"))]), _: 1 }), t(o, { align: "center", label: "合同额", "min-width": "120", prop: "contractAmount" }, { default: s(({ row: e }) => [e.contractAmount ? (a(), n("span", F, u(e.contractAmount), 1)) : (a(), n("span", R, "-"))]), _: 1 }), t(o, { align: "center", label: "入库额", "min-width": "120" }, { default: s(({ row: e }) => [e.storageAmountSum ? (a(), n("span", { key: 0, class: "tip_text", onClick: () => {
      d.value = e, i.value = true;
    } }, u(e.storageAmountSum), 9, z)) : (a(), n("span", H, "-"))]), _: 1 }), t(o, { align: "center", label: "累计付款", "min-width": "120", prop: "paymentAmountSum" }, { default: s(({ row: e }) => [e.paymentAmountSum ? (a(), n("span", K, u(e.paymentAmountSum), 1)) : (a(), n("span", L, "-"))]), _: 1 }), t(o, { align: "center", label: "累计开票", "min-width": "120", prop: "invoiceAmountSum" }, { default: s(({ row: e }) => [e.invoiceAmountSum ? (a(), n("span", O, u(e.invoiceAmountSum), 1)) : (a(), n("span", q, "-"))]), _: 1 }), t(o, { align: "center", label: "本次付款", "min-width": "120", prop: "moneyAmount" }, { default: s(({ row: e }) => [t(k, { modelValue: e.moneyAmount, "onUpdate:modelValue": (r) => e.moneyAmount = r, clearable: "", placeholder: "请输入金额", size: "default", onInput: (r) => S(r, e, "moneyAmount") }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])]), _: 1 })]), _: 1 }, 8, ["data", "summary-method"]), t(D, { modelValue: i.value, "onUpdate:modelValue": l[0] || (l[0] = (e) => i.value = e), apiParamField: "orderId", titleFields: [{ key: "purchaseContractNumber", label: "采购合同号" }, { key: "contractSignBodyName", label: "签订主体" }], currentRow: d.value }, null, 8, ["modelValue", "currentRow"])]);
  };
} }, Y = V(G, [["__scopeId", "data-v-8d2e3815"]]);
export {
  Y as default
};
