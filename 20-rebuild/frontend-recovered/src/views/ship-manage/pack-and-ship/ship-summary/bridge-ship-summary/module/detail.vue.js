import { ref as f } from "vue";
import { watch as G } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as z } from "vue";
import { withDirectives as r } from "vue";
import { vShow as m } from "vue";
import { unref as t } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as o } from "vue";
import { withCtx as y } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as N } from "vue";
import { createBlock as I } from "vue";
import { createCommentVNode as j } from "vue";
import { Fragment as q } from "vue";
import { ElTag as B } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { ElPagination as F } from "element-plus";
import { vLoading as Y } from "element-plus";
import { d as K } from "../../../../../../modules/bridge-ship-summary-aa634ae7.js";
import { n as J } from "../../../../../../modules/ship-manage-3066b2ed.js";
import { o as Q, J as X, on as l, uo as T, bo as M, ba as Z } from "../../../../../../shared/runtime.js";
const $ = { class: "my-code", style: { "margin-top": "20px" } }, ee = { style: { "margin-top": "20px" } }, te = { class: "head-container" }, ae = { class: "filter-item", style: { float: "right" } }, re = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, showType: { type: String }, query: { type: Object }, category: { type: Number }, workshopId: { type: Number }, projectId: { type: Number }, weightStatus: { type: Number } }, setup(e) {
  const a = e, g = f([]), u = f(false), { maxHeight: v } = Q({ extraBox: [".head-container"], wrapperBox: [".detail-container"], paginate: true }), { handleSizeChange: C, handleCurrentChange: V, total: k, setTotalPage: x, queryPage: d } = X({ fetchHook: E });
  G(() => a.showType, (n) => {
    n && E();
  }, { immediate: true, deep: true });
  async function E() {
    if (g.value = [], !!a.showType) {
      u.value = true;
      try {
        const { content: n = [], totalElements: w } = await K({ projectId: a.projectId, ...a.query, workshopId: a.workshopId, shipEnumType: l[a.showType].V, ...d });
        g.value = n, x(w), u.value = false;
      } catch (n) {
        console.log("获取详情失败", n), u.value = false;
      }
    }
  }
  function R(n) {
    return Z(n, { props: ["quantity", "totalNetWeight", "totalGrossWeight"] });
  }
  return (n, w) => {
    const U = B, O = b("print-table"), i = L, H = b("common-table"), A = F, D = W("permission"), P = Y;
    return S(), z(q, null, [r(s("div", $, " *点击上方表格数据查看详情 ", 512), [[m, !a.showType && a.category === t(T).STRUCTURE.V]]), r(s("div", ee, [r(s("div", te, [o(U, { size: "default", style: { float: "left" } }, { default: y(() => [_(N(e.showType === "INVENTORY" ? "清单总量" : e.showType === "ASSIGNMENT" ? "任务量" : e.showType === "STORAGE" ? "入库量" : e.showType === "CUMULATIVE_SHIPMENT" ? "累计发运" : e.showType === "SHIPMENT_MONTH" ? "本月发运" : e.showType === "IN_STOCK" ? "库存" : "累计车次/船次"), 1)]), _: 1 }), s("div", ae, [r(o(O, { "api-key": e.showType === "INVENTORY" ? "bridgeShipMeteDetail" : e.showType === "ASSIGNMENT" ? "bridgeShipTaskMeteDetail" : e.showType === "STORAGE" ? "bridgeShipInboundMeteDetail" : e.showType === "CUMULATIVE_SHIPMENT" ? "bridgeShipTotalMeteDetail" : e.showType === "SHIPMENT_MONTH" ? "bridgeShipMonthMeteDetail" : e.showType === "IN_STOCK" ? "bridgeShipStockMeteDetail" : "bridgeShipTrainMeteDetail", params: { projectId: a.projectId, ...a.query, workshopId: a.workshopId, shipEnumType: e.showType === "INVENTORY" ? t(l).INVENTORY.V : e.showType === "ASSIGNMENT" ? t(l).ASSIGNMENT.V : e.showType === "STORAGE" ? t(l).STORAGE.V : e.showType === "CUMULATIVE_SHIPMENT" ? t(l).CUMULATIVE_SHIPMENT.V : e.showType === "SHIPMENT_MONTH" ? t(l).SHIPMENT_MONTH.V : e.showType === "IN_STOCK" ? t(l).IN_STOCK.V : t(l).ACCUMULATED_NUMBER.V }, size: "default", type: "warning" }, null, 8, ["api-key", "params"]), [[D, t(J).print]])])], 512), [[m, a.category === t(T).STRUCTURE.V]]), r((S(), I(H, { data: g.value, "show-empty-symbol": false, "show-summary": "", "summary-method": R, "max-height": t(v) - 80 }, { default: y(() => [o(i, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), e.showType !== "INVENTORY" ? (S(), I(i, { key: "workshop.name", prop: "workshop.name", label: "车间", align: "center", "show-overflow-tooltip": true })) : j("", true), o(i, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }), o(i, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }), o(i, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), o(i, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true, "min-width": "120px" }), o(i, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true }), o(i, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true, width: "80px" }), o(i, { key: "netWeight", prop: "netWeight", label: "单重（kg）", align: "center", "show-overflow-tooltip": true }, { default: y(({ row: p }) => {
      var h, c;
      return [s("span", null, N(e.weightStatus === t(M).NET.V ? ((h = p.netWeight) == null ? void 0 : h.toFixed(2)) || "-" : ((c = p.grossWeight) == null ? void 0 : c.toFixed(2)) || "-"), 1)];
    }), _: 1 }), o(i, { key: "totalNetWeight", prop: "totalNetWeight", label: "总重（kg）", align: "center", "show-overflow-tooltip": true }, { default: y(({ row: p }) => {
      var h, c;
      return [s("span", null, N(e.weightStatus === t(M).NET.V ? ((h = p.totalNetWeight) == null ? void 0 : h.toFixed(2)) || "-" : ((c = p.totalGrossNetWeight) == null ? void 0 : c.toFixed(2)) || "-"), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[m, a.category === t(T).STRUCTURE.V], [P, u.value]]), r(o(A, { total: t(k), "current-page": t(d).pageNumber, "page-size": t(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(C), onCurrentChange: t(V) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), [[m, a.category === t(T).STRUCTURE.V]])], 512), [[m, a.showType]])], 64);
  };
} };
export {
  re as default
};
