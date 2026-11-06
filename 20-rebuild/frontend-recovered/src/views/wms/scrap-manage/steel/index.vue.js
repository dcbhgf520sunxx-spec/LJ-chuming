import { computed as y } from "vue";
import { ref as d } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as T } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as c } from "vue";
import { withCtx as S } from "vue";
import { createCommentVNode as p } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as D } from "element-plus";
import { l as N, t as P, jX as j, bD as R, D as l, aA as B, x as E, Cp as q, o as V, cO as U, jl as $, jG as H, jH as L, k5 as O, k6 as M, pB as Y, P as F } from "../../../../shared/runtime.js";
import I from "./module/header.vue.js";
function K(i) {
  return N({ module: "wms", url: "scrap/steel", method: "get", params: i });
}
const W = { class: "app-container" }, z = { __name: "index", setup(i) {
  const { decimalPrecision: r } = P(), f = { batchAdd: false, add: false, edit: false, del: false, download: false }, h = y(() => [...j, ["invoiceType", ["parse-enum", R, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", r.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", r.value.wms]], ["amount", ["to-thousand", l.YUAN]], ["amountExcludingVAT", ["to-thousand", l.YUAN]], ["inputVAT", ["to-thousand", l.YUAN]], ...B]), _ = d([]), u = d(), { CRUD: b, crud: a, columns: s } = E({ title: "废料列表", sort: ["id.desc"], invisibleColumns: ["warehouse"], permission: { ...q }, optShow: { ...f }, crudApi: { get: K } }, u), { maxHeight: w } = V({ paginate: true });
  return b.HOOK.handleRefresh = async (g, { data: o }) => {
    await U(o.content), o.content = await $(o.content, { toSmallest: false, toNum: false });
  }, (g, o) => {
    const m = A, v = x("common-table"), C = D;
    return n(), T("div", W, [t(e(I)), k((n(), c(v, { key: `scrap_steel_${e(a).query.basicClass}`, ref_key: "tableRef", ref: u, data: e(a).data, "data-format": h.value, "max-height": e(w), "default-expand-all": false, "expand-row-keys": _.value, "row-key": "id", onSortChange: e(a).handleSortChange }, { default: S(() => [t(H, { columns: e(s), "basic-class": e(a).query.basicClass, fixed: "left" }, null, 8, ["columns", "basic-class"]), t(L, { columns: e(s), "basic-class": e(a).query.basicClass }, null, 8, ["columns", "basic-class"]), t(O, { columns: e(s), "basic-class": e(a).query.basicClass }, null, 8, ["columns", "basic-class"]), t(M, { columns: e(s), "show-project": e(a).query.projectWarehouseType === e(Y).PROJECT.V }, null, 8, ["columns", "show-project"]), e(s).visible("createTime") ? (n(), c(m, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "生成日期", align: "center", width: "140", sortable: "custom" })) : p("", true), e(s).visible("convertNumber") ? (n(), c(m, { key: "convertNumber", "show-overflow-tooltip": true, prop: "convertNumber", label: "来源", align: "center", width: "120", sortable: "custom" })) : p("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys", "onSortChange"])), [[C, e(a).loading]]), t(e(F))]);
  };
} };
export {
  z as default
};
