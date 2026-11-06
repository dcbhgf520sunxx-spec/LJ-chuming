import { inject as m } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as i } from "vue";
import { withCtx as r } from "vue";
import { unref as o } from "vue";
import { ElInput as f } from "element-plus";
import { e5 as v, iK as I } from "../../../../../../shared/runtime.js";
import { i as V, b } from "../../../../../../modules/invoice-entry-de8cd325.js";
const h = { class: "invoice-container" }, g = { __name: "invoice-info", setup(A) {
  const s = m("invoice_data"), { formData: e, projectInfo: N } = s, u = (n, l) => {
    /^[A-Za-z0-9-#_]*$/.test(n) ? e[l] = n : e[l] = e[l].replace(/[^A-Za-z0-9-#_]/g, "");
  }, d = () => {
    const n = e.invoiceAmount;
    e.invoiceAmount = I(n, { allowNegative: true, decimalPlaces: 2 });
  };
  return (n, l) => {
    const c = f;
    return p(), _("div", h, [i(v, { column: 2, "form-data": o(e), "form-rules": o(V), "table-list": o(b) }, { invoiceAmount: r(({ item: a }) => [i(c, { modelValue: o(e)[a], "onUpdate:modelValue": (t) => o(e)[a] = t, clearable: "", placeholder: "录入发票额", onInput: d }, null, 8, ["modelValue", "onUpdate:modelValue"])]), invoiceSerialNumber: r(({ item: a }) => [i(c, { modelValue: o(e)[a], "onUpdate:modelValue": (t) => o(e)[a] = t, clearable: "", placeholder: "录入发票编号", onInput: (t) => u(t, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  g as default
};
