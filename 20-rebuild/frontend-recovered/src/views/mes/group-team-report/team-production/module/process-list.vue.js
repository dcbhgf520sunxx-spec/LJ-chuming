import { ref as G } from "vue";
import { inject as d } from "vue";
import { watch as M } from "vue";
import { nextTick as R } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as O } from "vue";
import { unref as _ } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as c } from "vue";
import { createVNode as l } from "vue";
import { toDisplayString as s } from "vue";
import { Fragment as j } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as F } from "element-plus";
import { o as L, fo as w, c as W, D as k } from "../../../../../shared/runtime.js";
const A = { __name: "process-list", emits: ["nesting-task-click", "selectionChange"], setup(P, { emit: v }) {
  const u = G(null), y = d("tableData"), C = d("loading"), m = d("weightType"), T = v;
  function E(e) {
    T("nesting-task-click", e);
  }
  const { maxHeight: N } = L({ paginate: true });
  function x(e) {
    T("selectionChange", e);
  }
  function H(e) {
    let n = 0;
    return m.value === w.NET_WEIGHT.V ? n = e.reportNetWeight : n = e.reportGrossWeight, n ? W(n, "kg", "t", k.COM_WT__T) : 0;
  }
  function Q(e) {
    let n = 0;
    return m.value === w.NET_WEIGHT.V ? n = e.netWeight : n = e.grossWeight, n ? W(n, "kg", "t", k.COM_WT__T) : 0;
  }
  function V(e) {
    const { columns: n, data: o } = e, i = [], g = (t, a) => {
      const h = o.reduce((f, p) => f + (p[t] || 0), 0), B = o.reduce((f, p) => {
        const D = m.value === w.NET_WEIGHT.V ? p[a] || 0 : p.grossWeight || 0;
        return f + D;
      }, 0);
      return `${h}/${W(B, "kg", "t", k.COM_WT__T)}`;
    };
    return n.forEach((t, a) => {
      if (a === 1) {
        i[a] = "合计";
        return;
      }
      switch (t.property) {
        case "reportNetWeight":
          i[a] = g("reportQuantity", "reportNetWeight");
          break;
        case "netWeight":
          i[a] = g("inspectionQuantity", "netWeight");
          break;
        default:
          i[a] = "";
      }
    }), i;
  }
  return M(y, (e) => {
    e && e.length > 0 && R(() => {
      u.value && (console.log(u.value), u.value.setCurrentRow(e[0]));
    });
  }, { immediate: true }), (e, n) => {
    const o = q, i = S("common-table"), g = F;
    return b(), I(j, null, [n[0] || (n[0] = r("div", { class: "head-container" }, null, -1)), O((b(), $(i, { ref_key: "tableRef", ref: u, "highlight-current-row": "", data: _(y), "return-source-data": "", "row-key": (t) => {
      var a;
      return (a = t.team) == null ? void 0 : a.id;
    }, stripe: false, "max-height": _(N) - 15, style: { width: "100%", cursor: "pointer" }, "show-summary": "", "summary-method": V, onCurrentChange: E, onSelectionChange: x }, { default: c(() => [l(o, { key: "selection", type: "selection", width: "40", fixed: "left" }), l(o, { label: "序号", type: "index", align: "center", width: "50", fixed: "left" }), l(o, { prop: "process.name", "show-overflow-tooltip": true, label: "工序", width: "80", align: "center" }, { default: c(({ row: t }) => {
      var a;
      return [r("span", null, s((a = t.process) == null ? void 0 : a.name), 1)];
    }), _: 1 }), l(o, { prop: "groups.name", "show-overflow-tooltip": true, label: "班组", "min-width": "125", "header-align": "center" }, { default: c(({ row: t }) => {
      var a, h;
      return [r("span", null, s((a = t.workshop) == null ? void 0 : a.name) + ">" + s((h = t.team) == null ? void 0 : h.name), 1)];
    }), _: 1 }), l(o, { prop: "reportNetWeight", "show-overflow-tooltip": true, label: "上报产量（件/吨）", width: "124", align: "center" }, { default: c(({ row: t }) => [r("span", null, s(t.reportQuantity) + "/" + s(H(t)), 1)]), _: 1 }), l(o, { prop: "netWeight", "show-overflow-tooltip": true, label: "质检（件/吨）", width: "120", align: "center" }, { default: c(({ row: t }) => [r("span", null, s(t.inspectionQuantity) + "/" + s(Q(t)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "row-key", "max-height"])), [[g, _(C)]])], 64);
  };
} };
export {
  A as default
};
