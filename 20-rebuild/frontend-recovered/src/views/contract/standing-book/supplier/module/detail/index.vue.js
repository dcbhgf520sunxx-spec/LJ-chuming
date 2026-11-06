import { _ as U, kc as B, dp as R, j0 as d } from "../../../../../../shared/runtime.js";
import { ref as _ } from "vue";
import { inject as j } from "vue";
import { computed as m } from "vue";
import { onMounted as A } from "vue";
import { watch as L } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as v } from "vue";
import { createBlock as f } from "vue";
import { withCtx as t } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as r } from "vue";
import { createElementVNode as o } from "vue";
import { unref as y } from "vue";
import { resolveDynamicComponent as z } from "vue";
import { defineAsyncComponent as c } from "vue";
import { ElButton as N } from "element-plus";
import { ElRadioButton as O } from "element-plus";
import { ElRadioGroup as h } from "element-plus";
import { ElDrawer as q } from "element-plus";
const G = { class: "record-container" }, H = { class: "header-container" }, K = { class: "left-elements" }, M = { class: "radio-container" }, $ = { class: "print-container" }, F = { __name: "index", emits: ["component-mounted"], setup(J, { expose: x, emit: I }) {
  const n = _(false), { projectInfo: V } = j("tableItem"), { crud: b } = B(), s = _(""), E = { settle: c(() => d(() => import("./settle.vue.js"), ["static/js/settle-c5c06ba1.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/detail-991649ef.js", "static/js/file-download-82b299aa.js", "static/css/settle-d83c2fd3.css"])), cumulativePayment: c(() => d(() => import("./PyamentTable.vue.js"), ["static/js/PyamentTable-feefd1ff.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/detail-991649ef.js", "static/js/file-download-82b299aa.js", "static/css/PyamentTable-6821feae.css"])), cumulativeInvoice: c(() => d(() => import("./TicketTable.vue.js"), ["static/js/TicketTable-0094d5c9.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/detail-991649ef.js", "static/js/file-download-82b299aa.js", "static/css/TicketTable-8f352744.css"])) }, T = m(() => E[s.value]), k = I;
  A(() => {
    k("component-mounted", true);
  });
  const w = m(() => {
    switch (s.value) {
      case "settle":
        return "stairUnitSupplierSettleDetail";
      case "cumulativePayment":
        return "stairUnitSupplierPaymentDetail";
      case "cumulativeInvoice":
        return "stairUnitSupplierTicketDetail";
      default:
        return "";
    }
  }), l = _(null);
  return L(() => n.value, async (p) => {
    var e;
    p && await ((e = l == null ? void 0 : l.value) == null ? void 0 : e.getList());
  }), x({ visible: n, radioType: s }), (p, e) => {
    const D = N, u = O, P = h, C = S("print-table"), g = q;
    return v(), f(g, { modelValue: n.value, "onUpdate:modelValue": e[2] || (e[2] = (i) => n.value = i), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, size: "100%" }, { header: t(() => [a(R, { "type-one": false, "header-title": "明细记录" }), a(D, { plain: "", onClick: e[0] || (e[0] = (i) => n.value = false) }, { default: t(() => e[3] || (e[3] = [r("关闭")])), _: 1, __: [3] })]), default: t(() => [o("div", G, [o("div", H, [o("div", K, [o("div", M, [a(P, { modelValue: s.value, "onUpdate:modelValue": e[1] || (e[1] = (i) => s.value = i), class: "box-container", size: "default" }, { default: t(() => [a(u, { value: "settle" }, { default: t(() => e[4] || (e[4] = [r("结算明细")])), _: 1, __: [4] }), a(u, { value: "cumulativePayment" }, { default: t(() => e[5] || (e[5] = [r("付款明细")])), _: 1, __: [5] }), a(u, { value: "cumulativeInvoice" }, { default: t(() => e[6] || (e[6] = [r("收票明细")])), _: 1, __: [6] })]), _: 1 }, 8, ["modelValue"])]), e[7] || (e[7] = o("div", { class: "sub-title" }, null, -1))]), o("div", $, [a(C, { "api-key": w.value, params: { orderId: y(V).id, purchaseType: y(b).query.purchaseType, isContract: true }, class: "animate__fadeIn", size: "default", type: "warning" }, null, 8, ["api-key", "params"])])]), (v(), f(z(T.value), { ref_key: "tableRef", ref: l, class: "animate__fadeIn" }, null, 512))])]), _: 1 }, 8, ["modelValue"]);
  };
} }, Y = U(F, [["__scopeId", "data-v-06cda4d2"]]);
export {
  Y as default
};
