import { inject as V } from "vue";
import { computed as u } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as s } from "vue";
import { withCtx as m } from "vue";
import { unref as t } from "vue";
import { Fragment as v } from "vue";
import { renderList as B } from "vue";
import { createBlock as x } from "vue";
import { ElOption as E } from "element-plus";
import { ElSelect as U } from "element-plus";
import { ElInput as g } from "element-plus";
import { e3 as j, dp as w, e5 as D } from "../../../../../../shared/runtime.js";
import { p as I, a as A } from "../../../../../../modules/data-33e35578.js";
const C = { class: "payment-info-container" }, L = { __name: "payment-info", setup(O) {
  const i = V("payment_data"), { formData: a, projectInfo: _, paymentTypelist: f } = i, b = u(() => j(A, _)), p = u(() => Object.entries(f.value).map(([o, n]) => ({ bankl: o, acount: n }))), y = (o) => {
    const n = p.value.find((r) => r.bankl === o);
    n && (a.paymentBankAccount = n.acount);
  };
  return (o, n) => {
    const r = E, k = U, h = g;
    return c(), d("div", C, [s(w, { "header-title": "付款信息" }), s(D, { column: 2, "form-data": t(a), "form-rules": t(I), "table-list": b.value }, { paymentBank: m(({ item: l }) => [s(k, { modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, "allow-create": "", clearable: "", filterable: "", placeholder: "请选择或输入银行", style: { width: "100%" }, onChange: y }, { default: m(() => [(c(true), d(v, null, B(p.value, (e, S) => (c(), x(r, { key: e.bankl, label: e.bankl, value: e.bankl }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), paymentBankAccount: m(({ item: l }) => [s(h, { modelValue: t(a)[l], "onUpdate:modelValue": (e) => t(a)[l] = e, clearable: "", placeholder: "请输入账号" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  L as default
};
