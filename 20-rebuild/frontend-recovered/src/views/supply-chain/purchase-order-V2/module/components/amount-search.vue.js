import { D as m, i as o, b as i, f3 as y } from "../../../../../shared/runtime.js";
import { resolveComponent as A } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as q } from "vue";
import { createVNode as c } from "vue";
import { unref as l } from "vue";
import { createElementVNode as f } from "vue";
const x = { style: { border: "1px solid #dcdfe6", "border-radius": "4px", height: "32px" } }, g = { __name: "amount-search", props: { visible: { type: Boolean, default: false }, query: { type: Object, default: () => {
} } }, emits: ["change"], setup(u, { emit: p }) {
  const h = p, e = u;
  function t() {
    const r = o(e.query.purchaseAmount) ? JSON.parse(JSON.stringify(e.query.purchaseAmount)) : [];
    o(e.query.purchaseMinAmount) || o(e.query.purchaseMaxAmount) ? o(e.query.purchaseMinAmount) && o(e.query.purchaseMaxAmount) ? e.query.purchaseAmount = [e.query.purchaseMinAmount, e.query.purchaseMaxAmount] : o(e.query.purchaseMinAmount) ? e.query.purchaseAmount = [e.query.purchaseMinAmount, 999999999999] : e.query.purchaseAmount = [0, e.query.purchaseMaxAmount] : e.query.purchaseAmount = [], !(i(e.query.purchaseAmount) && i(r)) && !y(r, e.query.purchaseAmount) && h("change");
  }
  return (r, n) => {
    const s = A("common-input-number");
    return d(), q("div", x, [c(s, { modelValue: u.query.purchaseMinAmount, "onUpdate:modelValue": n[0] || (n[0] = (a) => u.query.purchaseMinAmount = a), controls: false, max: u.query.purchaseMaxAmount ? u.query.purchaseMaxAmount : 999999999999, min: 0, precision: l(m).YUAN, step: 1, autocomplete: "off", class: "input-border-none", placeholder: "合同额最小值", style: { width: "120px" }, onChange: t }, null, 8, ["modelValue", "max", "precision"]), n[2] || (n[2] = f("span", null, "-", -1)), c(s, { modelValue: u.query.purchaseMaxAmount, "onUpdate:modelValue": n[1] || (n[1] = (a) => u.query.purchaseMaxAmount = a), controls: false, max: 999999999999, min: u.query.purchaseMinAmount ? u.query.purchaseMinAmount : 0, precision: l(m).YUAN, step: 1, class: "input-border-none", autocomplete: "off", placeholder: "合同额最大值", style: { width: "120px" }, onChange: t }, null, 8, ["modelValue", "min", "precision"])]);
  };
} };
export {
  g as default
};
