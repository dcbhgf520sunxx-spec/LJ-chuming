import { _ as Q, B as T, uz as U, uA as z, G as p, uB as c, a as _, j0 as k } from "../../../../../shared/runtime.js";
import { ref as f } from "vue";
import { computed as H } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { createBlock as r } from "vue";
import { withCtx as y } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as C } from "vue";
import { resolveDynamicComponent as M } from "vue";
import { defineAsyncComponent as D } from "vue";
import { ElDatePicker as O } from "element-plus";
import { ElButton as I } from "element-plus";
import j from "./fees/index.vue.js";
const F = { class: "header-container" }, $ = { class: "box-container radio-container" }, q = { class: "search-container box-container" }, G = { __name: "Header", setup(J) {
  const S = { auditStatus: void 0, settlementStatus: void 0, supplierName: void 0, year: (/* @__PURE__ */ new Date()).getTime(), unit: void 0 }, { crud: s, query: n } = T(S), g = f(null), w = { paySettleRef: D(() => k(() => import("./payment-settlement/payment-settlement.vue.js"), ["static/js/payment-settlement-e2516fcb.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css"])), invoiceEntryRef: D(() => k(() => import("./invoice-entry/index.vue.js"), ["static/js/index-731c6a56.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-f8d9a22d.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/invoice-entry-a9ceb692.js", "static/js/invoice-entry-d5222a89.js", "static/js/hook-467b8301.js", "static/js/payment-settlement-a7865af1.js", "static/js/second-table-01aae2ca.js", "static/js/useTableTotal-3d22365a.js", "static/css/second-table-0f51ab49.css", "static/js/invoice-info-ff94ef5d.js", "static/css/index-0891c296.css"])) }, R = H(() => w[g.value]), i = f(null), V = (u) => {
    g.value = u, i.value && (i.value.visible = true);
  }, B = (u) => {
    u && (i.value.visible = true);
  }, d = f(false);
  function h() {
    d.value = true;
  }
  const A = [{ id: "1", label: "展示一级单位" }, { id: "2", label: "展示二级单位" }];
  return (u, e) => {
    const P = O, b = E("common-radio-button"), N = E("common-select"), m = I;
    return l(), L("div", F, [x("div", $, [a(P, { modelValue: t(n).year, "onUpdate:modelValue": e[0] || (e[0] = (o) => t(n).year = o), clearable: "", editable: "", placeholder: "请选择年份", style: { width: "120px" }, type: "year", "value-format": "x", onChange: t(s).toQuery }, null, 8, ["modelValue", "onChange"]), a(b, { modelValue: t(n).auditStatus, "onUpdate:modelValue": e[1] || (e[1] = (o) => t(n).auditStatus = o), options: t(U).V, showOptionAll: "", type: "enum", onChange: t(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(b, { modelValue: t(n).settlementStatus, "onUpdate:modelValue": e[2] || (e[2] = (o) => t(n).settlementStatus = o), options: t(z).V, showOptionAll: "", type: "enum", onChange: t(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(N, { modelValue: t(n).unit, "onUpdate:modelValue": e[3] || (e[3] = (o) => t(n).unit = o), "data-structure": { key: "id", label: "label", value: "id" }, options: A, clearable: "", filterable: "", placeholder: "单位", type: "other", onChange: t(s).toQuery }, null, 8, ["modelValue", "onChange"])]), x("div", q, [t(p)(t(c).fee.get) ? (l(), r(m, { key: 0, size: "default", type: "primary", onClick: h }, { default: y(() => [a(_, { "icon-class": "logistics-fees" }), e[7] || (e[7] = v(" 物流费设置 "))]), _: 1, __: [7] })) : C("", true), t(p)(t(c).payment) ? (l(), r(m, { key: 1, size: "default", type: "success", onClick: e[4] || (e[4] = (o) => V("paySettleRef")) }, { default: y(() => [a(_, { "icon-class": "contract-collection" }), e[8] || (e[8] = v(" 付款申请 "))]), _: 1, __: [8] })) : C("", true), t(p)(t(c).invoice) ? (l(), r(m, { key: 2, size: "default", type: "warning", onClick: e[5] || (e[5] = (o) => V("invoiceEntryRef")) }, { default: y(() => [a(_, { "icon-class": "contract-invoice" }), e[9] || (e[9] = v(" 发票入账 "))]), _: 1, __: [9] })) : C("", true)]), a(j, { visible: d.value, "onUpdate:visible": e[6] || (e[6] = (o) => d.value = o) }, null, 8, ["visible"]), (l(), r(M(R.value), { ref_key: "currentComponentRef", ref: i, onComponentMounted: B }, null, 544))]);
  };
} }, Y = Q(G, [["__scopeId", "data-v-f0de6de6"]]);
export {
  Y as default
};
