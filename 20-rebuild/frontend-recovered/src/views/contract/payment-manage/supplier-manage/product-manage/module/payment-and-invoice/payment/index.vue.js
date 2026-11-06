import { ref as h } from "vue";
import { watch as M } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as o } from "vue";
import { createBlock as w } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as T } from "vue";
import { toDisplayString as r } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as f } from "vue";
import { withDirectives as F } from "vue";
import { createVNode as n } from "vue";
import { Fragment as H } from "vue";
import { renderList as $ } from "vue";
import { ElTag as j } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { InfoFilled as z } from "@element-plus/icons-vue";
import { ElIcon as Q } from "element-plus";
import { ElTooltip as O } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as J } from "../../../../../../../../modules/pay-9ccccafb.js";
import { _ as K, t as W, g8 as X, x as Y, o as Z, jF as ee, c3 as te, bV as b, p as R, ia as ae, iv as ne, P as oe, iy as le, ba as re } from "../../../../../../../../shared/runtime.js";
import { H as ie } from "../../../../../../../../modules/contract-9b18cc88.js";
const pe = { class: "app-container" }, se = ["onDblclick"], ue = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false }, propertyType: { type: [Number, String], default: void 0 } }, setup(u) {
  const S = ie.payment, { decimalPrecision: m } = W(), B = { add: false, edit: false, del: false, download: false }, g = u, k = h(), d = X(["payment_reason"]), c = h(false), x = h(), { crud: i } = Y({ title: "付款记录", sort: [], permission: { ...S }, optShow: { ...B }, crudApi: { ...J }, requiredQuery: ["orderId", "propertyType", "auditStatus"], invisibleColumns: ["haveApplyAmount", "collectionMode", "collectionReason", "collectionDepositBank", "collectionBankAccount", "paymentBankAccount", "paymentDepositBank", "auditorName", "auditTime"], hasPagination: true }, k), { maxHeight: D } = Z({ wrapperBox: ".material-payment", paginate: true, extraHeight: 40 });
  M(() => g.visibleValue, (s) => {
    s && (i.query.orderId = g.currentRow.id, i.query.propertyType = ee.PURCHASE.V, i.query.auditStatus = te.PASS.V, i.toQuery());
  }, { deep: true, immediate: true });
  function U(s) {
    x.value = s.id, c.value = true;
  }
  function V(s) {
    return re(s, { props: [["applyAmount", m.value.contract]], toThousandFields: ["applyAmount"] });
  }
  return (s, y) => {
    const A = j, l = L, N = z, E = Q, I = O, P = q("common-table"), C = G;
    return p(), v("div", pe, [o("div", null, [u.currentRow.amount ? (p(), w(A, { key: 0, type: "success", size: "large" }, { default: a(() => [T(r(`合同额:${t(b)(u.currentRow.amount, t(m).contract)}`), 1)]), _: 1 })) : f("", true), u.currentRow.settlementAmount ? (p(), w(A, { key: 1, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: a(() => [T(r(`结算额:${t(b)(u.currentRow.settlementAmount, t(m).contract)}`), 1)]), _: 1 })) : f("", true)]), F((p(), w(P, { ref_key: "tableRef", ref: k, data: t(i).data, "empty-text": t(i).emptyText, "max-height": t(D), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": V, stripe: false }, { default: a(() => [n(l, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), n(l, { key: "paymentDate", prop: "paymentDate", label: "*付款日期", align: "center", width: "160" }, { default: a((e) => [o("div", null, r(e.row.paymentDate ? t(R)(e.row.paymentDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), n(l, { key: "applyAmount1", prop: "applyAmount1", label: "*付款金额", align: "center", "min-width": "170", class: "money-column" }, { default: a(() => [n(l, { key: "applyAmount", prop: "applyAmount", label: "金额", align: "center", "min-width": "85" }, { default: a((e) => [o("div", null, r(e.row.applyAmount && e.row.applyAmount > 0 ? t(b)(e.row.applyAmount, t(m).contract) : e.row.applyAmount), 1)]), _: 1 }), n(l, { key: "applyAmount2", prop: "applyAmount2", label: "大写", align: "center", "min-width": "85" }, { default: a((e) => [o("div", null, r(e.row.applyAmount ? "(" + t(ae)(e.row.applyAmount) + ")" : ""), 1)]), _: 1 })]), _: 1 }), n(l, { key: "paymentReasonId", prop: "paymentReasonId", label: "*付款事由", align: "center", "show-overflow-tooltip": true }, { default: a((e) => [o("div", null, r(e.row.paymentReasonId && t(d) && t(d).label && t(d).label.payment_reason ? t(d).label.payment_reason[e.row.paymentReasonId] : ""), 1)]), _: 1 }), n(l, { key: "paymentMethod", prop: "paymentMethod", label: "*付款方式", align: "center", "show-overflow-tooltip": true }, { default: a((e) => [o("div", null, r(e.row.paymentMethod ? t(ne).VL[e.row.paymentMethod] : "-"), 1)]), _: 1 }), n(l, { key: "paymentBank", prop: "paymentBank", "show-overflow-tooltip": true, label: "*付款银行", align: "center" }, { default: a((e) => [o("div", null, r(e.row.paymentBank ? e.row.paymentBank : "-"), 1)]), _: 1 }), n(l, { key: "paymentUnit", prop: "paymentUnit", label: "*收款单位", align: "center", "show-overflow-tooltip": true }, { default: a((e) => [o("div", null, r(e.row.paymentUnit ? e.row.paymentUnit : "-"), 1)]), _: 1 }), n(l, { key: "attachments", prop: "attachments", label: "附件", align: "center", "show-overflow-tooltip": true }, { header: a(() => [n(I, { effect: "light", content: "双击可预览附件", placement: "top" }, { default: a(() => [o("div", null, [y[1] || (y[1] = o("span", null, "附件", -1)), n(E, null, { default: a(() => [n(N)]), _: 1 })])]), _: 1 })]), default: a((e) => [e.row.attachments && e.row.attachments.length > 0 ? (p(true), v(H, { key: 0 }, $(e.row.attachments, (_) => (p(), v("div", { key: _.id }, [o("div", { style: { cursor: "pointer" }, onDblclick: (me) => U(_) }, r(_.name), 41, se)]))), 128)) : f("", true)]), _: 1 }), n(l, { key: "applyUserName", prop: "applyUserName", label: "办理人", align: "center", width: "100px" }, { default: a((e) => [o("div", null, r(e.row.applyUserName), 1)]), _: 1 }), n(l, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center", width: "100px" }, { default: a((e) => [o("div", null, r(e.row.auditUserName), 1)]), _: 1 }), n(l, { key: "auditTime", prop: "auditTime", label: "审核日期", align: "center", width: "100px" }, { default: a((e) => [o("div", null, r(e.row.auditTime ? t(R)(e.row.auditTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[C, t(i).loading]]), n(t(oe)), c.value ? (p(), w(le, { key: 0, isVisible: c.value, showType: "attachment", id: x.value, onClose: y[0] || (y[0] = (e) => c.value = false) }, null, 8, ["isVisible", "id"])) : f("", true)]);
  };
} }, fe = K(ue, [["__scopeId", "data-v-20ee70db"]]);
export {
  fe as default
};
