import { inject as r } from "vue";
import d from "lodash";
import { ref as h } from "vue";
import { watch as V } from "vue";
import { computed as v } from "vue";
import { openBlock as b } from "vue";
import { createBlock as A } from "vue";
import { withCtx as c } from "vue";
import { createVNode as i } from "vue";
import { unref as t } from "vue";
import { ElInput as w } from "element-plus";
import { i as u, bV as x, e3 as D, e5 as U } from "../../../../../../../shared/runtime.js";
import { d as k } from "../../../../../../../modules/pc-pasychia-data-6ecf5a97.js";
const F = { __name: "invoice-info", setup(B) {
  const e = r("purchaseForm"), p = r("approveInfo"), f = d.cloneDeep(k), n = h(d.cloneDeep(p.value));
  V(n, (m) => {
    if (u(m)) {
      const { inboundAmountSum: l, settlementAmount: o } = n.value;
      u(l) && (e.inboundAmountSum = x(l)), u(o) && (e.settlementAmount = o);
    }
  }, { immediate: true });
  const _ = v(() => D(f, n.value));
  return (m, l) => {
    const o = w;
    return b(), A(U, { column: 2, "form-data": t(e), "table-list": _.value, "item-width": "7vw" }, { inboundAmountSum: c(({ item: a }) => [i(o, { modelValue: t(e)[a], "onUpdate:modelValue": (s) => t(e)[a] = s, readonly: "", placeholder: "累计入库额" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), settlementAmount: c(({ item: a }) => [i(o, { modelValue: t(e)[a], "onUpdate:modelValue": (s) => t(e)[a] = s, readonly: "", placeholder: "最终结算额" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["form-data", "table-list"]);
  };
} };
export {
  F as default
};
