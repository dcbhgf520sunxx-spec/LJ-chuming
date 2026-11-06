import { ref as f } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as E } from "vue";
import { unref as e } from "vue";
import { createBlock as r } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as u } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as i } from "vue";
import { ElTableColumn as V } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as B } from "element-plus";
import { l as h, uv as U, x as A, AL as H, o as M, aR as P, i as $, ux as N, ib as v, an as L, P as z } from "../../../../../shared/runtime.js";
import F from "./module/header.vue.js";
import I from "./module/detail.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
function K(d) {
  return h({ module: "wms", url: "reject/application/record/raw-materials", method: "get", params: d });
}
function q(d) {
  return h({ module: "wms", url: "reject/application/record/raw-materials", method: "delete", data: d });
}
function G(d) {
  return h({ module: "wms", url: `reject/application/record/raw-materials/${d}`, method: "get" });
}
const W = { get: K, del: q, detail: G }, J = { class: "app-container" }, Q = { key: 1 }, re = { __name: "index", setup(d) {
  const x = { add: false, edit: false, del: false, download: false }, w = f([]), _ = f(), R = f([...U, ["remark", "empty-text"], ["approvalComments", "empty-text"]]), { crud: b, columns: o } = A({ title: "退货记录", sort: ["id.desc"], invisibleColumns: ["reviewTime"], permission: { ...H }, optShow: { ...x }, crudApi: { ...W } }, _), { maxHeight: C } = M({ paginate: true });
  return (X, n) => {
    const l = V, S = g("table-cell-tag"), T = O, j = g("common-table"), D = B;
    return a(), k("div", J, [s(F), E((a(), r(j, { ref_key: "tableRef", ref: _, data: e(b).data, "data-format": R.value, "max-height": e(C), "default-expand-all": false, "expand-row-keys": w.value, "row-key": "id" }, { default: p(() => [s(P, { data: e(b).data, "expand-row-keys": w.value, "onUpdate:expandRowKeys": n[0] || (n[0] = (t) => w.value = t), "row-key": "id" }, { default: p(({ row: t }) => [u("p", null, [n[1] || (n[1] = c(" 退货关联项目：")), u("span", null, m(t.projectsFullName), 1)]), u("p", null, [n[2] || (n[2] = c(" 备注：")), u("span", null, m(t.remark), 1)]), u("p", null, [n[3] || (n[3] = c(" 审批意见：")), u("span", null, m(t.approvalComments), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), s(l, { label: "序号", type: "index", align: "center", width: "60" }), e(o).visible("serialNumber") ? (a(), r(l, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", "min-width": "160", label: "退货单号", align: "left" }, { default: p(({ row: t }) => [t.boolHasUnfreeze ? (a(), r(S, { key: 0, name: "解冻", type: "unfreeze", offset: 15 })) : i("", true), u("span", null, m(t.serialNumber), 1)]), _: 1 })) : i("", true), e(o).visible("purchaseOrder.serialNumber") ? (a(), r(l, { key: "purchaseOrder.serialNumber", "show-overflow-tooltip": true, prop: "purchaseOrder.serialNumber", label: "采购合同编号", "min-width": "155" }, { default: p(({ row: t }) => {
      var y;
      return [e($)((y = t.purchaseOrder) == null ? void 0 : y.id) ? (a(), r(e(N), { key: 0, "receipt-types": ["PURCHASE"], receipt: t.purchaseOrder }, null, 8, ["receipt"])) : (a(), k("span", Q, "-"))];
    }), _: 1 })) : i("", true), e(o).visible("inboundReceipt.serialNumber") ? (a(), r(l, { key: "inboundReceipt.serialNumber", "show-overflow-tooltip": true, prop: "inboundReceipt.serialNumber", "min-width": "160", label: "入库单号", align: "left" }, { default: p(({ row: t }) => [s(e(N), { "receipt-types": ["INBOUND"], receipt: t.inboundReceipt }, null, 8, ["receipt"])]), _: 1 })) : i("", true), e(o).visible("basicClass") ? (a(), r(l, { key: "basicClass", "show-overflow-tooltip": true, prop: "basicClass", label: "退货物料种类", width: "120" })) : i("", true), e(o).visible("projects") ? (a(), r(l, { "show-overflow-tooltip": "", key: "projects", prop: "projects", label: "退货关联项目", "min-width": "170" })) : i("", true), e(o).visible("supplier.name") ? (a(), r(l, { key: "supplier.name", "show-overflow-tooltip": true, prop: "supplier.name", label: "供应商", "min-width": "200" })) : i("", true), e(o).visible("applicantName") ? (a(), r(l, { key: "applicantName", "show-overflow-tooltip": true, prop: "applicantName", label: "申请人", align: "center", "min-width": "100" })) : i("", true), e(o).visible("reviewerName") ? (a(), r(l, { key: "reviewerName", "show-overflow-tooltip": true, prop: "reviewerName", label: "审核人", align: "center", "min-width": "100" })) : i("", true), e(o).visible("createTime") ? (a(), r(l, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "申请时间", align: "center", width: "140" })) : i("", true), e(o).visible("reviewTime") ? (a(), r(l, { key: "reviewTime", "show-overflow-tooltip": true, prop: "reviewTime", label: "审核时间", align: "center", width: "140" })) : i("", true), e(o).visible("reviewStatus") ? (a(), r(l, { key: "reviewStatus", "show-overflow-tooltip": true, prop: "reviewStatus", label: "状态", align: "center", fixed: "right" }, { default: p(({ row: t }) => [s(T, { type: e(v).V[t.reviewStatus].TAG }, { default: p(() => [c(m(e(v).VL[t.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : i("", true), s(l, { label: "操作", width: "120px", align: "center", fixed: "right" }, { default: p(({ row: t }) => [s(L, { "disabled-del": t.reviewStatus !== e(v).UNREVIEWED.V, data: t, "show-edit": false, "show-detail": "" }, null, 8, ["disabled-del", "data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])), [[D, e(b).loading]]), s(e(z)), s(I)]);
  };
} };
export {
  re as default
};
