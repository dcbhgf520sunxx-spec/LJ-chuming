import { ref as w } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as T } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as i } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as m } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as n } from "vue";
import { ElTableColumn as R } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as S } from "../../../../../../../modules/record-v2-41933798.js";
import { uv as j, x as A, A0 as P, o as B, aR as E, an as M, P as V } from "../../../../../../../shared/runtime.js";
import H from "./module/header.vue.js";
import L from "./module/detail.vue.js";
import "../../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const F = { class: "app-container" }, J = { __name: "index", setup(K) {
  const v = { batchAdd: false, add: false, edit: false, del: false, download: false }, c = w([]), f = w(), g = w([...j, ["outboundEarliestTime", ["parse-time", "{y}-{m}-{d}"]], ["outboundLatestTime", ["parse-time", "{y}-{m}-{d}"]]]), { crud: d, columns: r } = A({ title: "出库记录", sort: ["id.desc"], permission: { ...P }, optShow: { ...v }, crudApi: { ...S } }, f), { maxHeight: y } = B({ paginate: true });
  return (O, s) => {
    const a = R, _ = h("table-cell-tag"), x = h("common-table"), k = D;
    return o(), T("div", F, [l(e(H)), N((o(), i(x, { ref_key: "tableRef", ref: f, data: e(d).data, "data-format": g.value, "default-expand-all": false, "empty-text": e(d).emptyText, "expand-row-keys": c.value, "max-height": e(y), "row-key": "id", onRowDblclick: s[1] || (s[1] = (t) => e(d).toDetail(t)), onSelectionChange: e(d).selectionChangeHandler, onSortChange: e(d).handleSortChange }, { default: p(() => [l(E, { "expand-row-keys": c.value, "onUpdate:expandRowKeys": s[0] || (s[0] = (t) => c.value = t), data: e(d).data, "row-key": "id" }, { default: p(({ row: t }) => [m("p", null, [s[2] || (s[2] = b(" 关联项目：")), m("span", null, u(t.projectsFullName), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), l(a, { align: "center", type: "selection", width: "55" }), l(a, { align: "center", label: "序号", type: "index", width: "60" }, { default: p(({ row: t, $index: C }) => [l(_, { offset: 10, show: !!t.boolPrinted, color: "#67c23a", name: "已打印" }, null, 8, ["show"]), b(" " + u(C + 1), 1)]), _: 1 }), e(r).visible("serialNumber") ? (o(), i(a, { key: "serialNumber", "show-overflow-tooltip": true, label: "出库单号", prop: "serialNumber", width: "160" })) : n("", true), e(r).visible("basicClass") ? (o(), i(a, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "200" })) : n("", true), e(r).visible("projects") ? (o(), i(a, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : n("", true), e(r).visible("applicantName") ? (o(), i(a, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : n("", true), e(r).visible("reviewerName") ? (o(), i(a, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "处理人", "min-width": "100", prop: "reviewerName" })) : n("", true), e(r).visible("outboundTime") ? (o(), i(a, { key: "outboundTime", "show-overflow-tooltip": true, align: "center", label: "出库日期", prop: "outboundTime", width: "200" }, { default: p(({ row: t }) => [m("span", null, u(t.outboundEarliestTime), 1), s[3] || (s[3] = b("  ~  ")), m("span", null, u(t.outboundLatestTime), 1)]), _: 1 })) : n("", true), e(r).visible("createTime") ? (o(), i(a, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请日期", prop: "createTime", sortable: "custom", width: "160" })) : n("", true), e(r).visible("reviewTime") ? (o(), i(a, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核日期", prop: "reviewTime", width: "140" })) : n("", true), l(a, { align: "center", fixed: "right", label: "操作", width: "65px" }, { default: p(({ row: t }) => [l(M, { data: t, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "expand-row-keys", "max-height", "onSelectionChange", "onSortChange"])), [[k, e(d).loading]]), l(e(V)), l(L)]);
  };
} };
export {
  J as default
};
