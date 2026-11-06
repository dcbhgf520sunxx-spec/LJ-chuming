import { useRoute as U } from "vue-router";
import { ref as y } from "vue";
import { reactive as F } from "vue";
import { provide as I } from "vue";
import { watch as L } from "vue";
import { resolveComponent as Q } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as m } from "vue";
import { withDirectives as q } from "vue";
import { unref as t } from "vue";
import { createBlock as i } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as j } from "vue";
import { withModifiers as C } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as f } from "vue";
import { ElTableColumn as W } from "element-plus";
import { ElProgress as z } from "element-plus";
import { ElTag as Y } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as J, g as X } from "../../../modules/kanban-603b7875.js";
import { x as Z, pY as g, o as ee, mD as D, P as te } from "../../../shared/runtime.js";
import oe from "./module/header.vue.js";
import ae from "./module/kanban-detail.vue.js";
import re from "./module/group-status-drawer.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/group-status-detail.vue.js";
const se = { class: "app-container" }, ne = { class: "head-container" }, ie = ["onClick"], ge = { __name: "index", setup(le) {
  const V = { add: false, edit: false, del: false, download: false }, N = U(), v = y(), _ = y(false), h = y(false), b = y({}), { crud: o, CRUD: k, columns: p } = Z({ title: "生产监控看板", sort: [], optShow: { ...V }, permission: { ...g }, crudApi: { ...J }, requiredQuery: ["workshopId"], hasPagination: true }, v), { maxHeight: R } = ee({ extraBox: [".head-container", ".btn"], paginate: true });
  function T(a) {
    _.value = true, b.value = a;
  }
  const w = F({ summary: {}, loading: true });
  I("projectInfo", w), I("permission", g), k.HOOK.beforeToQuery = () => {
    var a;
    o.query.areaId = (a = N.params) == null ? void 0 : a.areaId;
  }, L([() => o.query.workshopId, () => o.query.areaId], (a) => {
    a && (B(), o.toQuery());
  });
  function P() {
    h.value = true;
  }
  async function B() {
    w.loading = true;
    try {
      const a = await X({ workshopId: o.query.workshopId, areaId: o.query.areaId ? o.query.areaId : void 0 }) || {};
      w.summary = a;
    } catch (a) {
      console.log("获取项目汇总图表数据", a);
    } finally {
      w.loading = false;
    }
  }
  return k.HOOK.handleRefresh = (a, { data: d }) => {
  }, (a, d) => {
    const E = Q("common-button"), u = W, H = z, K = Y, M = Q("common-table"), O = $("permission"), S = G;
    return r(), A("div", se, [c("div", ne, [m(oe)]), c("div", null, [q((r(), i(E, { class: "btn", size: "default", type: "warning", style: { float: "right", "margin-bottom": "8px" }, onClick: C(P, ["stop"]) }, { default: s(() => d[2] || (d[2] = [j(" 班组状态 ")])), _: 1, __: [2] })), [[O, t(g).status]]), q((r(), i(M, { ref_key: "tableRef", ref: v, data: t(o).data, "empty-text": t(o).emptyText, "max-height": t(R), "show-empty-symbol": false, "row-key": "projectId", style: { width: "100%" } }, { default: s(() => [m(u, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(p).visible("project") ? (r(), i(u, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", width: "200px" }, { default: s((e) => {
      var n, x;
      return [c("span", null, l((n = e.row.project) == null ? void 0 : n.contractNo) + "-" + l((x = e.row.project) == null ? void 0 : x.name), 1)];
    }), _: 1 })) : f("", true), t(p).visible("monomer.name") ? (r(), i(u, { key: "monomer.name", prop: "monomer.name", align: "center", "show-overflow-tooltip": true, label: "单体" }, { default: s((e) => {
      var n;
      return [c("span", null, l(e.row.monomer ? (n = e.row.monomer) == null ? void 0 : n.name : "/"), 1)];
    }), _: 1 })) : f("", true), t(p).visible("area.name") ? (r(), i(u, { key: "area.name", prop: "area.name", align: "center", "show-overflow-tooltip": true, label: "区域" }, { default: s((e) => {
      var n;
      return [c("span", null, l(e.row.area ? (n = e.row.area) == null ? void 0 : n.name : "/"), 1)];
    }), _: 1 })) : f("", true), t(p).visible("taskQuantity") ? (r(), i(u, { align: "center", key: "taskQuantity", prop: "taskQuantity", "show-overflow-tooltip": true, label: "排产量（件/吨）" }, { default: s((e) => [c("span", null, l(e.row.taskQuantity) + "/" + l((e.row.taskNetWeight / 1e3).toFixed(2)), 1)]), _: 1 })) : f("", true), t(p).visible("completeQuantity") ? (r(), i(u, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "实际完成量（件/吨）" }, { default: s((e) => [c("span", { onClick: C((n) => T(e.row), ["stop"]), style: { color: "#409eff", cursor: "pointer" } }, l(e.row.completeQuantity) + "/" + l((e.row.completeNetWeight / 1e3).toFixed(2)), 9, ie)]), _: 1 })) : f("", true), t(p).visible("rate") ? (r(), i(u, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "达成率", "min-width": "180px" }, { default: s((e) => [m(H, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: (e.row.completeQuantity / e.row.taskQuantity * 100).toFixed(2), status: "success" }, null, 8, ["percentage"])]), _: 1 })) : f("", true), t(p).visible("status") ? (r(), i(u, { align: "center", key: "status", prop: "status", "show-overflow-tooltip": true, label: "状态", width: "80px" }, { default: s((e) => [m(K, { effect: "plain", type: t(D).V[e.row.status].T }, { default: s(() => [j(l(t(D).VL[e.row.status]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[S, t(o).loading]]), m(t(te))]), m(ae, { visible: _.value, "onUpdate:visible": d[0] || (d[0] = (e) => _.value = e), "detail-list": b.value, workshopId: t(o).query.workshopId }, null, 8, ["visible", "detail-list", "workshopId"]), m(re, { visible: h.value, "onUpdate:visible": d[1] || (d[1] = (e) => h.value = e), areaId: t(o).query.areaId, workshopId: t(o).query.workshopId, "group-detail-data": t(o).data[0] }, null, 8, ["visible", "areaId", "workshopId", "group-detail-data"])]);
  };
} };
export {
  ge as default
};
