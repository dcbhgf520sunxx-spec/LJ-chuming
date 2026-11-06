import c from "./collection/index.vue.js";
import i from "./invoice/index.vue.js";
import { _ as r } from "../../../shared/runtime.js";
import { ref as _ } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as e } from "vue";
import { withCtx as a } from "vue";
import { unref as t } from "vue";
import { ElTabPane as l } from "element-plus";
import { ElTabs as d } from "element-plus";
import "../../../modules/collection-9275714a.js";
import "../../../modules/contract-9b18cc88.js";
import "./collection/module/header.vue.js";
import "../../../modules/invoice-2cd386aa.js";
import "./invoice/module/header.vue.js";
const u = { class: "app-container" }, f = { __name: "index", setup(v) {
  const o = _("collection");
  return (b, n) => (m(), p("div", u, [e(t(d), { modelValue: o.value, "onUpdate:modelValue": n[0] || (n[0] = (s) => o.value = s), class: "tab-container" }, { default: a(() => [e(t(l), { label: "收款列表", name: "collection" }, { default: a(() => [e(t(c), { class: "tab-content" })]), _: 1 }), e(t(l), { label: "开票列表", name: "invoice" }, { default: a(() => [e(t(i), { class: "tab-content" })]), _: 1 })]), _: 1 }, 8, ["modelValue"])]));
} }, T = r(f, [["__scopeId", "data-v-47833e28"]]);
export {
  T as default
};
