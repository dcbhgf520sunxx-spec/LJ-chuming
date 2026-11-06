import { ref as h } from "vue";
import { reactive as F } from "vue";
import { provide as x } from "vue";
import { watch as H } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as M } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as d } from "vue";
import { withCtx as a } from "vue";
import { withDirectives as Q } from "vue";
import { createBlock as n } from "vue";
import { withModifiers as N } from "vue";
import { createTextVNode as j } from "vue";
import { unref as t } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as f } from "vue";
import { ElTableColumn as $ } from "element-plus";
import { ElProgress as K } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as z } from "element-plus";
import { c as G, g as J } from "../../../../modules/kanban-603b7875.js";
import { x as X, rQ as _, o as Y, mD as C, P as Z } from "../../../../shared/runtime.js";
import ee from "./module/header.vue.js";
import te from "./module/kanban-detail.vue.js";
import oe from "./module/group-status-drawer.vue.js";
import "./module/panel.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/group-report-de628baf.js";
import "./module/group-status-detail.vue.js";
const ae = { class: "app-container" }, re = { class: "head-container" }, ie = ["onClick"], ye = { __name: "index", setup(se) {
  const D = { add: false, edit: false, del: false, download: false }, v = h(), g = h(false), y = h(false), k = h({}), { crud: i, CRUD: V, columns: u } = X({ title: "生产监控看板", sort: [], optShow: { ...D }, permission: { ..._ }, crudApi: { ...G }, requiredQuery: ["workshopId"], hasPagination: true }, v), { maxHeight: W } = Y({ extraBox: [".head-container", ".head-content"], paginate: true });
  function q(o) {
    g.value = true, k.value = o;
  }
  const w = F({ summary: {}, loading: true });
  x("projectInfo", w), x("permission", _), H(() => i.query.workshopId, (o) => {
    o && (T(), i.toQuery());
  });
  function R() {
    y.value = true;
  }
  async function T() {
    w.loading = true;
    try {
      const o = await J({ workshopId: i.query.workshopId }) || {};
      w.summary = o, w.summary = { ...o, totalWeight: [{ taskNetWeight: o.taskNetWeight / 1e3, precision: 2 }, { taskNetWeight: o.yearAvgNetWeight / 1e3, precision: 2 }] };
    } catch (o) {
      console.log("获取项目汇总图表数据", o);
    } finally {
      w.loading = false;
    }
  }
  return V.HOOK.handleRefresh = (o, { data: m }) => {
  }, (o, m) => {
    const P = I("common-button"), p = $, S = K, B = O, E = I("common-table"), U = L("permission"), A = z;
    return r(), M("div", ae, [c("div", re, [d(ee, { ref: "headerRef" }, { btn: a(() => [Q((r(), n(P, { class: "filter-item", size: "default", type: "warning", style: { float: "right" }, onClick: N(R, ["stop"]) }, { default: a(() => m[2] || (m[2] = [j(" 班组状态 ")])), _: 1, __: [2] })), [[U, t(_).groupStatus]])]), _: 1 }, 512)]), c("div", null, [Q((r(), n(E, { ref_key: "tableRef", ref: v, data: t(i).data, "empty-text": t(i).emptyText, "max-height": t(W), "show-empty-symbol": false, "row-key": "projectId", style: { width: "100%" } }, { default: a(() => [d(p, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(u).visible("project") ? (r(), n(p, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", width: "200px" }, { default: a((e) => {
      var s, b;
      return [c("span", null, l((s = e.row.project) == null ? void 0 : s.contractNo) + "-" + l((b = e.row.project) == null ? void 0 : b.name), 1)];
    }), _: 1 })) : f("", true), t(u).visible("monomer.name") ? (r(), n(p, { key: "monomer.name", prop: "monomer.name", align: "center", "show-overflow-tooltip": true, label: "单体" }, { default: a((e) => {
      var s;
      return [c("span", null, l(e.row.monomer ? (s = e.row.monomer) == null ? void 0 : s.name : "/"), 1)];
    }), _: 1 })) : f("", true), t(u).visible("area.name") ? (r(), n(p, { key: "area.name", prop: "area.name", align: "center", "show-overflow-tooltip": true, label: "区域" }, { default: a((e) => {
      var s;
      return [c("span", null, l(e.row.area ? (s = e.row.area) == null ? void 0 : s.name : "/"), 1)];
    }), _: 1 })) : f("", true), t(u).visible("taskQuantity") ? (r(), n(p, { align: "center", key: "taskQuantity", prop: "taskQuantity", "show-overflow-tooltip": true, label: "排产量（件/吨）" }, { default: a((e) => [c("span", null, l(e.row.taskQuantity) + "/" + l((e.row.taskNetWeight / 1e3).toFixed(2)), 1)]), _: 1 })) : f("", true), t(u).visible("completeQuantity") ? (r(), n(p, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "实际完成量（件/吨）" }, { default: a((e) => [c("span", { onClick: N((s) => q(e.row), ["stop"]), style: { color: "#409eff", cursor: "pointer" } }, l(e.row.completeQuantity) + "/" + l((e.row.completeNetWeight / 1e3).toFixed(2)), 9, ie)]), _: 1 })) : f("", true), t(u).visible("rate") ? (r(), n(p, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "达成率", "min-width": "180px" }, { default: a((e) => [d(S, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: Number((e.row.completeQuantity / e.row.taskQuantity * 100).toFixed(2)), status: "success" }, null, 8, ["percentage"])]), _: 1 })) : f("", true), t(u).visible("status") ? (r(), n(p, { align: "center", key: "status", prop: "status", "show-overflow-tooltip": true, label: "状态", width: "85px" }, { default: a((e) => [d(B, { effect: "plain", type: t(C).V[e.row.status].T }, { default: a(() => [j(l(t(C).VL[e.row.status]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[A, t(i).loading]]), d(t(Z))]), d(te, { visible: g.value, "onUpdate:visible": m[0] || (m[0] = (e) => g.value = e), "detail-list": k.value, workshopId: t(i).query.workshopId }, null, 8, ["visible", "detail-list", "workshopId"]), d(oe, { visible: y.value, "onUpdate:visible": m[1] || (m[1] = (e) => y.value = e), workshopId: t(i).query.workshopId, "group-detail-data": t(i).data[0] }, null, 8, ["visible", "workshopId", "group-detail-data"])]);
  };
} };
export {
  ye as default
};
