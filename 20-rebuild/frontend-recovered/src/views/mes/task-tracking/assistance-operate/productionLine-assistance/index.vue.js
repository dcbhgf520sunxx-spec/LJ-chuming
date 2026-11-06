import { ref as c } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as u } from "vue";
import { withCtx as m } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as n } from "vue";
import { createTextVNode as E } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as q } from "vue";
import { toDisplayString as d } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as W } from "element-plus";
import { c as B } from "../../../../../modules/productionLine-assistance-be4814e6.js";
import { x as I, rN as A, o as $, rL as w, bo as F, P as O } from "../../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import G from "./module/assistance-drawer.vue.js";
import K from "./module/record-drawer.vue.js";
import "../../../../../modules/use-scheduling-groups-e49a6ba2.js";
import "../../../../../modules/artifact-f1b0ca44.js";
import "./module/assistance-preview.vue.js";
const Q = { class: "app-container" }, J = { class: "head-container" }, le = { __name: "index", setup(X) {
  const R = { add: false, edit: false, del: false, download: false }, S = c([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"]]), _ = c(), { crud: l, columns: r, CRUD: V } = I({ title: "产线协同", sort: [], permission: { ...A }, optShow: { ...R }, crudApi: { ...B } }, _), { maxHeight: D } = $({ paginate: true });
  V.HOOK.handleRefresh = (v, o) => {
    o.data.content = o.data.content.map((p) => (p.completeRatio = p.totalNetWeight && (p.totalCompleteNetWeight / p.totalNetWeight * 100).toFixed(2) || 0, p));
  };
  const f = c(false), b = c(false), k = c({});
  function P(v) {
    k.value = Object.assign({}, v), b.value = true;
  }
  return (v, o) => {
    const p = N("common-button"), i = U, j = N("common-table"), H = L("permission"), M = W;
    return a(), h("div", Q, [y("div", J, [u(e(z), null, { viewLeft: m(() => [T((a(), n(p, { size: "default", type: "info", icon: "el-icon-clock", onClick: o[0] || (o[0] = (t) => f.value = true) }, { default: m(() => o[3] || (o[3] = [E(" 协同记录 ")])), _: 1, __: [3] })), [[H, e(A).record]])]), _: 1 })]), T((a(), n(j, { ref_key: "tableRef", ref: _, data: e(l).data, "empty-text": e(l).emptyText, "max-height": e(D), "data-format": S.value, style: { width: "100%" } }, { default: m(() => [u(i, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("orderNumber") ? (a(), n(i, { key: 0, align: "center", prop: "orderNumber", "show-overflow-tooltip": true, label: "排产工单号", "min-width": "120px" })) : s("", true), e(l).query.taskTypeEnum & e(w).MACHINE_PART.V ? s("", true) : (a(), h(q, { key: 1 }, [e(r).visible("project") ? (a(), n(i, { key: 0, prop: "project", "show-overflow-tooltip": true, label: "所属项目", "min-width": "160px" })) : s("", true), e(r).visible("monomer.name") ? (a(), n(i, { key: 1, align: "center", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "120px" })) : s("", true), e(r).visible("group.name") ? (a(), n(i, { key: 2, prop: "group.name", "show-overflow-tooltip": true, label: "当前生产组", "min-width": "160px" }, { default: m(({ row: t }) => {
      var g, x, C;
      return [y("span", null, d((g = t.workshop) == null ? void 0 : g.name) + ">" + d((x = t.productionLine) == null ? void 0 : x.name) + ">" + d((C = t.groups) == null ? void 0 : C.name), 1)];
    }), _: 1 })) : s("", true), e(r).visible("askCompleteTime") ? (a(), n(i, { key: 3, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : s("", true)], 64)), e(l).query.taskTypeEnum & e(w).MACHINE_PART.V ? (a(), h(q, { key: 2 }, [e(r).visible("cutConfig.name") ? (a(), n(i, { key: 0, prop: "cutConfig.name", "show-overflow-tooltip": true, label: "切割方式", width: "135px", align: "center" })) : s("", true)], 64)) : s("", true), e(r).visible("quantity") ? (a(), n(i, { key: 3, align: "center", prop: "quantity", "show-overflow-tooltip": true, label: "未完成量（件/kg）", width: "135px" }, { default: m(({ row: t }) => [y("span", null, d(e(l).query.weightStatus === e(F).NET.V ? t.quantity + "/" + t.totalNetWeight : t.quantity + "/" + t.totalGrossWeight), 1)]), _: 1 })) : s("", true), e(r).visible("user.name") && !(e(l).query.taskTypeEnum & e(w).MACHINE_PART.V) ? (a(), n(i, { key: 4, align: "center", prop: "user.name", "show-overflow-tooltip": true, label: "排产人", width: "120px" })) : s("", true), u(i, { label: "操作", width: "120px", align: "center", fixed: "right" }, { default: m(({ row: t }) => [u(p, { size: "default", type: "primary", onClick: (g) => P(t) }, { default: m(() => o[4] || (o[4] = [E("产线协同")])), _: 2, __: [4] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[M, e(l).loading]]), u(e(O)), u(G, { visible: b.value, "onUpdate:visible": o[1] || (o[1] = (t) => b.value = t), info: k.value, onSuccess: e(l).toQuery }, null, 8, ["visible", "info", "onSuccess"]), u(K, { visible: f.value, "onUpdate:visible": o[2] || (o[2] = (t) => f.value = t), weightStatus: e(l).query.weightStatus }, null, 8, ["visible", "weightStatus"])]);
  };
} };
export {
  le as default
};
