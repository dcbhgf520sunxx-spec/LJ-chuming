import { ref as v } from "vue";
import { watch as w } from "vue";
import { computed as V } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as g } from "vue";
import { withCtx as d } from "vue";
import { Fragment as y } from "vue";
import { renderList as T } from "vue";
import { unref as i } from "vue";
import { createBlock as m } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as f } from "vue";
import { ElRadioGroup as C } from "element-plus";
import { resolveDynamicComponent as D } from "vue";
import { ElRadioButton as E } from "element-plus";
import { _ as U, jw as n } from "../../../../shared/runtime.js";
import k from "./enclosure-table/structure-table.vue.js";
const R = { __name: "enclosure-show", props: { tableData: { type: Object, default: () => ({ [n.STRUCTURE.V]: [] }) }, showItem: { type: Array, default: () => [] } }, emits: ["click-change"], setup(a, { emit: h }) {
  const s = a, t = v(), p = h;
  w(() => s.showItem, (l) => {
    l.length > 0 && (t.value = s.showItem[0], u(t.value));
  }, { deep: true, immediate: true });
  const _ = V(() => {
    switch (t.value) {
      case n.STRUCTURE.V:
        return k;
      default:
        return null;
    }
  });
  function u(l) {
    p("click-change", l);
  }
  return (l, r) => {
    const b = E;
    return o(), c("div", null, [g(i(C), { modelValue: t.value, "onUpdate:modelValue": r[0] || (r[0] = (e) => t.value = e), size: "default", class: "filter-item", onChange: u, style: { "margin-bottom": "10px" } }, { default: d(() => [(o(true), c(y, null, T(i(n).ENUM, (e) => (o(), m(b, { key: e.V, value: e.V, disabled: a.showItem.indexOf(e.V) < 0 }, { default: d(() => [x(f(e.L) + f(a.tableData[e.V] && a.tableData[e.V].length ? `(${a.tableData[e.V].length})` : ""), 1)]), _: 2 }, 1032, ["value", "disabled"]))), 128))]), _: 1 }, 8, ["modelValue"]), (o(), m(D(_.value), { "table-data": a.tableData[t.value], "is-show": true }, null, 8, ["table-data"]))]);
  };
} }, N = U(R, [["__scopeId", "data-v-452f73d9"]]);
export {
  N as default
};
