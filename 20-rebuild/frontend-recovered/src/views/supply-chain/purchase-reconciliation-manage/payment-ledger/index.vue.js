import { computed as F } from "vue";
import { ref as y } from "vue";
import { provide as W } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as X } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as H } from "vue";
import { createBlock as u } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as d } from "vue";
import { createSlots as g } from "vue";
import { withModifiers as C } from "vue";
import { resolveDynamicComponent as Z } from "vue";
import { nextTick as I } from "vue";
import { ElTableColumn as ee } from "element-plus";
import { InfoFilled as te } from "@element-plus/icons-vue";
import { ElIcon as ne } from "element-plus";
import { ElTooltip as oe } from "element-plus";
import { vLoading as le } from "element-plus";
import { c as ie } from "../../../../modules/payment-ledger-cb1d373c.js";
import { _ as ae, t as se, x as ue, v_ as r, o as de, bv as pe, am as re, br as ce, iF as j, G as v, P as me } from "../../../../shared/runtime.js";
import fe from "./module/header.vue.js";
import ve from "./module/inbound-record.vue.js";
import _e from "./module/invoice-record.vue.js";
import ye from "./module/payment-record.vue.js";
import he from "./module/payment-application/index.vue.js";
import be from "./module/settle-form.vue.js";
import "../../../../modules/payment-application-502afb4b.js";
import "./module/payment-application/form.vue.js";
import "../../../../modules/UploadBtn-b4cfb47a.js";
import "./module/payment-application/detail.vue.js";
const ke = { class: "app-container" }, we = { style: { display: "inline-block" } }, ge = ["onClick"], Ce = { style: { display: "inline-block" } }, Ae = ["onClick"], xe = { style: { display: "inline-block" } }, Re = ["onClick"], Te = { style: { display: "inline-block" } }, Ve = ["onClick"], Ee = { style: { display: "inline-block" } }, Se = ["onClick"], $e = { style: { display: "inline-block" } }, Ne = ["onClick"], De = { __name: "index", setup(Ie) {
  const { decimalPrecision: V } = se(), q = { add: false, edit: false, del: false, download: false }, G = F(() => $.value === "inbound" ? ve : $.value === "invoice" ? _e : ye), E = y(), x = y(), R = y(false), S = y(false), P = F(() => [["createTime", "parse-time"], ["paymentRate", ["to-fixed", 2]], ["invoiceRate", ["to-fixed", 2]], ["amount", ["to-thousand", V.value.supplyChain]], ["inboundAmount", ["to-thousand-ck", "YUAN"]], ["paymentAmount", ["to-thousand", V.value.supplyChain]], ["invoiceAmount", ["to-thousand", V.value.supplyChain]]]), { crud: A, columns: c, CRUD: K } = ue({ title: "付款台账", sort: [], permission: { ...r }, crudApi: { ...ie }, invisibleColumns: [], optShow: { ...q } }, E), { maxHeight: U } = de({ paginate: true }), h = y({}), T = y(void 0), $ = y(""), N = y(false);
  W("orderId", T), K.HOOK.handleRefresh = (m, { data: a }) => {
    a.content.forEach((l) => {
      const _ = pe.getBits(re.ENUM, l.basicClass, "L");
      l.typeText = _.join(" | "), l.paymentRate = l.amount ? (l.paymentAmount || 0) / (l.amount || 0) * 100 : 0, l.invoiceRate = l.amount ? (l.invoiceAmount || 0) / (l.amount || 0) * 100 : 0;
    });
  };
  function b(m, a) {
    v(r.detail) && (h.value = m, $.value = a, T.value = m.id, I(() => {
      N.value = true;
    }));
  }
  function Q(m) {
    h.value = m, T.value = m.id, I(() => {
      R.value = true;
    });
  }
  function Y(m) {
    h.value = m, T.value = m.id, I(() => {
      S.value = true;
    });
  }
  return (m, a) => {
    var L, z;
    const l = ee, _ = te, k = ne, w = oe, M = D("common-button"), B = D("common-table"), J = D("common-drawer"), O = le;
    return s(), X("div", ke, [n(e(fe), { ref_key: "headerRef", ref: x }, null, 512), (L = x.value) != null && L.isOrderType ? H((s(), u(B, { key: 0, ref_key: "tableRef", ref: E, "data-format": P.value, data: e(A).data, style: { width: "100%" }, "max-height": e(U) }, { default: o(() => [n(l, { label: "序号", type: "index", align: "center", width: "60" }, { default: o(({ row: t, $index: f }) => [n(ce, { show: t.settlementStatus === e(j).SETTLED.V, name: "已结算", color: "#f56c6c" }, null, 8, ["show"]), i("span", null, p(f + 1), 1)]), _: 1 }), e(c).visible("createTime") ? (s(), u(l, { "show-overflow-tooltip": "", key: "createTime", prop: "createTime", label: "日期", align: "center", width: "130" })) : d("", true), e(c).visible("serialNumber") ? (s(), u(l, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "采购合同编号", align: "center", "min-width": "130" })) : d("", true), e(c).visible("supplierName") ? (s(), u(l, { "show-overflow-tooltip": "", key: "supplierName", prop: "supplierName", label: "供应商", "min-width": "150" })) : d("", true), e(c).visible("typeText") ? (s(), u(l, { "show-overflow-tooltip": "", key: "typeText", prop: "typeText", label: "物料种类", "min-width": "150" })) : d("", true), e(c).visible("amount") ? (s(), u(l, { prop: "amount", key: "amount", label: "合同额", align: "right", "min-width": "120", "show-overflow-tooltip": "" })) : d("", true), e(c).visible("inboundAmount") ? (s(), u(l, { prop: "inboundAmount", key: "inboundAmount", label: "入库额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, g({ default: o(({ row: t }) => [i("div", { type: "success", class: "clickable", onClick: C((f) => b(t, "inbound"), ["stop"]) }, p(t.inboundAmount), 9, ge)]), _: 2 }, [e(v)(e(r).detail) ? { name: "header", fn: o(() => [n(w, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: o(() => [i("div", we, [a[3] || (a[3] = i("span", null, "入库额 ", -1)), n(k, null, { default: o(() => [n(_)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : d("", true), e(c).visible("paymentAmount") ? (s(), u(l, { prop: "paymentAmount", key: "paymentAmount", label: "付款额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, g({ default: o(({ row: t }) => [i("div", { type: "warning", class: "clickable", onClick: C((f) => b(t, "payment"), ["stop"]) }, p(t.paymentAmount), 9, Ae)]), _: 2 }, [e(v)(e(r).detail) ? { name: "header", fn: o(() => [n(w, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: o(() => [i("div", Ce, [a[4] || (a[4] = i("span", null, "付款额 ", -1)), n(k, null, { default: o(() => [n(_)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : d("", true), e(c).visible("paymentRate") ? (s(), u(l, { key: "paymentRate", prop: "paymentRate", label: "付款比例", align: "center", width: "80" }, { default: o(({ row: t }) => [i("span", null, p(t.paymentRate) + "%", 1)]), _: 1 })) : d("", true), e(c).visible("invoiceAmount") ? (s(), u(l, { prop: "invoiceAmount", key: "invoiceAmount", label: "收票额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, g({ default: o(({ row: t }) => [i("div", { class: "clickable", onClick: C((f) => b(t, "invoice"), ["stop"]) }, p(t.invoiceAmount), 9, Re)]), _: 2 }, [e(v)(e(r).detail) ? { name: "header", fn: o(() => [n(w, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: o(() => [i("div", xe, [a[5] || (a[5] = i("span", null, "收票额 ", -1)), n(k, null, { default: o(() => [n(_)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : d("", true), e(c).visible("invoiceRate") ? (s(), u(l, { key: "invoiceRate", prop: "invoiceRate", label: "收票比例", align: "center", width: "80" }, { default: o(({ row: t }) => [i("span", null, p(t.invoiceRate) + "%", 1)]), _: 1 })) : d("", true), n(l, { label: "操作", width: "120px", align: "center" }, { default: o(({ row: t }) => [e(v)(e(r).application.get) ? (s(), u(M, { key: 0, type: "primary", icon: "el-icon-tickets", size: "default", onClick: (f) => Q(t) }, null, 8, ["onClick"])) : d("", true), t.settlementStatus !== e(j).SETTLED.V && !t.unCheckSettlementCount && e(v)(e(r).settle) ? (s(), u(M, { key: 1, type: "success", icon: "el-icon-money", size: "default", onClick: (f) => Y(t) }, null, 8, ["onClick"])) : d("", true)]), _: 1 })]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[O, e(A).loading]]) : d("", true), x.value && !((z = x.value) != null && z.isOrderType) ? H((s(), u(B, { key: 1, ref_key: "tableRef", ref: E, "data-format": P.value, data: e(A).data, style: { width: "100%" }, "max-height": e(U) }, { default: o(() => [n(l, { label: "序号", type: "index", align: "center", width: "60" }), n(l, { prop: "supplierName", label: "供应商", align: "center", "show-overflow-tooltip": "", "min-width": "140" }), n(l, { prop: "amount", label: "累计合同额", align: "right", "show-overflow-tooltip": "", "min-width": "120" }), n(l, { prop: "inboundAmount", key: "inboundAmount", label: "累计入库额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, g({ default: o(({ row: t }) => [i("div", { type: "warning", class: "clickable", onClick: C((f) => b(t, "inbound"), ["stop"]) }, p(t.inboundAmount), 9, Ve)]), _: 2 }, [e(v)(e(r).detail) ? { name: "header", fn: o(() => [n(w, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: o(() => [i("div", Te, [a[6] || (a[6] = i("span", null, "累计入库额 ", -1)), n(k, null, { default: o(() => [n(_)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024), n(l, { prop: "paymentAmount", key: "paymentAmount", label: "累计已付款", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, g({ default: o(({ row: t }) => [i("div", { type: "warning", class: "clickable", onClick: C((f) => b(t, "payment"), ["stop"]) }, p(t.paymentAmount), 9, Se)]), _: 2 }, [e(v)(e(r).detail) ? { name: "header", fn: o(() => [n(w, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: o(() => [i("div", Ee, [a[7] || (a[7] = i("span", null, "累计已付款 ", -1)), n(k, null, { default: o(() => [n(_)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024), n(l, { prop: "paymentRate", label: "付款比例", align: "center", "show-overflow-tooltip": "", "min-width": "80" }, { default: o(({ row: t }) => [i("span", null, p(t.paymentRate) + "%", 1)]), _: 1 }), n(l, { prop: "invoiceAmount", key: "invoiceAmount", label: "累计已收票", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, g({ default: o(({ row: t }) => [i("div", { type: "warning", class: "clickable", onClick: C((f) => b(t, "invoice"), ["stop"]) }, p(t.invoiceAmount), 9, Ne)]), _: 2 }, [e(v)(e(r).detail) ? { name: "header", fn: o(() => [n(w, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: o(() => [i("div", $e, [a[8] || (a[8] = i("span", null, "累计已收票 ", -1)), n(k, null, { default: o(() => [n(_)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024), n(l, { prop: "invoiceRate", label: "收票比例", align: "center", "show-overflow-tooltip": "", "min-width": "80" }, { default: o(({ row: t }) => [i("span", null, p(t.invoiceRate) + "%", 1)]), _: 1 })]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[O, e(A).loading]]) : d("", true), n(e(me)), (s(), u(Z(G.value), { modelValue: N.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => N.value = t), permission: e(r), "detail-info": h.value }, null, 8, ["modelValue", "permission", "detail-info"])), n(J, { ref: "drawerRef", "show-close": true, size: "80%", title: "付款申请记录", "append-to-body": "", modelValue: R.value, "onUpdate:modelValue": a[1] || (a[1] = (t) => R.value = t), "close-on-click-modal": false }, { content: o(() => [n(e(he), { visibleValue: R.value, "detail-info": h.value }, null, 8, ["visibleValue", "detail-info"])]), _: 1 }, 8, ["modelValue"]), n(e(be), { modelValue: S.value, "onUpdate:modelValue": a[2] || (a[2] = (t) => S.value = t), "detail-info": h.value, onSuccess: e(A).toQuery, showType: "add" }, null, 8, ["modelValue", "detail-info", "onSuccess"])]);
  };
} }, Qe = ae(De, [["__scopeId", "data-v-695dfa7a"]]);
export {
  Qe as default
};
