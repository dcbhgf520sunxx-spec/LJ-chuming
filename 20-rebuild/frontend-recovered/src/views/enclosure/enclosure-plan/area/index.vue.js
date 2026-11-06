import { ref as s } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as t } from "vue";
import { unref as l } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as B } from "vue";
import { createTextVNode as h } from "vue";
import { withModifiers as D } from "vue";
import { ElTableColumn as P } from "element-plus";
import { ElTag as A } from "element-plus";
import { vLoading as H } from "element-plus";
import { g as L } from "../../../../modules/area-ca564e60.js";
import { mu as w, x as U, o as M, p as O, P as $ } from "../../../../shared/runtime.js";
import { a as q } from "../../../../modules/enclosure-365a2177.js";
import F from "./module/header.vue.js";
import G from "./module/plan-list/list.vue.js";
import K from "./module/plan-detail/create-project.vue.js";
import "./module/plan-list/plan-form/index.vue.js";
import "./module/plan-list/plan-form/form.vue.js";
import "./module/plan-detail/custom-monomer-form.vue.js";
import "./module/plan-detail/subitemType-plan-table.vue.js";
import "./module/plan-detail/create-dept-plan.vue.js";
const Q = { class: "app-container" }, z = { class: "head-container" }, pe = { __name: "index", setup(J) {
  const x = { add: false, edit: false, del: false, download: false }, u = s(), d = s(false), S = s({}), p = s(false), f = s({}), v = s([["project", "parse-project"], ["planStatus", ["parse-enum", w]]]), { crud: i, columns: y, CRUD: V } = U({ title: "围护计划", sort: ["sort.asc", "id.desc"], permission: { ...q }, optShow: { ...x }, crudApi: { get: L }, invisibleColumns: [], hasPagination: true }, u), { maxHeight: j } = M({ wrapperBox: ".enclosure-area", paginate: true, extraHeight: 40 });
  V.HOOK.handleRefresh = (r, a) => {
    a.data.content = a.data.content.map((e) => (e.project = { id: e.projectId, shortName: e.shortName, name: e.projectName }, e));
  };
  function T(r) {
    console.log(r), p.value = true, f.value = r;
  }
  return (r, a) => {
    const e = P, C = A, N = g("common-button"), k = g("common-table"), E = H;
    return c(), I("div", Q, [m("div", z, [t(l(F))]), R((c(), _(k, { ref_key: "tableRef", ref: u, data: l(i).data, "data-format": v.value, "empty-text": l(i).emptyText, "max-height": l(j), showEmptySymbol: false, style: { width: "100%" } }, { default: n(() => [t(e, { align: "center", label: "序号", type: "index", width: "60" }), t(e, { align: "center", label: "项目编号", prop: "projectSerialNumber", width: "140" }), t(e, { align: "center", label: "项目名称", "min-width": "100", prop: "projectShortName", "show-overflow-tooltip": "" }), l(y).visible("createTime") ? (c(), _(e, { key: "createTime", align: "center", label: "创建时间", prop: "createTime", width: "180px" }, { default: n((o) => [m("span", null, b(o.row.createTime ? l(O)(o.row.createTime) : "-"), 1)]), _: 1 })) : B("", true), t(e, { align: "center", label: "创建人", prop: "user", width: "120px" }), t(e, { align: "center", label: "单位", prop: "" }, { default: n(() => a[2] || (a[2] = [m("span", null, "平方米", -1)])), _: 1 }), t(e, { align: "center", label: "预算量", prop: "budgetVolume" }), t(e, { align: "center", label: "状态", "min-width": "80", prop: "planStatus" }, { default: n((o) => [t(C, { type: l(w).V[o.row.sourceRow.planStatus].TAG, effect: "plain" }, { default: n(() => [h(b(o.row.planStatus), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), t(e, { align: "center", label: "操作", width: "140" }, { default: n(({ row: o }) => [t(N, { plan: "", type: "success", onClick: D((W) => T(o), ["stop"]) }, { default: n(() => a[3] || (a[3] = [h("查看计划")])), _: 2, __: [3] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[E, l(i).loading]]), t(l($)), t(l(G), { modelValue: d.value, "onUpdate:modelValue": a[0] || (a[0] = (o) => d.value = o), detailInfo: S.value, onSuccess: l(i).toQuery }, null, 8, ["modelValue", "detailInfo", "onSuccess"]), t(K, { modelValue: p.value, "onUpdate:modelValue": a[1] || (a[1] = (o) => p.value = o), projectInfo: f.value, onSuccess: r.handleSuccess }, null, 8, ["modelValue", "projectInfo", "onSuccess"])]);
  };
} };
export {
  pe as default
};
