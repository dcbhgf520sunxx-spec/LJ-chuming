import { computed as E } from "vue";
import { ref as S } from "vue";
import { watch as M } from "vue";
import { resolveComponent as H } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as b } from "vue";
import { withDirectives as P } from "vue";
import { unref as a } from "vue";
import { createBlock as h } from "vue";
import { withCtx as y } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as v } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { ElProgress as G } from "element-plus";
import { vLoading as L } from "element-plus";
import { c as V } from "./project-detail/index.vue.js";
import { H as A } from "../../../../modules/bridge-86f96a4f.js";
import { x as U, o as $, D as x } from "../../../../shared/runtime.js";
import j from "./module/header.vue.js";
import z from "./monthly-task-detail/index.vue.js";
import "../../../../modules/production-line-select-307387f7.js";
const J = { class: "app-container" }, X = { class: "head-container" }, Y = { style: { display: "flex" } }, ie = { __name: "index", setup(Z) {
  const K = { add: false, edit: false, del: false, download: false }, k = E(() => ({ workShopId: p.query.workShopId, productionLineId: p.query.productionLineId })), N = S(), _ = S([]), { crud: p, CRUD: W, columns: g } = U({ title: "月度任务跟踪", sort: [], optShow: { ...K }, permission: { ...A }, crudApi: { ...V }, hasPagination: false }, N);
  M(() => p.query.dateTime, (r) => {
    r && (_.value = {});
  }), M(() => k.value, (r) => {
    r && (_.value = {});
  });
  const { maxHeight: B } = $({ extraBox: [".head-container"], paginate: true });
  function F(r) {
    _.value = r;
  }
  W.HOOK.handleRefresh = (r, i) => {
    i.data.content = i.data;
  };
  function O(r) {
    const { columns: i, data: s } = r, o = [], c = [];
    return i.forEach((l, e) => {
      if (e === 0) {
        o[e] = "合计";
        return;
      }
      if (e === 2) {
        o[e] = 0, s.map((n) => c.push(n.completeQuantity / n.quantity));
        for (let n = 0; n <= c.length - 1; n++) o[e] = o[e] + c[n];
        o[e] = (o[e] / c.length * 100).toFixed(2) + "%";
        return;
      }
      if (l.property === "list" || l.property === "complete") {
        const n = l.property === "list" ? "quantity" : l.property + "Quantity", C = s.map((t) => Number(t == null ? void 0 : t[n]));
        let q = 0;
        const R = l.property === "list" ? "mete" : l.property + "Mete", D = s.map((t) => Number((t == null ? void 0 : t[R]) / 1e3));
        let T = 0;
        C.every((t) => isNaN(t)) || (q = C.reduce((t, d) => {
          const w = Number(d);
          return isNaN(w) ? t : t + d;
        }, 0)), D.every((t) => isNaN(t)) || (T = D.reduce((t, d) => {
          const w = Number(d);
          return isNaN(w) ? t : t + d;
        }, 0)), o[e] = q + "/" + T.toFixed(x.COM_WT__KG);
      }
    }), o;
  }
  return (r, i) => {
    const s = Q, o = G, c = H("common-table"), l = L;
    return m(), I("div", J, [u("div", X, [b(j)]), u("div", Y, [P((m(), h(c, { ref_key: "tableRef", ref: N, data: a(p).data, "empty-text": a(p).emptyText, "max-height": a(B), "highlight-current-row": "", returnSourceData: "", "row-key": "id", style: { width: "35%", cursor: "pointer" }, "show-summary": "", "summary-method": O, onCurrentChange: F }, { default: y(() => [a(g).visible("month") ? (m(), h(s, { align: "center", key: "month", prop: "month", "show-overflow-tooltip": true, label: "月份", width: "80px" }, { default: y((e) => [u("span", null, f(e.row.month) + "月", 1)]), _: 1 })) : v("", true), a(g).visible("list") ? (m(), h(s, { align: "center", key: "list", prop: "list", "show-overflow-tooltip": true, label: "排产量（件/吨）" }, { default: y((e) => [u("span", null, f(e.row.quantity) + "/" + f((e.row.mete / 1e3).toFixed(a(x).COM_WT__KG)), 1)]), _: 1 })) : v("", true), a(g).visible("rate") ? (m(), h(s, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "达成率", width: "160px" }, { default: y((e) => [u("span", null, [b(o, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: (e.row.completeQuantity / e.row.quantity * 100).toFixed(2), status: "success" }, null, 8, ["percentage"])])]), _: 1 })) : v("", true), a(g).visible("complete") ? (m(), h(s, { align: "center", key: "complete", prop: "complete", "show-overflow-tooltip": true, label: "实际完成（件/吨）" }, { default: y((e) => [u("span", null, f(e.row.completeQuantity) + "/" + f((e.row.completeMete / 1e3).toFixed(a(x).COM_WT__KG)), 1)]), _: 1 })) : v("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[l, a(p).loading]]), i[0] || (i[0] = u("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 180px)" } }, null, -1)), b(z, { query: k.value, "monthly-data": _.value, style: { flex: "1" } }, null, 8, ["query", "monthly-data"])])]);
  };
} };
export {
  ie as default
};
