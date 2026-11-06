import { inject as u } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as i } from "vue";
import { withCtx as c } from "vue";
import { unref as a } from "vue";
import { ElInput as _ } from "element-plus";
import { e5 as f } from "../../../../../shared/runtime.js";
import { i as b, b as v } from "../../../../../modules/invoice-entry-bd0669f8.js";
const V = { class: "invoice-container" }, A = { __name: "invoice-info", setup(h) {
  const s = u("invoice_data"), { formData: e } = s, d = (l, t) => {
    /^[A-Za-z0-9-#_]*$/.test(l) ? e[t] = l : e[t] = e[t].replace(/[^A-Za-z0-9-#_]/g, "");
  };
  return (l, t) => {
    const r = _;
    return p(), m("div", V, [i(f, { column: 2, "form-data": a(e), "form-rules": a(b), "table-list": a(v), "label-width": "100px" }, { invoiceAmount: c(({ item: o }) => [i(r, { modelValue: a(e)[o], "onUpdate:modelValue": (n) => a(e)[o] = n, modelModifiers: { number: true }, clearable: "", placeholder: "录入发票额", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), invoiceSerialNumber: c(({ item: o }) => [i(r, { modelValue: a(e)[o], "onUpdate:modelValue": (n) => a(e)[o] = n, clearable: "", placeholder: "录入发票编号", onInput: (n) => d(n, o) }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  A as default
};
