import { ref as p } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as u } from "vue";
import { unref as t } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as r } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as l } from "vue";
import { createTextVNode as O } from "vue";
import { ElTableColumn as G } from "element-plus";
import { ElBadge as q } from "element-plus";
import { ElTag as K } from "element-plus";
import { vLoading as Q } from "element-plus";
import { _ as J, m as W, t as X, x as Y, o as Z, iE as ee, z as te, bN as oe, p as ne, i as y, bV as w, G as g, c1 as D, P as ae, a as le } from "../../../shared/runtime.js";
import { c as ie } from "../../../modules/contract-ledger-2ee7c4ce.js";
import { k as v } from "../../../modules/contract-9b18cc88.js";
import re from "./module/header.vue.js";
import ce from "./module/occur-amount.vue.js";
import se from "./module/contract-money.vue.js";
import ue from "./module/collection-and-invoice/index.vue.js";
import "./module/collection-and-invoice/collection/index.vue.js";
import "../../../modules/collection-9275714a.js";
import "./module/collection-and-invoice/collection/form.vue.js";
import "./module/collection-and-invoice/invoice/index.vue.js";
import "../../../modules/invoice-2cd386aa.js";
import "./module/collection-and-invoice/invoice/form.vue.js";
const de = { class: "app-container" }, me = { class: "head-container" }, pe = ["onClick"], ve = ["onClick"], fe = { key: 0 }, _e = { style: { color: "#409eff", "text-align": "right", "margin-left": "8px" } }, we = ["onClick"], ge = { key: 0 }, be = { style: { color: "#409eff", "text-align": "right", "margin-left": "8px" } }, ye = ["onClick"], he = { __name: "index", setup(ke) {
  const { currentProjectType: B } = W(["currentProjectType"]), { decimalPrecision: f } = X(), P = { add: false, edit: false, del: false, download: false }, T = p(), h = p(false), k = p(false), x = p(false), _ = p(), j = p({}), V = p("collection"), { CRUD: E, crud: b, columns: c } = Y({ title: "项目台账", sort: [], permission: { ...v }, optShow: { ...P }, crudApi: { ...ie }, hasPagination: true }, T), { maxHeight: L } = Z({ wrapperBox: ".contractLedger", paginate: true, extraHeight: 40 });
  function U(m) {
    g(v.amountLog) && (_.value = m, h.value = true);
  }
  function M(m) {
    g(v.occurLog) && (_.value = m, k.value = true);
  }
  function N(m, d) {
    g(v[d].get) && (V.value = d, _.value = m.id, j.value = m, x.value = true);
  }
  return E.HOOK.handleRefresh = (m, d) => {
  }, (m, d) => {
    const i = G, I = le, R = q, S = K, $ = z("common-table"), H = Q;
    return o(), A("div", de, [a("div", me, [u(t(re), { currentProjectType: t(B) }, null, 8, ["currentProjectType"])]), F((o(), r($, { ref_key: "tableRef", ref: T, data: t(b).data, "empty-text": t(b).emptyText, "max-height": t(L), style: { width: "100%" }, "return-source-data": "", showEmptySymbol: false }, { default: n(() => [u(i, { prop: "index", label: "序号", align: "center", width: "55", type: "index", fixed: "left" }), t(c).visible("projectType") ? (o(), r(i, { key: "projectType", prop: "projectType", "show-overflow-tooltip": true, label: "项目类型", width: "80", align: "center", fixed: "left" }, { default: n((e) => [a("span", null, s(e.row.contractDefinitionType ? t(ee).VL[e.row.contractDefinitionType] : "-"), 1)]), _: 1 })) : l("", true), t(c).visible("project.shortName") ? (o(), r(i, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "项目", "min-width": "150", fixed: "left" }, { default: n((e) => [a("span", null, s(t(te)(e.row)), 1)]), _: 1 })) : l("", true), t(c).visible("businessType") ? (o(), r(i, { key: "businessType", prop: "businessType", label: "业务类型", align: "center", width: "80" }, { default: n((e) => [a("div", null, s(e.row.businessType ? t(oe).VL[e.row.businessType] : "-"), 1)]), _: 1 })) : l("", true), t(c).visible("projectManagerName") ? (o(), r(i, { key: "projectManagerName", "show-overflow-tooltip": true, label: "项目经理", align: "center", width: "90" }, { default: n((e) => [a("div", null, s(e.row.projectManagerName ? e.row.projectManagerName : e.row.salesLeaderName || "-"), 1)]), _: 1 })) : l("", true), t(c).visible("customerUnit") ? (o(), r(i, { key: "customerUnit", prop: "customerUnit", "show-overflow-tooltip": true, label: "客户名称", align: "center", "min-width": "90" }, { default: n((e) => [a("div", null, s(e.row.customerUnit || "-"), 1)]), _: 1 })) : l("", true), t(c).visible("signingDate") ? (o(), r(i, { key: "signingDate", prop: "signingDate", "show-overflow-tooltip": true, label: "签订日期", align: "center", width: "80" }, { default: n((e) => [a("div", null, s(e.row.signingDate ? t(ne)(e.row.signingDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : l("", true), t(c).visible("contractAmount") ? (o(), r(i, { key: "contractAmount", prop: "contractAmount", label: "合同额", align: "center", "min-width": "90" }, { default: n((e) => [a("div", { onClick: (C) => U(e.row.id), style: { cursor: "pointer", color: "#409eff", "text-align": "right" } }, s(t(y)(e.row.contractAmount) ? t(w)(e.row.contractAmount, t(f).contract) : "-"), 9, pe)]), _: 1 })) : l("", true), t(c).visible("settlementAmount") ? (o(), r(i, { key: "settlementAmount", prop: "settlementAmount", label: "结算额", align: "center" }, { default: n((e) => [a("div", null, s(e.row.settlementAmount ? t(w)(e.row.settlementAmount, t(f).contract) : "-"), 1)]), _: 1 })) : l("", true), t(c).visible("collectionAmount") ? (o(), r(i, { key: "collectionAmount", prop: "collectionAmount", label: "累计收款", align: "right" }, { default: n((e) => [a("div", { onClick: (C) => N(e.row, "collection"), style: { cursor: "pointer" } }, [e.row.unCheckCollectionCount > 0 && t(g)(t(v).collection.audit) ? (o(), A("span", fe, [u(R, { value: e.row.unCheckCollectionCount, max: 99, hidden: e.row.unCheckCollectionCount < 1 }, { default: n(() => [u(I, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["value", "hidden"])])) : l("", true), a("span", _e, s(t(y)(e.row.collectionAmount) ? t(w)(e.row.collectionAmount, t(f).contract) : "-"), 1)], 8, ve)]), _: 1 })) : l("", true), t(c).visible("collectionRate") ? (o(), r(i, { key: "collectionRate", prop: "collectionRate", label: "收款比例", align: "center", width: "80px" }, { default: n((e) => [a("div", null, s(e.row.collectionRate ? (e.row.collectionRate * 100).toFixed(2) + "%" : "-"), 1)]), _: 1 })) : l("", true), t(c).visible("invoiceAmount") ? (o(), r(i, { key: "invoiceAmount", prop: "invoiceAmount", label: "累计开票", align: "right" }, { default: n((e) => [a("div", { onClick: (C) => N(e.row, "invoice"), style: { cursor: "pointer" } }, [e.row.unCheckInvoiceCount > 0 && t(g)(t(v).invoice.audit) ? (o(), A("span", ge, [u(R, { value: e.row.unCheckInvoiceCount, max: 99, hidden: e.row.unCheckInvoiceCount < 1 }, { default: n(() => [u(I, { "icon-class": "notify", style: { color: "#e6a23c", "font-size": "15px" } })]), _: 2 }, 1032, ["value", "hidden"])])) : l("", true), a("span", be, s(t(y)(e.row.invoiceAmount) ? t(w)(e.row.invoiceAmount, t(f).contract) : "-"), 1)], 8, we)]), _: 1 })) : l("", true), t(c).visible("invoiceRate") ? (o(), r(i, { key: "invoiceRate", prop: "invoiceRate", label: "开票比例", align: "center", width: "80px" }, { default: n((e) => [a("div", null, s(e.row.invoiceRate ? (e.row.invoiceRate * 100).toFixed(2) + "%" : "-"), 1)]), _: 1 })) : l("", true), t(c).visible("deliverInstallAmount") ? (o(), r(i, { key: "deliverInstallAmount", prop: "deliverInstallAmount", label: "累计发生额", align: "center" }, { default: n((e) => [a("div", { onClick: (C) => M(e.row.id), style: { cursor: "pointer", color: "#409eff", "text-align": "right" } }, s(t(y)(e.row.deliverInstallAmount) ? t(w)(e.row.deliverInstallAmount, t(f).contract) : "-"), 9, ye)]), _: 1 })) : l("", true), t(c).visible("availableBalance") ? (o(), r(i, { key: "availableBalance", prop: "availableBalance", label: "可用余额", align: "center" }, { default: n((e) => [a("div", null, s(e.row.availableBalance ? t(w)(e.row.availableBalance, t(f).contract) : "-"), 1)]), _: 1 })) : l("", true), t(c).visible("status") ? (o(), r(i, { key: "status", prop: "status", label: "项目状态", align: "center", width: "80px" }, { default: n((e) => [u(S, { type: e.row.status === t(D).SETTLED.V ? "success" : "warning", effect: "plain" }, { default: n(() => [O(s(e.row.status ? t(D).VL[e.row.status] : "-"), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[H, t(b).loading]]), u(t(se), { modelValue: h.value, "onUpdate:modelValue": d[0] || (d[0] = (e) => h.value = e), projectId: _.value }, null, 8, ["modelValue", "projectId"]), u(t(ce), { modelValue: k.value, "onUpdate:modelValue": d[1] || (d[1] = (e) => k.value = e), projectId: _.value }, null, 8, ["modelValue", "projectId"]), u(t(ue), { modelValue: x.value, "onUpdate:modelValue": d[2] || (d[2] = (e) => x.value = e), projectId: _.value, tabName: V.value, onSuccess: t(b).toQuery, "current-row": j.value, permission: t(v) }, null, 8, ["modelValue", "projectId", "tabName", "onSuccess", "current-row", "permission"]), u(t(ae))]);
  };
} }, Ue = J(he, [["__scopeId", "data-v-a66dbc3e"]]);
export {
  Ue as default
};
