import { ref as x } from "vue";
import { computed as b } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as m } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as k } from "vue";
import { createCommentVNode as q } from "vue";
import { ElTableColumn as P } from "element-plus";
import { vLoading as D } from "element-plus";
import { l as R, x as B, ni as S, o as H, P as L } from "../../../../shared/runtime.js";
import { _ as N } from "../../../../modules/index-3b2628f3.js";
import { _ as V } from "../../../../modules/index-490fd9d7.js";
import $ from "./module/header.vue.js";
import "../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../modules/production-line-select-f08e245b.js";
function A(c) {
  return R({ module: "mes", url: "produce_surplus/page", method: "get", params: c });
}
const E = { get: A }, F = { class: "app-container" }, M = { class: "head-container" }, I = { __name: "index", setup(c) {
  const p = { add: false, edit: false, del: false, download: false }, i = x(), { crud: o, columns: s, CRUD: d } = B({ title: "多余列表", permission: { ...S }, sort: [], optShow: { ...p }, crudApi: { ...E } }, i), { maxHeight: _ } = H({ paginate: true }), h = b(() => o.query.productType);
  return d.HOOK.handleRefresh = (f, n) => {
    n.data.content = n.data.content.map((a) => a);
  }, (f, n) => {
    const a = P, y = v("common-table"), w = D;
    return r(), C("div", F, [l("div", M, [t(e($))]), T((r(), m(y, { ref_key: "tableRef", ref: i, data: e(o).data, "empty-text": e(o).emptyText, "max-height": e(_), style: { width: "100%" } }, { default: u(() => [t(a, { label: "序号", type: "index", align: "center", width: "60" }), t(e(N), { columns: e(s), showProject: "", showFactory: "", showWorkshop: "", showProductionLine: "", showProcess: "", showTeam: "" }, null, 8, ["columns"]), t(e(V), { productType: h.value, columns: e(s), unShowField: ["specification", "material", "name"] }, null, 8, ["productType", "columns"]), e(s).visible("quantity") ? (r(), m(a, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "多余数量", align: "center" }, { default: u((g) => [l("span", null, k(g.row.quantity), 1)]), _: 1 })) : q("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[w, e(o).loading]]), t(e(L))]);
  };
} };
export {
  I as default
};
