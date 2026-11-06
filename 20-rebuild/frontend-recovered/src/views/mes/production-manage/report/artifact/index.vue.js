import { provide as m } from "vue";
import { ref as T } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as a } from "vue";
import { withCtx as p } from "vue";
import { toDisplayString as u } from "vue";
import { createTextVNode as v } from "vue";
import { unref as t } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as h } from "vue";
import { ElTableColumn as R } from "element-plus";
import { vLoading as D } from "element-plus";
import { g as P, c as A } from "../../../../../modules/common-17e7687a.js";
import { a3 as N, x as q, pU as M, o as V, bs as W, D as B, P as $ } from "../../../../../shared/runtime.js";
import { _ as E } from "../../../../../modules/index-3b2628f3.js";
import { _ as F } from "../../../../../modules/index-490fd9d7.js";
import { p as H } from "../../../../../modules/mes-ee117a22.js";
import { _ as I } from "../../../../../modules/index-897a9ea4.js";
import O from "../components/report-header.vue.js";
import "../../../../../modules/index-b238c21c.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
const U = { class: "app-container" }, j = { class: "head-container" }, ot = { __name: "index", setup(G) {
  const g = { add: false, edit: false, del: false, download: false }, n = N.ARTIFACT.V;
  m("getSummaryApi", P), m("productType", n), m("defaultQuery", { productType: n });
  const f = T(), { crud: i, columns: r, CRUD: w } = q({ title: "生产报表-结构报表", permission: { ...M }, optShow: { ...g }, crudApi: { ...A }, invisibleColumns: ["grossWeight", "netWeight", "totalGrossWeight", "drawingNumber", "surfaceArea", "remark"] }, f), { maxHeight: x } = V({ paginate: true });
  return w.HOOK.handleRefresh = (b, s) => {
    s.data.content = s.data.content.map((o, d) => (o.rowId = d + "" + Math.random(), o));
  }, (b, s) => {
    const o = R, d = C("common-table"), y = D;
    return l(), k("div", U, [c("div", j, [a(O, { "print-key": "mesStructureProductionReport" }, { summaryText: p(({ summary: e }) => [c("span", null, u(e == null ? void 0 : e.quantity) + "件", 1), s[0] || (s[0] = v(" / ")), c("span", null, u(t(W)(e == null ? void 0 : e.totalNetWeight, t(B).COM_WT__KG)) + "kg", 1)]), _: 1 })]), S((l(), _(d, { ref_key: "tableRef", ref: f, data: t(i).data, "data-format": t(H)[t(n)], "empty-text": t(i).emptyText, "max-height": t(x), "row-key": "rowId", style: { width: "100%" }, onSortChange: t(i).handleSortChange }, { default: p(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(t(E), { columns: t(r), showProject: "", showMonomer: "" }, null, 8, ["columns"]), a(t(F), { productType: t(n), columns: t(r) }, null, 8, ["productType", "columns"]), a(t(I), { productType: t(n), columns: t(r) }, { quantity: p(() => [t(r).visible("quantity") ? (l(), _(o, { key: 0, prop: "quantity", sortable: "custom", label: "数量", align: "center", "min-width": "70px" })) : h("", true)]), _: 1 }, 8, ["productType", "columns"]), t(r).visible("date") ? (l(), _(o, { key: "date", prop: "date", sortable: "custom", "show-overflow-tooltip": true, label: "生产日期", align: "center", width: "160px" }, { default: p((e) => [c("span", null, u(e.row.date), 1)]), _: 1 })) : h("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "onSortChange"])), [[y, t(i).loading]]), a(t($))]);
  };
} };
export {
  ot as default
};
