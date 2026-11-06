import { ref as M } from "vue";
import { reactive as B } from "vue";
import { provide as P } from "vue";
import { resolveComponent as U } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as s } from "vue";
import { withCtx as t } from "vue";
import { createCommentVNode as p } from "vue";
import { createSlots as b } from "vue";
import { createElementVNode as n } from "vue";
import { withModifiers as y } from "vue";
import { toDisplayString as h } from "vue";
import { createTextVNode as j } from "vue";
import { ElTableColumn as z } from "element-plus";
import { ElTooltip as F } from "element-plus";
import { InfoFilled as G } from "@element-plus/icons-vue";
import { ElIcon as H } from "element-plus";
import { vLoading as Y } from "element-plus";
import { g as J, d as W } from "../../../../../modules/psi-b34aaded.js";
import { _ as X, D as Z, n as ee, x as te, Cd as r, o as ne, jG as ie, G as m, P as oe, L as le, ba as ae, jN as x } from "../../../../../shared/runtime.js";
import se from "./module/header.vue.js";
import de from "./module/detail.vue.js";
const ue = { class: "app-container" }, re = ["onClick"], ce = ["onClick"], pe = ["onClick"], me = { style: { display: "inline-block" } }, fe = ["onClick"], _e = { style: { display: "inline-block" } }, ve = ["onClick"], be = { style: { display: "inline-block" } }, ye = ["onClick"], he = { __name: "index", setup(ge) {
  const E = { add: false, edit: false, del: false, download: false }, k = M({}), w = M(false), S = M(), N = M([["amountExcludingVAT", ["to-thousand", Z.YUAN]], ["inboundTime", "parse-time"]]), d = B({ IN: { L: "入库明细", SL: "入库", K: "IN", V: 1 }, OUT: { L: "出库明细", SL: "出库", K: "OUT", V: 2 }, STOCK: { L: "库存明细", SL: "库存", K: "STOCK", V: 3 } });
  ee(d), P("orderDetailEnum", d);
  const { crud: C, columns: u } = te({ title: "收发存记录", sort: [], permission: { ...r }, crudApi: { get: J }, invisibleColumns: [], optShow: { ...E } }, S), { maxHeight: I } = ne({ paginate: true });
  function L(_) {
    return ae(_, { props: ["quantity", ["mete", x.weight.precision], ["inboundMete", x.weight.precision], ["outboundMete", x.weight.precision], ["inventoryMete", x.weight.precision], ["inboundQuantity", 3], ["outboundQuantity", 3], ["inventoryQuantity", 3]] });
  }
  function f(_, o) {
    m(r.detail) && (k.value = { ..._ == null ? void 0 : _.sourceRow, type: o, times: C.query.times }, w.value = true);
  }
  return (_, o) => {
    var T;
    const c = z, v = F, V = G, Q = H, $ = U("common-table"), O = U("common-drawer"), R = Y, K = q("permission");
    return a(), A("div", ue, [l(e(se)), D((a(), s($, { ref_key: "tableRef", ref: S, data: e(C).data, "data-format": N.value, "max-height": e(I), "summary-method": L, "highlight-current-row": "", "row-key": "id", "show-summary": "" }, { default: t(() => [l(ie, { columns: e(u) }, null, 8, ["columns"]), e(u).visible("measureUnit") ? (a(), s(c, { key: "measureUnit", align: "center", label: "计量单位", prop: "measureUnit", "show-overflow-tooltip": "", width: "70px" })) : p("", true), e(u).visible("inboundQuantity") ? (a(), s(c, { key: "inboundQuantity", align: "right", label: "入库量", "min-width": "120", prop: "inboundQuantity", "show-overflow-tooltip": "" }, b({ default: t(({ row: i }) => [n("div", { class: "clickable", onClick: y((g) => f(i, d.IN.V), ["stop"]) }, h(i.inboundQuantity), 9, re)]), _: 2 }, [e(m)(e(r).detail) ? { name: "header", fn: t(() => [l(v, { content: "点击行可以查看详情", effect: "light", placement: "top" }, { default: t(() => o[1] || (o[1] = [n("div", { style: { display: "inline-block" } }, [n("span", null, "入库量 "), n("i", { class: "el-icon-info" })], -1)])), _: 1, __: [1] })]), key: "0" } : void 0]), 1024)) : p("", true), e(u).visible("outboundQuantity") ? (a(), s(c, { key: "outboundQuantity", align: "right", label: "出库量", "min-width": "120", prop: "outboundQuantity", "show-overflow-tooltip": "" }, b({ default: t(({ row: i }) => [n("div", { class: "clickable", onClick: y((g) => f(i, d.OUT.V), ["stop"]) }, h(i.outboundQuantity), 9, ce)]), _: 2 }, [e(m)(e(r).detail) ? { name: "header", fn: t(() => [l(v, { content: "点击行可以查看详情", effect: "light", placement: "top" }, { default: t(() => o[2] || (o[2] = [n("div", { style: { display: "inline-block" } }, [n("span", null, " 出库量 "), n("i", { class: "el-icon-info" })], -1)])), _: 1, __: [2] })]), key: "0" } : void 0]), 1024)) : p("", true), e(u).visible("inventoryQuantity") ? (a(), s(c, { key: "inventoryQuantity", align: "right", label: "库存量", "min-width": "120", prop: "inventoryQuantity", "show-overflow-tooltip": "" }, b({ default: t(({ row: i }) => [n("div", { class: "clickable", onClick: y((g) => f(i, d.STOCK.V), ["stop"]) }, h(i.inventoryQuantity), 9, pe)]), _: 2 }, [e(m)(e(r).detail) ? { name: "header", fn: t(() => [l(v, { content: "点击行可以查看详情", effect: "light", placement: "top" }, { default: t(() => o[3] || (o[3] = [n("div", { style: { display: "inline-block" } }, [n("span", null, "库存量 "), n("i", { class: "el-icon-info" })], -1)])), _: 1, __: [3] })]), key: "0" } : void 0]), 1024)) : p("", true), e(u).visible("accountingUnit") ? (a(), s(c, { key: "accountingUnit", align: "center", label: "核算单位", prop: "accountingUnit", "show-overflow-tooltip": "", width: "70px" })) : p("", true), e(u).visible("inboundMete") ? (a(), s(c, { key: "inboundMete", align: "right", label: "入库量", "min-width": "120", prop: "inboundMete", "show-overflow-tooltip": "" }, b({ default: t(({ row: i }) => [n("div", { class: "clickable", onClick: y((g) => f(i, d.IN.V), ["stop"]) }, h(i.inboundMete), 9, fe)]), _: 2 }, [e(m)(e(r).detail) ? { name: "header", fn: t(() => [l(v, { content: "点击行可以查看详情", effect: "light", placement: "top" }, { default: t(() => [n("div", me, [o[4] || (o[4] = n("span", null, "入库量 ", -1)), l(Q, null, { default: t(() => [l(V)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : p("", true), e(u).visible("outboundMete") ? (a(), s(c, { key: "outboundMete", align: "right", label: "出库量", "min-width": "120", prop: "outboundMete", "show-overflow-tooltip": "" }, b({ default: t(({ row: i }) => [n("div", { class: "clickable", onClick: y((g) => f(i, d.OUT.V), ["stop"]) }, h(i.outboundMete), 9, ve)]), _: 2 }, [e(m)(e(r).detail) ? { name: "header", fn: t(() => [l(v, { content: "点击行可以查看详情", effect: "light", placement: "top" }, { default: t(() => [n("div", _e, [o[5] || (o[5] = n("span", null, "出库量 ", -1)), l(Q, null, { default: t(() => [l(V)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : p("", true), e(u).visible("inventoryMete") ? (a(), s(c, { key: "inventoryMete", align: "right", label: "库存量", "min-width": "120", prop: "inventoryMete", "show-overflow-tooltip": "" }, b({ default: t(({ row: i }) => [n("div", { class: "clickable", onClick: y((g) => f(i, d.STOCK.V), ["stop"]) }, h(i.inventoryMete), 9, ye)]), _: 2 }, [e(m)(e(r).detail) ? { name: "header", fn: t(() => [l(v, { content: "点击行可以查看详情", effect: "light", placement: "top" }, { default: t(() => [n("div", be, [o[6] || (o[6] = n("span", null, "库存量 ", -1)), l(Q, null, { default: t(() => [l(V)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : p("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[R, e(C).loading]]), l(e(oe)), l(O, { visible: w.value, "onUpdate:visible": o[0] || (o[0] = (i) => w.value = i), "before-close": () => {
      w.value = false;
    }, title: (T = d.VL) == null ? void 0 : T[k.value.type], direction: "rtl", size: "80%" }, { titleRight: t(() => [D((a(), s(le, { fn: e(W), params: { ...k.value, times: e(C).query.times } }, { default: t(() => o[7] || (o[7] = [j("下载 ")])), _: 1, __: [7] }, 8, ["fn", "params"])), [[K, e(r).download]])]), content: t(() => [l(e(de), { "detail-row": k.value }, null, 8, ["detail-row"])]), _: 1 }, 8, ["visible", "before-close", "title"])]);
  };
} }, Ve = X(he, [["__scopeId", "data-v-2ee12d81"]]);
export {
  Ve as default
};
