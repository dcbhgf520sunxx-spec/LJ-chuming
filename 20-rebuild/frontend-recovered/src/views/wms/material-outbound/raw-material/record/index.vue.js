import { ref as b } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as i } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as u } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as j } from "element-plus";
import { l as g, uv as B, x as E, zu as M, o as P, aR as V, an as A, P as H } from "../../../../../shared/runtime.js";
import L from "./module/header.vue.js";
import $ from "./module/detail.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
function F(m) {
  return g({ module: "wms", url: "outbound/application/record/raw-materials", method: "get", params: m });
}
function K(m) {
  return g({ module: "wms", url: `outbound/application/record/raw-materials/${m}`, method: "get" });
}
const O = { get: F, detail: K }, U = { class: "app-container" }, W = { __name: "index", setup(m) {
  const y = { batchAdd: false, add: false, edit: false, del: false, download: false }, w = b([]), f = b(), _ = b([...B, ["outboundEarliestTime", ["parse-time", "{y}-{m}-{d}"]], ["outboundLatestTime", ["parse-time", "{y}-{m}-{d}"]]]), { crud: d, columns: r } = E({ title: "出库记录", sort: ["id.desc"], permission: { ...M }, optShow: { ...y }, crudApi: { ...O } }, f), { maxHeight: x } = P({ paginate: true });
  return (q, n) => {
    const a = S, k = h("table-cell-tag"), C = h("common-table"), T = j;
    return o(), R("div", U, [l(e(L)), D((o(), i(C, { ref_key: "tableRef", ref: f, data: e(d).data, "data-format": _.value, "empty-text": e(d).emptyText, "max-height": e(x), "default-expand-all": false, "expand-row-keys": w.value, onRowDblclick: n[1] || (n[1] = (t) => e(d).toDetail(t)), onSelectionChange: e(d).selectionChangeHandler, onSortChange: e(d).handleSortChange, "row-key": "id" }, { default: p(() => [l(V, { data: e(d).data, "expand-row-keys": w.value, "onUpdate:expandRowKeys": n[0] || (n[0] = (t) => w.value = t), "row-key": "id" }, { default: p(({ row: t }) => [u("p", null, [n[2] || (n[2] = v(" 关联项目：")), u("span", null, c(t.projectsFullName), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), l(a, { type: "selection", width: "55", align: "center" }), l(a, { label: "序号", type: "index", align: "center", width: "70" }, { default: p(({ row: t, $index: N }) => [l(k, { show: t.boolPrinted, name: "已打印", type: "printed" }, null, 8, ["show"]), u("span", null, c(N + 1), 1)]), _: 1 }), e(r).visible("serialNumber") ? (o(), i(a, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", width: "160", label: "出库单号" })) : s("", true), e(r).visible("basicClass") ? (o(), i(a, { key: "basicClass", "show-overflow-tooltip": true, prop: "basicClass", label: "物料种类", width: "200" })) : s("", true), e(r).visible("projects") ? (o(), i(a, { "show-overflow-tooltip": "", key: "projects", prop: "projects", label: "关联项目", "min-width": "170" })) : s("", true), e(r).visible("applicantName") ? (o(), i(a, { key: "applicantName", "show-overflow-tooltip": true, prop: "applicantName", label: "申请人", align: "center", "min-width": "100" })) : s("", true), e(r).visible("reviewerName") ? (o(), i(a, { key: "reviewerName", "show-overflow-tooltip": true, prop: "reviewerName", label: "处理人", align: "center", "min-width": "100" })) : s("", true), e(r).visible("outboundTime") ? (o(), i(a, { key: "outboundTime", "show-overflow-tooltip": true, prop: "outboundTime", label: "出库日期", align: "center", width: "200" }, { default: p(({ row: t }) => [u("span", null, c(t.outboundEarliestTime), 1), n[3] || (n[3] = v("  ~  ")), u("span", null, c(t.outboundLatestTime), 1)]), _: 1 })) : s("", true), e(r).visible("createTime") ? (o(), i(a, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "申请日期", align: "center", width: "160", sortable: "custom" })) : s("", true), e(r).visible("reviewTime") ? (o(), i(a, { key: "reviewTime", "show-overflow-tooltip": true, prop: "reviewTime", label: "审核日期", align: "center", width: "140" })) : s("", true), l(a, { label: "操作", width: "65px", align: "center", fixed: "right" }, { default: p(({ row: t }) => [l(A, { "show-edit": false, "show-del": false, "show-detail": "", data: t }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "expand-row-keys", "onSelectionChange", "onSortChange"])), [[T, e(d).loading]]), l(e(H)), l($)]);
  };
} };
export {
  W as default
};
