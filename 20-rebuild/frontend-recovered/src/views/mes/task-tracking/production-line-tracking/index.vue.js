import { ref as w } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as l } from "vue";
import { withDirectives as T } from "vue";
import { unref as t } from "vue";
import { createBlock as r } from "vue";
import { withCtx as a } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as m } from "vue";
import { createTextVNode as E } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as P } from "element-plus";
import { ElProgress as H } from "element-plus";
import { vLoading as I } from "element-plus";
import { c as K, _ as q } from "./production-line-tracking-detail/index.vue.js";
import { a3 as n, x as G, oo as N, o as U, bo as C } from "../../../../shared/runtime.js";
import $ from "./module/header.vue.js";
const j = { class: "app-container" }, O = { class: "head-container" }, oe = { __name: "index", setup(z) {
  const A = w([["taskNetWeight", ["to-fixed", 2]], ["taskGrossWeight", ["to-fixed", 2]], ["completeNetWeight", ["to-fixed", 2]], ["completeGrossWeight", ["to-fixed", 2]]]), Q = { [n.ARTIFACT.K]: "success", [n.ASSEMBLE.K]: "warning", [n.MACHINE_PART.K]: "" }, V = { add: false, edit: false, del: false, download: false }, x = w(), h = w(false), v = w({}), { crud: p, CRUD: R, columns: c } = G({ title: "产线跟踪", sort: [], optShow: { ...V }, permission: { ...N }, crudApi: { ...K }, hasPagination: true }, x), { maxHeight: S } = U({ extraBox: [".head-container"], paginate: true });
  function F(g) {
    h.value = true, v.value = g;
  }
  return R.HOOK.handleRefresh = (g, { data: i }) => {
    var _;
    const o = [];
    for (const u in i) {
      const k = u === "artifactList" ? n.ARTIFACT.V : u === "assembleList" ? n.ASSEMBLE.V : n.MACHINE_PART.V;
      (_ = i[u]) == null || _.map((f) => {
        f.productType = k, o.push(f);
      });
    }
    i.content = o;
  }, (g, i) => {
    const o = M, _ = P, u = H, k = b("common-button"), f = b("common-table"), W = D("permission"), B = I;
    return s(), L("div", j, [y("div", O, [l($)]), T((s(), r(f, { ref_key: "tableRef", ref: x, data: t(p).data, "empty-text": t(p).emptyText, "max-height": t(S), "data-format": A.value, "row-key": "projectId", style: { width: "100%" } }, { default: a(() => [l(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(c).visible("name") ? (s(), r(o, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "产线", "min-width": "120px" }, { default: a((e) => [y("span", null, d(e.row.workShopName) + ">" + d(e.row.name), 1)]), _: 1 })) : m("", true), t(c).visible("taskType") ? (s(), r(o, { align: "center", key: "taskType", prop: "taskType", "show-overflow-tooltip": true, label: "类别", width: "80px" }, { default: a((e) => [l(_, { effect: "plain", type: Q[t(n).VK[e.row.taskType]] }, { default: a(() => [E(d(t(n).VL[e.row.taskType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : m("", true), t(c).visible("taskQuantity") ? (s(), r(o, { align: "center", key: "taskQuantity", prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务量（件/吨）" }, { default: a((e) => [y("span", null, d(t(p).query.weightStatus === t(C).NET.V ? e.row.taskQuantity + "/" + (e.row.taskNetWeight / 1e3).toFixed(2) : e.row.taskQuantity + "/" + (e.row.taskGrossWeight / 1e3).toFixed(2)), 1)]), _: 1 })) : m("", true), t(c).visible("completeQuantity") ? (s(), r(o, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成量（件/吨）" }, { default: a((e) => [y("span", null, d(t(p).query.weightStatus === t(C).NET.V ? e.row.completeQuantity + "/" + (e.row.completeNetWeight / 1e3).toFixed(2) : e.row.completeQuantity + "/" + (e.row.completeGrossWeight / 1e3).toFixed(2)), 1)]), _: 1 })) : m("", true), t(c).visible("rate") ? (s(), r(o, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "完成率", "min-width": "180px" }, { default: a((e) => [l(u, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: Number((e.row.completeQuantity / e.row.taskQuantity * 100).toFixed(2)), status: "success" }, null, 8, ["percentage"])]), _: 1 })) : m("", true), T((s(), r(o, { align: "center", "show-overflow-tooltip": true, label: "操作", width: "100px" }, { default: a((e) => [l(k, { type: "primary", size: "default", onClick: (J) => F(e.row) }, { default: a(() => i[1] || (i[1] = [E("查看")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })), [[W, t(N).detail]])]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[B, t(p).loading]]), l(q, { visible: h.value, "onUpdate:visible": i[0] || (i[0] = (e) => h.value = e), "detail-data": v.value }, null, 8, ["visible", "detail-data"])]);
  };
} };
export {
  oe as default
};
