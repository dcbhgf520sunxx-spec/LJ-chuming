import { ref as m } from "vue";
import { computed as P } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as d } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as i } from "vue";
import { Fragment as H } from "vue";
import { ElTableColumn as M } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as K, _ as Y } from "./module/header.vue.js";
import { uv as $, AX as G, D as k, x as q, AY as h, o as I, kD as W, G as x, aR as X, ux as R, gG as C, an as z, P as J } from "../../../../../shared/runtime.js";
import Q from "./module/detail.vue.js";
import Z from "./module/review.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "./module/material-unit-quantity-columns/index.vue.js";
import "./module/material-unit-quantity-columns/module/raw-mat.vue.js";
import "../../../../../modules/use-continuous-review-34fb5c14.js";
import "../../../../../modules/review-convenient-operate-8438d44b.js";
import "../../../../../modules/review-confirm-button-aa3600ad.js";
const ee = { class: "app-container" }, ce = { __name: "index", setup(te) {
  const S = { add: false, edit: false, del: false, download: false }, T = m({}), f = m(false), b = m([]), v = m(), V = m([...$, ["approvalComments", "empty-text"], ["boolRealReturn", ["parse-enum", G]], ["amount", ["to-thousand", k.YUAN]], ["amountExcludingVat", ["to-thousand", k.YUAN]]]), { CRUD: U, crud: u, columns: r } = q({ title: "退库审核", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime"], permission: { ...h }, optShow: { ...S }, crudApi: { ...K } }, v), { maxHeight: D } = I({ paginate: true });
  U.HOOK.handleRefresh = (O, { data: s }) => {
    s.content.forEach((t) => {
      t.reviewable = t.reviewStatus === W.UNREVIEWED.V && x(h.review);
    });
  };
  const E = P(() => x(h.showAmount));
  return (O, s) => {
    const t = M, g = N("table-cell-tag"), A = N("common-table"), L = F;
    return a(), _("div", ee, [n(e(Y)), j((a(), l(A, { ref_key: "tableRef", ref: v, data: e(u).data, "data-format": V.value, "default-expand-all": false, "expand-row-keys": b.value, "max-height": e(D), "row-key": "id", onSortChange: e(u).handleSortChange, onSelectionChange: e(u).selectionChangeHandler }, { default: p(() => [n(X, { "expand-row-keys": b.value, "onUpdate:expandRowKeys": s[0] || (s[0] = (o) => b.value = o), data: e(u).data, "row-key": "id" }, { default: p(({ row: o }) => [d("p", null, [s[2] || (s[2] = c(" 关联项目：")), d("span", null, w(o.projectsFullName), 1)]), d("p", null, [s[3] || (s[3] = c(" 关联出库单： ")), n(e(R), { receipt: o.outboundList, "receipt-types": ["OUTBOUND"] }, null, 8, ["receipt"])]), d("p", null, [s[4] || (s[4] = c(" 审批意见：")), d("span", null, w(o.approvalComments), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), n(t, { align: "center", type: "selection", width: "55" }), n(t, { align: "center", label: "序号", type: "index", width: "60" }, { default: p(({ row: o, $index: B }) => {
      var y;
      return [n(g, { color: (y = e(C).V[o.outboundTypeSelection]) == null ? void 0 : y.COLOR, name: e(C).VL[o.outboundTypeSelection] }, null, 8, ["color", "name"]), d("span", null, w(B + 1), 1)];
    }), _: 1 }), e(r).visible("serialNumber") ? (a(), l(t, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "退库单号", "min-width": "160", prop: "serialNumber" }, { default: p(({ row: o }) => [n(g, { offset: 10, show: !!o.boolPrinted, color: "#67c23a", name: "已打印" }, null, 8, ["show"]), c(" " + w(o.serialNumber), 1)]), _: 1 })) : i("", true), e(r).visible("basicClass") ? (a(), l(t, { key: "basicClass", "show-overflow-tooltip": true, align: "center", label: "物料种类", prop: "basicClass", width: "80" })) : i("", true), e(r).visible("projects") ? (a(), l(t, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("outboundSNList") ? (a(), l(t, { key: "outboundSNList", "show-overflow-tooltip": true, label: "关联出库单", "min-width": "155", prop: "outboundSNList" }, { default: p(({ row: o }) => [n(e(R), { receipt: o.outboundList, "receipt-types": ["OUTBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : i("", true), e(r).visible("boolRealReturn") ? (a(), l(t, { key: "boolRealReturn", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "状态", prop: "boolRealReturn", width: "80" })) : i("", true), E.value ? (a(), _(H, { key: 5 }, [e(r).visible("amount") ? (a(), l(t, { key: "amount", "show-overflow-tooltip": true, align: "right", label: "本次退库金额", "min-width": "120", prop: "amount" })) : i("", true), e(r).visible("amountExcludingVat") ? (a(), l(t, { key: "amountExcludingVat", "show-overflow-tooltip": true, align: "right", label: "本次退库金额(不含税)", "min-width": "120", prop: "amountExcludingVat" })) : i("", true)], 64)) : i("", true), e(r).visible("applicantName") ? (a(), l(t, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : i("", true), e(r).visible("editorName") ? (a(), l(t, { key: "editorName", "show-overflow-tooltip": true, align: "center", label: "编辑人", "min-width": "100", prop: "editorName" })) : i("", true), e(r).visible("reviewerName") ? (a(), l(t, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "reviewerName" })) : i("", true), e(r).visible("createTime") ? (a(), l(t, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "创建时间", prop: "createTime", width: "140" })) : i("", true), e(r).visible("userUpdateTime") ? (a(), l(t, { key: "userUpdateTime", "show-overflow-tooltip": true, align: "center", label: "编辑时间", prop: "userUpdateTime", width: "140" })) : i("", true), e(r).visible("reviewTime") ? (a(), l(t, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "reviewTime", width: "140" })) : i("", true), n(t, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: p(({ row: o }) => [n(z, { data: o, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[L, e(u).loading]]), n(e(J)), n(Q), n(Z, { modelValue: f.value, "onUpdate:modelValue": s[1] || (s[1] = (o) => f.value = o), data: T.value, onRefresh: e(u).refresh }, null, 8, ["modelValue", "data", "onRefresh"])]);
  };
} };
export {
  ce as default
};
