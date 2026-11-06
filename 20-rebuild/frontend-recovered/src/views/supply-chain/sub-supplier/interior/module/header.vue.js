import { B as U, uP as b, wG as T, G as p, C as h, a as j, j0 as N } from "../../../../../shared/runtime.js";
import { ref as c } from "vue";
import { computed as A } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createBlock as m } from "vue";
import { withCtx as y } from "vue";
import { createTextVNode as _ } from "vue";
import { createCommentVNode as V } from "vue";
import { resolveDynamicComponent as z } from "vue";
import { Fragment as O } from "vue";
import { defineAsyncComponent as w } from "vue";
import { ElDatePicker as Q } from "element-plus";
import { ElButton as I } from "element-plus";
import { ElInput as L } from "element-plus";
const $ = { class: "head-container" }, G = { class: "drawer-group" }, q = { class: "select-container" }, K = { __name: "header", setup(F) {
  const k = { year: (/* @__PURE__ */ new Date()).getTime(), boolSettlementStatus: void 0, auditTypeEnum: void 0 }, { crud: a, query: l } = U(k), v = c(), x = { payment: w(() => N(() => import("./payment-settlement/payment-settlement.vue.js"), ["static/js/payment-settlement-4d68c293.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/js/index-69cea220.js", "static/css/payment-settlement-a28f1e16.css", "static/css/el-radio-group-3b9ac3ad.css"])), invoiceEntry: w(() => N(() => import("./invoice-entry/index.vue.js"), ["static/js/index-44f58ff1.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-68be9666.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/invoice-entry-8680260e.js", "static/js/info-d30309fa.js", "static/js/index-69cea220.js", "static/js/second-table-21b0fbf3.js", "static/js/useTableTotal-3d22365a.js", "static/css/second-table-d1155412.css", "static/js/invoice-info-609393b3.js", "static/css/index-0cf7406f.css"])) }, i = c(), g = (u) => {
    v.value = u, i.value && (i.value.visible = true);
  }, D = (u) => {
    u && (i.value.visible = true);
  }, M = c([b.UNDER_APPROVAL, b.PASSED]), P = A(() => x[v.value]);
  return (u, t) => {
    const S = Q, C = B("common-radio-button"), d = I, E = j, s = L;
    return r(), R(O, null, [f("div", $, [n(S, { modelValue: e(l).year, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(l).year = o), class: "filter-item", placeholder: "日期", style: { width: "140px" }, type: "date", "value-format": "x", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), n(C, { modelValue: e(l).boolSettlementStatus, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(l).boolSettlementStatus = o), options: e(T).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(C, { modelValue: e(l).auditTypeEnum, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(l).auditTypeEnum = o), options: M.value, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), f("div", G, [e(p)(e(a).permission.add) ? (r(), m(d, { key: 0, class: "filter-item", icon: "el-icon-plus", size: "default", type: "success", onClick: e(a).toAdd }, { default: y(() => t[10] || (t[10] = [_("创建分供 ")])), _: 1, __: [10] }, 8, ["onClick"])) : V("", true), e(p)(e(a).permission.payment_application) ? (r(), m(d, { key: 1, class: "filter-item", size: "default", type: "primary", onClick: t[3] || (t[3] = (o) => g("payment")) }, { default: y(() => [n(E, { "icon-class": "contract-collection", style: { "margin-right": "5px" } }), t[11] || (t[11] = _(" 付款申请 "))]), _: 1, __: [11] })) : V("", true), e(p)(e(a).permission.invoice_entry) ? (r(), m(d, { key: 2, class: "filter-item", size: "default", type: "warning", onClick: t[4] || (t[4] = (o) => g("invoiceEntry")) }, { default: y(() => [n(E, { "icon-class": "contract-invoice", style: { "margin-right": "5px" } }), t[12] || (t[12] = _(" 发票入账 "))]), _: 1, __: [12] })) : V("", true)]), f("div", q, [n(s, { modelValue: e(l).serialNumber, "onUpdate:modelValue": t[5] || (t[5] = (o) => e(l).serialNumber = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "采购单号搜索", style: { width: "200px" } }, null, 8, ["modelValue"]), n(s, { modelValue: e(l).projectName, "onUpdate:modelValue": t[6] || (t[6] = (o) => e(l).projectName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "项目搜索", style: { width: "200px" } }, null, 8, ["modelValue"]), n(s, { modelValue: e(l).supplierName, "onUpdate:modelValue": t[7] || (t[7] = (o) => e(l).supplierName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "供应商搜索", style: { width: "200px" } }, null, 8, ["modelValue"]), n(s, { modelValue: e(l).projectManagerName, "onUpdate:modelValue": t[8] || (t[8] = (o) => e(l).projectManagerName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "项目经理搜索", style: { width: "200px" } }, null, 8, ["modelValue"]), n(s, { modelValue: e(l).userName, "onUpdate:modelValue": t[9] || (t[9] = (o) => e(l).userName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "创建人搜索", style: { width: "200px" } }, null, 8, ["modelValue"]), n(h)])]), (r(), m(z(P.value), { ref_key: "currentComponentRef", ref: i, onComponentMounted: D }, null, 544))], 64);
  };
} };
export {
  K as default
};
