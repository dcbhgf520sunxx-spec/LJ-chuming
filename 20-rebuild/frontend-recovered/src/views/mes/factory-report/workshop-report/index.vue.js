import { ref as b } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as w } from "vue";
import { unref as e } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as r } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as A } from "vue";
import { ElTableColumn as F } from "element-plus";
import { vLoading as L } from "element-plus";
import { c as T, m as R } from "./module/header.vue.js";
import { x as V, nA as B, o as D, z as E, bo as v, p as H, P, ba as z } from "../../../../shared/runtime.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
import "../../../../modules/production-line-select-f08e245b.js";
const G = { class: "app-container" }, I = { class: "head-container" }, X = { __name: "index", setup(M) {
  const f = b(), g = b(), y = { add: false, edit: false, del: false, download: false }, { crud: c, CRUD: _, columns: l } = V({ title: "车间报表", sort: [], optShow: { ...y }, permission: { ...B }, crudApi: { ...T }, invisibleColumns: ["productionLine.name", "date"], hasPagination: true }, f), { maxHeight: x } = D({ minHeight: "15", extraBox: [".head-container"], paginate: true });
  _.HOOK.handleRefresh = (m, h) => {
    h.data.content = h.data.content.map((o) => o);
  };
  function k(m) {
    return z(m, { props: ["length", "quantity", ["grossWeight", 2], ["totalNetWeight", 2], ["totalGrossWeight", 2]] });
  }
  function N(m) {
    g.value = m;
  }
  return (m, h) => {
    const o = F, W = C("common-table"), S = L;
    return a(), q("div", G, [s("div", I, [w(e(R), { onZoomChangeSize: N })]), j((a(), r(W, { ref_key: "tableRef", ref: f, data: e(c).data, "empty-text": e(c).emptyText, "max-height": g.value ? 360 : e(x), "show-summary": "", "summary-method": k, "row-key": "projectId", style: { width: "100%" } }, { default: n(() => [w(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(l).visible("project") ? (a(), r(o, { "header-align": "center", key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "120" }, { default: n((t) => [s("span", null, u(e(E)(t.row.project)), 1)]), _: 1 })) : i("", true), e(l).visible("monomer.name") ? (a(), r(o, { key: "monomer.name", prop: "monomer.name", align: "center", "show-overflow-tooltip": true, label: "单体" })) : i("", true), e(l).visible("area.name") ? (a(), r(o, { align: "center", key: "area.name", prop: "area.name", "show-overflow-tooltip": true, label: "区域" })) : i("", true), e(l).visible("productionLine") ? (a(), r(o, { align: "center", key: "productionLine", prop: "productionLine", "show-overflow-tooltip": true, label: "生产线" }, { default: n((t) => {
      var p;
      return [s("span", null, u(t.row.productionLine ? (p = t.row.productionLine) == null ? void 0 : p.name : "-"), 1)];
    }), _: 1 })) : i("", true), e(l).visible("name") ? (a(), r(o, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称" }, { default: n((t) => [s("span", null, u(t.row.name), 1)]), _: 1 })) : i("", true), e(l).visible("orderNumber") ? (a(), r(o, { align: "center", key: "orderNumber", prop: "orderNumber", "show-overflow-tooltip": true, label: "工单号" })) : i("", true), e(l).visible("serialNumber") ? (a(), r(o, { align: "center", key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }, { default: n((t) => [s("span", null, u(t.row.serialNumber), 1)]), _: 1 })) : i("", true), e(l).visible("specification") ? (a(), r(o, { align: "center", key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格" }, { default: n((t) => [s("span", null, u(t.row.specification), 1)]), _: 1 })) : i("", true), e(l).visible("material") ? (a(), r(o, { align: "center", key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质" }, { default: n((t) => [s("span", null, u(t.row.material), 1)]), _: 1 })) : i("", true), e(l).visible("quantity") ? (a(), r(o, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量" }, { default: n((t) => [s("span", null, u(t.row.quantity), 1)]), _: 1 })) : i("", true), e(l).visible("totalSurfaceArea") ? (a(), r(o, { align: "center", key: "totalSurfaceArea", prop: "totalSurfaceArea", "show-overflow-tooltip": true, label: "总面积" }, { default: n(({ row: t }) => [A(u(t.totalSurfaceArea.toFixed(2)), 1)]), _: 1 })) : i("", true), e(l).visible("netWeight") ? (a(), r(o, { align: "center", key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "单重（kg）" }, { default: n((t) => {
      var p, d;
      return [s("span", null, u(e(c).query.weightStatus === e(v).NET.V ? (p = t.row.netWeight) == null ? void 0 : p.toFixed(2) : (d = t.row.grossWeight) == null ? void 0 : d.toFixed(2)), 1)];
    }), _: 1 })) : i("", true), e(l).visible("totalNetWeight") ? (a(), r(o, { align: "center", key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总重（kg）" }, { default: n((t) => {
      var p, d;
      return [s("span", null, u(e(c).query.weightStatus === e(v).NET.V ? (p = t.row.totalNetWeight) == null ? void 0 : p.toFixed(2) : (d = t.row.totalGrossWeight) == null ? void 0 : d.toFixed(2)), 1)];
    }), _: 1 })) : i("", true), e(l).visible("date") ? (a(), r(o, { align: "center", key: "date", prop: "date", "show-overflow-tooltip": true, label: "入库日期" }, { default: n((t) => [s("span", null, u(e(H)(t.row.date, "{y}-{m}-{d}")), 1)]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[S, e(c).loading]]), w(e(P))]);
  };
} };
export {
  X as default
};
