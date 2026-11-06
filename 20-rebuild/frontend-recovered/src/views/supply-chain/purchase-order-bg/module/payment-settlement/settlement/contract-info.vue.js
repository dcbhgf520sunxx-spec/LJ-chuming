import { inject as d } from "vue";
import { toRef as _ } from "vue";
import { computed as p } from "vue";
import { watch as h } from "vue";
import { nextTick as r } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as l } from "vue";
import { withCtx as w } from "vue";
import { unref as t } from "vue";
import { ElInput as V } from "element-plus";
import { e as v, f as A } from "../../../../../../modules/data-499610b6.js";
import { e3 as B, e5 as k } from "../../../../../../shared/runtime.js";
const D = { class: "contract-info-container" }, F = { __name: "contract-info", setup(I) {
  const n = d("settlement_data"), { formData: e, contractListInfo: a } = n, c = _(n, "headerRef"), m = p(() => B(A, a));
  return h(() => e.settlementAmount, (o) => {
    o ? r(() => {
      a.remainingAmount = (parseFloat(o) - c.value.invoiceInfo.sum).toFixed(2);
    }) : r(() => {
      a.remainingAmount = null;
    });
  }), (o, L) => {
    const i = V;
    return b(), x("div", D, [l(k, { column: 3, "form-data": t(e), "form-rules": t(v), "table-list": m.value, "item-width": "10vw" }, { settlementAmount: w(({ item: s, blur: u }) => [l(i, { modelValue: t(e)[s], "onUpdate:modelValue": (f) => t(e)[s] = f, modelModifiers: { number: true }, clearable: "", placeholder: "请输入最终结算额", type: "number", onBlur: u }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  F as default
};
