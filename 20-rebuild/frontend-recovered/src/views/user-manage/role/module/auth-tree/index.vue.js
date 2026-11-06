import d from "./TableItem.vue.js";
import { _ as u } from "../../../../../shared/runtime.js";
import { ref as m } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as c } from "vue";
import { Fragment as p } from "vue";
import { renderList as y } from "vue";
import { createBlock as k } from "vue";
import "./TableCheckBox.vue.js";
const f = { class: "table-tree" }, v = { __name: "index", props: { dataSource: { type: Array, default: () => [] }, keys: { type: Array, default: () => [] } }, emits: ["change"], setup(s, { emit: l }) {
  const n = s, i = l, e = m(/* @__PURE__ */ new Set([...n.keys]));
  function _(o, t) {
    o ? e.value.add(t) : e.value.delete(t), i("change", e.value.values());
  }
  return (o, t) => (a(), c("div", f, [(a(true), c(p, null, y(n.dataSource, (r) => (a(), k(d, { key: r.key, item: r, keys: s.keys, onOnClick: _ }, null, 8, ["item", "keys"]))), 128))]));
} }, S = u(v, [["__scopeId", "data-v-04b82b62"]]);
export {
  S as default
};
