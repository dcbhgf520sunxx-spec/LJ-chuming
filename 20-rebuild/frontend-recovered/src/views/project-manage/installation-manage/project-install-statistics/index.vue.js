import { ref as d } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withCtx as f } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as I } from "vue";
import { createBlock as P } from "vue";
import { createCommentVNode as U } from "vue";
import { withDirectives as B } from "vue";
import y from "moment";
import { ElTag as E } from "element-plus";
import { ElTableColumn as V } from "element-plus";
import { vLoading as S } from "element-plus";
import { c as z, m as F } from "./module/header.vue.js";
import { _ as G, m as K, x as L, o as Y, p as T, tQ as J, G as W, P as X } from "../../../../shared/runtime.js";
import { v as _ } from "../../../../modules/project-19a12d6b.js";
const Z = { class: "app-container" }, $ = { class: "head-container" }, ee = { key: 0 }, te = { class: "head-tag", style: { "margin-top": "8px", display: "flex", "justify-content": "space-between" } }, ae = { key: 0 }, oe = { key: 1 }, ne = { key: 1, class: "red-tip" }, re = { __name: "index", setup(se) {
  const { globalProjectId: h, globalProject: O } = K(["globalProjectId", "globalProject"]), Q = { add: false, edit: false, del: false, download: false }, C = d([]), g = d(), l = d(""), r = d({}), { crud: t, CRUD: v } = L({ title: "项目安装统计", sort: [], permission: { get: _.detail }, optShow: { ...Q }, crudApi: { ...z }, requiredQuery: ["projectId", "productType"], hasPagination: true }, g), { maxHeight: M } = Y({ extraBox: [".head-container", ".head-tag"], extraHeight: 15, paginate: true });
  v.HOOK.beforeRefresh = () => (t.query.projectId = h.value || void 0, !!t.query.projectId), v.HOOK.handleRefresh = (i, { data: p }) => {
    p.content.forEach((o) => {
      var u, n;
      o.areaId = (u = o.area) == null ? void 0 : u.id, o.monomerId = (n = o.monomer) == null ? void 0 : n.id, o.installAbleNum = o.receivingQuantity ? o.receivingQuantity - (o.installQuantity || 0) - (o.unAuditQuantity || 0) : 0;
    });
  };
  function N(i, p) {
    console.log(t.query.productType, "1111"), l.value = i, r.value = p, i === "total" ? (t.query.startDate = void 0, t.query.endDate = void 0) : i === "last" ? (t.query.startDate = y().subtract(1, "months").startOf("month").valueOf(), t.query.endDate = y().subtract(1, "months").endOf("month").valueOf()) : i === "current" && (t.query.startDate = y().startOf("month").valueOf(), t.query.endDate = y().valueOf()), t.toQuery();
  }
  return (i, p) => {
    const o = E, u = D("print-table"), n = V, R = D("common-table"), A = S;
    return s(), c("div", Z, [m("div", $, [a(e(F), { projectId: e(h), permission: e(_), globalProject: e(O), onProgressChange: N }, null, 8, ["projectId", "permission", "globalProject"])]), l.value ? (s(), c("div", ee, [m("div", te, [m("div", null, [a(o, { type: "primary", size: "default", class: "filter-item", round: "" }, { default: f(() => [H(" 统计日期：" + I(l.value === "total" ? "所有" : e(T)(e(t).query.startDate, "{y}-{m}-{d}") + "~" + e(T)(e(t).query.endDate, "{y}-{m}-{d}")), 1)]), _: 1 }), a(o, { style: { "margin-left": "8px" }, type: "warning", size: "default", class: "filter-item", round: "" }, { default: f(() => {
      var b, w, x, k, q, j;
      return [e(t).query.productType === e(J).ARTIFACT.V ? (s(), c("span", ae, "安装量（件/吨）：")) : (s(), c("span", oe, "安装量（张/平方米）：")), m("span", null, I(l.value === "total" ? ((b = r.value) == null ? void 0 : b.quantity) + "/" + ((w = r.value) == null ? void 0 : w.mete) : l.value === "last" ? ((x = r.value) == null ? void 0 : x.lastMonthQuantity) + "/" + ((k = r.value) == null ? void 0 : k.lastMonthMete) : l.value === "current" ? ((q = r.value) == null ? void 0 : q.currentMonthQuantity) + "/" + ((j = r.value) == null ? void 0 : j.currentMonthMete) : "0/0"), 1)];
    }), _: 1 })]), e(W)(e(_).print) ? (s(), P(u, { key: 0, "api-key": "projectInstallList", params: { ...e(t).query }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"])) : U("", true)]), B((s(), P(R, { ref_key: "tableRef", ref: g, data: e(t).data, "data-format": C.value, "empty-text": e(t).emptyText, "max-height": e(M), style: { width: "100%", "margin-top": "10px" }, stripe: false }, { default: f(() => [a(n, { label: "序号", type: "index", align: "center", width: "60" }), a(n, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "" }), a(n, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "" }), a(n, { key: "serialNumber", prop: "serialNumber", align: "center", "show-overflow-tooltip": true, label: "编号" }), a(n, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "120" }), a(n, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", "show-overflow-tooltip": "" }), a(n, { key: "reportQuantity", prop: "reportQuantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), a(n, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", "show-overflow-tooltip": "" }), a(n, { key: "reportMete", prop: "reportMete", label: "核算量", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[A, e(t).loading]]), a(e(X))])) : (s(), c("div", ne, "* 点击上方累计、上月、本月图表展示详情"))]);
  };
} }, de = G(re, [["__scopeId", "data-v-456288a3"]]);
export {
  de as default
};
