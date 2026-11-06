import { ref as m } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as T } from "vue";
import { createVNode as o } from "vue";
import { unref as r } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as b } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as i } from "vue";
import { toDisplayString as l } from "vue";
import { withModifiers as V } from "vue";
import { createCommentVNode as j } from "vue";
import { ElTableColumn as B } from "element-plus";
import { vLoading as U } from "element-plus";
import { c as M } from "../../../../modules/inspect-statistics-fca9b551.js";
import R from "./module/header.vue.js";
import A from "./module/detail.vue.js";
import { x as E, mJ as g, o as H, p as v, G as Q, P as S } from "../../../../shared/runtime.js";
const $ = { class: "app-container" }, q = { class: "head-container" }, K = { __name: "index", setup(z) {
  const d = m(), { crud: n } = E({ title: "质检统计", permission: { ...g }, invisibleColumns: [], crudApi: { ...M }, hasPagination: true }, d), p = m(false), { maxHeight: N } = H({ paginate: true }), w = m();
  function x(u) {
    p.value = true, w.value = u;
  }
  return (u, f) => {
    const t = B, y = h("common-button"), k = h("common-table"), C = U;
    return c(), D("div", $, [T("div", q, [o(r(R))]), P((c(), b(k, { ref_key: "tableRef", ref: d, data: r(n).data, "empty-text": r(n).emptyText, "max-height": r(N), "show-empty-symbol": false, style: { width: "100%" } }, { default: a(() => [o(t, { label: "序号", type: "index", align: "center", width: "60" }), o(t, { "show-overflow-tooltip": "", prop: "project", label: "项目", align: "center", width: "180px" }, { default: a((e) => {
      var s, _;
      return [i(l(((s = e.row.project) == null ? void 0 : s.serialNumber) || "-") + " " + l(((_ = e.row.project) == null ? void 0 : _.shortName) || "-"), 1)];
    }), _: 1 }), o(t, { "show-overflow-tooltip": "", prop: "monomerName", label: "单体", align: "center" }, { default: a((e) => [i(l(e.row.monomerName || "-"), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": "", prop: "areaName", label: "区域", align: "center" }, { default: a((e) => [i(l(e.row.areaName || "-"), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": "", prop: "serialNumber", label: "编号", align: "center" }, { default: a((e) => [i(l(e.row.serialNumber || "-"), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": "", prop: "inspectionQuantity", label: "数量", align: "center" }, { default: a((e) => [i(l(e.row.inspectionQuantity || "-"), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": "", prop: "workshopName", label: "车间", align: "center" }, { default: a((e) => [i(l(e.row.workshopName || "-"), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": "", prop: "processName", label: "工序", align: "center" }, { default: a((e) => [i(l(e.row.processName || "-"), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": "", prop: "team", label: "班组", align: "center" }, { default: a((e) => {
      var s;
      return [i(l(((s = e.row.team) == null ? void 0 : s.name) || "-"), 1)];
    }), _: 1 }), o(t, { "show-overflow-tooltip": "", prop: "reportDate", label: "上报日期", align: "center" }, { default: a((e) => [i(l(e.row.reportDate ? r(v)(e.row.reportDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": "", prop: "inspectUserName", label: "质检", align: "center" }, { default: a((e) => [i(l(e.row.inspectUserName || "-"), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": "", prop: "passageTime", label: "通过时间", align: "center" }, { default: a((e) => [i(l(e.row.passageTime ? r(v)(e.row.passageTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), o(t, { label: "操作", align: "center", fixed: "right" }, { default: a((e) => [r(Q)(r(g).detail) ? (c(), b(y, { key: 0, type: "primary", icon: "el-icon-view", size: "default", onClick: V((s) => x(e.row), ["stop"]) }, null, 8, ["onClick"])) : j("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[C, r(n).loading]]), o(r(S)), o(r(A), { visible: p.value, "onUpdate:visible": f[0] || (f[0] = (e) => p.value = e), "detail-data": w.value }, null, 8, ["visible", "detail-data"])]);
  };
} };
export {
  K as default
};
