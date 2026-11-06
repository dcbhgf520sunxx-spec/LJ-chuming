import { inject as m } from "vue";
import { computed as p } from "vue";
import { watch as _ } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as r } from "vue";
import { withCtx as c } from "vue";
import { unref as n } from "vue";
import { ElInput as b } from "element-plus";
import { iK as I, e5 as V } from "../../../../../../shared/runtime.js";
import { i as h, b as A } from "../../../../../../modules/invoice-entry-fec44303.js";
const N = { class: "invoice-container" }, j = { __name: "invoice-info", setup(w) {
  const s = m("invoice_data"), { formData: e, projectInfo: U } = s, u = (o, a) => {
    /^[A-Za-z0-9-#_]*$/.test(o) ? e[a] = o : e[a] = e[a].replace(/[^A-Za-z0-9-#_]/g, "");
  }, d = p(() => e.orderInvoiceList.reduce((o, a) => +o + +(Number(a.invoiceAmount) ? a.invoiceAmount : 0), 0));
  return _(d, (o) => {
    e.invoiceAmount = I(o + "", { allowNegative: true, decimalPlaces: 2 });
  }, { immediate: true }), (o, a) => {
    const i = b;
    return f(), v("div", N, [r(V, { column: 2, "form-data": n(e), "form-rules": n(h), "table-list": n(A) }, { invoiceAmount: c(({ item: t }) => [r(i, { modelValue: n(e)[t], "onUpdate:modelValue": (l) => n(e)[t] = l, clearable: "", placeholder: "录入发票额", readonly: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), invoiceSerialNumber: c(({ item: t }) => [r(i, { modelValue: n(e)[t], "onUpdate:modelValue": (l) => n(e)[t] = l, clearable: "", placeholder: "录入发票编号", onInput: (l) => u(l, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  j as default
};
