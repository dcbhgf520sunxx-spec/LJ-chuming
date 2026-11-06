import { ref as _ } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as i } from "vue";
import { unref as t } from "vue";
import { withDirectives as G } from "vue";
import { createBlock as u } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as s } from "vue";
import { createSlots as I } from "vue";
import { createTextVNode as K } from "vue";
import { ElTableColumn as Y } from "element-plus";
import { ElBadge as J } from "element-plus";
import { InfoFilled as W } from "@element-plus/icons-vue";
import { ElIcon as X } from "element-plus";
import { ElTooltip as Z } from "element-plus";
import { ElTag as ee } from "element-plus";
import { vLoading as te } from "element-plus";
import { _ as ne, t as oe, x as ae, o as ie, br as le, iF as V, p as re, bv as ue, am as se, bV as w, G as f, D as me, i as ce, P as de, a as pe } from "../../../../../shared/runtime.js";
import { c as fe } from "../../../../../modules/material-manage-f1c542ef.js";
import { D as v } from "../../../../../modules/contract-9b18cc88.js";
import ye from "../../../../supply-chain/purchase-reconciliation-manage/payment-ledger/module/inbound-record.vue.js";
import _e from "./module/payment-and-invoice/index.vue.js";
import ve from "./module/payment-audit/index.vue.js";
import be from "../../../../supply-chain/purchase-reconciliation-manage/payment-ledger/module/settle-form.vue.js";
import we from "./module/header.vue.js";
import "../../../../../modules/payment-ledger-cb1d373c.js";
import "./module/payment-and-invoice/payment/index.vue.js";
import "../../../../../modules/pay-9ccccafb.js";
import "./module/payment-and-invoice/invoice/index.vue.js";
import "../../../../../modules/invoice-bc8acad8.js";
import "../../../../../modules/UploadBtn-b4cfb47a.js";
import "./module/payment-and-invoice/invoice/form.vue.js";
import "./module/payment-audit/list.vue.js";
import "./module/payment-audit/detail.vue.js";
import "../../../../../modules/collection-9275714a.js";
import "../../../../../modules/payment-application-502afb4b.js";
const he = { class: "app-container" }, ge = { class: "head-container" }, ke = ["onClick"], Ce = ["onClick"], Ae = ["onClick"], xe = { style: { display: "inline-block" } }, Te = ["onClick"], Se = ["onClick"], Ve = { style: { display: "inline-block" } }, Ne = ["onClick"], De = { style: { cursor: "pointer", "margin-right": "10px" } }, Ee = { key: 1 }, Re = { __name: "index", setup(Pe) {
  const U = { add: false, edit: false, del: false, download: false }, { decimalPrecision: h } = oe(), N = _(), k = _(false), C = _(false), A = _(false), x = _(false), y = _({}), D = _("payment"), E = _("audit"), { CRUD: M, crud: o, columns: d } = ae({ title: "原材料", sort: [], permission: { ...v }, optShow: { ...U }, crudApi: { ...fe }, hasPagination: true }, N), { maxHeight: L } = ie({ wrapperBox: ".materialManage", paginate: true, extraHeight: 40 });
  function F(p) {
    f(v.inbound.get) && (y.value = p, k.value = true);
  }
  function R(p, l) {
    f(v[l].get) && (D.value = l, y.value = p, C.value = true);
  }
  function H(p) {
    f(v.payment.get) && (y.value = p, A.value = true);
  }
  function P(p, l) {
    if (l === "detail") {
      if (!p.settlementAmount || !f(v.settleDetail)) return;
    } else if (!f(v.settleAudit)) return;
    E.value = l, y.value = p, x.value = true;
  }
  return M.HOOK.beforeRefresh = () => {
    var p;
    ((p = o.query.createTime) == null ? void 0 : p.length) > 0 ? (o.query.startDate = o.query.createTime[0], o.query.endDate = o.query.createTime[1]) : (o.query.startDate = void 0, o.query.endDate = void 0);
  }, (p, l) => {
    const m = Y, T = pe, S = J, q = W, $ = X, B = Z, z = ee, O = j("common-table"), Q = te;
    return a(), g("div", he, [r("div", ge, [i(t(we))]), G((a(), u(O, { ref_key: "tableRef", ref: N, data: t(o).data, "empty-text": t(o).emptyText, "max-height": t(L), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: n(() => [i(m, { label: "序号", type: "index", align: "center", width: "60" }, { default: n((e) => [i(le, { show: e.row.settlementStatus === t(V).SETTLED.V, name: "已结算", color: "#f56c6c" }, null, 8, ["show"]), r("span", null, c(e.$index + 1), 1)]), _: 1 }), t(d).visible("serialNumber") ? (a(), u(m, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "采购合同编号", align: "center" }, { default: n((e) => [r("span", null, c(e.row.serialNumber), 1)]), _: 1 })) : s("", true), t(d).visible("createTime") ? (a(), u(m, { key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "签订日期", align: "center", width: "80" }, { default: n((e) => [r("div", null, c(e.row.createTime ? t(re)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : s("", true), t(d).visible("supplierName") ? (a(), u(m, { key: "supplierName", prop: "supplierName", label: "供应商", align: "center" }, { default: n((e) => [r("div", null, c(e.row.supplierName ? e.row.supplierName : "-"), 1)]), _: 1 })) : s("", true), t(d).visible("basicClass") ? (a(), u(m, { key: "basicClass", prop: "basicClass", "show-overflow-tooltip": true, label: "种类", align: "center" }, { default: n((e) => [r("div", null, c(e.row.basicClass ? t(ue).getBits(t(se).ENUM, e.row.basicClass, "L").join("|") : ""), 1)]), _: 1 })) : s("", true), t(d).visible("amount") ? (a(), u(m, { key: "amount", prop: "amount", label: "合同额", align: "center" }, { default: n((e) => [r("span", null, c(e.row.amount ? t(w)(e.row.amount, t(h).contract) : "-"), 1)]), _: 1 })) : s("", true), t(d).visible("settlementAmount") ? (a(), u(m, { key: "settlementAmount", prop: "settlementAmount", "show-overflow-tooltip": true, label: "结算额", align: "center" }, { default: n((e) => [r("span", { style: { "margin-right": "10px" }, onClick: (b) => P(e.row, "detail") }, c(e.row.settlementAmount ? t(w)(e.row.settlementAmount, t(h).contract) : "-"), 9, ke), t(f)(t(o).permission.settleAudit) && e.row.unCheckSettlementCount > 0 ? (a(), g("span", { key: 0, onClick: (b) => P(e.row, "audit"), style: { cursor: "pointer" } }, [i(S, { value: 1, max: 99, hidden: e.row.unCheckSettlementCount < 1 }, { default: n(() => [i(T, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["hidden"])], 8, Ce)) : s("", true)]), _: 1 })) : s("", true), t(d).visible("inboundAmount") ? (a(), u(m, { key: "inboundAmount", prop: "inboundAmount", label: "入库额", align: "center" }, { default: n((e) => [r("span", { onClick: (b) => F(e.row) }, c(e.row.inboundAmount ? t(w)(e.row.inboundAmount, t(me).YUAN) : "-"), 9, Ae)]), _: 1 })) : s("", true), t(d).visible("paymentAmount") ? (a(), u(m, { key: "paymentAmount", prop: "paymentAmount", label: "付款额", align: "center" }, I({ default: n((e) => [r("span", { style: { cursor: "pointer", "margin-right": "10px" }, onClick: (b) => R(e.row, "payment") }, c(e.row.paymentAmount ? t(w)(e.row.paymentAmount, t(h).contract) : "-"), 9, Te), t(f)(t(o).permission.payment.audit) && e.row.unCheckPaymentCount > 0 ? (a(), g("span", { key: 0, onClick: (b) => H(e.row), style: { cursor: "pointer" } }, [i(S, { value: e.row.unCheckPaymentCount, max: 99, hidden: e.row.unCheckPaymentCount < 1 }, { default: n(() => [i(T, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["value", "hidden"])], 8, Se)) : s("", true)]), _: 2 }, [t(f)(t(o).permission.payment.get) ? { name: "header", fn: n(() => [i(B, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: n(() => [r("div", xe, [l[4] || (l[4] = r("span", null, "付款额 ", -1)), i($, null, { default: n(() => [i(q)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : s("", true), t(d).visible("paymentAmountRate") ? (a(), u(m, { key: "paymentAmountRate", prop: "paymentAmountRate", label: "付款比例", align: "center" }, { default: n((e) => [r("div", null, c(e.row.inboundAmount ? (e.row.paymentAmount / e.row.inboundAmount * 100).toFixed(2) + "%" : "0.00%"), 1)]), _: 1 })) : s("", true), t(d).visible("invoiceAmount") ? (a(), u(m, { key: "invoiceAmount", prop: "invoiceAmount", label: "收票额", align: "center" }, I({ default: n((e) => [r("div", { onClick: (b) => R(e.row, "invoice"), style: { cursor: "pointer" } }, [r("span", De, c(e.row.invoiceAmount ? t(w)(e.row.invoiceAmount, t(h).contract) : "-"), 1), t(f)(t(o).permission.invoice.audit) && e.row.unCheckInvoiceCount > 0 ? (a(), u(S, { key: 0, value: e.row.unCheckInvoiceCount, max: 99, hidden: e.row.unCheckInvoiceCount < 1 }, { default: n(() => [i(T, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["value", "hidden"])) : s("", true)], 8, Ne)]), _: 2 }, [t(f)(t(o).permission.invoice.get) ? { name: "header", fn: n(() => [i(B, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: n(() => [r("div", Ve, [l[5] || (l[5] = r("span", null, "收票额 ", -1)), i($, null, { default: n(() => [i(q)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : s("", true), t(d).visible("invoiceRate") ? (a(), u(m, { key: "invoiceRate", prop: "invoiceRate", label: "收票比例", align: "center" }, { default: n((e) => [r("div", null, c(e.row.inboundAmount ? (e.row.invoiceAmount / e.row.inboundAmount * 100).toFixed(2) + "%" : "0.00%"), 1)]), _: 1 })) : s("", true), t(d).visible("settlementStatus") ? (a(), u(m, { key: "settlementStatus", prop: "settlementStatus", label: "结算状态", align: "center", width: "80px" }, { default: n((e) => [t(ce)(e.row.settlementStatus) ? (a(), u(z, { key: 0, type: e.row.settlementStatus === t(V).SETTLED.V ? "success" : "warning", effect: "plain" }, { default: n(() => [K(c(t(V).VL[e.row.settlementStatus]), 1)]), _: 2 }, 1032, ["type"])) : (a(), g("span", Ee, "-"))]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[Q, t(o).loading]]), i(t(ye), { modelValue: k.value, "onUpdate:modelValue": l[0] || (l[0] = (e) => k.value = e), "detail-info": y.value, permission: t(v).inbound }, null, 8, ["modelValue", "detail-info", "permission"]), i(t(ve), { modelValue: A.value, "onUpdate:modelValue": l[1] || (l[1] = (e) => A.value = e), currentRow: y.value, propertyType: t(o).query.propertyType, onSuccess: t(o).toQuery }, null, 8, ["modelValue", "currentRow", "propertyType", "onSuccess"]), i(t(_e), { modelValue: C.value, "onUpdate:modelValue": l[2] || (l[2] = (e) => C.value = e), currentRow: y.value, tabName: D.value, propertyType: t(o).query.propertyType, onSuccess: t(o).toQuery, permission: t(v) }, null, 8, ["modelValue", "currentRow", "tabName", "propertyType", "onSuccess", "permission"]), i(t(be), { modelValue: x.value, "onUpdate:modelValue": l[3] || (l[3] = (e) => x.value = e), "detail-info": y.value, showType: E.value, onSuccess: t(o).toQuery }, null, 8, ["modelValue", "detail-info", "showType", "onSuccess"]), i(t(de))]);
  };
} }, et = ne(Re, [["__scopeId", "data-v-3eecc8a4"]]);
export {
  et as default
};
