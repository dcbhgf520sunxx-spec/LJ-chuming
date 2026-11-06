import { ref as d } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as r } from "vue";
import { ElTableColumn as k } from "element-plus";
import { vLoading as T } from "element-plus";
import { uv as N, x as D, AA as P, AB as S, o as A, an as R, P as B, AC as M } from "../../../../../../../shared/runtime.js";
import j from "./module/header.vue.js";
const H = { class: "app-container" }, K = { __name: "index", setup(V) {
  const h = { batchAdd: false, add: false, edit: false, del: false, download: false }, f = d([]), u = d(), b = d([...N, ["reviewPassTime", ["parse-time", "{y}-{m}-{d}"]], ["applicationTime", ["parse-time", "{y}-{m}-{d}"]]]), { crud: s, columns: n } = D({ title: "出库记录", sort: ["id.desc"], permission: { ...P }, optShow: { ...h }, crudApi: { ...S } }, u), { maxHeight: v } = A({ paginate: true });
  return (E, w) => {
    const a = k, _ = x("common-table"), g = T;
    return o(), y("div", H, [i(e(j)), C((o(), l(_, { ref_key: "tableRef", ref: u, data: e(s).data, "data-format": b.value, "default-expand-all": false, "empty-text": e(s).emptyText, "expand-row-keys": f.value, "max-height": e(v), "row-key": "id", onRowDblclick: w[0] || (w[0] = (t) => e(s).toDetail(t)), onSelectionChange: e(s).selectionChangeHandler, onSortChange: e(s).handleSortChange }, { default: p(() => [i(a, { align: "center", type: "selection", width: "55" }), i(a, { align: "center", label: "序号", type: "index", width: "70" }, { default: p(({ $index: t }) => [c("span", null, m(t + 1), 1)]), _: 1 }), e(n).visible("serialNumber") ? (o(), l(a, { key: "serialNumber", "show-overflow-tooltip": true, label: "出库单号", prop: "serialNumber", width: "160" }, { default: p(({ row: t }) => [c("span", null, m(t.serialNumber), 1)]), _: 1 })) : r("", true), e(n).visible("basicClass") ? (o(), l(a, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "200" })) : r("", true), e(n).visible("projects") ? (o(), l(a, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : r("", true), e(n).visible("applicantName") ? (o(), l(a, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : r("", true), e(n).visible("reviewPassTime") ? (o(), l(a, { key: "reviewPassTime", "show-overflow-tooltip": true, align: "center", label: "出库日期", prop: "reviewPassTime", width: "200" }, { default: p(({ row: t }) => [c("span", null, m(t.reviewPassTime), 1)]), _: 1 })) : r("", true), e(n).visible("applicationTime") ? (o(), l(a, { key: "applicationTime", "show-overflow-tooltip": true, align: "center", label: "申请日期", prop: "applicationTime", width: "160" })) : r("", true), i(a, { align: "center", fixed: "right", label: "操作", width: "65px" }, { default: p(({ row: t }) => [i(R, { data: t, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "expand-row-keys", "max-height", "onSelectionChange", "onSortChange"])), [[g, e(s).loading]]), i(e(B)), i(M)]);
  };
} };
export {
  K as default
};
