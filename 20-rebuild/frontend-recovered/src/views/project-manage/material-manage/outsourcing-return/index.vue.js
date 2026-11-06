import { ref as m } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as P } from "vue";
import { createVNode as u } from "vue";
import { withCtx as n } from "vue";
import { unref as e } from "vue";
import { createBlock as o } from "vue";
import { withModifiers as I } from "vue";
import { createTextVNode as w } from "vue";
import { createCommentVNode as i } from "vue";
import { withDirectives as z } from "vue";
import { createElementVNode as G } from "vue";
import { toDisplayString as h } from "vue";
import { Fragment as M } from "vue";
import { renderList as O } from "vue";
import { ElTableColumn as W } from "element-plus";
import { ElTag as F } from "element-plus";
import { vLoading as Q } from "element-plus";
import { _ as q, m as K, x as X, o as J, G as v, aN as Y, bv as Z, tS as k, tX as f, P as ee, a as te } from "../../../../shared/runtime.js";
import { c as ae } from "../../../../modules/outsourcing-return-1594aa02.js";
import { C as c } from "../../../../modules/project-19a12d6b.js";
import oe from "./module/header.vue.js";
import ie from "./module/return-detail.vue.js";
import le from "./module/create-return-form.vue.js";
import "../../../../modules/use-table-row-validate-5799de49.js";
import "../../../../modules/index-8edb1b61.js";
import "./module/return-confirm-form.vue.js";
import "../../../../modules/project-select-v3-7c9e02e1.js";
const re = { class: "app-container" }, se = { __name: "index", setup(ne) {
  const { globalProjectId: R, globalProject: V } = K(["globalProjectId", "globalProject"]), D = { add: false, edit: false, del: false, download: false }, x = m(), _ = m(false), b = m(false), T = m({}), N = m(false), U = m([["reviewTime", "parse-time"], ["createTime", "parse-time"]]), { crud: d, columns: p, CRUD: B } = X({ title: "外购退货", sort: ["id.desc"], permission: { ...c }, optShow: { ...D }, invisibleColumns: [""], crudApi: { ...ae }, hasPagination: true }, x);
  B.HOOK.beforeRefresh = () => {
  };
  const { maxHeight: $ } = J({ paginate: true, extraHeight: 40 });
  function S(j, l) {
    _.value = true, T.value = j, N.value = l;
  }
  return (j, l) => {
    const g = E("common-button"), r = W, C = F, A = te, H = E("common-table"), L = Q;
    return a(), P("div", re, [u(e(oe), { projectId: e(R) }, { createBtn: n(() => [e(v)(e(c).createReject) ? (a(), o(g, { key: 0, size: "default", icon: "el-icon-plus", type: "primary", class: "filter-item", onClick: l[0] || (l[0] = I((t) => b.value = true, ["stop"])) }, { default: n(() => l[3] || (l[3] = [w(" 外购退货办理 ")])), _: 1, __: [3] })) : i("", true)]), _: 1 }, 8, ["projectId"]), z((a(), o(H, { ref_key: "tableRef", ref: x, data: e(d).data, "data-format": U.value, "empty-text": e(d).emptyText, "max-height": e($), stripe: false, "row-key": "id", style: { width: "100%" } }, { default: n(() => [u(r, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), e(p).visible("serialNumber") ? (a(), o(r, { key: "serialNumber", prop: "serialNumber", label: "外购退货单", align: "center", "min-width": "120", "show-overflow-tooltip": true })) : i("", true), e(p).visible("project") ? (a(), o(r, { key: "project", prop: "project", label: "项目", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: n(({ row: t }) => {
      var s, y;
      return [G("span", null, h(((s = t == null ? void 0 : t.project) == null ? void 0 : s.serialNumber) + " " + ((y = t == null ? void 0 : t.project) == null ? void 0 : y.name) || "-"), 1)];
    }), _: 1 })) : i("", true), e(p).visible("productType") ? (a(), o(r, { key: "productType", prop: "productType", label: "材料类型", align: "center", "min-width": "180", "show-overflow-tooltip": true }, { default: n((t) => [(a(true), P(M, null, O(e(Y)(e(Z).getBits(e(k), t.row.productType, "V")), (s) => (a(), o(C, { style: { "margin-right": "5px" }, key: s, type: e(k).V[s].T, effect: "light", "disable-transitions": "" }, { default: n(() => [w(h(e(k).VL[s]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : i("", true), e(p).visible("applicantName") ? (a(), o(r, { key: "applicantName", prop: "applicantName", label: "退货人", align: "center", "show-overflow-tooltip": true })) : i("", true), e(p).visible("createTime") ? (a(), o(r, { key: "createTime", prop: "createTime", label: "创建日期", align: "center", "show-overflow-tooltip": true })) : i("", true), e(p).visible("reviewerName") ? (a(), o(r, { key: "reviewerName", prop: "reviewerName", label: "审核人", align: "center", "show-overflow-tooltip": true })) : i("", true), e(p).visible("reviewTime") ? (a(), o(r, { key: "reviewTime", prop: "reviewTime", label: "审核日期", align: "center", "show-overflow-tooltip": true })) : i("", true), e(p).visible("reviewStatus") ? (a(), o(r, { key: "reviewStatus", prop: "reviewStatus", label: "审核状态", align: "center", "show-overflow-tooltip": true }, { default: n(({ row: t }) => {
      var s;
      return [t.reviewStatus === e(f).UNREVIEWED.V && e(v)(e(c).audit) ? (a(), o(g, { key: 0, size: "default", type: "warning", onClick: I((y) => S(t, true), ["stop"]) }, { default: n(() => [u(A, { "icon-class": "wms-auditing" })]), _: 2 }, 1032, ["onClick"])) : i("", true), t.reviewStatus !== e(f).UNREVIEWED.V || t.reviewStatus === e(f).UNREVIEWED.V && !e(v)(e(c).audit) ? (a(), o(C, { key: 1, effect: "plain", type: (s = e(f).V[t.reviewStatus]) == null ? void 0 : s.TAG }, { default: n(() => [w(h(e(f).VL[t.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])) : i("", true)];
    }), _: 1 })) : i("", true), e(v)(e(c).detail) ? (a(), o(r, { key: 8, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: n((t) => [u(g, { size: "default", icon: "el-icon-view", type: "primary", onClick: (s) => S(t.row, false) }, null, 8, ["onClick"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[L, e(d).loading]]), u(e(ee)), u(e(ie), { modelValue: _.value, "onUpdate:modelValue": l[1] || (l[1] = (t) => _.value = t), detailInfo: T.value, permission: e(c), globalProject: e(V), showType: N.value, onSuccess: e(d).toQuery }, null, 8, ["modelValue", "detailInfo", "permission", "globalProject", "showType", "onSuccess"]), u(le, { modelValue: b.value, "onUpdate:modelValue": l[2] || (l[2] = (t) => b.value = t), onSuccess: e(d).toQuery, permission: e(c), globalProject: e(V) }, null, 8, ["modelValue", "onSuccess", "permission", "globalProject"])]);
  };
} }, we = q(se, [["__scopeId", "data-v-21bd81a1"]]);
export {
  we as default
};
