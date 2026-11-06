import { inject as r } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as n } from "vue";
import { withCtx as i } from "vue";
import { unref as e } from "vue";
import { ElInput as m } from "element-plus";
import { e5 as u } from "../../../../../../shared/runtime.js";
import { i as _, b as p } from "../../../../../../modules/invoice-entry-81d589e9.js";
const f = { class: "invoice-container" }, k = { __name: "invoice-info", setup(v) {
  const c = r("invoice_data"), { formData: a } = c;
  return (V, b) => {
    const t = m;
    return s(), d("div", f, [n(u, { column: 2, "table-list": e(_), "form-rules": e(p), "form-data": e(a) }, { invoiceAmount: i(({ item: o }) => [n(t, { modelValue: e(a)[o], "onUpdate:modelValue": (l) => e(a)[o] = l, clearable: "", placeholder: "录入发票额" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), invoiceSerialNumber: i(({ item: o }) => [n(t, { modelValue: e(a)[o], "onUpdate:modelValue": (l) => e(a)[o] = l, clearable: "", placeholder: "录入发票编号" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["table-list", "form-rules", "form-data"])]);
  };
} };
export {
  k as default
};
