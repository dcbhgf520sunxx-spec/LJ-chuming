import { ref as h } from "vue";
import { watch as M } from "vue";
import { resolveComponent as G } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as o } from "vue";
import { withDirectives as b } from "vue";
import { vShow as k } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as n } from "vue";
import { withCtx as c } from "vue";
import { toDisplayString as p } from "vue";
import { unref as t } from "vue";
import { Fragment as _ } from "vue";
import { renderList as D } from "vue";
import { ElTableColumn as V } from "element-plus";
import { ElProgress as B } from "element-plus";
import { ElPagination as K } from "element-plus";
import { m as H, _ as Q } from "../project-detail/index.vue.js";
import { _ as R, o as I, J as L, z as J, bo as C, D as d } from "../../../../../shared/runtime.js";
const U = { class: "app-container" }, $ = { class: "my-code", style: { width: "100%" } }, A = { style: { width: "100%" } }, X = { key: 0 }, Y = { key: 1 }, Z = { key: 2 }, ee = { key: 0 }, te = { key: 1 }, ae = { key: 2 }, oe = { class: "tc-primary" }, ne = { class: "tc-primary" }, re = { __name: "index", props: { monthlyData: { type: Object, default: () => {
} }, query: { type: Object }, weightStatus: { type: Number } }, setup(T) {
  const r = T, w = h([]), O = h(), f = h({}), y = h(false), { maxHeight: q } = I({ extraBox: [".head-container"], paginate: true });
  M(() => r.monthlyData.month, (s) => {
    s && v();
  });
  const { handleSizeChange: N, handleCurrentChange: S, total: j, setTotalPage: z, queryPage: g } = L({ fetchHook: v });
  async function v() {
    let s = [];
    try {
      const { content: m = [], totalElements: l } = await H({ ...r.query, dateTime: new Date(r.monthlyData.month).getTime(), ...g });
      z(l), s = m;
    } catch (m) {
      console.log("获取当前月的项目数据失败", m);
    } finally {
      w.value = s;
    }
  }
  function E(s) {
    y.value = true, f.value = s;
  }
  return (s, m) => {
    var x;
    const l = V, P = B, W = G("common-table"), F = K;
    return a(), o("div", U, [b(u("div", $, "*点击左侧表格行查看详情", 512), [[k, !r.monthlyData.month]]), b(u("div", A, [n(W, { ref_key: "tableRef", ref: O, data: w.value, "empty-text": "暂无数据", "max-height": t(q), "highlight-current-row": "", "row-key": "projectId", style: { width: "100%", cursor: "pointer" }, onRowClick: E }, { default: c(() => [n(l, { type: "index", label: "序号", key: "index", align: "center", width: "60px" }), n(l, { key: "project.shortName", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "150px" }, { default: c((e) => [u("span", null, p(t(J)(e.row.project)), 1)]), _: 1 }), n(l, { align: "left", key: "monomer", prop: "monomer", "show-overflow-tooltip": true, label: "包含单体" }, { default: c((e) => [(a(true), o(_, null, D(e.row.monomerDO, (i) => (a(), o(_, { key: i }, [e.row.monomerDO.length > 1 ? (a(), o("span", X, p(i.name) + "/", 1)) : e.row.monomerDO.length === 1 ? (a(), o("span", Y, p(i.name), 1)) : (a(), o("span", Z, "-"))], 64))), 128))]), _: 1 }), n(l, { align: "left", key: "area", prop: "area", "show-overflow-tooltip": true, label: "包含区域" }, { default: c((e) => [(a(true), o(_, null, D(e.row.areaDO, (i) => (a(), o(_, { key: i }, [e.row.areaDO.length > 1 ? (a(), o("span", ee, p(i.name) + "/", 1)) : e.row.areaDO.length === 1 ? (a(), o("span", te, p(i.name), 1)) : (a(), o("span", ae, "-"))], 64))), 128))]), _: 1 }), n(l, { align: "center", key: "list", prop: "list", "show-overflow-tooltip": true, label: "排产量（件/吨）" }, { default: c((e) => [u("span", oe, p(r.weightStatus === t(C).NET.V ? e.row.quantity + "/" + (e.row.netWeight / 1e3).toFixed(t(d).COM_WT__KG) : e.row.quantity + "/" + (e.row.grossWeight / 1e3).toFixed(t(d).COM_WT__KG)), 1)]), _: 1 }), n(l, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "完成率", width: "160px" }, { default: c((e) => [u("span", null, [n(P, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: Number((e.row.completeQuantity / e.row.quantity * 100).toFixed(2)), status: "success" }, null, 8, ["percentage"])])]), _: 1 }), n(l, { align: "center", key: "complete", prop: "complete", "show-overflow-tooltip": true, label: "实际完成（件/吨）" }, { default: c((e) => [u("span", ne, p(r.weightStatus === t(C).NET.V ? e.row.completeQuantity + "/" + (e.row.completeNetWeight / 1e3).toFixed(t(d).COM_WT__KG) : e.row.completeQuantity + "/" + (e.row.completeGrossWeight / 1e3).toFixed(t(d).COM_WT__KG)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), n(F, { total: t(j), "current-page": t(g).pageNumber, "page-size": t(g).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(N), onCurrentChange: t(S) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 512), [[k, r.monthlyData.month]]), n(Q, { visible: y.value, "onUpdate:visible": m[0] || (m[0] = (e) => y.value = e), dateTime: (x = r.monthlyData) == null ? void 0 : x.month, "detail-data": f.value, "params-query": r.query }, null, 8, ["visible", "dateTime", "detail-data", "params-query"])]);
  };
} }, pe = R(re, [["__scopeId", "data-v-33cf9548"]]);
export {
  pe as default
};
