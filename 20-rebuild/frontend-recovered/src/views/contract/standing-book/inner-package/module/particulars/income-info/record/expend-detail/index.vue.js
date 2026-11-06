import { _ as H, dp as M, j1 as G, gD as J, p as K, ec as Q, j0 as y } from "../../../../../../../../../shared/runtime.js";
import { useAttrs as U } from "vue";
import { toRefs as W } from "vue";
import { computed as o } from "vue";
import { ref as f } from "vue";
import { resolveComponent as X } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as a } from "vue";
import { createBlock as n } from "vue";
import { withCtx as l } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as I } from "vue";
import { createElementVNode as c } from "vue";
import { unref as r } from "vue";
import { createCommentVNode as _ } from "vue";
import { createElementBlock as b } from "vue";
import { Fragment as Z } from "vue";
import { renderList as $ } from "vue";
import { toDisplayString as k } from "vue";
import { withDirectives as ee } from "vue";
import { resolveDynamicComponent as te } from "vue";
import { defineAsyncComponent as h } from "vue";
import { nextTick as ae } from "vue";
import { ElButton as se } from "element-plus";
import { ElCol as re } from "element-plus";
import { ElRow as oe } from "element-plus";
import { ElDrawer as ne } from "element-plus";
const le = { class: "print-container" }, ie = { class: "basic-info" }, ce = { class: "item" }, pe = { class: "truncate" }, de = { __name: "index", props: { visible: { type: Boolean, required: true } }, emits: ["update:visible"], setup(D, { emit: j }) {
  const x = D, w = j, { item_info: t } = U(), { projectId: E, purchaseDetailId: g, supplierId: C } = W(t), T = () => w("update:visible", false), A = o(() => t.mark), N = { payment: h(() => y(() => import("./Payment.vue.js"), ["static/js/Payment-64846097.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js"])), collect_ticket: h(() => y(() => import("./CollectTicket.vue.js"), ["static/js/CollectTicket-93dea7bc.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js"])) }, P = o(() => N[A.value]), R = o(() => t.mark === "payment" ? "支付记录" : "发票记录"), m = f(), p = f(), s = (e, i) => ({ label: e, value: i(), isTruncated: false }), V = async () => {
    try {
      const e = await G.get("/api/v2/contract/payment/projectPaymentDetailList", { projectId: E.value, supplierId: C.value, orderId: g.value, incomeExpendType: t.mark === "payment" ? 1 : 2 });
      m.value = [s("项目", () => e.project.serialNumber + "-" + e.project.shortName), s("经营类型", () => J.VL[e.projectAttribute] + "项目"), s("项目经理", () => e.projectManager.name), s("创建日期", () => K(e.createTime, "{y}-{m}-{d}")), s("供应商", () => e.supplier.supplierName), s("采购合同号", () => e.supplierNumber)], p.value = Q(e.detail), await ae();
    } catch (e) {
      console.error("获取记录失败", e);
    }
  }, B = o(() => t.mark === "payment"), L = o(() => t.mark === "collect_ticket");
  return V(), (e, i) => {
    const z = se, v = X("print-table"), S = re, q = oe, O = ne, F = Y("ellipsis");
    return a(), n(O, { "model-value": x.visible, "show-close": false, "destroy-on-close": "", size: "50%" }, { header: l(() => [u(M, { "header-title": R.value, "type-one": false }, null, 8, ["header-title"]), u(z, { onClick: T }, { default: l(() => i[0] || (i[0] = [I("关闭")])), _: 1, __: [0] })]), default: l(() => [c("div", le, [B.value ? (a(), n(v, { key: 0, params: { projectId: r(t).projectId, supplierId: r(t).supplierId, orderId: r(t).purchaseDetailId }, "api-key": "expendPaymentRecord", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"])) : _("", true), L.value ? (a(), n(v, { key: 1, params: { projectId: r(t).projectId, supplierId: r(t).supplierId, orderId: r(t).purchaseDetailId }, "api-key": "expendInvoiceRecord", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"])) : _("", true)]), c("div", ie, [u(q, null, { default: l(() => [(a(true), b(Z, null, $(m.value, (d) => (a(), n(S, { key: d.key, span: 8 }, { default: l(() => [c("div", ce, [c("span", null, k(d.label), 1), ee((a(), b("span", pe, [I(k(d.value), 1)])), [[F]])])]), _: 2 }, 1024))), 128))]), _: 1 })]), p.value ? (a(), n(te(P.value), { key: 0, table_data: p.value, class: "animate__animated animate__fadeIn" }, null, 8, ["table_data"])) : _("", true)]), _: 1 }, 8, ["model-value"]);
  };
} }, me = H(de, [["__scopeId", "data-v-e9d924d9"]]);
export {
  me as default
};
