import { B as h, uP as b, wG as T, G as c, a as w, C as A, j0 as k } from "../../../../../shared/runtime.js";
import { ref as y } from "vue";
import { computed as M } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { createBlock as m } from "vue";
import { withCtx as _ } from "vue";
import { createTextVNode as V } from "vue";
import { createCommentVNode as v } from "vue";
import { withKeys as d } from "vue";
import { resolveDynamicComponent as j } from "vue";
import { Fragment as z } from "vue";
import { defineAsyncComponent as N } from "vue";
import { ElDatePicker as O } from "element-plus";
import { ElButton as I } from "element-plus";
import { ElInput as L } from "element-plus";
const $ = { class: "head-container" }, G = { class: "drawer-group" }, q = { class: "select-container" }, W = { __name: "header", setup(F) {
  const x = { year: (/* @__PURE__ */ new Date()).getTime(), boolSettlementStatus: void 0, auditTypeEnum: void 0 }, { crud: n, query: l } = h(x), C = y(), D = { payment: N(() => k(() => import("./payment-settlement/payment-settlement.vue.js"), ["static/js/payment-settlement-b0507c67.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/js/index-dfff0f60.js", "static/css/payment-settlement-6ac89dcb.css", "static/css/el-radio-group-3b9ac3ad.css"])), invoiceEntry: N(() => k(() => import("./invoice-entry/index.vue.js"), ["static/js/index-c5cb2b4b.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-0454d175.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/invoice-entry-de8cd325.js", "static/js/index-dfff0f60.js", "static/js/second-table-84aa0e8e.js", "static/js/useTableTotal-3d22365a.js", "static/css/second-table-a4f7a291.css", "static/js/invoice-info-771fe419.js", "static/css/index-4feb75aa.css"])) }, r = y(), E = (i) => {
    C.value = i, r.value && (r.value.visible = true);
  }, P = (i) => {
    i && (r.value.visible = true);
  }, S = y([b.UNDER_APPROVAL, b.PASSED]), K = M(() => D[C.value]);
  function Q() {
    n.toQuery();
  }
  return (i, t) => {
    const U = O, g = B("common-radio-button"), p = I, u = L;
    return s(), R(z, null, [f("div", $, [a(U, { modelValue: e(l).year, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(l).year = o), class: "filter-item", placeholder: "日期", style: { width: "100px" }, type: "year", "value-format": "x", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), a(g, { modelValue: e(l).boolSettlementStatus, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(l).boolSettlementStatus = o), options: e(T).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(g, { modelValue: e(l).auditTypeEnum, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(l).auditTypeEnum = o), options: S.value, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), f("div", G, [e(c)(e(n).permission.add) ? (s(), m(p, { key: 0, class: "filter-item", icon: "el-icon-plus", size: "default", type: "success", onClick: e(n).toAdd }, { default: _(() => t[9] || (t[9] = [V("创建分供 ")])), _: 1, __: [9] }, 8, ["onClick"])) : v("", true), e(c)(e(n).permission.payment_application) ? (s(), m(p, { key: 1, class: "filter-item", size: "default", type: "primary", onClick: t[3] || (t[3] = (o) => E("payment")) }, { default: _(() => [a(w, { "icon-class": "contract-collection", style: { "margin-right": "5px" } }), t[10] || (t[10] = V(" 付款申请 "))]), _: 1, __: [10] })) : v("", true), e(c)(e(n).permission.invoice_entry) ? (s(), m(p, { key: 2, class: "filter-item", size: "default", type: "warning", onClick: t[4] || (t[4] = (o) => E("invoiceEntry")) }, { default: _(() => [a(w, { "icon-class": "contract-invoice", style: { "margin-right": "5px" } }), t[11] || (t[11] = V(" 发票入账 "))]), _: 1, __: [11] })) : v("", true)]), f("div", q, [a(u, { modelValue: e(l).serialNumber, "onUpdate:modelValue": t[5] || (t[5] = (o) => e(l).serialNumber = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "分包合同号搜索", style: { width: "200px" }, onKeyup: d(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(u, { modelValue: e(l).projectName, "onUpdate:modelValue": t[6] || (t[6] = (o) => e(l).projectName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "项目搜索", style: { width: "200px" }, onKeyup: d(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(u, { modelValue: e(l).supplierName, "onUpdate:modelValue": t[7] || (t[7] = (o) => e(l).supplierName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "分包商搜索", style: { width: "200px" }, onKeyup: d(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(u, { modelValue: e(l).userName, "onUpdate:modelValue": t[8] || (t[8] = (o) => e(l).userName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "创建人搜索", style: { width: "200px" }, onKeyup: d(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(A)])]), (s(), m(j(K.value), { ref_key: "currentComponentRef", ref: r, onClosed: Q, onComponentMounted: P }, null, 544))], 64);
  };
} };
export {
  W as default
};
