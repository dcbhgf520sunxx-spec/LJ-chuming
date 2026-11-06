import { inject as f } from "vue";
import { computed as _ } from "vue";
import { watch as d } from "vue";
import { nextTick as s } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as l } from "vue";
import { withCtx as b } from "vue";
import { unref as e } from "vue";
import { ElInput as x } from "element-plus";
import { s as V, b as A } from "../../../../../../../modules/data-50c44b01.js";
import { e3 as k, e5 as w } from "../../../../../../../shared/runtime.js";
const D = { class: "contract-info-container" }, E = { __name: "contract-info", setup(I) {
  const r = f("settlement_data"), { formData: t, contractListInfo: a, headerRef: c } = r, m = _(() => k(A, a));
  return d(() => t.settlementAmount, (n) => {
    n ? s(() => {
      a.remainingAmount = parseFloat(n) - c.invoiceInfo.sum;
    }) : s(() => {
      a.remainingAmount = null;
    });
  }), (n, L) => {
    const i = x;
    return p(), h("div", D, [l(w, { "form-data": e(t), column: 3, "table-list": m.value, "form-rules": e(V) }, { settlementAmount: b(({ item: o }) => [l(i, { modelValue: e(t)[o], "onUpdate:modelValue": (u) => e(t)[o] = u, clearable: "", placeholder: "请输入最终结算额" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }, 8, ["form-data", "table-list", "form-rules"])]);
  };
} };
export {
  E as default
};
