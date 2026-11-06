import { ref as w } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as f } from "vue";
import { withDirectives as M } from "vue";
import { unref as t } from "vue";
import { createBlock as l } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as p } from "vue";
import { createTextVNode as T } from "vue";
import { ElTableColumn as O } from "element-plus";
import { vLoading as E } from "element-plus";
import { c as U } from "../../../../modules/use-get-separate-order-8068bd15.js";
import { x as $, o as H, p as x, G as S, cn as z, P as A } from "../../../../shared/runtime.js";
import { M as D } from "../../../../modules/bridge-86f96a4f.js";
import j from "./module/header.vue.js";
import G from "./module/detail.vue.js";
import I from "./module/cutting-detail.vue.js";
import "../../../../modules/index-069ba252.js";
import "../../../../modules/index-90569c81.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
import "../../../../modules/index-3b2e6e51.js";
import "./module/separate-order-table.vue.js";
import "./module/production-task-order.vue.js";
import "../../../../modules/print-e379c493.js";
const K = { class: "app-container" }, W = { class: "head-container" }, ce = { __name: "index", setup(F) {
  const C = { add: false, edit: false, del: false, download: false }, _ = w(), v = w({}), b = w(false), g = w({}), y = w(false), { crud: c, CRUD: N, columns: m } = $({ title: "零件工单", sort: [], permission: { ...D }, optShow: { ...C }, crudApi: { ...U }, requiredQuery: ["processType"], hasPagination: true }, _), { maxHeight: R } = H({ extraBox: [".head-container"], paginate: true });
  function P(d) {
    console.log(d, "row"), y.value = true, g.value = d;
  }
  function L(d) {
    b.value = true, v.value = d;
  }
  return N.HOOK.handleRefresh = (d, i) => {
    i.data.content = i.data.content.map((o) => (o.boolPrinted = !!o.printQuantity, o));
  }, (d, i) => {
    const o = O, Q = h("table-cell-tag"), k = h("common-button"), V = h("common-table"), B = E;
    return a(), q("div", K, [s("div", W, [f(j)]), M((a(), l(V, { ref_key: "tableRef", ref: _, data: t(c).data, "empty-text": t(c).emptyText, "max-height": t(R), style: { width: "100%" } }, { default: r(() => [f(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(m).visible("scheduleTime") ? (a(), l(o, { align: "center", key: "scheduleTime", prop: "scheduleTime", "show-overflow-tooltip": true, label: "排产日期" }, { default: r((e) => [s("span", null, u(e.row.scheduleTime ? t(x)(e.row.scheduleTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : p("", true), t(m).visible("cutNumber") ? (a(), l(o, { "header-align": "center", key: "cutNumber", prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", width: "220px" }, { default: r((e) => [f(Q, { show: e.row.boolPrinted, color: "#e64242", name: "已打印", offset: 15 }, null, 8, ["show"]), s("span", null, u(e.row.cutNumber), 1)]), _: 1 })) : p("", true), t(m).visible("userName") ? (a(), l(o, { align: "center", key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "排产人" }, { default: r((e) => [s("span", null, u(e.row.userName), 1)]), _: 1 })) : p("", true), t(m).visible("config") ? (a(), l(o, { align: "center", key: "config.name", prop: "config.name", "show-overflow-tooltip": true, label: "下料方式" }, { default: r((e) => {
      var n;
      return [s("span", null, u((n = e.row.config) == null ? void 0 : n.name), 1)];
    }), _: 1 })) : p("", true), t(m).visible("workshop") ? (a(), l(o, { align: "center", key: "workshop.name", prop: "workshop.name", "show-overflow-tooltip": true, label: "车间" }, { default: r((e) => {
      var n;
      return [s("span", null, u((n = e.row.workshop) == null ? void 0 : n.name), 1)];
    }), _: 1 })) : p("", true), t(m).visible("productionLine") ? (a(), l(o, { align: "center", key: "productionLine.name", prop: "productionLine.name", "show-overflow-tooltip": true, label: "生产线" }, { default: r((e) => {
      var n;
      return [s("span", null, u((n = e.row.productionLine) == null ? void 0 : n.name), 1)];
    }), _: 1 })) : p("", true), t(m).visible("taskQuantity") ? (a(), l(o, { align: "center", key: "taskQuantity", prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务量（件/kg）" }, { default: r((e) => [s("span", null, u(e.row.taskQuantity) + "/" + u(e.row.taskMete), 1)]), _: 1 })) : p("", true), t(m).visible("completeTime") ? (a(), l(o, { align: "center", key: "completeTime", prop: "completeTime", "show-overflow-tooltip": true, label: "完成日期" }, { default: r((e) => [s("span", null, u(e.row.completeTime ? t(x)(e.row.completeTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : p("", true), t(S)([...t(D).detail]) ? (a(), l(o, { key: 8, align: "center", "show-overflow-tooltip": true, label: "操作", width: "100" }, { default: r((e) => [t(c).query.processType === t(z).DRILL_ORDER.V ? (a(), l(k, { key: 0, type: "primary", size: "default", onClick: (n) => L(e.row) }, { default: r(() => i[2] || (i[2] = [T("查看")])), _: 2, __: [2] }, 1032, ["onClick"])) : (a(), l(k, { key: 1, type: "primary", size: "default", onClick: (n) => P(e.row) }, { default: r(() => i[3] || (i[3] = [T("查看")])), _: 2, __: [3] }, 1032, ["onClick"]))]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[B, t(c).loading]]), f(t(A)), f(G, { visible: b.value, "onUpdate:visible": i[0] || (i[0] = (e) => b.value = e), "process-type": t(c).query.processType, "detail-data": v.value }, null, 8, ["visible", "process-type", "detail-data"]), f(I, { "process-type": t(c).query.processType, visible: y.value, "onUpdate:visible": i[1] || (i[1] = (e) => y.value = e), "cutting-detail-data": g.value, onRefresh: t(c).toQuery }, null, 8, ["process-type", "visible", "cutting-detail-data", "onRefresh"])]);
  };
} };
export {
  ce as default
};
