import { ref as v } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as m } from "vue";
import { unref as t } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as i } from "vue";
import { withCtx as a } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as l } from "vue";
import { createTextVNode as O } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { ElBadge as j } from "element-plus";
import { ElTag as G } from "element-plus";
import { vLoading as K } from "element-plus";
import { _ as Y, t as J, x as W, o as X, br as Z, iF as V, p as ee, bv as te, am as ne, bV as b, G as f, D as oe, i as ae, P as ie, a as le } from "../../../../../shared/runtime.js";
import { c as re } from "../../../../../modules/material-manage-f1c542ef.js";
import { H as _ } from "../../../../../modules/contract-9b18cc88.js";
import ue from "./module/payment-audit/index.vue.js";
import se from "../../../../supply-chain/purchase-reconciliation-manage/payment-ledger/module/settle-form.vue.js";
import me from "./module/header.vue.js";
import ce from "../../../../supply-chain/purchase-reconciliation-manage/payment-ledger/module/inbound-record.vue.js";
import de from "./module/payment-and-invoice/index.vue.js";
import "./module/payment-audit/list.vue.js";
import "../../../../../modules/pay-9ccccafb.js";
import "./module/payment-audit/detail.vue.js";
import "../../../../../modules/collection-9275714a.js";
import "../../../../../modules/payment-application-502afb4b.js";
import "../../../../../modules/UploadBtn-b4cfb47a.js";
import "../../../../../modules/payment-ledger-cb1d373c.js";
import "./module/payment-and-invoice/payment/index.vue.js";
import "./module/payment-and-invoice/invoice/index.vue.js";
import "../../../../../modules/invoice-bc8acad8.js";
import "./module/payment-and-invoice/invoice/form.vue.js";
const pe = { class: "app-container" }, ye = { class: "head-container" }, ve = ["onClick"], fe = ["onClick"], _e = ["onClick"], we = ["onClick"], be = ["onClick"], he = ["onClick"], ge = { style: { cursor: "pointer", "margin-right": "10px" } }, ke = { key: 1 }, Ce = { __name: "index", setup(Ae) {
  const { decimalPrecision: h } = J(), q = { add: false, edit: false, del: false, download: false }, N = v(), k = v(false), C = v(false), A = v(false), x = v(false), y = v({}), R = v("payment"), D = v("audit"), { CRUD: $, crud: o, columns: d } = W({ title: "制成品", sort: [], permission: { ..._ }, optShow: { ...q }, crudApi: { ...re }, hasPagination: true }, N), { maxHeight: B } = X({ wrapperBox: ".productManage", paginate: true, extraHeight: 40 });
  function U(p) {
    f(_.inbound.get) && (y.value = p, k.value = true);
  }
  function E(p, r) {
    f(_[r].get) && (R.value = r, y.value = p, C.value = true);
  }
  function H(p) {
    f(_.payment.get) && (y.value = p, A.value = true);
  }
  function P(p, r) {
    if (r === "detail") {
      if (!p.settlementAmount || !f(_.settleDetail)) return;
    } else if (!f(_.settleAudit)) return;
    D.value = r, y.value = p, x.value = true;
  }
  return $.HOOK.beforeRefresh = () => {
    o.query.createTime && o.query.createTime.length > 0 ? (o.query.startDate = o.query.createTime[0], o.query.endDate = o.query.createTime[1]) : (o.query.startDate = void 0, o.query.endDate = void 0);
  }, (p, r) => {
    const s = Q, T = le, S = j, I = G, L = z("common-table"), M = K;
    return n(), g("div", pe, [u("div", ye, [m(t(me))]), F((n(), i(L, { ref_key: "tableRef", ref: N, data: t(o).data, "empty-text": t(o).emptyText, "max-height": t(B), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: a(() => [m(s, { label: "序号", type: "index", align: "center", width: "60" }, { default: a((e) => [m(Z, { show: e.row.settlementStatus === t(V).SETTLED.V, name: "已结算", color: "#f56c6c" }, null, 8, ["show"]), u("span", null, c(e.$index + 1), 1)]), _: 1 }), t(d).visible("serialNumber") ? (n(), i(s, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "采购合同编号", align: "center" }, { default: a((e) => [u("span", null, c(e.row.serialNumber), 1)]), _: 1 })) : l("", true), t(d).visible("createTime") ? (n(), i(s, { key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "签订日期", align: "center", width: "80" }, { default: a((e) => [u("div", null, c(e.row.createTime ? t(ee)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : l("", true), t(d).visible("supplierName") ? (n(), i(s, { key: "supplierName", prop: "supplierName", label: "供应商", align: "center" }, { default: a((e) => [u("div", null, c(e.row.supplierName ? e.row.supplierName : "-"), 1)]), _: 1 })) : l("", true), t(d).visible("basicClass") ? (n(), i(s, { key: "basicClass", prop: "basicClass", "show-overflow-tooltip": true, label: "种类", align: "center" }, { default: a((e) => [u("div", null, c(e.row.basicClass ? t(te).getBits(t(ne).ENUM, e.row.basicClass, "L").join("|") : ""), 1)]), _: 1 })) : l("", true), t(d).visible("amount") ? (n(), i(s, { key: "amount", prop: "amount", label: "合同额", align: "center" }, { default: a((e) => [u("span", null, c(e.row.amount ? t(b)(e.row.amount, t(h).contract) : "-"), 1)]), _: 1 })) : l("", true), t(d).visible("settlementAmount") ? (n(), i(s, { key: "settlementAmount", prop: "settlementAmount", "show-overflow-tooltip": true, label: "结算额", align: "center" }, { default: a((e) => [u("span", { style: { "margin-right": "10px" }, onClick: (w) => P(e.row, "detail") }, c(e.row.settlementAmount ? t(b)(e.row.settlementAmount, t(h).contract) : "-"), 9, ve), t(f)(t(_).settleAudit) && e.row.unCheckSettlementCount > 0 ? (n(), g("span", { key: 0, onClick: (w) => P(e.row, "audit"), style: { cursor: "pointer" } }, [m(S, { value: 1, max: 99, hidden: e.row.unCheckSettlementCount < 1 }, { default: a(() => [m(T, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["hidden"])], 8, fe)) : l("", true)]), _: 1 })) : l("", true), t(d).visible("inboundAmount") ? (n(), i(s, { key: "inboundAmount", prop: "inboundAmount", label: "入库额", align: "center" }, { default: a((e) => [u("span", { onClick: (w) => U(e.row) }, c(e.row.inboundAmount ? t(b)(e.row.inboundAmount, t(oe).YUAN) : "-"), 9, _e)]), _: 1 })) : l("", true), t(d).visible("paymentAmount") ? (n(), i(s, { key: "paymentAmount", prop: "paymentAmount", label: "付款额", align: "center" }, { default: a((e) => [u("span", { style: { cursor: "pointer", "margin-right": "10px" }, onClick: (w) => E(e.row, "payment") }, c(e.row.paymentAmount ? t(b)(e.row.paymentAmount, t(h).contract) : "-"), 9, we), t(f)(t(o).permission.payment.get) && e.row.unCheckPaymentCount > 0 ? (n(), g("span", { key: 0, onClick: (w) => H(e.row), style: { cursor: "pointer" } }, [m(S, { value: e.row.unCheckPaymentCount, max: 99, hidden: e.row.unCheckPaymentCount < 1 }, { default: a(() => [m(T, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["value", "hidden"])], 8, be)) : l("", true)]), _: 1 })) : l("", true), t(d).visible("paymentAmountRate") ? (n(), i(s, { key: "paymentAmountRate", prop: "paymentAmountRate", label: "付款比例", align: "center" }, { default: a((e) => [u("div", null, c(e.row.inboundAmount ? (e.row.paymentAmount / e.row.inboundAmount * 100).toFixed(2) + "%" : "0.00%"), 1)]), _: 1 })) : l("", true), t(d).visible("invoiceAmount") ? (n(), i(s, { key: "invoiceAmount", prop: "invoiceAmount", label: "收票额", align: "center" }, { default: a((e) => [u("div", { onClick: (w) => E(e.row, "invoice"), style: { cursor: "pointer" } }, [u("span", ge, c(e.row.invoiceAmount ? t(b)(e.row.invoiceAmount, t(h).contract) : "-"), 1), t(f)(t(o).permission.invoice.get) && e.row.unCheckInvoiceCount > 0 ? (n(), i(S, { key: 0, value: e.row.unCheckInvoiceCount, max: 99, hidden: e.row.unCheckInvoiceCount < 1 }, { default: a(() => [m(T, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["value", "hidden"])) : l("", true)], 8, he)]), _: 1 })) : l("", true), t(d).visible("invoiceRate") ? (n(), i(s, { key: "invoiceRate", prop: "invoiceRate", label: "收票比例", align: "center" }, { default: a((e) => [u("div", null, c(e.row.inboundAmount ? (e.row.invoiceAmount / e.row.inboundAmount * 100).toFixed(2) + "%" : "0.00%"), 1)]), _: 1 })) : l("", true), t(d).visible("settlementStatus") ? (n(), i(s, { key: "settlementStatus", prop: "settlementStatus", label: "结算状态", align: "center", width: "80px" }, { default: a((e) => [t(ae)(e.row.settlementStatus) ? (n(), i(I, { key: 0, type: e.row.settlementStatus === t(V).SETTLED.V ? "success" : "warning", effect: "plain" }, { default: a(() => [O(c(t(V).VL[e.row.settlementStatus]), 1)]), _: 2 }, 1032, ["type"])) : (n(), g("span", ke, "-"))]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[M, t(o).loading]]), m(t(ce), { modelValue: k.value, "onUpdate:modelValue": r[0] || (r[0] = (e) => k.value = e), "detail-info": y.value }, null, 8, ["modelValue", "detail-info"]), m(t(ue), { modelValue: A.value, "onUpdate:modelValue": r[1] || (r[1] = (e) => A.value = e), currentRow: y.value, propertyType: t(o).query.propertyType, onSuccess: t(o).toQuery }, null, 8, ["modelValue", "currentRow", "propertyType", "onSuccess"]), m(t(de), { modelValue: C.value, "onUpdate:modelValue": r[2] || (r[2] = (e) => C.value = e), currentRow: y.value, tabName: R.value, propertyType: t(o).query.propertyType, onSuccess: t(o).toQuery }, null, 8, ["modelValue", "currentRow", "tabName", "propertyType", "onSuccess"]), m(t(se), { modelValue: x.value, "onUpdate:modelValue": r[3] || (r[3] = (e) => x.value = e), "detail-info": y.value, showType: D.value, onSuccess: t(o).toQuery }, null, 8, ["modelValue", "detail-info", "showType", "onSuccess"]), m(t(ie))]);
  };
} }, Qe = Y(Ce, [["__scopeId", "data-v-f14c6750"]]);
export {
  Qe as default
};
