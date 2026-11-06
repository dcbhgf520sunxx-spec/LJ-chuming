import { ref as p } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as l } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as b } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as i } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as V } from "element-plus";
import { uv as A, x as D, A1 as v, A2 as j, o as P, aR as B, G as E, an as M, P as L, A3 as U } from "../../../../../../../shared/runtime.js";
import F from "./module/header.vue.js";
import H from "./module/review.vue.js";
import "../../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../../../modules/review-convenient-operate-8438d44b.js";
const K = { class: "app-container" }, W = { __name: "index", setup(O) {
  const y = { batchAdd: false, add: false, edit: false, del: false, download: false }, x = p({}), w = p(false), m = p([]), f = p(), _ = p([...A, ["outboundEarliestTime", ["parse-time", "{y}-{m}-{d}"]], ["outboundLatestTime", ["parse-time", "{y}-{m}-{d}"]]]), { crud: r, columns: n } = D({ title: "出库清单", sort: ["id.desc"], permission: { ...v }, optShow: { ...y }, crudApi: { ...j } }, f), { maxHeight: g } = P({ paginate: true });
  return ($, d) => {
    const o = S, k = T("common-table"), C = V;
    return t(), R("div", K, [s(e(F)), N((t(), l(k, { ref_key: "tableRef", ref: f, data: e(r).data, "data-format": _.value, "default-expand-all": false, "empty-text": e(r).emptyText, "expand-row-keys": m.value, "max-height": e(g), "row-key": "id", onSortChange: e(r).handleSortChange }, { default: u(() => [s(B, { "expand-row-keys": m.value, "onUpdate:expandRowKeys": d[0] || (d[0] = (a) => m.value = a), data: e(r).data, "row-key": "id" }, { default: u(({ row: a }) => [b("p", null, [d[2] || (d[2] = h(" 关联项目：")), b("span", null, c(a.projectsFullName), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(o, { align: "center", label: "序号", type: "index", width: "60" }), e(n).visible("applicationSN") ? (t(), l(o, { key: "applicationSN", "show-overflow-tooltip": true, label: "出库申请编号", prop: "applicationSN", width: "160" })) : i("", true), e(n).visible("basicClass") ? (t(), l(o, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "200" })) : i("", true), e(n).visible("projects") ? (t(), l(o, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : i("", true), e(n).visible("applicantName") ? (t(), l(o, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", prop: "applicantName", width: "140" })) : i("", true), e(n).visible("outboundTime") ? (t(), l(o, { key: "outboundTime", "show-overflow-tooltip": true, align: "center", label: "出库日期", prop: "outboundTime", width: "200" }, { default: u(({ row: a }) => [h(c(a.outboundEarliestTime) + "  ~  " + c(a.outboundLatestTime), 1)]), _: 1 })) : i("", true), e(n).visible("createTime") ? (t(), l(o, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", sortable: "custom", width: "160" })) : i("", true), e(E)(e(v).review) ? (t(), l(o, { key: 6, align: "center", fixed: "right", label: "操作", width: "120px" }, { default: u(({ row: a }) => [s(M, { data: a, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "expand-row-keys", "max-height", "onSortChange"])), [[C, e(r).loading]]), s(e(L)), s(H, { modelValue: w.value, "onUpdate:modelValue": d[1] || (d[1] = (a) => w.value = a), data: x.value, onRefresh: e(r).refresh }, null, 8, ["modelValue", "data", "onRefresh"]), s(U)]);
  };
} };
export {
  W as default
};
