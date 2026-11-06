import { ref as w } from "vue";
import { watch as U } from "vue";
import { resolveComponent as g } from "vue";
import { withDirectives as N } from "vue";
import { vShow as R } from "vue";
import { unref as t } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as a } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as z } from "vue";
import { toDisplayString as c } from "vue";
import { renderSlot as W } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as j } from "vue";
import { ElTag as B } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElPagination as L } from "element-plus";
import { vLoading as Y } from "element-plus";
import { g as _ } from "../../../../../../modules/ship-summary-d5d4a58f.js";
import { up as F, o as J, J as $, on as s, uo as Q, bo as E, ba as X } from "../../../../../../shared/runtime.js";
const Z = { style: { "margin-top": "20px" } }, ee = { class: "head-container" }, te = { class: "filter-item", style: { float: "right" } }, ne = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, showType: { type: String }, query: { type: Object }, category: { type: Number }, workshopId: { type: Number }, projectId: { type: Number }, weightStatus: { type: Number } }, setup(e, { expose: b }) {
  const I = w([["productSourceType", ["parse-enum", F]]]), o = e, u = w([]), h = w(false), { maxHeight: M } = J({ extraBox: [".head-container"], wrapperBox: [".detail-container"], paginate: true }), { handleSizeChange: k, handleCurrentChange: v, total: C, setTotalPage: V, queryPage: m } = $({ fetchHook: y });
  U(() => o.showType, (n) => {
    n && y();
  }, { immediate: true, deep: true });
  async function y() {
    if (u.value = [], !!o.showType) {
      h.value = true;
      try {
        const { content: n = [], totalElements: T } = await _({ projectId: o.projectId, ...o.query, workshopId: o.workshopId, shipEnumType: s[o.showType].V, ...m });
        u.value = n, V(T), h.value = false;
      } catch (n) {
        console.log("获取详情失败", n), h.value = false;
      }
    }
  }
  function A(n) {
    return X(n, { props: ["quantity", "totalNetWeight", "totalGrossNetWeight"] });
  }
  return b({ refresh: y }), (n, T) => {
    const x = B, P = g("print-table"), l = K, O = g("table-cell-tag"), D = g("common-table"), H = L, G = Y;
    return N((d(), q("div", Z, [i("div", ee, [a(x, { size: "default", class: "filter-item" }, { default: p(() => [z(c(e.showType === "INVENTORY" ? "清单总量" : e.showType === "ASSIGNMENT" ? "排产量" : e.showType === "STORAGE" ? "入库量" : e.showType === "CUMULATIVE_SHIPMENT" ? "累计发运" : e.showType === "SHIPMENT_MONTH" ? "本月发运" : e.showType === "IN_STOCK" ? "库存" : e.showType === "PACKAGE" ? "打包量(未装车)" : "累计车次/船次"), 1)]), _: 1 }), W(n.$slots, "query"), i("div", te, [a(P, { "api-key": e.showType === "INVENTORY" ? "mesShipMeteDetail" : e.showType === "ASSIGNMENT" ? "mesShipTaskMeteDetail" : e.showType === "STORAGE" ? "mesShipInboundMeteDetail" : e.showType === "CUMULATIVE_SHIPMENT" ? "mesShipTotalMeteDetail" : e.showType === "SHIPMENT_MONTH" ? "mesShipMonthMeteDetail" : e.showType === "IN_STOCK" ? "mesShipStockMeteDetail" : e.showType === "PACKAGE" ? "mesShipPackageMeteDetail" : "mesShipTrainMeteDetail", params: { projectId: o.projectId, ...o.query, workshopId: o.workshopId, weightStatus: o.weightStatus, shipEnumType: e.showType === "INVENTORY" ? t(s).INVENTORY.V : e.showType === "ASSIGNMENT" ? t(s).ASSIGNMENT.V : e.showType === "STORAGE" ? t(s).STORAGE.V : e.showType === "CUMULATIVE_SHIPMENT" ? t(s).CUMULATIVE_SHIPMENT.V : e.showType === "SHIPMENT_MONTH" ? t(s).SHIPMENT_MONTH.V : e.showType === "IN_STOCK" ? t(s).IN_STOCK.V : e.showType === "PACKAGE" ? t(s).PACKAGE.V : t(s).ACCUMULATED_NUMBER.V }, size: "default", type: "warning" }, null, 8, ["api-key", "params"])])]), N((d(), f(D, { data: u.value, "show-empty-symbol": false, "show-summary": "", "data-format": I.value, "summary-method": A, "max-height": t(M) - 50 }, { default: p(() => [a(l, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), e.showType !== "INVENTORY" ? (d(), f(l, { key: "workshop.name", prop: "workshop.name", label: "车间", align: "center", "show-overflow-tooltip": true })) : j("", true), a(l, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }, { default: p(({ row: r }) => {
      var S;
      return [a(O, { show: r.boolAllPartSendDirectly, name: "檩条直发", color: "#f56c6c" }, null, 8, ["show"]), i("span", null, c((S = r.monomer) == null ? void 0 : S.name), 1)];
    }), _: 1 }), a(l, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }), a(l, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true }), a(l, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), a(l, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true, "min-width": "120px" }), a(l, { key: "length", prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": true }), a(l, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true, width: "80px" }), a(l, { key: "netWeight", prop: "netWeight", label: "单重（kg）", align: "center", "show-overflow-tooltip": true }, { default: p(({ row: r }) => [i("span", null, c(e.weightStatus === t(E).NET.V ? r.netWeight || "-" : r.grossWeight || "-"), 1)]), _: 1 }), a(l, { prop: e.weightStatus === t(E).NET.V ? "totalNetWeight" : "totalGrossNetWeight", label: "总重（kg）", align: "center", "show-overflow-tooltip": true }, { default: p(({ row: r }) => [i("span", null, c(r.totalNetWeight || "-"), 1)]), _: 1 }, 8, ["prop"]), a(l, { key: "productSourceType", prop: "productSourceType", label: "备注", "show-overflow-tooltip": true })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[G, h.value]]), a(H, { total: t(C), "current-page": t(m).pageNumber, "page-size": t(m).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(k), onCurrentChange: t(v) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 512)), [[R, o.showType && o.category === t(Q).STRUCTURE.V]]);
  };
} };
export {
  ne as default
};
