import { ref as w } from "vue";
import { watch as R } from "vue";
import { resolveComponent as g } from "vue";
import { withDirectives as N } from "vue";
import { vShow as U } from "vue";
import { unref as t } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as a } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as z } from "vue";
import { toDisplayString as h } from "vue";
import { renderSlot as W } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElTag as j } from "element-plus";
import { ElTableColumn as B } from "element-plus";
import { ElPagination as L } from "element-plus";
import { vLoading as K } from "element-plus";
import { h as Y } from "../../../../../../modules/ship-summary-d5d4a58f.js";
import { up as F, o as J, J as $, on as r, uo as Q, bo as E, ba as X } from "../../../../../../shared/runtime.js";
const Z = { style: { "margin-top": "20px" } }, ee = { class: "head-container" }, te = { class: "filter-item", style: { float: "right" } }, ne = { __name: "direct-detail", props: { modelValue: { type: Boolean, default: false }, showType: { type: String }, query: { type: Object }, category: { type: Number }, workshopId: { type: Number }, projectId: { type: Number }, weightStatus: { type: Number } }, setup(e, { expose: I }) {
  const b = w([["productSourceType", ["parse-enum", F]]]), o = e, u = w([]), c = w(false), { maxHeight: M } = J({ extraBox: [".head-container"], wrapperBox: [".detail-container"], paginate: true }), { handleSizeChange: v, handleCurrentChange: k, total: C, setTotalPage: V, queryPage: m } = $({ fetchHook: y });
  R(() => o.showType, (n) => {
    n && y();
  }, { immediate: true, deep: true });
  async function y() {
    if (u.value = [], !(!o.showType || o.showType === "ASSIGNMENT" || o.showType === "PACKAGE")) {
      c.value = true;
      try {
        const { content: n = [], totalElements: T } = await Y({ projectId: o.projectId, ...o.query, workshopId: o.workshopId, shipEnumType: r[o.showType].V, ...m });
        u.value = n, V(T), c.value = false;
      } catch (n) {
        console.log("获取详情失败", n), c.value = false;
      }
    }
  }
  function D(n) {
    return X(n, { props: ["quantity", "totalNetWeight", "totalGrossNetWeight"] });
  }
  return I({ refresh: y }), (n, T) => {
    const x = j, A = g("print-table"), l = B, O = g("table-cell-tag"), H = g("common-table"), P = L, G = K;
    return N((d(), q("div", Z, [i("div", ee, [a(x, { size: "small", class: "filter-item" }, { default: p(() => [z(h(e.showType === "INVENTORY" ? "清单总量" : e.showType === "ASSIGNMENT" ? "排产量" : e.showType === "STORAGE" ? "入库量" : e.showType === "CUMULATIVE_SHIPMENT" ? "累计发运" : e.showType === "SHIPMENT_MONTH" ? "本月发运" : e.showType === "IN_STOCK" ? "库存" : "累计车次/船次"), 1)]), _: 1 }), W(n.$slots, "query"), i("div", te, [a(A, { "api-key": e.showType === "INVENTORY" ? "mesShipMeteDetailDirect" : e.showType === "ASSIGNMENT" ? "mesShipTaskMeteDetailDirect" : e.showType === "STORAGE" ? "mesShipInboundMeteDetailDirect" : e.showType === "CUMULATIVE_SHIPMENT" ? "mesShipTotalMeteDetailDirect" : e.showType === "SHIPMENT_MONTH" ? "mesShipMonthMeteDetailDirect" : e.showType === "IN_STOCK" ? "mesShipStockMeteDetailDirect" : "mesShipTrainMeteDetailDirect", params: { projectId: o.projectId, ...o.query, workshopId: o.workshopId, shipEnumType: e.showType === "INVENTORY" ? t(r).INVENTORY.V : e.showType === "ASSIGNMENT" ? t(r).ASSIGNMENT.V : e.showType === "STORAGE" ? t(r).STORAGE.V : e.showType === "CUMULATIVE_SHIPMENT" ? t(r).CUMULATIVE_SHIPMENT.V : e.showType === "SHIPMENT_MONTH" ? t(r).SHIPMENT_MONTH.V : e.showType === "IN_STOCK" ? t(r).IN_STOCK.V : t(r).ACCUMULATED_NUMBER.V }, size: "default", type: "warning" }, null, 8, ["api-key", "params"])])]), N((d(), f(H, { data: u.value, "show-empty-symbol": false, "show-summary": "", "data-format": b.value, "summary-method": D, "max-height": t(M) - 50 }, { default: p(() => [a(l, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), e.showType !== "INVENTORY" ? (d(), f(l, { key: "workshop.name", prop: "workshop.name", label: "车间", align: "center", "show-overflow-tooltip": true })) : _("", true), a(l, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }, { default: p(({ row: s }) => {
      var S;
      return [a(O, { show: s.boolAllPartSendDirectly, name: "檩条直发", color: "#f56c6c" }, null, 8, ["show"]), i("span", null, h((S = s.monomer) == null ? void 0 : S.name), 1)];
    }), _: 1 }), a(l, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }), a(l, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), a(l, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true, "min-width": "120px" }), a(l, { key: "length", prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": true }), a(l, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true, width: "80px" }), a(l, { key: "netWeight", prop: "netWeight", label: "单重（kg）", align: "center", "show-overflow-tooltip": true }, { default: p(({ row: s }) => [i("span", null, h(e.weightStatus === t(E).NET.V ? s.netWeight || "-" : s.grossWeight || "-"), 1)]), _: 1 }), a(l, { prop: e.weightStatus === t(E).NET.V ? "totalNetWeight" : "totalGrossNetWeight", label: "总重（kg）", align: "center", "show-overflow-tooltip": true }, { default: p(({ row: s }) => [i("span", null, h(s.totalNetWeight || "-"), 1)]), _: 1 }, 8, ["prop"]), a(l, { key: "productSourceType", prop: "productSourceType", label: "备注", "show-overflow-tooltip": true })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[G, c.value]]), a(P, { total: t(C), "current-page": t(m).pageNumber, "page-size": t(m).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(v), onCurrentChange: t(k) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 512)), [[U, o.showType && o.category === t(Q).DIRECT.V]]);
  };
} };
export {
  ne as default
};
