import { ref as l } from "vue";
import { inject as T } from "vue";
import { provide as $ } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as d } from "vue";
import { renderSlot as B } from "vue";
import { withDirectives as E } from "vue";
import { unref as e } from "vue";
import { createBlock as f } from "vue";
import { withCtx as i } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as y } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElTag as M } from "element-plus";
import { vLoading as S } from "element-plus";
import { c as j } from "../../../../../modules/piecework-system-3800a6fe.js";
import { x as H, o as I, rX as O, rY as W, aY as C, G as Y, P as F, V as G } from "../../../../../shared/runtime.js";
import { _ as U } from "../../../../../modules/index-3b2628f3.js";
import K from "./detail.vue.js";
import "../../../../../modules/index-490fd9d7.js";
const X = { class: "app-container" }, J = { class: "head-container" }, le = { __name: "index", setup(Z) {
  const N = { add: false, edit: false, del: false, download: false }, V = l([["price", ["to-fixed-ck", "YUAN"]]]), b = l(), v = T("permission"), { crud: p, columns: u, CRUD: Q } = H({ title: "班组工资", sort: [], permission: { ...v }, optShow: { ...N }, crudApi: { ...j }, hasPagination: true }, b), { maxHeight: A } = I({ paginate: true });
  $("query", p.query);
  const D = T("name"), P = l([]);
  Q.HOOK.handleRefresh = (m, s) => {
    var n;
    P.value = s.data.content.length && ((n = s.data.content[0]) == null ? void 0 : n.processPrice), s.data.content = s.data.content.map((t, h) => {
      if (t.rowId = h + "" + Math.random(), t.wageQuotaType) {
        const g = O({ wageQuotaType: t.wageQuotaType });
        t.showUnit = g.meteUnit, t.mete = W({ length: t.mate, weight: t.mate, surfaceArea: t.mate, quantity: t.mate, wageQuotaType: t.wageQuotaType }).convertMete;
      }
      return t;
    });
  };
  const _ = l(false), x = l({});
  function z(m) {
    x.value = G(m), _.value = true;
  }
  return (m, s) => {
    const n = L, t = M, h = k("common-button"), g = k("common-table"), R = S;
    return r(), q("div", X, [d("div", J, [B(m.$slots, "header")]), E((r(), f(g, { ref_key: "tableRef", ref: b, data: e(p).data, "data-format": V.value, "empty-text": e(p).emptyText, "max-height": e(A), "row-key": "rowId", style: { width: "100%" } }, { default: i(() => [o(n, { label: "序号", type: "index", align: "center", width: "60" }), o(e(U), { columns: e(u), showFactory: "", showWorkshop: "", showProductionLine: "" }, null, 8, ["columns"]), e(u).visible("processName") ? (r(), f(n, { key: 0, prop: "processName", "show-overflow-tooltip": true, label: "工序", align: "center", width: "100" }, { default: i(({ row: a }) => [o(t, { effect: "plain" }, { default: i(() => [w(c(a.processName), 1)]), _: 2 }, 1024)]), _: 1 })) : y("", true), e(u).visible("organizationType") ? (r(), f(n, { key: 1, prop: "organizationType", "show-overflow-tooltip": true, label: "属性", align: "center", width: "100" }, { default: i(({ row: a }) => [o(t, { effect: "plain", type: e(C).V[a.organizationType].T }, { default: i(() => [w(c(e(C).VL[a.organizationType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : y("", true), o(e(U), { columns: e(u), showTeam: "", teamAlign: "center" }, null, 8, ["columns"]), o(n, { prop: "showUnit", "show-overflow-tooltip": true, label: "单位", align: "center", width: "100" }, { default: i(({ row: a }) => [d("span", null, c(a.showUnit), 1)]), _: 1 }), o(n, { prop: "mete", "show-overflow-tooltip": true, label: "生产量", align: "center" }, { default: i(({ row: a }) => [d("span", null, c(a.mete), 1)]), _: 1 }), o(n, { prop: "price", "show-overflow-tooltip": true, label: "工资总额(元)", align: "center" }, { default: i(({ row: a }) => [d("span", null, c(a.price), 1)]), _: 1 }), e(Y)([...e(v).detail]) ? (r(), f(n, { key: 2, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: i(({ row: a }) => [o(h, { type: "primary", size: "default", onClick: (ee) => z(a) }, { default: i(() => s[1] || (s[1] = [w("查看")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })) : y("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[R, e(p).loading]]), o(e(F)), o(e(K), { visible: _.value, "onUpdate:visible": s[0] || (s[0] = (a) => _.value = a), info: x.value, title: `${e(D)}班组工资详情` }, null, 8, ["visible", "info", "title"])]);
  };
} };
export {
  le as default
};
