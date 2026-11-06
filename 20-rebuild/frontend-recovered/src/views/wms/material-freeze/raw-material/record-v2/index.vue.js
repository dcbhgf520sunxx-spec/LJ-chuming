import { ref as c } from "vue";
import { computed as m } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as j } from "vue";
import { withCtx as f } from "vue";
import { createElementVNode as B } from "vue";
import { vLoading as z } from "element-plus";
import { l as E, _ as S, jX as $, x as q, y6 as L, o as P, am as T, pB as F, cO as M, jl as U, aR as D, y7 as H, jG as I, jH as O, k5 as V, k6 as A, P as K } from "../../../../../shared/runtime.js";
import N from "./module/header.vue.js";
function Q(i) {
  return E({ module: "wms", url: "freeze/raw-material", method: "get", params: i });
}
const W = { get: Q };
const G = { class: "app-container" }, J = { class: "flex-rsc mtb-20", style: { "margin-left": "30px" } }, X = { __name: "index", setup(i) {
  const _ = { add: false, edit: false, del: false, download: false }, u = c(), p = c(), l = c([]), y = c([...$]), { CRUD: w, crud: s, columns: t } = q({ title: "钢材物料仓", sort: ["id.desc"], invisibleColumns: [], requiredQuery: ["basicClass"], permission: { ...L }, optShow: { ..._ }, crudApi: { ...W } }, u), { maxHeight: h } = P({ paginate: true }), r = m(() => s.query.basicClass || T.STEEL_PLATE.V), x = m(() => s.query.projectWarehouseType === F.PROJECT.V);
  return w.HOOK.handleRefresh = async (b, { data: o }) => {
    await M(o.content), o.content = await U(o.content, { toSmallest: false, toNum: false });
  }, (b, o) => {
    const v = k("common-table"), g = z;
    return d(), C("div", G, [a(e(N), { ref_key: "headerRef", ref: p }, null, 512), R((d(), j(v, { key: `material_freeze_${e(s).query.basicClass}`, ref_key: "tableRef", ref: u, data: e(s).data, "data-format": y.value, "default-expand-all": true, "expand-row-keys": l.value, "max-height": e(h), "row-key": "id" }, { default: f(() => [a(D, { "expand-row-keys": l.value, "onUpdate:expandRowKeys": o[0] || (o[0] = (n) => l.value = n), data: e(s).data, "row-key": "id" }, { default: f(({ row: { sourceRow: n } }) => [B("div", J, [a(H, { material: n, records: n.recordList, stripe: false, class: "table-border-none", mode: "incoming", onUnfreezeSuccess: e(s).toQuery }, null, 8, ["material", "records", "onUnfreezeSuccess"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), a(I, { "basic-class": r.value, columns: e(t) }, null, 8, ["basic-class", "columns"]), a(O, { "basic-class": r.value, columns: e(t), "label-prefix": "冻结", meteField: "frozenMete", quantityField: "frozenQuantity" }, null, 8, ["basic-class", "columns"]), a(V, { "basic-class": r.value, columns: e(t) }, null, 8, ["basic-class", "columns"]), a(A, { columns: e(t), "show-area": false, "show-monomer": false, "show-project": x.value }, null, 8, ["columns", "show-project"])]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])), [[g, e(s).loading]]), a(e(K))]);
  };
} }, ae = S(X, [["__scopeId", "data-v-05ffc13c"]]);
export {
  ae as default
};
