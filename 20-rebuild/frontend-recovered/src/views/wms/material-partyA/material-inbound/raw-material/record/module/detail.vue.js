import { inject as B } from "vue";
import { computed as o } from "vue";
import { ref as x } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as i } from "vue";
import { createBlock as u } from "vue";
import { withCtx as m } from "vue";
import { createVNode as l } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as f } from "vue";
import { createElementVNode as A } from "vue";
import { createTextVNode as U } from "vue";
import { toDisplayString as $ } from "vue";
import { createElementBlock as I } from "vue";
import { Fragment as L } from "vue";
import { ElTableColumn as F } from "element-plus";
import { _ as H, t as Y, jX as M, bD as O, D as c, gt as W, jY as q, o as z, gS as G, G as K, jZ as X, j_ as Z, j$ as J, cO as Q, jl as ee, xm as ae, xn as te, aR as se, k4 as oe, jG as le, jH as ne, k5 as ie, zE as re, ba as ue, jN as ce } from "../../../../../../../shared/runtime.js";
import { _ as me } from "../../../../../../../modules/index-4b5f34f4.js";
const de = { __name: "detail", setup(pe) {
  const { decimalPrecision: h } = Y(), N = B("permission"), T = o(() => [...M, ["invoiceType", ["parse-enum", O, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", h.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", h.value.wms]], ["amount", ["to-thousand", c.YUAN]], ["amountExcludingVAT", ["to-thousand", c.YUAN]], ["inputVAT", ["to-thousand", c.YUAN]], ["remark", "empty-text"], ["monomerName", "empty-text"], ["areaName", "empty-text"]]), k = x(), _ = x([]), { CRUD: C, crud: r, detail: e } = W(), { inboundFillWayCfg: v } = q(), { maxHeight: E } = z({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => o(() => !r.detailLoading)), s = o(() => e.purchaseOrder || {}), V = o(() => v.value ? v.value.amountFillWay === G.APPLICATION.V : false), w = o(() => K(N.showAmount) && V.value), b = o(() => {
    var n;
    return ((n = s.value) == null ? void 0 : n.supplyType) === X.PARTY_A.V;
  }), j = o(() => e.basicClass & Z.MANUFACTURED.V), S = o(() => e.inboundWay === J.OPENING_RECEIPT.V ? r.detailLoading ? "入库单" : `入库单：${e.serialNumber}` : r.detailLoading ? "入库单" : `入库单：${e.serialNumber}（ ${s.value.supplier ? s.value.supplier.name : "无供应商"} ）`), y = o(() => {
    const n = w.value && !b.value && s.value.projects && s.value.requisitionsSN, t = w.value && b.value && s.value.projects && s.value.requisitionsSN;
    return !(n || t);
  });
  C.HOOK.beforeDetailLoaded = async (n, t) => {
    await Q(t.list), t.list = await ee(t.list, { toSmallest: false, toNum: false });
  };
  function P(n) {
    return ue(n, { props: ["quantity", ["mete", ce.weight.precision], ["amount", c.YUAN], ["amountExcludingVAT", c.YUAN], ["inputVAT", c.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT"] });
  }
  return (n, t) => {
    const d = F, D = g("common-table"), R = g("common-drawer");
    return i(), u(R, { ref_key: "drawerRef", ref: k, "before-close": a(r).cancelDetail, "content-loading": a(r).detailLoading, "show-close": true, title: S.value, visible: a(r).detailVisible, "custom-class": "raw-mat-inbound-application-record-detail", size: "100%" }, { titleAfter: m(() => [l(ae, { detail: a(e), order: s.value }, null, 8, ["detail", "order"])]), titleRight: m(() => [l(te, { "purchase-id": s.value.id, size: "default" }, null, 8, ["purchase-id"])]), content: m(() => [l(D, { data: a(e).list, "data-format": T.value, "expand-row-keys": _.value, "max-height": a(E), "summary-method": P, "row-key": "id", "show-summary": "" }, { default: m(() => [l(se, { "expand-row-keys": _.value, "onUpdate:expandRowKeys": t[0] || (t[0] = (p) => _.value = p), data: a(e).list, fixed: "left", "row-key": "id" }, { default: m(({ row: p }) => [y.value ? f("", true) : (i(), u(oe, { key: 0, "basic-class": a(e).basicClass, row: p, "show-brand": "" }, null, 8, ["basic-class", "row"])), A("p", null, [t[1] || (t[1] = U(" 备注：")), A("span", null, $(p.remark), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), l(le, { "basic-class": a(e).basicClass, fixed: "left" }, null, 8, ["basic-class"]), l(ne, { "basic-class": a(e).basicClass }, null, 8, ["basic-class"]), y.value ? (i(), u(ie, { key: 0, "basic-class": a(e).basicClass }, null, 8, ["basic-class"])) : f("", true), w.value ? (i(), I(L, { key: 1 }, [b.value ? f("", true) : (i(), u(re, { key: 0 }))], 64)) : f("", true), l(d, { align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" }), l(d, { align: "left", label: "单体", "min-width": "120px", prop: "monomerName", "show-overflow-tooltip": "" }), l(d, { align: "left", label: "区域", "min-width": "120px", prop: "areaName", "show-overflow-tooltip": "" }), j.value ? (i(), u(d, { key: 3, align: "left", label: "仓库", "min-width": "120px", prop: "workshop.name", "show-overflow-tooltip": "" })) : (i(), u(me, { key: 2 }))]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, be = H(de, [["__scopeId", "data-v-21acc41a"]]);
export {
  be as default
};
