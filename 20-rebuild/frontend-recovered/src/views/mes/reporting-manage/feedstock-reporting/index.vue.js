import { ref as m } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as s } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as t } from "vue";
import { unref as o } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as h } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as r } from "vue";
import { withModifiers as C } from "vue";
import { createCommentVNode as R } from "vue";
import { ElTableColumn as T } from "element-plus";
import { vLoading as j } from "element-plus";
import { c as D } from "../../../../modules/feedstock-reporting-f416c9a5.js";
import { x as L, qn as g, o as P, p as B, G as V, P as M } from "../../../../shared/runtime.js";
import Q from "./module/header.vue.js";
import $ from "./module/detail.vue.js";
import "../../../../modules/project-select-94bb5bbd.js";
import "./module/form.vue.js";
import "./module/preview.vue.js";
const q = { class: "app-container" }, A = { class: "head-container" }, E = { key: 0 }, H = { key: 1 }, U = { key: 0 }, z = { key: 1 }, Z = { __name: "index", setup(F) {
  const u = m(), d = m(), { crud: c } = L({ title: "投料填报", permission: { ...g }, crudApi: { ...D }, sort: [], hasPagination: true }, u), p = m(false), { maxHeight: y } = P({ paginate: true });
  function b(_) {
    p.value = true, d.value = _;
  }
  return (_, f) => {
    const a = T, k = w("common-button"), v = w("common-table"), x = j;
    return i(), s("div", q, [l("div", A, [t(o(Q))]), N((i(), h(v, { ref_key: "tableRef", ref: u, data: o(c).data, "empty-text": o(c).emptyText, "max-height": o(y), style: { width: "100%" }, "show-empty-symbol": false, "return-source-data": "" }, { default: n(() => [t(a, { label: "序号", type: "index", align: "center", width: "60" }), t(a, { key: "createTime", prop: "createTime", "show-overflow-tooltip": "", label: "投料时间", align: "center" }, { default: n((e) => [l("span", null, r(e.row.createTime ? o(B)(e.row.createTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 }), t(a, { key: "project", prop: "project", "show-overflow-tooltip": "", label: "所属项目", align: "center" }, { default: n((e) => [e.row.project ? (i(), s("span", E, r(e.row.project.serialNumber) + " " + r(e.row.project.shortName), 1)) : (i(), s("span", H, "-"))]), _: 1 }), t(a, { key: "workshopNameList", prop: "workshopNameList", "show-overflow-tooltip": "", label: "所属生产车间", align: "center" }, { default: n((e) => [e.row.workshopNameList ? (i(), s("span", U, r(e.row.workshopNameList.join("、")), 1)) : (i(), s("span", z, "-"))]), _: 1 }), t(a, { key: "feedingQuantity", prop: "feedingQuantity", "show-overflow-tooltip": "", label: "投料量(t)", align: "center" }, { default: n((e) => [l("span", null, r(e.row.feedingQuantity ?? "-"), 1)]), _: 1 }), t(a, { key: "userName", prop: "userName", "show-overflow-tooltip": "", label: "办理人", align: "center" }, { default: n((e) => [l("span", null, r(e.row.userName || "-"), 1)]), _: 1 }), t(a, { label: "操作", align: "center", fixed: "right" }, { default: n((e) => [o(V)(o(g).details) ? (i(), h(k, { key: 0, icon: "el-icon-view", type: "info", size: "default", onClick: C((G) => b(e.row), ["stop"]) }, null, 8, ["onClick"])) : R("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[x, o(c).loading]]), t(o(M)), t(o($), { visible: p.value, "onUpdate:visible": f[0] || (f[0] = (e) => p.value = e), currentRow: d.value }, null, 8, ["visible", "currentRow"])]);
  };
} };
export {
  Z as default
};
