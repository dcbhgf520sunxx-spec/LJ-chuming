import { ref as v } from "vue";
import { reactive as E } from "vue";
import { provide as I } from "vue";
import { watch as R } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as f } from "vue";
import { unref as t } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as i } from "vue";
import { withCtx as a } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as w } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElTag as H } from "element-plus";
import { vLoading as O } from "element-plus";
import { c as q, g as M } from "../../../modules/radan-controller-25ebed6e.js";
import { x as Q, o as z, G as S, m3 as y, P as G } from "../../../shared/runtime.js";
import W from "./module/header.vue.js";
import $ from "./detail/index.vue.js";
import { e as b } from "../../../modules/cutting-457c256f.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "./detail/group.vue.js";
const F = { class: "app-container" }, J = { class: "head-container" }, le = { __name: "index", setup(K) {
  const _ = v(false), h = v(), k = v([]), T = { add: false, edit: false, del: false, download: false }, c = E({ summary: {}, provinceList: [], loading: true });
  I("projectInfo", c);
  const { crud: d, columns: u } = Q({ title: "套料任务", sort: ["createTime.desc"], permission: { ...b }, optShow: { ...T }, crudApi: { ...q }, hasPagination: true }, h);
  R((n) => {
    N(), d.toQuery();
  }, { deep: true });
  const { maxHeight: j } = z({ paginate: true });
  async function N() {
    if (S(b.statistics)) {
      c.loading = true;
      try {
        const n = await M({ year: d.query.year }) || {};
        c.provinceList = n.provinceList, delete n.provinceList, c.summary = n;
      } catch (n) {
        console.log("获取项目汇总图表数据", n);
      } finally {
        c.loading = false;
      }
    }
  }
  function P(n) {
    _.value = true, k.value = n, console.log(n);
  }
  function C() {
    N(), d.toQuery();
  }
  return (n, l) => {
    const s = U, g = H, L = x("common-button"), V = x("common-table"), D = O;
    return o(), A("div", F, [m("div", J, [f(t(W))]), B((o(), i(V, { ref_key: "tableRef", ref: h, data: t(d).data, "empty-text": t(d).emptyText, "max-height": t(j), style: { width: "100%" } }, { default: a(() => [f(s, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(u).visible("projectName") ? (o(), i(s, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "项目名称", "min-width": "100", "header-align": "center" }, { default: a((e) => [m("span", null, p(e.row.projectNumber) + "-" + p(e.row.projectName), 1)]), _: 1 })) : r("", true), t(u).visible("monomerNum") ? (o(), i(s, { key: "monomerNum", prop: "monomerNum", "show-overflow-tooltip": true, label: "单体", "min-width": "60", align: "center" }, { default: a((e) => [m("span", null, p(e.row.monomerNum), 1)]), _: 1 })) : r("", true), t(u).visible("areaNum") ? (o(), i(s, { key: "areaNum", prop: "areaNum", "show-overflow-tooltip": true, label: "单元", "min-width": "60", align: "center" }, { default: a((e) => [m("span", null, p(e.row.areaNum), 1)]), _: 1 })) : r("", true), t(u).visible("sum") ? (o(), i(s, { key: "sum", prop: "sum", align: "center", "show-overflow-tooltip": true, label: "零件数量（件）", "min-width": "60" }, { default: a((e) => [m("span", null, p(e.row.sum), 1)]), _: 1 })) : r("", true), t(u).visible("reduce") ? (o(), i(s, { key: "reduce", prop: "reduce", align: "center", "show-overflow-tooltip": true, label: "零件重量（kg）", "min-width": "60" }, { default: a((e) => [m("span", null, p(e.row.reduce), 1)]), _: 1 })) : r("", true), t(u).visible("nestingState") ? (o(), i(s, { key: "nestingState", prop: "nestingState", "show-overflow-tooltip": true, label: "状态", align: "center", "min-width": "60" }, { default: a((e) => [e.row.nestingState === t(y).NOT_LINED_UP.V ? (o(), i(g, { key: 0, style: { width: "100%" }, type: "danger" }, { default: a(() => l[1] || (l[1] = [w("未排套")])), _: 1, __: [1] })) : r("", true), e.row.nestingState && e.row.nestingState === t(y).PARTIAL_ROW_SETS.V ? (o(), i(g, { key: 1, style: { width: "100%" }, type: "warning" }, { default: a(() => l[2] || (l[2] = [w("部分排套")])), _: 1, __: [2] })) : r("", true), e.row.nestingState && e.row.nestingState === t(y).LINED_UP.V ? (o(), i(g, { key: 2, style: { width: "100%" }, type: "success" }, { default: a(() => l[3] || (l[3] = [w("排套结束")])), _: 1, __: [3] })) : r("", true)]), _: 1 })) : r("", true), t(u).visible("importTime") ? (o(), i(s, { key: "importTime", align: "center", prop: "importTime", "show-overflow-tooltip": true, label: "创建时间", "min-width": "60" }, { default: a((e) => [m("span", null, p(e.row.importTime), 1)]), _: 1 })) : r("", true), t(S)(t(b).detail) ? (o(), i(s, { key: 7, "show-overflow-tooltip": true, label: "操作", align: "center" }, { default: a((e) => [f(L, { size: "default", type: "primary", icon: "el-icon-view", onClick: (X) => P(e.row) }, { default: a(() => l[4] || (l[4] = [w("查看")])), _: 2, __: [4] }, 1032, ["onClick"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[D, t(d).loading]]), f(t(G)), f($, { "detail-data": k.value, visible: _.value, "onUpdate:visible": l[0] || (l[0] = (e) => _.value = e), onSuccess: C }, null, 8, ["detail-data", "visible"])]);
  };
} };
export {
  le as default
};
