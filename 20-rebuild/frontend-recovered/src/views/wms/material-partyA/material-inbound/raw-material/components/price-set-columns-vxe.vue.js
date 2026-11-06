import { uZ as g, D as _ } from "../../../../../../shared/runtime.js";
import { resolveComponent as i } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as u } from "vue";
import { withCtx as c } from "vue";
import { createBlock as m } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as x } from "vue";
const b = { __name: "price-set-columns-vxe", props: { weightAttribute: { type: String, default: "weighingTotalWeight" } }, setup(r) {
  const d = r, { handleUnitPriceChange: p, handleAmountChange: h } = g(d.weightAttribute);
  return (V, C) => {
    const o = i("common-input-number"), l = i("vxe-column");
    return n(), f(x, null, [u(l, { field: "unitPrice", align: "center", width: "135px", title: "含税单价" }, { default: c(({ row: e }) => [e ? (n(), m(o, { key: 0, modelValue: e.unitPrice, "onUpdate:modelValue": (t) => e.unitPrice = t, min: 0, max: 9999999999, controls: false, style: { width: "100%" }, step: 1, size: "default", placeholder: "含税单价", onChange: (t) => a(p)(t, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : s("", true)]), _: 1 }), u(l, { field: "amount", align: "center", width: "135px", title: "金额" }, { default: c(({ row: e }) => [e ? (n(), m(o, { key: 0, modelValue: e.amount, "onUpdate:modelValue": (t) => e.amount = t, min: 0, max: 9999999999, controls: false, style: { width: "100%" }, step: 1, size: "default", precision: a(_).YUAN, placeholder: "金额", onChange: (t) => a(h)(t, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : s("", true)]), _: 1 })], 64);
  };
} };
export {
  b as default
};
