import { _ as I, G as c, a as u, dp as x, j0 as _ } from "../../../../../shared/runtime.js";
import { ref as d } from "vue";
import { computed as A } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as s } from "vue";
import { withCtx as r } from "vue";
import { unref as t } from "vue";
import { createBlock as a } from "vue";
import { createTextVNode as p } from "vue";
import { createCommentVNode as m } from "vue";
import { resolveDynamicComponent as T } from "vue";
import { Fragment as j } from "vue";
import { defineAsyncComponent as v } from "vue";
import { ElButton as B } from "element-plus";
import { X as f } from "../../../../../modules/contract-9b18cc88.js";
const L = { class: "header-container" }, N = { class: "btn-container" }, O = { __name: "project-info", setup($) {
  const b = d(""), E = d(null), y = d(false), V = { collection: v(() => _(() => import("./establish/collection.vue.js"), ["static/js/collection-2323a70a.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/data-039b7fd9.js", "static/css/collection-c3df868a.css"])), billing: v(() => _(() => import("./establish/billing.vue.js"), ["static/js/billing-0b1f71e8.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/data-039b7fd9.js", "static/css/billing-b18adea3.css"])), capital: v(() => _(() => import("./establish/capital.vue.js"), ["static/js/capital-f73aa175.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/data-039b7fd9.js", "static/js/capital-de0d42db.js", "static/css/capital-4cc03fd9.css"])), settle: v(() => _(() => import("./establish/settle.vue.js"), ["static/js/settle-fff1f8ea.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/self-healing-6f411a5c.js", "static/css/settle-c79ee090.css"])) }, D = A(() => V[b.value]), i = async (g) => {
    b.value = g, y.value = true, P();
  }, k = d();
  function P() {
    k.value = Math.random();
  }
  return (g, e) => {
    const l = B;
    return n(), R(j, null, [C("div", L, [s(x, { "header-title": "" }, { headerLeft: r(() => [C("div", N, [t(c)(t(f).payment) ? (n(), a(l, { key: 0, style: { background: "#09945a", border: "none" }, type: "success", onClick: e[0] || (e[0] = (o) => i("collection")) }, { default: r(() => [s(u, { class: "icon", "icon-class": "contract-collection" }), e[5] || (e[5] = p(" 创建收款 "))]), _: 1 })) : m("", true), t(c)(t(f).billing) ? (n(), a(l, { key: 1, type: "warning", onClick: e[1] || (e[1] = (o) => i("billing")) }, { default: r(() => [s(u, { class: "icon", "icon-class": "contract-invoice" }), e[6] || (e[6] = p(" 创建开票 "))]), _: 1 })) : m("", true), t(c)(t(f).register) ? (n(), a(l, { key: 2, type: "primary", onClick: e[2] || (e[2] = (o) => i("capital")) }, { default: r(() => [s(u, { class: "icon", "icon-class": "contract-register" }), e[7] || (e[7] = p(" 创建注资 "))]), _: 1 })) : m("", true), t(c)(t(f).settle) ? (n(), a(l, { key: 3, size: "default", type: "success", onClick: e[3] || (e[3] = (o) => i("settle")) }, { default: r(() => [s(u, { class: "icon", "icon-class": "contract-settle" }), e[8] || (e[8] = p(" 项目结算 "))]), _: 1 })) : m("", true)])]), _: 1 })]), (n(), a(T(D.value), { key: k.value, ref_key: "currentComRef", ref: E, visible: y.value, "onUpdate:visible": e[4] || (e[4] = (o) => y.value = o) }, null, 40, ["visible"]))], 64);
  };
} }, F = I(O, [["__scopeId", "data-v-d4855b18"]]);
export {
  F as default
};
