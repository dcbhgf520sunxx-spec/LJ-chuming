import { ref as d } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as _ } from "vue";
import { unref as e } from "vue";
import { createVNode as l } from "vue";
import { withCtx as s } from "vue";
import { createBlock as a } from "vue";
import { withModifiers as B } from "vue";
import { createTextVNode as g } from "vue";
import { createCommentVNode as n } from "vue";
import { withDirectives as O } from "vue";
import { Fragment as U } from "vue";
import { renderList as $ } from "vue";
import { toDisplayString as q } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as z } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as F } from "../../../../modules/outsourcing-receiving-3624908c.js";
import { _ as G, m as Q, x as K, bN as j, tU as J, o as W, G as P, aN as X, bv as Y, tS as v, P as Z } from "../../../../shared/runtime.js";
import { o as m } from "../../../../modules/project-19a12d6b.js";
import ee from "./module/header.vue.js";
import te from "./module/delivery-detail.vue.js";
import oe from "./module/create-receive-form.vue.js";
import "../../../../modules/index-8edb1b61.js";
import "../../../../modules/use-table-row-validate-5799de49.js";
import "./module/receive-confirm-form.vue.js";
const ae = { class: "app-container" }, re = { key: 0 }, ie = { key: 1 }, le = { __name: "index", setup(se) {
  const { globalProjectId: w, globalProject: c } = Q(["globalProjectId", "globalProject"]), S = { add: false, edit: false, del: false, download: false }, x = d(), y = d(false), b = d(false), h = d({}), { crud: p, columns: u, CRUD: C } = K({ title: "外购收货", sort: ["id.desc"], permission: { ...m }, optShow: { ...S }, requiredQuery: ["projectId"], crudApi: { ...F }, hasPagination: true }, x);
  C.HOOK.beforeRefresh = () => (p.query.projectId = c.value.businessType === j.INSTALLATION.V ? w.value : void 0, !!p.query.projectId);
  const A = d([["status", ["parse-enum", J]], ["receivedTime", "parse-time"]]), { maxHeight: D } = W({ paginate: true, extraHeight: 40 });
  function E(T, o) {
    y.value = true, h.value = T;
  }
  return (T, o) => {
    var V;
    const k = I("common-button"), i = H, N = z, L = I("common-table"), R = M;
    return t(), _("div", ae, [((V = e(c)) == null ? void 0 : V.businessType) === e(j).INSTALLATION.V ? (t(), _("div", re, [l(e(ee), { projectId: e(w) }, { createBtn: s(() => [e(P)(e(m).createReceive) ? (t(), a(k, { key: 0, size: "default", icon: "el-icon-plus", type: "primary", class: "filter-item", onClick: o[0] || (o[0] = B((r) => b.value = true, ["stop"])) }, { default: s(() => o[3] || (o[3] = [g(" 创建收货 ")])), _: 1, __: [3] })) : n("", true)]), _: 1 }, 8, ["projectId"]), O((t(), a(L, { ref_key: "tableRef", ref: x, data: e(p).data, "data-format": A.value, "empty-text": e(p).emptyText, "max-height": e(D), stripe: false, "row-key": "id", style: { width: "100%" } }, { default: s(() => [l(i, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), e(u).visible("receivedTime") ? (t(), a(i, { key: "receivedTime", prop: "receivedTime", label: "收货日期", align: "center", "min-width": "120", "show-overflow-tooltip": true })) : n("", true), e(u).visible("userName") ? (t(), a(i, { key: "userName", prop: "userName", label: "办理人", align: "center", "show-overflow-tooltip": true })) : n("", true), e(u).visible("supplierName") ? (t(), a(i, { key: "supplierName", prop: "supplierName", label: "供应商", align: "center", "show-overflow-tooltip": true })) : n("", true), e(u).visible("orderSerialNumber") ? (t(), a(i, { key: "orderSerialNumber", prop: "orderSerialNumber", label: "采购合同号", align: "center", "show-overflow-tooltip": true })) : n("", true), e(u).visible("productType") ? (t(), a(i, { key: "productType", prop: "productType", label: "类别", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: s((r) => [(t(true), _(U, null, $(e(X)(e(Y).getBits(e(v), r.row.productType, "V")), (f) => (t(), a(N, { style: { "margin-right": "5px" }, key: f, type: e(v).V[f].T, effect: "light", "disable-transitions": "" }, { default: s(() => [g(q(e(v).VL[f]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : n("", true), e(P)(e(m).detail) ? (t(), a(i, { key: 5, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: s((r) => [l(k, { size: "default", icon: "el-icon-view", type: "primary", onClick: (f) => E(r.row) }, null, 8, ["onClick"])]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[R, e(p).loading]]), l(e(Z))])) : (t(), _("div", ie, [l(N, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: s(() => o[4] || (o[4] = [g(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [4] })])), l(e(te), { modelValue: y.value, "onUpdate:modelValue": o[1] || (o[1] = (r) => y.value = r), detailInfo: h.value, permission: e(m), globalProject: e(c) }, null, 8, ["modelValue", "detailInfo", "permission", "globalProject"]), l(oe, { modelValue: b.value, "onUpdate:modelValue": o[2] || (o[2] = (r) => b.value = r), onSuccess: e(p).toQuery, permission: e(m), globalProject: e(c) }, null, 8, ["modelValue", "onSuccess", "permission", "globalProject"])]);
  };
} }, ge = G(le, [["__scopeId", "data-v-0fe26784"]]);
export {
  ge as default
};
