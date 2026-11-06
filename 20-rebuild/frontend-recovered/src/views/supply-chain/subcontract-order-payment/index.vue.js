import { computed as E } from "vue";
import { ref as m } from "vue";
import { provide as F } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as n } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as i } from "vue";
import { createSlots as S } from "vue";
import { withModifiers as V } from "vue";
import { resolveDynamicComponent as O } from "vue";
import { nextTick as q } from "vue";
import { ElTableColumn as G } from "element-plus";
import { InfoFilled as K } from "@element-plus/icons-vue";
import { ElIcon as z } from "element-plus";
import { ElTooltip as J } from "element-plus";
import { vLoading as Q } from "element-plus";
import { c as W } from "../../../modules/payment-list-f26a95c8.js";
import { _ as X, t as Y, x as Z, wH as u, o as ee, br as te, iF as oe, G as f, P as ae } from "../../../shared/runtime.js";
import ne from "./module/header.vue.js";
import ie from "./module/invoice-record.vue.js";
import le from "./module/payment-record.vue.js";
import "../../../modules/payment-ledger-cb1d373c.js";
const se = { class: "app-container" }, re = { style: { display: "inline-block" } }, ce = ["onClick"], pe = { style: { display: "inline-block" } }, ue = ["onClick"], me = { __name: "index", setup(de) {
  const { decimalPrecision: v } = Y(), T = { add: false, edit: false, del: false, download: false }, I = E(() => R.value === "invoice" ? ie : le), g = m(), P = m(), j = E(() => [["signDate", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"], ["paymentRate", ["to-fixed", 2]], ["invoiceRate", ["to-fixed", 2]], ["amount", ["to-thousand", v.value.supplyChain]], ["paymentAmount", ["to-thousand", v.value.supplyChain]], ["invoiceAmount", ["to-thousand", v.value.supplyChain]]]), { crud: w, columns: s, CRUD: $ } = Z({ title: "付款台账", sort: [], permission: { ...u }, crudApi: { ...W }, invisibleColumns: [], optShow: { ...T } }, g), { maxHeight: B } = ee({ paginate: true }), k = m({}), C = m(void 0), R = m(""), h = m(false);
  F("orderId", C), $.HOOK.handleRefresh = (_, { data: r }) => {
    r.content.forEach((t) => {
      t.paymentRate = t.amount ? (t.paymentAmount || 0) / (t.amount || 0) * 100 : 0, t.invoiceRate = t.amount ? (t.invoiceAmount || 0) / (t.amount || 0) * 100 : 0;
    });
  };
  function x(_, r) {
    f(u.detail) && (k.value = _, R.value = r, C.value = _.id, q(() => {
      h.value = true;
    }));
  }
  return (_, r) => {
    const t = G, A = K, D = z, N = J, H = U("common-table"), M = Q;
    return o(), b("div", se, [c(e(ne), { ref_key: "headerRef", ref: P }, null, 512), L((o(), n(H, { ref_key: "tableRef", ref: g, "data-format": j.value, data: e(w).data, style: { width: "100%" }, "max-height": e(B) }, { default: l(() => [c(t, { label: "序号", type: "index", align: "center", width: "60" }, { default: l(({ row: a, $index: y }) => [c(te, { show: a.boolSettlementStatus === !!e(oe).SETTLED.V, name: "已结算", color: "#f56c6c" }, null, 8, ["show"]), p("span", null, d(y + 1), 1)]), _: 1 }), e(s).visible("serialNumber") ? (o(), n(t, { "show-overflow-tooltip": "", key: "serialNumber", prop: "serialNumber", label: "订单编号", align: "center" })) : i("", true), e(s).visible("signDate") ? (o(), n(t, { "show-overflow-tooltip": "", key: "signDate", prop: "signDate", label: "签订日期", align: "center", width: "100" })) : i("", true), e(s).visible("project") ? (o(), n(t, { "show-overflow-tooltip": "", key: "project", prop: "project", label: "所属项目", "min-width": "130" })) : i("", true), e(s).visible("supplierName") ? (o(), n(t, { "show-overflow-tooltip": "", key: "supplierName", prop: "supplierName", label: "分包单位", "min-width": "110" })) : i("", true), e(s).visible("amount") ? (o(), n(t, { prop: "amount", key: "amount", label: "合同额", align: "right", "show-overflow-tooltip": "" })) : i("", true), e(s).visible("settlementAmount") ? (o(), n(t, { prop: "settlementAmount", key: "settlementAmount", label: "结算额", align: "right", "show-overflow-tooltip": "" })) : i("", true), e(s).visible("subcontractClassName") ? (o(), n(t, { "show-overflow-tooltip": "", key: "subcontractClassName", prop: "subcontractClassName", label: "分类" })) : i("", true), e(s).visible("paymentAmount") ? (o(), n(t, { prop: "paymentAmount", key: "paymentAmount", label: "付款额", align: "right", "show-overflow-tooltip": "" }, S({ default: l(({ row: a }) => [e(f)(e(u).payment.get) ? (o(), b("div", { key: 0, type: "warning", class: "clickable", onClick: V((y) => x(a, "payment"), ["stop"]) }, d(a.paymentAmount), 9, ce)) : i("", true)]), _: 2 }, [e(f)(e(u).payment.get) ? { name: "header", fn: l(() => [c(N, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: l(() => [p("div", re, [r[1] || (r[1] = p("span", null, "付款额 ", -1)), c(D, null, { default: l(() => [c(A)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : i("", true), e(s).visible("paymentRate") ? (o(), n(t, { key: "paymentRate", prop: "paymentRate", label: "付款比例", align: "center", width: "80" }, { default: l(({ row: a }) => [p("span", null, d(a.paymentRate) + "%", 1)]), _: 1 })) : i("", true), e(s).visible("invoiceAmount") ? (o(), n(t, { prop: "invoiceAmount", key: "invoiceAmount", label: "收票额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, S({ default: l(({ row: a }) => [e(f)(e(u).invoice.get) ? (o(), b("div", { key: 0, class: "clickable", onClick: V((y) => x(a, "invoice"), ["stop"]) }, d(a.invoiceAmount), 9, ue)) : i("", true)]), _: 2 }, [e(f)(e(u).invoice.get) ? { name: "header", fn: l(() => [c(N, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: l(() => [p("div", pe, [r[2] || (r[2] = p("span", null, "收票额 ", -1)), c(D, null, { default: l(() => [c(A)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : i("", true), e(s).visible("invoiceRate") ? (o(), n(t, { key: "invoiceRate", prop: "invoiceRate", label: "收票比例", align: "center", width: "80" }, { default: l(({ row: a }) => [p("span", null, d(a.invoiceRate) + "%", 1)]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[M, e(w).loading]]), c(e(ae)), (o(), n(O(I.value), { modelValue: h.value, "onUpdate:modelValue": r[0] || (r[0] = (a) => h.value = a), permission: e(u), "detail-info": k.value }, null, 8, ["modelValue", "permission", "detail-info"]))]);
  };
} }, we = X(me, [["__scopeId", "data-v-cf6c0e8c"]]);
export {
  we as default
};
