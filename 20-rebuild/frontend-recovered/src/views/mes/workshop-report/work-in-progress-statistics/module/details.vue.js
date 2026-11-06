import { ref as _ } from "vue";
import { inject as J } from "vue";
import { computed as C } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as P } from "vue";
import { createBlock as z } from "vue";
import { withCtx as a } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as o } from "vue";
import { unref as s } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as U } from "vue";
import { isRef as F } from "vue";
import { ElTag as G } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElPagination as Q } from "element-plus";
import { vLoading as X } from "element-plus";
import { a as Y } from "../../../../../modules/work-in-progress-statistics-5c372d83.js";
import { _ as Z, o as $, u as ee, J as te, p as ae, ba as ne } from "../../../../../shared/runtime.js";
const se = { class: "head-container content-header flex-rbc" }, le = { __name: "details", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentProcess: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(d, { emit: N }) {
  const I = N, u = d, p = _(false), y = _([]), v = _(), m = J("query"), q = [1e3, 1001, 1002], S = C(() => q.includes(u.currentProcess.processId) ? "制成品库存数据" : "在制品库存数据"), w = C(() => {
    var l, t;
    return { processId: ((l = u.currentProcess) == null ? void 0 : l.processId) || void 0, projectId: ((t = u.currentRow) == null ? void 0 : t.projectId) || void 0, ...m };
  }), { maxHeight: V } = $({ mainBox: ".work-in-progress-statistics-details", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, () => v.value.loaded), { visible: f, handleClose: j } = ee({ emit: I, props: u, field: "visible", showHook: T }), { handleSizeChange: B, handleCurrentChange: H, total: R, setTotalPage: W, queryPage: g } = te({ fetchHook: x });
  async function x() {
    let l = [];
    p.value = true;
    try {
      const { content: t = [], totalElements: c } = await Y({ ...w.value, ...g });
      l = t, W(c);
    } catch (t) {
      console.log(t);
    } finally {
      y.value = l, p.value = false;
    }
  }
  function D(l) {
    return ne(l, { props: ["quantity", "totalWeight"] });
  }
  function T() {
    g.pageNumber = 1, x();
  }
  return (l, t) => {
    const c = G, E = h("print-table"), i = K, L = h("common-table"), M = Q, O = h("common-drawer"), A = X;
    return P(), z(O, { ref_key: "drawerRef", ref: v, title: S.value, modelValue: s(f), "onUpdate:modelValue": t[0] || (t[0] = (e) => F(f) ? f.value = e : null), "before-close": s(j), "custom-class": "work-in-progress-statistics-details", size: "50%" }, { titleAfter: a(() => [n(c, { class: "filter-item", size: "default", effect: "plain" }, { default: a(() => {
      var e;
      return [b(" 项目：" + o(((e = d.currentRow) == null ? void 0 : e.projectName) || "-"), 1)];
    }), _: 1 }), n(c, { class: "filter-item", size: "default", effect: "plain" }, { default: a(() => {
      var e;
      return [b(" 工序：" + o(((e = d.currentProcess) == null ? void 0 : e.processName) || "-"), 1)];
    }), _: 1 }), n(c, { class: "filter-item", size: "default", effect: "plain" }, { default: a(() => {
      var e, k;
      return [b(" 统计日期：" + o((e = s(m)) != null && e.date ? s(ae)((k = s(m)) == null ? void 0 : k.date, "{y}-{m}-{d}") : "-"), 1)];
    }), _: 1 })]), content: a(() => [r("div", se, [t[1] || (t[1] = r("div", null, null, -1)), n(E, { "api-key": "workInProgressInventoryStatistics", params: w.value, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"])]), U((P(), z(L, { data: y.value, "max-height": s(V), "show-empty-symbol": false, style: { width: "100%" }, "show-summary": "", "summary-method": D }, { default: a(() => [n(i, { label: "序号", type: "index", align: "center", width: "60" }), n(i, { label: "编号", prop: "serialNumber", key: "serialNumber", align: "center" }, { default: a((e) => [r("div", null, o(e.row.serialNumber || "-"), 1)]), _: 1 }), n(i, { label: "规格", prop: "specification", key: "specification", align: "center" }, { default: a((e) => [r("div", null, o(e.row.specification || "-"), 1)]), _: 1 }), n(i, { label: "数量", prop: "quantity", key: "quantity", align: "center" }, { default: a((e) => [r("div", null, o(e.row.quantity ?? "-"), 1)]), _: 1 }), n(i, { label: "单重（kg）", prop: "netWeight", key: "netWeight", align: "center" }, { default: a((e) => [r("div", null, o(e.row.netWeight ?? "-"), 1)]), _: 1 }), n(i, { label: "总重（kg）", prop: "totalWeight", key: "totalWeight", align: "center" }, { default: a((e) => [r("div", null, o(e.row.totalWeight ?? "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[A, p.value]]), n(M, { total: s(R), "current-page": s(g).pageNumber, "page-sizes": [10, 20, 30, 40, 50, 100, 200, 500], style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: s(B), onCurrentChange: s(H) }, null, 8, ["total", "current-page", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ce = Z(le, [["__scopeId", "data-v-32843d8a"]]);
export {
  ce as default
};
