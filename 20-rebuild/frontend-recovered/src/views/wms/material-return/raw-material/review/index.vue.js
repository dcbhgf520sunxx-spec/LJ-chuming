import { ref as m } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as G } from "vue";
import { createBlock as l } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as d } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as H } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as $ } from "element-plus";
import { vLoading as F } from "element-plus";
import { uv as K, AX as q, x as z, AY as C, AU as I, o as W, kD as X, G as Y, aR as Z, ux as N, gG as _, xs as T, ib as V, an as J, P as Q, AZ as ee } from "../../../../../shared/runtime.js";
import te from "./module/header.vue.js";
import ae from "./module/review.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/use-continuous-review-34fb5c14.js";
import "../../../../../modules/review-convenient-operate-8438d44b.js";
import "../../../../../modules/review-confirm-button-aa3600ad.js";
const oe = { class: "app-container" }, ce = { __name: "index", setup(le) {
  const U = { add: false, edit: false, del: false, download: false }, k = m({}), b = m(false), f = m([]), R = m(), E = m([...K, ["approvalComments", "empty-text"], ["boolRealReturn", ["parse-enum", q]]]), { CRUD: D, crud: p, columns: i } = z({ title: "退库审核", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime"], permission: { ...C }, optShow: { ...U }, crudApi: { ...I } }, R), { maxHeight: L } = W({ paginate: true });
  D.HOOK.handleRefresh = (h, { data: n }) => {
    n.content.forEach((a) => {
      a.reviewable = a.reviewStatus === X.UNREVIEWED.V && Y(C.review);
    });
  };
  function O(h) {
    k.value = h, b.value = true;
  }
  return (h, n) => {
    const a = M, A = y("table-cell-tag"), B = y("common-button"), S = $, j = y("common-table"), P = F;
    return o(), x("div", oe, [r(e(te)), G((o(), l(j, { ref_key: "tableRef", ref: R, data: e(p).data, "data-format": E.value, "default-expand-all": false, "expand-row-keys": f.value, "max-height": e(L), "row-key": "id", onSortChange: e(p).handleSortChange, onSelectionChange: e(p).selectionChangeHandler }, { default: u(() => [r(Z, { "expand-row-keys": f.value, "onUpdate:expandRowKeys": n[0] || (n[0] = (t) => f.value = t), data: e(p).data, "row-key": "id" }, { default: u(({ row: t }) => [d("p", null, [n[2] || (n[2] = c(" 关联项目：")), d("span", null, w(t.projectsFullName), 1)]), d("p", null, [n[3] || (n[3] = c(" 关联出库单： ")), r(e(N), { receipt: t.outboundList, "receipt-types": ["OUTBOUND"] }, null, 8, ["receipt"])]), d("p", null, [n[4] || (n[4] = c(" 审批意见：")), d("span", null, w(t.approvalComments), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), r(a, { align: "center", type: "selection", width: "55" }), r(a, { align: "center", label: "序号", type: "index", width: "60" }, { default: u(({ row: t, $index: v }) => {
      var g;
      return [r(A, { color: (g = e(_).V[t.outboundTypeSelection]) == null ? void 0 : g.COLOR, name: e(_).VL[t.outboundTypeSelection] }, null, 8, ["color", "name"]), d("span", null, w(v + 1), 1)];
    }), _: 1 }), e(i).visible("serialNumber") ? (o(), l(a, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "退库单号", "min-width": "160", prop: "serialNumber" })) : s("", true), e(i).visible("basicClass") ? (o(), l(a, { key: "basicClass", "show-overflow-tooltip": true, align: "center", label: "物料种类", prop: "basicClass", width: "80" })) : s("", true), e(i).visible("projects") ? (o(), l(a, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : s("", true), e(i).visible("outboundSNList") ? (o(), l(a, { key: "outboundSNList", "show-overflow-tooltip": true, label: "关联出库单", "min-width": "155", prop: "outboundSNList" }, { default: u(({ row: t }) => [r(e(N), { receipt: t.outboundList, "receipt-types": ["OUTBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : s("", true), e(i).visible("boolRealReturn") ? (o(), l(a, { key: "boolRealReturn", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "状态", prop: "boolRealReturn", width: "80" })) : s("", true), e(i).visible("applicantName") ? (o(), l(a, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : s("", true), e(i).visible("editorName") ? (o(), l(a, { key: "editorName", "show-overflow-tooltip": true, align: "center", label: "编辑人", "min-width": "100", prop: "editorName" })) : s("", true), e(i).visible("reviewerName") ? (o(), l(a, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "reviewerName" })) : s("", true), e(i).visible("createTime") ? (o(), l(a, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "创建时间", prop: "createTime", width: "140" })) : s("", true), e(i).visible("userUpdateTime") ? (o(), l(a, { key: "userUpdateTime", "show-overflow-tooltip": true, align: "center", label: "编辑时间", prop: "userUpdateTime", width: "140" })) : s("", true), e(i).visible("reviewTime") ? (o(), l(a, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "reviewTime", width: "140" })) : s("", true), e(i).visible("reviewStatus") ? (o(), l(a, { key: "reviewStatus", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "状态", prop: "reviewStatus", width: "80" }, { default: u(({ row: t }) => {
      var v;
      return [t.reviewable ? (o(), l(B, { key: 0, icon: "el-icon-s-check", size: "default", type: "warning", onClick: (g) => O(t) }, null, 8, ["onClick"])) : (o(), x(H, { key: 1 }, [t.outboundTypeSelection === e(_).PRODUCE.V ? (o(), l(S, { key: 0, type: (v = e(T).V[t.reviewStatus]) == null ? void 0 : v.TAG }, { default: u(() => [c(w(e(T).VL[t.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])) : (o(), l(S, { key: 1, type: e(V).V[t.reviewStatus].TAG }, { default: u(() => [c(w(e(V).VL[t.reviewStatus]), 1)]), _: 2 }, 1032, ["type"]))], 64))];
    }), _: 1 })) : s("", true), r(a, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: u(({ row: t }) => [r(J, { data: t, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[P, e(p).loading]]), r(e(Q)), r(ee), r(ae, { modelValue: b.value, "onUpdate:modelValue": n[1] || (n[1] = (t) => b.value = t), data: k.value, onRefresh: e(p).refresh }, null, 8, ["modelValue", "data", "onRefresh"])]);
  };
} };
export {
  ce as default
};
