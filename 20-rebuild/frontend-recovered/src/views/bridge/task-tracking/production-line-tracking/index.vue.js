import { ref as b } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as p } from "vue";
import { withDirectives as T } from "vue";
import { unref as t } from "vue";
import { createBlock as r } from "vue";
import { withCtx as a } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as d } from "vue";
import { createTextVNode as C } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElTag as O } from "element-plus";
import { ElProgress as H } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as S, _ as I } from "./production-line-tracking-detail/index.vue.js";
import { F as s, x as U, o as $, D as Q } from "../../../../shared/runtime.js";
import { J as V } from "../../../../modules/bridge-86f96a4f.js";
import j from "./module/header.vue.js";
const q = { class: "app-container" }, G = { class: "head-container" }, oe = { __name: "index", setup(W) {
  const D = { [s.BOX.K]: "success", [s.CELL.K]: "warning", [s.MACHINE_PART.K]: "" }, E = { add: false, edit: false, del: false, download: false }, v = b(), w = b(false), h = b({}), { crud: y, CRUD: L, columns: c } = U({ title: "产线跟踪", sort: [], optShow: { ...E }, permission: { ...V }, crudApi: { ...S }, hasPagination: true }, v), { maxHeight: M } = $({ extraBox: [".head-container"], paginate: true });
  function R(k) {
    w.value = true, h.value = k;
  }
  return L.HOOK.handleRefresh = (k, { data: n }) => {
    var m;
    const o = [];
    for (const u in n) {
      const g = u === "boxList" ? s.BOX.V : u === "elementList" ? s.CELL.V : s.MACHINE_PART.V;
      (m = n[u]) == null || m.map((_) => {
        _.productType = g, o.push(_);
      });
    }
    n.content = o;
  }, (k, n) => {
    const o = A, m = O, u = H, g = x("common-button"), _ = x("common-table"), B = N("permission"), K = F;
    return i(), P("div", q, [f("div", G, [p(j)]), T((i(), r(_, { ref_key: "tableRef", ref: v, data: t(y).data, "empty-text": t(y).emptyText, "max-height": t(M), "row-key": "projectId", style: { width: "100%" } }, { default: a(() => [p(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(c).visible("name") ? (i(), r(o, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "产线" }, { default: a((e) => [f("span", null, l(e.row.workShopName) + ">" + l(e.row.name), 1)]), _: 1 })) : d("", true), t(c).visible("taskType") ? (i(), r(o, { align: "center", key: "taskType", prop: "taskType", "show-overflow-tooltip": true, label: "类别", width: "80px" }, { default: a((e) => [p(m, { effect: "plain", type: D[t(s).VK[e.row.taskType]] }, { default: a(() => [C(l(t(s).VL[e.row.taskType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : d("", true), t(c).visible("taskQuantity") ? (i(), r(o, { align: "center", key: "taskQuantity", prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务量（件/kg）" }, { default: a((e) => [f("span", null, l(e.row.taskQuantity) + "/" + l(e.row.taskMete.toFixed(t(Q).COM_WT__KG)), 1)]), _: 1 })) : d("", true), t(c).visible("completeQuantity") ? (i(), r(o, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成量（件/kg）" }, { default: a((e) => [f("span", null, l(e.row.completeQuantity) + "/" + l(e.row.completeMete.toFixed(t(Q).COM_WT__KG)), 1)]), _: 1 })) : d("", true), t(c).visible("rate") ? (i(), r(o, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "完成率", "min-width": "180px" }, { default: a((e) => [p(u, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: (e.row.completeQuantity / e.row.taskQuantity * 100).toFixed(2), status: "success" }, null, 8, ["percentage"])]), _: 1 })) : d("", true), T((i(), r(o, { align: "center", "show-overflow-tooltip": true, label: "操作", width: "100px" }, { default: a((e) => [p(g, { type: "primary", size: "default", onClick: (X) => R(e.row) }, { default: a(() => n[1] || (n[1] = [C("查看")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })), [[B, t(V).detail]])]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[K, t(y).loading]]), p(I, { visible: w.value, "onUpdate:visible": n[0] || (n[0] = (e) => w.value = e), "detail-data": h.value }, null, 8, ["visible", "detail-data"])]);
  };
} };
export {
  oe as default
};
