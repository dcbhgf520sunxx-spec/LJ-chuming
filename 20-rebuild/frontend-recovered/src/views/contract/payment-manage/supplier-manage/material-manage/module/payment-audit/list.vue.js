import { ref as w } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as G } from "vue";
import { createElementVNode as u } from "vue";
import { createBlock as m } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as i } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as b } from "vue";
import { withDirectives as C } from "vue";
import { createVNode as n } from "vue";
import { ElTag as J } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { vLoading as W } from "element-plus";
import { c as X } from "../../../../../../../modules/pay-9ccccafb.js";
import { _ as Y, t as Z, x as ee, o as te, jF as ae, bV as v, p as P, ia as re, c3 as g, i as k, G as U, P as le, fK as ne, ba as ie } from "../../../../../../../shared/runtime.js";
import { D as oe } from "../../../../../../../modules/contract-9b18cc88.js";
import ue from "./detail.vue.js";
import "../../../../../../../modules/collection-9275714a.js";
const se = { class: "app-container" }, ce = { __name: "list", props: { currentRow: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false }, propertyType: { type: [Number, String], default: void 0 } }, emits: ["success"], setup(s, { emit: I }) {
  const { decimalPrecision: y } = Z(), f = oe.payment, q = { add: false, edit: false, del: false, download: false }, A = s, T = w(), x = w({}), S = w("detail"), _ = w(false), D = I, { crud: d } = ee({ title: "付款审核", sort: [], permission: { ...f }, optShow: { ...q }, requiredQuery: ["orderId", "propertyType"], crudApi: { ...X }, hasPagination: true }, T), E = { collectionDate: [{ required: true, message: "请选择付款日期", trigger: "change" }], collectionAmount: [{ required: true, message: "请选择付款金额", trigger: "change", type: "number" }], collectionBankAccountId: [{ required: true, message: "请选择付款银行", trigger: "change" }], collectionMode: [{ required: true, message: "请选择付款方式", trigger: "change" }], collectionReason: [{ required: true, message: "请选择付款事由", trigger: "change" }], paymentUnit: [{ required: true, message: "请输入付款单位", trigger: "blur" }] };
  function B({ row: l, column: o }) {
    if (!l) return;
    const p = E;
    let a = true;
    return l.verify && Object.keys(l.verify) && Object.keys(l.verify).length > 0 && (l.verify[o.property] === false && (a = ne(o.property, p[o.property], l)), a && (l.verify[o.property] = true)), a ? "" : "mask-td";
  }
  const { maxHeight: M } = te({ wrapperBox: ".collection", paginate: true, extraHeight: 40 });
  Q(() => A.visibleValue, (l) => {
    l && (d.query.orderId = A.currentRow.id, d.query.propertyType = ae.PURCHASE.V, d.toQuery());
  }, { deep: true, immediate: true });
  function R(l, o) {
    x.value = l, S.value = o, _.value = true;
  }
  function j() {
    D("success"), d.toQuery();
  }
  function z(l) {
    return ie(l, { props: [["applyAmount", y.value.contract]], toThousandFields: ["applyAmount"] });
  }
  return (l, o) => {
    const p = J, a = K, N = V("common-button"), H = V("common-table"), $ = F("permission"), L = W;
    return c(), G("div", se, [u("div", null, [s.currentRow.amount ? (c(), m(p, { key: 0, type: "success", size: "large" }, { default: r(() => [h(i(`合同额:${t(v)(s.currentRow.amount, t(y).contract)}`), 1)]), _: 1 })) : b("", true), s.currentRow.settlementAmount ? (c(), m(p, { key: 1, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: r(() => [h(i(`结算额:${t(v)(s.currentRow.settlementAmount, t(y).contract)}`), 1)]), _: 1 })) : b("", true)]), C((c(), m(H, { ref_key: "tableRef", ref: T, data: t(d).data, "empty-text": t(d).emptyText, "max-height": t(M), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", "cell-class-name": B, "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": z, stripe: false }, { default: r(() => [n(a, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), n(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "采购合同编号", align: "center" }, { default: r((e) => [u("span", null, i(e.row.serialNumber || s.currentRow.serialNumber), 1)]), _: 1 }), n(a, { key: "applyUserName", prop: "applyUserName", label: "申请人", align: "center", width: "100px" }, { default: r((e) => [u("div", null, i(e.row.applyUserName), 1)]), _: 1 }), n(a, { key: "createTime", prop: "createTime", label: "申请日期", align: "center", width: "160" }, { default: r((e) => [u("div", null, i(e.row.createTime ? t(P)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), n(a, { key: "applyAmount", prop: "applyAmount", label: "申请金额", align: "center", "min-width": "85" }, { default: r((e) => [u("div", null, i(e.row.applyAmount && e.row.applyAmount > 0 ? t(v)(e.row.applyAmount, t(y).contract) : e.row.applyAmount), 1)]), _: 1 }), n(a, { key: "applyAmount1", prop: "applyAmount1", label: "大写", align: "center", "min-width": "85" }, { default: r((e) => [u("div", null, i(e.row.applyAmount && e.row.applyAmount > 0 ? t(re)(e.row.applyAmount) : "-"), 1)]), _: 1 }), n(a, { key: "auditStatus", prop: "auditStatus", label: "状态", align: "center", width: "90px" }, { default: r((e) => [e.row.auditStatus === t(g).PASS.V ? (c(), m(p, { key: 0, type: "success", effect: "plain" }, { default: r(() => [h(i(t(k)(e.row.auditStatus) ? t(g).VL[e.row.auditStatus] : "-"), 1)]), _: 2 }, 1024)) : (c(), m(p, { key: 1, type: e.row.auditStatus === t(g).REJECT.V ? "warning" : "primary", effect: "plain" }, { default: r(() => [h(i(t(k)(e.row.auditStatus) ? t(g).VL[e.row.auditStatus] : "-"), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 }), n(a, { key: "actuallyPaymentAmount", prop: "actuallyPaymentAmount", label: "实付金额", align: "center", "min-width": "85" }, { default: r((e) => [u("div", null, i(t(k)(e.row.actuallyPaymentAmount) ? t(v)(e.row.actuallyPaymentAmount, t(y).contract) : "-"), 1)]), _: 1 }), n(a, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center", width: "100px" }, { default: r((e) => [u("div", null, i(e.row.auditUserName), 1)]), _: 1 }), n(a, { key: "auditTime", prop: "auditTime", label: "审核日期", align: "center", width: "160" }, { default: r((e) => [u("div", null, i(e.row.auditTime ? t(P)(e.row.auditTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), t(U)([...t(f).detail, ...t(f).audit]) ? (c(), m(a, { key: 0, label: "操作", width: "190px", align: "center" }, { default: r((e) => [C(n(N, { icon: "el-icon-view", type: "primary", size: "default", onClick: (O) => R(e.row, "detail") }, null, 8, ["onClick"]), [[$, t(f).detail]]), e.row.auditStatus == t(g).ENUM.AUDITING.V && t(U)(t(f).audit) ? (c(), m(N, { key: 0, icon: "el-icon-stamp", type: "primary", size: "default", onClick: (O) => R(e.row, "audit") }, null, 8, ["onClick"])) : b("", true)]), _: 1 })) : b("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[L, t(d).loading]]), n(t(le)), n(t(ue), { modelValue: _.value, "onUpdate:modelValue": o[0] || (o[0] = (e) => _.value = e), showType: S.value, detailInfo: x.value, branchCompanyId: s.currentRow.branchCompanyId, onSuccess: j, currentRow: s.currentRow }, null, 8, ["modelValue", "showType", "detailInfo", "branchCompanyId", "currentRow"])]);
  };
} }, we = Y(ce, [["__scopeId", "data-v-33930864"]]);
export {
  we as default
};
