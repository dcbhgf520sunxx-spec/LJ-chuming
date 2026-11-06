import { provide as i } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as t } from "vue";
import { withCtx as a } from "vue";
import { unref as e } from "vue";
import { createBlock as s } from "vue";
import { createCommentVNode as m } from "vue";
import { ElCol as d } from "element-plus";
import { ElRow as _ } from "element-plus";
import { g1 as l, G as r, f_ as u } from "../../../../shared/runtime.js";
import f from "./component/amount-apply-config.vue.js";
import g from "./component/uncollected-unpaid-amount-calculation-method.vue.js";
import "../../../../modules/amount-apply-config-f0556377.js";
const x = { class: "app-container" }, B = { __name: "index", setup(C) {
  return i("permission", l), (h, k) => {
    const n = d, c = _;
    return o(), p("div", x, [t(c, { gutter: 20 }, { default: a(() => [t(n, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: a(() => [e(r)(e(l).get) ? (o(), s(e(f), { key: 0, style: { "margin-bottom": "20px" } })) : m("", true)]), _: 1 }), t(n, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: a(() => [e(r)(e(u).getUncollectedUnpaidAmountCalculationMethod) ? (o(), s(e(g), { key: 0, style: { "margin-bottom": "20px" } })) : m("", true)]), _: 1 })]), _: 1 })]);
  };
} };
export {
  B as default
};
