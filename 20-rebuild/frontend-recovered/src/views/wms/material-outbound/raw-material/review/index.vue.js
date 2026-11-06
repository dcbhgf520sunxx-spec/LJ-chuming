import { ref as p } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as i } from "vue";
import { withCtx as m } from "vue";
import { createElementVNode as _ } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as j } from "element-plus";
import { vLoading as B } from "element-plus";
import { c as E } from "../../../../../modules/review-a53b87d8.js";
import { uv as M, x as P, zv as x, o as A, aR as L, G as U, an as $, P as z } from "../../../../../shared/runtime.js";
import F from "./module/header.vue.js";
import H from "./module/detail.vue.js";
import K from "./module/review.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/review-convenient-operate-8438d44b.js";
import "../../../../../modules/review-confirm-button-aa3600ad.js";
const O = { class: "app-container" }, ae = { __name: "index", setup(q) {
  const g = { batchAdd: false, add: false, edit: false, del: false, download: false }, w = p({}), u = p(false), c = p([]), b = p(), k = p([...M, ["outboundEarliestTime", ["parse-time", "{y}-{m}-{d}"]], ["outboundLatestTime", ["parse-time", "{y}-{m}-{d}"]]]), { crud: n, columns: r } = P({ title: "出库清单", sort: ["id.desc"], permission: { ...x }, optShow: { ...g }, crudApi: { ...E } }, b), { maxHeight: C } = A({ paginate: true });
  function R(v) {
    w.value = v, u.value = true;
  }
  return (v, d) => {
    const o = j, T = h("common-button"), N = h("common-table"), S = B;
    return a(), V("div", O, [l(e(F)), D((a(), i(N, { ref_key: "tableRef", ref: b, data: e(n).data, "data-format": k.value, "empty-text": e(n).emptyText, "max-height": e(C), "default-expand-all": false, "expand-row-keys": c.value, "row-key": "id", onSortChange: e(n).handleSortChange }, { default: m(() => [l(L, { data: e(n).data, "expand-row-keys": c.value, "onUpdate:expandRowKeys": d[0] || (d[0] = (t) => c.value = t), "row-key": "id" }, { default: m(({ row: t }) => [_("p", null, [d[2] || (d[2] = y(" 关联项目：")), _("span", null, f(t.projectsFullName), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), l(o, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("applicationSN") ? (a(), i(o, { key: "applicationSN", "show-overflow-tooltip": true, prop: "applicationSN", width: "160", label: "出库申请编号" })) : s("", true), e(r).visible("basicClass") ? (a(), i(o, { key: "basicClass", "show-overflow-tooltip": true, prop: "basicClass", label: "物料种类", width: "200" })) : s("", true), e(r).visible("projects") ? (a(), i(o, { "show-overflow-tooltip": "", key: "projects", prop: "projects", label: "关联项目", "min-width": "170" })) : s("", true), e(r).visible("applicantName") ? (a(), i(o, { key: "applicantName", "show-overflow-tooltip": true, prop: "applicantName", label: "申请人", align: "center", width: "140" })) : s("", true), e(r).visible("outboundTime") ? (a(), i(o, { key: "outboundTime", "show-overflow-tooltip": true, prop: "outboundTime", label: "出库日期", align: "center", width: "200" }, { default: m(({ row: t }) => [y(f(t.outboundEarliestTime) + "  ~  " + f(t.outboundLatestTime), 1)]), _: 1 })) : s("", true), e(r).visible("createTime") ? (a(), i(o, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "申请时间", align: "center", width: "160", sortable: "custom" })) : s("", true), e(U)(e(x).review) ? (a(), i(o, { key: 6, label: "操作", width: "120px", align: "center", fixed: "right" }, { default: m(({ row: t }) => [l($, { data: t, "show-detail": "", "show-edit": false, "show-del": false }, null, 8, ["data"]), l(T, { type: "warning", icon: "el-icon-stamp", size: "default", onClick: (G) => R(t) }, null, 8, ["onClick"])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "expand-row-keys", "onSortChange"])), [[S, e(n).loading]]), l(e(z)), l(K, { modelValue: u.value, "onUpdate:modelValue": d[1] || (d[1] = (t) => u.value = t), data: w.value, onRefresh: e(n).refresh }, null, 8, ["modelValue", "data", "onRefresh"]), l(H)]);
  };
} };
export {
  ae as default
};
