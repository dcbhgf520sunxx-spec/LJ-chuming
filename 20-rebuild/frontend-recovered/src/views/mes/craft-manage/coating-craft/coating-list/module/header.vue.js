import { _ as o, B as n, E as _ } from "../../../../../../shared/runtime.js";
import { resolveComponent as c } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as e } from "vue";
import { withCtx as l } from "vue";
import { unref as t } from "vue";
const d = { class: "head-container" }, u = { __name: "header", setup(m) {
  const a = {}, { query: s } = n(a);
  return (f, h) => {
    const r = c("print-table");
    return p(), i("div", d, [e(t(_), null, { viewLeft: l(() => [e(r, { "api-key": "coatingProcess", params: { ...t(s) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"])]), _: 1 })]);
  };
} }, x = o(u, [["__scopeId", "data-v-f3254109"]]);
export {
  x as default
};
