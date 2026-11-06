import { ref as v } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as r } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as s } from "vue";
import { createSlots as $ } from "vue";
import { ElTableColumn as z } from "element-plus";
import { InfoFilled as Q } from "@element-plus/icons-vue";
import { ElIcon as q } from "element-plus";
import { ElTooltip as G } from "element-plus";
import { ElBadge as Y } from "element-plus";
import { vLoading as J } from "element-plus";
import { _ as K, t as W, x as X, o as Z, i as C, bV as x, G as d, P as ee, jE as te, jF as D, a as ne } from "../../../../../shared/runtime.js";
import { l as oe } from "../../../../../modules/logistics-record-ledger-a6792d58.js";
import { C as u } from "../../../../../modules/contract-9b18cc88.js";
import ie from "./module/header.vue.js";
import ae from "./module/payment-and-invoice/index.vue.js";
import le from "../../../../supply-chain/logistics-payment-manage/logistics-record/module/record-detail.vue.js";
import re from "./module/payment-audit/index.vue.js";
import "./module/payment-and-invoice/payment/index.vue.js";
import "../../../../../modules/logistics-payment-1a755fb1.js";
import "./module/payment-and-invoice/invoice/index.vue.js";
import "../../../../../modules/UploadBtn-b4cfb47a.js";
import "./module/payment-and-invoice/invoice/form.vue.js";
import "./module/payment-audit/list.vue.js";
import "./module/payment-audit/detail.vue.js";
import "../../../../../modules/pay-9ccccafb.js";
const se = { class: "app-container" }, ue = { class: "head-container" }, ce = ["onClick"], me = ["onClick"], pe = { style: { display: "inline-block" } }, de = ["onClick"], fe = ["onClick"], _e = { style: { display: "inline-block" } }, ye = ["onClick"], ve = { style: { "margin-right": "10px" } }, he = { __name: "index", setup(ge) {
  const { decimalPrecision: g } = W(), L = { add: false, edit: false, del: false, download: false }, A = v(), w = v(false), b = v(false), k = v(false), f = v({}), V = v("payment"), { crud: _, columns: m } = X({ title: "物流付款", sort: [], permission: { ...u }, optShow: { ...L }, crudApi: { get: oe }, hasPagination: true }, A), { maxHeight: M } = Z({ wrapperBox: ".logisticsAuditManage", paginate: true, extraHeight: 40 });
  function N(y) {
    d(u.logisticsLog.get) && (f.value = y, w.value = true);
  }
  function R(y, i) {
    d(u[i].get) && (V.value = i, f.value = y, b.value = true);
  }
  function F(y) {
    d(u.payment.get) && (f.value = y, k.value = true);
  }
  return (y, i) => {
    const c = z, P = Q, T = q, S = G, E = ne, I = Y, U = O("common-table"), H = J;
    return l(), B("div", se, [a("div", ue, [o(e(ie))]), j((l(), r(U, { ref_key: "tableRef", ref: A, data: e(_).data, "empty-text": e(_).emptyText, "max-height": e(M), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: n(() => [o(c, { prop: "index", label: "序号", align: "center", width: "55", type: "index", fixed: "left" }), e(m).visible("supplierName") ? (l(), r(c, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": true, label: "物流单位", align: "center", "min-width": "140" }, { default: n((t) => [a("span", { onClick: (h) => N(t.row), style: { cursor: "pointer" } }, p(t.row.supplierName), 9, ce)]), _: 1 })) : s("", true), e(m).visible("branchCompanyName") ? (l(), r(c, { key: "branchCompanyName", prop: "branchCompanyName", "show-overflow-tooltip": true, label: "签约主体", align: "center", "min-width": "140" }, { default: n((t) => [a("span", null, p(t.row.branchCompanyName), 1)]), _: 1 })) : s("", true), e(m).visible("freight") ? (l(), r(c, { key: "freight", prop: "freight", label: "运输额", align: "center", "min-width": "100" }, { default: n((t) => [a("span", { onClick: (h) => N(t.row), style: { cursor: "pointer" } }, p(e(C)(t.row.freight) ? e(x)(t.row.freight, e(g).contract) : 0), 9, me)]), _: 1 })) : s("", true), e(m).visible("paymentAmount") ? (l(), r(c, { key: "paymentAmount", prop: "paymentAmount", label: "付款额", align: "center", "min-width": "100" }, $({ default: n((t) => [a("span", { style: { cursor: "pointer", "margin-right": "10px" }, onClick: (h) => R(t.row, "payment") }, p(e(C)(t.row.paymentAmount) ? e(x)(t.row.paymentAmount, e(g).contract) : 0), 9, de), e(d)(e(u).payment.audit) && t.row.unCheckPaymentCount > 0 ? (l(), B("span", { key: 0, onClick: (h) => F(t.row), style: { cursor: "pointer" } }, [o(I, { value: t.row.unCheckPaymentCount, max: 99, hidden: t.row.unCheckPaymentCount < 1 }, { default: n(() => [o(E, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["value", "hidden"])], 8, fe)) : s("", true)]), _: 2 }, [e(d)(e(u).invoice.get) ? { name: "header", fn: n(() => [o(S, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: n(() => [a("div", pe, [i[3] || (i[3] = a("span", null, "付款额 ", -1)), o(T, null, { default: n(() => [o(P)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : s("", true), e(m).visible("paymentAmountRate") ? (l(), r(c, { key: "paymentAmountRate", prop: "paymentAmountRate", label: "付款比例", align: "center", "min-width": "80" }, { default: n((t) => [a("div", null, p(t.row.paymentAmount && t.row.freight ? (t.row.paymentAmount / t.row.freight * 100).toFixed(2) + "%" : 0), 1)]), _: 1 })) : s("", true), e(m).visible("invoiceAmount") ? (l(), r(c, { key: "invoiceAmount", prop: "invoiceAmount", label: "收票额", align: "center", "min-width": "100" }, $({ default: n((t) => [a("div", { onClick: (h) => R(t.row, "invoice"), style: { cursor: "pointer" } }, [a("span", ve, p(e(C)(t.row.invoiceAmount) ? e(x)(t.row.invoiceAmount, e(g).contract) : 0), 1), e(d)(e(u).invoice.audit) && t.row.unCheckInvoiceCount > 0 ? (l(), r(I, { key: 0, value: t.row.unCheckInvoiceCount, max: 99, hidden: t.row.unCheckInvoiceCount < 1 }, { default: n(() => [o(E, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["value", "hidden"])) : s("", true)], 8, ye)]), _: 2 }, [e(d)(e(_).permission.get) ? { name: "header", fn: n(() => [o(S, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: n(() => [a("div", _e, [i[4] || (i[4] = a("span", null, "收票额 ", -1)), o(T, null, { default: n(() => [o(P)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : s("", true), e(m).visible("invoiceRate") ? (l(), r(c, { key: "invoiceRate", prop: "invoiceRate", label: "收票比例", align: "center", "min-width": "80" }, { default: n((t) => [a("div", null, p(t.row.invoiceAmount ? (t.row.invoiceAmount / t.row.freight * 100).toFixed(2) + "%" : 0), 1)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[H, e(_).loading]]), o(e(ee)), o(e(le), { modelValue: w.value, "onUpdate:modelValue": i[0] || (i[0] = (t) => w.value = t), detailInfo: f.value, type: e(te).COMPANY.V, permission: e(u).logisticsLog }, null, 8, ["modelValue", "detailInfo", "type", "permission"]), o(e(ae), { modelValue: b.value, "onUpdate:modelValue": i[1] || (i[1] = (t) => b.value = t), currentRow: f.value, tabName: V.value, propertyType: e(D).TRANSPORT.V, onSuccess: e(_).toQuery, permission: e(u) }, null, 8, ["modelValue", "currentRow", "tabName", "propertyType", "onSuccess", "permission"]), o(e(re), { modelValue: k.value, "onUpdate:modelValue": i[2] || (i[2] = (t) => k.value = t), currentRow: f.value, propertyType: e(D).TRANSPORT.V, onSuccess: e(_).toQuery }, null, 8, ["modelValue", "currentRow", "propertyType", "onSuccess"])]);
  };
} }, De = K(he, [["__scopeId", "data-v-50cf1eb8"]]);
export {
  De as default
};
