import { ref as p } from "vue";
import { inject as j } from "vue";
import { nextTick as D } from "vue";
import { onMounted as H } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as W } from "vue";
import { withDirectives as G } from "vue";
import { createBlock as V } from "vue";
import { withCtx as g } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as A } from "vue";
import { toDisplayString as _ } from "vue";
import { createElementVNode as I } from "vue";
import { unref as l } from "vue";
import { mergeProps as M } from "vue";
import { Fragment as F } from "vue";
import { ElTableColumn as J } from "element-plus";
import { ElPagination as Q } from "element-plus";
import { vLoading as X } from "element-plus";
import { tC as $, J as K, b as d, ws as O, c as Y, iX as f, wd as L, i as S } from "../../../../../../../shared/runtime.js";
const ae = { __name: "structure-table", props: { selectListHistory: { type: Array, default: () => [] } }, setup(Z, { expose: k }) {
  const c = p(), y = p([]), h = p(false), o = p([]), { form: m } = $(), i = j("customQuery"), { handleSizeChange: N, handleCurrentChange: R, total: E, setTotalPage: s, queryPage: w } = K({ fetchHook: v });
  function q(t) {
    var n;
    return ((n = m.list) == null ? void 0 : n.findIndex((e) => e.productId === t.productId)) === -1;
  }
  async function v() {
    if (o.value = [], d(i.value.branchCompanyId)) {
      o.value = [], s(0);
      return;
    }
    if (d(i.value.projectId)) {
      o.value = [], s(0);
      return;
    }
    console.log(i.value, "231231");
    try {
      await C();
    } catch (t) {
      console.log(t, "获取构件类型");
    }
  }
  async function C() {
    if (d(i.value.branchCompanyId)) {
      o.value = [], s(0);
      return;
    }
    if (d(i.value.projectId)) {
      o.value = [], s(0);
      return;
    }
    try {
      h.value = true;
      const { content: t, totalElements: n } = await O({ ...i.value, ...w });
      o.value = t.map((e) => (e.totalLength = Y(f(e.quantity * e.length, L.LENGTH_DP), L.LENGTH, "m"), e.totalWeight = f(e.quantity * e.netWeight, 2), e.measureUnit = "件", e.accountingUnit = "千克", e)), h.value = false, s(n), await D(() => {
        S(m.list) && m.list.forEach((e) => {
          const u = o.value.find((b) => b.productId === e.productId);
          S(u) && c.value.toggleRowSelection(u, true);
        });
      });
    } catch (t) {
      console.log(t, "获取成品清单");
    }
  }
  function z(t) {
    c.value.toggleRowSelection(o.value.find((n) => n.productId === t.productId), false);
  }
  function P() {
    o.value.forEach((t) => {
      c.value.toggleRowSelection(t, false);
    });
  }
  function T(t) {
    y.value = t;
  }
  return H(() => {
    v();
  }), k({ refresh: v, refreshList: C, selectList: y, deleteRow: z, deleteAll: P }), (t, n) => {
    const e = J, u = U("common-table"), b = Q, B = X;
    return x(), W(F, null, [G((x(), V(u, M({ ref_key: "tableRef", ref: c, data: o.value, style: { width: "100%" } }, t.$attrs, { onSelectionChange: T }), { default: g(() => [a(e, { selectable: q, align: "center", type: "selection", width: "55" }), a(e, { align: "center", label: "序号", type: "index", width: "60" }), a(e, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "编号", "min-width": "100px", prop: "serialNumber", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "长度（mm）", prop: "length", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), a(e, { align: "center", label: "数量", "min-width": "100px", "show-overflow-tooltip": "" }, { default: g(({ row: { sourceRow: r } }) => [A(_(r.quantity), 1)]), _: 1 }), a(e, { align: "center", label: "单重（kg）", "min-width": "120px", "show-overflow-tooltip": "" }, { default: g(({ row: { sourceRow: r } }) => [I("span", null, _(l(f)(r.netWeight, 2)), 1)]), _: 1 }), a(e, { align: "center", label: "总重（kg）", "min-width": "120px", "show-overflow-tooltip": "" }, { default: g(({ row: { sourceRow: r } }) => [I("span", null, _(l(f)(r.quantity * r.netWeight, 2)), 1)]), _: 1 })]), _: 1 }, 16, ["data"])), [[B, h.value]]), a(b, { "current-page": l(w).pageNumber, "page-size": l(w).pageSize, total: l(E), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" }, onSizeChange: l(N), onCurrentChange: l(R) }, null, 8, ["current-page", "page-size", "total", "onSizeChange", "onCurrentChange"])], 64);
  };
} };
export {
  ae as default
};
