import { ref as c } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as m } from "vue";
import { withCtx as u } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as n } from "vue";
import { createTextVNode as A } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as R } from "vue";
import { toDisplayString as d } from "vue";
import { ElTableColumn as I } from "element-plus";
import { vLoading as L } from "element-plus";
import { c as U } from "../../../../../modules/productionLine-assistance-4576379e.js";
import { x as W, o as $, ce as y, P as F } from "../../../../../shared/runtime.js";
import O from "./module/header.vue.js";
import z from "./module/assistance-drawer.vue.js";
import G from "./module/record-drawer.vue.js";
import { G as E } from "../../../../../modules/bridge-86f96a4f.js";
import "../../../../../modules/use-scheduling-groups-9f6c1fa1.js";
import "../../../../../modules/box-3fab54f9.js";
import "./module/assistance-preview.vue.js";
const K = { class: "app-container" }, Q = { class: "head-container" }, le = { __name: "index", setup(J) {
  const V = { add: false, edit: false, del: false, download: false }, q = c([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"]]), h = c(), { crud: p, columns: l, CRUD: D } = W({ title: "产线协同", sort: [], permission: { ...E }, optShow: { ...V }, crudApi: { ...U } }, h), { maxHeight: P } = $({ paginate: true });
  D.HOOK.handleRefresh = (v, t) => {
    t.data.content = t.data.content.map((s) => (s.completeRatio = s.totalNetWeight && (s.totalCompleteNetWeight / s.totalNetWeight * 100).toFixed(2) || 0, s));
  };
  const f = c(false), b = c(false), k = c({});
  function j(v) {
    k.value = Object.assign({}, v), b.value = true;
  }
  return (v, t) => {
    const s = T("common-button"), i = I, H = T("common-table"), S = B("permission"), M = L;
    return a(), g("div", K, [w("div", Q, [m(e(O), null, { viewLeft: u(() => [N((a(), n(s, { size: "default", type: "info", icon: "el-icon-clock", onClick: t[0] || (t[0] = (o) => f.value = true) }, { default: u(() => t[3] || (t[3] = [A("协同记录")])), _: 1, __: [3] })), [[S, e(E).record]])]), _: 1 })]), N((a(), n(H, { ref_key: "tableRef", ref: h, data: e(p).data, "empty-text": e(p).emptyText, "max-height": e(P), "data-format": q.value, style: { width: "100%" } }, { default: u(() => [m(i, { label: "序号", type: "index", align: "center", width: "60" }), e(l).visible("orderNumber") ? (a(), n(i, { key: 0, align: "center", prop: "orderNumber", "show-overflow-tooltip": true, label: "排产工单号", "min-width": "120px" })) : r("", true), e(p).query.taskTypeEnum & e(y).MACHINE_PART.V ? r("", true) : (a(), g(R, { key: 1 }, [e(l).visible("project") ? (a(), n(i, { key: 0, prop: "project", "show-overflow-tooltip": true, label: "所属项目", "min-width": "160px" })) : r("", true), e(l).visible("monomer.name") ? (a(), n(i, { key: 1, align: "center", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "120px" })) : r("", true), e(l).visible("group.name") ? (a(), n(i, { key: 2, prop: "group.name", "show-overflow-tooltip": true, label: "原生产组", "min-width": "160px" }, { default: u(({ row: o }) => {
      var _, x, C;
      return [w("span", null, d((_ = o.workshop) == null ? void 0 : _.name) + ">" + d((x = o.productionLine) == null ? void 0 : x.name) + ">" + d((C = o.groups) == null ? void 0 : C.name), 1)];
    }), _: 1 })) : r("", true), e(l).visible("askCompleteTime") ? (a(), n(i, { key: 3, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : r("", true)], 64)), e(p).query.taskTypeEnum & e(y).MACHINE_PART.V ? (a(), g(R, { key: 2 }, [e(l).visible("cutConfig.name") ? (a(), n(i, { key: 0, prop: "cutConfig.name", "show-overflow-tooltip": true, label: "切割方式", width: "135px", align: "center" })) : r("", true)], 64)) : r("", true), e(l).visible("quantity") ? (a(), n(i, { key: 3, align: "center", prop: "quantity", "show-overflow-tooltip": true, label: "未完成量（件/kg）", width: "135px" }, { default: u(({ row: o }) => [w("span", null, d(o.quantity || 0) + " / " + d(o.totalNetWeight || 0), 1)]), _: 1 })) : r("", true), e(l).visible("user.name") && !(e(p).query.taskTypeEnum & e(y).MACHINE_PART.V) ? (a(), n(i, { key: 4, align: "center", prop: "user.name", "show-overflow-tooltip": true, label: "排产人", width: "120px" })) : r("", true), m(i, { label: "操作", width: "120px", align: "center", fixed: "right" }, { default: u(({ row: o }) => [m(s, { size: "default", type: "primary", onClick: (_) => j(o) }, { default: u(() => t[4] || (t[4] = [A("产线协同")])), _: 2, __: [4] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[M, e(p).loading]]), m(e(F)), m(z, { visible: b.value, "onUpdate:visible": t[1] || (t[1] = (o) => b.value = o), info: k.value, onSuccess: e(p).toQuery }, null, 8, ["visible", "info", "onSuccess"]), m(G, { visible: f.value, "onUpdate:visible": t[2] || (t[2] = (o) => f.value = o) }, null, 8, ["visible"])]);
  };
} };
export {
  le as default
};
