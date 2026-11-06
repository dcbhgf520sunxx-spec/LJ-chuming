import { ref as y } from "vue";
import { computed as z } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as x } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as Q } from "vue";
import { createBlock as u } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as s } from "vue";
import { createSlots as B } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElBadge as G } from "element-plus";
import { InfoFilled as K } from "@element-plus/icons-vue";
import { ElIcon as J } from "element-plus";
import { ElTooltip as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { _ as Y, t as Z, x as ee, o as te, br as oe, iF as ne, bV as A, G as d, P as ae, a as le } from "../../../../../shared/runtime.js";
import { c as ie } from "../../../../../modules/payment-list-f26a95c8.js";
import { I as f } from "../../../../../modules/contract-9b18cc88.js";
import re from "./module/header.vue.js";
import se from "./module/payment-and-invoice/index.vue.js";
import ue from "./module/payment-audit/index.vue.js";
import ce from "../../../../project-manage/subcontract-manage/subcontract-payment/module/settle-form.vue.js";
import "./module/payment-and-invoice/payment/index.vue.js";
import "../../../../../modules/pay-9ccccafb.js";
import "./module/payment-and-invoice/invoice/index.vue.js";
import "../../../../../modules/invoice-bc8acad8.js";
import "./module/payment-and-invoice/invoice/form.vue.js";
import "../../../../../modules/UploadBtn-b4cfb47a.js";
import "./module/payment-audit/list.vue.js";
import "./module/payment-audit/detail.vue.js";
import "../../../../../modules/payment-application-18cdaf45.js";
import "../../../../../modules/collection-9275714a.js";
const me = { class: "app-container" }, pe = { class: "head-container" }, de = ["onClick"], fe = ["onClick"], ye = { style: { display: "inline-block" } }, _e = ["onClick"], ve = ["onClick"], we = { style: { display: "inline-block" } }, he = ["onClick"], be = { style: { cursor: "pointer", "margin-right": "10px" } }, ge = { __name: "index", setup(ke) {
  const { decimalPrecision: _ } = Z(), $ = { add: false, edit: false, del: false, download: false }, S = y(), k = y(false), R = y(false), C = y(false), v = y({}), T = y("payment"), V = y("audit"), j = z(() => [["signDate", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"], ["paymentRate", ["to-fixed", 2]], ["invoiceRate", ["to-fixed", 2]], ["amount", ["to-thousand", _.value.contract]], ["paymentAmount", ["to-thousand", _.value.contract]], ["invoiceAmount", ["to-thousand", _.value.contract]]]), { CRUD: U, crud: p, columns: m } = ee({ title: "分包订单", sort: [], permission: { ...f }, optShow: { ...$ }, crudApi: { ...ie }, hasPagination: true }, S), { maxHeight: H } = te({ wrapperBox: ".subcontractOrderManage", paginate: true, extraHeight: 40 });
  function N(r, n) {
    d(f[n].get) && (T.value = n, v.value = r.sourceRow, k.value = true);
  }
  function M(r) {
    d(f.payment.get) && (v.value = r.sourceRow, R.value = true);
  }
  function D(r, n) {
    var o, w, h;
    if (n === "detail") {
      if (!r.sourceRow.settlementAmount || !d(f.settleDetail)) return;
    } else if (!d(f.settleAudit)) return;
    V.value = n, r.sourceRow.unCheckSettlementAmount = (o = r.settlementInfo) == null ? void 0 : o.amount, r.sourceRow.attachmentDTOS = (w = r.settlementInfo) == null ? void 0 : w.attachments, r.sourceRow.settleNotBoolDeduct = !((h = r.settlementInfo) != null && h.boolDeduct), v.value = r.sourceRow, C.value = true;
  }
  return U.HOOK.handleRefresh = (r, { data: n }) => {
    n.content.forEach((o) => {
      o.paymentRate = o.amount ? (o.paymentAmount || 0) / (o.amount || 0) * 100 : 0, o.invoiceRate = o.amount ? (o.invoiceAmount || 0) / (o.amount || 0) * 100 : 0;
    });
  }, (r, n) => {
    const o = L, w = le, h = G, I = K, P = J, E = W, O = F("common-table"), q = X;
    return l(), x("div", me, [c("div", pe, [a(e(re))]), Q((l(), u(O, { ref_key: "tableRef", ref: S, data: e(p).data, "data-format": j.value, "empty-text": e(p).emptyText, "max-height": e(H), style: { width: "100%" } }, { default: i(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }, { default: i(({ row: t, $index: b }) => [a(oe, { show: t.boolSettlementStatus === !!e(ne).SETTLED.V, name: "已结算", color: "#f56c6c" }, null, 8, ["show"]), c("span", null, g(b + 1), 1)]), _: 1 }), e(m).visible("serialNumber") ? (l(), u(o, { "show-overflow-tooltip": "", key: "serialNumber", prop: "serialNumber", label: "分包订单编号", align: "center" })) : s("", true), e(m).visible("signDate") ? (l(), u(o, { "show-overflow-tooltip": "", key: "signDate", prop: "signDate", label: "签订日期", align: "center", width: "100" })) : s("", true), e(m).visible("project") ? (l(), u(o, { "show-overflow-tooltip": "", key: "project", prop: "project", label: "所属项目", "min-width": "130", align: "center" })) : s("", true), e(m).visible("supplierName") ? (l(), u(o, { "show-overflow-tooltip": "", key: "supplierName", prop: "supplierName", label: "分包单位", "min-width": "110", align: "center" })) : s("", true), e(m).visible("amount") ? (l(), u(o, { prop: "amount", key: "amount", label: "合同额", align: "center", "show-overflow-tooltip": "" })) : s("", true), e(m).visible("settlementAmount") ? (l(), u(o, { key: "settlementAmount", prop: "settlementAmount", "show-overflow-tooltip": true, label: "结算额", align: "center" }, { default: i((t) => [c("span", { style: { "margin-right": "10px" }, onClick: (b) => D(t.row, "detail") }, g(t.row.sourceRow.settlementAmount ? e(A)(t.row.sourceRow.settlementAmount, e(_).contract) : "-"), 9, de), e(d)(e(f).settleAudit) && t.row.sourceRow.unCheckSettlementCount > 0 ? (l(), x("span", { key: 0, onClick: (b) => D(t.row, "audit"), style: { cursor: "pointer" } }, [a(h, { value: 1, max: 99, hidden: t.row.sourceRow.unCheckSettlementCount < 1 }, { default: i(() => [a(w, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["hidden"])], 8, fe)) : s("", true)]), _: 1 })) : s("", true), e(m).visible("subcontractClassName") ? (l(), u(o, { "show-overflow-tooltip": "", key: "subcontractClassName", prop: "subcontractClassName", label: "分类", align: "center" })) : s("", true), e(m).visible("paymentAmount") ? (l(), u(o, { prop: "paymentAmount", key: "paymentAmount", label: "付款额", align: "center", "show-overflow-tooltip": "" }, B({ default: i((t) => [c("span", { style: { cursor: "pointer", "margin-right": "10px" }, onClick: (b) => N(t.row, "payment") }, g(t.row.sourceRow.paymentAmount ? e(A)(t.row.sourceRow.paymentAmount, e(_).contract) : "-"), 9, _e), e(d)(e(p).permission.payment.audit) && t.row.unCheckPaymentCount > 0 ? (l(), x("span", { key: 0, onClick: (b) => M(t.row), style: { cursor: "pointer" } }, [a(h, { value: t.row.sourceRow.unCheckPaymentCount, max: 99, hidden: t.row.sourceRow.unCheckPaymentCount < 1 }, { default: i(() => [a(w, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["value", "hidden"])], 8, ve)) : s("", true)]), _: 2 }, [e(d)(e(f).detail) ? { name: "header", fn: i(() => [a(E, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: i(() => [c("div", ye, [n[3] || (n[3] = c("span", null, "付款额 ", -1)), a(P, null, { default: i(() => [a(I)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : s("", true), e(m).visible("paymentRate") ? (l(), u(o, { key: "paymentRate", prop: "paymentRate", label: "付款比例", align: "center", width: "80" }, { default: i((t) => [c("span", null, g(t.row.paymentRate) + "%", 1)]), _: 1 })) : s("", true), e(m).visible("invoiceAmount") ? (l(), u(o, { prop: "invoiceAmount", key: "invoiceAmount", label: "收票额", align: "center", "min-width": "120", "show-overflow-tooltip": "" }, B({ default: i((t) => [c("div", { onClick: (b) => N(t.row, "invoice"), style: { cursor: "pointer" } }, [c("span", be, g(t.row.sourceRow.invoiceAmount ? e(A)(t.row.sourceRow.invoiceAmount, e(_).contract) : "-"), 1), e(d)(e(p).permission.invoice.audit) && t.row.sourceRow.unCheckInvoiceCount > 0 ? (l(), u(h, { key: 0, value: t.row.sourceRow.unCheckInvoiceCount, max: 99, hidden: t.row.sourceRow.unCheckInvoiceCount < 1 }, { default: i(() => [a(w, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["value", "hidden"])) : s("", true)], 8, he)]), _: 2 }, [e(d)(e(f).detail) ? { name: "header", fn: i(() => [a(E, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: i(() => [c("div", we, [n[4] || (n[4] = c("span", null, "收票额 ", -1)), a(P, null, { default: i(() => [a(I)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : s("", true), e(m).visible("invoiceRate") ? (l(), u(o, { key: "invoiceRate", prop: "invoiceRate", label: "收票比例", align: "center", width: "80" }, { default: i((t) => [c("span", null, g(t.row.invoiceRate) + "%", 1)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[q, e(p).loading]]), a(e(ue), { modelValue: R.value, "onUpdate:modelValue": n[0] || (n[0] = (t) => R.value = t), currentRow: v.value, propertyType: e(p).query.propertyType, onSuccess: e(p).toQuery }, null, 8, ["modelValue", "currentRow", "propertyType", "onSuccess"]), a(e(se), { modelValue: k.value, "onUpdate:modelValue": n[1] || (n[1] = (t) => k.value = t), currentRow: v.value, tabName: T.value, propertyType: e(p).query.propertyType, onSuccess: e(p).toQuery, permission: e(f) }, null, 8, ["modelValue", "currentRow", "tabName", "propertyType", "onSuccess", "permission"]), a(e(ce), { modelValue: C.value, "onUpdate:modelValue": n[2] || (n[2] = (t) => C.value = t), "detail-info": v.value, showType: V.value, onSuccess: e(p).toQuery }, null, 8, ["modelValue", "detail-info", "showType", "onSuccess"]), a(e(ae))]);
  };
} }, Oe = Y(ge, [["__scopeId", "data-v-5d4bc76c"]]);
export {
  Oe as default
};
