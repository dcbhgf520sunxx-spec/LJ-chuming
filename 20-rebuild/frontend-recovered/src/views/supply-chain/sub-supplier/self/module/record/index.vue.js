import { _ as j, u as B, z as U, j0 as l } from "../../../../../../shared/runtime.js";
import { ref as p } from "vue";
import { inject as m } from "vue";
import { watch as z } from "vue";
import { computed as c } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as f } from "vue";
import { createBlock as y } from "vue";
import { withCtx as t } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as N } from "vue";
import { unref as n } from "vue";
import { createElementVNode as _ } from "vue";
import { resolveDynamicComponent as O } from "vue";
import { defineAsyncComponent as i } from "vue";
import { ElTag as F } from "element-plus";
import { ElRadioButton as G } from "element-plus";
import { ElRadioGroup as q } from "element-plus";
const H = { class: "header-container" }, J = { __name: "index", props: { modelValue: { type: Boolean, default: false } }, emits: ["update:modelValue"], setup(b, { emit: V }) {
  const g = b, D = V, E = p(null), { visible: S, handleClose: w } = B({ emit: D, props: g }), { table_item_data: u } = m("common"), o = p("payment"), { current_key: x } = m("common");
  z(() => x.value, (d) => {
    o.value = d;
  }, { immediate: true });
  const k = { settle: i(() => l(() => import("./settle.vue.js"), ["static/js/settle-9536ab06.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-dfff0f60.js", "static/js/file-download-82b299aa.js"])), preSettle: i(() => l(() => import("./pre-settle.vue.js"), ["static/js/pre-settle-f81fa2c9.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-dfff0f60.js", "static/js/file-download-82b299aa.js"])), payment: i(() => l(() => import("./payment.vue.js"), ["static/js/payment-2e0b90f1.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-dfff0f60.js", "static/js/file-download-82b299aa.js"])), invoice: i(() => l(() => import("./invoice.vue.js"), ["static/js/invoice-f7c90f0a.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-dfff0f60.js", "static/js/file-download-82b299aa.js"])) }, I = c(() => k[o.value]), L = c(() => {
    switch (o.value) {
      case "settle":
        return "stairUnitSupplierLedgerSettleDetail";
      case "preSettle":
        return "stairUnitSupplierLedgerPreSettleDetail";
      case "payment":
        return "stairUnitSupplierLedgerPaymentDetail";
      case "invoice":
        return "purchaseSupplierLedgerInvoiceDetail";
    }
  });
  return (d, e) => {
    const P = F, s = G, R = q, T = v("print-table"), A = v("common-drawer");
    return f(), y(A, { ref_key: "drawer_ref", ref: E, "append-to-body": true, "before-close": n(w), visible: n(S), "custom-class": "detail-record", size: "100%", title: "明细记录" }, { titleAfter: t(() => [a(P, null, { default: t(() => [r(N(n(U)(n(u).project)), 1)]), _: 1 })]), content: t(() => [_("div", H, [_("div", null, [a(R, { modelValue: o.value, "onUpdate:modelValue": e[0] || (e[0] = (C) => o.value = C), class: "box-container", size: "default" }, { default: t(() => [a(s, { value: "settle" }, { default: t(() => e[1] || (e[1] = [r("结算明细")])), _: 1, __: [1] }), a(s, { value: "preSettle" }, { default: t(() => e[2] || (e[2] = [r("预结算明细")])), _: 1, __: [2] }), a(s, { value: "payment" }, { default: t(() => e[3] || (e[3] = [r("付款明细")])), _: 1, __: [3] }), a(s, { value: "invoice" }, { default: t(() => e[4] || (e[4] = [r("开票明细")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"])]), _("div", null, [a(T, { "api-key": L.value, params: { id: n(u).id, isPre: o.value === "preSettle", isSub: o.value !== "preSettle" }, class: "animate__fadeIn", size: "default", type: "warning" }, null, 8, ["api-key", "params"])])]), (f(), y(O(I.value), { class: "animate__fadeIn" }))]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, W = j(J, [["__scopeId", "data-v-9ee56f52"]]);
export {
  W as default
};
