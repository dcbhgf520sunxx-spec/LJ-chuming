import { ref as _ } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as c } from "vue";
import { withDirectives as j } from "vue";
import { unref as e } from "vue";
import { createBlock as i } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as n } from "vue";
import { createTextVNode as q } from "vue";
import { toDisplayString as u } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as B } from "element-plus";
import { c as P, _ as V } from "./module/detail.vue.js";
import { x as L, nF as h, o as T, z as E, G as F, P as H } from "../../../../shared/runtime.js";
import S from "./module/header.vue.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
const U = { class: "app-container" }, $ = { class: "head-container" }, z = { style: { color: "#67c23a" } }, A = { style: { color: "#f56c6c" } }, M = { style: { color: "#f56c6c" } }, ee = { __name: "index", setup(O) {
  const g = { add: false, edit: false, del: false, download: false }, w = _(), d = _(false), b = _({}), { crud: f, CRUD: k, columns: l } = L({ title: "滞后统计", sort: [], optShow: { ...g }, permission: { permission: h }, crudApi: { ...P }, hasPagination: true }, w), { maxHeight: x } = T({ extraBox: [".head-container"], paginate: true });
  function Q(y) {
    d.value = true, b.value = y;
  }
  return k.HOOK.handleRefresh = (y, { data: p }) => {
    var t;
    (t = p.content) == null || t.forEach((r) => {
      r.completeRate = r.completeQuantity && r.quantity ? (r.completeQuantity / r.quantity * 100).toFixed(2) + "%" : "0%";
    });
  }, (y, p) => {
    const t = N, r = v("common-button"), R = v("common-table"), C = B;
    return o(), D("div", U, [m("div", $, [c(S)]), j((o(), i(R, { ref_key: "tableRef", ref: w, data: e(f).data, "empty-text": e(f).emptyText, "max-height": e(x), "row-key": "id", style: { width: "100%" } }, { default: s(() => [c(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(l).visible("workshop.name") ? (o(), i(t, { key: "workshop.name", prop: "workshop.name", "show-overflow-tooltip": true, label: "车间", align: "center" })) : n("", true), e(l).visible("productionLine.name") ? (o(), i(t, { align: "center", key: "productionLine.name", prop: "productionLine.name", "show-overflow-tooltip": true, label: "产线" })) : n("", true), e(l).visible("process.name") ? (o(), i(t, { key: "process.name", prop: "process.name", align: "center", "show-overflow-tooltip": true, label: "工序" })) : n("", true), e(l).visible("team.name") ? (o(), i(t, { key: "team.name", prop: "team.name", "show-overflow-tooltip": true, align: "center", label: "班组" })) : n("", true), e(l).visible("project") ? (o(), i(t, { key: "project", prop: "project", align: "center", "show-overflow-tooltip": true, label: "项目", "min-width": "140" }, { default: s(({ row: a }) => [q(u(e(E)(a.project)), 1)]), _: 1 })) : n("", true), e(l).visible("quantity") ? (o(), i(t, { key: "quantity", prop: "quantity", align: "center", "show-overflow-tooltip": true, label: "任务量（件）" })) : n("", true), e(l).visible("completeQuantity") ? (o(), i(t, { key: "completeQuantity", prop: "completeQuantity", align: "center", "show-overflow-tooltip": true, label: "实际完成（件）" }, { default: s(({ row: a }) => [m("span", z, u(a.completeQuantity), 1)]), _: 1 })) : n("", true), e(l).visible("unQuantity") ? (o(), i(t, { key: "unQuantity", prop: "unQuantity", align: "center", "show-overflow-tooltip": true, label: "滞后数量（件）" }, { default: s(({ row: a }) => [m("span", A, u(a.unQuantity), 1)]), _: 1 })) : n("", true), e(l).visible("completeRate") ? (o(), i(t, { key: "completeRate", prop: "completeRate", align: "center", "show-overflow-tooltip": true, label: "完成率" }, { default: s(({ row: a }) => [m("span", M, u(a.completeRate), 1)]), _: 1 })) : n("", true), c(t, { align: "center", "show-overflow-tooltip": true, label: "操作", width: "100px" }, { default: s((a) => [e(F)(e(h).detail) ? (o(), i(r, { key: 0, type: "primary", size: "default", icon: "el-icon-view", onClick: (G) => Q(a.row) }, null, 8, ["onClick"])) : n("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[C, e(f).loading]]), c(e(H)), c(V, { visible: d.value, "onUpdate:visible": p[0] || (p[0] = (a) => d.value = a), "detail-data": b.value, permission: e(h) }, null, 8, ["visible", "detail-data", "permission"])]);
  };
} };
export {
  ee as default
};
