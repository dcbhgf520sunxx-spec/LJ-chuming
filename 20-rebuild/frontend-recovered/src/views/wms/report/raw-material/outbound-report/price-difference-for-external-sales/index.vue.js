import { ref as x } from "vue";
import { computed as A } from "vue";
import { watch as z } from "vue";
import { resolveComponent as Q } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as J } from "vue";
import { createVNode as _ } from "vue";
import { unref as a } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as n } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as r } from "vue";
import { createCommentVNode as u } from "vue";
import { toDisplayString as c } from "vue";
import { normalizeStyle as k } from "vue";
import { ElTableColumn as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { g as te, a as ae } from "../../../../../../modules/external-sales-details-a890aa63.js";
import { _ as ie, t as oe, jX as le, bD as U, D as d, x as ne, Cb as B, o as se, G as ue, sQ as re, cO as I, bl as ce, jP as pe, bR as S, jl as W, j_ as de, x_ as me, k5 as he, jH as fe, vb as be, k6 as ge, ux as _e, bV as j, P as ve, ba as we, jN as Te } from "../../../../../../shared/runtime.js";
import ye from "./module/header.vue.js";
import { M as De } from "../../../../../../modules/index-a46d8bb8.js";
import "../../../../../../modules/index-5b9e6004.js";
import "../../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../../modules/reset-query-5216307c.js";
const xe = { class: "report-material-inbound-details app-container" }, Ae = { __name: "index", setup(Se) {
  const { decimalPrecision: N } = oe(), L = { add: false, edit: false, del: false, download: false }, F = x([]), M = x(), Y = A(() => [...le, ["invoiceType", ["parse-enum", U, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", N.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", N.value.wms]], ["amount", ["to-thousand", d.YUAN]], ["amountExcludingVAT", ["to-thousand", d.YUAN]], ["outboundDetailSellDTO.profitAmount", ["to-thousand", d.YUAN]], ["sellAmount", ["to-thousand", d.YUAN]], ["inputVAT", ["to-thousand", d.YUAN]], ["sellInputVat", ["to-thousand", d.YUAN]], ["sellUnitPrice", ["to-thousand", d.YUAN]], ["outboundTime", "parse-time"]]), { CRUD: $, crud: b, columns: i } = ne({ title: "对外销售差异表", sort: ["id.desc"], invisibleColumns: ["heatNoAndBatchNo", "warehouse", "mete", "brand", "unitPrice", "unitPriceExcludingVAT", "amount", "amountExcludingVAT", "inputVAT"], permission: { ...B }, optShow: { ...L }, crudApi: { get: te } }, M), { maxHeight: q } = se({ paginate: true }), H = A(() => ue(B.showAmount)), g = A(() => b.query ? b.query.basicClass : void 0), { baseUnit: E } = re(g.value), D = x();
  function V(T) {
    return T.replace(/[\(\)]/g, function(m) {
      return m === "(" ? "（" : "）";
    });
  }
  $.HOOK.handleRefresh = async (T, { data: m }) => {
    await I(m.content), m.content.forEach((e) => {
      var v, y, t, p, h, R;
      if (e.outboundReceipt || (e.outboundReceipt = {}), e.outboundTime = (v = e.outboundReceipt) == null ? void 0 : v.outboundTime, e.sellUnitPrice = (y = e.outboundDetailSellDTO) == null ? void 0 : y.sellUnitPrice, e.sellAmount = (t = e.outboundDetailSellDTO) == null ? void 0 : t.sellAmount, e.sellInputVat = (p = e.outboundDetailSellDTO) == null ? void 0 : p.sellInputVat, e.purchaser = (h = e.outboundDetailSellDTO) == null ? void 0 : h.purchaser, e.specification && e.specMerge.indexOf(e.specification) > -1 && (e.specification = V(e.specification), e.specMerge = V(e.specMerge), e.specMerge = e.specMerge.replace(new RegExp(`\\${e.specification}`, "g"), "")), e.basicClass === ce.SECTION_STEEL.V) {
        const w = e.specification.split("*");
        for (let f = 0; f < w.length; f++) w[f] = w[f].trim();
        const P = [];
        for (const f in e.specKV) if (f.indexOf("standard") < 0) {
          P.push(e.specKV[f]);
          const C = w.findIndex((G) => G === e.specKV[f]);
          C > -1 && w.splice(C, 1);
        }
        e.specification = P.join("*"), e.standard = w.join("*");
      }
      e.basicClass & pe.STEEL.V && (e.theoryTotalWeight = e.outboundDetailSellDTO.weightMeasurementMode === S.THEORY.V ? e.outboundDetailSellDTO.inputMete : "-", e.weighingWeight = e.outboundDetailSellDTO.weightMeasurementMode === S.OVERWEIGHT.V ? e.outboundDetailSellDTO.inputMete : "-"), e.differenceMete = (R = e.outboundDetailSellDTO) == null ? void 0 : R.differenceMete;
    }), m.content = await W(m.content, { toSmallest: false, toNum: false }, { mete: ["mete", "theoryTotalWeight", "weighingWeight", "differenceMete"], amount: ["unitPriceNoFreight", "unitPrice", "sellUnitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
    const o = [];
    m.content.forEach((e) => {
      Array.isArray(e.rejectList) && e.rejectList.forEach((v) => {
        o.push(v.material);
      });
    }), await I(o), await W(o, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
  }, z(() => b.query, async () => {
    D.value = await ae(b.query), g.value & de.STEEL.V && await me(D.value, { unit: E.value[g.value].weight.unit, precision: E.value[g.value].weight.precision, fields: ["meteCount", "differenceMeteSum"], toSmallest: false, toNum: true });
  }, { deep: true, immutable: true });
  function K(T) {
    return we(T, { props: ["quantity", ["mete", Te.weight.precision], "weighingWeight", "theoryTotalWeight", ["amount", d.YUAN], ["amountExcludingVAT", d.YUAN], ["amountNoFreight", d.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "amountNoFreight"] });
  }
  return (T, m) => {
    const o = Z, e = Q("common-table"), v = X("parse-time"), y = ee;
    return l(), J("div", xe, [_(a(ye), { DetailsCount: D.value }, null, 8, ["DetailsCount"]), O((l(), n(e, { ref_key: "tableRef", ref: M, data: a(b).data, "data-format": Y.value, "default-expand-all": false, "expand-row-keys": F.value, "max-height": a(q), "summary-method": K, "highlight-current-row": "", "row-key": "id", "show-summary": "", onSortChange: a(b).handleSortChange }, { default: s(() => [_(De, { "basic-class": g.value, columns: a(i), "spec-merge": false, "classify-name-alias": "名称", "model-name-label": "型号", "reject-detail-viewable": "", "show-classification": "", "show-reject-status": "", sortable: "", "spec-only": "" }, { afterIndex: s(() => [a(i).visible("outboundTime") ? (l(), n(o, { key: "outboundTime", "show-overflow-tooltip": true, align: "center", label: "出库时间", prop: "outboundTime", sortable: "custom", width: "125" }, { default: s(({ row: t }) => [O(r("span", null, null, 512), [[v, t.outboundReceipt.outboundTime]])]), _: 1 })) : u("", true)]), _: 1 }, 8, ["basic-class", "columns"]), a(i).visible("heatNoAndBatchNo") ? (l(), n(o, { key: "heatNoAndBatchNo", "show-overflow-tooltip": false, align: "center", label: "炉批号/卷号", "min-width": "150px", prop: "heatNoAndBatchNo" }, { default: s(({ row: { sourceRow: t } }) => [r("span", null, c(t.heatNoAndBatchNo || "-"), 1)]), _: 1 })) : u("", true), _(he, { "basic-class": g.value, columns: a(i) }, null, 8, ["basic-class", "columns"]), _(fe, { "basic-class": g.value, columns: a(i) }, null, 8, ["basic-class", "columns"]), a(i).visible("theoryTotalWeight") ? (l(), n(o, { key: "theoryTotalWeight", "show-overflow-tooltip": false, align: "center", label: "理论重量", "min-width": "150px", prop: "theoryTotalWeight" }, { default: s(({ row: { sourceRow: t } }) => [r("span", null, c(t.theoryTotalWeight || "-"), 1)]), _: 1 })) : u("", true), a(i).visible("weighingWeight") ? (l(), n(o, { key: "weighingWeight", "show-overflow-tooltip": false, align: "center", label: "过磅重量", "min-width": "150px", prop: "weighingWeight" }, { default: s(({ row: { sourceRow: t } }) => [r("span", null, c(t.weighingWeight || "-"), 1)]), _: 1 })) : u("", true), a(i).visible("weightMeasurementMode") ? (l(), n(o, { key: "weightMeasurementMode", "show-overflow-tooltip": false, align: "center", label: "计量方式", "min-width": "150px", prop: "weightMeasurementMode" }, { default: s(({ row: { sourceRow: t } }) => [r("span", null, c(a(S).VL[t.outboundDetailSellDTO.weightMeasurementMode] || "-"), 1)]), _: 1 })) : u("", true), H.value ? (l(), n(be, { key: 4, columns: a(i), "show-invoice-type": "", "show-unit-price-e": "" }, null, 8, ["columns"])) : u("", true), a(i).visible("invoiceType") ? (l(), n(o, { key: "invoiceType", "show-overflow-tooltip": false, align: "center", label: "出售票据类型", "min-width": "150px", prop: "taxRate" }, { default: s(({ row: { sourceRow: t } }) => [r("span", null, c(a(U).VL[t.invoiceType] || "-"), 1)]), _: 1 })) : u("", true), a(i).visible("taxRate") ? (l(), n(o, { key: "taxRate", "show-overflow-tooltip": false, align: "center", label: "出售税率", "min-width": "150px", prop: "taxRate" }, { default: s(({ row: { sourceRow: t } }) => [r("span", null, c(t.taxRate ? ` ${t.taxRate}% ` : "-"), 1)]), _: 1 })) : u("", true), a(i).visible("sellUnitPrice") ? (l(), n(o, { key: "unitPrice", "show-overflow-tooltip": false, align: "center", label: "出售单价", "min-width": "150px", prop: "sellUnitPrice" }, { default: s(({ row: t }) => [r("span", null, c(t.sellUnitPrice || "-"), 1)]), _: 1 })) : u("", true), a(i).visible("sellAmount") ? (l(), n(o, { key: "sellUnitPrice", "show-overflow-tooltip": false, align: "center", label: "出售金额", "min-width": "150px", prop: "sellAmount" }, { default: s(({ row: t }) => [r("span", null, c(t.sellAmount || "-"), 1)]), _: 1 })) : u("", true), a(i).visible("sellInputVat") ? (l(), n(o, { key: "sellInputVat", "show-overflow-tooltip": false, align: "center", label: "出售进项税", "min-width": "150px", prop: "sellInputVat" }, { default: s(({ row: t }) => [r("span", null, c(t.sellInputVat || "-"), 1)]), _: 1 })) : u("", true), _(ge, { columns: a(i) }, null, 8, ["columns"]), a(i).visible("outboundReceipt.serialNumber") ? (l(), n(o, { key: "outboundReceipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "出库单号", "min-width": "155", prop: "outboundReceipt.serialNumber" }, { default: s(({ row: t }) => [_(a(_e), { receipt: t.outboundReceipt, "receipt-types": ["OUTBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : u("", true), a(i).visible("branchCompany") ? (l(), n(o, { key: "branchCompany", "show-overflow-tooltip": true, label: "关联交易单位", "min-width": "200", prop: "branchCompany" }, { default: s(({ row: t }) => {
      var p, h;
      return [r("span", null, c(((h = (p = t.outboundDetailSellDTO) == null ? void 0 : p.branchCompany) == null ? void 0 : h.name) || "-"), 1)];
    }), _: 1 })) : u("", true), a(i).visible("purchaser") ? (l(), n(o, { key: "purchaser", "show-overflow-tooltip": true, label: "购买方", "min-width": "120", prop: "purchaser" })) : u("", true), a(i).visible("outboundDetailSellDTO.differenceMete") ? (l(), n(o, { key: "outboundDetailSellDTO.differenceMete", "show-overflow-tooltip": true, label: "重量差异", "min-width": "200", prop: "outboundDetailSellDTO.differenceMete" }, { default: s(({ row: { sourceRow: t } }) => {
      var p;
      return [r("span", { style: k(`color:${((p = t.outboundDetailSellDTO) == null ? void 0 : p.differenceMete) >= 0 ? "#67c23a" : "#fa0303"}`) }, c(a(j)(t.differenceMete) || "-"), 5)];
    }), _: 1 })) : u("", true), a(i).visible("outboundDetailSellDTO.profitAmount") ? (l(), n(o, { key: "outboundDetailSellDTO.profitAmount", "show-overflow-tooltip": true, label: "价格差异", "min-width": "200", prop: "outboundDetailSellDTO.profitAmount" }, { default: s(({ row: { sourceRow: t } }) => {
      var p, h;
      return [r("span", { style: k(`color:${((p = t.outboundDetailSellDTO) == null ? void 0 : p.profitAmount) >= 0 ? "#67c23a" : "#fa0303"}`) }, c(a(j)((h = t.outboundDetailSellDTO) == null ? void 0 : h.profitAmount) || "-"), 5)];
    }), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[y, a(b).loading]]), _(a(ve))]);
  };
} }, ke = ie(Ae, [["__scopeId", "data-v-df715a16"]]);
export {
  ke as default
};
