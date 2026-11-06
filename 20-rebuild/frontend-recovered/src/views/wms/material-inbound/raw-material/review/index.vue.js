import { ref as d } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as c } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as h } from "vue";
import { createCommentVNode as o } from "vue";
import { Fragment as H } from "vue";
import { renderList as B } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElTag as M } from "element-plus";
import { ElImage as z } from "element-plus";
import { vLoading as F } from "element-plus";
import { _ as G, uv as K, x as O, yC as C, yD as $, o as W, kD as N, G as J, k0 as T, aR as Q, an as X, P as Y } from "../../../../../shared/runtime.js";
import Z from "./module/header.vue.js";
import ee from "./module/detail.vue.js";
import te from "./module/review.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../components/inspection-return-info.vue.js";
import "../../../../../modules/index-e817c507.js";
import "../../../../../modules/review-convenient-operate-8438d44b.js";
import "../../../../../modules/review-confirm-button-aa3600ad.js";
import "../components/warehouse-set-columns.vue.js";
const ae = { class: "app-container" }, ie = { key: 0 }, le = { key: 2 }, oe = { class: "imgs-box" }, se = { __name: "index", setup(re) {
  const R = { add: false, edit: false, del: false, download: false }, x = d(), E = d([...K, ["qualityTestingTime", "parse-time"], ["approvalComments", "empty-text"]]), { CRUD: U, crud: u, columns: s } = O({ title: "入库记录", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime", "shipmentNumber"], permission: { ...C }, optShow: { ...R }, crudApi: { ...$ } }, x), S = d({}), b = d(false), y = d([]), { maxHeight: V } = W({ paginate: true });
  U.HOOK.handleRefresh = (g, { data: r }) => {
    r.content.forEach((t) => {
      var f;
      t.imgUrls = ((f = t.attachments) == null ? void 0 : f.map((m) => m.imageUrl)) || [], t.reviewable = t.reviewStatus === N.UNREVIEWED.V && J(C.review) && !(t.qualityTestingEnum & T.UNREVIEWED.V);
    });
  };
  function q(g) {
    S.value = g, b.value = true;
  }
  return (g, r) => {
    const t = L, f = k("table-cell-tag"), m = M, D = z, P = k("common-button"), A = k("common-table"), I = F;
    return a(), v("div", ae, [n(e(Z)), j((a(), l(A, { ref_key: "tableRef", ref: x, data: e(u).data, "data-format": E.value, "default-expand-all": false, "expand-row-keys": y.value, "max-height": e(V), "row-key": "id", onSortChange: e(u).handleSortChange, onSelectionChange: e(u).selectionChangeHandler }, { default: p(() => [n(Q, { "expand-row-keys": y.value, "onUpdate:expandRowKeys": r[0] || (r[0] = (i) => y.value = i), data: e(u).data, "row-key": "id" }, { default: p(({ row: i }) => [c("p", null, [r[2] || (r[2] = w(" 关联项目：")), c("span", null, h(i.projectsFullName), 1)]), c("p", null, [r[3] || (r[3] = w(" 审批意见：")), c("span", null, h(i.approvalComments), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), n(t, { align: "center", type: "selection", width: "55" }), n(t, { align: "center", label: "序号", type: "index", width: "60" }), e(s).visible("purchaseSN") ? (a(), l(t, { key: "purchaseSN", "show-overflow-tooltip": true, label: "采购合同编号", "min-width": "155", prop: "purchaseSN" }, { default: p(({ row: { sourceRow: i } }) => [n(f, { offset: 10, show: !!i.boolPartyA && !!i.purchaseSN, name: "甲供", type: "partyA" }, null, 8, ["show"]), i.purchaseSN ? (a(), v("span", ie, h(i.purchaseSN), 1)) : o("", true), i.boolPartyA ? (a(), l(m, { key: 1, effect: "dark", size: "default", type: "danger" }, { default: p(() => r[4] || (r[4] = [w("甲供")])), _: 1, __: [4] })) : (a(), v("span", le, "-"))]), _: 1 })) : o("", true), e(s).visible("serialNumber") ? (a(), l(t, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "入库单号", "min-width": "160", prop: "serialNumber" })) : o("", true), e(s).visible("shipmentNumber") ? (a(), l(t, { key: "shipmentNumber", align: "left", label: "物流单号", "min-width": "150", prop: "shipmentNumber", "show-overflow-tooltip": "" })) : o("", true), e(s).visible("basicClass") ? (a(), l(t, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "120" })) : o("", true), e(s).visible("projects") ? (a(), l(t, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : o("", true), e(s).visible("supplier.name") ? (a(), l(t, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", "min-width": "200", prop: "supplier.name" })) : o("", true), e(s).visible("licensePlate") ? (a(), l(t, { key: "licensePlate", "show-overflow-tooltip": true, align: "left", label: "车牌/船牌号", prop: "licensePlate", width: "100" })) : o("", true), e(s).visible("attachments") ? (a(), l(t, { key: "attachments", "show-overflow-tooltip": false, align: "left", label: "质检图片", prop: "attachments", width: "150px" }, { default: p(({ row: { sourceRow: i } }) => [c("div", oe, [(a(true), v(H, null, B(i.attachments, (_) => (a(), l(D, { key: _.id, "initial-index": 1, "preview-src-list": i.imgUrls, src: _.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })) : o("", true), e(s).visible("applicantName") ? (a(), l(t, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : o("", true), e(s).visible("editorName") ? (a(), l(t, { key: "editorName", "show-overflow-tooltip": true, align: "center", label: "编辑人", "min-width": "100", prop: "editorName" })) : o("", true), e(s).visible("qualityTestingUserName") ? (a(), l(t, { key: "qualityTestingUserName", "show-overflow-tooltip": true, align: "center", label: "质检人", "min-width": "100", prop: "qualityTestingUserName" })) : o("", true), e(s).visible("reviewerName") ? (a(), l(t, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "reviewerName" })) : o("", true), e(s).visible("createTime") ? (a(), l(t, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", width: "140" })) : o("", true), e(s).visible("userUpdateTime") ? (a(), l(t, { key: "userUpdateTime", "show-overflow-tooltip": true, align: "center", label: "编辑时间", prop: "userUpdateTime", width: "140" })) : o("", true), e(s).visible("qualityTestingTime") ? (a(), l(t, { key: "qualityTestingTime", "show-overflow-tooltip": true, align: "center", label: "质检时间", prop: "qualityTestingTime", width: "140" })) : o("", true), e(s).visible("reviewTime") ? (a(), l(t, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "reviewTime", width: "140" })) : o("", true), e(s).visible("qualityTestingEnum") ? (a(), l(t, { key: "qualityTestingEnum", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "质检状态", prop: "qualityTestingEnum", width: "100" }, { default: p(({ row: i }) => [n(m, { type: e(T).V[i.qualityTestingEnum].TAG }, { default: p(() => [w(h(e(T).V[i.qualityTestingEnum].SL), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : o("", true), e(s).visible("reviewStatus") ? (a(), l(t, { key: "reviewStatus", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "审核状态", prop: "reviewStatus", width: "80" }, { default: p(({ row: { sourceRow: i } }) => [i.reviewable ? (a(), l(P, { key: 0, icon: "el-icon-stamp", size: "default", type: "warning", onClick: (_) => q(i) }, null, 8, ["onClick"])) : (a(), l(m, { key: 1, type: e(N).V[i.reviewStatus].TAG }, { default: p(() => [w(h(e(N).VL[i.reviewStatus]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })) : o("", true), n(t, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: p(({ row: i }) => [n(X, { data: i, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[I, e(u).loading]]), n(e(Y)), n(ee), n(te, { modelValue: b.value, "onUpdate:modelValue": r[1] || (r[1] = (i) => b.value = i), data: S.value, onRefresh: e(u).refresh }, null, 8, ["modelValue", "data", "onRefresh"])]);
  };
} }, ye = G(se, [["__scopeId", "data-v-c194212f"]]);
export {
  ye as default
};
