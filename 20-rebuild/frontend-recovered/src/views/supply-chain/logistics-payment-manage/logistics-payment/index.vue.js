import { ref as d } from "vue";
import { computed as H } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as s } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as r } from "vue";
import { createSlots as q } from "vue";
import { withModifiers as G } from "vue";
import { nextTick as x } from "vue";
import { ElTableColumn as K } from "element-plus";
import { InfoFilled as j } from "@element-plus/icons-vue";
import { ElIcon as J } from "element-plus";
import { ElTooltip as Q } from "element-plus";
import { vLoading as W } from "element-plus";
import { l as X } from "../../../../modules/logistics-record-ledger-a6792d58.js";
import { a as Y } from "../../../../modules/logistics-payment-1a755fb1.js";
import { _ as Z, t as ee, x as te, uE as f, o as oe, G as v, P as ae } from "../../../../shared/runtime.js";
import ne from "./module/header.vue.js";
import ie from "./module/invoice-record.vue.js";
import le from "./module/payment-application/index.vue.js";
import se from "./module/form.vue.js";
import "./module/payment-application/form.vue.js";
import "../../../../modules/UploadBtn-b4cfb47a.js";
import "../../../contract/payment-manage/supplier-manage/logistics-manage/module/payment-audit/detail.vue.js";
import "../../../../modules/pay-9ccccafb.js";
const re = { class: "app-container" }, ce = { style: { display: "inline-block" } }, pe = ["onClick"], me = { __name: "index", setup(ue) {
  const { decimalPrecision: y } = ee(), A = { add: false, edit: false, del: false, download: false }, k = d(), V = d(), h = d(false), N = H(() => [["paymentRate", ["to-fixed", 2]], ["invoiceRate", ["to-fixed", 2]], ["freight", ["to-thousand", y.value.supplyChain]], ["paymentAmount", ["to-thousand", y.value.supplyChain]], ["invoiceAmount", ["to-thousand", y.value.supplyChain]]]), { crud: b, columns: c, CRUD: P } = te({ title: "物流付款台账", sort: [], permission: { ...f }, crudApi: { get: X, add: Y }, invisibleColumns: [], optShow: { ...A } }, k), { maxHeight: E } = oe({ paginate: true }), u = d({}), D = d(""), g = d(false);
  P.HOOK.handleRefresh = (p, { data: l }) => {
    l.content.forEach((t) => {
      t.paymentRate = t.freight ? (t.paymentAmount || 0) / (t.freight || 0) * 100 : 0, t.invoiceRate = t.freight ? (t.invoiceAmount || 0) / (t.freight || 0) * 100 : 0;
    });
  };
  function I(p, l) {
    v(f.detail) && (u.value = p.sourceRow, D.value = l, x(() => {
      g.value = true;
    }));
  }
  function $(p) {
    u.value = p, b.toAdd();
  }
  function B(p) {
    u.value = p.sourceRow, x(() => {
      h.value = true;
    });
  }
  return (p, l) => {
    const t = K, M = j, S = J, T = Q, R = w("common-button"), U = w("common-table"), z = w("common-drawer"), F = W;
    return a(), L("div", re, [n(e(ne), { ref_key: "headerRef", ref: V }, null, 512), O((a(), s(U, { ref_key: "tableRef", ref: k, "data-format": N.value, data: e(b).data, style: { width: "100%" }, "max-height": e(E) }, { default: i(() => [n(t, { label: "序号", type: "index", align: "center", width: "60" }), e(c).visible("supplierName") ? (a(), s(t, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": true, label: "物流公司", align: "center", "min-width": "180" }, { default: i((o) => [m("span", null, _(o.row.supplierName), 1)]), _: 1 })) : r("", true), e(c).visible("branchCompanyName") ? (a(), s(t, { key: "branchCompanyName", prop: "branchCompanyName", "show-overflow-tooltip": true, label: "付款单位", align: "center", "min-width": "180" }, { default: i((o) => [m("span", null, _(o.row.branchCompanyName), 1)]), _: 1 })) : r("", true), e(c).visible("freight") ? (a(), s(t, { prop: "freight", key: "freight", label: "物流费", align: "right", "min-width": "120", "show-overflow-tooltip": "" })) : r("", true), e(c).visible("paymentAmount") ? (a(), s(t, { prop: "paymentAmount", key: "paymentAmount", label: "付款额", align: "right", "min-width": "120", "show-overflow-tooltip": "" })) : r("", true), e(c).visible("paymentRate") ? (a(), s(t, { key: "paymentRate", prop: "paymentRate", label: "付款比例", align: "center", width: "90" }, { default: i(({ row: o }) => [m("span", null, _(o.paymentRate) + "%", 1)]), _: 1 })) : r("", true), e(c).visible("invoiceAmount") ? (a(), s(t, { prop: "invoiceAmount", key: "invoiceAmount", label: "收票额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, q({ default: i(({ row: o }) => [m("div", { class: "clickable", onClick: G((C) => I(o, "invoice"), ["stop"]) }, _(o.invoiceAmount), 9, pe)]), _: 2 }, [e(v)(e(f).detail) ? { name: "header", fn: i(() => [n(T, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: i(() => [m("div", ce, [l[2] || (l[2] = m("span", null, "收票额 ", -1)), n(S, null, { default: i(() => [n(M)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : r("", true), e(c).visible("invoiceRate") ? (a(), s(t, { key: "invoiceRate", prop: "invoiceRate", label: "收票比例", align: "center", width: "90" }, { default: i(({ row: o }) => [m("span", null, _(o.invoiceRate) + "%", 1)]), _: 1 })) : r("", true), n(t, { label: "操作", width: "120px", align: "center" }, { default: i(({ row: o }) => [e(v)(e(f).add) ? (a(), s(R, { key: 0, type: "primary", icon: "el-icon-plus", size: "default", onClick: (C) => $(o) }, null, 8, ["onClick"])) : r("", true), e(v)(e(f).application.get) ? (a(), s(R, { key: 1, type: "primary", icon: "el-icon-tickets", size: "default", onClick: (C) => B(o) }, null, 8, ["onClick"])) : r("", true)]), _: 1 })]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[F, e(b).loading]]), n(e(ae)), n(e(se), { "detail-info": u.value }, null, 8, ["detail-info"]), n(e(ie), { modelValue: g.value, "onUpdate:modelValue": l[0] || (l[0] = (o) => g.value = o), permission: e(f), "detail-info": u.value }, null, 8, ["modelValue", "permission", "detail-info"]), n(z, { ref: "drawerRef", "show-close": true, size: "80%", title: "付款申请记录", "append-to-body": "", modelValue: h.value, "onUpdate:modelValue": l[1] || (l[1] = (o) => h.value = o), "close-on-click-modal": false }, { content: i(() => [n(e(le), { visibleValue: h.value, currentRow: u.value }, null, 8, ["visibleValue", "currentRow"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, xe = Z(me, [["__scopeId", "data-v-d2fc22f8"]]);
export {
  xe as default
};
