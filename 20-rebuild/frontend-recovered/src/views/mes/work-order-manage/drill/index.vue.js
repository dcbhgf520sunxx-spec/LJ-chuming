import { ref as w } from "vue";
import { provide as C } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as c } from "vue";
import { unref as t } from "vue";
import { createBlock as r } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as D } from "vue";
import { withDirectives as G } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as n } from "vue";
import { ElTag as B } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { vLoading as $ } from "element-plus";
import { c as A } from "../../../../modules/machine-part-85f162b2.js";
import { _ as M, x as S, sg as y, o as U, p as q, G as j, cn as L, P as z } from "../../../../shared/runtime.js";
import K from "../components/header.vue.js";
import F from "./module/detail.vue.js";
import J from "./module/drill-project-list.vue.js";
import "../../../../modules/index-069ba252.js";
import "../../../../modules/index-90569c81.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
import "../../../../modules/index-3b2e6e51.js";
import "../../../../modules/use-default-table-template-4b5e02c6.js";
import "../../../../modules/use-get-separate-order-0ba48739.js";
import "../components/separate-order-table.vue.js";
import "../components/production-task-order.vue.js";
import "../components/project-to-area-tree.vue.js";
const X = { class: "app-container wrap" }, Y = { class: "wrap-left" }, Z = { class: "wrap-right" }, ee = { key: 1 }, te = { class: "wrap-head" }, oe = { __name: "index", setup(ae) {
  const W = { add: false, edit: false, del: false, download: false }, g = w(), k = w({}), h = w(false), { crud: a, CRUD: I, columns: u } = S({ title: "钻孔工单", sort: [], permission: { ...y }, optShow: { ...W }, crudApi: { ...A }, invisibleColumns: ["taskGrossWeight"], requiredQuery: ["processType", "areaIds"], hasPagination: true }, g);
  C("crud", a), C("permission", y);
  const { maxHeight: v } = U();
  function P(f) {
    h.value = true, k.value = f;
  }
  function Q({ projectIds: f, monomerIds: p, areaIds: d }) {
    a.query.processType = L.DRILL_ORDER.V, a.query.projectIds = f, a.query.monomerIds = p, a.query.areaIds = d, a.toQuery();
  }
  return I.HOOK.handleRefresh = (f, p) => {
    p.data.content = p.data.content.map((d) => (d.boolPrinted = !!d.printQuantity, d));
  }, (f, p) => {
    var x, N;
    const d = B, i = H, T = b("table-cell-tag"), E = b("common-button"), O = b("common-table"), V = $;
    return o(), R("div", X, [s("div", Y, [c(J, { maxHeight: t(v) - 40, onNestingTaskClick: Q }, null, 8, ["maxHeight"])]), s("div", Z, [(N = (x = t(a).query) == null ? void 0 : x.areaIds) != null && N.length ? (o(), R("div", ee, [s("div", te, [c(K)]), G((o(), r(O, { ref_key: "tableRef", ref: g, data: t(a).data, "empty-text": t(a).emptyText, "max-height": t(v) - 130, style: { width: "100%" } }, { default: l(() => [c(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(u).visible("scheduleTime") ? (o(), r(i, { align: "center", key: "scheduleTime", prop: "scheduleTime", "show-overflow-tooltip": true, label: "排产日期" }, { default: l((e) => [c(T, { show: e.row.boolOffLine, name: "线下套料", color: "#E6A23C" }, null, 8, ["show"]), s("span", null, m(e.row.scheduleTime ? t(q)(e.row.scheduleTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : n("", true), t(u).visible("cutNumber") ? (o(), r(i, { "header-align": "center", key: "cutNumber", prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", width: "220px" }, { default: l((e) => [c(T, { show: e.row.boolPrinted, color: "#e64242", name: "已打印", offset: 15 }, null, 8, ["show"]), s("span", null, m(e.row.cutNumber), 1)]), _: 1 })) : n("", true), t(u).visible("userName") ? (o(), r(i, { align: "center", key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "排产人" }, { default: l((e) => [s("span", null, m(e.row.userName), 1)]), _: 1 })) : n("", true), t(u).visible("config") ? (o(), r(i, { align: "center", key: "config.name", prop: "config.name", "show-overflow-tooltip": true, label: "下料方式" }, { default: l((e) => [s("span", null, m(e.row.cutTypeName), 1)]), _: 1 })) : n("", true), t(u).visible("workshop") ? (o(), r(i, { align: "center", key: "workshop.name", prop: "workshop.name", "show-overflow-tooltip": true, label: "车间" }, { default: l((e) => {
      var _;
      return [s("span", null, m((_ = e.row.workshop) == null ? void 0 : _.name), 1)];
    }), _: 1 })) : n("", true), t(u).visible("productionLine") ? (o(), r(i, { align: "center", key: "productionLine.name", prop: "productionLine.name", "show-overflow-tooltip": true, label: "生产线" }, { default: l((e) => {
      var _;
      return [s("span", null, m((_ = e.row.productionLine) == null ? void 0 : _.name), 1)];
    }), _: 1 })) : n("", true), t(u).visible("taskQuantity") ? (o(), r(i, { align: "center", key: "taskQuantity", prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务数（件）" }, { default: l((e) => [s("span", null, m(e.row.taskQuantity), 1)]), _: 1 })) : n("", true), t(u).visible("taskNetWeight") ? (o(), r(i, { align: "center", key: "taskNetWeight", prop: "taskNetWeight", "show-overflow-tooltip": true, label: "总净重（kg）" }, { default: l((e) => [s("span", null, m(e.row.taskNetWeight), 1)]), _: 1 })) : n("", true), t(u).visible("taskGrossWeight") ? (o(), r(i, { align: "center", key: "taskGrossWeight", prop: "taskGrossWeight", "show-overflow-tooltip": true, label: "总毛重（kg）" }, { default: l((e) => [s("span", null, m(e.row.taskGrossWeight), 1)]), _: 1 })) : n("", true), t(u).visible("completeTime") ? (o(), r(i, { align: "center", key: "completeTime", prop: "completeTime", "show-overflow-tooltip": true, label: "计划完成日期" }, { default: l((e) => [s("span", null, m(e.row.completeTime ? t(q)(e.row.completeTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : n("", true), t(j)([...t(y).detail]) ? (o(), r(i, { key: 10, align: "center", "show-overflow-tooltip": true, label: "操作", width: "100" }, { default: l((e) => [t(a).query.processType === t(L).DRILL_ORDER.V ? (o(), r(E, { key: 0, type: "primary", size: "default", onClick: (_) => P(e.row) }, { default: l(() => p[2] || (p[2] = [D("查看")])), _: 2, __: [2] }, 1032, ["onClick"])) : n("", true)]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[V, t(a).loading]]), c(t(z))])) : (o(), r(d, { key: 0, type: "info", size: "large" }, { default: l(() => p[1] || (p[1] = [D(" * 请点击左侧项目列表查看详情 ")])), _: 1, __: [1] })), c(F, { visible: h.value, "onUpdate:visible": p[0] || (p[0] = (e) => h.value = e), "process-type": t(a).query.processType, "detail-data": k.value, serialNumber: t(a).query.serialNumber, onRefresh: t(a).toQuery }, null, 8, ["visible", "process-type", "detail-data", "serialNumber", "onRefresh"])])]);
  };
} }, ve = M(oe, [["__scopeId", "data-v-6d68bbdd"]]);
export {
  ve as default
};
