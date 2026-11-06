import { ref as g } from "vue";
import { computed as A } from "vue";
import { resolveComponent as u } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as y } from "vue";
import { createBlock as k } from "vue";
import { withCtx as s } from "vue";
import { withDirectives as C } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createElementVNode as h } from "vue";
import { toDisplayString as _ } from "vue";
import { isRef as U } from "vue";
import { ElTableColumn as F } from "element-plus";
import { ElTooltip as J } from "element-plus";
import { ElPagination as W } from "element-plus";
import { vLoading as G } from "element-plus";
import { s as K } from "../../../../../../modules/main-material-track-74a129d5.js";
import { u as Q, J as X, o as Y, cO as Z, jl as $, py as ee, pz as te, pA as ae, i as oe, pB as x } from "../../../../../../shared/runtime.js";
const se = { __name: "stock-detail", props: { visible: { type: Boolean, default: false }, projectId: { type: Number }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(B, { emit: I }) {
  const w = g(), P = I, r = B, { visible: m, handleClose: z } = Q({ emit: P, props: r, field: "visible", showHook: v }), { handleSizeChange: T, handleCurrentChange: M, total: S, setTotalPage: j, queryPage: d } = X({ fetchHook: v }), { maxHeight: L } = Y({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, w), f = g(false), p = g([]), b = A(() => {
    var o, n, l, c;
    return { projectId: r.projectId, basicId: (o = r.info) == null ? void 0 : o.basicId, configId: (n = r.info) == null ? void 0 : n.configId, material: (l = r.info) == null ? void 0 : l.material, thickness: (c = r.info) == null ? void 0 : c.thickness };
  });
  async function v() {
    try {
      f.value = true;
      const { content: o, totalElements: n } = await K({ ...b.value, ...d });
      j(n), p.value = o.map((l, c) => (l.rowId = c + "" + Math.random(), l)), Z(p.value), await $(p.value, { toSmallest: false, toNum: false, accountingUnit: "kg", accountingPrecision: 2 });
    } catch (o) {
      console.log("获取库存明细失败", o);
    } finally {
      f.value = false;
    }
  }
  return (o, n) => {
    const l = u("print-table"), c = u("table-cell-tag"), i = F, N = J, R = u("common-table"), V = W, E = u("common-drawer"), H = O("permission"), q = G;
    return y(), k(E, { ref_key: "drawerRef", ref: w, title: "库存明细", modelValue: e(m), "onUpdate:modelValue": n[0] || (n[0] = (a) => U(m) ? m.value = a : null), direction: "rtl", "before-close": e(z), size: "70%" }, { titleRight: s(() => [C(t(l, { "api-key": "mesMainMaterialTrackStock", params: b.value, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[H, e(ee).stockPrint]])]), content: s(() => [C((y(), k(R, { data: p.value, "max-height": e(L), style: { width: "100%" } }, { default: s(() => [t(i, { label: "序号", type: "index", align: "center", width: "60" }, { default: s(({ row: a, $index: D }) => [t(c, { show: !!a.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), h("span", null, _(D + 1), 1)]), _: 1 }), t(i, { prop: "classifyName", "show-overflow-tooltip": true, label: "名称", align: "center", "min-width": "140" }), t(i, { "show-overflow-tooltip": true, label: "规格", align: "center", "min-width": "200" }, { default: s(({ row: a }) => [t(N, { content: e(te)(a), placement: "left" }, { default: s(() => [h("span", null, _(e(ae)(a)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), t(i, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center", width: "90" }), t(i, { prop: "mete", "show-overflow-tooltip": true, label: "重量(kg)", align: "center", width: "100" }), t(i, { "show-overflow-tooltip": true, label: "库存", align: "center", width: "100" }, { default: s(({ row: a }) => [h("span", null, _(e(oe)(a.project) ? e(x).PROJECT.L : e(x).PUBLIC.L), 1)]), _: 1 }), t(i, { prop: "warehouse.name", "show-overflow-tooltip": true, label: "库位", align: "center", "min-width": "120" })]), _: 1 }, 8, ["data", "max-height"])), [[q, f.value]]), t(V, { total: e(S), "current-page": e(d).pageNumber, "page-size": e(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: e(T), onCurrentChange: e(M) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  se as default
};
