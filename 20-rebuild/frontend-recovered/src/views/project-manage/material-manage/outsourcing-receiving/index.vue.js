import { ref as c } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as n } from "vue";
import { withCtx as p } from "vue";
import { unref as e } from "vue";
import { createBlock as a } from "vue";
import { withModifiers as B } from "vue";
import { createTextVNode as T } from "vue";
import { createCommentVNode as i } from "vue";
import { withDirectives as U } from "vue";
import { Fragment as $ } from "vue";
import { renderList as q } from "vue";
import { toDisplayString as A } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as L } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as O } from "../../../../modules/outsourcing-receiving-3624908c.js";
import { _ as z, m as F, x as G, tU as Q, o as K, G as V, aN as J, bv as W, tS as g, P as X } from "../../../../shared/runtime.js";
import { A as d } from "../../../../modules/project-19a12d6b.js";
import Y from "./module/header.vue.js";
import Z from "./module/delivery-detail.vue.js";
import ee from "./module/create-receive-form.vue.js";
import "../../../../modules/index-8edb1b61.js";
import "../../../../modules/use-table-row-validate-5799de49.js";
import "./module/receive-confirm-form.vue.js";
const te = { class: "app-container" }, oe = { __name: "index", setup(ae) {
  const { globalProjectId: v, globalProject: b } = F(["globalProjectId", "globalProject"]), N = { add: false, edit: false, del: false, download: false }, y = c(), f = c(false), _ = c(false), w = c({}), { crud: s, columns: u, CRUD: P } = G({ title: "外购收货", sort: ["id.desc"], permission: { ...d }, optShow: { ...N }, requiredQuery: ["projectId"], crudApi: { ...O }, hasPagination: true }, y);
  P.HOOK.beforeRefresh = () => (s.query.projectId = v.value || void 0, !!s.query.projectId);
  const C = c([["status", ["parse-enum", Q]], ["receivedTime", "parse-time"]]), { maxHeight: I } = K({ paginate: true, extraHeight: 40 });
  function S(x, o) {
    f.value = true, w.value = x;
  }
  return (x, o) => {
    const h = k("common-button"), l = H, R = L, D = k("common-table"), E = M;
    return t(), j("div", te, [n(e(Y), { projectId: e(v) }, { createBtn: p(() => [e(V)(e(d).createReceive) ? (t(), a(h, { key: 0, size: "default", icon: "el-icon-plus", type: "primary", class: "filter-item", onClick: o[0] || (o[0] = B((r) => _.value = true, ["stop"])) }, { default: p(() => o[3] || (o[3] = [T(" 创建收货 ")])), _: 1, __: [3] })) : i("", true)]), _: 1 }, 8, ["projectId"]), U((t(), a(D, { ref_key: "tableRef", ref: y, data: e(s).data, "data-format": C.value, "empty-text": e(s).emptyText, "max-height": e(I), stripe: false, "row-key": "id", style: { width: "100%" } }, { default: p(() => [n(l, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), e(u).visible("receivedTime") ? (t(), a(l, { key: "receivedTime", prop: "receivedTime", label: "收货日期", align: "center", "min-width": "120", "show-overflow-tooltip": true })) : i("", true), e(u).visible("userName") ? (t(), a(l, { key: "userName", prop: "userName", label: "办理人", align: "center", "show-overflow-tooltip": true })) : i("", true), e(u).visible("supplierName") ? (t(), a(l, { key: "supplierName", prop: "supplierName", label: "供应商", align: "center", "show-overflow-tooltip": true })) : i("", true), e(u).visible("orderSerialNumber") ? (t(), a(l, { key: "orderSerialNumber", prop: "orderSerialNumber", label: "采购合同号", align: "center", "show-overflow-tooltip": true })) : i("", true), e(u).visible("productType") ? (t(), a(l, { key: "productType", prop: "productType", label: "类别", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: p((r) => [(t(true), j($, null, q(e(J)(e(W).getBits(e(g), r.row.productType, "V")), (m) => (t(), a(R, { style: { "margin-right": "5px" }, key: m, type: e(g).V[m].T, effect: "light", "disable-transitions": "" }, { default: p(() => [T(A(e(g).VL[m]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : i("", true), e(V)(e(d).detail) ? (t(), a(l, { key: 5, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: p((r) => [n(h, { size: "default", icon: "el-icon-view", type: "primary", onClick: (m) => S(r.row) }, null, 8, ["onClick"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[E, e(s).loading]]), n(e(X)), n(e(Z), { modelValue: f.value, "onUpdate:modelValue": o[1] || (o[1] = (r) => f.value = r), detailInfo: w.value, permission: e(d), globalProject: e(b) }, null, 8, ["modelValue", "detailInfo", "permission", "globalProject"]), n(ee, { modelValue: _.value, "onUpdate:modelValue": o[2] || (o[2] = (r) => _.value = r), onSuccess: e(s).toQuery, permission: e(d), globalProject: e(b) }, null, 8, ["modelValue", "onSuccess", "permission", "globalProject"])]);
  };
} }, fe = z(oe, [["__scopeId", "data-v-af8d4a9a"]]);
export {
  fe as default
};
