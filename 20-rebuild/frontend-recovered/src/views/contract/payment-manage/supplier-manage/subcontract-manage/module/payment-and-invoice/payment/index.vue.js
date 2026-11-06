import { ref as v } from "vue";
import { watch as q } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as o } from "vue";
import { createBlock as w } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as T } from "vue";
import { toDisplayString as r } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as f } from "vue";
import { withDirectives as $ } from "vue";
import { createVNode as n } from "vue";
import { Fragment as j } from "vue";
import { renderList as H } from "vue";
import { ElTag as L } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { InfoFilled as O } from "@element-plus/icons-vue";
import { ElIcon as Q } from "element-plus";
import { ElTooltip as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { c as K } from "../../../../../../../../modules/pay-9ccccafb.js";
import { _ as W, t as X, g8 as Y, x as Z, o as ee, jF as te, c3 as ae, bV as _, p as B, i as S, ia as ne, iv as oe, P as le, iy as re, ba as ie } from "../../../../../../../../shared/runtime.js";
import { I as ue } from "../../../../../../../../modules/contract-9b18cc88.js";
const se = { class: "app-container" }, pe = ["onDblclick"], me = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false }, propertyType: { type: [Number, String], default: void 0 } }, setup(p) {
  const R = ue.payment, { decimalPrecision: m } = X(), D = { add: false, edit: false, del: false, download: false }, b = p, k = v(), d = Y(["payment_reason"]), c = v(false), A = v(), { crud: i } = Z({ title: "付款记录", sort: [], permission: { ...R }, optShow: { ...D }, crudApi: { ...K }, requiredQuery: ["orderId", "propertyType", "auditStatus"], invisibleColumns: ["haveApplyAmount", "collectionMode", "collectionReason", "collectionDepositBank", "collectionBankAccount", "paymentBankAccount", "paymentDepositBank", "auditorName", "auditTime"], hasPagination: true }, k), { maxHeight: N } = ee({ wrapperBox: ".subcontract-payment", paginate: true, extraHeight: 40 });
  q(() => b.visibleValue, (s) => {
    s && (i.query.orderId = b.currentRow.id, i.query.propertyType = te.SUBCONTRACT.V, i.query.auditStatus = ae.PASS.V, i.toQuery());
  }, { deep: true, immediate: true });
  function P(s) {
    A.value = s.id, c.value = true;
  }
  function U(s) {
    return ie(s, { props: [["applyAmount", m.value.contract]], toThousandFields: ["applyAmount"] });
  }
  return (s, y) => {
    const x = L, l = z, V = O, I = Q, C = G, E = F("common-table"), M = J;
    return u(), g("div", se, [o("div", null, [p.currentRow.amount ? (u(), w(x, { key: 0, type: "success", size: "large" }, { default: a(() => [T(r(`合同额:${t(_)(p.currentRow.amount, t(m).contract)}`), 1)]), _: 1 })) : f("", true), p.currentRow.settlementAmount ? (u(), w(x, { key: 1, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: a(() => [T(r(`结算额:${t(_)(p.currentRow.settlementAmount, t(m).contract)}`), 1)]), _: 1 })) : f("", true)]), $((u(), w(E, { ref_key: "tableRef", ref: k, data: t(i).data, "empty-text": t(i).emptyText, "max-height": t(N), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": U, stripe: false }, { default: a(() => [n(l, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), n(l, { key: "paymentDate", prop: "paymentDate", label: "付款日期", align: "center", width: "160" }, { default: a((e) => [o("div", null, r(e.row.paymentDate ? t(B)(e.row.paymentDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), n(l, { key: "applyAmount1", prop: "applyAmount1", label: "付款金额", align: "center", "min-width": "170", class: "money-column" }, { default: a(() => [n(l, { key: "applyAmount", prop: "applyAmount", label: "申请金额", align: "center", "min-width": "85" }, { default: a((e) => [o("div", null, r(t(S)(e.row.applyAmount) ? t(_)(e.row.applyAmount, t(m).contract) : e.row.applyAmount), 1)]), _: 1 }), n(l, { key: "applyAmount2", prop: "applyAmount2", label: "大写", align: "center", "min-width": "85" }, { default: a((e) => [o("div", null, r(e.row.applyAmount ? t(ne)(e.row.applyAmount) : ""), 1)]), _: 1 })]), _: 1 }), n(l, { key: "actuallyPaymentAmount", prop: "actuallyPaymentAmount", label: "实际付款额", align: "center", "min-width": "85" }, { default: a((e) => [o("div", null, r(t(S)(e.row.actuallyPaymentAmount) ? t(_)(e.row.actuallyPaymentAmount, t(m).contract) : e.row.actuallyPaymentAmount), 1)]), _: 1 }), n(l, { key: "paymentReasonId", prop: "paymentReasonId", label: "付款事由", align: "center", "show-overflow-tooltip": true }, { default: a((e) => [o("div", null, r(e.row.paymentReasonId && t(d) && t(d).label && t(d).label.payment_reason ? t(d).label.payment_reason[e.row.paymentReasonId] : ""), 1)]), _: 1 }), n(l, { key: "paymentMethod", prop: "paymentMethod", label: "付款方式", align: "center", "show-overflow-tooltip": true }, { default: a((e) => [o("div", null, r(e.row.paymentMethod ? t(oe).VL[e.row.paymentMethod] : "-"), 1)]), _: 1 }), n(l, { key: "paymentBank", prop: "paymentBank", "show-overflow-tooltip": true, label: "付款银行", align: "center" }, { default: a((e) => [o("div", null, r(e.row.paymentBank ? e.row.paymentBank : "-"), 1)]), _: 1 }), n(l, { key: "receivingUnit", prop: "receivingUnit", label: "收款单位", align: "center", "show-overflow-tooltip": true }, { default: a((e) => [o("div", null, r(e.row.receivingUnit ? e.row.receivingUnit : "-"), 1)]), _: 1 }), n(l, { key: "attachments", prop: "attachments", label: "附件", align: "center", "show-overflow-tooltip": true }, { header: a(() => [n(C, { effect: "light", content: "双击可预览附件", placement: "top" }, { default: a(() => [o("div", null, [y[1] || (y[1] = o("span", null, "附件", -1)), n(I, null, { default: a(() => [n(V)]), _: 1 })])]), _: 1 })]), default: a((e) => [e.row.attachments && e.row.attachments.length > 0 ? (u(true), g(j, { key: 0 }, H(e.row.attachments, (h) => (u(), g("div", { key: h.id }, [o("div", { style: { cursor: "pointer" }, onDblclick: (de) => P(h) }, r(h.name), 41, pe)]))), 128)) : f("", true)]), _: 1 }), n(l, { key: "applyUserName", prop: "applyUserName", label: "办理人", align: "center", width: "100px" }, { default: a((e) => [o("div", null, r(e.row.applyUserName), 1)]), _: 1 }), n(l, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center", width: "100px" }, { default: a((e) => [o("div", null, r(e.row.auditUserName), 1)]), _: 1 }), n(l, { key: "auditTime", prop: "auditTime", label: "审核日期", align: "center", width: "100px" }, { default: a((e) => [o("div", null, r(e.row.auditTime ? t(B)(e.row.auditTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[M, t(i).loading]]), n(t(le)), c.value ? (u(), w(re, { key: 0, isVisible: c.value, showType: "attachment", id: A.value, onClose: y[0] || (y[0] = (e) => c.value = false) }, null, 8, ["isVisible", "id"])) : f("", true)]);
  };
} }, _e = W(me, [["__scopeId", "data-v-5bf0d942"]]);
export {
  _e as default
};
