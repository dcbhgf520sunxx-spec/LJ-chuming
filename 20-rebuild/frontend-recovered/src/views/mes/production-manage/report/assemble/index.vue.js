import { provide as m } from "vue";
import { ref as C } from "vue";
import { resolveComponent as T } from "vue";
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
import { ElTableColumn as P } from "element-plus";
import { vLoading as D } from "element-plus";
import { g as R, c as A } from "../../../../../modules/common-17e7687a.js";
import { a3 as M, x as N, pV as V, o as q, bs as B, D as E, P as W } from "../../../../../shared/runtime.js";
import { _ as $ } from "../../../../../modules/index-3b2628f3.js";
import { _ as H } from "../../../../../modules/index-490fd9d7.js";
import { p as O } from "../../../../../modules/mes-ee117a22.js";
import { _ as j } from "../../../../../modules/index-897a9ea4.js";
import F from "../components/report-header.vue.js";
import "../../../../../modules/index-b238c21c.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
const G = { class: "app-container" }, I = { class: "head-container" }, ot = { __name: "index", setup(K) {
  const g = { add: false, edit: false, del: false, download: false }, n = M.ASSEMBLE.V;
  m("getSummaryApi", R), m("productType", n), m("defaultQuery", { productType: n });
  const f = C(), { crud: i, columns: s, CRUD: b } = N({ title: "生产报表-部件报表", permission: { ...V }, optShow: { ...g }, crudApi: { ...A }, invisibleColumns: ["grossWeight", "netWeight", "totalGrossWeight", "drawingNumber", "surfaceArea", "remark"] }, f), { maxHeight: w } = q({ paginate: true });
  return b.HOOK.handleRefresh = (x, r) => {
    r.data.content = r.data.content.map((o, d) => (o.rowId = d + "" + Math.random(), o));
  }, (x, r) => {
    const o = P, d = T("common-table"), y = D;
    return l(), k("div", G, [c("div", I, [a(F, { "print-key": "mesAssemblePartProductionReport" }, { summaryText: p(({ summary: e }) => [c("span", null, u(e == null ? void 0 : e.quantity) + "件", 1), r[0] || (r[0] = v(" / ")), c("span", null, u(t(B)(e == null ? void 0 : e.totalNetWeight, t(E).COM_WT__KG)) + "kg", 1)]), _: 1 })]), S((l(), _(d, { ref_key: "tableRef", ref: f, data: t(i).data, "data-format": t(O)[t(n)], "empty-text": t(i).emptyText, "max-height": t(w), "row-key": "rowId", style: { width: "100%" }, onSortChange: t(i).handleSortChange }, { default: p(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(t($), { columns: t(s), showProject: "", showMonomer: "" }, null, 8, ["columns"]), a(t(H), { productType: t(n), columns: t(s) }, null, 8, ["productType", "columns"]), a(t(j), { productType: t(n), columns: t(s) }, { quantity: p(() => [t(s).visible("quantity") ? (l(), _(o, { key: 0, prop: "quantity", sortable: "custom", label: "数量", align: "center", "min-width": "70px" })) : h("", true)]), _: 1 }, 8, ["productType", "columns"]), t(s).visible("date") ? (l(), _(o, { key: "date", prop: "date", sortable: "custom", "show-overflow-tooltip": true, label: "生产日期", align: "center", width: "160px" }, { default: p((e) => [c("span", null, u(e.row.date), 1)]), _: 1 })) : h("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "onSortChange"])), [[y, t(i).loading]]), a(t(W))]);
  };
} };
export {
  ot as default
};
