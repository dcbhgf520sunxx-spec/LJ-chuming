import { ref as m } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as i } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as u } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as o } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElTag as B } from "element-plus";
import { vLoading as H } from "element-plus";
import { uv as M, x as P, AM as _, AN as K, o as $, kD as z, G as F, aR as G, i as I, ux as k, ib as N, an as L, P as q, AO as W } from "../../../../../shared/runtime.js";
import J from "./module/header.vue.js";
import Q from "./module/review.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/review-convenient-operate-8438d44b.js";
import "../../../../../modules/review-confirm-button-aa3600ad.js";
import "../../../../../modules/use-continuous-review-34fb5c14.js";
const X = { class: "app-container" }, Y = { key: 1 }, ne = { __name: "index", setup(Z) {
  const x = { add: false, edit: false, del: false, download: false }, f = m([]), R = m({}), v = m(false), b = m(), C = m([...M, ["remark", "empty-text"], ["approvalComments", "empty-text"]]), { CRUD: S, crud: d, columns: s } = P({ title: "退货审核", sort: ["id.desc"], invisibleColumns: ["reviewTime"], permission: { ..._ }, optShow: { ...x }, crudApi: { ...K } }, b), { maxHeight: V } = $({ paginate: true });
  return S.HOOK.handleRefresh = (T, { data: r }) => {
    r.content.forEach((a) => {
      a.reviewable = a.reviewStatus === z.UNREVIEWED.V && F(_.review);
    });
  }, (T, r) => {
    const a = j, D = g("table-cell-tag"), E = B, O = g("common-table"), U = H;
    return l(), y("div", X, [n(e(J)), A((l(), i(O, { ref_key: "tableRef", ref: b, data: e(d).data, "data-format": C.value, "default-expand-all": false, "expand-row-keys": f.value, "max-height": e(V), "row-key": "id", onSortChange: e(d).handleSortChange, onSelectionChange: e(d).selectionChangeHandler }, { default: p(() => [n(G, { "expand-row-keys": f.value, "onUpdate:expandRowKeys": r[0] || (r[0] = (t) => f.value = t), data: e(d).data, "row-key": "id" }, { default: p(({ row: t }) => [u("p", null, [r[2] || (r[2] = w(" 退货关联项目：")), u("span", null, c(t.projectsFullName), 1)]), u("p", null, [r[3] || (r[3] = w(" 备注：")), u("span", null, c(t.remark), 1)]), u("p", null, [r[4] || (r[4] = w(" 审批意见：")), u("span", null, c(t.approvalComments), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), n(a, { align: "center", type: "selection", width: "55" }), n(a, { align: "center", label: "序号", type: "index", width: "60" }), e(s).visible("serialNumber") ? (l(), i(a, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "退货单号", "min-width": "160", prop: "serialNumber" }, { default: p(({ row: t }) => [t.boolHasUnfreeze ? (l(), i(D, { key: 0, offset: 15, name: "解冻", type: "unfreeze" })) : o("", true), u("span", null, c(t.serialNumber), 1)]), _: 1 })) : o("", true), e(s).visible("purchaseOrder.serialNumber") ? (l(), i(a, { key: "purchaseOrder.serialNumber", "show-overflow-tooltip": true, label: "采购合同编号", "min-width": "155", prop: "purchaseOrder.serialNumber" }, { default: p(({ row: t }) => {
      var h;
      return [e(I)((h = t.purchaseOrder) == null ? void 0 : h.id) ? (l(), i(e(k), { key: 0, "receipt-types": ["PURCHASE"], receipt: t.purchaseOrder }, null, 8, ["receipt"])) : (l(), y("span", Y, "-"))];
    }), _: 1 })) : o("", true), e(s).visible("inboundReceipt.serialNumber") ? (l(), i(a, { key: "inboundReceipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "入库单号", "min-width": "160", prop: "inboundReceipt.serialNumber" }, { default: p(({ row: t }) => [n(e(k), { receipt: t.inboundReceipt, "receipt-types": ["INBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : o("", true), e(s).visible("basicClass") ? (l(), i(a, { key: "basicClass", "show-overflow-tooltip": true, label: "退货物料种类", prop: "basicClass", width: "120" })) : o("", true), e(s).visible("projects") ? (l(), i(a, { key: "projects", label: "退货关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : o("", true), e(s).visible("supplier.name") ? (l(), i(a, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", "min-width": "200", prop: "supplier.name" })) : o("", true), e(s).visible("applicantName") ? (l(), i(a, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : o("", true), e(s).visible("reviewerName") ? (l(), i(a, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "reviewerName" })) : o("", true), e(s).visible("createTime") ? (l(), i(a, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", width: "140" })) : o("", true), e(s).visible("reviewTime") ? (l(), i(a, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "reviewTime", width: "140" })) : o("", true), e(s).visible("reviewStatus") ? (l(), i(a, { key: "reviewStatus", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "状态", prop: "reviewStatus", width: "85" }, { default: p(({ row: t }) => [n(E, { type: e(N).V[t.reviewStatus].TAG }, { default: p(() => [w(c(e(N).VL[t.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : o("", true), n(a, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: p(({ row: t }) => [n(L, { data: t, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[U, e(d).loading]]), n(e(q)), n(W), n(Q, { modelValue: v.value, "onUpdate:modelValue": r[1] || (r[1] = (t) => v.value = t), data: R.value, onRefresh: e(d).refresh }, null, 8, ["modelValue", "data", "onRefresh"])]);
  };
} };
export {
  ne as default
};
