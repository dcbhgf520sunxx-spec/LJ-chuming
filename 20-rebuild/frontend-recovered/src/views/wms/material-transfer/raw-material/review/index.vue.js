import { ref as c } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as z } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as r } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as d } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as i } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as P } from "element-plus";
import { vLoading as $ } from "element-plus";
import { _ as A, uv as K, zd as M, x as G, B7 as T, B8 as L, o as q, kD as h, G as F, aR as W, zh as J, an as Q, P as X, B9 as Y } from "../../../../../shared/runtime.js";
import Z from "./module/header.vue.js";
import ee from "./module/review.vue.js";
import te from "./module/source-text-info.vue.js";
import ae from "./module/direction-text-info.vue.js";
import "../../../../../modules/review-convenient-operate-8438d44b.js";
import "../../../../../modules/review-confirm-button-aa3600ad.js";
import "./module/set-party-a-info.vue.js";
const oe = { class: "app-container" }, re = { __name: "index", setup(ie) {
  const N = { add: false, edit: false, del: false, download: false }, b = c(), S = c([...K, ["approvalComments", "empty-text"], ["transferType", ["parse-enum", M]], ["borrowProject", ["parse-project", { onlyShortName: true }]], ["[source].project", ["parse-project", { onlyShortName: true }]], ["direction.project", ["parse-project", { onlyShortName: true }]]]), { CRUD: R, crud: u, columns: l } = G({ title: "调拨审核", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime"], permission: { ...T }, optShow: { ...N }, crudApi: { ...L } }, b), y = c({}), f = c(false), w = c([]), { maxHeight: U } = q({ paginate: true });
  R.HOOK.handleRefresh = (v, { data: p }) => {
    p.content.forEach((a) => {
      a.reviewable = a.reviewStatus === h.UNREVIEWED.V && F(T.review);
    });
  };
  function D(v) {
    y.value = v, f.value = true;
  }
  return (v, p) => {
    const a = H, g = _("table-cell-tag"), E = _("common-button"), V = P, B = _("common-table"), I = O("parse-time"), j = $;
    return o(), z("div", oe, [s(e(Z)), x((o(), r(B, { ref_key: "tableRef", ref: b, data: e(u).data, "data-format": S.value, "max-height": e(U), "default-expand-all": false, "expand-row-keys": w.value, "row-key": "id", onSortChange: e(u).handleSortChange, onSelectionChange: e(u).selectionChangeHandler }, { default: n(() => [s(W, { data: e(u).data, "expand-row-keys": w.value, "onUpdate:expandRowKeys": p[0] || (p[0] = (t) => w.value = t), "row-key": "id" }, { default: n(({ row: t }) => [d("p", null, [p[2] || (p[2] = C(" 审批意见：")), d("span", null, m(t.approvalComments), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), s(a, { type: "selection", width: "55", align: "center" }), s(a, { label: "序号", type: "index", align: "center", width: "60" }, { default: n(({ row: t, $index: k }) => [t.transferCreateType === e(J).OUTBOUND.V ? (o(), r(g, { key: 0, name: "出库", type: "transferOutbound" })) : i("", true), d("span", null, m(k + 1), 1)]), _: 1 }), e(l).visible("serialNumber") ? (o(), r(a, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", width: "160", label: "调拨单号", align: "left" }, { default: n(({ row: t }) => [t.boolHasUnfreeze ? (o(), r(g, { key: 0, name: "解冻", type: "unfreeze", offset: 15 })) : i("", true), d("span", null, m(t.serialNumber), 1)]), _: 1 })) : i("", true), e(l).visible("basicClass") ? (o(), r(a, { key: "basicClass", "show-overflow-tooltip": true, prop: "basicClass", label: "物料种类", width: "100", align: "center" })) : i("", true), e(l).visible("transferType") ? (o(), r(a, { "show-overflow-tooltip": "", key: "transferType", prop: "transferType", label: "调拨类型", width: "90", align: "center" })) : i("", true), e(l).visible("sourceInfo") ? (o(), r(a, { "show-overflow-tooltip": "", key: "sourceInfo", prop: "sourceInfo", label: "来源", "min-width": "170" }, { default: n(({ row: t }) => [s(te, { "transfer-receipt": t, class: "ellipsis-text" }, null, 8, ["transfer-receipt"])]), _: 1 })) : i("", true), e(l).visible("directionInfo") ? (o(), r(a, { "show-overflow-tooltip": "", key: "directionInfo", prop: "directionInfo", label: "目的", "min-width": "170" }, { default: n(({ row: t }) => [s(ae, { "transfer-receipt": t, class: "ellipsis-text" }, null, 8, ["transfer-receipt"])]), _: 1 })) : i("", true), e(l).visible("applicantName") ? (o(), r(a, { key: "applicantName", "show-overflow-tooltip": true, prop: "applicantName", label: "申请人", align: "center", width: "110" })) : i("", true), e(l).visible("editorName") ? (o(), r(a, { key: "editorName", "show-overflow-tooltip": true, prop: "editorName", label: "编辑人", align: "center", width: "110" })) : i("", true), e(l).visible("reviewerName") ? (o(), r(a, { key: "reviewerName", "show-overflow-tooltip": true, prop: "reviewerName", label: "审核人", align: "center", width: "110" })) : i("", true), e(l).visible("createTime") ? (o(), r(a, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "申请时间", align: "center", width: "140" }, { default: n(({ row: t }) => [x(d("span", null, null, 512), [[I, t.createTime]])]), _: 1 })) : i("", true), e(l).visible("userUpdateTime") ? (o(), r(a, { key: "userUpdateTime", "show-overflow-tooltip": true, prop: "userUpdateTime", label: "编辑时间", align: "center", width: "140" })) : i("", true), e(l).visible("reviewTime") ? (o(), r(a, { key: "reviewTime", "show-overflow-tooltip": true, prop: "reviewTime", label: "审核时间", align: "center", width: "140" })) : i("", true), e(l).visible("reviewStatus") ? (o(), r(a, { key: "reviewStatus", "show-overflow-tooltip": true, prop: "reviewStatus", label: "状态", align: "center", width: "85", fixed: "right" }, { default: n(({ row: t }) => [t.reviewable ? (o(), r(E, { key: 0, type: "warning", icon: "el-icon-stamp", size: "default", onClick: (k) => D(t) }, null, 8, ["onClick"])) : (o(), r(V, { key: 1, type: e(h).V[t.reviewStatus].TAG }, { default: n(() => [C(m(e(h).VL[t.reviewStatus]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })) : i("", true), s(a, { label: "操作", width: "80", align: "center", fixed: "right" }, { default: n(({ row: t }) => [s(Q, { data: t, "show-edit": false, "show-del": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys", "onSortChange", "onSelectionChange"])), [[j, e(u).loading]]), s(e(X)), s(Y), s(ee, { visible: f.value, "onUpdate:visible": p[1] || (p[1] = (t) => f.value = t), data: y.value, onRefresh: e(u).refresh }, null, 8, ["visible", "data", "onRefresh"])]);
  };
} }, we = A(re, [["__scopeId", "data-v-67624136"]]);
export {
  we as default
};
