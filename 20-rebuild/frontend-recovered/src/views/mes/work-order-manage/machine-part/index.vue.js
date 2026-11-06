import { ref as w } from "vue";
import { provide as V } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as d } from "vue";
import { unref as t } from "vue";
import { createBlock as a } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as D } from "vue";
import { withDirectives as L } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as n } from "vue";
import { ElTag as B } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { vLoading as U } from "element-plus";
import { c as A } from "../../../../modules/machine-part-85f162b2.js";
import { _ as M, x as S, sh as b, o as $, p as R, G as j, cn as q, P as z } from "../../../../shared/runtime.js";
import K from "../components/header.vue.js";
import F from "./module/cutting-detail.vue.js";
import J from "./module/part-project-list.vue.js";
import "../../../../modules/print-e379c493.js";
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
  const W = { add: false, edit: false, del: false, download: false }, g = w(), k = w({}), f = w(false), { crud: l, CRUD: P, columns: p } = S({ title: "零件工单", sort: [], permission: { ...b }, optShow: { ...W }, crudApi: { ...A }, invisibleColumns: ["taskGrossWeight"], requiredQuery: ["processType", "areaIds"], hasPagination: true }, g);
  V("permission", b);
  const { maxHeight: v } = $();
  function G(h) {
    f.value = true, k.value = h;
  }
  function I({ areaIds: h, projectIds: u, monomerIds: m }) {
    l.query.processType = q.CUTTING_ORDER.V, l.query.projectIds = u, l.query.monomerIds = m, l.query.areaIds = h, l.toQuery();
  }
  return P.HOOK.handleRefresh = (h, u) => {
    u.data.content = u.data.content.map((m) => (m.boolPrinted = !!m.printQuantity, m));
  }, (h, u) => {
    var N, x;
    const m = B, s = H, T = y("table-cell-tag"), Q = y("common-button"), E = y("common-table"), O = U;
    return o(), C("div", X, [i("div", Y, [d(J, { maxHeight: t(v) - 40, onNestingTaskClick: I }, null, 8, ["maxHeight"])]), i("div", Z, [(x = (N = t(l).query) == null ? void 0 : N.areaIds) != null && x.length ? (o(), C("div", ee, [i("div", te, [d(K)]), L((o(), a(E, { ref_key: "tableRef", ref: g, data: t(l).data, "empty-text": t(l).emptyText, "max-height": t(v) - 130, style: { width: "100%" } }, { default: r(() => [d(s, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(p).visible("scheduleTime") ? (o(), a(s, { align: "center", key: "scheduleTime", prop: "scheduleTime", "show-overflow-tooltip": true, label: "排产日期" }, { default: r((e) => [d(T, { show: e.row.boolOffLine, name: "线下套料", color: "#E6A23C" }, null, 8, ["show"]), i("span", null, c(e.row.scheduleTime ? t(R)(e.row.scheduleTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : n("", true), t(p).visible("cutNumber") ? (o(), a(s, { "header-align": "center", key: "cutNumber", prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", width: "220px" }, { default: r((e) => [d(T, { show: e.row.boolPrinted, color: "#e64242", name: "已打印", offset: 15 }, null, 8, ["show"]), i("span", null, c(e.row.cutNumber), 1)]), _: 1 })) : n("", true), t(p).visible("userName") ? (o(), a(s, { align: "center", key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "排产人" }, { default: r((e) => [i("span", null, c(e.row.userName), 1)]), _: 1 })) : n("", true), t(p).visible("cutTypeName") ? (o(), a(s, { align: "center", key: "cutTypeName", prop: "cutTypeName", "show-overflow-tooltip": true, label: "下料方式" }, { default: r((e) => [i("span", null, c(e.row.cutTypeName), 1)]), _: 1 })) : n("", true), t(p).visible("workshop") ? (o(), a(s, { align: "center", key: "workshop.name", prop: "workshop.name", "show-overflow-tooltip": true, label: "车间" }, { default: r((e) => {
      var _;
      return [i("span", null, c((_ = e.row.workshop) == null ? void 0 : _.name), 1)];
    }), _: 1 })) : n("", true), t(p).visible("productionLine") ? (o(), a(s, { align: "center", key: "productionLine.name", prop: "productionLine.name", "show-overflow-tooltip": true, label: "生产线" }, { default: r((e) => {
      var _;
      return [i("span", null, c((_ = e.row.productionLine) == null ? void 0 : _.name), 1)];
    }), _: 1 })) : n("", true), t(p).visible("taskQuantity") ? (o(), a(s, { align: "center", key: "taskQuantity", prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务数（件）" }, { default: r((e) => [i("span", null, c(e.row.taskQuantity), 1)]), _: 1 })) : n("", true), t(p).visible("taskNetWeight") ? (o(), a(s, { align: "center", key: "taskNetWeight", prop: "taskNetWeight", "show-overflow-tooltip": true, label: "总净重（kg）" }, { default: r((e) => [i("span", null, c(e.row.taskNetWeight), 1)]), _: 1 })) : n("", true), t(p).visible("taskGrossWeight") ? (o(), a(s, { align: "center", key: "taskGrossWeight", prop: "taskGrossWeight", "show-overflow-tooltip": true, label: "总毛重（kg）" }, { default: r((e) => [i("span", null, c(e.row.taskGrossWeight), 1)]), _: 1 })) : n("", true), t(p).visible("completeTime") ? (o(), a(s, { align: "center", key: "completeTime", prop: "completeTime", "show-overflow-tooltip": true, label: "计划完成日期" }, { default: r((e) => [i("span", null, c(e.row.completeTime ? t(R)(e.row.completeTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : n("", true), t(j)([...t(b).detail]) ? (o(), a(s, { key: 10, align: "center", "show-overflow-tooltip": true, label: "操作", width: "100" }, { default: r((e) => [t(l).query.processType === t(q).CUTTING_ORDER.V ? (o(), a(Q, { key: 0, type: "primary", size: "default", onClick: (_) => G(e.row) }, { default: r(() => u[2] || (u[2] = [D("查看")])), _: 2, __: [2] }, 1032, ["onClick"])) : n("", true)]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[O, t(l).loading]]), d(t(z))])) : (o(), a(m, { key: 0, type: "info", size: "large" }, { default: r(() => u[1] || (u[1] = [D(" * 请点击左侧项目列表查看详情 ")])), _: 1, __: [1] })), d(F, { "process-type": t(l).query.processType, visible: f.value, "onUpdate:visible": u[0] || (u[0] = (e) => f.value = e), "cutting-detail-data": k.value, serialNumber: t(l).query.serialNumber, onRefresh: t(l).toQuery }, null, 8, ["process-type", "visible", "cutting-detail-data", "serialNumber", "onRefresh"])])]);
  };
} }, Te = M(oe, [["__scopeId", "data-v-f8fbcedb"]]);
export {
  Te as default
};
