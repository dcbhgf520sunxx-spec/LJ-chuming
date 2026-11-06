import { ref as c } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as E } from "vue";
import { ElTableColumn as R } from "element-plus";
import { ElProgress as B } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as j } from "../../../../modules/ship-summary-06293e56.js";
import { _ as F, x as P, om as g, o as q, bo as I, P as T, i as D } from "../../../../shared/runtime.js";
import H from "./module/header.vue.js";
import N from "./module/project-shipment-detail.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/detail.vue.js";
import "./module/detail-drawer.vue.js";
const V = { class: "app-container" }, A = { style: { display: "flex" } }, L = { style: { width: "30%", "padding-right": "10px" } }, O = { class: "head-container" }, U = { style: { position: "relative" } }, G = { style: { position: "absolute", top: "-2px", left: "0", width: "100%", "text-align": "right", "padding-right": "60px" } }, K = { style: { flex: "1", "padding-left": "10px" } }, $ = { key: 1, class: "my-code" }, z = { __name: "index", setup(J) {
  const f = { add: false, edit: false, del: false, download: false }, w = c([["project", "parse-project"]]), m = c(), l = c({}), { crud: o, CRUD: x } = P({ title: "发运管理", sort: [], permission: { ...g }, dataPath: "", optShow: { ...f }, crudApi: { ...j }, hasPagination: true }, m), { maxHeight: y } = q({ extraBox: [".head-container"], wrapperBox: [".app-container"], paginate: false });
  x.HOOK.handleRefresh = (p, { data: r }) => {
    r.forEach((t) => {
      var n;
      t.projectId = (n = t.project) == null ? void 0 : n.id, t.rate = t.sendMete && t.mete ? (t.sendMete / t.mete * 100).toFixed(2) : 0;
    });
  };
  function b(p) {
    l.value = p;
  }
  return (p, r) => {
    const t = R, n = B, v = C("common-table"), k = M;
    return d(), h("div", V, [a("div", A, [a("div", L, [a("div", O, [s(e(H))]), S((d(), _(v, { ref_key: "tableRef", ref: m, data: e(o).data, "data-format": w.value, "empty-text": e(o).emptyText, onCurrentChange: b, "highlight-current-row": "", "max-height": e(y), style: { width: "100%" }, stripe: false, showEmptySymbol: false }, { default: u(() => [s(t, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), s(t, { key: "project", prop: "project", label: "项目", align: "left", "show-overflow-tooltip": "", "min-width": "120" }), s(t, { key: "rate", prop: "rate", label: "发运数据(吨)", align: "center", "min-width": "160", "show-overflow-tooltip": "" }, { default: u((i) => [a("div", U, [s(n, { "stroke-width": 16, percentage: i.row.rate }, null, 8, ["percentage"]), a("span", G, E(e(o).query.weightStatus === e(I).NET.V ? (i.row.sendMete / 1e3).toFixed(2) + " | " + (i.row.mete / 1e3).toFixed(2) : (i.row.sendGrossMete / 1e3).toFixed(2) + " | " + (i.row.grossMete / 1e3).toFixed(2)), 1)])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[k, e(o).loading]]), s(e(T))]), r[0] || (r[0] = a("div", { style: { "border-right": "1px solid #ededed", height: "calc(100vh - 130px)" } }, null, -1)), a("div", K, [e(D)(l.value) ? (d(), _(N, { key: 0, workshopId: e(o).query.workshopId, weightStatus: e(o).query.weightStatus, "production-line-type-enum": e(o).query.productionLineTypeEnum, currentRow: l.value, permission: e(g) }, null, 8, ["workshopId", "weightStatus", "production-line-type-enum", "currentRow", "permission"])) : (d(), h("div", $, "*点击左表操作查看明细"))])])]);
  };
} }, ie = F(z, [["__scopeId", "data-v-2dadfb09"]]);
export {
  ie as default
};
