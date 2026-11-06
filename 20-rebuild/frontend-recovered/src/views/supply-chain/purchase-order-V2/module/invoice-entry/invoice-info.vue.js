import { inject as m } from "vue";
import { computed as p } from "vue";
import { watch as _ } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as s } from "vue";
import { withCtx as c } from "vue";
import { unref as t } from "vue";
import { ElInput as V } from "element-plus";
import { e7 as b, iY as h, e5 as I, iX as A } from "../../../../../shared/runtime.js";
import { i as N, b as U } from "../../../../../modules/invoice-entry-d59b5377.js";
const w = { class: "invoice-container" }, z = { __name: "invoice-info", setup(x) {
  const r = m("invoice_data"), { formData: e, projectInfo: P } = r, u = (o, a) => {
    /^[A-Za-z0-9-#_]*$/.test(o) ? e[a] = o : e[a] = e[a].replace(/[^A-Za-z0-9-#_]/g, "");
  }, d = p(() => e.orderInvoiceList.reduce((o, a) => {
    const n = b(a.invoiceAmount);
    return typeof n == "number" && !isNaN(n) && (o = A(o + n, 2)), o;
  }, 0));
  return _(d, (o) => {
    var a;
    e.invoiceAmount = (a = h([o])) == null ? void 0 : a[0];
  }, { immediate: true }), (o, a) => {
    const n = V;
    return f(), v("div", w, [s(I, { column: 2, "form-data": t(e), "form-rules": t(N), "table-list": t(U) }, { invoiceAmount: c(({ item: i }) => [s(n, { modelValue: t(e)[i], "onUpdate:modelValue": (l) => t(e)[i] = l, clearable: "", placeholder: "录入发票额", readonly: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), invoiceSerialNumber: c(({ item: i }) => [s(n, { modelValue: t(e)[i], "onUpdate:modelValue": (l) => t(e)[i] = l, clearable: "", placeholder: "录入发票编号", onInput: (l) => u(l, i) }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  z as default
};
