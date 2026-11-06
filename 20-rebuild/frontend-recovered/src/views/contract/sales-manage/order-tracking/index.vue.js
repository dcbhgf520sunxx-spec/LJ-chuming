import { computed as D } from "vue";
import { ref as _ } from "vue";
import { provide as U } from "vue";
import { resolveComponent as H } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as F } from "vue";
import { createVNode as s } from "vue";
import { unref as t } from "vue";
import { withDirectives as G } from "vue";
import { createBlock as l } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as O } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as r } from "vue";
import { createSlots as R } from "vue";
import { createElementVNode as i } from "vue";
import { withModifiers as x } from "vue";
import { resolveDynamicComponent as q } from "vue";
import { nextTick as z } from "vue";
import { ElTableColumn as K } from "element-plus";
import { ElTag as L } from "element-plus";
import { InfoFilled as Y } from "@element-plus/icons-vue";
import { ElIcon as J } from "element-plus";
import { ElTooltip as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { c as Z } from "../../../../modules/order-tracking-9be524cd.js";
import { _ as ee, t as te, x as oe, o as ne, iw as ae, c1 as E, D as le, G as v, P as ie } from "../../../../shared/runtime.js";
import { M as m } from "../../../../modules/contract-9b18cc88.js";
import se from "./module/header.vue.js";
import ce from "./module/collection-record.vue.js";
import re from "./module/invoice-record.vue.js";
import ue from "./module/happened-record.vue.js";
import pe from "./module/warehouse-record.vue.js";
import "./module/happened-detail/index.vue.js";
import "./module/happened-detail/module/header.vue.js";
const de = { class: "app-container" }, me = { style: { display: "inline-block" } }, fe = ["onClick"], he = { style: { display: "inline-block" } }, _e = ["onClick"], ve = { style: { display: "inline-block" } }, we = ["onClick"], Ae = { style: { display: "inline-block" } }, be = ["onClick"], ye = { __name: "index", setup(ke) {
  const { decimalPrecision: h } = te(), $ = { add: false, edit: false, del: false, download: false }, N = D(() => w.value === "collection" ? ce : w.value === "invoice" ? re : w.value === "warehouse" ? pe : ue), T = _(), { crud: j, columns: c, CRUD: I } = oe({ title: "订单跟踪", sort: [], permission: { ...m }, crudApi: { ...Z }, optShow: { ...$ } }, T), { maxHeight: P } = ne({ paginate: true }), S = _({}), V = _(void 0), w = _(""), C = _(false), M = D(() => [["project", "parse-project"], ["orderSourceType", ["parse-enum", ae]], ["status", ["parse-enum", E]], ["contractAmount", ["to-thousand", h.value.contract]], ["settlementAmount", ["to-thousand", h.value.contract]], ["collectionAmount", ["to-thousand", h.value.contract]], ["invoiceAmount", ["to-thousand", h.value.contract]], ["happenedAmount", ["to-thousand", h.value.contract]], ["warehouseAmount", ["to-thousand", le.YUAN]], ["warehouseRate", ["to-fixed", 2]], ["collectionRate", ["to-fixed", 2]], ["invoiceRate", ["to-fixed", 2]], ["happenedRate", ["to-fixed", 2]]]);
  U("projectId", V), I.HOOK.handleRefresh = (d, { data: u }) => {
    u.content.forEach((e) => {
      e.collectionRate = e.settlementAmount || e.contractAmount ? (e.collectionAmount || 0) / (e.settlementAmount || e.contractAmount) * 100 : 0, e.invoiceRate = e.settlementAmount || e.contractAmount ? (e.invoiceAmount || 0) / (e.settlementAmount || e.contractAmount) * 100 : 0, e.happenedRate = e.settlementAmount || e.contractAmount ? (e.happenedAmount || 0) / (e.settlementAmount || e.contractAmount) * 100 : 0, e.warehouseRate = e.settlementAmount || e.contractAmount ? (e.warehouseAmount || 0) / (e.settlementAmount || e.contractAmount) * 100 : 0;
    });
  };
  function A(d, u) {
    var e, b;
    v(m.detail) && (S.value = d == null ? void 0 : d.sourceRow, w.value = u, V.value = (b = (e = d == null ? void 0 : d.sourceRow) == null ? void 0 : e.project) == null ? void 0 : b.id, z(() => {
      C.value = true;
    }));
  }
  return (d, u) => {
    const e = K, b = L, y = Y, k = J, g = W, B = H("common-table"), Q = X;
    return a(), F("div", de, [s(t(se)), G((a(), l(B, { ref_key: "tableRef", ref: T, "data-format": M.value, data: t(j).data, style: { width: "100%" }, "max-height": t(P) }, { default: n(() => [s(e, { label: "序号", type: "index", align: "center", width: "55" }), t(c).visible("status") ? (a(), l(e, { key: "status", prop: "status", "show-overflow-tooltip": true, align: "center", label: "状态", width: "90" }, { default: n(({ row: o }) => {
      var f;
      return [s(b, { type: t(E).V[(f = o == null ? void 0 : o.sourceRow) == null ? void 0 : f.status].TAG, size: "large", effect: "plain" }, { default: n(() => [O(p(o.status), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : r("", true), t(c).visible("project") ? (a(), l(e, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "150" })) : r("", true), t(c).visible("orderSourceType") ? (a(), l(e, { key: "orderSourceType", prop: "orderSourceType", "show-overflow-tooltip": true, label: "订单属性", width: "80" })) : r("", true), t(c).visible("projectContentName") ? (a(), l(e, { key: "projectContentName", prop: "projectContentName", label: "合同内容", "min-width": "120", "show-overflow-tooltip": "" })) : r("", true), t(c).visible("contractAmount") ? (a(), l(e, { prop: "contractAmount", key: "contractAmount", label: "合同额", align: "right", "min-width": "120", "show-overflow-tooltip": "" })) : r("", true), t(c).visible("settlementAmount") ? (a(), l(e, { prop: "settlementAmount", key: "settlementAmount", label: "结算额", align: "right", "min-width": "120", "show-overflow-tooltip": "" })) : r("", true), t(c).visible("collectionAmount") ? (a(), l(e, { prop: "collectionAmount", key: "collectionAmount", label: "累计收款额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, R({ default: n(({ row: o }) => [i("div", { class: "clickable", onClick: x((f) => A(o, "collection"), ["stop"]) }, p(o.collectionAmount), 9, fe)]), _: 2 }, [t(v)(t(m).detail) ? { name: "header", fn: n(() => [s(g, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: n(() => [i("div", me, [u[1] || (u[1] = i("span", null, "累计收款额 ", -1)), s(k, null, { default: n(() => [s(y)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : r("", true), t(c).visible("collectionRate") ? (a(), l(e, { key: "collectionRate", prop: "collectionRate", label: "收款比例", align: "center", width: "90", "show-overflow-tooltip": "" }, { default: n(({ row: o }) => [i("span", null, p(o.collectionRate) + "%", 1)]), _: 1 })) : r("", true), t(c).visible("invoiceAmount") ? (a(), l(e, { prop: "invoiceAmount", key: "invoiceAmount", label: "累计开票额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, R({ default: n(({ row: o }) => [i("div", { class: "clickable", onClick: x((f) => A(o, "invoice"), ["stop"]) }, p(o.invoiceAmount), 9, _e)]), _: 2 }, [t(v)(t(m).detail) ? { name: "header", fn: n(() => [s(g, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: n(() => [i("div", he, [u[2] || (u[2] = i("span", null, "累计开票额 ", -1)), s(k, null, { default: n(() => [s(y)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : r("", true), t(c).visible("invoiceRate") ? (a(), l(e, { key: "invoiceRate", prop: "invoiceRate", label: "开票比例", align: "center", width: "80", "show-overflow-tooltip": "" }, { default: n(({ row: o }) => [i("span", null, p(o.invoiceRate) + "%", 1)]), _: 1 })) : r("", true), t(c).visible("warehouseAmount") ? (a(), l(e, { prop: "warehouseAmount", key: "warehouseAmount", label: "累计入库额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, R({ default: n(({ row: o }) => [i("div", { class: "clickable", onClick: x((f) => A(o, "warehouse"), ["stop"]) }, p(o.warehouseAmount), 9, we)]), _: 2 }, [t(v)(t(m).detail) ? { name: "header", fn: n(() => [s(g, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: n(() => [i("div", ve, [u[3] || (u[3] = i("span", null, "累计入库额 ", -1)), s(k, null, { default: n(() => [s(y)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : r("", true), t(c).visible("warehouseRate") ? (a(), l(e, { key: "warehouseRate", prop: "warehouseRate", label: "入库比例", align: "center", width: "80", "show-overflow-tooltip": "" }, { default: n(({ row: o }) => [i("span", null, p(o.warehouseRate) + "%", 1)]), _: 1 })) : r("", true), t(c).visible("happenedAmount") ? (a(), l(e, { prop: "happenedAmount", key: "happenedAmount", label: "累计出库额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, R({ default: n(({ row: o }) => [i("div", { class: "clickable", onClick: x((f) => A(o, "happened"), ["stop"]) }, p(o.happenedAmount), 9, be)]), _: 2 }, [t(v)(t(m).detail) ? { name: "header", fn: n(() => [s(g, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: n(() => [i("div", Ae, [u[4] || (u[4] = i("span", null, "累计出库额 ", -1)), s(k, null, { default: n(() => [s(y)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : r("", true), t(c).visible("happenedRate") ? (a(), l(e, { key: "happenedRate", prop: "happenedRate", label: "出库额比例", align: "center", width: "90", "show-overflow-tooltip": "" }, { default: n(({ row: o }) => [i("span", null, p(o.happenedRate) + "%", 1)]), _: 1 })) : r("", true), t(c).visible("transportQuantity") ? (a(), l(e, { key: "transportQuantity", prop: "transportQuantity", label: "运输车次/船次", align: "center", width: "80", "show-overflow-tooltip": "" }, { default: n(({ row: o }) => [i("span", null, p(o.transportQuantity), 1)]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[Q, t(j).loading]]), s(t(ie)), (a(), l(q(N.value), { modelValue: C.value, "onUpdate:modelValue": u[0] || (u[0] = (o) => C.value = o), permission: t(m), "detail-info": S.value }, null, 8, ["modelValue", "permission", "detail-info"]))]);
  };
} }, Ne = ee(ye, [["__scopeId", "data-v-b28d6993"]]);
export {
  Ne as default
};
