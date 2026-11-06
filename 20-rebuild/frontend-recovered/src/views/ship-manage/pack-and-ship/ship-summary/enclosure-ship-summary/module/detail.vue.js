import { ref as v } from "vue";
import { watch as R } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as _ } from "vue";
import { withDirectives as I } from "vue";
import { vShow as q } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as n } from "vue";
import { withCtx as g } from "vue";
import { createTextVNode as z } from "vue";
import { toDisplayString as M } from "vue";
import { renderSlot as B } from "vue";
import { unref as o } from "vue";
import { createBlock as b } from "vue";
import { createCommentVNode as C } from "vue";
import { ElTag as G } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElPagination as K } from "element-plus";
import { vLoading as F } from "element-plus";
import { a as J } from "../../../../../../modules/enclosure-ship-summary-6941ca85.js";
import { up as $, o as Q, J as W, on as i, c as V, D as X } from "../../../../../../shared/runtime.js";
const Z = { style: { "margin-top": "20px" } }, ee = { class: "head-container" }, te = { class: "filter-item", style: { float: "right" } }, ne = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, showType: { type: String }, query: { type: Object }, workshopId: { type: Number }, projectId: { type: Number }, weightStatus: { type: Number }, permission: { type: Object, default: () => {
} } }, setup(e, { expose: O }) {
  const x = v([["productSourceType", ["parse-enum", $]]]), r = e, S = v([]), y = v(false), { maxHeight: D } = Q({ extraBox: [".head-container"], wrapperBox: [".detail-container"], paginate: true }), { handleSizeChange: H, handleCurrentChange: A, total: P, setTotalPage: L, queryPage: f } = W({ fetchHook: E });
  R(() => r.showType, (l) => {
    l && E();
  }, { immediate: true, deep: true });
  async function E() {
    if (S.value = [], !!r.showType) {
      y.value = true;
      try {
        const { content: l = [], totalElements: T } = await J({ projectId: r.projectId, ...r.query, workshopId: r.workshopId, shipEnumType: i[r.showType].V, ...f });
        S.value = l, L(T), y.value = false;
      } catch (l) {
        console.log("获取详情失败", l), y.value = false;
      }
    }
  }
  function U(l) {
    const { columns: T, data: w } = l, h = [];
    return T.forEach((t, m) => {
      if (m === 0) {
        h[m] = "合计";
        return;
      }
      if (t.property === "quantity") {
        const p = w.map((a) => Number(a[t.property]));
        let u = 0;
        p.every((a) => isNaN(a)) || (u = p.reduce((a, s) => {
          const c = Number(s);
          return isNaN(c) ? a : a + s;
        }, 0)), h[m] = u;
      }
      if (t.property === "totalLength") {
        const p = w.map((a) => Number(a[t.property]));
        let u = 0;
        p.every((a) => isNaN(a)) || (u = p.reduce((a, s) => {
          const c = Number(s);
          return isNaN(c) ? a : a + s;
        }, 0)), h[m] = V(u, "mm", "m", 2);
      }
    }), h;
  }
  return O({ refresh: E }), (l, T) => {
    const w = G, h = k("print-table"), t = Y, m = k("common-table"), p = K, u = _("permission"), a = F;
    return I((d(), j("div", Z, [N("div", ee, [n(w, { class: "filter-item", size: "default" }, { default: g(() => [z(M(e.showType === "INVENTORY" ? "清单总量" : e.showType === "ASSIGNMENT" ? "排产量" : e.showType === "STORAGE" ? "入库量" : e.showType === "CUMULATIVE_SHIPMENT" ? "累计发运" : e.showType === "SHIPMENT_MONTH" ? "本月发运" : e.showType === "IN_STOCK" ? "库存" : "累计车次/船次"), 1)]), _: 1 }), B(l.$slots, "query"), N("div", te, [I(n(h, { "api-key": e.showType === "INVENTORY" ? "enclosureShipMeteDetail" : e.showType === "ASSIGNMENT" ? "enclosureShipTaskMeteDetail" : e.showType === "STORAGE" ? "enclosureShipInboundMeteDetail" : e.showType === "CUMULATIVE_SHIPMENT" ? "enclosureShipTotalMeteDetail" : e.showType === "SHIPMENT_MONTH" ? "enclosureShipMonthMeteDetail" : e.showType === "IN_STOCK" ? "enclosureShipStockMeteDetail" : "mesShipTrainMeteDetail", params: { projectId: r.projectId, ...r.query, workshopId: r.workshopId, shipEnumType: e.showType === "INVENTORY" ? o(i).INVENTORY.V : e.showType === "ASSIGNMENT" ? o(i).ASSIGNMENT.V : e.showType === "STORAGE" ? o(i).STORAGE.V : e.showType === "CUMULATIVE_SHIPMENT" ? o(i).CUMULATIVE_SHIPMENT.V : e.showType === "SHIPMENT_MONTH" ? o(i).SHIPMENT_MONTH.V : e.showType === "IN_STOCK" ? o(i).IN_STOCK.V : o(i).ACCUMULATED_NUMBER.V }, size: "default", type: "warning" }, null, 8, ["api-key", "params"]), [[u, e.permission.print]])])]), I((d(), b(m, { data: S.value, "show-empty-symbol": false, "show-summary": "", "data-format": x.value, "summary-method": U, "max-height": o(D) - 180 }, { default: g(() => {
      var s;
      return [n(t, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), e.showType !== "INVENTORY" ? (d(), b(t, { key: "workshop.name", prop: "workshop.name", label: "车间", align: "center", "show-overflow-tooltip": true })) : C("", true), n(t, { key: "area.name", prop: "area.name", label: "批次", align: "center", "show-overflow-tooltip": true }), n(t, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }), n(t, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), ((s = r.query) == null ? void 0 : s.category) !== 32 ? (d(), b(t, { key: "plate", prop: "plate", label: "板型", align: "center", "show-overflow-tooltip": true, "min-width": "120px" })) : C("", true), n(t, { key: "length", prop: "length", label: "单长（mm）", align: "center", "show-overflow-tooltip": true }, { default: g(({ row: c }) => [N("span", null, M(c.length || "-"), 1)]), _: 1 }), n(t, { key: "quantity", prop: "quantity", label: "数量（件）", align: "center", "show-overflow-tooltip": true, width: "90px" }), n(t, { key: "totalLength", prop: "totalLength", label: "总长（m）", align: "center", "show-overflow-tooltip": true }, { default: g(({ row: c }) => [N("span", null, M(o(V)(c.totalLength, "mm", "m", o(X).MES_ENCLOSURE_L__M) || "-"), 1)]), _: 1 }), n(t, { key: "productSourceType", prop: "productSourceType", label: "备注", "show-overflow-tooltip": true })];
    }), _: 1 }, 8, ["data", "data-format", "max-height"])), [[a, y.value]]), n(p, { total: o(P), "current-page": o(f).pageNumber, "page-size": o(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(H), onCurrentChange: o(A) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 512)), [[q, r.showType]]);
  };
} };
export {
  ne as default
};
