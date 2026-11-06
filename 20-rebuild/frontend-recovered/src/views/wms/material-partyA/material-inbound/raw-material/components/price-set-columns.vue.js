import { resolveComponent as h } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as u } from "vue";
import { withCtx as m } from "vue";
import { createBlock as c } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as i } from "vue";
import { Fragment as _ } from "vue";
import { ElTableColumn as f } from "element-plus";
import { uZ as C, D as V } from "../../../../../../shared/runtime.js";
const k = { __name: "price-set-columns", props: { weightAttribute: { type: String, default: "weighingTotalWeight" } }, setup(r) {
  const s = r, { handleUnitPriceChange: p, handleAmountChange: d } = C(s.weightAttribute);
  return (b, x) => {
    const o = h("common-input-number"), l = f;
    return n(), g(_, null, [u(l, { prop: "unitPrice", align: "center", width: "135px", label: "含税单价" }, { default: m(({ row: e }) => [e ? (n(), c(o, { key: 0, modelValue: e.unitPrice, "onUpdate:modelValue": (t) => e.unitPrice = t, min: 0, max: 9999999999, controls: false, step: 1, size: "default", placeholder: "含税单价", onChange: (t) => a(p)(t, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : i("", true)]), _: 1 }), u(l, { prop: "amount", align: "center", width: "135px", label: "金额" }, { default: m(({ row: e }) => [e ? (n(), c(o, { key: 0, modelValue: e.amount, "onUpdate:modelValue": (t) => e.amount = t, min: 0, max: 9999999999, controls: false, step: 1, size: "default", precision: a(V).YUAN, placeholder: "金额", onChange: (t) => a(d)(t, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : i("", true)]), _: 1 })], 64);
  };
} };
export {
  k as default
};
