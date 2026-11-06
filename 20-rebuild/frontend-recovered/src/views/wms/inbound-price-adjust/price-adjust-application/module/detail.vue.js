import { inject as O } from "vue";
import { computed as l } from "vue";
import { ref as V } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as f } from "vue";
import { createBlock as x } from "vue";
import { withCtx as i } from "vue";
import { createVNode as t } from "vue";
import { unref as s } from "vue";
import { createElementVNode as E } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as S } from "vue";
import { createCommentVNode as N } from "vue";
import { createElementBlock as $ } from "vue";
import { Fragment as W } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElTag as G } from "element-plus";
import { _ as K, t as M, jX as z, bD as X, D as a, gt as Z, jY as J, o as Q, gS as ee, G as te, jZ as ae, V as oe, k0 as k, xl as se, w5 as m, i as F, cO as ie, jl as ne, xm as le, xn as ue, aR as re, jG as ce, jH as de, k5 as me, jI as pe, k6 as he, ba as fe, jN as ge } from "../../../../../shared/runtime.js";
const we = { style: "width:800px;padding-right:20px;padding-left:20px;", class: "mtb-10" }, _e = { __name: "detail", setup(xe) {
  const { decimalPrecision: u } = M(), j = O("permission"), P = l(() => [...z, ["invoiceType", ["parse-enum", X, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", u.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", u.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", u.value.wms]], ["unitPriceNoFreight", ["to-thousand", u.value.wms]], ["amount", ["to-thousand", a.YUAN]], ["amountExcludingVAT", ["to-thousand", a.YUAN]], ["amountNoFreight", ["to-thousand", a.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", a.YUAN]], ["inputVAT", ["to-thousand", a.YUAN]], ["inputVATNoFreight", ["to-thousand", a.YUAN]], ["remark", "empty-text"], ["monomerName", "empty-text"], ["areaName", "empty-text"]]), L = l(() => [["unitPrice", ["to-thousand", u.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", u.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", u.value.wms]], ["unitPriceNoFreight", ["to-thousand", u.value.wms]], ["amount", ["to-thousand", a.YUAN]], ["amountExcludingVAT", ["to-thousand", a.YUAN]], ["amountNoFreight", ["to-thousand", a.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", a.YUAN]], ["inputVAT", ["to-thousand", a.YUAN]], ["inputVATNoFreight", ["to-thousand", a.YUAN]], ["createTime", ["parse-time"]]]), C = V(), A = V([]), { CRUD: D, crud: p, detail: r } = Z(), { inboundFillWayCfg: v } = J(), { maxHeight: U } = Q({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => l(() => !p.detailLoading)), n = l(() => r.purchaseOrder || {}), Y = l(() => v.value ? v.value.amountFillWay === ee.APPLICATION.V : false), b = l(() => te(j.showAmount) || Y.value), y = l(() => {
    var c;
    return ((c = n.value) == null ? void 0 : c.supplyType) === ae.PARTY_A.V;
  }), R = l(() => p.detailLoading ? "入库单" : `入库单：${r.serialNumber}（ ${n.value.supplier ? n.value.supplier.name : "无供应商"} ）`), B = l(() => {
    const c = b.value && !y.value && n.value.projects && n.value.requisitionsSN, o = b.value && y.value && n.value.projects && n.value.requisitionsSN;
    return !(c || o);
  });
  D.HOOK.beforeDetailLoaded = async (c, o) => {
    o.originList = oe(o.list), o.list = o.originList.filter((e) => e.qualityTestingEnum & (k.ALL_PASS.V | k.NO.V) && e.rejectStatus === se.NONE.V), o.list.forEach((e) => {
      var g, h, w;
      e.uncheckAble = ((g = e.adjustDetailList) == null ? void 0 : g.findIndex((d) => d.reviewStatus === m.UNREVIEWED.V)) > -1, e.tagShow = F(e.adjustDetailList) ? e.uncheckAble ? "调整待审" : "调整" + (e.adjustDetailList[0].reviewStatus === m.PASS.V ? "过" : e.adjustDetailList[0].reviewStatus === m.REFUSE.V ? "驳回" : "撤销") : "", e.tagColor = F(e.adjustDetailList) ? e.uncheckAble ? "#409EFF" : (w = m.V[(h = e.adjustDetailList[0]) == null ? void 0 : h.reviewStatus]) == null ? void 0 : w.O_COLOR : "";
    }), await ie(o.list), o.list = await ne(o.list, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
  };
  function I(c) {
    return fe(c, { props: ["quantity", ["mete", ge.weight.precision], ["amount", a.YUAN], ["amountExcludingVAT", a.YUAN], ["inputVAT", a.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT"] });
  }
  return (c, o) => {
    const e = q, g = G, h = T("common-table"), w = T("common-drawer");
    return f(), x(w, { ref_key: "drawerRef", ref: C, "before-close": s(p).cancelDetail, "content-loading": s(p).detailLoading, "show-close": true, title: R.value, visible: s(p).detailVisible, "custom-class": "raw-mat-inbound-application-record-detail", size: "100%" }, { titleAfter: i(() => [t(le, { detail: s(r), order: n.value }, null, 8, ["detail", "order"])]), titleRight: i(() => [t(ue, { "purchase-id": n.value.id, size: "default" }, null, 8, ["purchase-id"])]), content: i(() => [t(h, { data: s(r).list, "data-format": P.value, "expand-row-keys": A.value, "max-height": s(U), "summary-method": I, "row-key": "id", "show-summary": "" }, { default: i(() => [t(re, { "expand-row-keys": A.value, "onUpdate:expandRowKeys": o[0] || (o[0] = (d) => A.value = d), data: s(r).list, stripe: false, fixed: "left", "row-key": "id", style: { background: "#f4f4f5" } }, { default: i(({ row: { sourceRow: d } }) => [E("div", we, [(f(), x(h, { key: d.id, data: d.adjustDetailList, "data-format": L.value, "header-cell-style": { background: "#f0f9eb !important" }, stripe: false, style: { "margin-bottom": "10px" } }, { default: i(() => [t(e, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), t(e, { align: "center", label: "历史调整" }, { default: i(() => [t(e, { align: "left", label: "含税金额", "min-width": "120px", prop: "Amount", "show-overflow-tooltip": "" }), t(e, { align: "left", label: "不含税金额", "min-width": "120px", prop: "AmountExcludingVat", "show-overflow-tooltip": "" }), t(e, { align: "left", label: "税额", "min-width": "120px", prop: "inputVat", "show-overflow-tooltip": "" })]), _: 1 }), t(e, { label: "状态", prop: "reviewStatus" }, { default: i(({ row: _ }) => [t(g, { type: s(m).V[_.reviewStatus].TAG }, { default: i(() => [H(S(s(m).VL[_.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 2 }, 1024), t(e, { align: "center", label: "调整日期", "min-width": "120px", prop: "createTime", "show-overflow-tooltip": "" }), t(e, { align: "center", label: "调整单号", prop: "serialNumber", "show-overflow-tooltip": "", width: "120px" })]), _: 2 }, 1032, ["data", "data-format"]))])]), _: 1 }, 8, ["expand-row-keys", "data"]), t(e, { align: "center", label: "序号", type: "index", width: "55" }, { default: i(({ row: d, $index: _ }) => [E("span", null, S(_ + 1), 1)]), _: 1 }), t(ce, { "basic-class": s(r).basicClass, showIndex: false }, null, 8, ["basic-class"]), t(de, { "basic-class": s(r).basicClass }, null, 8, ["basic-class"]), B.value ? (f(), x(me, { key: 0, "basic-class": s(r).basicClass }, null, 8, ["basic-class"])) : N("", true), b.value ? (f(), $(W, { key: 1 }, [y.value ? N("", true) : (f(), x(pe, { key: 0, showFreight: false }))], 64)) : N("", true), t(e, { align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" }), t(he)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, ye = K(_e, [["__scopeId", "data-v-ee97e3dc"]]);
export {
  ye as default
};
