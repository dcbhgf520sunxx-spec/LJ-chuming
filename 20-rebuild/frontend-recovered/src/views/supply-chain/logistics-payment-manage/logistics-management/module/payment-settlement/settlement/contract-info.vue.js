import { inject as f } from "vue";
import { toRef as d } from "vue";
import { computed as _ } from "vue";
import { watch as p } from "vue";
import { nextTick as r } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as l } from "vue";
import { withCtx as w } from "vue";
import { unref as t } from "vue";
import { ElInput as x } from "element-plus";
import { s as V, b as v } from "../../../../../../../modules/data-2d709dfa.js";
import { e3 as A, e5 as k } from "../../../../../../../shared/runtime.js";
const D = { class: "contract-info-container" }, E = { __name: "contract-info", setup(I) {
  const o = f("settlement_data"), { formData: e, contractListInfo: a } = o, c = d(o, "headerRef"), m = _(() => A(v, a));
  return p(() => e.settlementAmount, (n) => {
    n ? r(() => {
      a.remainingAmount = parseFloat(n) - c.value.invoiceInfo.sum;
    }) : r(() => {
      a.remainingAmount = null;
    });
  }), (n, L) => {
    const i = x;
    return h(), b("div", D, [l(k, { column: 3, "form-data": t(e), "form-rules": t(V), "table-list": m.value, "item-width": "7vw" }, { settlementAmount: w(({ item: s }) => [l(i, { modelValue: t(e)[s], "onUpdate:modelValue": (u) => t(e)[s] = u, modelModifiers: { number: true }, clearable: "", placeholder: "请输入最终结算额", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  E as default
};
