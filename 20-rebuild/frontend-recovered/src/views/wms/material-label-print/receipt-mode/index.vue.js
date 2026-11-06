import { inject as P } from "vue";
import { ref as d } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as r } from "vue";
import { withCtx as m } from "vue";
import { createElementVNode as E } from "vue";
import { toDisplayString as H } from "vue";
import { createCommentVNode as n } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as j } from "element-plus";
import { c as A } from "../../../../modules/receipt-mode-c54e9044.js";
import { uv as L, vx as V, x as $, o as F, cO as I, jl as K, ux as q, an as z, P as G } from "../../../../shared/runtime.js";
import J from "./module/detail.vue.js";
import { _ as Q, u as W } from "./module/header.vue.js";
import { u as X } from "../../../../modules/use-print-d47bc68b.js";
import "../../../../modules/material-print-button-3ec7d08d.js";
import "../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../modules/popover-confirm-35927771.js";
import "../../../../modules/warehouse-project-cascader-17e2b952.js";
const Y = { class: "app-container" }, pe = { __name: "index", emits: ["printed-success"], setup(Z, { emit: b }) {
  const _ = b, g = { batchAdd: false, add: false, edit: false, del: false, download: false }, v = P("permission"), y = d([]), f = d(), C = d([...L, ["receipt.receiptType", ["parse-enum", V, { f: "DOC" }]]]), { CRUD: h, crud: i, columns: s } = $({ title: "打印标签-单据模式", sort: ["id.desc"], invisibleColumns: ["warehouse"], permission: { ...v }, optShow: { ...g }, crudApi: { ...A } }, f);
  i.props.copies = 1;
  const { print: N } = X(), { getDetailMaterialList: x } = W(), { maxHeight: k } = F({ paginate: true, extraHeight: 60 });
  h.HOOK.beforeRefresh = () => {
    _("printed-success");
  }, h.HOOK.handleRefresh = async (c, { data: p }) => {
    await I(p.content), p.content = await K(p.content, { toSmallest: false, toNum: false });
  };
  async function R(c) {
    await N(() => x(c.id), i.props.copies), c.pendingPrintedMaterialNumber > 0 && i.refresh();
  }
  return (c, p) => {
    const t = U, T = u("table-cell-tag"), D = u("common-button"), O = u("common-table"), S = j;
    return o(), B("div", Y, [a(e(Q)), M((o(), r(O, { key: `material_label_print_receipt_mode_${e(i).query.basicClass}`, ref_key: "tableRef", ref: f, data: e(i).data, "data-format": C.value, "max-height": e(k), "default-expand-all": false, "expand-row-keys": y.value, "row-key": "id", onSortChange: e(i).handleSortChange, onSelectionChange: e(i).selectionChangeHandler }, { default: m(() => [a(t, { type: "selection", width: "55", align: "center", fixed: "left" }), a(t, { label: "序号", type: "index", align: "center", width: "55", fixed: "left" }, { default: m(({ row: l, $index: w }) => [a(T, { show: l.pendingPrintedMaterialNumber === 0, name: "已打印", type: "printed" }, null, 8, ["show"]), E("span", null, H(w + 1), 1)]), _: 1 }), e(s).visible("receipt.receiptType") ? (o(), r(t, { key: "receipt.receiptType", "show-overflow-tooltip": true, prop: "receipt.receiptType", width: "120", label: "单据类型", align: "center" })) : n("", true), e(s).visible("receipt.serialNumber") ? (o(), r(t, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", "min-width": "120", label: "单据编号", align: "left" }, { default: m(({ row: { sourceRow: l } }) => [a(e(q), { "receipt-types": ["INBOUND", "OUTBOUND", "TRANSFER", "RETURN", "CONVERT"], receipt: l.receipt }, null, 8, ["receipt"])]), _: 1 })) : n("", true), e(s).visible("basicClass") ? (o(), r(t, { key: "basicClass", "show-overflow-tooltip": true, prop: "basicClass", label: "物料种类", "min-width": "120" })) : n("", true), e(s).visible("projects") ? (o(), r(t, { "show-overflow-tooltip": "", key: "projects", prop: "projects", label: "关联项目", "min-width": "170" })) : n("", true), e(s).visible("pendingPrintedMaterialNumber") ? (o(), r(t, { key: "pendingPrintedMaterialNumber", "show-overflow-tooltip": true, prop: "pendingPrintedMaterialNumber", label: "未打印物料数量", align: "center", width: "120" })) : n("", true), e(s).visible("reviewerName") ? (o(), r(t, { key: "reviewerName", "show-overflow-tooltip": true, prop: "reviewerName", label: "审核人", align: "center", width: "120" })) : n("", true), e(s).visible("createTime") ? (o(), r(t, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "创建日期", align: "center", width: "130", sortable: "custom" })) : n("", true), a(t, { label: "操作", width: "130", align: "center", fixed: "right" }, { default: m(({ row: { sourceRow: l } }) => [a(z, { "show-detail": "", "show-edit": false, "show-del": false, data: l }, null, 8, ["data"]), a(D, { icon: "el-icon-printer", type: "success", size: "default", onClick: (w) => R(l) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys", "onSortChange", "onSelectionChange"])), [[S, e(i).loading]]), a(e(G)), a(J)]);
  };
} };
export {
  pe as default
};
