import { ref as n } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as d } from "vue";
import { unref as t } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as f } from "vue";
import { withCtx as g } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElProgress as B } from "element-plus";
import { vLoading as I } from "element-plus";
import { c as L } from "../../../../../modules/enclosure-ship-summary-6941ca85.js";
import { _ as T, x as q, o as D, i as H, a3 as M, V as N } from "../../../../../shared/runtime.js";
import { o as y } from "../../../../../modules/ship-manage-3066b2ed.js";
import P from "./module/header.vue.js";
import V from "./module/project-shipment-detail.vue.js";
import "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/detail.vue.js";
import "./module/ship-list.vue.js";
import "../../../../../modules/ship-summary-d5d4a58f.js";
import "./module/package-detail-drawer.vue.js";
import "./module/train-number-list.vue.js";
const A = { class: "app-container" }, F = { style: { display: "flex" } }, O = { style: { width: "450px", "padding-right": "10px" } }, U = { class: "head-container" }, K = { style: { position: "relative" } }, $ = { style: { flex: "1", overflow: "hidden", "padding-left": "10px" } }, z = { key: 1, class: "my-code" }, G = { __name: "index", setup(J) {
  const x = { add: false, edit: false, del: false, download: false }, w = n([["project", "parse-project"]]), m = n(), l = n({}), h = n([]), u = n([]), { crud: a, CRUD: b } = q({ title: "发运管理", sort: [], permission: { ...y }, dataPath: "", optShow: { ...x }, crudApi: { ...L }, hasPagination: false }, m), { maxHeight: v } = D({ extraBox: [".head-container"], wrapperBox: [".app-container"], paginate: false });
  b.HOOK.handleRefresh = (r, { data: o }) => {
    o.forEach((e) => {
      var i, p;
      e.projectId = (i = e.project) == null ? void 0 : i.id, e.rate = e.sendMete && e.mete ? (e.sendMete / e.mete * 100).toFixed(2) : 0, e.ratio = (p = e.ratio) == null ? void 0 : p.toFixed(2);
    });
  };
  function k(r) {
    var o, e;
    l.value = r, u.value = (e = (o = r == null ? void 0 : r.project) == null ? void 0 : o.projectContentList) == null ? void 0 : e.filter((i) => i.categoryType === M.ENCLOSURE.V), h.value = N(u.value);
  }
  return (r, o) => {
    const e = j, i = B, p = R("common-table"), C = I;
    return c(), _("div", A, [s("div", F, [s("div", O, [s("div", U, [d(t(P))]), S((c(), f(p, { ref_key: "tableRef", ref: m, data: t(a).data, "data-format": w.value, "empty-text": t(a).emptyText, onCurrentChange: k, "highlight-current-row": "", "max-height": t(v), style: { width: "100%" }, stripe: false, showEmptySymbol: false }, { default: g(() => [d(e, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), d(e, { key: "project", prop: "project", label: "项目", align: "left", "show-overflow-tooltip": "", "min-width": "120" }), d(e, { key: "ratio", prop: "ratio", label: "发运数据(米)", align: "center", "min-width": "160", "show-overflow-tooltip": "" }, { default: g((E) => [s("div", K, [d(i, { color: "#67C23A", "stroke-width": 16, percentage: E.row.ratio }, null, 8, ["percentage"])])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[C, t(a).loading]])]), o[0] || (o[0] = s("div", { style: { "border-right": "1px solid #ededed", height: "calc(100vh - 130px)" } }, null, -1)), s("div", $, [t(H)(l.value) ? (c(), f(V, { key: 0, workshopId: t(a).query.workshopId, weightStatus: t(a).query.weightStatus, "production-line-type-enum": t(a).query.productionLineTypeEnum, currentRow: l.value, "category-list": h.value, permission: t(y) }, null, 8, ["workshopId", "weightStatus", "production-line-type-enum", "currentRow", "category-list", "permission"])) : (c(), _("div", z, "*点击左表操作查看明细"))])])]);
  };
} }, pe = T(G, [["__scopeId", "data-v-b1d8244c"]]);
export {
  pe as default
};
