import { ref as h } from "vue";
import { inject as i } from "vue";
import { watchEffect as B } from "vue";
import { computed as D } from "vue";
import { watch as E } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as f } from "vue";
import { createSlots as I } from "vue";
import { unref as c } from "vue";
import { withCtx as y } from "vue";
import { Fragment as S } from "vue";
import { renderList as g } from "vue";
import { createBlock as V } from "vue";
import { ElOption as w } from "element-plus";
import { ElSelect as x } from "element-plus";
import { ElInput as F } from "element-plus";
import { g as C } from "../../../../../../../modules/payment-settlement-a7865af1.js";
import { e3 as U, e5 as R } from "../../../../../../../shared/runtime.js";
import { b as j, c as O } from "../../../../../../../modules/pc-pasychia-data-6ecf5a97.js";
const P = { class: "payment-info-container" }, G = { __name: "payment-info", setup(L) {
  const _ = h([]), { purchaseInfo: n } = i("purchaseInfo"), e = i("purchaseForm"), k = i("tableItemData", {});
  B(() => {
    n && n.supplierAuditSelfEmployedDto && (_.value = U(j, n.supplierAuditSelfEmployedDto));
  });
  const u = h([]), m = D(() => {
    var l, a;
    return ((a = (l = n.supplierAuditSelfEmployedDto) == null ? void 0 : l.list) == null ? void 0 : a.map((o) => o.orderId)) || [];
  });
  E(() => m.value, () => {
    v();
  }, { immediate: true });
  async function v() {
    var l, a, o, p;
    if (m.value.length) try {
      const { paymentDto: s } = await C({ orderIds: m.value });
      u.value = Object.entries(s).map(([r, t]) => ({ bank: r, account: t })), e.paymentBank = (l = n.supplierAuditSelfEmployedDto) != null && l.paymentBank ? (a = n.supplierAuditSelfEmployedDto) == null ? void 0 : a.paymentBank : null, e.paymentBankAccount = (o = n.supplierAuditSelfEmployedDto) != null && o.paymentBankAccount ? (p = n.supplierAuditSelfEmployedDto) == null ? void 0 : p.paymentBankAccount : null;
    } catch (s) {
      console.log(s);
    }
  }
  const A = (l) => {
    const a = u.value.find((o) => o.bank === l);
    a ? e.paymentBankAccount = a.account : e.paymentBankAccount = null;
  };
  return (l, a) => {
    const o = w, p = x, s = F;
    return d(), b("div", P, [f(R, { column: 2, "form-data": c(e), "table-list": _.value, formRules: c(O) }, I({ _: 2 }, [c(k).approvalFlag ? { name: "paymentBank", fn: y(({ item: r }) => [f(p, { modelValue: c(e)[r], "onUpdate:modelValue": (t) => c(e)[r] = t, "allow-create": "", clearable: "", filterable: "", placeholder: "请选择或输入银行", onChange: A }, { default: y(() => [(d(true), b(S, null, g(u.value, (t) => (d(), V(o, { key: t.bank, label: t.bank, value: t.bank }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), key: "0" } : void 0, c(k).approvalFlag ? { name: "paymentBankAccount", fn: y(({ item: r }) => [f(s, { modelValue: c(e)[r], "onUpdate:modelValue": (t) => c(e)[r] = t, clearable: "", placeholder: "请输入账号" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), key: "1" } : void 0]), 1032, ["form-data", "table-list", "formRules"])]);
  };
} };
export {
  G as default
};
