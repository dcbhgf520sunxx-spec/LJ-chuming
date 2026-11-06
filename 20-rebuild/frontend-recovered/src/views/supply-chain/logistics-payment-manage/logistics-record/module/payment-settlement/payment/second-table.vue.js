import { inject as E } from "vue";
import { ref as y } from "vue";
import { watch as T } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as n } from "vue";
import { withCtx as c } from "vue";
import { unref as b } from "vue";
import { toDisplayString as d } from "vue";
import { ElTableColumn as w } from "element-plus";
import { ElInput as V } from "element-plus";
import { ElFormItem as C } from "element-plus";
import { ElTable as I } from "element-plus";
import { ElForm as j } from "element-plus";
import { _ as B, ia as D, e7 as F, iY as N } from "../../../../../../../shared/runtime.js";
const U = { class: "second-table-container" }, z = { key: 0 }, L = { key: 1 }, R = { key: 0 }, $ = { key: 1 }, q = { key: 0 }, x = { key: 1 }, M = { __name: "second-table", setup(O, { expose: g }) {
  const A = E("payment_data"), { formData: f, projectInfo: S } = A, h = y(null), _ = y(null), v = (s) => {
    if (s && s.columns.length && s.data.length) {
      const { columns: r, data: o } = s, t = [], p = ["contractAmount", "paymentAmountSum", "invoiceAmountSum", "moneyAmount"];
      return r.forEach((u, a) => {
        if (a === 0) {
          t[a] = `${o.length + 1}`;
          return;
        }
        if (a === 1) {
          t[a] = "合计";
          return;
        }
        p.includes(u.property) && o.forEach((e) => {
          if (e[u.property]) {
            const i = F(e[u.property]);
            t[a] ? t[a] += i : t[a] = i;
          }
        });
      }), t.length === r.length ? _.value = t[t.length - 1] : _.value = 0, N(t);
    }
  };
  return T(() => _.value, (s) => {
    const r = parseFloat(s) > 0 ? D(s) : "";
    Object.assign(S, { currentPaymentAmount: r });
  }), g({ formRef: h }), (s, r) => {
    const o = w, t = V, p = C, u = I, a = j;
    return l(), m("div", U, [n(a, { model: b(f), ref_key: "formRef", ref: h }, { default: c(() => [n(u, { border: "", data: b(f).tableList, fit: "", "show-summary": "", "summary-method": v }, { default: c(() => [n(o, { type: "index", label: "序号", align: "center", width: "80" }), n(o, { prop: "purchaseContractNumber", label: "合同编号", align: "center", "min-width": "120" }), n(o, { prop: "contractAmount", label: "合同额", align: "center", "min-width": "120" }, { default: c(({ row: e }) => [e.contractAmount ? (l(), m("span", z, d(e.contractAmount), 1)) : (l(), m("span", L, "-"))]), _: 1 }), n(o, { prop: "paymentAmountSum", label: "累计付款", align: "center", "min-width": "120" }, { default: c(({ row: e }) => [e.paymentAmountSum ? (l(), m("span", R, d(e.paymentAmountSum), 1)) : (l(), m("span", $, "-"))]), _: 1 }), n(o, { prop: "invoiceAmountSum", label: "累计开票", align: "center", "min-width": "120" }, { default: c(({ row: e }) => [e.invoiceAmountSum ? (l(), m("span", q, d(e.invoiceAmountSum), 1)) : (l(), m("span", x, "-"))]), _: 1 }), n(o, { prop: "moneyAmount", label: "本次付款", align: "center", "min-width": "120" }, { default: c(({ row: e, $index: i }) => [n(p, { prop: `tableList.${i}.moneyAmount`, rules: { required: true, message: "金额不能为空", trigger: ["change", "blur"] } }, { default: c(() => [n(t, { placeholder: "请输入金额", size: "mini", modelValue: e.moneyAmount, "onUpdate:modelValue": (k) => e.moneyAmount = k, modelModifiers: { number: true }, clearable: "", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop"])]), _: 1 })]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["model"])]);
  };
} }, G = B(M, [["__scopeId", "data-v-92229883"]]);
export {
  G as default
};
