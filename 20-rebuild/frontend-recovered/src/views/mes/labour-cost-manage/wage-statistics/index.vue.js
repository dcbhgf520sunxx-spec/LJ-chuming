import { ref as m } from "vue";
import { computed as w } from "vue";
import { provide as k } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as l } from "vue";
import { withCtx as g } from "vue";
import { createTextVNode as R } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as q } from "element-plus";
import { vLoading as B } from "element-plus";
import { l as I, _ as N, x as S, nY as T, D as A, o as E } from "../../../../shared/runtime.js";
import H from "./module/header.vue.js";
import P from "./details/index.vue.js";
import "./details/module/production-detail.vue.js";
function V(i) {
  return I({ url: "/api/mes/building/wage-manage/wage-statistics/year-summary-list", method: "get", params: i });
}
const Y = { get: V };
const j = { class: "app-container wrap" }, Q = { class: "wrap-left" }, U = { class: "head-container" }, z = { key: 1, style: { color: "red" } }, F = { class: "wrap-right" }, L = { __name: "index", setup(i) {
  const c = m(), n = m(), { crud: t } = S({ title: "工价统计", permission: { ...T }, sort: [], crudApi: { ...Y }, hasPagination: false }, c), y = w(() => [["totalSalary", ["to-thousand", A.YUAN]]]), { maxHeight: h } = E({ paginate: false });
  function f(d) {
    n.value = d;
  }
  return k("query", t.query), (d, _) => {
    var u;
    const s = M, v = C("common-table"), x = q, b = B;
    return a(), p("div", j, [r("div", Q, [r("div", U, [o(e(H))]), e(t).query.projectId ? D((a(), l(v, { key: 0, ref_key: "tableRef", ref: c, data: e(t).data, "empty-text": e(t).emptyText, "max-height": e(h), "data-format": y.value, "highlight-current-row": "", "row-class-name": "table-row", onCurrentChange: f }, { default: g(() => [o(s, { label: "月份", prop: "yearMonth", key: "yearMonth", align: "center" }), o(s, { label: "入库总量（吨）", prop: "totalInboundQuantity", key: "totalInboundQuantity", align: "center" }), o(s, { label: "工资总额", prop: "totalSalary", key: "totalSalary", align: "center" })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[b, e(t).loading]]) : (a(), p("span", z, "* 请先选择项目"))]), r("div", F, [(u = n.value) != null && u.yearMonth ? (a(), l(e(P), { key: 1, currentRow: n.value }, null, 8, ["currentRow"])) : (a(), l(x, { key: 0, type: "info", size: "large" }, { default: g(() => _[0] || (_[0] = [R(" * 请点击左侧列表查看详情 ")])), _: 1, __: [0] }))])]);
  };
} }, X = N(L, [["__scopeId", "data-v-74072119"]]);
export {
  X as default
};
