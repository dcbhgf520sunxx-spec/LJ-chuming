import { inject as r } from "vue";
import { computed as _ } from "vue";
import { watchEffect as g } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as s } from "vue";
import { withCtx as u } from "vue";
import { unref as e } from "vue";
import { Fragment as f } from "vue";
import { renderList as h } from "vue";
import { createBlock as U } from "vue";
import { ElInput as B } from "element-plus";
import { ElOption as I } from "element-plus";
import { ElSelect as A } from "element-plus";
import { e3 as D, bD as N, c3 as S, e5 as k, iK as w } from "../../../../../../../shared/runtime.js";
import { i as x, b as y } from "../../../../../../../modules/invoice-income-831df2fb.js";
const L = { class: "invoice-container" }, O = { __name: "invoice-info", setup(T) {
  const n = r("approveInfo"), i = r("tableItemData"), E = _(() => D(x, n.value)), a = r("purchaseForm");
  g(() => {
    n != null && n.value && (a.invoiceAmount = n.value.invoiceAmount, a.invoiceSerialNumber = n.value.invoiceSerialNumber);
  });
  function F() {
    const v = a.invoiceAmount;
    a.invoiceAmount = w(v, { decimalPlaces: 2, allowNegative: false });
  }
  const m = _(() => n.value.boolFinalApprover && n.value.passButton && i.approvalFlag);
  return (v, R) => {
    const c = B, b = I, V = A;
    return d(), p("div", L, [s(k, { column: 2, "form-data": e(a), "form-rules": e(y), "table-list": E.value, "item-width": "12vw" }, { invoiceSerialNumber: u(({ item: l }) => [s(c, { modelValue: e(a)[l], "onUpdate:modelValue": (t) => e(a)[l] = t, disabled: !m.value }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), invoiceAmount: u(({ item: l }) => [s(c, { modelValue: e(a)[l], "onUpdate:modelValue": (t) => e(a)[l] = t, disabled: !m.value, clearable: "", placeholder: "录入发票额", onInput: F }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), supplierInvoiceType: u(({ item: l }) => {
      var t;
      return [s(V, { modelValue: e(a)[l], "onUpdate:modelValue": (o) => e(a)[l] = o, disabled: !((t = e(n)) != null && t.passButton && e(i).approvalFlag), clearable: "", placeholder: "请选择开票方式" }, { default: u(() => [(d(true), p(f, null, h(e(N).V, (o) => (d(), U(b, { key: o.K, label: o.L, value: o.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])];
    }), invoiceTaxRate: u(({ item: l }) => {
      var t;
      return [s(c, { modelValue: e(a)[l], "onUpdate:modelValue": (o) => e(a)[l] = o, disabled: !((t = e(n)) != null && t.passButton && e(i).approvalFlag), clearable: "", placeholder: "请输入发票税率" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])];
    }), auditStatusEnum: u(({ item: l }) => {
      var t;
      return [s(V, { modelValue: e(a)[l], "onUpdate:modelValue": (o) => e(a)[l] = o, disabled: !((t = e(n)) != null && t.passButton && e(i).approvalFlag), clearable: "", placeholder: "请选择审批状态" }, { default: u(() => [(d(true), p(f, null, h(e(S).V, (o) => (d(), U(b, { key: o.V, label: o.L, value: o.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])];
    }), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  O as default
};
