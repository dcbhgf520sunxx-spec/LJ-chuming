import { ref as y } from "vue";
import { watch as T } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as u } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as e } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as h } from "vue";
import { unref as o } from "vue";
import { createBlock as j } from "vue";
import { createTextVNode as V } from "vue";
import { normalizeStyle as q } from "vue";
import { withDirectives as B } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElTag as $ } from "element-plus";
import { ElDivider as F } from "element-plus";
import { ElCol as H } from "element-plus";
import { ElRow as I } from "element-plus";
import { vLoading as O } from "element-plus";
import { P as z } from "../../../modules/index-5b9e6004.js";
import { c as G } from "../../../modules/program-analysis-f1c6c876.js";
import { _ as K, o as M, x as U, z as J, K as Q, c1 as b, P as W, G as X } from "../../../shared/runtime.js";
import { h as p } from "../../../modules/operation-4e9312fe.js";
import Y from "./module/header.vue.js";
import Z from "./module/collect-and-invoice.vue.js";
import ee from "./module/product-status.vue.js";
import oe from "./module/project-execution-status.vue.js";
import te from "./module/project-feeding-status.vue.js";
import ae from "./module/project-cost-analysis.vue.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/collect-and-invoice-detail.vue.js";
import "../../../modules/use-chart-v2-ba3ec3fa.js";
import "../../../modules/index-18acf776.js";
import "./module/product-status-detail.vue.js";
import "./module/project-execution-status-detail.vue.js";
import "../../../modules/use-chart-59e4b63c.js";
import "./module/project-feeding-status-detail.vue.js";
import "./module/project-cost-analysis-detail.vue.js";
const se = { class: "app-container" }, re = { class: "content-wrap" }, ne = { class: "left-wrap" }, le = { class: "head-container" }, ie = { key: 1 }, ce = { class: "right-wrap" }, pe = { key: 0 }, de = { style: { display: "flex", width: "100%" } }, ue = { style: { display: "flex", width: "100%", "margin-top": "10px" } }, me = { key: 1, class: "red-tip" }, _e = { __name: "index", setup(fe) {
  const { maxHeight: m } = M({ extraBox: [".head-container"], paginate: true }), C = { add: false, edit: false, del: false, download: false }, v = y(), k = y(false), t = y({}), { crud: r, CRUD: E } = U({ title: "项目列表", sort: ["id.asc"], permission: { ...p }, optShow: { ...C }, crudApi: { ...G }, queryOnPresenterCreated: false, hasPagination: true }, v);
  T(() => r.query, (d) => {
    t.value = {};
  }, { deep: true }), E.HOOK.handleRefresh = (d, x) => {
    var l;
    (l = x.data.content) == null || l.forEach((i) => {
      i.project = { serialNumber: i.serialNumber, name: i.name, shortName: i.shortName };
    });
  };
  function D(d) {
    X(r.permission.projectDetail) && (t.value = d);
  }
  return (d, x) => {
    var g;
    const l = L, i = $, P = S("common-table"), A = F, _ = z, f = H, N = I, R = O;
    return c(), u("div", se, [a("div", re, [a("div", ne, [a("div", le, [e(Y)]), e(P, { ref_key: "tableRef", ref: v, data: o(r).data, "max-height": o(m), "highlight-current-row": "", style: { width: "100%", cursor: "pointer" }, onRowClick: D }, { default: s(() => [e(l, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(l, { "show-overflow-tooltip": true, prop: "project", label: "项目名称", align: "center", "min-width": "140" }, { default: s((n) => [a("span", null, h(o(J)(n.row.project)), 1)]), _: 1 }), e(l, { "show-overflow-tooltip": true, prop: "projectType", label: "项目类型", align: "center" }, { default: s(({ row: n }) => [a("span", null, h(n.projectType ? o(Q).VL[n.projectType] : "-"), 1)]), _: 1 }), e(l, { "show-overflow-tooltip": true, prop: "status", label: "状态", align: "center" }, { default: s(({ row: n }) => {
      var w;
      return [n.status ? (c(), j(i, { key: 0, effect: "plain", type: (w = o(b).V[n.status]) == null ? void 0 : w.TAG }, { default: s(() => [V(h(o(b).VL[n.status]), 1)]), _: 2 }, 1032, ["type"])) : (c(), u("span", ie, "-"))];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), e(o(W))]), e(A, { direction: "vertical", style: q(`height: ${o(m) + 130}px; margin: 0px 10px`) }, null, 8, ["style"]), a("div", ce, [(g = t.value) != null && g.id ? (c(), u("div", pe, [B((c(), j(N, { gutter: 24, class: "panel-group" }, { default: s(() => [e(f, { span: 8, class: "card-panel-col" }, { default: s(() => [e(_, { name: "工期（天）", "text-color": "#626262", "num-color": "#337ECC", "end-val": t.value.allDays || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(f, { span: 8, class: "card-panel-col" }, { default: s(() => [e(_, { name: "已用时（天）", "text-color": "#626262", "num-color": "#F56C6C", "end-val": t.value.alreadyDays || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(f, { span: 8, class: "card-panel-col" }, { default: s(() => [e(_, { name: "剩余时间（天）", "text-color": "#626262", "num-color": "#67C23A", "end-val": t.value.allDays - t.value.alreadyDays || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[R, k.value]]), a("div", { style: q(`height: ${o(m) + 80}px; overflow: auto`) }, [a("div", de, [e(Z, { style: { flex: "1" }, query: o(r).query, "project-info": t.value, permission: o(p) }, null, 8, ["query", "project-info", "permission"]), e(ee, { style: { flex: "1" }, query: o(r).query, "project-info": t.value, permission: o(p) }, null, 8, ["query", "project-info", "permission"])]), e(oe, { query: o(r).query, "project-info": t.value, permission: o(p) }, null, 8, ["query", "project-info", "permission"]), e(te, { query: o(r).query, "project-info": t.value, permission: o(p) }, null, 8, ["query", "project-info", "permission"]), a("div", ue, [e(ae, { style: { flex: "1" }, query: o(r).query, "project-info": t.value, permission: o(p) }, null, 8, ["query", "project-info", "permission"])])], 4)])) : (c(), u("div", me, "*点击左侧行数据查看详情"))])])]);
  };
} }, Le = K(_e, [["__scopeId", "data-v-145dda4b"]]);
export {
  Le as default
};
