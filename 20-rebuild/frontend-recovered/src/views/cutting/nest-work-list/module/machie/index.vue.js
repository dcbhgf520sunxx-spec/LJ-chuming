import { openBlock as a } from "vue";
import { createElementBlock as c } from "vue";
import { Fragment as d } from "vue";
import { renderList as r } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as p } from "vue";
import { ElTag as m } from "element-plus";
import { _ as h } from "../../../../../shared/runtime.js";
const g = { class: "production-lines-content" }, y = { __name: "index", props: { machineData: { type: Array, default: () => [] }, selectLineId: { type: Number, default: void 0 }, isSingle: { type: Boolean, default: false } }, emits: ["change"], setup(t, { emit: s }) {
  const i = s;
  function o(n) {
    i("change", n);
  }
  return (n, x) => {
    const l = m;
    return a(), c("div", g, [(a(true), c(d, null, r(t.machineData, (e) => (a(), _(l, { effect: t.selectLineId === e.id ? "light" : "plain", type: t.selectLineId === e.id ? "success" : "info", class: "elTag", hit: "", onClick: (k) => o(e), key: e.id }, { default: u(() => [f(p(e.machineName), 1)]), _: 2 }, 1032, ["effect", "type", "onClick"]))), 128))]);
  };
} }, B = h(y, [["__scopeId", "data-v-dc72394a"]]);
export {
  B as default
};
