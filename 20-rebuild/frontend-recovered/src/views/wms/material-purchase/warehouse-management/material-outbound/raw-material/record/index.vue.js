import { ref as b } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as N } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as i } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as u } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as R } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as V } from "../../../../../../../modules/record-v2-41933798.js";
import { uv as j, x as E, AD as L, o as A, aR as B, gG as y, an as M, P as O } from "../../../../../../../shared/runtime.js";
import P from "./module/header.vue.js";
import H from "./module/detail.vue.js";
import "../../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../../../modules/index-4b5f34f4.js";
const F = { class: "app-container" }, W = { __name: "index", setup(K) {
  const _ = { batchAdd: false, add: false, edit: false, del: false, download: false }, w = b([]), h = b(), x = b([...j, ["outboundEarliestTime", ["parse-time", "{y}-{m}-{d}"]], ["outboundLatestTime", ["parse-time", "{y}-{m}-{d}"]]]), { crud: d, columns: n } = E({ title: "出库记录", sort: ["id.desc"], permission: { ...L }, optShow: { ..._ }, crudApi: { ...V } }, h), { maxHeight: k } = A({ paginate: true });
  return (U, r) => {
    const a = R, v = g("table-cell-tag"), T = g("common-table"), C = D;
    return o(), N("div", F, [l(e(P)), S((o(), i(T, { ref_key: "tableRef", ref: h, data: e(d).data, "data-format": x.value, "default-expand-all": false, "empty-text": e(d).emptyText, "expand-row-keys": w.value, "max-height": e(k), "row-key": "id", onRowDblclick: r[1] || (r[1] = (t) => e(d).toDetail(t)), onSelectionChange: e(d).selectionChangeHandler, onSortChange: e(d).handleSortChange }, { default: p(() => [l(B, { "expand-row-keys": w.value, "onUpdate:expandRowKeys": r[0] || (r[0] = (t) => w.value = t), data: e(d).data, "row-key": "id" }, { default: p(({ row: t }) => [u("p", null, [r[2] || (r[2] = f(" 关联项目：")), u("span", null, m(t.projectsFullName), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), l(a, { align: "center", type: "selection", width: "55" }), l(a, { align: "center", label: "序号", type: "index", width: "60" }, { default: p(({ row: t, $index: c }) => [l(v, { offset: 10, show: !!t.boolPrinted, color: "#67c23a", name: "已打印" }, null, 8, ["show"]), f(" " + m(c + 1), 1)]), _: 1 }), e(n).visible("serialNumber") ? (o(), i(a, { key: "serialNumber", "show-overflow-tooltip": true, label: "出库单号", prop: "serialNumber", width: "160" }, { default: p(({ row: t }) => {
      var c;
      return [l(v, { name: e(y).VL[t.outboundTypeSelection], color: (c = e(y).V[t.outboundTypeSelection]) == null ? void 0 : c.COLOR }, null, 8, ["name", "color"]), u("span", null, m(t.serialNumber), 1)];
    }), _: 1 })) : s("", true), e(n).visible("basicClass") ? (o(), i(a, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "200" })) : s("", true), e(n).visible("projects") ? (o(), i(a, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : s("", true), e(n).visible("applicantName") ? (o(), i(a, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : s("", true), e(n).visible("reviewerName") ? (o(), i(a, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "处理人", "min-width": "100", prop: "reviewerName" })) : s("", true), e(n).visible("outboundTime") ? (o(), i(a, { key: "outboundTime", "show-overflow-tooltip": true, align: "center", label: "出库日期", prop: "outboundTime", width: "200" }, { default: p(({ row: t }) => [u("span", null, m(t.outboundEarliestTime), 1), r[3] || (r[3] = f("  ~  ")), u("span", null, m(t.outboundLatestTime), 1)]), _: 1 })) : s("", true), e(n).visible("createTime") ? (o(), i(a, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请日期", prop: "createTime", sortable: "custom", width: "160" })) : s("", true), e(n).visible("reviewTime") ? (o(), i(a, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核日期", prop: "reviewTime", width: "140" })) : s("", true), l(a, { align: "center", fixed: "right", label: "操作", width: "80px" }, { default: p(({ row: t }) => [l(M, { data: t, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "expand-row-keys", "max-height", "onSelectionChange", "onSortChange"])), [[C, e(d).loading]]), l(e(O)), l(H)]);
  };
} };
export {
  W as default
};
