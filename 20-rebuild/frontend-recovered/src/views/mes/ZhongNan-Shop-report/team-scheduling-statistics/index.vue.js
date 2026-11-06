import { provide as k } from "vue";
import { ref as g } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as U } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as d } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as i } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as F } from "element-plus";
import { vLoading as B } from "element-plus";
import { c as P, _ as R } from "./module/detail.vue.js";
import { n1 as h, x as S, o as V, G as q } from "../../../../shared/runtime.js";
import $ from "./module/header.vue.js";
import "../../../../modules/production-line-select-f08e245b.js";
const E = { class: "app-container" }, H = { class: "head-container" }, J = { __name: "index", setup(M) {
  k("permission", h);
  const y = { add: false, edit: false, del: false, download: false }, N = g(), u = g(false), _ = g(), { crud: c, columns: p } = S({ title: "班组排产统计", permission: { ...h }, optShow: { ...y }, crudApi: { ...P }, dataPath: "", hasPagination: false }, N), { maxHeight: W } = V({ paginate: false });
  function x(f) {
    u.value = true, _.value = f;
  }
  return k("query", c.query), (f, v) => {
    const o = F, C = w("common-button"), T = w("common-table"), A = B;
    return a(), U("div", E, [r("div", H, [d(t($), { ref: "headerRef" }, null, 512)]), D((a(), i(T, { ref_key: "tableRef", ref: N, data: t(c).data, "empty-text": t(c).emptyText, "max-height": t(W), style: { width: "100%" } }, { default: n(() => [d(o, { label: "序号", type: "index", align: "center", width: "60" }), t(p).visible("teamName") ? (a(), i(o, { label: "班组", prop: "teamName", key: "teamName", align: "center" }, { default: n((e) => [r("div", null, m(e.row.teamName), 1)]), _: 1 })) : s("", true), t(p).visible("processName") ? (a(), i(o, { label: "工序", prop: "processName", key: "processName", align: "center" }, { default: n((e) => [r("div", null, m(e.row.processName), 1)]), _: 1 })) : s("", true), t(p).visible("productTypeName") ? (a(), i(o, { label: "类型", prop: "productTypeName", key: "productTypeName", align: "center" }, { default: n((e) => [r("div", null, m(e.row.productTypeName), 1)]), _: 1 })) : s("", true), t(p).visible("workshopName") ? (a(), i(o, { label: "生产车间", prop: "workshopName", key: "workshopName", align: "center" }, { default: n((e) => [r("div", null, m(e.row.workshopName), 1)]), _: 1 })) : s("", true), t(p).visible("lineName") ? (a(), i(o, { label: "生产线", prop: "lineName", key: "lineName", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: n((e) => [r("div", null, m(e.row.lineName), 1)]), _: 1 })) : s("", true), t(p).visible("totalTaskNetWeight") ? (a(), i(o, { label: "排产任务量(吨)", prop: "totalTaskNetWeight", key: "totalTaskNetWeight", align: "center" }, { default: n((e) => {
      var l;
      return [r("div", null, m((l = e.row.totalTaskNetWeight) == null ? void 0 : l.toFixed(3)), 1)];
    }), _: 1 })) : s("", true), t(p).visible("totalCompleteNetWeight") ? (a(), i(o, { label: "已完成量(吨)", prop: "totalCompleteNetWeight", key: "totalCompleteNetWeight", align: "center" }, { default: n((e) => {
      var l;
      return [r("div", null, m((l = e.row.totalCompleteNetWeight) == null ? void 0 : l.toFixed(3)), 1)];
    }), _: 1 })) : s("", true), t(p).visible("totalUncompleteNetWeight") ? (a(), i(o, { label: "未完成量(吨)", prop: "totalUncompleteNetWeight", key: "totalUncompleteNetWeight", align: "center" }, { default: n((e) => {
      var l;
      return [r("div", null, m((l = e.row.totalUncompleteNetWeight) == null ? void 0 : l.toFixed(3)), 1)];
    }), _: 1 })) : s("", true), t(p).visible("totalTaskNetWeightAll") ? (a(), i(o, { label: "累计任务量(吨)", prop: "totalTaskNetWeightAll", key: "totalTaskNetWeightAll", align: "center" }, { default: n((e) => {
      var l, b;
      return [r("div", null, m((b = (l = e.row) == null ? void 0 : l.totalTaskNetWeightAll) == null ? void 0 : b.toFixed(3)), 1)];
    }), _: 1 })) : s("", true), t(p).visible("totalCompleteNetWeightAll") ? (a(), i(o, { label: "累计完成量(吨)", prop: "totalCompleteNetWeightAll", key: "totalCompleteNetWeightAll", align: "center" }, { default: n((e) => {
      var l;
      return [r("div", null, m((l = e.row.totalCompleteNetWeightAll) == null ? void 0 : l.toFixed(3)), 1)];
    }), _: 1 })) : s("", true), t(p).visible("totalUncompleteNetWeightAll") ? (a(), i(o, { label: "累计未完成量(吨)", prop: "totalUncompleteNetWeightAll", key: "totalUncompleteNetWeightAll", align: "center" }, { default: n((e) => {
      var l;
      return [r("div", null, m((l = e.row.totalUncompleteNetWeightAll) == null ? void 0 : l.toFixed(3)), 1)];
    }), _: 1 })) : s("", true), d(o, { label: "操作", align: "center", fixed: "right" }, { default: n((e) => [t(q)(t(h).detail) ? (a(), i(C, { key: 0, type: "primary", size: "default", icon: "el-icon-view", onClick: (l) => x(e.row) }, null, 8, ["onClick"])) : s("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[A, t(c).loading]]), d(t(R), { visible: u.value, "onUpdate:visible": v[0] || (v[0] = (e) => u.value = e), "row-detail": _.value }, null, 8, ["visible", "row-detail"])]);
  };
} };
export {
  J as default
};
