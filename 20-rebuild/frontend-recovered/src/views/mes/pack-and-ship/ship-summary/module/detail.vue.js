import { ref as d } from "vue";
import { watch as D } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as P } from "vue";
import { withDirectives as T } from "vue";
import { vShow as S } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as a } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as U } from "vue";
import { toDisplayString as w } from "vue";
import { unref as t } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as G } from "vue";
import { Fragment as R } from "vue";
import { ElTag as W } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { ElPagination as j } from "element-plus";
import { vLoading as q } from "element-plus";
import { a as B } from "../../../../../modules/ship-summary-06293e56.js";
import { o as L, J as _, on as i, bo as E, ba as Y } from "../../../../../shared/runtime.js";
const K = { class: "my-code", style: { "margin-top": "20px" } }, F = { style: { "margin-top": "20px" } }, J = { class: "head-container" }, Q = { class: "filter-item", style: { float: "right" } }, ee = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, showType: { type: String }, query: { type: Object }, workshopId: { type: Number }, projectId: { type: Number }, weightStatus: { type: Number } }, setup(e) {
  const o = e, m = d([]), h = d(false), { maxHeight: I } = L({ extraBox: [".head-container"], wrapperBox: [".detail-container"], paginate: true }), { handleSizeChange: M, handleCurrentChange: b, total: k, setTotalPage: v, queryPage: c } = _({ fetchHook: g });
  D(() => o.showType, (l) => {
    l && g();
  }, { immediate: true, deep: true });
  async function g() {
    if (m.value = [], !!o.showType) {
      h.value = true;
      try {
        const { content: l = [], totalElements: u } = await B({ projectId: o.projectId, ...o.query, workshopId: o.workshopId, shipEnumType: i[o.showType].V, ...c });
        m.value = l, v(u), h.value = false;
      } catch (l) {
        console.log("获取详情失败", l), h.value = false;
      }
    }
  }
  function C(l) {
    return Y(l, { props: ["quantity", "totalNetWeight", "totalGrossWeight"] });
  }
  return (l, u) => {
    const V = W, x = N("print-table"), n = z, O = N("common-table"), H = j, A = q;
    return y(), P(R, null, [T(s("div", K, "*点击上方表格数据查看详情", 512), [[S, !o.showType]]), T(s("div", F, [s("div", J, [a(V, { size: "default", style: { float: "left" } }, { default: p(() => [U(w(e.showType === "INVENTORY" ? "清单总量" : e.showType === "ASSIGNMENT" ? "任务量" : e.showType === "STORAGE" ? "入库量" : e.showType === "CUMULATIVE_SHIPMENT" ? "累计发运" : e.showType === "SHIPMENT_MONTH" ? "本月发运" : e.showType === "IN_STOCK" ? "库存" : "累计车次/船次"), 1)]), _: 1 }), s("div", Q, [a(x, { "api-key": e.showType === "INVENTORY" ? "mesShipMeteDetail" : e.showType === "ASSIGNMENT" ? "mesShipTaskMeteDetail" : e.showType === "STORAGE" ? "mesShipInboundMeteDetail" : e.showType === "CUMULATIVE_SHIPMENT" ? "mesShipTotalMeteDetail" : e.showType === "SHIPMENT_MONTH" ? "mesShipMonthMeteDetail" : e.showType === "IN_STOCK" ? "mesShipStockMeteDetail" : "mesShipTrainMeteDetail", params: { projectId: o.projectId, ...o.query, workshopId: o.workshopId, shipEnumType: e.showType === "INVENTORY" ? t(i).INVENTORY.V : e.showType === "ASSIGNMENT" ? t(i).ASSIGNMENT.V : e.showType === "STORAGE" ? t(i).STORAGE.V : e.showType === "CUMULATIVE_SHIPMENT" ? t(i).CUMULATIVE_SHIPMENT.V : e.showType === "SHIPMENT_MONTH" ? t(i).SHIPMENT_MONTH.V : e.showType === "IN_STOCK" ? t(i).IN_STOCK.V : t(i).ACCUMULATED_NUMBER.V }, size: "default", type: "warning" }, null, 8, ["api-key", "params"])])]), T((y(), f(O, { data: m.value, "show-empty-symbol": false, "show-summary": "", "summary-method": C, "max-height": t(I) - 30 }, { default: p(() => [a(n, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), e.showType !== "INVENTORY" ? (y(), f(n, { key: "workshop.name", prop: "workshop.name", label: "车间", align: "center", "show-overflow-tooltip": true })) : G("", true), a(n, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }), a(n, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }), a(n, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), a(n, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true, "min-width": "120px" }), a(n, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true }), a(n, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true, width: "80px" }), a(n, { key: "netWeight", prop: "netWeight", label: "单重（kg）", align: "center", "show-overflow-tooltip": true }, { default: p(({ row: r }) => [s("span", null, w(e.weightStatus === t(E).NET.V ? r.netWeight || "-" : r.grossWeight || "-"), 1)]), _: 1 }), a(n, { key: "totalNetWeight", prop: "totalNetWeight", label: "总重（kg）", align: "center", "show-overflow-tooltip": true }, { default: p(({ row: r }) => [s("span", null, w(e.weightStatus === t(E).NET.V ? r.totalNetWeight || "-" : r.totalGrossNetWeight || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[A, h.value]]), a(H, { total: t(k), "current-page": t(c).pageNumber, "page-size": t(c).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(M), onCurrentChange: t(b) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 512), [[S, o.showType]])], 64);
  };
} };
export {
  ee as default
};
