import { computed as F } from "vue";
import { ref as G } from "vue";
import { watch as O } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as Q } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as N } from "vue";
import { withDirectives as I } from "vue";
import { unref as o } from "vue";
import { createBlock as g } from "vue";
import { withCtx as _ } from "vue";
import { toDisplayString as q } from "vue";
import { createCommentVNode as b } from "vue";
import { ElTableColumn as P } from "element-plus";
import { ElProgress as H } from "element-plus";
import { vLoading as L } from "element-plus";
import { c as A } from "./project-detail/index.vue.js";
import { x as U, rO as $, o as j, bo as d, D as f } from "../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import J from "./monthly-task-detail/index.vue.js";
import "../../../../modules/production-line-select-f08e245b.js";
const X = { class: "app-container" }, Y = { style: { display: "flex" } }, Z = { style: { width: "38%" } }, tt = { class: "head-container" }, ut = { __name: "index", setup(et) {
  const E = { add: false, edit: false, del: false, download: false }, x = F(() => ({ workShopId: r.query.workShopId, productionLineId: r.query.productionLineId })), k = G(), w = G([]), { crud: r, CRUD: V, columns: v } = U({ title: "月度任务跟踪", sort: [], optShow: { ...E }, permission: { ...$ }, invisibleColumns: ["grossWeight", "completeGrossWeight"], crudApi: { ...A }, hasPagination: false }, k);
  O([() => r.query.dateTime, () => r.query.weightStatus], (l) => {
    l && (w.value = {});
  }), O(() => x.value, (l) => {
    l && (w.value = {});
  });
  const { maxHeight: K } = j({ extraBox: [".head-container"], paginate: true });
  function M(l) {
    w.value = l;
  }
  V.HOOK.handleRefresh = (l, h) => {
    var i;
    h.data.content = (i = h.data) == null ? void 0 : i.map((a) => {
      var n;
      return a.months = (n = a.month) == null ? void 0 : n.split("-")[1], a;
    });
  };
  function R(l) {
    const { columns: h, data: i } = l, a = [], n = [];
    return h.forEach((s, t) => {
      if (t === 0) {
        a[t] = "全年平均";
        return;
      }
      if (s.property === "rate") {
        a[t] = 0, i.map((u) => n.push(u.completeQuantity / u.quantity));
        for (let u = 0; u <= n.length - 1; u++) a[t] = a[t] + n[u];
        a[t] = (a[t] / n.length * 100).toFixed(2) + "%";
        return;
      }
      if (s.property === "list" || s.property === "complete") {
        const u = s.property === "list" ? "quantity" : s.property + "Quantity", W = i.map((e) => Number(e == null ? void 0 : e[u]));
        let T = 0, m = "";
        s.property === "list" && r.query.weightStatus === d.NET.V ? m = "netWeight" : s.property === "list" && r.query.weightStatus === d.GROSS.V ? m = "grossWeight" : s.property !== "list" && r.query.weightStatus === d.NET.V ? m = s.property + "NetWeight" : s.property !== "list" && r.query.weightStatus === d.GROSS.V && (m = s.property + "GrossWeight");
        const C = i.map((e) => Number((e == null ? void 0 : e[m]) / 1e3));
        let D = 0;
        W.every((e) => isNaN(e)) || (T = W.reduce((e, y) => {
          const S = Number(y);
          return isNaN(S) ? e : e + y;
        }, 0)), C.every((e) => isNaN(e)) || (D = C.reduce((e, y) => {
          const S = Number(y);
          return isNaN(S) ? e : e + y;
        }, 0)), a[t] = T + "/" + D.toFixed(f.COM_WT__KG);
      }
    }), a;
  }
  return (l, h) => {
    const i = P, a = H, n = B("common-table"), s = L;
    return c(), Q("div", X, [p("div", Y, [p("div", Z, [p("div", tt, [N(z)]), I((c(), g(n, { ref_key: "tableRef", ref: k, data: o(r).data, "empty-text": o(r).emptyText, "max-height": o(K), "highlight-current-row": "", returnSourceData: "", "row-key": "id", style: { cursor: "pointer" }, "show-summary": "", "summary-method": R, onRowClick: M }, { default: _(() => [o(v).visible("months") ? (c(), g(i, { align: "center", key: "months", prop: "months", "show-overflow-tooltip": true, label: "月份", width: "80px" }, { default: _((t) => [p("span", null, q(t.row.months) + "月", 1)]), _: 1 })) : b("", true), o(v).visible("list") ? (c(), g(i, { align: "center", key: "list", prop: "list", "show-overflow-tooltip": true, label: "排产量（件/吨）" }, { default: _((t) => [p("span", null, q(o(r).query.weightStatus === o(d).NET.V ? t.row.quantity + "/" + (t.row.netWeight / 1e3).toFixed(o(f).COM_WT__KG) : t.row.quantity + "/" + (t.row.grossWeight / 1e3).toFixed(o(f).COM_WT__KG)), 1)]), _: 1 })) : b("", true), o(v).visible("rate") ? (c(), g(i, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "达成率", width: "160px" }, { default: _((t) => [p("span", null, [N(a, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: Number((t.row.completeQuantity / t.row.quantity * 100).toFixed(2)), status: "success" }, null, 8, ["percentage"])])]), _: 1 })) : b("", true), o(v).visible("complete") ? (c(), g(i, { align: "center", key: "complete", prop: "complete", "show-overflow-tooltip": true, label: "实际完成量（件/吨）" }, { default: _((t) => [p("span", null, q(o(r).query.weightStatus === o(d).NET.V ? t.row.completeQuantity + "/" + (t.row.completeNetWeight / 1e3).toFixed(o(f).COM_WT__KG) : t.row.completeQuantity + "/" + (t.row.completeGrossWeight / 1e3).toFixed(o(f).COM_WT__KG)), 1)]), _: 1 })) : b("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[s, o(r).loading]])]), h[0] || (h[0] = p("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 180px)" } }, null, -1)), N(J, { query: x.value, weightStatus: o(r).query.weightStatus, "monthly-data": w.value, style: { width: "60%" } }, null, 8, ["query", "weightStatus", "monthly-data"])])]);
  };
} };
export {
  ut as default
};
