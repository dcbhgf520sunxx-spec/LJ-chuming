import { inject as d } from "vue";
import { cloneDeep as b } from "lodash";
import { computed as k } from "vue";
import { watchEffect as D } from "vue";
import { ref as x } from "vue";
import { watch as j } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as f } from "vue";
import { createSlots as w } from "vue";
import { unref as o } from "vue";
import { withCtx as _ } from "vue";
import { Fragment as C } from "vue";
import { renderList as E } from "vue";
import { createBlock as F } from "vue";
import { ElOption as S } from "element-plus";
import { ElSelect as U } from "element-plus";
import { ElInput as T } from "element-plus";
import { g as P } from "../../../../../../../modules/index-dfff0f60.js";
import { s as R } from "../../../../../../../modules/sp-pasychia-data-d374d1e9.js";
import { _ as N, e3 as O, i as z, bV as r, ia as Q, e5 as $ } from "../../../../../../../shared/runtime.js";
import { c as q } from "../../../../../../../modules/pc-pasychia-data-6ecf5a97.js";
const G = { class: "second-table-container" }, H = { __name: "second-table", setup(J) {
  const { purchaseInfo: { supplierAuditSelfEmployedDto: v } } = d("purchaseInfo"), t = d("purchaseForm"), y = d("tableItemData"), e = b(v), A = b(R), B = k(() => O(A, e));
  D(() => {
    if (z(e)) {
      const { paymentAmount: a, projectCollectionAmount: n, projectDisburseAmount: l, totalPaymentAmount: p } = e;
      e.paymentAmount = r(a), e.projectCollectionAmount = r(n), e.projectDisburseAmount = r(l), e.totalPaymentAmount = r(p), e.capital = Q(a);
    }
  });
  const u = x([]), m = k(() => {
    var a;
    return ((a = e == null ? void 0 : e.list) == null ? void 0 : a.map((n) => n.orderId)) || [];
  });
  j(() => m.value, () => {
    I();
  }, { immediate: true });
  async function I() {
    if (m.value.length) try {
      const { paymentDto: a } = await P({ orderIds: m.value });
      u.value = Object.entries(a).map(([n, l]) => ({ bank: n, account: l })), t.paymentBank = e != null && e.paymentBank ? e == null ? void 0 : e.paymentBank : null, t.paymentBankAccount = e != null && e.paymentBankAccount ? e == null ? void 0 : e.paymentBankAccount : null;
    } catch (a) {
      console.log(a);
    }
  }
  const g = (a) => {
    const n = u.value.find((l) => l.bank === a);
    n ? t.paymentBankAccount = n.account : t.paymentBankAccount = null;
  };
  return (a, n) => {
    const l = S, p = U, V = T;
    return i(), h("div", G, [f($, { column: 2, "form-data": o(t), "table-list": B.value, size: "default", formRules: o(q) }, w({ _: 2 }, [o(y).approvalFlag ? { name: "paymentBank", fn: _(({ item: s }) => [f(p, { modelValue: o(t)[s], "onUpdate:modelValue": (c) => o(t)[s] = c, "allow-create": "", clearable: "", filterable: "", placeholder: "请选择或输入银行", onChange: g }, { default: _(() => [(i(true), h(C, null, E(u.value, (c) => (i(), F(l, { key: c.bank, label: c.bank, value: c.bank }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), key: "0" } : void 0, o(y).approvalFlag ? { name: "paymentBankAccount", fn: _(({ item: s }) => [f(V, { modelValue: o(t)[s], "onUpdate:modelValue": (c) => o(t)[s] = c, clearable: "", placeholder: "请输入账号" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), key: "1" } : void 0]), 1032, ["form-data", "table-list", "formRules"])]);
  };
} }, Y = N(H, [["__scopeId", "data-v-6e66ff66"]]);
export {
  Y as default
};
