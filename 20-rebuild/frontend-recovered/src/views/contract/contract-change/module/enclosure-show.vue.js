import { ref as T } from "vue";
import { watch as p } from "vue";
import { computed as S } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as b } from "vue";
import { withCtx as i } from "vue";
import { Fragment as h } from "vue";
import { renderList as A } from "vue";
import { unref as d } from "vue";
import { createBlock as m } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as _ } from "vue";
import { ElRadioGroup as g } from "element-plus";
import { resolveDynamicComponent as L } from "vue";
import { ElRadioButton as v } from "element-plus";
import { _ as O, dn as e } from "../../../../shared/runtime.js";
import P from "./enclosure-table/sandwich-table.vue.js";
import U from "./enclosure-table/pressed-color-table.vue.js";
import w from "./enclosure-table/pressed-support-table.vue.js";
import y from "./enclosure-table/structure-table.vue.js";
import I from "./enclosure-table/truss-support-table.vue.js";
import "../../../../modules/judgeSameValue-9683bdce.js";
import "../../../../modules/index-61ce89a1.js";
const C = { __name: "enclosure-show", props: { tableData: { type: Object, default: () => ({ [e.STRUCTURE.V]: [], [e.PROFILED_PLATE.V]: [], [e.TRUSS_FLOOR_PLATE.V]: [], [e.PRESSURE_BEARING_PLATE.V]: [], [e.SANDWICH_BOARD.V]: [] }) }, showItem: { type: Array, default: () => [] }, originData: { type: Object, default: () => ({ [e.STRUCTURE.V]: [], [e.PROFILED_PLATE.V]: [], [e.TRUSS_FLOOR_PLATE.V]: [], [e.PRESSURE_BEARING_PLATE.V]: [], [e.SANDWICH_BOARD.V]: [] }) } }, emits: ["click-change"], setup(t, { emit: f }) {
  const l = t, n = T(), E = f;
  p(() => l.showItem, (o) => {
    o.length > 0 && (n.value = l.showItem[0], s(n.value));
  }, { deep: true, immediate: true });
  const R = S(() => {
    switch (n.value) {
      case e.STRUCTURE.V:
        return y;
      case e.PROFILED_PLATE.V:
        return U;
      case e.TRUSS_FLOOR_PLATE.V:
        return I;
      case e.PRESSURE_BEARING_PLATE.V:
        return w;
      case e.SANDWICH_BOARD.V:
        return P;
      default:
        return null;
    }
  });
  function s(o) {
    E("click-change", o);
  }
  return (o, u) => {
    const V = v;
    return r(), c("div", null, [b(d(g), { modelValue: n.value, "onUpdate:modelValue": u[0] || (u[0] = (a) => n.value = a), size: "default", class: "filter-item", onChange: s, style: { "margin-bottom": "10px" } }, { default: i(() => [(r(true), c(h, null, A(d(e).ENUM, (a) => (r(), m(V, { key: a.V, value: a.V, disabled: t.showItem.indexOf(a.V) < 0 }, { default: i(() => [D(_(a.L) + _(t.tableData[a.V] && t.tableData[a.V].length ? `(${t.tableData[a.V].length})` : ""), 1)]), _: 2 }, 1032, ["value", "disabled"]))), 128))]), _: 1 }, 8, ["modelValue"]), (r(), m(L(R.value), { "table-data": t.tableData[n.value], "origin-data": t.originData[n.value], "is-show": true }, null, 8, ["table-data", "origin-data"]))]);
  };
} }, W = O(C, [["__scopeId", "data-v-fb88bc40"]]);
export {
  W as default
};
