import { o as d } from "../../../../shared/runtime.js";
import u from "./module/component-card.vue.js";
import p from "./module/order-card.vue.js";
import _ from "./module/unit-card.vue.js";
import { ref as i } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as r } from "vue";
import { unref as c } from "vue";
import "../../../../modules/member-binding-2f5cdd6e.js";
const g = { class: "app-container" }, w = { style: { display: "flex", "justify-content": "space-between" } }, B = { __name: "index", setup(v) {
  const s = i({}), o = i([]), m = (e) => {
    console.log(e), s.value = e;
  }, { maxHeight: t } = d(), l = (e) => {
    o.value = [], e.forEach((a) => {
      const n = { number: void 0, productId: void 0 };
      n.number = a.number, n.productId = a.productId, o.value.push(n);
    }), console.log(o.value);
  };
  return (e, a) => (f(), h("div", g, [x("div", w, [r(p, { onOrderRowClick: m, maxHeight: c(t) }, null, 8, ["maxHeight"]), r(u, { "row-data": s.value, onComponentRowClick: l, maxHeight: c(t) }, null, 8, ["row-data", "maxHeight"]), r(_, { "row-data": o.value, maxHeight: c(t) }, null, 8, ["row-data", "maxHeight"])])]));
} };
export {
  B as default
};
