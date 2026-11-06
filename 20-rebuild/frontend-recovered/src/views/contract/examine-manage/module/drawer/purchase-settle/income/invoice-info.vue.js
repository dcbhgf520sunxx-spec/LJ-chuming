import { inject as i } from "vue";
import f from "lodash";
import { ref as x } from "vue";
import { computed as m } from "vue";
import { watchEffect as F } from "vue";
import { watch as I } from "vue";
import { openBlock as r } from "vue";
import { createBlock as c } from "vue";
import { withCtx as g } from "vue";
import { unref as u } from "vue";
import { ElNotification as k } from "element-plus";
import { ElInput as y } from "element-plus";
import { i as v, bV as E, e3 as B, e5 as L } from "../../../../../../../shared/runtime.js";
import { i as S } from "../../../../../../../modules/pc-pasychia-data-6ecf5a97.js";
const M = { __name: "invoice-info", setup(N) {
  const l = i("purchaseForm"), _ = i("approveInfo"), A = i("tableItemData"), s = f.cloneDeep(S), t = x(f.cloneDeep(_.value)), p = m(() => {
    var e;
    return (e = t.value) == null ? void 0 : e.settlementAmount;
  }), d = m(() => {
    var e, n;
    return (n = (e = t.value) == null ? void 0 : e.supplierSettlementEchoDtoList) != null && n.length ? t.value.supplierSettlementEchoDtoList.reduce((a, o) => a += o == null ? void 0 : o.invoiceAmount, 0) : 0;
  });
  F(() => {
    var e;
    (e = t.value) != null && e.settlementAmount && (t.value.remainingAmount = (parseFloat(t.value.settlementAmount) - parseFloat(d.value)).toFixed(2));
  }), I(t, (e) => {
    var n;
    if (v(e)) {
      const { amount: a } = t.value;
      t.value.contractAmount = E(a);
    }
    if (e != null && e.isDisabled) {
      (n = t.value) != null && n.settlementAmount && (l.settlementAmount = t.value.settlementAmount);
      const a = s.findIndex((o) => o.key === "settlementAmount");
      a !== -1 && (s[a].verify = true);
    }
  }, { immediate: true });
  const h = m(() => B(s, t.value));
  function b(e) {
    if (e || (t.value.remainingAmount = 0), parseFloat(e) > parseFloat(p.value)) return k({ title: `本次申请额度: ${p.value}`, message: "最终结算额不得大于本次申请额度", type: "warning" }), l.settlementAmount = 0;
    v(e) && (t.value.remainingAmount = (e - parseFloat(d.value)).toFixed(2));
  }
  return (e, n) => {
    const a = y;
    return r(), c(L, { column: 3, "form-data": u(l), "table-list": h.value }, { settlementAmount: g(({ item: o }) => [!t.value.isDisabled || u(A).auditStatusEnum === 2 ? (r(), c(a, { key: 0, "model-value": t.value[o], disabled: "" }, null, 8, ["model-value"])) : (r(), c(a, { key: 1, modelValue: u(l)[o], "onUpdate:modelValue": (D) => u(l)[o] = D, modelModifiers: { number: true }, clearable: "", placeholder: "最终结算额", type: "number", onInput: b }, null, 8, ["modelValue", "onUpdate:modelValue"]))]), _: 1 }, 8, ["form-data", "table-list"]);
  };
} };
export {
  M as default
};
