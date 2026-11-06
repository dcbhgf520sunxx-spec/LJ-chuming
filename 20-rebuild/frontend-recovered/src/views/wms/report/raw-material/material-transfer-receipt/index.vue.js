import { ref as d } from "vue";
import { computed as O } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as r } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as c } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as i } from "vue";
import { Fragment as $ } from "vue";
import { ElTableColumn as K } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as z, _ as F } from "./module/header.vue.js";
import { _ as Y, uv as q, zd as G, D as T, zh as k, x as L, C8 as w, o as W, kD as J, G as C, aR as Q, an as X, P as Z } from "../../../../../shared/runtime.js";
import ee from "./module/detail.vue.js";
import te from "./module/review.vue.js";
import ae from "../../../material-transfer/raw-material/review/module/source-text-info.vue.js";
import oe from "../../../material-transfer/raw-material/review/module/direction-text-info.vue.js";
import "./module/common-title-info.vue.js";
import "../../../../../modules/review-convenient-operate-8438d44b.js";
import "../../../../../modules/review-confirm-button-aa3600ad.js";
import "./module/set-party-a-info.vue.js";
const re = { class: "app-container" }, ie = { __name: "index", setup(le) {
  const N = { add: false, edit: false, del: false, download: false }, h = d(), R = d([...q, ["approvalComments", "empty-text"], ["transferType", ["parse-enum", G]], ["borrowProject", ["parse-project", { onlyShortName: true }]], ["[source].project", ["parse-project", { onlyShortName: true }]], ["direction.project", ["parse-project", { onlyShortName: true }]], ["amount", ["to-thousand", T.YUAN]], ["amountExcludingVAT", ["to-thousand", T.YUAN]], ["transferCreateType", ["parse-enum", k]]]), { CRUD: S, crud: u, columns: l } = L({ title: "调拨审核", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime"], permission: { ...w }, optShow: { ...N }, crudApi: { ...z } }, h), D = d({}), v = d(false), m = d([]), { maxHeight: E } = W({ paginate: true });
  S.HOOK.handleRefresh = (V, { data: s }) => {
    s.content.forEach((t) => {
      t.reviewable = t.reviewStatus === J.UNREVIEWED.V && C(w.review);
    });
  };
  const U = O(() => C(w.showAmount));
  return (V, s) => {
    const t = K, b = y("table-cell-tag"), A = y("common-table"), I = B("parse-time"), j = M;
    return o(), g("div", re, [n(e(F)), x((o(), r(A, { ref_key: "tableRef", ref: h, data: e(u).data, "data-format": R.value, "max-height": e(E), "default-expand-all": false, "expand-row-keys": m.value, "row-key": "id", onSortChange: e(u).handleSortChange, onSelectionChange: e(u).selectionChangeHandler }, { default: p(() => [n(Q, { data: e(u).data, "expand-row-keys": m.value, "onUpdate:expandRowKeys": s[0] || (s[0] = (a) => m.value = a), "row-key": "id" }, { default: p(({ row: a }) => [c("p", null, [s[2] || (s[2] = H(" 审批意见：")), c("span", null, f(a.approvalComments), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), n(t, { type: "selection", width: "55", align: "center" }), n(t, { label: "序号", type: "index", align: "center", width: "55" }, { default: p(({ row: a, $index: P }) => {
      var _;
      return [((_ = a == null ? void 0 : a.sourceRow) == null ? void 0 : _.transferCreateType) === e(k).OUTBOUND.V ? (o(), r(b, { key: 0, name: "出库", type: "transferOutbound" })) : i("", true), c("span", null, f(P + 1), 1)];
    }), _: 1 }), e(l).visible("serialNumber") ? (o(), r(t, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", width: "150", label: "调拨单号", align: "left" }, { default: p(({ row: a }) => [n(b, { offset: 10, show: !!a.boolPrinted, color: "#67c23a", name: "已打印" }, null, 8, ["show"]), c("span", null, f(a.serialNumber), 1)]), _: 1 })) : i("", true), e(l).visible("basicClass") ? (o(), r(t, { key: "basicClass", "show-overflow-tooltip": true, prop: "basicClass", label: "物料种类", width: "100", align: "center" })) : i("", true), e(l).visible("transferType") ? (o(), r(t, { "show-overflow-tooltip": "", key: "transferType", prop: "transferType", label: "调拨类型", width: "90", align: "center" })) : i("", true), e(l).visible("sourceInfo") ? (o(), r(t, { "show-overflow-tooltip": "", key: "sourceInfo", prop: "sourceInfo", label: "来源", "min-width": "170" }, { default: p(({ row: a }) => [n(ae, { "transfer-receipt": a, class: "ellipsis-text" }, null, 8, ["transfer-receipt"])]), _: 1 })) : i("", true), e(l).visible("directionInfo") ? (o(), r(t, { "show-overflow-tooltip": "", key: "directionInfo", prop: "directionInfo", label: "目的", "min-width": "170" }, { default: p(({ row: a }) => [n(oe, { "transfer-receipt": a, class: "ellipsis-text" }, null, 8, ["transfer-receipt"])]), _: 1 })) : i("", true), U.value ? (o(), g($, { key: 5 }, [e(l).visible("amount") ? (o(), r(t, { key: "amount", "show-overflow-tooltip": true, align: "right", label: "本次调拨金额", "min-width": "120", prop: "amount" })) : i("", true), e(l).visible("amountExcludingVAT") ? (o(), r(t, { key: "amountExcludingVAT", "show-overflow-tooltip": true, align: "right", label: `本次调拨金额
(不含税)`, "min-width": "120", prop: "amountExcludingVAT" })) : i("", true)], 64)) : i("", true), e(l).visible("outboundSn") ? (o(), r(t, { key: "outboundSn", "show-overflow-tooltip": true, prop: "outboundSn", width: "130", label: "关联出库单号", align: "left" })) : i("", true), e(l).visible("transferCreateType") ? (o(), r(t, { key: "transferCreateType", "show-overflow-tooltip": true, prop: "transferCreateType", width: "110", label: "创建类型", align: "left" })) : i("", true), e(l).visible("applicantName") ? (o(), r(t, { key: "applicantName", "show-overflow-tooltip": true, prop: "applicantName", label: "申请人", align: "center", width: "100" })) : i("", true), e(l).visible("editorName") ? (o(), r(t, { key: "editorName", "show-overflow-tooltip": true, prop: "editorName", label: "编辑人", align: "center", width: "100" })) : i("", true), e(l).visible("reviewerName") ? (o(), r(t, { key: "reviewerName", "show-overflow-tooltip": true, prop: "reviewerName", label: "审核人", align: "center", width: "110" })) : i("", true), e(l).visible("createTime") ? (o(), r(t, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "申请时间", align: "center", width: "140" }, { default: p(({ row: a }) => [x(c("span", null, null, 512), [[I, a.createTime]])]), _: 1 })) : i("", true), e(l).visible("userUpdateTime") ? (o(), r(t, { key: "userUpdateTime", "show-overflow-tooltip": true, prop: "userUpdateTime", label: "编辑时间", align: "center", width: "140" })) : i("", true), e(l).visible("reviewTime") ? (o(), r(t, { key: "reviewTime", "show-overflow-tooltip": true, prop: "reviewTime", label: "审核时间", align: "center", width: "140" })) : i("", true), n(t, { label: "操作", width: "80", align: "center", fixed: "right" }, { default: p(({ row: a }) => [n(X, { data: a, "show-edit": false, "show-del": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys", "onSortChange", "onSelectionChange"])), [[j, e(u).loading]]), n(e(Z)), n(ee), n(te, { visible: v.value, "onUpdate:visible": s[1] || (s[1] = (a) => v.value = a), data: D.value, onRefresh: e(u).refresh }, null, 8, ["visible", "data", "onRefresh"])]);
  };
} }, be = Y(ie, [["__scopeId", "data-v-cd7aae7f"]]);
export {
  be as default
};
