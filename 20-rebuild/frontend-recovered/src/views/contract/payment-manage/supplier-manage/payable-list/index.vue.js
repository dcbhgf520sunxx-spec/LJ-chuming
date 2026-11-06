import { ref as m } from "vue";
import { computed as C } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as o } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as n } from "vue";
import { toDisplayString as y } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as B } from "element-plus";
import { c as S } from "../../../../../modules/payable-list-dd7ea2e5.js";
import { _ as E, t as H, x as U, o as $, G as q, P as L } from "../../../../../shared/runtime.js";
import { E as g } from "../../../../../modules/contract-9b18cc88.js";
import M from "./module/header.vue.js";
import T from "./module/detail.vue.js";
import "./module/purchase-list.vue.js";
import "./module/detail-table/purchase-detail.vue.js";
import "./module/subcontract-list.vue.js";
import "./module/detail-table/subcontract-detail.vue.js";
import "./module/material-transport.vue.js";
import "./module/detail-table/inbound-detail.vue.js";
import "./module/manuf-transport.vue.js";
const z = { class: "app-container" }, F = { class: "head-container" }, G = { key: 1 }, j = { __name: "index", setup(J) {
  const { decimalPrecision: r } = H(), A = { add: false, edit: false, del: false, download: false }, v = m(), p = m(false), h = m({}), { crud: s, columns: a, CRUD: K } = U({ title: "应付汇总", sort: [], permission: { ...g }, optShow: { ...A }, crudApi: { ...S }, hasPagination: true }, v), x = C(() => [["paymentRate", ["to-fixed", 2]], ["invoiceRate", ["to-fixed", 2]], ["amount", ["to-thousand", r.value.contract]], ["paymentAmount", ["to-thousand", r.value.contract]], ["unPaymentAmount", ["to-thousand", r.value.contract]], ["invoiceAmount", ["to-thousand", r.value.contract]], ["unInvoiceAmount", ["to-thousand", r.value.contract]]]), { maxHeight: k } = $({ wrapperBox: ".supplierPayable", paginate: true, extraHeight: 40 });
  function R(f) {
    h.value = f, p.value = true;
  }
  return (f, _) => {
    const i = N, P = w("common-button"), D = w("common-table"), I = B;
    return t(), b("div", z, [d("div", F, [u(e(M))]), V((t(), o(D, { ref_key: "tableRef", ref: v, data: e(s).data, "empty-text": e(s).emptyText, "max-height": e(k), "data-format": x.value, style: { width: "100%" } }, { default: c(() => [u(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(a).visible("supplierName") ? (t(), o(i, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": true, label: "供应商", align: "center", "min-width": "140" })) : n("", true), e(a).visible("recordDetail") ? (t(), o(i, { key: "recordDetail", prop: "recordDetail", "show-overflow-tooltip": true, label: "关联合同/记录", width: "120", align: "center" }, { default: c(({ row: l }) => [e(q)(e(g).detail) ? (t(), o(P, { key: 0, icon: "el-icon-view", size: "default", type: "primary", onClick: (O) => R(l) }, null, 8, ["onClick"])) : (t(), b("span", G, "-"))]), _: 1 })) : n("", true), e(a).visible("totalAmount") ? (t(), o(i, { key: "totalAmount", prop: "totalAmount", "show-overflow-tooltip": true, label: "交易总额", "min-width": "100", align: "right" })) : n("", true), e(a).visible("inboundAmount") ? (t(), o(i, { key: "inboundAmount", prop: "inboundAmount", "show-overflow-tooltip": true, label: "已到货金额", "min-width": "100", align: "right" })) : n("", true), e(a).visible("paidAmount") ? (t(), o(i, { key: "paidAmount", prop: "paidAmount", "show-overflow-tooltip": true, label: "已付金额", "min-width": "100", align: "right" })) : n("", true), e(a).visible("unPaidAmount") ? (t(), o(i, { key: "unPaidAmount", prop: "unPaidAmount", "show-overflow-tooltip": true, label: "未付金额", "min-width": "100", align: "right" })) : n("", true), e(a).visible("paymentRate") ? (t(), o(i, { key: "paymentRate", prop: "paymentRate", "show-overflow-tooltip": true, label: "付款率", "min-width": "80", align: "center" }, { default: c(({ row: l }) => [d("span", null, y(l.paymentRate) + "%", 1)]), _: 1 })) : n("", true), e(a).visible("receivedInvoiceAmount") ? (t(), o(i, { key: "receivedInvoiceAmount", prop: "receivedInvoiceAmount", "show-overflow-tooltip": true, label: "已收票", "min-width": "100", align: "right" })) : n("", true), e(a).visible("unreceivedInvoiceAmount") ? (t(), o(i, { key: "unreceivedInvoiceAmount", prop: "unreceivedInvoiceAmount", "show-overflow-tooltip": true, label: "未收票", "min-width": "100", align: "right" })) : n("", true), e(a).visible("invoiceRate") ? (t(), o(i, { key: "invoiceRate", prop: "invoiceRate", "show-overflow-tooltip": true, label: "收票率", "min-width": "80", align: "center" }, { default: c(({ row: l }) => [d("span", null, y(l.invoiceRate) + "%", 1)]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[I, e(s).loading]]), u(e(L)), u(e(T), { modelValue: p.value, "onUpdate:modelValue": _[0] || (_[0] = (l) => p.value = l), detailInfo: h.value, type: e(s).query.type }, null, 8, ["modelValue", "detailInfo", "type"])]);
  };
} }, se = E(j, [["__scopeId", "data-v-706dd8f1"]]);
export {
  se as default
};
