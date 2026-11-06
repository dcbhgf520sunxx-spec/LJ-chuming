import { ref as A } from "vue";
import { computed as R } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as c } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as n } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as v } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as C } from "element-plus";
import { l as N, _ as B, t as H, x as I, o as T, P as O } from "../../../../../shared/runtime.js";
import { F as S } from "../../../../../modules/contract-9b18cc88.js";
import E from "./module/header.vue.js";
function V(d) {
  return N({ url: "/api/v2/contract/payment/payable/summary", method: "get", params: d });
}
const F = { get: V };
const K = { class: "app-container" }, M = { class: "head-container" }, U = { __name: "index", setup(d) {
  const { decimalPrecision: l } = H(), _ = { add: false, edit: false, del: false, download: false }, h = A(), { crud: a, columns: i, CRUD: f } = I({ title: "应付汇总", sort: [], permission: { ...S }, optShow: { ..._ }, crudApi: { ...F }, hasPagination: true }, h), w = R(() => [["paymentRate", ["to-fixed", 2]], ["invoiceRate", ["to-fixed", 2]], ["amount", ["to-thousand", l.value.contract]], ["paymentAmount", ["to-thousand", l.value.contract]], ["unPaymentAmount", ["to-thousand", l.value.contract]], ["invoiceAmount", ["to-thousand", l.value.contract]], ["unInvoiceAmount", ["to-thousand", l.value.contract]]]), { maxHeight: g } = T({ wrapperBox: ".supplierPayable", paginate: true, extraHeight: 40 });
  return f.HOOK.handleRefresh = (s, { data: y }) => {
    y.content.forEach((e) => {
      e.paymentRate = e.amount ? (e.paymentAmount || 0) / (e.amount || 0) * 100 : 0, e.invoiceRate = e.amount ? (e.invoiceAmount || 0) / (e.amount || 0) * 100 : 0;
    });
  }, f.HOOK.beforeRefresh = () => {
    var s;
    ((s = a.query.createTime) == null ? void 0 : s.length) > 0 ? (a.query.startDate = a.query.createTime[0], a.query.endDate = a.query.createTime[1]) : (a.query.startDate = void 0, a.query.endDate = void 0);
  }, (s, y) => {
    const e = q, b = k("common-table"), x = C;
    return o(), P("div", K, [m("div", M, [c(t(E))]), D((o(), n(b, { ref_key: "tableRef", ref: h, data: t(a).data, "empty-text": t(a).emptyText, "max-height": t(g), "data-format": w.value, style: { width: "100%" } }, { default: p(() => [c(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(i).visible("supplierName") ? (o(), n(e, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": true, label: "供应商", align: "center", "min-width": "140" })) : r("", true), t(i).visible("amount") ? (o(), n(e, { key: "amount", prop: "amount", "show-overflow-tooltip": true, label: "交易总额", "min-width": "100", align: "right" })) : r("", true), t(i).visible("paymentAmount") ? (o(), n(e, { key: "paymentAmount", prop: "paymentAmount", "show-overflow-tooltip": true, label: "已付金额", "min-width": "100", align: "right" })) : r("", true), t(i).visible("unPaymentAmount") ? (o(), n(e, { key: "unPaymentAmount", prop: "unPaymentAmount", "show-overflow-tooltip": true, label: "未付金额", "min-width": "100", align: "right" })) : r("", true), t(i).visible("paymentRate") ? (o(), n(e, { key: "payRate", prop: "payRate", "show-overflow-tooltip": true, label: "付款率", "min-width": "80", align: "center" }, { default: p(({ row: u }) => [m("span", null, v(u.paymentRate) + "%", 1)]), _: 1 })) : r("", true), t(i).visible("invoiceAmount") ? (o(), n(e, { key: "invoiceAmount", prop: "invoiceAmount", "show-overflow-tooltip": true, label: "已收票", "min-width": "100", align: "right" })) : r("", true), t(i).visible("unInvoiceAmount") ? (o(), n(e, { key: "unInvoiceAmount", prop: "unInvoiceAmount", "show-overflow-tooltip": true, label: "未收票", "min-width": "100", align: "right" })) : r("", true), t(i).visible("invoiceRate") ? (o(), n(e, { key: "invoiceRate", prop: "invoiceRate", "show-overflow-tooltip": true, label: "收票率", "min-width": "80", align: "center" }, { default: p(({ row: u }) => [m("span", null, v(u.invoiceRate) + "%", 1)]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[x, t(a).loading]]), c(t(O))]);
  };
} }, G = B(U, [["__scopeId", "data-v-0f7ab6aa"]]);
export {
  G as default
};
