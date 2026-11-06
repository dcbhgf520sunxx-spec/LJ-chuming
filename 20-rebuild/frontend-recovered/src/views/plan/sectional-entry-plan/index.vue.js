import { ref as s } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as R } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as B } from "vue";
import { unref as t } from "vue";
import { createBlock as d } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as H } from "vue";
import { withModifiers as v } from "vue";
import { createCommentVNode as w } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElTag as I } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as O } from "../../../modules/sectional-entry-plan-49cfc1e2.js";
import { bN as U, iG as G, x as L, o as $, s_ as p, G as x, P as q } from "../../../shared/runtime.js";
import { s as y } from "../../../modules/plan-d12d7ccf.js";
import F from "./module/header.vue.js";
import K from "./module/create-project.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/custom-monomer-form.vue.js";
import "./module/subitemType-plan-table.vue.js";
import "./module/create-dept-plan.vue.js";
const Q = { class: "app-container" }, z = { class: "head-container" }, se = { __name: "index", setup(J) {
  const c = s(false), _ = s({}), T = s([["startDate", ["parse-time", "{y}-{m}-{d}"]], ["endDate", ["parse-time", "{y}-{m}-{d}"]], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["orderType", ["parse-enum", U]], ["structureType", ["parse-enum", G]]]), g = s(), m = s(), { crud: l, CRUD: S } = L({ title: "单体区域计划", permission: { get: y.get }, crudApi: { ...O }, hasPagination: true }, g);
  console.log(l);
  const { maxHeight: C } = $({ paginate: true, extraBox: [".head-container"], minHeight: 300 });
  S.HOOK.handleRefresh = (u, { data: r }) => {
    m.value.fetchCountInfo();
  };
  function h(u) {
    c.value = true, _.value = u;
  }
  function D() {
    l.toQuery(), m.value.fetchSummary();
  }
  return (u, r) => {
    const a = A, E = I, b = k("common-button"), N = k("common-table"), V = M;
    return i(), j("div", Q, [R("div", z, [e(F, { ref_key: "header", ref: m }, null, 512)]), B((i(), d(N, { ref_key: "tableRef", ref: g, data: t(l).data, "data-format": T.value, "empty-text": t(l).emptyText, "max-height": t(C), style: { width: "100%" } }, { default: n(() => [e(a, { label: "序号", align: "center", width: "50", type: "index" }), e(a, { key: "planStatus", prop: "planStatus", "show-overflow-tooltip": false, align: "center", label: "计划状态" }, { default: n((o) => [e(E, { type: t(p).V[o.row.planStatus].T, effect: "plain" }, { default: n(() => [f(H(t(p).VL[o.row.planStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), e(a, { key: "projectSerialNumber", prop: "projectSerialNumber", "show-overflow-tooltip": "", label: "项目编号", align: "center" }), e(a, { key: "projectShortName", prop: "projectShortName", "show-overflow-tooltip": "", label: "项目简称", align: "center" }), e(a, { key: "orderType", prop: "orderType", label: "订单类型", align: "center" }), e(a, { key: "structureTypeName", prop: "structureTypeName", label: "结构类型", align: "center" }), e(a, { key: "startDate", prop: "startDate", "show-overflow-tooltip": "", label: "开工时间", align: "center" }), e(a, { key: "endDate", prop: "endDate", "show-overflow-tooltip": "", label: "完工时间", align: "center" }), e(a, { key: "duration", prop: "duration", label: "工期（天）", align: "center" }), e(a, { label: "操作", align: "center", fixed: "right" }, { default: n((o) => [o.row.planStatus === t(p).NOTCREATED.V && t(x)(t(y).createPlan) ? (i(), d(b, { key: 0, type: "primary", onClick: v((P) => h(o.row), ["stop"]) }, { default: n(() => r[1] || (r[1] = [f(" 计划创建 ")])), _: 2, __: [1] }, 1032, ["onClick"])) : w("", true), o.row.planStatus === t(p).CREATED.V && t(x)(t(y).getPlanDetails) ? (i(), d(b, { key: 1, type: "success", onClick: v((P) => h(o.row), ["stop"]) }, { default: n(() => r[2] || (r[2] = [f(" 查看计划 ")])), _: 2, __: [2] }, 1032, ["onClick"])) : w("", true)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[V, t(l).loading]]), e(t(q)), e(K, { modelValue: c.value, "onUpdate:modelValue": r[0] || (r[0] = (o) => c.value = o), projectInfo: _.value, onSuccess: D }, null, 8, ["modelValue", "projectInfo"])]);
  };
} };
export {
  se as default
};
