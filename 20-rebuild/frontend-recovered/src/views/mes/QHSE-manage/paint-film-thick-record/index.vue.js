import { ref as f } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as u } from "vue";
import { unref as t } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as i } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as r } from "vue";
import { normalizeClass as k } from "vue";
import { ElTableColumn as B } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as P, d as S } from "./module/detail.vue.js";
import { _ as V, x as H, mR as w, o as U, i as y, mS as L, p as M, P as O, G as q } from "../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import "../quality-problem-statistics/module/detail.vue.js";
import "../../../../modules/index-d532b8ca.js";
import "../../../../modules/use-drawing-8a7ba23b.js";
import "../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const F = { class: "app-container" }, G = { class: "head-container" }, I = { key: 1 }, K = { key: 1 }, J = { __name: "index", setup(Q) {
  const x = { add: false, edit: false, del: false, download: false }, v = f(), d = f(false), g = f(), { crud: b, columns: l, CRUD: N } = H({ title: "漆膜厚度检测记录", permission: { ...w }, invisibleColumns: [], optShow: { ...x }, crudApi: { ...P }, hasPagination: true }, v), { maxHeight: T } = U({ extraBox: [".head-container"], paginate: true });
  N.HOOK.handleRefresh = (h, _) => {
  };
  function C(h) {
    q(w.get) && (g.value = h, d.value = true);
  }
  return (h, _) => {
    const a = B, E = A("common-table"), R = D;
    return o(), c("div", F, [m("div", G, [u(t(z))]), j((o(), i(E, { ref_key: "tableRef", ref: v, data: t(b).data, "empty-text": t(b).emptyText, "max-height": t(T), "row-key": "id", style: { width: "100%", cursor: "pointer" }, onRowClick: C }, { default: s(() => [u(a, { label: "序号", type: "index", prop: "index", align: "center", width: "55" }), t(l).visible("project.serialNumber") ? (o(), i(a, { key: 0, "show-overflow-tooltip": true, align: "center", prop: "project.serialNumber", label: "合同编号", "min-width": "120" }, { default: s(({ row: e }) => {
      var n;
      return [m("span", null, p(((n = e.project) == null ? void 0 : n.serialNumber) || "-"), 1)];
    }), _: 1 })) : r("", true), t(l).visible("project.shortName") ? (o(), i(a, { key: 1, "show-overflow-tooltip": true, align: "center", prop: "project.shortName", label: "项目", "min-width": "120" }, { default: s(({ row: e }) => {
      var n;
      return [m("span", null, p(((n = e.project) == null ? void 0 : n.shortName) || "-"), 1)];
    }), _: 1 })) : r("", true), t(l).visible("monomer.name") ? (o(), i(a, { key: 2, "show-overflow-tooltip": true, align: "center", prop: "monomer.name", label: "单体", "min-width": "100" }, { default: s(({ row: e }) => {
      var n;
      return [m("span", null, p(((n = e.monomer) == null ? void 0 : n.name) || "-"), 1)];
    }), _: 1 })) : r("", true), t(l).visible("area.name") ? (o(), i(a, { key: 3, "show-overflow-tooltip": true, align: "center", prop: "area.name", label: "区域", "min-width": "100" }, { default: s(({ row: e }) => {
      var n;
      return [m("span", null, p(((n = e.area) == null ? void 0 : n.name) || "-"), 1)];
    }), _: 1 })) : r("", true), t(l).visible("serialNumber") ? (o(), i(a, { key: 4, "show-overflow-tooltip": true, align: "center", prop: "serialNumber", label: "编号", "min-width": "120" }, { default: s(({ row: e }) => [m("span", null, p(e.serialNumber || "-"), 1)]), _: 1 })) : r("", true), t(l).visible("number") ? (o(), i(a, { key: 5, "show-overflow-tooltip": true, align: "center", prop: "number", label: "编码", width: "100" }, { default: s(({ row: e }) => [m("span", null, p(e.number || "-"), 1)]), _: 1 })) : r("", true), t(l).visible("avgThickness") ? (o(), i(a, { key: 6, "show-overflow-tooltip": true, align: "center", prop: "avgThickness", label: "平均厚度（μm）", width: "120" }, { default: s(({ row: e }) => [t(y)(e == null ? void 0 : e.avgThickness) ? (o(), c("span", { key: 0, class: k(e.boolPaintThicknessAdoptEnum ? "" : "tc-danger") }, p(e.avgThickness), 3)) : (o(), c("span", I, "-"))]), _: 1 })) : r("", true), t(l).visible("boolAdoptEnum") ? (o(), i(a, { key: 7, "show-overflow-tooltip": true, align: "center", prop: "boolAdoptEnum", label: "质检状态" }, { default: s(({ row: e }) => [t(y)(e == null ? void 0 : e.boolAdoptEnum) ? (o(), c("span", { key: 0, class: k(e.boolAdoptEnum ? "tc-success" : "tc-danger") }, p(t(L).VL[e.boolAdoptEnum]), 3)) : (o(), c("span", K, "-"))]), _: 1 })) : r("", true), t(l).visible("reporterName") ? (o(), i(a, { key: 8, "show-overflow-tooltip": true, align: "center", prop: "reporterName", label: "工序上报人" })) : r("", true), t(l).visible("inspectionName") ? (o(), i(a, { key: 9, "show-overflow-tooltip": true, align: "center", prop: "inspectionName", label: "质检人" })) : r("", true), t(l).visible("reportTime2") ? (o(), i(a, { key: 10, "show-overflow-tooltip": true, align: "center", prop: "reportTime2", label: "质检上报时间", width: "150" }, { default: s(({ row: e }) => [m("span", null, p(e.reportTime2 ? t(M)(e.reportTime2, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[R, t(b).loading]]), u(t(O)), u(t(S), { visible: d.value, "onUpdate:visible": _[0] || (_[0] = (e) => d.value = e), "detail-data": g.value }, null, 8, ["visible", "detail-data"])]);
  };
} }, me = V(J, [["__scopeId", "data-v-f4b51943"]]);
export {
  me as default
};
