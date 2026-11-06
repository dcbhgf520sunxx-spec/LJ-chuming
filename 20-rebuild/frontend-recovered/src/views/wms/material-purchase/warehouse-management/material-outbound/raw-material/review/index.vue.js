import { ref as p } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as s } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as f } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as i } from "vue";
import { ElTableColumn as E } from "element-plus";
import { vLoading as j } from "element-plus";
import { uv as L, x as B, AE as y, A2 as M, o as O, aR as P, gG as g, G as F, an as U, P as G, AF as H } from "../../../../../../../shared/runtime.js";
import K from "./module/header.vue.js";
import $ from "./module/review.vue.js";
import "../../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../../../modules/index-4b5f34f4.js";
import "../../../../../../../modules/review-convenient-operate-8438d44b.js";
const q = { class: "app-container" }, ae = { __name: "index", setup(z) {
  const x = { batchAdd: false, add: false, edit: false, del: false, download: false }, k = p({}), w = p(false), c = p([]), b = p(), T = p([...L, ["outboundEarliestTime", ["parse-time", "{y}-{m}-{d}"]], ["outboundLatestTime", ["parse-time", "{y}-{m}-{d}"]]]), { crud: n, columns: r } = B({ title: "出库清单", sort: ["id.desc"], permission: { ...y }, optShow: { ...x }, crudApi: { ...M } }, b), { maxHeight: C } = O({ paginate: true });
  return (I, d) => {
    const R = v("table-cell-tag"), o = E, S = v("common-table"), N = j;
    return t(), A("div", q, [l(e(K)), D((t(), s(S, { ref_key: "tableRef", ref: b, data: e(n).data, "data-format": T.value, "default-expand-all": false, "empty-text": e(n).emptyText, "expand-row-keys": c.value, "max-height": e(C), "row-key": "id", onSortChange: e(n).handleSortChange }, { default: u(() => [l(P, { "expand-row-keys": c.value, "onUpdate:expandRowKeys": d[0] || (d[0] = (a) => c.value = a), data: e(n).data, "row-key": "id" }, { default: u(({ row: a }) => [f("p", null, [d[2] || (d[2] = _(" 关联项目：")), f("span", null, m(a.projectsFullName), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), l(o, { align: "center", label: "序号", type: "index", width: "60" }, { default: u(({ row: a, $index: V }) => {
      var h;
      return [l(R, { color: (h = e(g).V[a.outboundTypeSelection]) == null ? void 0 : h.COLOR, name: e(g).VL[a.outboundTypeSelection] }, null, 8, ["color", "name"]), f("span", null, m(V + 1), 1)];
    }), _: 1 }), e(r).visible("applicationSN") ? (t(), s(o, { key: "applicationSN", "show-overflow-tooltip": true, label: "出库申请编号", prop: "applicationSN", width: "160" })) : i("", true), e(r).visible("basicClass") ? (t(), s(o, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "200" })) : i("", true), e(r).visible("projects") ? (t(), s(o, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("applicantName") ? (t(), s(o, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", prop: "applicantName", width: "140" })) : i("", true), e(r).visible("outboundTime") ? (t(), s(o, { key: "outboundTime", "show-overflow-tooltip": true, align: "center", label: "出库日期", prop: "outboundTime", width: "200" }, { default: u(({ row: a }) => [_(m(a.outboundEarliestTime) + "  ~  " + m(a.outboundLatestTime), 1)]), _: 1 })) : i("", true), e(r).visible("createTime") ? (t(), s(o, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", sortable: "custom", width: "160" })) : i("", true), e(F)(e(y).review) ? (t(), s(o, { key: 6, align: "left", fixed: "right", label: "操作", width: "120px" }, { default: u(({ row: a }) => [l(U, { data: a, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "expand-row-keys", "max-height", "onSortChange"])), [[N, e(n).loading]]), l(e(G)), l($, { modelValue: w.value, "onUpdate:modelValue": d[1] || (d[1] = (a) => w.value = a), data: k.value, onRefresh: e(n).refresh }, null, 8, ["modelValue", "data", "onRefresh"]), l(H)]);
  };
} };
export {
  ae as default
};
