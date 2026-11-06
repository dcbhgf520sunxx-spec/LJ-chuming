import { inject as d } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as c } from "vue";
import { withCtx as i } from "vue";
import { unref as o } from "vue";
import { ElInput as _ } from "element-plus";
import { e5 as f } from "../../../../../../shared/runtime.js";
import { i as v, b } from "../../../../../../modules/invoice-entry-a9ceb692.js";
const V = { class: "invoice-container" }, j = { __name: "invoice-info", setup(I) {
  const s = d("invoice_data"), { formData: e, projectInfo: h } = s, u = (l, t) => {
    /^[A-Za-z0-9-#_]*$/.test(l) ? e[t] = l : e[t] = e[t].replace(/[^A-Za-z0-9-#_]/g, "");
  };
  return (l, t) => {
    const r = _;
    return p(), m("div", V, [c(f, { column: 2, "form-data": o(e), "form-rules": o(v), "table-list": o(b) }, { invoiceAmount: i(({ item: a }) => [c(r, { modelValue: o(e)[a], "onUpdate:modelValue": (n) => o(e)[a] = n, modelModifiers: { number: true }, clearable: "", placeholder: "录入发票额", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), invoiceSerialNumber: i(({ item: a }) => [c(r, { modelValue: o(e)[a], "onUpdate:modelValue": (n) => o(e)[a] = n, clearable: "", placeholder: "录入发票编号", onInput: (n) => u(n, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  j as default
};
