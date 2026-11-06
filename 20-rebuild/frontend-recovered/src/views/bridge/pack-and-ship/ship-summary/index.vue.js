import { ref as c } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as h } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as j } from "vue";
import { ElTableColumn as E } from "element-plus";
import { ElProgress as P } from "element-plus";
import { vLoading as S } from "element-plus";
import { c as B } from "../../../../modules/ship-summary-9143cc4e.js";
import { u as f } from "../../../../modules/bridge-86f96a4f.js";
import { _ as I, x as M, o as D, P as F, i as H } from "../../../../shared/runtime.js";
import q from "./module/header.vue.js";
import N from "./module/project-shipment-detail.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const T = { class: "app-container" }, A = { style: { display: "flex" } }, L = { style: { width: "30%", "padding-right": "10px" } }, O = { style: { position: "relative" } }, U = { style: { position: "absolute", top: "-2px", left: "0", width: "100%", "text-align": "right", "padding-right": "60px" } }, V = { style: { flex: "1", "padding-left": "10px" } }, K = { key: 1, class: "my-code" }, $ = { __name: "index", setup(z) {
  const g = { add: false, edit: false, del: false, download: false }, x = c([["project", "parse-project"]]), m = c(), d = c({}), { crud: i, CRUD: y } = M({ title: "发运管理", sort: [], permission: { ...f }, dataPath: "", optShow: { ...g }, crudApi: { ...B }, hasPagination: true }, m), { maxHeight: w } = D();
  y.HOOK.handleRefresh = (l, { data: r }) => {
    r.forEach((e) => {
      var s;
      e.projectId = (s = e.project) == null ? void 0 : s.id, e.rate = e.sendMete && e.mete ? (e.sendMete / e.mete * 100).toFixed(2) : 0;
    });
  };
  function b(l) {
    d.value = l;
  }
  return (l, r) => {
    const e = E, s = P, v = C("common-table"), k = S;
    return n(), _("div", T, [o("div", A, [o("div", L, [a(t(q)), R((n(), h(v, { ref_key: "tableRef", ref: m, data: t(i).data, "data-format": x.value, "empty-text": t(i).emptyText, onCurrentChange: b, "highlight-current-row": "", "max-height": t(w), style: { width: "100%", "margin-top": "10px" }, stripe: false, showEmptySymbol: false }, { default: u(() => [a(e, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), a(e, { key: "project", prop: "project", label: "项目", align: "left", "show-overflow-tooltip": "", "min-width": "120" }), a(e, { key: "rate", prop: "rate", label: "发运数据(kg)", align: "center", "min-width": "160", "show-overflow-tooltip": "" }, { default: u((p) => [o("div", O, [a(s, { "stroke-width": 16, percentage: p.row.rate }, null, 8, ["percentage"]), o("span", U, j(p.row.sendMete.toFixed(2) + " | " + p.row.mete.toFixed(2)), 1)])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[k, t(i).loading]]), a(t(F))]), r[0] || (r[0] = o("div", { style: { "border-right": "1px solid #ededed", height: "calc(100vh - 130px)" } }, null, -1)), o("div", V, [t(H)(d.value) ? (n(), h(N, { key: 0, workshopId: t(i).query.workshopId, "production-line-type-enum": t(i).query.productionLineTypeEnum, currentRow: d.value, permission: t(f) }, null, 8, ["workshopId", "production-line-type-enum", "currentRow", "permission"])) : (n(), _("div", K, "*点击左表操作查看明细"))])])]);
  };
} }, oe = I($, [["__scopeId", "data-v-55a8652b"]]);
export {
  oe as default
};
