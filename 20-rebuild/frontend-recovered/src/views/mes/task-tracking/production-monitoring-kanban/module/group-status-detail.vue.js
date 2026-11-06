import { ref as d } from "vue";
import { inject as A } from "vue";
import { watch as F } from "vue";
import { computed as J } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as z } from "vue";
import { createElementBlock as Q } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as t } from "vue";
import { unref as n } from "vue";
import { withKeys as Z } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as T } from "vue";
import { withModifiers as E } from "vue";
import { withDirectives as X } from "vue";
import { toDisplayString as f } from "vue";
import { normalizeClass as S } from "vue";
import { ElInput as Y } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElPagination as ee } from "element-plus";
import { d as te } from "../../../../../modules/kanban-603b7875.js";
import { _ as ae, o as oe, J as le, bb as ne, ng as re, bZ as ie, z as se } from "../../../../../shared/runtime.js";
const pe = { key: 0, class: "my-code" }, ue = { key: 1 }, de = { class: "app-container" }, ce = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, me = { style: { width: "300px" } }, fe = { __name: "group-status-detail", props: { detailData: { type: Object, default: () => {
} }, workshopId: { type: Number }, processId: { type: Number } }, setup(k) {
  const o = k, V = d(), I = d([]), c = d(), y = d(), g = d(), h = d(), { maxHeight: L } = oe({ extraBox: [".head-container"], paginate: true }), P = A("permission");
  F(() => {
    var i, a;
    return (a = (i = o.detailData) == null ? void 0 : i.productionLine) == null ? void 0 : a.id;
  }, (i) => {
    i && p();
  }, { immediate: true, deep: true });
  const x = J(() => ({ projectId: c.value, monomerId: y.value, areaId: g.value, serialNumber: h.value })), { handleSizeChange: U, handleCurrentChange: R, total: W, setTotalPage: B, queryPage: v } = le({ fetchHook: p });
  async function p() {
    var i, a, _;
    try {
      const { content: u = [], totalElements: b } = await te({ groupId: (i = o.detailData.groups) == null ? void 0 : i.id, productionLineId: (a = o.detailData.productionLine) == null ? void 0 : a.id, taskTypeEnum: o.detailData.taskTypeEnum, teamId: (_ = o.detailData.team) == null ? void 0 : _.id, workshopId: o.workshopId, processId: o.processId, ...x.value, ...v });
      I.value = u || [], B(b);
    } catch (u) {
      console.log("获取班组详情信息失败", u);
    }
  }
  function M() {
    p();
  }
  function G() {
    c.value = void 0, y.value = void 0, g.value = void 0, h.value = void 0, p();
  }
  return (i, a) => {
    var C, D, N, j;
    const _ = Y, u = w("common-button"), b = w("print-table"), l = $, H = w("common-table"), K = ee, q = O("permission");
    return (C = k.detailData.productionLine) != null && C.id ? (z(), Q("div", ue, [r("div", de, [r("div", ce, [r("div", null, [t(n(ne), { modelValue: c.value, "onUpdate:modelValue": a[0] || (a[0] = (e) => c.value = e), class: "filter-item", clearable: "", style: { width: "200px" } }, null, 8, ["modelValue"]), t(n(ie), { monomerId: y.value, "onUpdate:monomerId": a[1] || (a[1] = (e) => y.value = e), areaId: g.value, "onUpdate:areaId": a[2] || (a[2] = (e) => g.value = e), productType: n(re).STRUCTURE.V, needConvert: "", clearable: "", areaClearable: "", "project-id": c.value, onChange: p }, null, 8, ["monomerId", "areaId", "productType", "project-id"]), t(_, { modelValue: h.value, "onUpdate:modelValue": a[3] || (a[3] = (e) => h.value = e), modelModifiers: { trim: true }, size: "default", placeholder: "编号搜索", style: { width: "130px" }, class: "filter-item", clearable: "", onKeyup: Z(p, ["enter"]) }, null, 8, ["modelValue"]), t(u, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: E(M, ["stop"]) }, { default: s(() => a[4] || (a[4] = [T("搜索")])), _: 1, __: [4] }), t(u, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: E(G, ["stop"]) }, { default: s(() => a[5] || (a[5] = [T(" 重置 ")])), _: 1, __: [5] })]), r("div", me, [X(t(b, { "api-key": "mesProductionKanbanGroupList", params: { groupId: (D = o.detailData.groups) == null ? void 0 : D.id, productionLineId: (N = o.detailData.productionLine) == null ? void 0 : N.id, taskTypeEnum: o.detailData.taskTypeEnum, teamId: (j = o.detailData.team) == null ? void 0 : j.id, workshopId: o.workshopId, processId: o.processId, ...x.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[q, n(P).print]])])]), t(H, { ref_key: "tableRef", ref: V, data: I.value, "empty-text": "暂无数据", "show-empty-symbol": false, "max-height": n(L) + 140, "row-key": "id", style: { width: "100%" } }, { default: s(() => [t(l, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(l, { "show-overflow-tooltip": true, prop: "project", key: "project", label: "项目", align: "center" }, { default: s(({ row: e }) => [r("span", null, f(e.project ? n(se)(e.project) : "/"), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "monomer.name", key: "monomer.name", label: "单体", align: "center" }, { default: s(({ row: e }) => {
      var m;
      return [r("span", null, f(e.monomer ? (m = e.monomer) == null ? void 0 : m.name : "/"), 1)];
    }), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "area.name", key: "area.name", label: "区域", align: "center" }, { default: s(({ row: e }) => {
      var m;
      return [r("span", null, f(e.area ? (m = e.area) == null ? void 0 : m.name : "/"), 1)];
    }), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "specification", key: "specification", label: "规格", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "material", key: "material", label: "材质", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "scheduleQuantity", key: "scheduleQuantity", label: "排产数", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "scheduleNetWeight", key: "scheduleNetWeight", label: "排产量（kg）", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "completeQuantity", key: "completeQuantity", label: "完成数", align: "center" }, { default: s(({ row: e }) => [r("span", { class: S(e.scheduleQuantity === e.completeQuantity ? "" : "tc-danger") }, f(e.completeQuantity), 3)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "completeNetWeight", key: "completeNetWeight", label: "完成量（kg）", align: "center" }, { default: s(({ row: e }) => [r("span", { class: S(e.scheduleQuantity === e.completeQuantity ? "" : "tc-danger") }, f(e.completeNetWeight), 3)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), t(K, { total: n(W), "current-page": n(v).pageNumber, "page-size": n(v).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(U), onCurrentChange: n(R) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])])) : (z(), Q("div", pe, "*点击左侧表格行查看详情"));
  };
} }, _e = ae(fe, [["__scopeId", "data-v-863f2199"]]);
export {
  _e as default
};
