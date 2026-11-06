import { ref as k } from "vue";
import { inject as q } from "vue";
import { watch as B } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as D } from "vue";
import { createElementBlock as x } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as t } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as u } from "vue";
import { withDirectives as R } from "vue";
import { unref as r } from "vue";
import { ElTag as V } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElPagination as F } from "element-plus";
import { d as J } from "../../../../modules/kanban-603b7875.js";
import { _ as K, o as M, J as O, z as A } from "../../../../shared/runtime.js";
const Q = { key: 0, class: "my-code" }, U = { key: 1 }, X = { class: "app-container" }, Y = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, Z = { style: { width: "300px" } }, $ = { __name: "group-status-detail", props: { detailData: { type: Object, default: () => {
} }, workshopId: { type: Number }, areaId: { type: Number } }, setup(g) {
  const e = g, I = k(), _ = k([]), { maxHeight: C } = M({ paginate: true }), j = q("permission");
  B(() => {
    var n, s;
    return (s = (n = e.detailData) == null ? void 0 : n.groups) == null ? void 0 : s.id;
  }, (n) => {
    n && h();
  });
  const { handleSizeChange: z, handleCurrentChange: E, total: N, setTotalPage: T, queryPage: m } = O({ fetchHook: h });
  async function h() {
    var n, s, d;
    try {
      const { content: p = [], totalElements: o } = await J({ groupId: (n = e.detailData.groups) == null ? void 0 : n.id, productionLineId: (s = e.detailData.productionLine) == null ? void 0 : s.id, taskTypeEnum: e.detailData.taskTypeEnum, teamId: (d = e.detailData.team) == null ? void 0 : d.id, workshopId: e.workshopId, areaId: e.areaId, ...m });
      _.value = p || [], T(o);
    } catch (p) {
      console.log("获取班组详情信息失败", p);
    }
  }
  return (n, s) => {
    var y, f, w, b;
    const d = V, p = v("print-table"), o = W, S = v("common-table"), L = F, P = G("permission");
    return (y = g.detailData.groups) != null && y.id ? (D(), x("div", U, [l("div", X, [l("div", Y, [t(d, null, { default: c(() => {
      var a, i;
      return [H("班组：" + u((i = (a = e.detailData) == null ? void 0 : a.groups) == null ? void 0 : i.name), 1)];
    }), _: 1 }), l("div", Z, [R(t(p, { "api-key": "mesProductionKanbanGroupList", params: { groupId: (f = e.detailData.groups) == null ? void 0 : f.id, productionLineId: (w = e.detailData.productionLine) == null ? void 0 : w.id, taskTypeEnum: e.detailData.taskTypeEnum, teamId: (b = e.detailData.team) == null ? void 0 : b.id, workshopId: e.workshopId, areaId: e.areaId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[P, r(j).print]])])]), t(S, { ref_key: "tableRef", ref: I, data: _.value, "empty-text": "暂无数据", "show-empty-symbol": false, "max-height": r(C) + 120, "row-key": "id", style: { width: "100%" } }, { default: c(() => [t(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(o, { "show-overflow-tooltip": true, prop: "project", key: "project", label: "项目", align: "center" }, { default: c(({ row: a }) => [l("span", null, u(a.project ? r(A)(a.project) : "/"), 1)]), _: 1 }), t(o, { "show-overflow-tooltip": true, prop: "monomer.name", key: "monomer.name", label: "单体", align: "center" }, { default: c(({ row: a }) => {
      var i;
      return [l("span", null, u(a.monomer ? (i = a.monomer) == null ? void 0 : i.name : "/"), 1)];
    }), _: 1 }), t(o, { "show-overflow-tooltip": true, prop: "area.name", key: "area.name", label: "区域", align: "center" }, { default: c(({ row: a }) => {
      var i;
      return [l("span", null, u(a.area ? (i = a.area) == null ? void 0 : i.name : "/"), 1)];
    }), _: 1 }), t(o, { "show-overflow-tooltip": true, prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), t(o, { "show-overflow-tooltip": true, prop: "specification", key: "specification", label: "规格", align: "center" }), t(o, { "show-overflow-tooltip": true, prop: "quantity", key: "quantity", label: "数量", align: "center" }), t(o, { "show-overflow-tooltip": true, prop: "netWeight", key: "netWeight", label: "重量（kg）", align: "center" })]), _: 1 }, 8, ["data", "max-height"]), t(L, { total: r(N), "current-page": r(m).pageNumber, "page-size": r(m).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: r(z), onCurrentChange: r(E) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])])) : (D(), x("div", Q, "*点击左侧表格行查看详情"));
  };
} }, oe = K($, [["__scopeId", "data-v-9a3247ef"]]);
export {
  oe as default
};
