import { ref as p } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as V } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as M } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as g } from "vue";
import { unref as e } from "vue";
import { createBlock as r } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as i } from "vue";
import { normalizeClass as B } from "vue";
import { withModifiers as H } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElTag as L } from "element-plus";
import { vLoading as U } from "element-plus";
import { c as O } from "../../../../modules/project-plan-a5233e17.js";
import { _ as q, gD as z, bN as F, x as K, o as Q, P as $ } from "../../../../shared/runtime.js";
import { j as w } from "../../../../modules/plan-d12d7ccf.js";
import G from "./module/header.vue.js";
import J from "./module/create-project.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/custom-monomer-form.vue.js";
import "./module/subitemType-plan-table.vue.js";
import "./module/create-dept-plan.vue.js";
const W = { class: "app-container" }, X = { class: "head-container" }, Y = { __name: "index", setup(Z) {
  const u = p(false), h = p({}), D = { add: false, edit: false, del: false, download: false }, x = p([["startDate", ["parse-time", "{y}-{m}-{d}"]], ["endDate", ["parse-time", "{y}-{m}-{d}"]], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["projectAttribute", ["parse-enum", z]], ["businessType", ["parse-enum", F]]]), f = p(), _ = p(), { crud: c, columns: l, CRUD: k } = K({ title: "项目计划", permission: { get: w.get }, optShow: { ...D }, crudApi: { ...O }, invisibleColumns: [], hasPagination: true }, f);
  console.log(c);
  const { maxHeight: N } = Q({ paginate: true, extraBox: [".head-container"], minHeight: 300 });
  k.HOOK.handleRefresh = (d, { data: m }) => {
  };
  function j(d) {
    u.value = true, h.value = d;
  }
  function T() {
    c.toQuery(), _.value.fetchSummary();
  }
  return (d, m) => {
    const t = I, C = L, P = v("common-button"), A = v("common-table"), S = V("permission"), R = U;
    return a(), M("div", W, [b("div", X, [s(G, { ref_key: "header", ref: _ }, null, 512)]), g((a(), r(A, { ref_key: "tableRef", ref: f, data: e(c).data, "data-format": x.value, "empty-text": e(c).emptyText, "max-height": e(N), style: { width: "100%" } }, { default: n(() => [s(t, { label: "序号", align: "center", width: "50", type: "index" }), e(l).visible("havePlan") ? (a(), r(t, { key: 0, prop: "havePlan", "show-overflow-tooltip": false, align: "center", width: "90", label: "状态" }, { default: n(({ row: { sourceRow: o } }) => [s(C, { type: o.havePlan ? "success" : "danger", effect: "plain" }, { default: n(() => [E(y(o.havePlan ? "已创建" : "未创建"), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : i("", true), e(l).visible("createTime") ? (a(), r(t, { key: 1, prop: "createTime", "show-overflow-tooltip": true, align: "center", label: "立项日期", width: "130" })) : i("", true), e(l).visible("serialNumber") ? (a(), r(t, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "合同编号", width: "130" })) : i("", true), e(l).visible("shortName") ? (a(), r(t, { key: "shortName", prop: "shortName", "show-overflow-tooltip": true, label: "项目简称", "header-align": "center", "min-width": "130" })) : i("", true), e(l).visible("projectAttribute") ? (a(), r(t, { key: "projectAttribute", prop: "projectAttribute", label: "经营方式", align: "center", width: "100" })) : i("", true), e(l).visible("businessType") ? (a(), r(t, { key: "businessType", prop: "businessType", label: "订单类型", align: "center", width: "100" })) : i("", true), e(l).visible("structureStatusName") ? (a(), r(t, { key: "structureStatusName", prop: "structureStatusName", label: "结构类型", align: "center", width: "100" })) : i("", true), e(l).visible("contractAmount") ? (a(), r(t, { key: "contractAmount", prop: "contractAmount", "show-overflow-tooltip": true, align: "center", width: "120", label: "合同额（元）" })) : i("", true), e(l).visible("startDate") ? (a(), r(t, { key: "startDate", prop: "startDate", "show-overflow-tooltip": true, align: "center", width: "110", label: "约定开工日期" })) : i("", true), e(l).visible("endDate") ? (a(), r(t, { key: "endDate", prop: "endDate", "show-overflow-tooltip": true, align: "center", width: "110", label: "约定完工日期" })) : i("", true), e(l).visible("allDays") ? (a(), r(t, { key: "allDays", prop: "allDays", label: "总工期(天)", align: "center", width: "90" })) : i("", true), e(l).visible("alreadyDays") ? (a(), r(t, { key: "alreadyDays", prop: "alreadyDays", label: "已用时", align: "center", width: "100px" }, { default: n(({ row: o }) => [b("span", { class: B(o.alreadyDays > o.allDays ? "table-alreadyDays" : "") }, y(o.alreadyDays >= 0 ? o.alreadyDays : "-"), 3)]), _: 1 })) : i("", true), e(l).visible("projectManagerName") ? (a(), r(t, { key: "projectManagerName", label: "项目（销售）经理", align: "center", width: "130px" }, { default: n((o) => [b("div", null, y(o.row.projectManagerName ? o.row.projectManagerName : o.row.salesLeaderName), 1)]), _: 1 })) : i("", true), e(l).visible("createName") ? (a(), r(t, { key: "createName", prop: "createName", label: "创建人", align: "center", width: "100px" })) : i("", true), s(t, { label: "操作", width: "90px", align: "center", fixed: "right" }, { default: n(({ row: { sourceRow: o } }) => [g(s(P, { type: "primary", icon: "el-icon-edit", onClick: H((ee) => j(o), ["stop"]) }, null, 8, ["onClick"]), [[S, e(w).edit]])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[R, e(c).loading]]), s(e($)), s(J, { modelValue: u.value, "onUpdate:modelValue": m[0] || (m[0] = (o) => u.value = o), projectInfo: h.value, onSuccess: T }, null, 8, ["modelValue", "projectInfo"])]);
  };
} }, de = q(Y, [["__scopeId", "data-v-2f604386"]]);
export {
  de as default
};
