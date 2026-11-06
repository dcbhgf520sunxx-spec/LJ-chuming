import { G as m } from "../../../../../modules/contract-9b18cc88.js";
import { _ as d, G as l } from "../../../../../shared/runtime.js";
import u from "./payment/index.vue.js";
import f from "./invoice/index.vue.js";
import { ref as v } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as o } from "vue";
import { withCtx as n } from "vue";
import { unref as e } from "vue";
import { createBlock as i } from "vue";
import { ElTabPane as _ } from "element-plus";
import { createCommentVNode as p } from "vue";
import { ElTabs as b } from "element-plus";
import "./payment/module/header.vue.js";
import "./invoice/module/header.vue.js";
const x = { class: "app-container" }, k = { __name: "index", setup(g) {
  const s = v("payment");
  return (P, c) => (t(), y("div", x, [o(e(b), { modelValue: s.value, "onUpdate:modelValue": c[0] || (c[0] = (a) => s.value = a), class: "tab-container" }, { default: n(() => {
    var a, r;
    return [e(l)((a = e(m).payment) == null ? void 0 : a.get) ? (t(), i(e(_), { key: 0, label: "付款列表", name: "payment" }, { default: n(() => [o(e(u), { class: "tab-content" })]), _: 1 })) : p("", true), e(l)((r = e(m).invoice) == null ? void 0 : r.get) ? (t(), i(e(_), { key: 1, label: "收票列表", name: "invoice" }, { default: n(() => [o(e(f), { class: "tab-content" })]), _: 1 })) : p("", true)];
  }), _: 1 }, 8, ["modelValue"])]));
} }, G = d(k, [["__scopeId", "data-v-92774693"]]);
export {
  G as default
};
