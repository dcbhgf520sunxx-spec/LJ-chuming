import { ref as R } from "vue";
import { computed as x } from "vue";
import { watch as H } from "vue";
import { resolveComponent as K } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as Q } from "vue";
import { createVNode as g } from "vue";
import { unref as t } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as n } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as c } from "vue";
import { createCommentVNode as u } from "vue";
import { toDisplayString as p } from "vue";
import { createTextVNode as X } from "vue";
import { ElTableColumn as z } from "element-plus";
import { vLoading as J } from "element-plus";
import { g as Z, a as ee } from "../../../../../../modules/external-sales-details-a890aa63.js";
import { _ as te, t as ie, jX as oe, bD as k, D as r, x as ae, C9 as M, o as le, G as ne, sQ as ue, cO as U, bl as se, jP as re, bR as S, jl as W, j_ as ce, x_ as pe, k5 as de, jH as me, vb as he, k6 as be, ux as fe, P as ge, ba as we, jN as A } from "../../../../../../shared/runtime.js";
import ve from "./module/header.vue.js";
import { M as Te } from "../../../../../../modules/index-a46d8bb8.js";
import "../../../../../../modules/reset-query-5216307c.js";
const _e = { class: "report-material-inbound-details app-container" }, ye = { __name: "index", setup(De) {
  ie();
  const B = { add: false, edit: false, del: false, download: false }, I = R([]), E = R(), j = x(() => [...oe, ["invoiceType", ["parse-enum", k, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", r.YUAN]], ["unitPriceExcludingVAT", ["to-thousand", r.YUAN]], ["amount", ["to-thousand", r.YUAN]], ["amountExcludingVAT", ["to-thousand", r.YUAN]], ["inputVAT", ["to-thousand", r.YUAN]], ["sellUnitPrice", ["to-thousand", r.YUAN]], ["sellAmount", ["to-thousand", r.YUAN]], ["sellInputVat", ["to-thousand", r.YUAN]], ["outboundTime", "parse-time"], ["outboundReceipt.outboundTime", "parse-time"], ["outboundReceipt.reviewTime", "parse-time"], ["outboundReceipt.createTime", "parse-time"]]), { CRUD: L, crud: h, columns: o } = ae({ title: "对外出售明细", sort: ["id.desc"], invisibleColumns: ["outboundReceipt.applicantName", "outboundReceipt.reviewerName", "outboundReceipt.editorName", "outboundReceipt.createTime", "heatNoAndBatchNo", "mete", "brand", "unitPrice", "unitPriceExcludingVAT", "amount", "amountExcludingVAT", "inputVAT"], permission: { ...M }, optShow: { ...B }, crudApi: { get: Z } }, E), { maxHeight: Y } = le({ paginate: true }), F = x(() => ne(M.showAmount)), b = x(() => h.query ? h.query.basicClass : void 0), { baseUnit: V } = ue(b.value), D = R();
  function C(v) {
    return v.replace(/[\(\)]/g, function(d) {
      return d === "(" ? "（" : "）";
    });
  }
  L.HOOK.handleRefresh = async (v, { data: d }) => {
    await U(d.content), d.content.forEach((e) => {
      var f, y, i, T, _;
      if (e.outboundReceipt || (e.outboundReceipt = {}), e.outboundTime = (f = e.outboundReceipt) == null ? void 0 : f.outboundTime, e.sellUnitPrice = (y = e.outboundDetailSellDTO) == null ? void 0 : y.sellUnitPrice, e.sellAmount = (i = e.outboundDetailSellDTO) == null ? void 0 : i.sellAmount, e.sellInputVat = (T = e.outboundDetailSellDTO) == null ? void 0 : T.sellInputVat, e.purchaser = (_ = e.outboundDetailSellDTO) == null ? void 0 : _.purchaser, e.specification && e.specMerge.indexOf(e.specification) > -1 && (e.specification = C(e.specification), e.specMerge = C(e.specMerge), e.specMerge = e.specMerge.replace(new RegExp(`\\${e.specification}`, "g"), "")), e.basicClass === se.SECTION_STEEL.V) {
        const w = e.specification.split("*");
        for (let m = 0; m < w.length; m++) w[m] = w[m].trim();
        const O = [];
        for (const m in e.specKV) if (m.indexOf("standard") < 0) {
          O.push(e.specKV[m]);
          const P = w.findIndex((q) => q === e.specKV[m]);
          P > -1 && w.splice(P, 1);
        }
        e.specification = O.join("*"), e.standard = w.join("*");
      }
      e.basicClass & re.STEEL.V && (e.theoryTotalWeight = e.outboundDetailSellDTO.weightMeasurementMode === S.THEORY.V ? e.outboundDetailSellDTO.inputMete : "-", e.weighingWeight = e.outboundDetailSellDTO.weightMeasurementMode === S.OVERWEIGHT.V ? e.outboundDetailSellDTO.inputMete : "-"), e.inboundReceipt || (e.inboundReceipt = {});
    }), d.content = await W(d.content, { toSmallest: false, toNum: false }, { mete: ["mete", "theoryTotalWeight", "weighingWeight"], amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight", "sellUnitPrice"] });
    const a = [];
    d.content.forEach((e) => {
      Array.isArray(e.rejectList) && e.rejectList.forEach((f) => {
        a.push(f.material);
      });
    }), await U(a), await W(a, { toSmallest: false, toNum: false }, { mete: ["mete", "theoryTotalWeight", "weighingWeight"], amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
  }, H(() => h.query, async () => {
    D.value = await ee(h.query), b.value & ce.STEEL.V && await pe(D.value, { unit: V.value[b.value].weight.unit, precision: V.value[b.value].weight.precision, fields: ["meteCount"], toSmallest: false, toNum: true });
  }, { deep: true, immutable: true });
  function $(v) {
    return we(v, { props: ["quantity", ["mete", A.weight.precision], ["weighingWeight", A.weight.precision], ["theoryTotalWeight", A.weight.precision], ["amount", r.YUAN], ["amountExcludingVAT", r.YUAN], ["amountNoFreight", r.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "amountNoFreight"] });
  }
  return (v, d) => {
    const a = z, e = K("common-table"), f = G("parse-time"), y = J;
    return l(), Q("div", _e, [g(t(ve), { DetailsCount: D.value }, null, 8, ["DetailsCount"]), N((l(), n(e, { ref_key: "tableRef", ref: E, data: t(h).data, "data-format": j.value, "default-expand-all": false, "expand-row-keys": I.value, "max-height": t(Y), "summary-method": $, "highlight-current-row": "", "row-key": "id", "show-summary": "", onSortChange: t(h).handleSortChange }, { default: s(() => [g(Te, { "basic-class": b.value, columns: t(o), "spec-merge": false, "classify-name-alias": "名称", "model-name-label": "型号", "reject-detail-viewable": "", "show-classification": "", "show-reject-status": "", sortable: "", "spec-only": "" }, { afterIndex: s(() => [t(o).visible("outboundTime") ? (l(), n(a, { key: "outboundTime", "show-overflow-tooltip": true, align: "center", label: "出库时间", prop: "outboundTime", sortable: "custom", width: "125" }, { default: s(({ row: i }) => [N(c("span", null, null, 512), [[f, i.outboundReceipt.outboundTime]])]), _: 1 })) : u("", true), t(o).visible("outboundReceipt.reviewTime") ? (l(), n(a, { key: "outboundReceipt.reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "outboundReceipt.reviewTime", width: "125" }, { default: s(({ row: i }) => [N(c("span", null, null, 512), [[f, i.outboundReceipt.reviewTime]])]), _: 1 })) : u("", true)]), _: 1 }, 8, ["basic-class", "columns"]), t(o).visible("heatNoAndBatchNo") ? (l(), n(a, { key: "heatNoAndBatchNo", "show-overflow-tooltip": false, align: "center", label: "炉批号/卷号", "min-width": "150px", prop: "heatNoAndBatchNo" }, { default: s(({ row: { sourceRow: i } }) => [c("span", null, p(i.heatNoAndBatchNo || "-"), 1)]), _: 1 })) : u("", true), g(de, { "basic-class": b.value, columns: t(o) }, null, 8, ["basic-class", "columns"]), g(me, { "basic-class": b.value, columns: t(o) }, null, 8, ["basic-class", "columns"]), F.value ? (l(), n(he, { key: 1, columns: t(o), "show-invoice-type": "", "show-unit-price-e": "" }, null, 8, ["columns"])) : u("", true), t(o).visible("outboundDetailSellDTO.weightMeasurementMode") ? (l(), n(a, { key: "outboundDetailSellDTO.weightMeasurementMode", "show-overflow-tooltip": false, align: "center", label: "计量方式", "min-width": "150px", prop: "outboundDetailSellDTO.weightMeasurementMode" }, { default: s(({ row: { sourceRow: i } }) => [c("span", null, p(t(S).VL[i.outboundDetailSellDTO.weightMeasurementMode] || "-"), 1)]), _: 1 })) : u("", true), t(o).visible("theoryTotalWeight") ? (l(), n(a, { key: "theoryTotalWeight", "show-overflow-tooltip": false, align: "center", label: "理论重量", "min-width": "150px", prop: "theoryTotalWeight" }, { default: s(({ row: { sourceRow: i } }) => [c("span", null, p(i.theoryTotalWeight || "-"), 1)]), _: 1 })) : u("", true), t(o).visible("weighingWeight") ? (l(), n(a, { key: "weighingWeight", "show-overflow-tooltip": false, align: "center", label: "过磅重量", "min-width": "150px", prop: "weighingWeight" }, { default: s(({ row: { sourceRow: i } }) => [c("span", null, p(i.weighingWeight || "-"), 1)]), _: 1 })) : u("", true), t(o).visible("outboundDetailSellDTO.invoiceType") ? (l(), n(a, { key: "outboundDetailSellDTO.invoiceType", "show-overflow-tooltip": false, align: "center", label: "出售票据类型", "min-width": "150px", prop: "outboundDetailSellDTO.invoiceType" }, { default: s(({ row: { sourceRow: i } }) => [c("span", null, p(t(k).VL[i.outboundDetailSellDTO.invoiceType] || "-"), 1)]), _: 1 })) : u("", true), t(o).visible("outboundDetailSellDTO.taxRate") ? (l(), n(a, { key: "outboundDetailSellDTO.taxRate", "show-overflow-tooltip": false, align: "center", label: "出售税率", "min-width": "150px", prop: "taxRate" }, { default: s(({ row: { sourceRow: i } }) => [c("span", null, p(i.outboundDetailSellDTO.taxRate ? ` ${i.outboundDetailSellDTO.taxRate}% ` : "-"), 1)]), _: 1 })) : u("", true), t(o).visible("sellUnitPrice") ? (l(), n(a, { key: "sellUnitPrice", "show-overflow-tooltip": false, align: "center", label: "出售单价", "min-width": "150px", prop: "sellUnitPrice" })) : u("", true), t(o).visible("sellAmount") ? (l(), n(a, { key: "sellAmount", "show-overflow-tooltip": false, align: "center", label: "出售金额", "min-width": "150px", prop: "sellAmount" })) : u("", true), t(o).visible("sellInputVat") ? (l(), n(a, { key: "sellInputVat", "show-overflow-tooltip": false, align: "center", label: "出售进项税", "min-width": "150px", prop: "sellInputVat" }, { default: s(({ row: i }) => [c("span", null, p(i.sellInputVat || "-"), 1)]), _: 1 })) : u("", true), g(be, { columns: t(o) }, null, 8, ["columns"]), t(o).visible("outboundReceipt.serialNumber") ? (l(), n(a, { key: "outboundReceipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "出库单号", "min-width": "155", prop: "outboundReceipt.serialNumber" }, { default: s(({ row: i }) => [g(t(fe), { receipt: i.outboundReceipt, "receipt-types": ["OUTBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : u("", true), t(o).visible("branchCompany") ? (l(), n(a, { key: "branchCompany", "show-overflow-tooltip": true, label: "关联交易单位", "min-width": "200", prop: "branchCompany" }, { default: s(({ row: i }) => {
      var T, _;
      return [c("span", null, p(((_ = (T = i.outboundDetailSellDTO) == null ? void 0 : T.branchCompany) == null ? void 0 : _.name) || "-"), 1)];
    }), _: 1 })) : u("", true), t(o).visible("purchaser") ? (l(), n(a, { key: "purchaser", "show-overflow-tooltip": true, label: "购买方", "min-width": "120", prop: "purchaser" })) : u("", true), t(o).visible("outboundReceipt.applicantName") ? (l(), n(a, { key: "outboundReceipt.applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "outboundReceipt.applicantName" })) : u("", true), t(o).visible("outboundReceipt.editorName") ? (l(), n(a, { key: "outboundReceipt.editorName", "show-overflow-tooltip": true, align: "center", label: "编辑人", "min-width": "100", prop: "outboundReceipt.editorName" })) : u("", true), t(o).visible("outboundReceipt.reviewerName") ? (l(), n(a, { key: "outboundReceipt.reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "outboundReceipt.reviewerName" })) : u("", true), t(o).visible("outboundReceipt.createTime") ? (l(), n(a, { key: "outboundReceipt.createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "outboundReceipt.createTime", width: "125" }, { default: s(({ row: i }) => [X(p(i.outboundReceipt.createTime), 1)]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[y, t(h).loading]]), g(t(ge))]);
  };
} }, Ve = te(ye, [["__scopeId", "data-v-59afc1f4"]]);
export {
  Ve as default
};
