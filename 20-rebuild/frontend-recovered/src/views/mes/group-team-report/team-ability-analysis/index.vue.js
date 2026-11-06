import { ref as C } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as d } from "vue";
import { withCtx as n } from "vue";
import { unref as e } from "vue";
import { createBlock as s } from "vue";
import { createTextVNode as W } from "vue";
import { createCommentVNode as D } from "vue";
import { withDirectives as B } from "vue";
import { toDisplayString as y } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as O } from "element-plus";
import { l as w, x as P, nG as q, o as R, c, D as g, G as A, L as V, p as o, P as E } from "../../../../shared/runtime.js";
import H from "./module/header.vue.js";
function S(m) {
  return w({ module: "mes", url: "report/capacity_analysis", method: "get", params: m });
}
function U(m) {
  return w({ url: "/api/mes/building/report/capacity_analysis/download", method: "get", timeout: 6e6, responseType: "blob", params: m });
}
const G = { get: S }, L = { class: "app-container" }, $ = { class: "head-container" }, z = { __name: "index", setup(m) {
  const _ = { add: false, edit: false, del: false, download: false }, b = C(), { crud: a, CRUD: k } = P({ title: "能力分析", sort: [], optShow: { ..._ }, permission: { ...q }, crudApi: { ...G }, hasPagination: true }, b), { maxHeight: v } = R({ extraBox: [".head-container"], paginate: true });
  return k.HOOK.handleRefresh = (l, { data: h }) => {
    var r;
    (r = h.content) == null || r.map((u) => {
      var f;
      return u.summaryMete = 0, (f = u.eachMonthDTO) == null || f.forEach((t) => {
        u[t.date] = t.totalCompleteWeight ? c(t.totalCompleteWeight, "kg", "t", g.COM_WT__T) : 0, u.summaryMete = t.totalCompleteWeight ? u.summaryMete + t.totalCompleteWeight : u.summaryMete;
      }), u.summaryMete = c(u.summaryMete, "kg", "t", g.COM_WT__T), u.avgWeight = c(u.avgWeight, "kg", "t", g.COM_WT__T), u;
    });
  }, (l, h) => {
    const r = N, u = M("common-table"), f = O;
    return p(), T("div", L, [i("div", $, [d(H, null, { printBtn: n(() => {
      var t;
      return [e(A)(e(q).export) ? (p(), s(V, { key: 0, fn: e(U), params: { ...e(a).query }, class: "filter-item", disabled: !((t = e(a).data) != null && t.length) }, { default: n(() => h[0] || (h[0] = [W(" 班组能力分析清单 ")])), _: 1, __: [0] }, 8, ["fn", "params", "disabled"])) : D("", true)];
    }), _: 1 })]), B((p(), s(u, { ref_key: "tableRef", ref: b, data: e(a).data, "empty-text": e(a).emptyText, "max-height": e(v), "return-source-data": "", style: { width: "100%" } }, { default: n(() => [d(r, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), d(r, { key: "workshop.name", prop: "workshop.name", "show-overflow-tooltip": true, label: "车间", align: "center" }), d(r, { key: "process.name", prop: "process.name", align: "center", "show-overflow-tooltip": true, label: "工序" }), d(r, { key: "team.name", prop: "team.name", "show-overflow-tooltip": true, align: "center", label: "班组" }), d(r, { key: "teamNumber", prop: "teamNumber", "show-overflow-tooltip": true, align: "center", label: "组员（人）" }), d(r, { key: "total", prop: "total", align: "center", "show-overflow-tooltip": true, label: "月度产量（吨）" }, { default: n(() => [(p(), s(r, { key: l.month1, prop: l.month1, align: "center", "show-overflow-tooltip": true, label: e(o)(e(a).query.date, "{y}") + "-01" }, { default: n(({ row: t }) => [i("span", null, y(t[e(o)(e(a).query.date, "{y}") + "-01"] ? t[e(o)(e(a).query.date, "{y}") + "-01"] : 0), 1)]), _: 1 }, 8, ["prop", "label"])), (p(), s(r, { key: l.month2, prop: l.month2, align: "center", "show-overflow-tooltip": true, label: e(o)(e(a).query.date, "{y}") + "-02" }, { default: n(({ row: t }) => [i("span", null, y(t[e(o)(e(a).query.date, "{y}") + "-02"] ? t[e(o)(e(a).query.date, "{y}") + "-02"] : 0), 1)]), _: 1 }, 8, ["prop", "label"])), (p(), s(r, { key: l.month3, prop: l.month3, align: "center", "show-overflow-tooltip": true, label: e(o)(e(a).query.date, "{y}") + "-03" }, { default: n(({ row: t }) => [i("span", null, y(t[e(o)(e(a).query.date, "{y}") + "-03"] ? t[e(o)(e(a).query.date, "{y}") + "-03"] : 0), 1)]), _: 1 }, 8, ["prop", "label"])), (p(), s(r, { key: l.month4, prop: l.month4, align: "center", "show-overflow-tooltip": true, label: e(o)(e(a).query.date, "{y}") + "-04" }, { default: n(({ row: t }) => [i("span", null, y(t[e(o)(e(a).query.date, "{y}") + "-04"] ? t[e(o)(e(a).query.date, "{y}") + "-04"] : 0), 1)]), _: 1 }, 8, ["prop", "label"])), (p(), s(r, { key: l.month5, prop: l.month5, align: "center", "show-overflow-tooltip": true, label: e(o)(e(a).query.date, "{y}") + "-05" }, { default: n(({ row: t }) => [i("span", null, y(t[e(o)(e(a).query.date, "{y}") + "-05"] ? t[e(o)(e(a).query.date, "{y}") + "-05"] : 0), 1)]), _: 1 }, 8, ["prop", "label"])), (p(), s(r, { key: l.month6, prop: l.month6, align: "center", "show-overflow-tooltip": true, label: e(o)(e(a).query.date, "{y}") + "-06" }, { default: n(({ row: t }) => [i("span", null, y(t[e(o)(e(a).query.date, "{y}") + "-06"] ? t[e(o)(e(a).query.date, "{y}") + "-06"] : 0), 1)]), _: 1 }, 8, ["prop", "label"])), (p(), s(r, { key: l.month7, prop: l.month7, align: "center", "show-overflow-tooltip": true, label: e(o)(e(a).query.date, "{y}") + "-07" }, { default: n(({ row: t }) => [i("span", null, y(t[e(o)(e(a).query.date, "{y}") + "-07"] ? t[e(o)(e(a).query.date, "{y}") + "-07"] : 0), 1)]), _: 1 }, 8, ["prop", "label"])), (p(), s(r, { key: l.month8, prop: l.month8, align: "center", "show-overflow-tooltip": true, label: e(o)(e(a).query.date, "{y}") + "-08" }, { default: n(({ row: t }) => [i("span", null, y(t[e(o)(e(a).query.date, "{y}") + "-08"] ? t[e(o)(e(a).query.date, "{y}") + "-08"] : 0), 1)]), _: 1 }, 8, ["prop", "label"])), (p(), s(r, { key: l.month9, prop: l.month9, align: "center", "show-overflow-tooltip": true, label: e(o)(e(a).query.date, "{y}") + "-09" }, { default: n(({ row: t }) => [i("span", null, y(t[e(o)(e(a).query.date, "{y}") + "-09"] ? t[e(o)(e(a).query.date, "{y}") + "-09"] : 0), 1)]), _: 1 }, 8, ["prop", "label"])), (p(), s(r, { key: l.month10, prop: l.month10, align: "center", "show-overflow-tooltip": true, label: e(o)(e(a).query.date, "{y}") + "-10" }, { default: n(({ row: t }) => [i("span", null, y(t[e(o)(e(a).query.date, "{y}") + "-10"] ? t[e(o)(e(a).query.date, "{y}") + "-10"] : 0), 1)]), _: 1 }, 8, ["prop", "label"])), (p(), s(r, { key: l.month11, prop: l.month11, align: "center", "show-overflow-tooltip": true, label: e(o)(e(a).query.date, "{y}") + "-11" }, { default: n(({ row: t }) => [i("span", null, y(t[e(o)(e(a).query.date, "{y}") + "-11"] ? t[e(o)(e(a).query.date, "{y}") + "-11"] : 0), 1)]), _: 1 }, 8, ["prop", "label"])), (p(), s(r, { key: l.month12, prop: l.month12, align: "center", "show-overflow-tooltip": true, label: e(o)(e(a).query.date, "{y}") + "-12" }, { default: n(({ row: t }) => [i("span", null, y(t[e(o)(e(a).query.date, "{y}") + "-12"] ? t[e(o)(e(a).query.date, "{y}") + "-12"] : 0), 1)]), _: 1 }, 8, ["prop", "label"]))]), _: 1 }), d(r, { key: "summaryMete", prop: "summaryMete", align: "center", "min-width": "120", "show-overflow-tooltip": true, label: "合计" }), d(r, { key: "avgWeight", prop: "avgWeight", align: "center", "show-overflow-tooltip": true, label: `平均能力
（吨/月）` })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[f, e(a).loading]]), d(e(E))]);
  };
} };
export {
  z as default
};
