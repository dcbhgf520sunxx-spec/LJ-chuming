import { ref as D } from "vue";
import { inject as I } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as p } from "vue";
import { createBlock as w } from "vue";
import { withCtx as l } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as _ } from "vue";
import { createElementVNode as a } from "vue";
import { unref as e } from "vue";
import { normalizeStyle as z } from "vue";
import { withDirectives as d } from "vue";
import { createElementBlock as c } from "vue";
import { Fragment as A } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as m } from "vue";
import { isRef as F } from "vue";
import { ElFormItem as H } from "element-plus";
import { ElDivider as U } from "element-plus";
import { ElForm as O } from "element-plus";
import { _ as L, u as q, o as J, i as W, jJ as T, am as X, jZ as Z, bD as E, jT as $, bR as G, jU as K, jV as Q, z as Y, R as ee, S as se, vX as te } from "../../../../../shared/runtime.js";
const ae = { class: "main-content" }, le = { class: "form-left" }, oe = { class: "flex-rss child-mr-10" }, ne = { key: 0 }, ie = { key: 0 }, re = { key: 0 }, pe = { style: { "word-break": "break-all" } }, de = { key: 0, class: "pre-wrap" }, me = { class: "form-right" }, ue = { __name: "submit-preview", props: { visible: { type: Boolean, default: false }, loading: { type: Boolean, default: false } }, emits: ["update:visible", "submit"], setup(y, { emit: x }) {
  var h;
  const b = D(), v = x, k = y, s = (h = I("crud")) == null ? void 0 : h.form, { visible: f, handleClose: C } = q({ emit: v, props: k, field: "visible" }), { maxHeight: R } = J({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, b);
  function V() {
    v("submit");
  }
  return (M, t) => {
    const j = g("common-button"), n = H, B = U, P = O, S = g("common-drawer"), r = N("parse-enum");
    return p(), w(S, { ref_key: "drawerRef", ref: b, title: "提交预览", modelValue: e(f), "onUpdate:modelValue": t[1] || (t[1] = (u) => F(f) ? f.value = u : null), direction: "rtl", "before-close": e(C), size: "100%" }, { titleRight: l(() => [o(j, { loading: y.loading, size: "default", type: "primary", onClick: V }, { default: l(() => t[2] || (t[2] = [_(" 确认提交 ")])), _: 1, __: [2] }, 8, ["loading"])]), content: l(() => [a("div", ae, [e(W)(e(s)) ? (p(), w(P, { key: 0, model: e(s), size: "default", "label-position": "left", "label-width": "100px" }, { default: l(() => [a("div", { class: "form-content", style: z(M.heightStyle) }, [a("div", le, [o(n, { label: "物料种类", prop: "basicClass" }, { default: l(() => [a("div", oe, [d(a("span", null, null, 512), [[r, { e: e(T), v: e(s).purchaseType, extra: "：" }]]), d(a("span", null, null, 512), [[r, { e: e(X), v: e(s).basicClass, bit: true, split: " | " }]])])]), _: 1 }), e(s).supplyType === e(Z).SELF.V ? (p(), c(A, { key: 0 }, [o(n, { label: "合同量", prop: "mete" }, { default: l(() => [a("span", null, i(e(s).mete) + " " + i(e(s).meteUnit), 1)]), _: 1 }), o(n, { label: "合同额", prop: "amount" }, { default: l(() => [a("span", null, i(e(s).amount) + " 元", 1), t[3] || (t[3] = _(" 【")), d(a("span", null, null, 512), [[r, { e: e(E), v: e(s).invoiceType }]]), e(s).invoiceType !== e(E).RECEIPT.V ? (p(), c("span", ne, "（" + i(e(s).taxRate) + "%）", 1)) : m("", true), t[4] || (t[4] = _("】 "))]), _: 1, __: [3, 4] }), o(n, { label: "订单类型", prop: "purchaseOrderPaymentMode" }, { default: l(() => [d(a("span", null, null, 512), [[r, { e: e($), v: e(s).purchaseOrderPaymentMode }]])]), _: 1 })], 64)) : m("", true), o(n, { prop: "weightMeasurementMode", label: "计量方式" }, { default: l(() => [d(a("span", null, null, 512), [[r, { e: e(G), v: e(s).weightMeasurementMode }]])]), _: 1 }), o(n, { label: "物流信息", prop: "logistics" }, { default: l(() => [d(a("span", null, null, 512), [[r, { e: e(K), v: e(s).logisticsTransportType }]]), t[5] || (t[5] = _(" （费用")), d(a("span", null, null, 512), [[r, { e: e(Q), v: e(s).logisticsPayerType }]]), t[6] || (t[6] = _("） "))]), _: 1, __: [5, 6] }), o(n, { label: "供应商", prop: "supplier" }, { default: l(() => [e(s).supplier ? (p(), c("span", ie, i(e(s).supplier.name), 1)) : m("", true)]), _: 1 }), o(n, { label: "签订主体", prop: "branchCompanyName", style: { width: "100%" } }, { default: l(() => [e(s).branchCompany ? (p(), c("span", re, i(e(s).branchCompany.name), 1)) : m("", true)]), _: 1 }), o(n, { label: "备注", prop: "remark", style: { width: "100%" } }, { default: l(() => [a("span", pe, i(e(s).remark), 1)]), _: 1 }), o(n, { label: "关联项目", class: "el-form-item-4", prop: "projectIds", style: { width: "100%" } }, { default: l(() => [e(T).RAW_MATERIAL.V === e(s).purchaseType ? (p(), c("span", de, i(e(s).projects ? e(s).projects.map((u) => e(Y)(u, null, false)).join(`
`) : ""), 1)) : m("", true)]), _: 1 }), o(B, null, { default: l(() => t[7] || (t[7] = [a("span", { class: "title" }, "附件", -1)])), _: 1, __: [7] }), o(ee, { "show-download": "", "file-classify": e(se).PURCHASE_ORDER_ATT.V, files: e(s).attachments, "onUpdate:files": t[0] || (t[0] = (u) => e(s).attachments = u), uploadable: false, "empty-text": "暂未上传采购合同附件" }, null, 8, ["file-classify", "files"])]), t[9] || (t[9] = a("div", { class: "vertical-dashed-divider" }, null, -1)), a("div", me, [t[8] || (t[8] = a("div", { class: "right-head flex-rbs" }, [a("span", { class: "right-head-content" }, [a("span", { class: "label" }, "采购清单")])], -1)), o(te, { "material-type": e(s).materialType, list: e(s).details, "max-height": e(R) - 150 }, null, 8, ["material-type", "list", "max-height"])])], 4)]), _: 1 }, 8, ["model"])) : m("", true)])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, fe = L(ue, [["__scopeId", "data-v-d5735ebf"]]);
export {
  fe as default
};
