import { ref as f } from "vue";
import { provide as P } from "vue";
import { reactive as M } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as U } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as r } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as m } from "vue";
import { createTextVNode as V } from "vue";
import { ElTableColumn as B } from "element-plus";
import { ElProgress as H } from "element-plus";
import { vLoading as T } from "element-plus";
import { c as $, _ as q } from "./module/detail.vue.js";
import { x as j, r_ as b, o as A, bs as F, c as x, D as k, G as W } from "../../../../shared/runtime.js";
import { _ as z } from "../../../../modules/index-3b2628f3.js";
import G from "./module/header.vue.js";
import "../../../../modules/index-490fd9d7.js";
import "../../../../modules/factory-select-b8d0a4ac.js";
const I = { class: "app-container" }, K = { class: "head-container" }, le = { __name: "index", setup(J) {
  const v = [{ color: "#f56c6c", percentage: 30 }, { color: "#e6a23c", percentage: 70 }, { color: "#6f7ad3", percentage: 100 }], y = { add: false, edit: false, del: false, download: false }, h = f(), { crud: i, columns: c, CRUD: L } = j({ title: "围护班组进度", permission: { ...b }, optShow: { ...y }, crudApi: { ...$ }, hasPagination: false, dataPath: "" }, h), { maxHeight: C } = A({ paginate: false });
  P("query", i.query), L.HOOK.handleRefresh = (u, a) => {
    a.data = a.data.map((t) => (t.completeRate = Number(F(t.completeLength / t.taskLength * 100, 2)), t));
  };
  let p = M({});
  const d = f(false);
  function R(u) {
    d.value = true, p = Object.assign(p, u);
  }
  return (u, a) => {
    const t = B, E = H, S = g("common-button"), D = g("common-table"), N = T;
    return l(), U("div", I, [_("div", K, [n(e(G))]), O((l(), r(D, { ref_key: "tableRef", ref: h, data: e(i).data, "empty-text": e(i).emptyText, "max-height": e(C), "row-key": "id", style: { width: "100%" }, onSelectionChange: e(i).selectionChangeHandler }, { default: s(() => [n(t, { type: "selection", width: "55", align: "center" }), n(t, { label: "序号", type: "index", align: "center", width: "60" }), n(e(z), { columns: e(c), showFactory: "", showWorkshop: "", showProductionLine: "", fixedWidth: "" }, null, 8, ["columns"]), e(c).visible("taskLength") ? (l(), r(t, { key: "taskLength", prop: "taskLength", "show-overflow-tooltip": true, label: "任务量(m)", align: "center", "min-width": "140px" }, { default: s((o) => [_("span", null, w(e(x)(o.row.taskLength, "mm", "m", e(k).MES_ENCLOSURE_L__M)), 1)]), _: 1 })) : m("", true), e(c).visible("completeLength") ? (l(), r(t, { key: "completeLength", prop: "completeLength", "show-overflow-tooltip": true, label: "完成量(m)", align: "center", "min-width": "140px" }, { default: s((o) => [_("span", null, w(e(x)(o.row.completeLength, "mm", "m", e(k).MES_ENCLOSURE_L__M)), 1)]), _: 1 })) : m("", true), e(c).visible("completeRate") ? (l(), r(t, { key: "completeRate", prop: "completeRate", "show-overflow-tooltip": true, label: "完成状态", "min-width": "250px" }, { default: s((o) => [n(E, { "text-inside": true, "stroke-width": 20, percentage: o.row.completeRate, color: v }, null, 8, ["percentage"])]), _: 1 })) : m("", true), e(W)(e(b).detail) ? (l(), r(t, { key: 3, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: s((o) => [n(S, { type: "primary", size: "default", onClick: (Q) => R(o.row) }, { default: s(() => a[1] || (a[1] = [V("查看")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[N, e(i).loading]]), n(e(q), { visible: d.value, "onUpdate:visible": a[0] || (a[0] = (o) => d.value = o), info: e(p) }, null, 8, ["visible", "info"])]);
  };
} };
export {
  le as default
};
