import { ref as h } from "vue";
import { watch as M } from "vue";
import N from "moment";
import { resolveComponent as B } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as a } from "vue";
import { withDirectives as x } from "vue";
import { vShow as b } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as o } from "vue";
import { withCtx as c } from "vue";
import { toDisplayString as l } from "vue";
import { unref as r } from "vue";
import { Fragment as _ } from "vue";
import { renderList as D } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { ElProgress as H } from "element-plus";
import { ElPagination as R } from "element-plus";
import { m as V, _ as G } from "../project-detail/index.vue.js";
import { _ as I, o as K, J as L, z as W, D as C } from "../../../../../shared/runtime.js";
import "../../../../../modules/bridge-86f96a4f.js";
const Y = { class: "app-container" }, J = { class: "my-code", style: { width: "100%" } }, U = { style: { width: "100%" } }, $ = { key: 0 }, A = { key: 1 }, X = { key: 2 }, Z = { key: 0 }, ee = { key: 1 }, te = { key: 2 }, ae = { __name: "index", props: { monthlyData: { type: Object, default: () => {
} }, query: { type: Object } }, setup(O) {
  const p = O, f = h([]), j = h(), v = h({}), d = h(false), { maxHeight: q } = K({ extraBox: [".head-container"], paginate: true });
  M(() => p.monthlyData.month, (s) => {
    s && k();
  });
  const { handleSizeChange: z, handleCurrentChange: P, total: S, setTotalPage: T, queryPage: y } = L({ fetchHook: k });
  async function k() {
    let s = [];
    try {
      const u = N().set("month", p.monthlyData.month - 1)._d, n = (/* @__PURE__ */ new Date(u.getFullYear() + "-" + p.monthlyData.month)).getTime(), { content: g = [], totalElements: w } = await V({ ...p.query, dateTime: n, ...y });
      T(w), s = g;
    } catch (u) {
      console.log("获取当前月的项目数据失败", u);
    } finally {
      f.value = s;
    }
  }
  function F(s) {
    d.value = true, v.value = s;
  }
  return (s, u) => {
    const n = Q, g = H, w = B("common-table"), E = R;
    return t(), a("div", Y, [x(m("div", J, "*点击左侧表格行查看详情", 512), [[b, !p.monthlyData.month]]), x(m("div", U, [o(w, { ref_key: "tableRef", ref: j, data: f.value, "empty-text": "暂无数据", "max-height": r(q), "highlight-current-row": "", "row-key": "projectId", style: { width: "100%", cursor: "pointer" }, onRowClick: F }, { default: c(() => [o(n, { type: "index", label: "序号", key: "index", align: "center", width: "60px" }), o(n, { key: "project.shortName", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "150px" }, { default: c((e) => [m("span", null, l(r(W)(e.row.project)), 1)]), _: 1 }), o(n, { align: "left", key: "monomer", prop: "monomer", "show-overflow-tooltip": true, label: "包含单体" }, { default: c((e) => [(t(true), a(_, null, D(e.row.monomerDO, (i) => (t(), a(_, { key: i }, [e.row.monomerDO.length > 1 ? (t(), a("span", $, l(i.name) + "/", 1)) : e.row.monomerDO.length === 1 ? (t(), a("span", A, l(i.name), 1)) : (t(), a("span", X, "-"))], 64))), 128))]), _: 1 }), o(n, { align: "left", key: "area", prop: "area", "show-overflow-tooltip": true, label: "包含区域" }, { default: c((e) => [(t(true), a(_, null, D(e.row.areaDO, (i) => (t(), a(_, { key: i }, [e.row.areaDO.length > 1 ? (t(), a("span", Z, l(i.name) + "/", 1)) : e.row.areaDO.length === 1 ? (t(), a("span", ee, l(i.name), 1)) : (t(), a("span", te, "-"))], 64))), 128))]), _: 1 }), o(n, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "排产量（件/吨）" }, { default: c((e) => [m("span", null, l(e.row.quantity) + "/" + l((e.row.mete / 1e3).toFixed(r(C).COM_WT__KG)), 1)]), _: 1 }), o(n, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "完成率", width: "160px" }, { default: c((e) => [m("span", null, [o(g, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: (e.row.completeQuantity / e.row.quantity * 100).toFixed(2), status: "success" }, null, 8, ["percentage"])])]), _: 1 }), o(n, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "实际完成（件/吨）" }, { default: c((e) => [m("span", null, l(e.row.completeQuantity) + "/" + l((e.row.completeMete / 1e3).toFixed(r(C).COM_WT__KG)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), o(E, { total: r(S), "current-page": r(y).pageNumber, "page-size": r(y).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: r(z), onCurrentChange: r(P) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 512), [[b, p.monthlyData.month]]), o(G, { visible: d.value, "onUpdate:visible": u[0] || (u[0] = (e) => d.value = e), "detail-data": v.value }, null, 8, ["visible", "detail-data"])]);
  };
} }, ie = I(ae, [["__scopeId", "data-v-632933f1"]]);
export {
  ie as default
};
