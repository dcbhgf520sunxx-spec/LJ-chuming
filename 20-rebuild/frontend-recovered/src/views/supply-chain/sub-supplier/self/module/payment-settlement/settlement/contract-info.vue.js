import { inject as d } from "vue";
import { toRef as _ } from "vue";
import { computed as p } from "vue";
import { watch as h } from "vue";
import { nextTick as l } from "vue";
import { openBlock as A } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as m } from "vue";
import { withCtx as x } from "vue";
import { unref as a } from "vue";
import { ElInput as I } from "element-plus";
import { e as b, f as v } from "../../../../../../../modules/data-e72242cc.js";
import { e3 as V, e5 as g, iK as k } from "../../../../../../../shared/runtime.js";
const D = { class: "contract-info-container" }, F = { __name: "contract-info", setup(L) {
  const o = d("settlement_data"), { formData: t, contractListInfo: n } = o, r = _(o, "headerRef"), c = p(() => V(v, n));
  h(() => t.settlementAmount, (e) => {
    e ? l(() => {
      n.remainingAmount = (parseFloat(e) - r.value.invoiceInfo.sum).toFixed(2);
    }) : l(() => {
      n.remainingAmount = null;
    });
  });
  const u = () => {
    const e = t.settlementAmount;
    t.settlementAmount = k(e, { allowNegative: false });
  };
  return (e, N) => {
    const i = I;
    return A(), w("div", D, [m(g, { column: 3, "form-data": a(t), "form-rules": a(b), "table-list": c.value, "item-width": "7vw" }, { settlementAmount: x(({ item: s }) => [m(i, { modelValue: a(t)[s], "onUpdate:modelValue": (f) => a(t)[s] = f, clearable: "", placeholder: "请输入最终结算额", onInput: u }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  F as default
};
