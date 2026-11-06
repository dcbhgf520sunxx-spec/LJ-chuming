import { _ as b, kc as k, j0 as l } from "../../../../../shared/runtime.js";
import { ref as C } from "vue";
import { computed as p } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as u } from "vue";
import { createBlock as m } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as d } from "vue";
import { unref as s } from "vue";
import { resolveDynamicComponent as g } from "vue";
import { defineAsyncComponent as _ } from "vue";
import { ElRadioButton as P } from "element-plus";
import { ElRadioGroup as U } from "element-plus";
const A = { class: "head-container" }, B = { class: "print-container" }, O = { __name: "index", emits: ["closed"], setup(S, { emit: f }) {
  const { crud: t } = k(), y = f, o = C(), V = { payment: _(() => l(() => import("./payment.vue.js"), ["static/js/payment-ae0e0340.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/supplier-e2667d36.js", "static/js/upload-file-download-812f558c.js", "static/js/self-healing-6f411a5c.js", "static/css/payment-f4ca0245.css"])), invoice: _(() => l(() => import("./invoice.vue.js"), ["static/js/invoice-47b45059.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/upload-file-download-812f558c.js", "static/js/useTableTotal-3d22365a.js", "static/js/self-healing-6f411a5c.js", "static/js/supplier-e2667d36.js", "static/css/invoice-1ecf540d.css"])), settle: _(() => l(() => import("./settle.vue.js"), ["static/js/settle-2bd68139.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/supplier-e2667d36.js", "static/js/upload-file-download-812f558c.js", "static/js/self-healing-6f411a5c.js", "static/css/settle-eb9b49bc.css"])) }, x = p(() => V[o.value]);
  function D() {
    o.value = t.props.recordType;
  }
  function E() {
    y("closed");
  }
  const I = p(() => {
    switch (o.value) {
      case "settle":
        return "stairUnitSupplierSettleDetail";
      case "payment":
        return "stairUnitSupplierPaymentDetail";
      case "invoice":
        return "purchaseSupplierPurchaseInvoiceDetail";
    }
  });
  return (z, e) => {
    const r = P, w = U, R = c("print-table"), T = c("common-drawer");
    return u(), m(T, { modelValue: s(t).props.recordVisible, "onUpdate:modelValue": e[1] || (e[1] = (i) => s(t).props.recordVisible = i), size: "100%", title: "明细记录", onClosed: E, onOpen: D }, { content: a(() => [v("div", A, [n(w, { modelValue: o.value, "onUpdate:modelValue": e[0] || (e[0] = (i) => o.value = i), size: "default" }, { default: a(() => [n(r, { value: "settle" }, { default: a(() => e[2] || (e[2] = [d("结算明细")])), _: 1, __: [2] }), n(r, { value: "payment" }, { default: a(() => e[3] || (e[3] = [d("付款明细")])), _: 1, __: [3] }), n(r, { value: "invoice" }, { default: a(() => e[4] || (e[4] = [d("收票明细")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"]), v("div", B, [n(R, { "api-key": I.value, params: { id: s(t).props.rowDetail.id }, class: "animate__fadeIn", size: "default", type: "warning" }, null, 8, ["api-key", "params"])])]), (u(), m(g(x.value), { orderId: s(t).props.rowDetail.id, class: "animate__fadeIn" }, null, 8, ["orderId"]))]), _: 1 }, 8, ["modelValue"]);
  };
} }, G = b(O, [["__scopeId", "data-v-f3ca0cac"]]);
export {
  G as default
};
