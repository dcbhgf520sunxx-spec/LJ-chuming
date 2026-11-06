import { ref as u } from "vue";
import { inject as B } from "vue";
import { nextTick as D } from "vue";
import { onMounted as H } from "vue";
import { resolveComponent as G } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as U } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as V } from "vue";
import { withCtx as y } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as W } from "vue";
import { toDisplayString as L } from "vue";
import { unref as l } from "vue";
import { createElementVNode as M } from "vue";
import { mergeProps as F } from "vue";
import { Fragment as J } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { ElPagination as X } from "element-plus";
import { vLoading as $ } from "element-plus";
import { tC as K, J as O, b as g, wr as Y, c as _, iX as h, wd as i, i as T, T as Z } from "../../../../../../../shared/runtime.js";
const oe = { __name: "enclosure-table", props: { selectListHistory: { type: Array, default: () => [] } }, setup(ee, { expose: k }) {
  const c = u(), C = u([]), f = u(false), o = u([]), { form: m } = K(), r = B("customQuery"), { handleSizeChange: R, handleCurrentChange: S, total: A, setTotalPage: s, queryPage: d } = O({ fetchHook: w });
  function N(t) {
    var n;
    return ((n = m.list) == null ? void 0 : n.findIndex((e) => e.id === t.id)) === -1;
  }
  async function w() {
    if (o.value = [], g(r.value.branchCompanyId)) {
      o.value = [], s(0);
      return;
    }
    if (g(r.value.projectId)) {
      o.value = [], s(0);
      return;
    }
    try {
      await x();
    } catch (t) {
      console.log(t, "获取构件类型");
    }
  }
  async function x() {
    if (g(r.value.branchCompanyId)) {
      o.value = [], s(0);
      return;
    }
    if (g(r.value.projectId)) {
      o.value = [], s(0);
      return;
    }
    try {
      f.value = true;
      const { content: t, totalElements: n } = await Y({ ...r.value, ...d });
      o.value = t.map((e) => (e.totalLength = _(h(e.quantity * e.length, i.LENGTH_DP), i.LENGTH, "m"), e.totalArea = _(h(e.quantity * e.surfaceArea, i.AREA_DP), i.AREA, "m²"), e.totalWeight = _(h(e.quantity * e.weight, i.WEIGHT_DP), i.WEIGHT, "kg"), e.measureUnit = "张", e.accountingUnit = "千克", e)), f.value = false, s(n), await D(() => {
        T(m.list) && m.list.forEach((e) => {
          const p = o.value.find((b) => b.id === e.id);
          T(p) && c.value.toggleRowSelection(p, true);
        });
      });
    } catch (t) {
      console.log(t, "获取成品清单");
    }
  }
  function I(t) {
    c.value.toggleRowSelection(o.value.find((n) => n.id === t.id), false);
  }
  function P() {
    o.value.forEach((t) => {
      c.value.toggleRowSelection(t, false);
    });
  }
  function q(t) {
    C.value = t;
  }
  return H(() => {
    w();
  }), k({ refresh: w, refreshList: x, selectList: C, deleteRow: I, deleteAll: P }), (t, n) => {
    const e = Q, p = G("common-table"), b = X, z = $;
    return E(), U(J, null, [j((E(), V(p, F({ ref_key: "tableRef", ref: c, data: o.value, style: { width: "100%" } }, t.$attrs, { onSelectionChange: q }), { default: y(() => [a(e, { selectable: N, align: "center", type: "selection", width: "55" }), a(e, { align: "center", label: "序号", type: "index", width: "60" }), a(e, { align: "center", label: "类型", "min-width": "120px", prop: "category", "show-overflow-tooltip": "" }, { default: y(({ row: { sourceRow: v } }) => [W(L(l(Z).VL[v.category]), 1)]), _: 1 }), a(e, { align: "center", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "编号", "min-width": "120px", prop: "serialNumber", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "厚度（mm）", prop: "thickness", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "单长（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "计量单位", "min-width": "100px", prop: "measureUnit", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "数量", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "总长（m）", "min-width": "120px", prop: "totalLength", "show-overflow-tooltip": "" }, { default: y(({ row: { sourceRow: v } }) => [M("span", null, L(l(h)(v.totalLength, 2)), 1)]), _: 1 }), a(e, { align: "center", label: "面积（m²）", "min-width": "120px", prop: "totalArea", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "备注", prop: "remark", "show-overflow-tooltip": "" })]), _: 1 }, 16, ["data"])), [[z, f.value]]), a(b, { "current-page": l(d).pageNumber, "page-size": l(d).pageSize, total: l(A), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" }, onSizeChange: l(R), onCurrentChange: l(S) }, null, 8, ["current-page", "page-size", "total", "onSizeChange", "onCurrentChange"])], 64);
  };
} };
export {
  oe as default
};
