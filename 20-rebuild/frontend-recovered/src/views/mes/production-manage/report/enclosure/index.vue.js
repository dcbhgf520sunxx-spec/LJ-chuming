import { provide as d } from "vue";
import { ref as k } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as n } from "vue";
import { withCtx as i } from "vue";
import { unref as t } from "vue";
import { toDisplayString as u } from "vue";
import { createTextVNode as A } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as y } from "vue";
import { ElTableColumn as L } from "element-plus";
import { vLoading as U } from "element-plus";
import { g as q, c as v } from "../../../../../modules/common-17e7687a.js";
import { a3 as D, x as N, pW as O, o as P, c as w, D as g, kA as B, bs as $, P as H } from "../../../../../shared/runtime.js";
import { _ as j } from "../../../../../modules/index-3b2628f3.js";
import { _ as F } from "../../../../../modules/index-490fd9d7.js";
import { p as I } from "../../../../../modules/mes-ee117a22.js";
import { _ as Q } from "../../../../../modules/index-897a9ea4.js";
import K from "../components/report-header.vue.js";
import "../../../../../modules/index-b238c21c.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
const W = { class: "app-container" }, z = { class: "head-container" }, st = { __name: "index", setup(G) {
  const b = { add: false, edit: false, del: false, download: false }, r = D.ENCLOSURE.V;
  d("getSummaryApi", q), d("productType", r), d("defaultQuery", { productType: r });
  const h = k(), { crud: a, columns: s, CRUD: x } = N({ title: "生产报表-围护", permission: { ...O }, optShow: { ...b }, crudApi: { ...v }, invisibleColumns: ["remark", "weight"] }, h), { maxHeight: C } = P({ paginate: true });
  return x.HOOK.handleRefresh = (E, l) => {
    l.data.content = l.data.content.map((o, c) => (o.rowId = c + "" + Math.random(), o.totalArea = w(o.totalArea, "mm²", "㎡", g.COM_AREA__M2), o.totalLength = w(o.totalLength, "mm", "m", g.COM_L__M), o));
  }, (E, l) => {
    const o = f("common-radio-button"), c = L, S = f("common-table"), T = U;
    return m(), R("div", W, [p("div", z, [n(K, { "print-key": "mesEnclosureProductionReport" }, { customSearch: i(({ query: e }) => [n(o, { modelValue: e.category, "onUpdate:modelValue": (M) => e.category = M, options: t(B).ENUM, showOptionAll: "", type: "enum", class: "filter-item", onChange: t(a).toQuery }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), summaryText: i(({ summary: e }) => [p("span", null, u(e == null ? void 0 : e.quantity) + "张", 1), l[0] || (l[0] = A(" / ")), p("span", null, u(t($)(e == null ? void 0 : e.totalLength, t(g).MES_ENCLOSURE_L__M)) + "m", 1)]), _: 1 })]), V((m(), _(S, { ref_key: "tableRef", ref: h, data: t(a).data, "data-format": t(I)[t(r)], "empty-text": t(a).emptyText, "max-height": t(C), "row-key": "rowId", style: { width: "100%" }, onSortChange: t(a).handleSortChange }, { default: i(() => [n(c, { label: "序号", type: "index", align: "center", width: "60" }), n(t(j), { columns: t(s), showProject: "", showMonomer: "" }, null, 8, ["columns"]), n(t(F), { productType: t(r), category: t(a).query.category, columns: t(s) }, null, 8, ["productType", "category", "columns"]), n(t(Q), { productType: t(r), category: t(a).query.category, columns: t(s) }, { quantity: i(() => [t(s).visible("quantity") ? (m(), _(c, { key: "quantity", prop: "quantity", sortable: "custom", label: "数量", align: "center", "min-width": "70px" })) : y("", true)]), _: 1 }, 8, ["productType", "category", "columns"]), t(s).visible("date") ? (m(), _(c, { key: "date", prop: "date", sortable: "custom", "show-overflow-tooltip": true, label: "生产日期", align: "center", width: "160px" }, { default: i((e) => [p("span", null, u(e.row.date), 1)]), _: 1 })) : y("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "onSortChange"])), [[T, t(a).loading]]), n(t(H))]);
  };
} };
export {
  st as default
};
