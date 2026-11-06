import { _ as R, kc as T, j0 as l } from "../../../../../shared/runtime.js";
import { ref as k } from "vue";
import { computed as p } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as c } from "vue";
import { createBlock as m } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as d } from "vue";
import { unref as s } from "vue";
import { resolveDynamicComponent as C } from "vue";
import { defineAsyncComponent as _ } from "vue";
import { ElRadioButton as g } from "element-plus";
import { ElRadioGroup as U } from "element-plus";
const A = { class: "head-container" }, B = { class: "print-container" }, O = { __name: "index", emits: ["closed"], setup(S, { emit: f }) {
  const { crud: t } = T(), y = f, o = k(), V = { payment: _(() => l(() => import("./payment.vue.js"), ["static/js/payment-c21500cb.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/supplier-e2667d36.js", "static/js/file-download-82b299aa.js", "static/css/payment-9d2eb2fd.css"])), invoice: _(() => l(() => import("./invoice.vue.js"), ["static/js/invoice-cdcd77b0.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/supplier-e2667d36.js", "static/js/file-download-82b299aa.js", "static/css/invoice-f16f200d.css"])), settle: _(() => l(() => import("./settle.vue.js"), ["static/js/settle-f5407e9b.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/supplier-e2667d36.js", "static/js/file-download-82b299aa.js", "static/css/settle-7d5f93f7.css"])) }, D = p(() => V[o.value]), x = p(() => {
    switch (o.value) {
      case "settle":
        return "stairUnitSupplierPurchaseSettleDetail";
      case "payment":
        return "stairUnitSupplierPurchasePaymentDetail";
      case "invoice":
        return "purchaseSupplierPurchaseInvoiceDetail";
    }
  });
  function E() {
    o.value = t.props.recordType;
  }
  function I() {
    y("closed");
  }
  return (z, e) => {
    const r = g, b = U, P = u("print-table"), w = u("common-drawer");
    return c(), m(w, { modelValue: s(t).props.recordVisible, "onUpdate:modelValue": e[1] || (e[1] = (i) => s(t).props.recordVisible = i), size: "100%", title: "明细记录", onClosed: I, onOpen: E }, { content: a(() => [v("div", A, [n(b, { modelValue: o.value, "onUpdate:modelValue": e[0] || (e[0] = (i) => o.value = i), size: "default" }, { default: a(() => [n(r, { value: "settle" }, { default: a(() => e[2] || (e[2] = [d("结算明细")])), _: 1, __: [2] }), n(r, { value: "payment" }, { default: a(() => e[3] || (e[3] = [d("付款明细")])), _: 1, __: [3] }), n(r, { value: "invoice" }, { default: a(() => e[4] || (e[4] = [d("收票明细")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"]), v("div", B, [n(P, { "api-key": x.value, params: { id: s(t).props.rowDetail.id }, class: "animate__fadeIn", size: "default", type: "warning" }, null, 8, ["api-key", "params"])])]), (c(), m(C(D.value), { orderId: s(t).props.rowDetail.id, class: "animate__fadeIn" }, null, 8, ["orderId"]))]), _: 1 }, 8, ["modelValue"]);
  };
} }, h = R(O, [["__scopeId", "data-v-aa7b4ddc"]]);
export {
  h as default
};
