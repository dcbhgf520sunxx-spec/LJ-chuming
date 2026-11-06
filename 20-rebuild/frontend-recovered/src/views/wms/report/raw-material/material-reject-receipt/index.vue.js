import { ref as d } from "vue";
import { computed as g } from "vue";
import { watch as P } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as _ } from "vue";
import { unref as e } from "vue";
import { createBlock as o } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as c } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as i } from "vue";
import { Fragment as B } from "vue";
import { ElTableColumn as O } from "element-plus";
import { vLoading as M } from "element-plus";
import { b as F, c as H, a as q } from "../../../../../modules/reject-03b2f373.js";
import { Bu as $, D as x, cJ as K, x as L, C3 as N, o as Y, G, aR as I, ux as k, an as J, P as z } from "../../../../../shared/runtime.js";
import Q from "./module/header.vue.js";
import W from "./module/detail.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/closing-time-date-query-82715fa2.js";
const X = { class: "app-container" }, pe = { __name: "index", setup(Z) {
  const C = { add: false, edit: false, del: false, download: false }, m = d([]), f = d(), T = g(() => [...$, ["realTime", "parse-time"], ["rejectTime", "parse-time"], ["rejectAmountExcludingVAT", ["to-thousand", x.YUAN]], ["inboundAmountExcludingVAT", ["to-thousand", x.YUAN]], ["projects", ["parse-project", { onlyShortName: true }]], ["projectsFullName", "parse-project", { source: "projects" }], ["basicClass", ["parse-enum", K, { bit: true, split: " | " }]]]), { crud: n, CRUD: ee, columns: r } = L({ title: "退货记录", sort: ["id.desc"], invisibleColumns: ["applicantName", "reviewerName", "createTime", "reviewTime", "rejectTime"], permission: { ...N }, optShow: { ...C }, crudApi: { get: F, detail: H } }, f), { maxHeight: A } = Y({ paginate: true }), j = g(() => G(N.showAmount)), v = d();
  return P(() => n.query, async () => {
    v.value = await q(n.query);
  }, { deep: true, immutable: true }), (te, p) => {
    const a = O, R = y("table-cell-tag"), D = y("common-table"), V = U("empty-text"), E = M;
    return t(), w("div", X, [s(Q, { DetailsCount: v.value }, null, 8, ["DetailsCount"]), _((t(), o(D, { ref_key: "tableRef", ref: f, data: e(n).data, "data-format": T.value, "default-expand-all": false, "expand-row-keys": m.value, "max-height": e(A), "highlight-current-row": "", "row-key": "id", onSortChange: e(n).handleSortChange, onSelectionChange: e(n).selectionChangeHandler }, { default: u(() => [s(I, { "expand-row-keys": m.value, "onUpdate:expandRowKeys": p[0] || (p[0] = (l) => m.value = l), data: e(n).data, "row-key": "id" }, { default: u(({ row: l }) => [c("p", null, [p[1] || (p[1] = h(" 关联项目：")), c("span", null, b(l.projectsFullName), 1)]), c("p", null, [p[2] || (p[2] = h(" 备注：")), _((t(), w("span", null, [h(b(l.remark), 1)])), [[V]])])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(a, { align: "center", type: "selection", width: "55" }), s(a, { align: "center", label: "序号", type: "index", width: "60" }, { default: u(({ row: l, $index: S }) => [s(R, { offset: 2, show: !!l.boolPrinted, color: "#67c23a", name: "已打印" }, null, 8, ["show"]), c("span", null, b(S + 1), 1)]), _: 1 }), e(r).visible("rejectTime") ? (t(), o(a, { key: "rejectTime", "show-overflow-tooltip": true, prop: "rejectTime", label: "系统退货时间", align: "center", width: "140" })) : i("", true), e(r).visible("serialNumber") ? (t(), o(a, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "退货单号", "min-width": "160", prop: "serialNumber" })) : i("", true), e(r).visible("purchaseOrder.serialNumber") ? (t(), o(a, { key: "purchaseOrder.serialNumber", "show-overflow-tooltip": true, label: "采购合同编号", "min-width": "155", prop: "purchaseOrder.serialNumber" }, { default: u(({ row: l }) => [s(e(k), { receipt: l.purchaseOrder, "receipt-types": ["PURCHASE"] }, null, 8, ["receipt"])]), _: 1 })) : i("", true), e(r).visible("inboundReceipt.serialNumber") ? (t(), o(a, { key: "inboundReceipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "入库单号", "min-width": "160", prop: "inboundReceipt.serialNumber" }, { default: u(({ row: l }) => [s(e(k), { receipt: l.inboundReceipt, "receipt-types": ["INBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : i("", true), e(r).visible("basicClass") ? (t(), o(a, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "120" })) : i("", true), e(r).visible("projects") ? (t(), o(a, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("supplier.name") ? (t(), o(a, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", "min-width": "200", prop: "supplier.name" })) : i("", true), j.value ? (t(), w(B, { key: 7 }, [e(r).visible("inboundAmountExcludingVAT") ? (t(), o(a, { key: "inboundAmountExcludingVAT", "show-overflow-tooltip": true, align: "right", label: "入库金额(不含税)", "min-width": "120", prop: "inboundAmountExcludingVAT" })) : i("", true), e(r).visible("rejectAmountExcludingVAT") ? (t(), o(a, { key: "rejectAmountExcludingVAT", "show-overflow-tooltip": true, align: "right", label: "本次退货金额(不含税)", prop: "rejectAmountExcludingVAT", width: "140" })) : i("", true)], 64)) : i("", true), e(r).visible("applicantName") ? (t(), o(a, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : i("", true), e(r).visible("reviewerName") ? (t(), o(a, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "reviewerName" })) : i("", true), e(r).visible("createTime") ? (t(), o(a, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", width: "140" })) : i("", true), e(r).visible("reviewTime") ? (t(), o(a, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "reviewTime", width: "140" })) : i("", true), s(a, { align: "center", fixed: "right", label: "操作", width: "75px" }, { default: u(({ row: l }) => [s(J, { data: l, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[E, e(n).loading]]), s(e(z)), s(W)]);
  };
} };
export {
  pe as default
};
