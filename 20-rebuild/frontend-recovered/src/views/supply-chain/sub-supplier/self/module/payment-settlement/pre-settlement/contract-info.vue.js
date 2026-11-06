import { inject as _ } from "vue";
import { toRef as d } from "vue";
import { computed as p } from "vue";
import { watch as h } from "vue";
import { nextTick as l } from "vue";
import { openBlock as A } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as r } from "vue";
import { withCtx as w } from "vue";
import { unref as n } from "vue";
import { ElInput as x } from "element-plus";
import { b as I, c as v } from "../../../../../../../modules/data-e72242cc.js";
import { e3 as V, e5 as g, iK as k } from "../../../../../../../shared/runtime.js";
const D = { class: "contract-info-container" }, F = { __name: "contract-info", setup(L) {
  const o = _("settlement_data"), { formData: t, contractListInfo: a } = o, c = d(o, "headerRef"), m = p(() => V(v, a));
  h(() => t.settlementAmount, (e) => {
    e ? l(() => {
      a.remainingAmount = (parseFloat(e) - c.value.invoiceInfo.sum).toFixed(2);
    }) : l(() => {
      a.remainingAmount = null;
    });
  });
  const u = () => {
    const e = t.settlementAmount;
    t.settlementAmount = k(e, { allowNegative: true });
  };
  return (e, N) => {
    const i = x;
    return A(), b("div", D, [r(g, { column: 3, "form-data": n(t), "form-rules": n(I), "table-list": m.value, "item-width": "7vw" }, { settlementAmount: w(({ item: s }) => [r(i, { modelValue: n(t)[s], "onUpdate:modelValue": (f) => n(t)[s] = f, clearable: "", placeholder: "请输入预结算额", onInput: u }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  F as default
};
