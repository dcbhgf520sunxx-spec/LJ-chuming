import { computed as a } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as e } from "vue";
import { withCtx as l } from "vue";
import { normalizeStyle as u } from "vue";
import { ElCol as _ } from "element-plus";
import { ElRow as p } from "element-plus";
import { _ as x, o as g } from "../../../../shared/runtime.js";
import d from "./module/evaluation-category.vue.js";
import f from "./module/score-rating.vue.js";
import v from "./module/qualification-config.vue.js";
import "../../../../modules/supplier-evaluation-config-2fb6916b.js";
const b = { class: "app-container supplier-evaluation-basic" }, y = { __name: "index", setup(H) {
  const { maxHeight: i } = g({ wrapperBox: ".supplier-evaluation-basic", extraBox: null, minHeight: 560 }), t = a(() => Math.max(i.value || 0, 560)), c = a(() => `height:${t.value}px`), n = a(() => Math.max(t.value - 96, 260)), o = a(() => Math.max((t.value - 20) / 2 - 96, 180));
  return (w, M) => {
    const s = _, r = p;
    return h(), m("div", b, [e(r, { gutter: 20, class: "layout-row", style: u(c.value) }, { default: l(() => [e(s, { lg: 10, md: 24, sm: 24, xs: 24, class: "left-col" }, { default: l(() => [e(d, { class: "full-height-card", "table-max-height": n.value }, null, 8, ["table-max-height"])]), _: 1 }), e(s, { lg: 14, md: 24, sm: 24, xs: 24, class: "right-col" }, { default: l(() => [e(f, { class: "half-height-card", "table-max-height": o.value }, null, 8, ["table-max-height"]), e(v, { class: "half-height-card", "table-max-height": o.value }, null, 8, ["table-max-height"])]), _: 1 })]), _: 1 }, 8, ["style"])]);
  };
} }, T = x(y, [["__scopeId", "data-v-e35386f8"]]);
export {
  T as default
};
