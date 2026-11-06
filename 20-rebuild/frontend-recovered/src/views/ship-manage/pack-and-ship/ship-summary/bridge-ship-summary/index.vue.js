import { ref as c } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as E } from "vue";
import { ElTableColumn as R } from "element-plus";
import { ElProgress as B } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as j } from "../../../../../modules/bridge-ship-summary-aa634ae7.js";
import { n as f } from "../../../../../modules/ship-manage-3066b2ed.js";
import { _ as F, x as q, o as I, bo as T, i as D } from "../../../../../shared/runtime.js";
import H from "./module/header.vue.js";
import N from "./module/project-shipment-detail.vue.js";
import "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/detail.vue.js";
import "./module/direct-detail.vue.js";
import "./module/detail-drawer.vue.js";
const P = { class: "app-container" }, A = { style: { display: "flex" } }, V = { style: { width: "30%", "padding-right": "10px" } }, L = { class: "head-container" }, O = { style: { position: "relative" } }, U = { style: { position: "absolute", top: "-2px", left: "0", width: "100%", "text-align": "right", "padding-right": "60px" } }, G = { style: { flex: "1", "padding-left": "10px" } }, K = { key: 1, class: "my-code" }, $ = { __name: "index", setup(z) {
  const g = { add: false, edit: false, del: false, download: false }, w = c([["project", "parse-project"]]), m = c(), l = c({}), { crud: o, CRUD: x } = q({ title: "发运管理", sort: [], permission: { ...f }, dataPath: "", optShow: { ...g }, crudApi: { ...j }, hasPagination: false }, m), { maxHeight: y } = I({ extraBox: [".head-container"], wrapperBox: [".app-container"], paginate: false });
  x.HOOK.handleRefresh = (p, { data: s }) => {
    s.forEach((t) => {
      var n;
      t.projectId = (n = t.project) == null ? void 0 : n.id, t.rate = t.sendMete && t.mete ? (t.sendMete / t.mete * 100).toFixed(2) : 0;
    });
  };
  function v(p) {
    l.value = p;
  }
  return (p, s) => {
    const t = R, n = B, b = C("common-table"), k = M;
    return d(), h("div", P, [a("div", A, [a("div", V, [a("div", L, [i(e(H))]), S((d(), _(b, { ref_key: "tableRef", ref: m, data: e(o).data, "data-format": w.value, "empty-text": e(o).emptyText, onCurrentChange: v, "highlight-current-row": "", "max-height": e(y), style: { width: "100%" }, stripe: false, showEmptySymbol: false }, { default: u(() => [i(t, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), i(t, { key: "project", prop: "project", label: "项目", align: "left", "show-overflow-tooltip": "", "min-width": "120" }), i(t, { key: "rate", prop: "rate", label: "发运数据(吨)", align: "center", "min-width": "160", "show-overflow-tooltip": "" }, { default: u((r) => [a("div", O, [i(n, { color: "#67C23A", "stroke-width": 16, percentage: r.row.rate }, null, 8, ["percentage"]), a("span", U, E(e(o).query.weightStatus === e(T).NET.V ? (r.row.sendMete / 1e3).toFixed(2) + " | " + (r.row.mete / 1e3).toFixed(2) : (r.row.sendGrossMete / 1e3).toFixed(2) + " | " + (r.row.grossMete / 1e3).toFixed(2)), 1)])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[k, e(o).loading]])]), s[0] || (s[0] = a("div", { style: { "border-right": "1px solid #ededed", height: "calc(100vh - 130px)" } }, null, -1)), a("div", G, [e(D)(l.value) ? (d(), _(N, { key: 0, workshopId: e(o).query.workshopId, weightStatus: e(o).query.weightStatus, "production-line-type-enum": e(o).query.productionLineTypeEnum, currentRow: l.value, permission: e(f) }, null, 8, ["workshopId", "weightStatus", "production-line-type-enum", "currentRow", "permission"])) : (d(), h("div", K, "*点击左表操作查看明细"))])])]);
  };
} }, se = F($, [["__scopeId", "data-v-faa58e9c"]]);
export {
  se as default
};
