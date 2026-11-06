import { ref as D } from "vue";
import { computed as V } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as d } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as a } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as i } from "vue";
import { createElementVNode as g } from "vue";
import { toDisplayString as v } from "vue";
import { ElTableColumn as j } from "element-plus";
import { vLoading as U } from "element-plus";
import { g as P, _ as B } from "./module/header.vue.js";
import { _ as Y, t as I, jY as O, jX as L, bD as M, D as r, x as W, Cc as F, o as H, j$ as m, pA as $, ux as q, P as G, ba as K, jN as X } from "../../../../../shared/runtime.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
const z = { class: "report-material-inbound-details app-container" }, J = { __name: "index", setup(Q) {
  const { decimalPrecision: p } = I();
  O();
  const N = { add: false, edit: false, del: false, download: false }, f = D(), y = V(() => [...L, ["invoiceType", ["parse-enum", M, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", p.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", p.value.wms]], ["amount", ["to-thousand", r.YUAN]], ["amountExcludingVAT", ["to-thousand", r.YUAN]], ["inputVAT", ["to-thousand", r.YUAN]], ["inboundReceipt.inboundTime", "parse-time"], ["inboundReceipt.reviewTime", "parse-time"], ["createTime", "parse-time"], ["project", "parse-project"], ["differentAmount", ["to-thousand", r.YUAN]], ["differentAmountExcludingVat", ["to-thousand", r.YUAN]]]), { CRUD: A, crud: b, columns: n } = W({ title: "入库明细", sort: ["id.desc"], invisibleColumns: [], permission: { ...F }, optShow: { ...N }, crudApi: { get: P } }, f), { maxHeight: x } = H({ paginate: true });
  A.HOOK.handleRefresh = async (u, { data: h }) => {
    h.content.map((s) => {
      s.inboundReceipt = { id: s.inboundId, serialNumber: s.serialNumber };
    });
  };
  function E(u) {
    return K(u, { props: ["quantity", ["mete", X.weight.precision], ["amount", r.YUAN], ["amountExcludingVAT", r.YUAN]], toThousandFields: ["amount", "amountExcludingVAT"] });
  }
  return (u, h) => {
    const s = w("table-cell-tag"), o = j, T = w("common-table"), k = U;
    return t(), R("div", z, [d(e(B), { DetailsCount: u.DetailsCount }, null, 8, ["DetailsCount"]), S((t(), a(T, { ref_key: "tableRef", ref: f, data: e(b).data, "data-format": y.value, "default-expand-all": false, "max-height": e(x), "summary-method": E, "highlight-current-row": "", "show-summary": "" }, { default: c(() => [d(o, { align: "center", label: "序号", type: "index", width: "60" }, { default: c(({ row: { sourceRow: l }, $index: C }) => {
      var _;
      return [l.inboundWay === e(m).OPENING_RECEIPT.V ? (t(), a(s, { key: 0, name: e(m).VL[l.inboundWay], color: (_ = e(m).V[l.inboundWay]) == null ? void 0 : _.COLOR }, null, 8, ["name", "color"])) : i("", true), g("span", null, v(C + 1), 1)];
    }), _: 1 }), e(n).visible("createTime") ? (t(), a(o, { key: "createTime", "show-overflow-tooltip": true, align: "left", label: "调整时间", prop: "createTime", width: "150" })) : i("", true), e(n).visible("adjustSerialNumber") ? (t(), a(o, { key: "adjustSerialNumber", "show-overflow-tooltip": true, align: "left", label: "价格调整单号", "min-width": "100", prop: "adjustSerialNumber" })) : i("", true), e(n).visible("materialSn") ? (t(), a(o, { key: "materialSn", "show-overflow-tooltip": true, align: "left", label: "物料编号", "min-width": "100", prop: "materialSn" })) : i("", true), e(n).visible("classifyName") ? (t(), a(o, { key: "classifyName", "show-overflow-tooltip": true, align: "left", label: "名称", "min-width": "100", prop: "classifyName" })) : i("", true), e(n).visible("specification") ? (t(), a(o, { key: "specification", "show-overflow-tooltip": true, align: "left", label: "规格", "min-width": "160", prop: "specification" }, { default: c(({ row: l }) => [g("span", null, v(e($)(l)), 1)]), _: 1 })) : i("", true), e(n).visible("brand") ? (t(), a(o, { key: "brand", "show-overflow-tooltip": true, align: "left", label: "品牌", prop: "brand", width: "100" })) : i("", true), e(n).visible("heatNoAndBatchNo") ? (t(), a(o, { key: "heatNoAndBatchNo", "show-overflow-tooltip": true, align: "left", label: "炉批号", prop: "heatNoAndBatchNo", width: "100" })) : i("", true), e(n).visible("project") ? (t(), a(o, { key: "project", "show-overflow-tooltip": true, align: "left", label: "项目", "min-width": "100", prop: "project" })) : i("", true), e(n).visible("serialNumber") ? (t(), a(o, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "入库单号", "min-width": "155", prop: "serialNumber" }, { default: c(({ row: l }) => [d(e(q), { receipt: l.inboundReceipt, "receipt-types": ["INBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : i("", true), e(n).visible("differentAmount") ? (t(), a(o, { key: "differentAmount", "show-overflow-tooltip": true, align: "left", label: "调整金额（含税）", "min-width": "100", prop: "differentAmount" })) : i("", true), e(n).visible("differentAmountExcludingVat") ? (t(), a(o, { key: "differentAmountExcludingVat", "show-overflow-tooltip": true, align: "left", label: "调整金额（不含税）", "min-width": "100", prop: "differentAmountExcludingVat" })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[k, e(b).loading]]), d(e(G))]);
  };
} }, oe = Y(J, [["__scopeId", "data-v-eb86acae"]]);
export {
  oe as default
};
