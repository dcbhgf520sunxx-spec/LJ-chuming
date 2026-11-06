import { inject as S } from "vue";
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
import { c as I } from "../../../../../../modules/receipt-mode-V2-8c051f68.js";
import { uv as V, vx as A, x as F, o as L, cO as $, jl as K, ux as q, an as z, P as G } from "../../../../../../shared/runtime.js";
import Y from "./module/detail.vue.js";
import { _ as J, u as Q } from "./module/header.vue.js";
import { u as W } from "../../../../../../modules/use-print-4d7e67fe.js";
import "../../../../../../modules/material-print-button-3ec7d08d.js";
import "../../../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../../../modules/popover-confirm-35927771.js";
import "../../../../../../modules/receipt-mode-c54e9044.js";
import "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const X = { class: "app-container" }, me = { __name: "index", emits: ["printed-success"], setup(Z, { emit: b }) {
  const _ = b, g = { batchAdd: false, add: false, edit: false, del: false, download: false }, v = S("permission"), y = d([]), f = d(), C = d([...V, ["receipt.receiptType", ["parse-enum", A, { f: "DOC" }]]]), { CRUD: h, crud: i, columns: s } = F({ title: "打印标签-单据模式", sort: ["id.desc"], invisibleColumns: ["warehouse"], permission: { ...v }, optShow: { ...g }, crudApi: { ...I } }, f);
  i.props.copies = 1;
  const { print: N } = W(), { getDetailMaterialList: x } = Q(), { maxHeight: k } = L({ paginate: true, extraHeight: 60 });
  h.HOOK.beforeRefresh = () => {
    _("printed-success");
  }, h.HOOK.handleRefresh = async (c, { data: p }) => {
    await $(p.content), p.content = await K(p.content, { toSmallest: false, toNum: false });
  };
  async function R(c) {
    await N(() => x(c.id), i.props.copies), c.pendingPrintedMaterialNumber > 0 && i.refresh();
  }
  return (c, p) => {
    const t = U, T = u("table-cell-tag"), O = u("common-button"), D = u("common-table"), P = j;
    return o(), B("div", X, [a(e(J)), M((o(), r(D, { key: `material_label_print_receipt_mode_${e(i).query.basicClass}`, ref_key: "tableRef", ref: f, data: e(i).data, "data-format": C.value, "default-expand-all": false, "expand-row-keys": y.value, "max-height": e(k), "row-key": "id", onSortChange: e(i).handleSortChange, onSelectionChange: e(i).selectionChangeHandler }, { default: m(() => [a(t, { align: "center", fixed: "left", type: "selection", width: "55" }), a(t, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: m(({ row: l, $index: w }) => [a(T, { show: l.pendingPrintedMaterialNumber === 0, name: "已打印", type: "printed" }, null, 8, ["show"]), E("span", null, H(w + 1), 1)]), _: 1 }), e(s).visible("receipt.receiptType") ? (o(), r(t, { key: "receipt.receiptType", "show-overflow-tooltip": true, align: "center", label: "单据类型", prop: "receipt.receiptType", width: "120" })) : n("", true), e(s).visible("receipt.serialNumber") ? (o(), r(t, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "单据编号", "min-width": "120", prop: "serialNumber" }, { default: m(({ row: { sourceRow: l } }) => [a(e(q), { receipt: l.receipt, "receipt-types": ["INBOUND", "OUTBOUND", "TRANSFER", "RETURN", "INVENTORY_PROFIT", "CONVERT"] }, null, 8, ["receipt"])]), _: 1 })) : n("", true), e(s).visible("basicClass") ? (o(), r(t, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", "min-width": "120", prop: "basicClass" })) : n("", true), e(s).visible("projects") ? (o(), r(t, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : n("", true), e(s).visible("pendingPrintedMaterialNumber") ? (o(), r(t, { key: "pendingPrintedMaterialNumber", "show-overflow-tooltip": true, align: "center", label: "未打印物料数量", prop: "pendingPrintedMaterialNumber", width: "120" })) : n("", true), e(s).visible("reviewerName") ? (o(), r(t, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", prop: "reviewerName", width: "120" })) : n("", true), e(s).visible("createTime") ? (o(), r(t, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "创建日期", prop: "createTime", sortable: "custom", width: "130" })) : n("", true), a(t, { align: "center", fixed: "right", label: "操作", width: "130" }, { default: m(({ row: { sourceRow: l } }) => [a(z, { data: l, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"]), a(O, { icon: "el-icon-printer", size: "default", type: "success", onClick: (w) => R(l) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[P, e(i).loading]]), a(e(G)), a(Y)]);
  };
} };
export {
  me as default
};
