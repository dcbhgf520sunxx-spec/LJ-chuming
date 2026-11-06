import { inject as p } from "vue";
import { ref as d } from "vue";
import { cloneDeep as f } from "lodash";
import { computed as F } from "vue";
import { watch as h } from "vue";
import { openBlock as m } from "vue";
import { createBlock as r } from "vue";
import { withCtx as y } from "vue";
import { unref as i } from "vue";
import { ElNotification as I } from "element-plus";
import { ElInput as g } from "element-plus";
import { e3 as k, i as v, bV as D, e5 as B } from "../../../../../../../shared/runtime.js";
import { a as E } from "../../../../../../../modules/subpackage-settle-bdb7b46f.js";
const C = { __name: "payment-info", setup(M) {
  const o = p("purchaseForm"), c = o.settlementAmount, _ = p("approveInfo"), e = d(f(_.value)), u = f(E), A = F(() => k(u, e.value)), s = d(0);
  h(e, (t) => {
    if (v(e.value)) {
      const { amount: n } = e.value;
      e.value.amount = D(n), s.value = e.value.dto.reduce((a, l) => a += l.invoiceAmount, 0), e.value.remainingAmount = (parseFloat(e.value.settlementAmount) - parseFloat(s.value)).toFixed(2);
    }
    if (t != null && t.isDisabled) {
      const n = u.findIndex((a) => a.key === "settlementAmount");
      n !== -1 && (u[n].verify = true);
    }
  }, { immediate: true });
  function b(t) {
    if (t || (e.value.remainingAmount = 0), parseFloat(t) > parseFloat(c)) return I({ title: `本次申请额度: ${c}`, message: "最终结算额不得大于本次申请额度", type: "warning" }), o.settlementAmount = 0;
    v(t) && (e.value.remainingAmount = (t - parseFloat(s.value)).toFixed(2));
  }
  return (t, n) => {
    const a = g;
    return m(), r(B, { column: 3, "form-data": i(o), "table-list": A.value }, { settlementAmount: y(({ item: l }) => [e.value.isDisabled ? (m(), r(a, { key: 1, modelValue: i(o)[l], "onUpdate:modelValue": (x) => i(o)[l] = x, modelModifiers: { number: true }, clearable: "", placeholder: "最终结算额", type: "number", onInput: b }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (m(), r(a, { key: 0, "model-value": e.value[l], disabled: "" }, null, 8, ["model-value"]))]), _: 1 }, 8, ["form-data", "table-list"]);
  };
} };
export {
  C as default
};
