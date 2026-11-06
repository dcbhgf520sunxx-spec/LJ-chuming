import { resolveComponent as g } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as u } from "vue";
import { createSlots as V } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as C } from "vue";
import { createTextVNode as _ } from "vue";
import { createBlock as d } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as m } from "vue";
import { Fragment as b } from "vue";
import { ElTableColumn as x } from "element-plus";
import { uZ as k, D as y } from "../../../../../../../shared/runtime.js";
const N = { __name: "price-set-columns", props: { weightAttribute: { type: String, default: "weighingTotalWeight" }, isRequiredIdentifier: { type: Boolean, default: false } }, setup(i) {
  const c = i, { handleUnitPriceChange: p, handleAmountChange: f } = k(c.weightAttribute);
  return (P, n) => {
    const r = g("common-input-number"), s = x;
    return a(), h(b, null, [u(s, { align: "center", label: "含税单价", prop: "unitPrice", width: "135px" }, V({ default: o(({ row: e }) => [e ? (a(), d(r, { key: 0, modelValue: e.unitPrice, "onUpdate:modelValue": (t) => e.unitPrice = t, controls: false, max: 9999999999, min: 0, step: 1, placeholder: "含税单价", size: "default", onChange: (t) => l(p)(t, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : m("", true)]), _: 2 }, [i.isRequiredIdentifier ? { name: "header", fn: o(() => [n[0] || (n[0] = C("span", { style: { color: "red" } }, "*", -1)), n[1] || (n[1] = _("含税单价 "))]), key: "0" } : void 0]), 1024), u(s, { align: "center", label: "含税金额", prop: "amount", width: "135px" }, { default: o(({ row: e }) => [e ? (a(), d(r, { key: 0, modelValue: e.amount, "onUpdate:modelValue": (t) => e.amount = t, controls: false, max: 9999999999, min: 0, precision: l(y).YUAN, step: 1, placeholder: "含税金额", size: "default", onChange: (t) => l(f)(t, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : m("", true)]), _: 1 })], 64);
  };
} };
export {
  N as default
};
