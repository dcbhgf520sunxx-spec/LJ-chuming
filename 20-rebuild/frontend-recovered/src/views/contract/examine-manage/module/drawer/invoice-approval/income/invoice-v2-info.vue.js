import { inject as r } from "vue";
import { computed as s } from "vue";
import { watchEffect as f } from "vue";
import { watch as b } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as u } from "vue";
import { withCtx as d } from "vue";
import { unref as t } from "vue";
import { ElInput as A } from "element-plus";
import { e3 as V, iK as w, e5 as N } from "../../../../../../../shared/runtime.js";
import { i as E, b as x } from "../../../../../../../modules/invoice-income-831df2fb.js";
const U = { class: "invoice-container" }, k = { __name: "invoice-v2-info", setup(C) {
  const n = r("approveInfo"), m = r("isCanEdit"), p = s(() => V(E, n.value)), e = r("purchaseForm");
  f(() => {
    n != null && n.value && (e.invoiceAmount = n.value.invoiceAmount, e.invoiceSerialNumber = n.value.invoiceSerialNumber);
  });
  const v = (a, o) => {
    /^[A-Za-z0-9-#_]*$/.test(a) ? e[o] = a : e[o] = e[o].replace(/[^A-Za-z0-9-#_]/g, "");
  }, _ = s(() => e.orderInvoiceList.reduce((a, o) => +a + +(Number(o.actualInvoiceAmount) ? o.actualInvoiceAmount : 0), 0));
  return b(_, (a) => {
    e.invoiceAmount = w(a + "", { allowNegative: true, decimalPlaces: 2 });
  }, { immediate: true }), (a, o) => {
    const c = A;
    return h(), I("div", U, [u(N, { column: 2, "form-data": t(e), "form-rules": t(x), "table-list": p.value, "item-width": "12vw" }, { invoiceAmount: d(({ item: l }) => [u(c, { modelValue: t(e)[l], "onUpdate:modelValue": (i) => t(e)[l] = i, clearable: "", placeholder: "录入发票额", readonly: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), invoiceSerialNumber: d(({ item: l }) => [u(c, { modelValue: t(e)[l], "onUpdate:modelValue": (i) => t(e)[l] = i, clearable: "", placeholder: "录入发票编号", disabled: !t(m), onInput: (i) => v(i, l) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onInput"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  k as default
};
