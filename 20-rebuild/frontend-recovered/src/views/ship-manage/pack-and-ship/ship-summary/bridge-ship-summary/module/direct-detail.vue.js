import { ref as S } from "vue";
import { watch as P } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as G } from "vue";
import { withDirectives as l } from "vue";
import { vShow as h } from "vue";
import { unref as t } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as o } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as W } from "vue";
import { toDisplayString as w } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as z } from "vue";
import { Fragment as _ } from "vue";
import { ElTag as j } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { ElPagination as B } from "element-plus";
import { vLoading as L } from "element-plus";
import { e as Y } from "../../../../../../modules/bridge-ship-summary-aa634ae7.js";
import { n as K } from "../../../../../../modules/ship-manage-3066b2ed.js";
import { o as F, J, on as r, uo as u, bo as I, ba as Q } from "../../../../../../shared/runtime.js";
const X = { class: "my-code", style: { "margin-top": "20px" } }, Z = { style: { "margin-top": "20px" } }, $ = { class: "head-container" }, ee = { class: "filter-item", style: { float: "right" } }, ne = { __name: "direct-detail", props: { modelValue: { type: Boolean, default: false }, showType: { type: String }, query: { type: Object }, category: { type: Number }, workshopId: { type: Number }, projectId: { type: Number }, weightStatus: { type: Number } }, setup(e) {
  const a = e, y = S([]), c = S(false), { maxHeight: b } = F({ extraBox: [".head-container"], wrapperBox: [".detail-container"], paginate: true }), { handleSizeChange: M, handleCurrentChange: v, total: C, setTotalPage: V, queryPage: g } = J({ fetchHook: N });
  P(() => a.showType, (n) => {
    n && N();
  }, { immediate: true, deep: true });
  async function N() {
    if (y.value = [], !!a.showType) {
      c.value = true;
      try {
        const { content: n = [], totalElements: T } = await Y({ projectId: a.projectId, ...a.query, workshopId: a.workshopId, shipEnumType: r[a.showType].V, ...g });
        y.value = n, V(T), c.value = false;
      } catch (n) {
        console.log("获取详情失败", n), c.value = false;
      }
    }
  }
  function k(n) {
    return Q(n, { props: ["quantity", "totalNetWeight", "totalGrossWeight"] });
  }
  return (n, T) => {
    const D = j, x = E("print-table"), i = q, O = E("common-table"), H = B, R = U("permission"), A = L;
    return d(), G(_, null, [l(s("div", X, " *点击上方表格数据查看详情 ", 512), [[h, !a.showType && a.category === t(u).DIRECT.V]]), l(s("div", Z, [l(s("div", $, [o(D, { size: "default", style: { float: "left" } }, { default: m(() => [W(w(e.showType === "INVENTORY" ? "清单总量" : e.showType === "ASSIGNMENT" ? "任务量" : e.showType === "STORAGE" ? "入库量" : e.showType === "CUMULATIVE_SHIPMENT" ? "累计发运" : e.showType === "SHIPMENT_MONTH" ? "本月发运" : e.showType === "IN_STOCK" ? "库存" : "累计车次/船次"), 1)]), _: 1 }), s("div", ee, [l(o(x, { "api-key": e.showType === "INVENTORY" ? "bridgeShipMeteDetailDirect" : e.showType === "ASSIGNMENT" ? "bridgeShipTaskMeteDetailDirect" : e.showType === "STORAGE" ? "bridgeShipInboundMeteDetailDirect" : e.showType === "CUMULATIVE_SHIPMENT" ? "bridgeShipTotalMeteDetailDirect" : e.showType === "SHIPMENT_MONTH" ? "bridgeShipMonthMeteDetailDirect" : e.showType === "IN_STOCK" ? "bridgeShipStockMeteDetailDirect" : "bridgeShipTrainMeteDetailDirect", params: { projectId: a.projectId, ...a.query, workshopId: a.workshopId, shipEnumType: e.showType === "INVENTORY" ? t(r).INVENTORY.V : e.showType === "ASSIGNMENT" ? t(r).ASSIGNMENT.V : e.showType === "STORAGE" ? t(r).STORAGE.V : e.showType === "CUMULATIVE_SHIPMENT" ? t(r).CUMULATIVE_SHIPMENT.V : e.showType === "SHIPMENT_MONTH" ? t(r).SHIPMENT_MONTH.V : e.showType === "IN_STOCK" ? t(r).IN_STOCK.V : t(r).ACCUMULATED_NUMBER.V }, size: "default", type: "warning" }, null, 8, ["api-key", "params"]), [[R, t(K).print]])])], 512), [[h, a.category === t(u).DIRECT.V]]), l((d(), f(O, { data: y.value, "show-empty-symbol": false, "show-summary": "", "summary-method": k, "max-height": t(b) - 30 }, { default: m(() => [o(i, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), e.showType !== "INVENTORY" ? (d(), f(i, { key: "workshop.name", prop: "workshop.name", label: "车间", align: "center", "show-overflow-tooltip": true })) : z("", true), o(i, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }), o(i, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }), o(i, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), o(i, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true, "min-width": "120px" }), o(i, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true }), o(i, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true, width: "80px" }), o(i, { key: "netWeight", prop: "netWeight", label: "单重（kg）", align: "center", "show-overflow-tooltip": true }, { default: m(({ row: p }) => [s("span", null, w(e.weightStatus === t(I).NET.V ? p.netWeight || "-" : p.grossWeight || "-"), 1)]), _: 1 }), o(i, { key: "totalNetWeight", prop: "totalNetWeight", label: "总重（kg）", align: "center", "show-overflow-tooltip": true }, { default: m(({ row: p }) => [s("span", null, w(e.weightStatus === t(I).NET.V ? p.totalNetWeight || "-" : p.totalGrossNetWeight || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[h, a.category === t(u).DIRECT.V], [A, c.value]]), l(o(H, { total: t(C), "current-page": t(g).pageNumber, "page-size": t(g).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(M), onCurrentChange: t(v) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), [[h, a.category === t(u).DIRECT.V]])], 512), [[h, a.showType]])], 64);
  };
} };
export {
  ne as default
};
