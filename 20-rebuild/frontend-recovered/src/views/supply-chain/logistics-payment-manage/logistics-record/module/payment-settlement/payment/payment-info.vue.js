import { inject as p } from "vue";
import { computed as u } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { unref as a } from "vue";
import { ElInput as _ } from "element-plus";
import { e3 as f, e5 as V } from "../../../../../../../shared/runtime.js";
import { p as y, a as b } from "../../../../../../../modules/data-33e35578.js";
const h = { class: "payment-info-container" }, v = { __name: "payment-info", setup(k) {
  const r = p("payment_data"), { formData: e, projectInfo: m } = r, c = u(() => f(b, m));
  return (x, B) => {
    const l = _;
    return d(), i("div", h, [n(V, { column: 2, "table-list": c.value, "form-rules": a(y), "form-data": a(e) }, { paymentBank: s(({ item: t }) => [n(l, { placeholder: "请输入银行", clearable: "", modelValue: a(e)[t], "onUpdate:modelValue": (o) => a(e)[t] = o }, null, 8, ["modelValue", "onUpdate:modelValue"])]), paymentBankAccount: s(({ item: t }) => [n(l, { placeholder: "请输入账号", clearable: "", modelValue: a(e)[t], "onUpdate:modelValue": (o) => a(e)[t] = o }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["table-list", "form-rules", "form-data"])]);
  };
} };
export {
  v as default
};
