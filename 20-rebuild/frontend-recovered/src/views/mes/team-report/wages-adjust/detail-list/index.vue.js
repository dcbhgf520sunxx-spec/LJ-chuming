import { inject as S } from "vue";
import { computed as A } from "vue";
import { watch as B } from "vue";
import { ref as g } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as N } from "vue";
import { createElementVNode as P } from "vue";
import { createVNode as s } from "vue";
import { withCtx as i } from "vue";
import { renderSlot as j } from "vue";
import { unref as e } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as u } from "vue";
import { createCommentVNode as w } from "vue";
import { createTextVNode as H } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { vLoading as V } from "element-plus";
import { c as $ } from "../../../../../modules/detail-bead30a9.js";
import { a3 as D, x as F, o as M, G as W, P as G } from "../../../../../shared/runtime.js";
import { _ as K } from "../../../../../modules/index-490fd9d7.js";
import { p as L } from "../../../../../modules/mes-ee117a22.js";
import { _ as U } from "../../../../../modules/index-897a9ea4.js";
import z from "./module/header.vue.js";
const J = { class: "app-container" }, X = { class: "head-container" }, re = { __name: "index", props: { fQuery: { type: Object, default: () => {
} }, fInfo: { type: Object, default: () => {
} } }, emits: ["setInfo", "clearInfo"], setup(p, { expose: x, emit: I }) {
  const f = I, _ = S("permission"), d = p, c = A(() => {
    var t;
    return ((t = d.fQuery) == null ? void 0 : t.productType) || D.MACHINE_PART.V;
  });
  B(() => c.value, () => {
    o.data = [], f("clearInfo");
  });
  const k = { add: false, edit: false, del: false, download: false }, v = g(), h = g(), { crud: o, columns: m, CRUD: y } = F({ title: "工价调整明细", permission: { ..._ }, optShow: { ...k }, crudApi: { ...$ }, hasPagination: true, queryOnPresenterCreated: false }, h), { maxHeight: T } = M({ paginate: true });
  y.HOOK.beforeRefresh = () => {
    const { name: t, steelId: n, steelSpec: a, category: r } = d.fInfo || {};
    o.query = Object.assign(o.query, d.fQuery, { name: t, steelId: n, steelSpec: a, category: r });
  }, y.HOOK.handleRefresh = (t, n) => {
    n.data.content = n.data.content.map((a, r) => (a.rowId = r + "" + Math.random(), a));
  };
  function C(t) {
    f("setInfo", t);
  }
  return x({ toQuery: o.toQuery }), (t, n) => {
    const a = Q, r = b("common-button"), R = b("common-table"), O = V;
    return l(), N("div", J, [P("div", X, [s(e(z), { ref_key: "headRef", ref: v, fInfo: p.fInfo }, { auditBox: i(() => [j(t.$slots, "auditBox")]), _: 3 }, 8, ["fInfo"])]), E((l(), u(R, { ref_key: "tableRef", ref: h, data: e(o).data, "data-format": e(L)[c.value], "empty-text": e(o).emptyText, "max-height": e(T), "row-key": "rowId", style: { width: "100%" } }, { default: i(() => [s(a, { label: "序号", type: "index", align: "center", width: "60" }), s(e(K), { productType: c.value, columns: e(m), unShowField: ["material", "plate"] }, null, 8, ["productType", "columns"]), s(e(U), { productType: c.value, columns: e(m), unShowField: ["grossWeight", "totalNetWeight", "totalGrossWeight", "surfaceArea", "totalArea", "totalLength", "weight"] }, { quantity: i(() => [e(m).visible("quantity") ? (l(), u(a, { key: 0, prop: "quantity", sortable: "custom", label: "数量", align: "center", "min-width": "70px" })) : w("", true)]), _: 1 }, 8, ["productType", "columns"]), e(W)(e(_).edit) ? (l(), u(a, { key: 0, align: "center", prop: "prop", label: "操作", width: "110" }, { default: i(({ row: q }) => [s(r, { type: "primary", size: "default", onClick: (Y) => C(q) }, { default: i(() => n[0] || (n[0] = [H("工价调整")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 })) : w("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[O, e(o).loading]]), s(e(G))]);
  };
} };
export {
  re as default
};
